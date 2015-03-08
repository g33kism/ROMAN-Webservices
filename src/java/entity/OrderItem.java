/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author Gunraj
 */
public class OrderItem implements Serializable {
    private Integer itemID;
    private Integer orderID;
    private String status;
    private Integer quantity;

    public OrderItem() {
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItem)) {
            return false;
        }
        OrderItem other = (OrderItem) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.OrderItem[ itemID=" + itemID + " ]";
    }

    public boolean insert()
    {
        try{
        Connection connection = util.db.connect();
        String stmt= "Insert into orderitem(orderID,itemID,quantity,status) values(?,?,?,?);";
        PreparedStatement in=connection.prepareStatement(stmt);
       // in.setInt(1, itemID);

        in.setInt(1, orderID);
        in.setInt(2, itemID);
        in.setInt(3, quantity);
        in.setString(4, status);
        in.execute();
        return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
     public boolean update()
    {
        try{
        Connection connection = util.db.connect();

        if(quantity>0)
        {
        String stmt = "select quantity from orderitem where itemID =? and orderID=?";
        PreparedStatement in=connection.prepareStatement(stmt);
        in.setInt(1, itemID);
        in.setInt(2, orderID);

        ResultSet rs=in.executeQuery();
        if(rs.next())
        {
            //updation
            quantity=rs.getInt("quantity");
            stmt= "update orderitem set quantity=? where itemID =? and orderID=?";
            in = connection.prepareStatement(stmt);
            in.setInt(1, quantity);
            in.setInt(2, itemID);
            in.setInt(3, orderID);
            in.execute();

            return true;
        }
        else{
           return false;
        }
        //return true;
        }
        else
        {
            try
            {
            String stmt="delete from orderitem where orderId=? and itemID=?";
             PreparedStatement in=connection.prepareStatement(stmt);
            in.setInt(1, orderID);
            in.setInt(2, itemID);
            in.execute();
            return true;
            }
            catch(Exception e)
            {
                e.printStackTrace();
                return false;
            }
        }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
public boolean update_status()
{
    try{
        Connection connection = util.db.connect(); 
        String stmt = "select status from orderitem where itemID =? and orderID=?";
        PreparedStatement in=connection.prepareStatement(stmt);
        in.setInt(1, itemID);
        in.setInt(2, orderID);

        ResultSet rs=in.executeQuery();
        if(rs.next())
        {
            //updation
            status=rs.getString("status");
            stmt= "update orderitem set status=? where itemID =? and orderID=?";
            in = connection.prepareStatement(stmt);
            in.setString(1, status);
            in.setInt(2, itemID);
            in.setInt(3, orderID);
            in.execute();

            return true;
        }
        else{
           return false;
        }
    }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
}

}

