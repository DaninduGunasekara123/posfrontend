package dto;

import java.util.Date;
import java.util.List;

public class OrderDTO {
    private String customerName;
    private Date date;
    private int orderId;
    private List<OrderDetailDTO> orderDetailsDTOS;

    public OrderDTO() {
    }

    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }

    public String getCustomerName(){
        return customerName;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
        return date;
    }

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public int getOrderId(){
        return orderId;
    }

    public void setOrderDetailsDTOS(List<OrderDetailDTO> orderDetailsDTOS){
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    public List<OrderDetailDTO> getOrderDetailsDTOS(){
        return orderDetailsDTOS;
    }

    public void setOrderDetailDTOS(List<OrderDetailDTO> orderDetailDTOS) {
    }
}
