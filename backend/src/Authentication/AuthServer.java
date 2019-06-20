package Authentication;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/authentication")
public class AuthServer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()){

            String username = req.getParameter("userName");
            String passwors = req.getParameter("password");

            if (username == null || passwors == null){
                resp.sendError(401);
                return;
            }

            if (username.equals("danindugunasekara@gmail.com") && passwors.equals("1234")){
                resp.setStatus(200);
                req.getSession();
            }else {
                resp.sendError(401);
            }
        }
    }
}
