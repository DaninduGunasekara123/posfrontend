package Authentication;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(urlPatterns = "/items")
public class ItemServlet extends HttpServlet {
    @Resource(name = "java:comp/env/jdbc/pool")
    private DataSource ds;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {

            resp.setContentType("application/json");

            try {
                Connection connection = ds.getConnection();

                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("SELECT * FROM Item");

                JsonArrayBuilder items = Json.createArrayBuilder();

                while (rst.next()){
                    String itemName = rst.getString("itemName");
                    int itemQuantity = rst.getInt("itemQuantity");
                    double itemPrice = rst.getDouble("itemPrice");

                    JsonObject item = Json.createObjectBuilder()
                            .add("itemName", itemName)
                            .add("itemQuantity", itemQuantity)
                            .add("itemPrice", itemPrice)
                            .build();
                    items.add(item);
                }

                out.println(items.build().toString());

                connection.close();
            } catch (Exception ex) {
                resp.sendError(500, ex.getMessage());
                ex.printStackTrace();
            }

        }

    }
}
