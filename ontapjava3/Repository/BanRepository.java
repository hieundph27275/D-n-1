/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontapjava3.Repository;

import java.util.ArrayList;
import java.util.List;
import ontapjava3.Utility.JDBCHelper;
import ontapjava3.model.Ban;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class BanRepository {
    private JDBCHelper JDBC;
    
    public BanRepository(){
        JDBC = new JDBCHelper();
    }
    
    
    public List<Ban> laynv(){
        List<Ban> nv = new ArrayList<>();
        String sql = "SELECT * FROM Ban";
        ResultSet rs = JDBC.executeQuery(sql);
        
        try {
            while(rs.next()){
                nv.add(mapping(rs));
            }
        } catch (SQLException e) {
            System.out.println("Loi khong lay duoc du lieu");
        }
        return nv;
    }
    
    
    public Ban mapping(ResultSet rs){
        if(rs != null){
            try {
                String id = rs.getString("id");
                String ten = rs.getString("ten");
                String ma = rs.getString("ma");
                boolean gioitinh = rs.getBoolean("gioitinh");
                
                return new Ban(id, ten, ma, gioitinh);
            } catch (SQLException e) {
                System.out.println("Loi ko mapping duoc");
            }
        }
        return null;
        
    }
    
    
    public Ban addnv(Ban nv){
        String sql = "INSERT INTO dbo.Ban(Id, Ten, Ma, GioiTinh) VALUES(?, ?, ?, ?)";
        String id = nv.getId();
        String ten = nv.getTen();
        String ma = nv.getMa();
        boolean gioitinh = nv.isGioitinh();
        int kq = JDBCHelper.executeUpdate(sql, id, ma, ten, true);
        
        if(kq > 0){
            String sqlselect = "SELECT TOP 1 * FROM Ban ORDER BY ID DESC";
            
            ResultSet rs = JDBC.executeQuery(sqlselect);
            
            try {
                while(rs.next()){
                    return mapping(rs);
                }
            } catch (SQLException e) {
                System.out.println("Loi them nv");
            }
        }
        return null;
    }
    
    
    
    public void xoanv(String id){
        String sql = "Delete from Ban where id = ?";
        JDBCHelper.executeUpdate(sql, id);
    }

   public void suanv(Ban nv){
       String id = nv.getId();
       String ten = nv.getTen();
       String ma = nv.getMa();
       boolean gioitinh = nv.isGioitinh();
       
       String sql = "UPDATE Ban SET id= ?, ten=?, ma=?, gioitinh=?";
       JDBC.executeUpdate(sql, id, ten, ma,gioitinh);
   }
    
}
