/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.servlets;

import consultas.beans.Medico;
import consultas.dao.MedicoDAO;
import consultas.forms.NovoMedicoFormBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "cadastrarMedServlet", urlPatterns = {"/cadastrarMedServlet"})
public class cadastrarMedServlet extends HttpServlet {

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
        NovoMedicoFormBean npfb = new NovoMedicoFormBean();
        try {
            BeanUtils.populate(npfb, request.getParameterMap());
            request.getSession().setAttribute("novoMedico", npfb);
            MedicoDAO pdao = new MedicoDAO(dataSource);

            List<String> mensagens = npfb.validar();
            if (mensagens == null) {
                try {
                    Medico u = new Medico();
                    u.setCRM(npfb.getCRM());
                    u.setNome(npfb.getNome());
                    u.setSenha(npfb.getSenha());
                    u.setEspecialidade(npfb.getEspecialidade());
                    u = pdao.gravarMedico(u);
                    request.setAttribute("mensagem", "Medico Cadastrado!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                } catch (Exception e) {
                    e.printStackTrace();
                    request.setAttribute("mensagem", e.getLocalizedMessage());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensagens", mensagens);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("mensagem", e.getMessage());
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
