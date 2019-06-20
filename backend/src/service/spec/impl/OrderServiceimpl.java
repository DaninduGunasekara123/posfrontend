package service.spec.impl;


import db.DBConnection;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Item;
import entity.OrderDetail;
import entity.OrderDetail_PK;
import org.modelmapper.ModelMapper;
import repository.RepoFactory;
import repository.repo.ItemRepo;
import repository.repo.OrderDetailRepo;
import repository.repo.OrderRepo;
import service.spec.OrderService;
import servlet.Orders;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

public class OrderServiceimpl  implements OrderService {
    private OrderRepo orderRepo;
    private OrderDetailRepo orderDetailRepo;
    private ItemRepo itemRepo;
    private ModelMapper modelMapper;

    public OrderServiceimpl() {
        this.orderRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ORDERS);
        this.orderDetailRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ORDER_DETAIL);
        this.itemRepo=new RepoFactory().getRepo(RepoFactory.RepoTypes.ITEM);
        this.modelMapper=new ModelMapper();
    }

    @Override
    public boolean add(OrderDTO orderDTO)  {
        try {
            Connection connection = DBConnection.getConnection();
            Objects.requireNonNull(connection).setAutoCommit(false);
            try {

                Orders orders = modelMapper.map(orderDTO, Orders.class);
                boolean add = orderRepo.add(orders);
                if (!add) {
                    connection.rollback();
                    return false;
                }
                int lastOrderId = orderRepo.getLastOrderId();
                for (OrderDetailDTO orderDetailDTO : orderDTO.getOrderDetailsDTOS()) {
                    OrderDetail orderDetails = new OrderDetail();
                    orderDetails.setOrderDetail_pk(
                            new OrderDetail_PK(
                                    orderDetailDTO.getOrderId(),
                                    lastOrderId
                            )
                    );
                    orderDetails.
                setItemPrice(orderDetailDTO.
                getItemPrice());
                    orderDetails.
                setItemQuantity(orderDetailDTO.getItemQuantity());
                    add = orderDetailRepo.add(orderDetails);
                    if (!add) {
                        connection.rollback();
                        return false;
                    }
                    Item item = new Item();
//                    Item item = (Item) itemRepo.search(orderDetailDTO.getItemName());
//                    item.setItemQuantity(item.getItemQuantity() - orderDetailDTO.getItemQuantity());
                    add = itemRepo.update(item);
                    if (!add) {
                        connection.rollback();
                        return false;
                    }
                }

                connection.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                connection.rollback();
                return false;
            } finally {
                connection.setAutoCommit(true);
                connection.close();
            }
        }catch (Exception s){
            s.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(OrderDTO orderDTO) {
        return false;
    }

    @Override
    public boolean delete(Integer integer) {
        return false;
    }

    @Override
    public OrderDTO search(Integer integer) {
        return null;
    }

    @Override
    public List<OrderDTO> getAll() {
        return null;
    }
}
