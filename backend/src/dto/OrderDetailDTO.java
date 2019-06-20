package dto;

public class OrderDetailDTO {
    private int orderId;
    private String itemName;
    private Double itemPrice;
    private String itemQuantity;
    private Double total;

    public void setOrderId(int orderId){
        this.orderId = orderId;
    }

    public int getOrderId(){
        return orderId;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemPrice(Double itemPrice){
        this.itemPrice = itemPrice;
    }

    public Double getItemPrice(){
        return itemPrice;
    }

    public void setItemQuantity(String itemQuantity){
        this.itemQuantity = itemQuantity;
    }

    public String getItemQuantity(){
        return itemQuantity;
    }

    public void setTotal(Double total){
        this.total = total;
    }

    public Double getTotal(){
        return total;
    }
}
