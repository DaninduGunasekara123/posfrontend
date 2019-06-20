package repository.repo;

import repository.SuperRepo;
import servlet.Orders;

import java.sql.SQLException;

public interface OrderRepo extends SuperRepo<Orders,Integer> {
    int getLastOrderId()throws SQLException;
}
