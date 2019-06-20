package Servlet;

import javax.json.*;
import javax.json.stream.JsonParsingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/items")
public class item extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {

            if (req.getParameter("itemName") != null) {

                String itemName = req.getParameter("itemName");

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");
                    PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE itemName=?");
                    pstm.setObject(1, itemName);
                    ResultSet rst = pstm.executeQuery();

                    if (rst.next()) {
                        JsonObjectBuilder ob = Json.createObjectBuilder();
                        ob.add("itemName", rst.getString(1));
                        ob.add("itemPrice", rst.getString(2));
                        ob.add("itemQty", rst.getString(3));
                        resp.setContentType("application/json");
                        out.println(ob.build());
                    } else {
                        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            else{
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");
                    Statement stm = connection.createStatement();
                    ResultSet rst = stm.executeQuery("SELECT * FROM Item");

                    resp.setContentType("application/json");

                    JsonArrayBuilder ab = Json.createArrayBuilder();

                    while (rst.next()){
                        JsonObjectBuilder ob = Json.createObjectBuilder();
                        ob.add("itemName", rst.getString("itemName"));
                        ob.add("itemPrice", rst.getString("itemPrice"));
                        ob.add("itemQty", rst.getString("itemQty"));
                        ab.add(ob.build());
                    }
                    out.println(ab.build());
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JsonReader reader = Json.createReader(req.getReader());
            JsonObject item = reader.readObject();

            String itemName = item.getString("itemName");
            String itemPrice = item.getString("itemPrice");
            String itemQty = item.getString("itemQty");

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?)");
            pstm.setObject(1, itemName);
            pstm.setObject(2,itemPrice);
            pstm.setObject(3,itemQty);
            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0){
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

        }catch (JsonParsingException | NullPointerException  ex){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }catch (Exception ex){
            ex.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String itemName = req.getParameter("itemName");

        if (itemName != null){

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");
                PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE itemName=?");
                pstm.setObject(1, itemName);
                int affectedRows = pstm.executeUpdate();
                if (affectedRows >  0){
                    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                }else{
                    resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                }
            }catch (Exception ex){
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                ex.printStackTrace();
            }

        }else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("itemName") != null){

            try {
                JsonReader reader = Json.createReader(req.getReader());
                JsonObject item = reader.readObject();

                String itemName = item.getString("itemName");
                String itemPrice = item.getString("itemPrice");
                String itemQty = item.getString("itemQty");

                if (!itemName.equals(req.getParameter("itemName"))){
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");
                PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET itemPrice=?, itemQty=? WHERE itemName=?");
                pstm.setObject(3,itemName);
                pstm.setObject(1,itemPrice);
                pstm.setObject(2,itemQty);
                int affectedRows = pstm.executeUpdate();

                if (affectedRows > 0){
                    resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
                }else{
                    resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                }

            }catch (JsonParsingException | NullPointerException  ex){
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }catch (Exception ex){
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }


        }else{
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("SELECT COUNT(*) FROM Item");
            if (rst.next()){
                resp.addHeader("X-Count",rst.getString(1));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
