package dto;

public class ItemDTO {
    private String itemName;
    private Double itemPrice;
    private String itemQuantity;

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public String getItemName(){
        return itemName;
    }

    public String setItemPrice(String itemPrice){
        return itemPrice;
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
}
