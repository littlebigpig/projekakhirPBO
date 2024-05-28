/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.datalogin;
import model.datauser;

/**
 *
 * @author USER
 */
public interface dataloginimplement {
    
    public void ceklogin(datalogin u);
    
    public List<datalogin> getAll();
}
