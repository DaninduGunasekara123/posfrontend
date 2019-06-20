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

@WebServlet(urlPatterns = "/customers")
public class Customer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            if (req.getParameter("cusName") != null){
                String cusName = req.getParameter("cusName");

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "1234");
                    PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE Name=?");
                    pstm.setObject(1, cusName);
                    ResultSet rst = pstm.executeQuery();

                    if (rst.next()){
                        JsonObjectBuilder ob = Json.createObjectBuilder();
                        ob.add("cusName", rst.getString(1));
                        ob.add("cusAge", rst.getString(2));
                        ob.add("cusTp", rst.getString(3));
                        ob.add("cusSalary", rst.getString(4));
                        resp.setContentType("application/json");
                        out.println(ob.build());
                    }else {
                        resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }else {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "");
                Statement stm = connection.createStatement();
                ResultSet rst = stm.executeQuery("SELECT * FROM Customer");

                resp.setContentType("application/json");

                JsonArrayBuilder ab = Json.createArrayBuilder();

                while (rst.next()) {
                    JsonObjectBuilder ob = Json.createObjectBuilder();
                    ob.add("cusName",rst.getString("cusName"));
                    ob.add("cusAge",rst.getString("cusAge"));
                    ob.add("cusTp",rst.getString("cusTp"));
                    ob.add("cusSalary",rst.getString("cusSalary"));
                    ab.add(ob.build());
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            JsonReader reader = Json.createReader(req.getReader());
            JsonObject customer = reader.readObject();

            String cusName = customer.getString("cusName");
            String cusAge = customer.getString("cusAge");
            String cusTp = customer.getString("cusTp");
            String cusSalary = customer.getString("cusSalary");

            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "");
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
            pstm.setObject(1,cusName);
            pstm.setObject(2,cusAge);
            pstm.setObject(3,cusTp);
            pstm.setObject(4,cusSalary);
            int affectedRows = pstm.executeUpdate();

            if (affectedRows > 0){
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else{
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }

        }catch (JsonParsingException | NullPointerException  ex){
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
        }catch (Exception ex){
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cusName = req.getParameter("cusName");

        if (cusName != null){

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "");
                PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE name=?");
                pstm.setObject(1, cusName);
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
        if (req.getParameter("cusName") != null){

            try {
                JsonReader reader = Json.createReader(req.getReader());
                JsonObject customer = reader.readObject();

                String cusName = customer.getString("cusName");
                String cusAge = customer.getString("cusAge");
                String cusTp = customer.getString("cusTp");
                String cusSalary = customer.getString("cusSalary");

                if (!cusName.equals(req.getParameter("cusName"))){
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thogakade", "root", "");
                PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET cusAge=?, cusTp=?, cusSalary=? WHERE cusName=?");
                pstm.setObject(4,cusName);
                pstm.setObject(1,cusAge);
                pstm.setObject(2,cusTp);
                pstm.setObject(3,cusSalary);
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
}
