import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sgab.model.dto.Biblioteca;
import sgab.model.service.GestaoBiblioteca;


@WebServlet(urlPatterns = {"/cadastroServlet"})
public class cadastroServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            
            String adicionarUnidadeOrgInput = request.getParameter("adicionarUnidadeOrgInput");
            String adicionarNomeInput = request.getParameter("adicionarNomeInput");
            Long adicionarIDInput = Long.parseLong(request.getParameter("adicionarIDInput"));

            GestaoBiblioteca cadastro = new GestaoBiblioteca();

            Biblioteca novaBiblioteca = new Biblioteca();
            novaBiblioteca.setNome(adicionarNomeInput);
            novaBiblioteca.setId(adicionarIDInput);
            novaBiblioteca.setUnidadeOrg(adicionarUnidadeOrgInput);

            cadastro.cadastrarBiblioteca(novaBiblioteca);

            request.setAttribute("adicionarUnidadeOrgInput", adicionarUnidadeOrgInput);
            request.setAttribute("adicionarNomeInput", adicionarNomeInput);
            request.setAttribute("adicionarIDInput", adicionarIDInput);

            response.sendRedirect("../../../web/core/biblioteca/resposta.jsp");
            
            //out.println("<h1>Teste Pega variavel " + "</h1>");
            
            //out.println( "Variavel = " + adicionarAtendenteInput2);
            
            /*request.getRequestDispatcher(".jsp").forward(request, response);*/
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
