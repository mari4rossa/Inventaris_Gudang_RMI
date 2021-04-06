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
 * @author User
 */
public class DetailTransaksiDAO {
    public static List<DetailTransaksiModel> getAll() {
       List<DetailTransaksiModel> listDetailTransaksi = new ArrayList<>();

       try {
           String query = "\"SELECT id, id_transaksi, id_barang, jumlah FROM `detail_transaksi` \"";
           
           PreparedStatement ps = Koneksi().prepareStatement(query);
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
}
