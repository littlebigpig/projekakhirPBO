package DAOdatawarnet;

import java.sql.*;
import java.util.*;
import koneksi.konektor;
import model.datalogin;
import DAOImplement.dataloginimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
import projekakhir.*;
import javax.swing.JOptionPane;

public class dataloginDAO implements dataloginimplement {
    Connection connection;
    
    final String select = "SELECT * FROM admin WHERE username = ? AND password = ?;";
    final String selectAll = "SELECT * FROM admin;";
    
    public dataloginDAO(){
        connection = konektor.connection();
    }
    
    @Override
    public void ceklogin(datalogin u) {
        try (PreparedStatement statement = connection.prepareStatement(select)) {
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    adminview v = new adminview();
                    v.setVisible(true);
                    v.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(null, "Berhasil Login");
                } else {
                    JOptionPane.showMessageDialog(null, "Gagal Login");
                    loginview v = new loginview();
                    v.setVisible(true);
                    v.setLocationRelativeTo(null);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(dataloginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<datalogin> getAll() {
        List<datalogin> dl = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(selectAll)) {
            while (rs.next()) {
                datalogin login = new datalogin();
                login.setUsername(rs.getString("username"));
                login.setPassword(rs.getString("password"));
                dl.add(login);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dataloginDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dl;
    }
}
