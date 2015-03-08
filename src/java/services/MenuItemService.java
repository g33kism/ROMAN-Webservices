/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import entity.Menuitem;
/**
 *
 * @author Gunraj
 */
@WebService(serviceName = "MenuItemService")
public class MenuItemService {

    /**
     * This is a sample web service operation
     */
  
    @WebMethod(operationName = "newMenuItem")
    public boolean newMenuItem(@WebParam(name = "name") String name,@WebParam(name="desc")String desc,@WebParam(name = "category") String cat,@WebParam(name = "cuisine") String cui,@WebParam(name = "price") float price, @WebParam(name = "pic") String pic) {
        Menuitem m=new Menuitem();
        m.setItemName(name);
        m.setItemDesc(desc);
        m.setCategory(cat);
        m.setCuisine(cui);
        m.setPrice(price);
        m.setPic(pic);
        return m.insert();
    }
    
    @WebMethod(operationName="updateMenuItem")
    public boolean updateMenuItem(@WebParam(name = "oldname") String oname,@WebParam(name = "newname") String nname,@WebParam(name="desc")String desc,@WebParam(name = "category") String cat,@WebParam(name = "cuisine") String cui,@WebParam(name = "price") float price, @WebParam(name = "pic") String pic)
    {
        Menuitem m=new Menuitem();
        m.setItemName(nname);
        m.setItemDesc(desc);
        m.setCategory(cat);
        m.setCuisine(cui);
        m.setPrice(price);
        m.setPic(pic);
        return m.update(oname);
    }
    
    @WebMethod(operationName="deleteMenuItem")
    public boolean deleteMenuItem(@WebParam(name = "name") String name)
    {
        Menuitem m=new Menuitem();
        m.setItemName(name);
        return m.delete();
    }
     @WebMethod(operationName="getMenuItems")
   public Object[][] getMenuItems()
   {
       Menuitem m=new Menuitem();
       return m.getMenuItems();
   }
      @WebMethod(operationName="getMenuItemNames")
     public String[] getMenuItemNames()
     {
       Menuitem m=new Menuitem();
       return m.getMenuItemNames();
   }
   @WebMethod(operationName="getMenuItemByName")
   public String[] getMenuItemByName(@WebParam(name = "name")String name)
   {
       Menuitem m=new Menuitem();
       return m.getMenuItemByName(name);
   }
}
