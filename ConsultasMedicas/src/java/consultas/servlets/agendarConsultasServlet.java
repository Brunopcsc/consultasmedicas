/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.servlets;

import consultas.beans.Consulta;
import consultas.beans.Medico;
import consultas.beans.Paciente;
import consultas.dao.ConsultaDAO;
import consultas.dao.MedicoDAO;
import consultas.forms.AgendarConsultaFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;
import sun.rmi.transport.proxy.HttpReceiveSocket;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "agendarConsultasServlet", urlPatterns = {"/agendarConsultasServlet"})
public class agendarConsultasServlet extends HttpServlet {

    @Resource(name = "jdbc/ConsultaDBLocal")
    DataSource dataSource;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            HttpSession sessao = request.getSession();
            Paciente pac = (Paciente) sessao.getAttribute("login");

            AgendarConsultaFormBean acfb = new AgendarConsultaFormBean();
            BeanUtils.populate(acfb, request.getParameterMap());
            List<String> mensagens = acfb.validar();
            if (mensagens == null) {
                try {
                    MedicoDAO mdao = new MedicoDAO(dataSource);
                    if (!mdao.verificaCRM(acfb.getCRM())) {
                        mensagens = new ArrayList<String>();
                        mensagens.add("Médico de CRM " + acfb.getCRM() + " não existente! ");
                        request.setAttribute("mensagens", mensagens);
                        request.getRequestDispatcher("agendarConsultas.jsp").forward(request, response);
                    } else {
                        SimpleDateFormat formato =  new SimpleDateFormat("dd/MM/yyyy");
                        ConsultaDAO cdao = new ConsultaDAO(dataSource);
                        Date data = formato.parse(acfb.getData());
                        if(cdao.verificaConsultaCRM(acfb.getCRM(), data)){                            
                            mensagens = new ArrayList<String>();
                            mensagens.add("Já há consulta marcada para o médico no dia especificado! ");
                            request.setAttribute("mensagens", mensagens);
                            request.getRequestDispatcher("agendarConsultas.jsp").forward(request, response);
                        }
                        else if(cdao.verificaConsultaCPF(pac.getCPF(), data)){
                            mensagens = new ArrayList<String>();
                            mensagens.add("Já há consulta marcada para o paciente no dia especificado! ");
                            request.setAttribute("mensagens", mensagens);
                            request.getRequestDispatcher("agendarConsultas.jsp").forward(request, response);
                        }
                        else{
                            Consulta consulta = new Consulta();
                            consulta.setCPF(pac.getCPF());
                            consulta.setCRM(acfb.getCRM());
                            consulta.setDataConsulta(new java.sql.Date(formato.parse(acfb.getData()).getTime()));
                            cdao.gravarConsulta(consulta);
                            request.setAttribute("mensagem", "Consulta agendada!");
                            request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                    }

                } catch (Exception e) {
                    request.setAttribute("mensagem", e.getStackTrace()[0]);
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensagens", mensagens);
                request.getRequestDispatcher("agendarConsultas.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("mensagem", e.getStackTrace()[0].getLineNumber());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
