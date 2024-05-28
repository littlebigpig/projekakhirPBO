/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOdatawarnet.datagameDAO;
import DAOImplement.datagameimplement;
import java.util.List;
import model.*;
import projekakhir.gameview;
/**
 *
 * @author USER
 */
public class datagamecontroller {
    gameview frame;
    datagameimplement impldatagame;
    List<datagame> dg1;
    List<datagame> dg2;
    
    public datagamecontroller(gameview frame) {
        this.frame = frame;
        impldatagame = new datagameDAO();
        dg1 = impldatagame.getAll1();
        dg2 = impldatagame.getAll2();
    }
    
    public void isitabel1() {
        dg1 = impldatagame.getAll1();
        modeldatagame mp = new modeldatagame(dg1);
        frame.getTabelreq().setModel(mp);
    }
    
    public void isitabel2() {
        dg2 = impldatagame.getAll2();
        modeldatagame mp = new modeldatagame(dg2);
        frame.getTabelgame().setModel(mp);
    }
    
    public void insert2() {
        try {
            datagame dg = new datagame();
            dg.setGametitle(frame.getReqgametitle().getText());
            dg.setGenre(frame.getReqgenre().getText());
            double size = Double.parseDouble(frame.getReqsize().getText());
            dg.setSize(size);
            impldatagame.insert2(dg);
        } catch (Exception ex) {
            System.err.println("Error occurred while inserting data:");
        }
    }
    
    public void delete1() {
        String gametitle = frame.getReqgametitle().getText();
        impldatagame.delete1(gametitle);
    }
    
    public void delete2() {
        String gametitle = frame.getReqgametitle().getText();
        impldatagame.delete2(gametitle);
    }
    
}
