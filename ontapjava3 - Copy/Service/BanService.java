/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ontapjava3.Service;

import java.util.List;
import ontapjava3.Repository.BanRepository;
import ontapjava3.model.Ban;

/**
 *
 * @author Admin
 */
public class BanService {
    private BanRepository banrepository;
    
    
    public BanService(){
        banrepository = new BanRepository();
    }
    
    public List<Ban> laynv(){
        return banrepository.laynv();
    }
    
    public Ban addsv(Ban nv){
        return banrepository.addnv(nv);
    }
    
    public  void xoanv(String id){
        this.banrepository.xoanv(id);
    }
    
    public  void suanv(Ban nv){
        this.banrepository.suanv(nv);
    }
}
