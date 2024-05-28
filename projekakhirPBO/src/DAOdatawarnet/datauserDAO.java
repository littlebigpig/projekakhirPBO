/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatawarnet;
import java.sql.*;
import java.util.*;
import koneksi.konektor;
import model.*;
import DAOImplement.datauserimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */
public class datauserDAO implements datauserimplement{
    Connection connection;
    
    final String select = "SELECT * FROM user";
    final String insert = "INSERT INTO user (username, password, notelpon, durasi) VALUES (?, ?, ?, ?);";
    final String update = "UPDATE user SET username=?, password=?, notelpon=?, durasi=? WHERE username=?;";
    final String delete = "DELETE FROM user WHERE username=?;";

    public datauserDAO(){
        connection = konektor.connection();
    }

    
    @Override
    public void insert(datauser u) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getNotelpon());
            statement.setDouble(4, u.getDurasi());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while(rs.next()) {
                u.setUsername(rs.getString(1));
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update(datauser u) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(update, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, u.getUsername());
            statement.setString(2, u.getPassword());
            statement.setString(3, u.getNotelpon());
            statement.setDouble(4, u.getDurasi());
            statement.setString(5, u.getUsername());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(String username) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            statement.setString(1, username);
            statement.executeUpdate();
        }catch (SQLException ex){
            ex.printStackTrace();
        }finally {
            try {
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datauser> getAll() {
        List<datauser> dt = null;
        try{
            dt = new ArrayList<datauser>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datauser user = new datauser();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNotelpon(rs.getString("notelpon"));
                user.setDurasi(rs.getDouble("durasi"));
                dt.add(user);
            }
        }catch(SQLException ex){
            Logger.getLogger(datauserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    return dt;
    }
}
