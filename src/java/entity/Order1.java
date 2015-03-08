/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author Gunraj
 */

public class Order1 implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Integer orderID;
    
    private Date orderDate;
    
    private String tableNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    private Double totalPrice;
    
    private Billing billing;

    public Order1() {
    }

    public Order1(Integer orderID) {
        this.orderID = orderID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderID != null ? orderID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.orderID == null && other.orderID != null) || (this.orderID != null && !this.orderID.equals(other.orderID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Order1[ orderID=" + orderID + " ]";
    }

    public boolean update_totalprice(int orderID)
    {
        try
        {
          Connection connection=util.db.connect();
          String stmt="Select totalprice from order where orderID=?";
          PreparedStatement in=connection.prepareStatement(stmt);
        in.setInt(1, orderID);
        
        ResultSet rs=in.executeQuery();
        if(rs.next())
        {
            
        }

        return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
        //return true;
    }
}
