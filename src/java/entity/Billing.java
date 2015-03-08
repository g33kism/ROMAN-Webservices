/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Gunraj
 */
public class Billing implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer billID;
    private Integer orderID;
    private String tableNumber;
    private Boolean paymentStatus;
    private Order1 order1;

    public Billing() {
    }

    public Billing(Integer billID) {
        this.billID = billID;
    }

    public Integer getBillID() {
        return billID;
    }

    public void setBillID(Integer billID) {
        this.billID = billID;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Order1 getOrder1() {
        return order1;
    }

    public void setOrder1(Order1 order1) {
        this.order1 = order1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (billID != null ? billID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Billing)) {
            return false;
        }
        Billing other = (Billing) object;
        if ((this.billID == null && other.billID != null) || (this.billID != null && !this.billID.equals(other.billID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Billing[ billID=" + billID + " ]";
    }
    public boolean insert()
    {
        try{
        Connection connection = util.db.connect();
        String stmt= "Insert into billing(itemName,category,cuisine,price,pic) values(?,?,?,?,?);";
        PreparedStatement in=connection.prepareStatement(stmt);
       // in.setInt(1, itemID);
   /*     in.setString(1, itemName);
        in.setString(2, category);
        in.setString(3, cuisine);
        in.setFloat(4, price);
        in.setString(5, pic);*/
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
