/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author USER
 */
public class modeldatagame extends AbstractTableModel {

    List<datagame> dg;
    public modeldatagame(List<datagame>dg) {
        this.dg = dg;
    }    
   
    @Override
    public int getRowCount() {
        return dg.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Title";
            case 1:
                return "Genre";
            case 2:
                return "Size";
            default:
                return null;
                 
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return dg.get(row).getGametitle();
            case 1:
                return dg.get(row).getGenre();
            case 2:
                return dg.get(row).getSize();
            default:
                return null;
                 
        }
    }    
}
