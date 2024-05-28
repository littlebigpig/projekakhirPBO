/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DAOdatawarnet.datagameDAO;
import DAOImplement.datagameimplement;
import model.*;
import projekakhir.reqgameview;

/**
 *
 * @author USER
 */
public class datareqgamecontroller {
    reqgameview frame;
    datagameimplement impldatagame;
    
    public datareqgamecontroller(reqgameview frame) {
        this.frame = frame;
        impldatagame = new datagameDAO();
    }
    
    public void insert1() {
        try {
            datagame dg = new datagame();
            dg.setGametitle(frame.getTexttitlegame().getText());
            dg.setGenre(frame.getTextgenre().getText());
            double size = Double.parseDouble(frame.getTextsize().getText());
            dg.setSize(size);
            impldatagame.insert1(dg);
            System.out.println("anjay");
        } catch (Exception ex) {
            System.err.println("Error occurred while inserting data:");
        }
    }
}
