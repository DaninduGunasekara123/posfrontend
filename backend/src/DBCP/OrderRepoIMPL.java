package DBCP;

import entity.Order;
import repository.repo.OrderRepo;
import servlet.Orders;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderRepoIMPL implements OrderRepo {
    @Override
    public int getLastOrderId() throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        ResultSet resultSet = crudUtil.executeQuery("SELECT orderId as orderId FROM order ORDER BY orderId DESC LIMIT 1");
        if(resultSet.next()){
            int orderId = resultSet.getInt("orderId");
            crudUtil.closeConnection();
            return orderId;
        }
        crudUtil.closeConnection();
        return 0;
    }

    @Override
    public boolean add(Orders order) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        boolean b = crudUtil.executeUpdate("INSERT INTO orders VALUES(?,?,?)", order.getCustomerName(), order.getDate(), order.getOrderId());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean update(Orders order) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        boolean b = crudUtil.executeUpdate("UPDATE orders SET date=?, total=?, customerName=? WHERE orderId=?", order.getCustomerName(), order.getDate(), order.getOrderId());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean delete(Integer orders, Object cusName) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        boolean b = crudUtil.executeUpdate("DELETE FROM orders WHERE customerName=?", cusName);
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public Orders search(Integer k) throws SQLException {
        return null;
    }

    @Override
    public List<Orders> getAll() throws SQLException {
        return null;
    }

    public Order search(Order order, String cusName) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM orders WHERE customerName=?", cusName);
        if(resultSet.next()){
            Order orders =new Order();
            orders.setCustomerName(cusName);
            orders.setDate(resultSet.getDate("date"));
            orders.setOrderId(resultSet.getByte("total"));
            return order;
        }
        crudUtil.closeConnection();
        return null;
    }

    public List<Order> getAll(Order order) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        List<Order> ordersList=new ArrayList<>();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM order");
        while (resultSet.next()){
            Order orders=new Order();
            orders.setOrderId(resultSet.getInt("orderId"));
            orders.setDate(resultSet.getDate("date"));
            orders.setCustomerName(resultSet.getString("customerName"));
            ordersList.add( orders);
        }
        crudUtil.closeConnection();
        return ordersList;
    }
}
