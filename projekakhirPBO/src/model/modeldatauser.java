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
public class modeldatauser extends AbstractTableModel {
    
    List<datauser> dt;
    public modeldatauser(List<datauser>dt) {
        this.dt = dt;
    }

    @Override
    public int getRowCount() {
        return dt.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Username";
            case 1:
                return "Password";
            case 2:
                return "No. Telpon";
            case 3: 
                return "Durasi";
            default:
                return null;
                 
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column) {
            case 0:
                return dt.get(row).getUsername();
            case 1:
                return dt.get(row).getPassword();
            case 2:
                return dt.get(row).getNotelpon();
            case 3: 
                return dt.get(row).getDurasi();
            default:
                return null;
                 
        }
    }    
}
