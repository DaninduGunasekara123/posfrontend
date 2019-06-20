package ContextPool;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = "/servlet.Item")
public class ItemContext extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection connection = ds.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Item");

            JsonArrayBuilder ab = Json.createArrayBuilder();
            while (rst.next()) {
                JsonObjectBuilder ob = Json.createObjectBuilder();
                ob.add("itemName", rst.getString("itemName"));
                ob.add("itemPrice", rst.getString("itemPrice"));
                ob.add("itemQty", rst.getString("itemQty"));
                ab.add(ob.build());
            }
            JsonArray customer = ab.build();
            resp.setContentType("application/json");
            resp.getWriter().println(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
