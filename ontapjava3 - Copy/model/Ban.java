/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontapjava3.model;

/**
 *
 * @author Admin
 */
public class Ban {
    private String id;
    private String ten;
    private String ma;
    boolean gioitinh;

    public Ban() {
    }

    public Ban(String id, String ten, String ma, boolean gioitinh) {
        this.id = id;
        this.ten = ten;
        this.ma = ma;
        this.gioitinh = gioitinh;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    
    
}
