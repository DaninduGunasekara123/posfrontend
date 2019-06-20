package repository;

import java.sql.SQLException;
import java.util.List;

public interface SuperRepo<T,K> {
    boolean add(T t) throws SQLException;
    boolean update(T t) throws SQLException;
    boolean delete(Integer t, Object cusName) throws SQLException;
    T search(Integer k) throws SQLException;
    List<T> getAll() throws SQLException;
}
