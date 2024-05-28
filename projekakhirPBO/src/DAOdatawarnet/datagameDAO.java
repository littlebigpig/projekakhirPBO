/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatawarnet;
import java.sql.*;
import java.util.*;
import koneksi.konektor;
import model.*;
import DAOImplement.datagameimplement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class datagameDAO implements datagameimplement {
    Connection connection;
    
    final String select1 = "SELECT * FROM game_req";
    final String select2 = "SELECT * FROM game";
    final String insert1 = "INSERT INTO game_req (gametitle, genre, size) VALUES (?, ?, ?);";
    final String insert2 = "INSERT INTO game (gametitle, genre, size) VALUES (?, ?, ?);";
    final String delete1 = "DELETE FROM game_req WHERE gametitle=?;";
    final String delete2 = "DELETE FROM game WHERE gametitle=?;";
    
    public datagameDAO(){
        connection = konektor.connection();
    }
    

    @Override
    public void insert1(datagame g) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert1, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, g.getGametitle());
            statement.setString(2, g.getGenre());
            statement.setDouble(3, g.getSize());
            
            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                JOptionPane.showMessageDialog(null, "Request Gagal");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Request Berhasil");
            }
            } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void insert2(datagame g) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert2);
            statement.setString(1, g.getGametitle());
            statement.setString(2, g.getGenre());
            statement.setDouble(3, g.getSize());

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                JOptionPane.showMessageDialog(null, "Gagal Install Game");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Berhasil Install Game");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete1(String gametitle) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete1);
            statement.setString(1, gametitle);
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
    public void delete2(String gametitle) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete2);
            statement.setString(1, gametitle);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Game Berhasil Di Uninstall");
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
    public List<datagame> getAll1() {
        List<datagame> dg1 = new ArrayList<>();
        try {
            Statement st1 = connection.createStatement();
            ResultSet rs1 = st1.executeQuery(select1);

            while (rs1.next()) {
                datagame game1 = new datagame();
                game1.setGametitle(rs1.getString("gametitle"));
                game1.setGenre(rs1.getString("genre"));
                game1.setSize(rs1.getDouble("size"));
                dg1.add(game1);
            }

            rs1.close();
            st1.close();

        } catch (SQLException ex) {
            Logger.getLogger(datagameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dg1;
    }
    
    @Override
    public List<datagame> getAll2() {
        List<datagame> dg2 = new ArrayList<>();
        try {
            Statement st2 = connection.createStatement();
            ResultSet rs2 = st2.executeQuery(select2);

            while (rs2.next()) {
                datagame game2 = new datagame();
                game2.setGametitle(rs2.getString("gametitle"));
                game2.setGenre(rs2.getString("genre"));
                game2.setSize(rs2.getDouble("size"));
                dg2.add(game2);
            }

            rs2.close();
            st2.close();

        } catch (SQLException ex) {
            Logger.getLogger(datagameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dg2;
    }

}
