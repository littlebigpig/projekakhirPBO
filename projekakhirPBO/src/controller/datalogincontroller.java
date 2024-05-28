/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOdatawarnet.dataloginDAO;
import DAOImplement.dataloginimplement;
import java.util.List;
import model.*;
import projekakhir.loginview;
/**
 *
 * @author USER
 */
public class datalogincontroller {
    loginview frame;
    dataloginimplement impldatalogin;
    List<datalogin> dl;
    
    public datalogincontroller(loginview frame) {
        this.frame = frame;
        impldatalogin= new dataloginDAO();
        dl = impldatalogin.getAll();
    }
    public void ceklogin() {
        datalogin dl = new datalogin();
        dl.setUsername(frame.getUsername());
        dl.setPassword(frame.getPassword());
        impldatalogin.ceklogin(dl);
    }
}
