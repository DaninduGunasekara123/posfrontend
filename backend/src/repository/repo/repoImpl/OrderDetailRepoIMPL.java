package repository.repo.repoImpl;

import entity.OrderDetail;
import entity.OrderDetail_PK;
import repository.repo.OrderDetailRepo;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailRepoIMPL implements OrderDetailRepo {
    @Override
    public boolean add(OrderDetail orderDetail) throws SQLException {
        CrudUtil crudUtil= new CrudUtil();
        boolean b = crudUtil.executeUpdate("INSERT INTO orderdetails VALUES(?,?,?)",
                orderDetail.getOrderDetail_pk(), orderDetail.getItemPrice(), orderDetail.getItemQuantity());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean update(OrderDetail orderDetail) throws SQLException {
        CrudUtil crudUtil= new CrudUtil();
        boolean b = crudUtil.executeUpdate("UPDATE orderdetails SET itemPrice=?, itemQuantity=? WHERE orderId=? AND customerName=?",
                orderDetail.getItemPrice(),orderDetail.getItemQuantity(),orderDetail.getOrderDetail_pk().getOrderId(),orderDetail.getOrderDetail_pk().getCustomerName());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean delete(Integer orderDetail, Object cusName) throws SQLException {
        return false;
    }

    @Override
    public OrderDetail search(Integer k) throws SQLException {
        return null;
    }

    @Override
    public List<OrderDetail> getAll() throws SQLException {
        CrudUtil crudUtil= new CrudUtil();
        List<OrderDetail>ordersList=new ArrayList<>();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM orderdetails");
        while (resultSet.next()){
            OrderDetail orderDetails=new OrderDetail();
            orderDetails.setOrderDetail_pk(
                    new OrderDetail_PK(
                            resultSet.getInt("customerName"),
                            resultSet.getInt("orderId")
                    )
            );
            orderDetails.setItemQuantity(resultSet.getString("itemQuantity"));
            orderDetails.setItemPrice(resultSet.getDouble("itemPrice"));
            ordersList.add( orderDetails);
        }
        crudUtil.closeConnection();
        return ordersList;
    }
}
