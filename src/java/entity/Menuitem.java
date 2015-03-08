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
public class Menuitem implements Serializable {

    public Menuitem(Integer itemID, String itemName,String desc, String category, String cuisine, float price, String pic) {
        this.itemID = itemID;
        this.desc=desc;
        this.itemName = itemName;
        this.category = category;
        this.cuisine = cuisine;
        this.price = price;
        this.pic = pic;
    }
   
    private Integer itemID;
    
    private String itemName;
    
    private String category;

     private String cuisine;
  
    private float price;
    
    private String pic;
    
    public String desc;
    
public void setItemDesc(String desc) {
      this.desc=desc;
    }
    public String getItemdesc()
    {
    return desc;
    }
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
    
    public Menuitem() {
    }

    public Menuitem(Integer itemID) {
        this.itemID = itemID;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
        if (!(object instanceof Menuitem)) {
            return false;
        }
        Menuitem other = (Menuitem) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Menuitem[ itemID=" + itemID + " ]";
    }
    
    public boolean insert()
    {   
        try{
        Connection connection = util.db.connect();
        String stmt= "Insert into menuitem(itemName,description,category,cuisine,price,pic) values(?,?,?,?,?,?);";
        PreparedStatement in=connection.prepareStatement(stmt);
       // in.setInt(1, itemID);
        in.setString(1, itemName);
        in.setString(2, desc);
        in.setString(3, category);
        in.setString(4, cuisine);
        in.setFloat(5, price);
        in.setString(6, pic);
        in.execute();
        return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
     public boolean update(String oname)
    {
        try{
        Connection connection = util.db.connect();
        String stmt = "select itemID from menuitem where itemName =?";
        PreparedStatement in=connection.prepareStatement(stmt);
        in.setString(1, oname);
        
        ResultSet rs=in.executeQuery();
        if(rs.next())
        {
            //updation
            itemID=rs.getInt("itemID");
            stmt= "update menuitem set itemName=? ,category=?,cuisine=?,price=?,pic=?  where itemID =?";
            in = connection.prepareStatement(stmt);
            in.setString(1, itemName);
            in.setString(2, category);
            in.setString(3, cuisine);
            in.setFloat(4, price);
            in.setInt(6, itemID);
            in.setString(5, pic);
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
      public boolean delete()
    {
       try{
        Connection connection = util.db.connect();
        String stmt = "select itemID from menuitem where itemName =?";
        PreparedStatement in=connection.prepareStatement(stmt);
        in.setString(1, itemName);
        
        ResultSet rs=in.executeQuery();
        if(rs.next())
        {
            itemID=rs.getInt("itemID");
            stmt= "delete from menuitem where itemID=?";
            in = connection.prepareStatement(stmt);   
            in.setInt(1, itemID);
            in.execute();
            return true;
        }
        else
            return false;
       }
        catch(Exception e)
        {
            e.printStackTrace();
            return false;
        }
    }
      
    /*public Object[] getMenuItemNames()
    {
        //Menuitem items;
        LinkedList temp= new LinkedList();
        try{
        Connection connection = util.db.connect();
        String stmt = "select * from Menuitem";
        PreparedStatement in=connection.prepareStatement(stmt);
        ResultSet rs=in.executeQuery();
        while(rs.next())
            temp.add((Object)new Menuitem(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getString(6)));
       return temp.toArray();
        
        }
        catch(Exception e)
        {
            return null;
        }
    }*/
    
     public Object[][] getMenuItems()
    {
        try{
        Connection connection = util.db.connect();
        String stmt = "select * from Menuitem";
        PreparedStatement in=connection.prepareStatement(stmt);
        ResultSet rs=in.executeQuery();
        rs.last();
        int numRows = rs.getRow();
        int numColumns=6,row=0;
        rs.beforeFirst();
        Object returnArray[][] = new Object[numRows][numColumns];
        while(rs.next()){
        for(int col=1; col<=numColumns;col++)
            returnArray[row][col-1] = rs.getObject(col);
            row++;
        }
        return returnArray;
        }
        catch(Exception e)
        {
            return null;
        }
    }
      public String[] getMenuItemNames()
    {
        try{
        Connection connection = util.db.connect();
        String stmt = "select itemname from Menuitem";
        PreparedStatement in=connection.prepareStatement(stmt);
        ResultSet rs=in.executeQuery();
        rs.last();
        int numRows = rs.getRow();
        int row=0;
        rs.beforeFirst();
        String returnArray[] = new String[numRows];
        while(rs.next()){
            returnArray[row]= rs.getString(1);
            row++;
        }
        return returnArray;
        }
        catch(Exception e)
        {
            return null;
        }
    }
      
       public String[] getMenuItemByName(String name)
    {
        try{
        Connection connection = util.db.connect();
        String stmt = "select * from Menuitem where itemname=?";
        PreparedStatement in=connection.prepareStatement(stmt);
        in.setString(1, name);
        ResultSet rs=in.executeQuery();
        int numColumns=7;
       
        String returnArray[]= new String[numColumns];
        
        while(rs.next()){
            for(int col=1; col<=numColumns;col++)
            returnArray[col-1] = rs.getString(col);

        }
        return returnArray;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    
}
