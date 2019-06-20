package repository.repo.repoImpl;

import entity.Customer;
import repository.repo.CustomerRepo;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepoIMPL implements CustomerRepo {
    @Override
    public boolean add(Customer customer) throws SQLException {
        CrudUtil crudUtil = new CrudUtil();
        boolean b = crudUtil.executeUpdate("INSERT INTO customer VALUES(?,?,?,?", customer.getCusName(), customer.getCusAge(), customer.getCusTp(), customer.getCusSalary());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean update(Customer customer) throws SQLException {
        CrudUtil crudUtil = new CrudUtil();
        boolean b = crudUtil.executeUpdate("UPDATE customer SET cusName=?, cusAge=?, cusTp=?, cusSalary=?", customer.getCusName(), customer.getCusAge(), customer.getCusTp(), customer.getCusAge(), customer.getCusSalary());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean delete(Integer cusName, Object cusName1) throws SQLException {
        CrudUtil crudUtil = new CrudUtil();
        boolean b = crudUtil.executeUpdate("DELETE FROM customer WHERE cusName=?", cusName);
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public Customer search(Integer cusName) throws SQLException {
        CrudUtil crudUtil = new CrudUtil();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM customer WHERE cusName=?", cusName);
        if(resultSet.next()){
            Customer customer=new Customer();
            customer.setcusName(cusName);
            customer.setCusAge(resultSet.getString("cusAge"));
            customer.setCusTp(resultSet.getString("cusTp"));
            customer.setCusSalary(resultSet.getDouble("cusSalary"));
            crudUtil.closeConnection();
            return customer;
        }
        crudUtil.closeConnection();
        return null;
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        CrudUtil crudUtil = new CrudUtil();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM customer");
        ArrayList<Customer> customers=new ArrayList<>();
        while (resultSet.next()){
            Customer customer=new Customer();
            customer.setcusName(resultSet.getInt("cusName"));
            customer.setCusAge(resultSet.getString("cusAge"));
            customer.setCusTp(resultSet.getString("cusTp"));
            customer.setCusSalary(resultSet.getDouble("cusSalary"));
            customers.add(customer);
        }
        crudUtil.closeConnection();
        return customers;
    }
}
