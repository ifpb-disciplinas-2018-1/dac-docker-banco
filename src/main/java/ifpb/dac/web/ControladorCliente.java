package ifpb.dac.web;

import ifpb.dac.domain.Cliente;
import ifpb.dac.infra.ClientesEmJDBC;
import ifpb.dac.infra.ClientesEmMemoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorCliente", urlPatterns = {"/clientes"})
public class ControladorCliente extends HttpServlet {

//    private ClientesEmMemoria service = new ClientesEmMemoria();
    private ClientesEmJDBC service = new ClientesEmJDBC();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String cpf = req.getParameter("cpf");
        Cliente cliente = Cliente.of(nome, cpf);
        
       this.service.salvar(cliente); 
//       req.getRequestDispatcher("/clientes").forward(req, resp);
       resp.sendRedirect(req.getRequestURI());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ControladorCliente</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listagem de Clientes</h1>");
            
            
            imprimir(out);
            out.println("</body>");
            out.println("</html>");
        }
    }

    private void imprimir(PrintWriter out) {
        this.service.todos().stream().forEach(c->out.println("<p>"+c.getNome()+"</p>"));
    }

}
