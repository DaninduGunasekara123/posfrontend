package Servlet;

import Servlet.Other.JsonResponseGenerator;
import Servlet.Other.PojoGenerator;
import dto.OrderDTO;
import service.other.ServiceFactory;
import service.spec.OrderService;
import util.Constaants;

import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet
public class Orders extends HttpServlet {
    private OrderService orderService;
    private PojoGenerator pojoGenerator;
    private JsonResponseGenerator jsonResponseGenerator;

    public Orders() {
        this.orderService=new ServiceFactory().getService(ServiceFactory.ServiceTypes.ORDERS);
        this.pojoGenerator=new PojoGenerator();
        this.jsonResponseGenerator=new JsonResponseGenerator();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            boolean operation = req.getHeader("operation").isEmpty();
        } catch (NullPointerException n){
            resp.sendError(400,"No operation header is presented ! ");
            return;
        }
        switch (req.getHeader("operation")){
            case "add":
                try {
                    OrderDTO orderDTO;
                    try {
                        orderDTO = new PojoGenerator().getOrderDTO(req.getReader());
                    } catch (NullPointerException n) {
                        n.printStackTrace();
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid response data " + n.getMessage());
                        return;
                    }
                    boolean add = orderService.add(orderDTO);
                    if(add){
                        resp.setStatus(200);
                        JsonObject forCommonResponse = (JsonObject) new JsonResponseGenerator()
                                .getForCommonResponse(Constaants.ADDED, "Orders is added successfully !");
                        resp.getWriter().println(forCommonResponse);
                        return;
                    }else {
                        resp.sendError(HttpServletResponse.SC_EXPECTATION_FAILED, "Failed to add ");
                        return;
                    }
                }catch (RuntimeException r){
                    r.printStackTrace();
                    resp.sendError(HttpServletResponse.SC_EXPECTATION_FAILED,r.getMessage());
                }
                break;
            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Post Operation");
                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }


    public Object getCustomerName() {
        return true;
    }

    public Object getDate() {
        return true;
    }

    public Object getOrderId() {
        return true;
    }
}
