package Servlet.Other;

import dto.CustomerDTO;
import dto.ItemDTO;

import javax.json.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Danindu
 * Date: 2019-04-06
 * Time: 06:57 PM
 */
public class JsonResponseGenerator {

    public JsonObject getByCustomerDTO(CustomerDTO customerDTO){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("cusName",customerDTO.getCusName());
        objectBuilder.add("cusAge",customerDTO.getCusAge());
        objectBuilder.add("cusTp",customerDTO.getCusTp());
        objectBuilder.add("cusSalary",customerDTO.getCusSalary());
        return objectBuilder.build();
    }

    public JsonArray getByCustomerDTOList(List<CustomerDTO> customerDTOS){
        JsonArrayBuilder jsonArrayBuilder= Json.createArrayBuilder();
        customerDTOS.forEach(customerDTO -> {
            jsonArrayBuilder.add(getByCustomerDTO(customerDTO));
        });
        return jsonArrayBuilder.build();
    }

    public JsonObject getByItemDTO(ItemDTO itemDTO){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("itemName",itemDTO.getItemName());
        objectBuilder.add("itemPrice",itemDTO.getItemPrice());
        objectBuilder.add("itemQuantity",itemDTO.getItemQuantity());
        return objectBuilder.build();
    }

    public JsonArray getByItemDTOList(List<ItemDTO> itemDTOS){
        JsonArrayBuilder jsonArrayBuilder= Json.createArrayBuilder();
        itemDTOS.forEach(ItemDTO -> {
            jsonArrayBuilder.add(getByItemDTO(ItemDTO));
        });
        return jsonArrayBuilder.build();
    }

    public JsonObject getForCommonResponse(int name, String message){
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("name",name);
        objectBuilder.add("message",message);
        return objectBuilder.build();
    }
}
