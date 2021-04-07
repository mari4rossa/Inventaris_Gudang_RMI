/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.TransaksiModel;
import static Utility.Koneksi.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maria
 */
public class TransaksiDAO {
    /**
     * Berfungsi untuk menampilkan semua riwayat transaksi
     */
    public static List<TransaksiModel> getAll() {
        List<TransaksiModel> listTransaksi = new ArrayList<>();
        
        try {
            String query = "SELECT id, date_format(tanggal, '%d-%m-%Y') AS tanggal, id_admin, id_gudang, tipe, transfer FROM transaksi";
            
            PreparedStatement ps = Koneksi().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                TransaksiModel transaksi = new TransaksiModel();
                
                transaksi.setId(rs.getString("id"));
                transaksi.setTanggal(rs.getString("tanggal"));
                transaksi.setIdAdmin(rs.getString("id_admin"));
                transaksi.setIdGudang(rs.getString("id_gudang"));
                transaksi.setTipe(rs.getString("tipe"));
                transaksi.setTransfer(rs.getString("transfer"));
                
                listTransaksi.add(transaksi);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return listTransaksi;
    }
    
    /**
     * Berfungsi untuk mengambil jumlah seluruh barang per transaksi
     */
    public static int getTotalBarangById(String idTransaksi) {
       int totalBarang = 0;
       
       try {
           String query = "SELECT SUM(b.jumlah) AS \"total_barang\" FROM transaksi a INNER JOIN detail_transaksi b ON a.id = b.id_transaksi";
           query += " WHERE a.id = ?";
           
           PreparedStatement ps = Koneksi().prepareStatement(query);
           ps.setString(1, idTransaksi);
           ResultSet rs = ps.executeQuery();
           
           if (rs.next()) {
               totalBarang = rs.getInt(1);
           } 
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return totalBarang;
    }
    
    /**
     * Berfungsi untuk membuat transaksi baru
     */
    public static boolean insert(TransaksiModel transaksi) {
        try {
            String query = "INSERT INTO transaksi (id, tanggal, id_admin, id_gudang, tipe, transfer) VALUES (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement ps = Koneksi().prepareStatement(query);
            ps.setString(1, transaksi.getId());
            ps.setString(2, transaksi.getTanggal());
            ps.setString(3, transaksi.getIdAdmin());
            ps.setString(4, transaksi.getIdGudang());
            ps.setString(5, transaksi.getTipe());
            ps.setString(6, transaksi.getTransfer());
            
            if (ps.executeUpdate() > 0){
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
   /**
     * Berfungsi untuk menghapus transaksi
     */
    public static boolean delete(String idTransaksi) {
        try {
            String query = "DELETE FROM transaksi WHERE id = ?";
            
            PreparedStatement ps = Koneksi().prepareStatement(query);
            ps.setString(1, idTransaksi);
                    
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    /**
     * Berfungsi untuk memperbaharui data transaksi
     */
    public static boolean update(TransaksiModel transaksi) {
        try {
            String query = "UPDATE transaksi SET tanggal=?, id_admin=?, id_gudang=?, tipe=?, transfer=? WHERE id=?";
            
            PreparedStatement ps = Koneksi().prepareStatement(query);
            ps.setString(1, transaksi.getTanggal());
            ps.setString(2, transaksi.getIdAdmin());
            ps.setString(3, transaksi.getIdGudang());
            ps.setString(4, transaksi.getTipe());
            ps.setString(5, transaksi.getTransfer());
            ps.setString(6, transaksi.getId());
                     
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
