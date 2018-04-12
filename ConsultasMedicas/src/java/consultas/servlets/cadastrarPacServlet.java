/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.servlets;

import consultas.beans.Paciente;
import consultas.dao.PacienteDAO;
import consultas.forms.NovoPacienteFormBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Bruno
 */
@WebServlet(name = "cadastrarPacServlet", urlPatterns = {"/cadastrarPacServlet"})
public class cadastrarPacServlet extends HttpServlet {

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
        NovoPacienteFormBean npfb = new NovoPacienteFormBean();
        try {
            BeanUtils.populate(npfb, request.getParameterMap());
            request.getSession().setAttribute("novoPaciente", npfb);
            PacienteDAO pdao = new PacienteDAO(dataSource);

            List<String> mensagens = npfb.validar();
            if (mensagens == null) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataNascimento = null;
                try {
                    dataNascimento = sdf.parse(npfb.getDataNascimento());
                } catch (ParseException e) {
                    request.setAttribute("mensagem",  e.getLocalizedMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
                try {
                    Paciente u = new Paciente();
                    u.setCPF(npfb.getCPF());
                    u.setNome(npfb.getNome());
                    u.setSenha(npfb.getSenha());
                    u.setTelefone(npfb.getTelefone());
                    u.setSexo("M");
                    u.setDataNascimento(dataNascimento);
                    u = pdao.gravarPaciente(u);
                    request.setAttribute("mensagem", "Paciente Cadastrado!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("mensagem",  e.getLocalizedMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensagens", mensagens);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getLocalizedMessage());
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
