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
public interface datagameimplement {
    public void insert1(datagame g);
    
    public void insert2(datagame g);
    
    public void delete1(String gametitle);
    
    public void delete2(String gametitle);
    
    public List<datagame> getAll1();
    
    public List<datagame> getAll2();
}
