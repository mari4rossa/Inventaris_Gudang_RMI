/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Controller.Koneksi;
import Model.BarangModel;
import java.util.Collection;
/**
 *
 * @author Matius Andreatna
 */
public class BarangDao {
    public static List<String[]> loadBarang() throws Exception {
        List<String[]> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM barang";
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            ResultSet rs = stt.executeQuery();
            while (rs.next()) {
                String[] data = new String[4];
                
                data[0] = rs.getString("id");
                data[1] = rs.getString("nama");
                data[2] = rs.getString("ukuran");
                data[3] = String.valueOf(rs.getInt("harga"));
                list.add(data);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    public static boolean insertBarang(BarangModel dataIn) throws Exception{
        try {
            BarangModel item = dataIn;
            
            String id = item.getId();
            String nama = item.getNama();
            String ukuran = item.getUkuran();
            int harga = item.getHarga();
            
            String query = "INSERT INTO barang(id, "
                    + "nama, ukuran, harga) VALUES ('"+id+"','"+nama+"','"+ukuran+"','"+harga+"')";
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            stt.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
    
    public static List<String[]> cariBarang(String dataCari) throws Exception{
        List<String[]> list = new ArrayList<>();
        try {
            String data = dataCari;
            
            String query = "SELECT * FROM barang WHERE id LIKE '%" + data + "%' "
                    + "OR nama LIKE '%" + data + "%'";
     
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            ResultSet rs = stt.executeQuery();
            while (rs.next()) {
                String[] rsString = new String[4];
                rsString[0] = rs.getString("id");
                rsString[1] = rs.getString("nama");
                rsString[2] = rs.getString("ukuran");
                rsString[3] = String.valueOf(rs.getInt("harga"));
                list.add(rsString);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    
    public static List<String[]> sortBarang(String by) throws Exception{
        List<String[]> list = new ArrayList<>();
        try {
            String data = by;
            PreparedStatement stt = null;
            if (data.equalsIgnoreCase("id")) {
                stt = Koneksi.Koneksi().prepareCall("SELECT * FROM barang ORDER BY id ASC");
            } else if (data.equalsIgnoreCase("nama")) {
                stt = Koneksi.Koneksi().prepareCall("SELECT * FROM barang ORDER BY nama ASC");
            } else if (data.equalsIgnoreCase("harga")) {
                stt = Koneksi.Koneksi().prepareCall("SELECT * FROM barang ORDER BY harga ASC");
            }
 
            ResultSet rs = stt.executeQuery();
            while (rs.next()) {
                String[] rsString = new String[4];
                rsString[0] = rs.getString("id");
                rsString[1] = rs.getString("nama");
                rsString[2] = rs.getString("ukuran");
                rsString[3] = rs.getString("harga");
                list.add(rsString);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    
    public static String IdBarang() throws Exception{
        String result = null;
        try {
            String query = "SELECT * FROM barang ORDER BY id DESC";
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            ResultSet rs = stt.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id").substring(1);
                String AN = "" + (Integer.parseInt(id) + 1);
                String Nol = "";

                if(AN.length()==1)
                {Nol = "000";}
                else if(AN.length()==2)
                {Nol = "00";}
                else if(AN.length()==3)
                {Nol = "0";}
                else if(AN.length()==4)
                {Nol = "";}

               result = "K" + Nol + AN;
            } else {
               result = "K0001";
            }

           }catch(Exception e){
                throw e;
           }
     
        return result;
    }
    
    public static boolean updateData(BarangModel dataIn) throws Exception{
        try {
            BarangModel item = dataIn;
            String id = item.getId();
            String nama = item.getNama();
            String ukuran = item.getUkuran();
            int harga = item.getHarga();
            
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall("UPDATE barang SET nama='"+nama+"',ukuran='"+ukuran+"',harga='"+harga+"'WHERE id='"+id +"'");
            stt.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
    
    public static boolean deleteData(BarangModel Id) throws Exception{
        try {
            BarangModel bM = Id;
            String id = bM.getId();
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall("DELETE FROM barang WHERE id='"+id+"'");
            stt.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
}
