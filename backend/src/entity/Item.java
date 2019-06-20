package entity;

public class Item {
    private Integer itemName;
    private Double itemPrice;
    private Double itemQuantity;

    public Item() {
    }

    public void setItemName(Integer itemName){
        this.itemName = itemName;
    }

    public Integer getItemName(){
        return itemName;
    }

    public Double setItemPrice(Double itemPrice){
        return itemPrice;
    }

    public Double getItemPrice(){
        return itemPrice;
    }

    public void setItemQuantity(Double itemQuantity){
        this.itemQuantity = itemQuantity;
    }

    public Double getItemQuantity(){
        return itemQuantity;
    }
}
