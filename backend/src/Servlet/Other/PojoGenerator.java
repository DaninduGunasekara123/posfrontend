package Servlet.Other;

import dto.CustomerDTO;
import dto.ItemDTO;
import dto.OrderDTO;
import dto.OrderDetailDTO;

import javax.json.*;
import java.io.BufferedReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Danindu
 * Date: 2019-04-06
 * Time: 06:44 PM
 */
public class PojoGenerator {

    /**
     * @param bufferedReader- this will assigned the inputstream by client's request
     * @return the customerDTO mapped by input json
     * will throw nullpointer exception if the expected arguments are not presented
     */
    public CustomerDTO getCustomerDTO(BufferedReader bufferedReader){
        JsonReader reader = Json.createReader(bufferedReader);
        JsonObject customer = reader.readObject();
        String cusName = customer.
        getString("cusName");
        String cusAge = customer.getString("cusAge");
        String cusTp = customer.getString("cusTp");
        String cusSalary = customer.getString("cusSalary");
        CustomerDTO customerDTO=new CustomerDTO();
        customerDTO.setcusName(cusName);
        customerDTO.setCusAge(cusAge);
        customerDTO.setCusTp(cusTp);
        customerDTO.setCusSalary(cusSalary);
        return customerDTO;
    }

    public ItemDTO getItemDTO(BufferedReader bufferedReader){
        JsonReader reader = Json.createReader(bufferedReader);
        JsonObject item = reader.readObject();
        String itemName = item.getString("itemName");
        String itemPrice = item.getString("cusPrice");
        String itemQuantity = item.getString("itemQuantity");
//        String itemQuantity = String.parseString(item.get("cusQuantity").toString());
        ItemDTO itemDTO=new ItemDTO();
        itemDTO.setItemName(itemName);
        itemDTO.setItemPrice(itemPrice);
        itemDTO.setItemQuantity(itemQuantity);
        return itemDTO;
    }

    public OrderDTO getOrderDTO(BufferedReader bufferedReader){
        JsonReader reader = Json.createReader(bufferedReader);
        JsonObject orders = reader.readObject();
        List<OrderDetailDTO> orderDetailDTOS=new ArrayList<>();

        String cusName=orders.getString("cusName");
        Date date=Date.valueOf(orders.getString("date"));
        int orderId = orders.getInt("orderId");
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setCustomerName(cusName);
        orderDTO.setDate(date);
        JsonArray jsonArray = orders.getJsonArray("orderDetailDTOS");

        for (JsonValue jsonValue:jsonArray) {
            JsonObject jsonObject = jsonValue.asJsonObject();
            int orderId1 = jsonObject.getInt("orderId");
            String itemName = jsonObject.getString("itemName1");
            double itemPrice = Double.parseDouble(jsonObject.get("itemPrice").toString());
            String itemQuantity = jsonObject.getString("itemQuantity");
            double total = (double) Double.parseDouble(String.valueOf(jsonObject.get("total")));
            OrderDetailDTO orderDetailDTO=new OrderDetailDTO();
            orderDetailDTO.setOrderId(orderId1);
            orderDetailDTO.setItemName(itemName);
            orderDetailDTO.setItemPrice(itemPrice);
            orderDetailDTO.setItemQuantity(itemQuantity);
            orderDetailDTO.setTotal(total);
            orderDetailDTOS.add(orderDetailDTO);
        }
        orderDTO.setOrderDetailDTOS(orderDetailDTOS);
        return orderDTO;
    }

}
