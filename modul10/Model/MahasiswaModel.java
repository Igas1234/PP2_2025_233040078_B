/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.unpas.pratikumprogaman2.modul10.Model;

/**
 *
 * @author 62812
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import id.ac.unpas.pratikumprogaman2.modul10.KoneksiDB;

public class MahasiswaModel {

    public List<Object[]> getAll() throws SQLException {
        List<Object[]> data = new ArrayList<>();
        Connection conn = KoneksiDB.configDB();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM mahasiswa");

        while (rs.next()) {
            data.add(new Object[]{
                rs.getString("nama"),
                rs.getString("nim"),
                rs.getString("jurusan")
            });
        }
        return data;
    }

    public boolean nimExists(String nim) throws SQLException {
        String sql = "SELECT nim FROM mahasiswa WHERE nim=?";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, nim);
        return pst.executeQuery().next();
    }

    public void insert(String nama, String nim, String jurusan) throws SQLException {
        String sql = "INSERT INTO mahasiswa VALUES (NULL, ?, ?, ?)";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, nim);
        pst.setString(3, jurusan);
        pst.executeUpdate();
    }

    public void update(String nama, String jurusan, String nim) throws SQLException {
        String sql = "UPDATE mahasiswa SET nama=?, jurusan=? WHERE nim=?";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, nama);
        pst.setString(2, jurusan);
        pst.setString(3, nim);
        pst.executeUpdate();
    }

    public void delete(String nim) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE nim=?";
        PreparedStatement pst = KoneksiDB.configDB().prepareStatement(sql);
        pst.setString(1, nim);
        pst.executeUpdate();
    }
}
