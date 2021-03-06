/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.DetailTransaksiModel;
import static Utility.Koneksi.Koneksi;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maria
 */
public class DetailTransaksiDAO {
    /**
     * Berfungsi untuk menampilkan semua detail transaksi terkait transaksi yang dipilih
     */
    public static List<DetailTransaksiModel> getAll(String idTransaksi) {
       List<DetailTransaksiModel> listDetailTransaksi = new ArrayList<>();

       try {
           String query = "\"SELECT id, id_transaksi, id_barang, jumlah FROM `detail_transaksi` \"";
           query += " WHERE id_transaksi = ?";
           
           PreparedStatement ps = Koneksi().prepareStatement(query);
           ps.setString(1, idTransaksi);
           ResultSet rs = ps.executeQuery();

           while(rs.next()) {
               DetailTransaksiModel detailtransaksi = new DetailTransaksiModel();

               detailtransaksi.setId(rs.getString("id"));
               detailtransaksi.setIdTransaksi(rs.getString("id_transaksi"));
               detailtransaksi.setIdBarang(rs.getString("id_barang"));
               detailtransaksi.setJumlahBarang(rs.getInt("jumlah"));

               listDetailTransaksi.add(detailtransaksi);
           }
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }

       return listDetailTransaksi;
    }
    
    /**
     * Berfungsi untuk memasukkan detail transaksi saat input transaksi
     */
    public static boolean insert(DetailTransaksiModel detailTransaksi) {
       try {
           String query = "INSERT INTO detail_transaksi (id, id_transaksi, id_barang, jumlah) VALUES (?, ?, ?, ?)";
           
           PreparedStatement ps = Koneksi().prepareStatement(query);
           ps.setInt(1, Types.NULL);
           ps.setString(2, detailTransaksi.getIdTransaksi());
           ps.setString(3, detailTransaksi.getIdBarang());
           ps.setInt(5, detailTransaksi.getJumlahBarang());
            
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
     * Berfungsi untuk mendapatkan total harga per item
     */
    public static long getTotalHargaById(String idTransaksi) {
       long totalHarga = 0;
       
       try {
           String query = "SELECT SUM(b.jumlah * c.harga) AS \"total_harga\" FROM transaksi a INNER JOIN detail_transaksi b ON a.id = b.id_transaksi LEFT JOIN barang c ON b.id_barang = c.id";
           query += " WHERE a.id = ?";
           
           PreparedStatement ps = Koneksi().prepareStatement(query);
           ps.setString(1, idTransaksi);
           ResultSet rs = ps.executeQuery();
           
           if (rs.next()) {
               totalHarga = rs.getInt(1);
           } 
       } catch (SQLException se) {
           se.printStackTrace();
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return totalHarga;
    }
}
