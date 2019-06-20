package DBCP;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@WebListener(value = "/servlet.Item")
public class ItemServlet extends HttpServlet {
    {
        try {
            BasicDataSource dataSource = (BasicDataSource) getServletContext().getAttribute("POS1");
            Connection connection = dataSource.getConnection();
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
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
