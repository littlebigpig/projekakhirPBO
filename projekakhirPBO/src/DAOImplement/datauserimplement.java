/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplement;
import java.util.List;
import model.*;

/**
 *
 * @author USER
 */
public interface datauserimplement {
    
    public void insert(datauser u);
    
    public void update(datauser u);
    
    public void delete(String username);
    
    public List<datauser> getAll();
    
}
