/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultas.servlets;

import consultas.beans.Administrador;
import consultas.beans.Login;
import consultas.beans.Medico;
import consultas.beans.Paciente;
import consultas.dao.AdministradorDAO;
import consultas.dao.MedicoDAO;
import consultas.dao.PacienteDAO;
import consultas.forms.LoginFormBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

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

        request.setCharacterEncoding("UTF-8");
        String tipo;
        if (request.getSession().getAttribute("tipo") != null){
            tipo = request.getSession().getAttribute("tipo").toString() ;
        }else{
            tipo = null;
        }
        
        try { 
            
            if (tipo == null && request.getParameter("pagina") == null) {
                request.setAttribute("acao", request.getAttribute("acao"));
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else if (request.getSession().getAttribute("tipo") == null) {
                
                LoginFormBean npfb = new LoginFormBean();
                try {
                    BeanUtils.populate(npfb, request.getParameterMap());

                    List<String> mensagens = npfb.validar();
                    if (mensagens == null) {
                        if (npfb.getTipo().equals("medico")) {
                            MedicoDAO mdao = new MedicoDAO(dataSource);
                            Medico medico = new Medico();
                            medico = mdao.verificaLogin(npfb.getLogin(), npfb.getSenha());
                            if (medico != null) {
                                request.getSession().setAttribute("login", medico);
                                request.getSession().setAttribute("tipo", "medico");
                                String acao = request.getParameter("acao");
                                if (acao.equals("listConsulta")) {
                                    request.getRequestDispatcher("listarConsultas.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("erro", "Acesso restrito!");
                                    request.getRequestDispatcher("index.jsp").forward(request, response);
                                }
                            } else {
                                request.setAttribute("acao", request.getAttribute("acao"));
                                request.setAttribute("erro", "Login ou senha inválidos!");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                            }
                        } else if (npfb.getTipo().equals("paciente")) {
                            PacienteDAO pdao = new PacienteDAO(dataSource);
                            Paciente paciente = new Paciente();
                            paciente = pdao.verificaLogin(npfb.getLogin(), npfb.getSenha());
                            if (paciente != null) {
                                request.getSession().setAttribute("login", paciente);
                                request.getSession().setAttribute("tipo", "paciente");
                                String acao = request.getParameter("acao");
                                if (acao.equals("agendar")) {
                                    request.getRequestDispatcher("agendarConsultas.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("erro", "Acesso restrito!");
                                    request.getRequestDispatcher("index.jsp").forward(request, response);
                                }
                            } else {
                                request.setAttribute("acao", request.getAttribute("acao"));
                                request.setAttribute("erro", "Login ou senha inválidos!");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                            }
                        } else {
                            AdministradorDAO adao = new AdministradorDAO(dataSource);
                            Administrador admin = new Administrador();
                            admin = adao.verificaLogin(npfb.getLogin(), npfb.getSenha());
                            if (admin != null) {
                                request.getSession().setAttribute("login", admin);
                                request.getSession().setAttribute("tipo", "admin");
                                String acao = request.getParameter("acao");
                                if (acao.equals("cadMed")) {
                                    request.getRequestDispatcher("cadastroMedico.jsp").forward(request, response);
                                } else if (acao.equals("cadPac")) {
                                    request.getRequestDispatcher("cadastroPaciente.jsp").forward(request, response);
                                } else {
                                    request.setAttribute("erro", "Acesso restrito!");
                                    request.getRequestDispatcher("index.jsp").forward(request, response);
                                }
                            } else {
                                request.setAttribute("acao", request.getAttribute("acao"));
                                request.setAttribute("erro", "Login ou senha inválidos!");
                                request.getRequestDispatcher("login.jsp").forward(request, response);
                            }
                        }
                    } else {
                        request.setAttribute("mensagens", mensagens);
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    request.setAttribute("mensagem", e.getCause());
                    request.getRequestDispatcher("erro.jsp").forward(request, response);
                }
            } else {
                String acao = request.getParameter("acao");
                if (tipo.equals("admin")){
                    if (acao.equals("cadMed")) {
                        request.getRequestDispatcher("cadastroMedico.jsp").forward(request, response);
                    } else if (acao.equals("cadPac")) {
                        request.getRequestDispatcher("cadastroPaciente.jsp").forward(request, response);
                    } else {
                        request.setAttribute("erro", "Acesso restrito!");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } else if (tipo.equals("medico")){
                    if (acao.equals("listConsulta")) {
                        request.getRequestDispatcher("listarConsultas.jsp").forward(request, response);
                    } else {
                        request.setAttribute("erro", "Acesso restrito!");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                } else if (tipo.equals("paciente")){
                    if (acao.equals("agendar")) {
                        request.getRequestDispatcher("agendarConsultas.jsp").forward(request, response);
                    } else {
                        request.setAttribute("erro", "Acesso restrito!");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                }
            }
        } catch (Exception e) {
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
