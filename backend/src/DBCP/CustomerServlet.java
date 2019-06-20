package DBCP;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    {
        try {
            BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("POS1");
            Connection connection = dataSource.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

            JsonArrayBuilder ab = Json.createArrayBuilder();
            while (rst.next()) {
                JsonObjectBuilder ob = Json.createObjectBuilder();
                ob.add("cusName",rst.getString("cusName"));
                ob.add("cusAge",rst.getString("cusAge"));
                ob.add("cusTp",rst.getString("cusTp"));
                ob.add("cusSalary",rst.getString("cusSalary"));
                ab.add(ob.build());
            }
            JsonArray customer = ab.build();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
