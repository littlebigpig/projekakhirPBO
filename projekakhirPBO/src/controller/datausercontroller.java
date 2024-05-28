/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOdatawarnet.datauserDAO;
import DAOImplement.datauserimplement;
import java.util.List;
import javax.swing.JOptionPane;
import model.*;
import projekakhir.adminview;
/**
 *
 * @author USER
 */
public class datausercontroller {
    adminview frame;
    datauserimplement impldatauser;
    List<datauser> dt;
    
    public datausercontroller(adminview frame) {
        this.frame = frame;
        impldatauser = new datauserDAO();
        dt = impldatauser.getAll();
    }
    
    public void isitabel() {
        dt = impldatauser.getAll();
        modeldatauser mp = new modeldatauser(dt);
        frame.getTabeluserlist().setModel(mp);
    }
 
    public void insert() {
        try {
            datauser dt = new datauser();
            dt.setUsername(frame.getUsername().getText());
            dt.setPassword(frame.getPassword().getText());
            dt.setNotelpon(frame.getNotelpon().getText());
            double durasi = Double.parseDouble(frame.getDurasi().getText());
            dt.setDurasi(durasi);
            impldatauser.insert(dt);
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan User");
        } catch (NumberFormatException e) {
            
        }
    }
    
    public void update() {
        try {
            datauser dt = new datauser();
            dt.setUsername(frame.getUsername().getText());
            dt.setPassword(frame.getPassword().getText());
            dt.setNotelpon(frame.getNotelpon().getText());
            double durasi = Double.parseDouble(frame.getDurasi().getText());
            dt.setDurasi(durasi);
            impldatauser.update(dt);
            JOptionPane.showMessageDialog(null, "Berhasil Update Data User");
        } catch (NumberFormatException e) {
            
        }
    }
    
    public void delete() {
        String username = frame.getUsername().getText();
        impldatauser.delete(username);
        JOptionPane.showMessageDialog(null, "User Dihapus");
    }
    
}
