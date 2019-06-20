package repository.repo.repoImpl;

import entity.Item;
import repository.repo.ItemRepo;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemRepoIMPL implements ItemRepo {
    @Override
    public boolean add(Item item) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        boolean b = crudUtil.executeUpdate("INSERT INTO item values(?,?,?)", item.getItemName(), item.getItemPrice(), item.getItemQuantity());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean update(Item item) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        boolean b = crudUtil.executeUpdate("UPDATE item SET name=?,price=?,qty=? WHERE code=?", item.getItemName(), item.getItemPrice(), item.getItemQuantity());
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public boolean delete(Integer itemName, Object cusName) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        boolean b = crudUtil.executeUpdate("DELETE FROM item WHERE itemName=?", itemName);
        crudUtil.closeConnection();
        return b;
    }

    @Override
    public Item search(Integer itemName) throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM item WHERE itemName=?", itemName);
        if(resultSet.next()){
            Item item=new Item();
            item.setItemName(itemName);
            item.setItemPrice(resultSet.getDouble("itemPrice"));
            item.setItemQuantity(resultSet.getDouble("itemQuantity"));
            crudUtil.closeConnection();
            return item;
        }
        crudUtil.closeConnection();
        return null;
    }

    @Override
    public List<Item> getAll() throws SQLException {
        CrudUtil crudUtil=new CrudUtil();
        List<Item>items=new ArrayList<>();
        ResultSet resultSet = crudUtil.executeQuery("SELECT * FROM item");
        while (resultSet.next()){
            Item item=new Item();
            item.setItemName(resultSet.getInt("itemName"));
            item.setItemPrice(resultSet.getDouble("itemPrice"));
            item.setItemQuantity(resultSet.getDouble("itemQuantity"));
            items.add(item);
        }
        crudUtil.closeConnection();
        return items;
    }
}
