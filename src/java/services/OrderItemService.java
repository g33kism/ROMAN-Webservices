/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import entity.OrderItem;
/**
 *
 * @author USER
 */
@WebService(serviceName="OrderItemService")
public class OrderItemService {
    
    /**
     * This Operation creates new Order Item
     * @param orderid
     * @param itemid
     * @param quantity
     * @param status
     * @return 
     */
    @WebMethod(operationName="newOrderItem")
    public boolean newOrderItem(@WebParam(name="OrderID")int orderid,@WebParam(name="ItemID")int itemid,@WebParam(name="Quantity")int quantity,@WebParam(name="Status")String status)
    {
     OrderItem o=new OrderItem();
     o.setOrderID(orderid);
     o.setItemID(itemid);
     o.setQuantity(quantity);
     o.setStatus(status);
     return o.insert();
    }
    @WebMethod(operationName="updateOrderItem")
    public boolean updateOrderItem(@WebParam (name="OrderID") int orderid ,@WebParam(name="ItemID")int itemid,@WebParam(name="newQuantity")int newquan)
    {
        OrderItem o=new OrderItem();
        o.setOrderID(orderid);
        o.setItemID(itemid);
        o.setQuantity(newquan);
        return o.update();
    }
     @WebMethod(operationName="updateStatus")
    public boolean updateStatus(@WebParam(name="OrderID")int orderid,@WebParam(name="ItemID")int itemid,@WebParam(name="newstatus")String newstatus)
    {
        OrderItem o=new OrderItem();
        o.setOrderID(orderid);
        o.setItemID(itemid);
        o.setStatus(newstatus);
        return o.update_status();
       
    }
}
