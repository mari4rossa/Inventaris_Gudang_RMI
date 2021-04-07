/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Koneksi;
import Model.GudangModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matius Andreatna
 */
public class GudangDao {
    public static List<String[]> loadGudang() throws Exception {
        List<String[]> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM gudang";
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            ResultSet rs = stt.executeQuery();
            while (rs.next()) {
                String[] data = new String[4];
                
                data[0] = rs.getString("id");
                data[1] = rs.getString("lokasi");
                data[2] = rs.getString("id_admin");
                list.add(data);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    public static boolean insertGudang(GudangModel dataIn) throws Exception{
        try {
            GudangModel item = dataIn;
            
            String id = item.getId();
            String lokasi = item.getLokasi();
            String idAdmin = item.getId_admin();
            
            String query = "INSERT INTO gudang(id, "
                    + "lokasi, id_dmin, harga) VALUES ('"+id+"','"+lokasi+"','"+idAdmin+"')";
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            stt.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
    
    public static List<String[]> cariGudang(String dataCari) throws Exception{
        List<String[]> list = new ArrayList<>();
        try {
            String data = dataCari;
            
            String query = "SELECT * FROM gudang WHERE id LIKE '%" + data + "%' "
                    + "OR lokasi LIKE '%" + data + "%'";
     
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            ResultSet rs = stt.executeQuery();
            while (rs.next()) {
                String[] rsString = new String[3];
                rsString[0] = rs.getString("id");
                rsString[1] = rs.getString("lokasi");
                rsString[2] = rs.getString("id_admin");
                list.add(rsString);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    
    public static List<String[]> sortGudang(String by) throws Exception{
        List<String[]> list = new ArrayList<>();
        try {
            String data = by;
            PreparedStatement stt = null;
            if (data.equalsIgnoreCase("id")) {
                stt = Koneksi.Koneksi().prepareCall("SELECT * FROM gudang ORDER BY id ASC");
            } else if (data.equalsIgnoreCase("lokasi")) {
                stt = Koneksi.Koneksi().prepareCall("SELECT * FROM gudang ORDER BY lokasi ASC");
            } else if (data.equalsIgnoreCase("id_admin")) {
                stt = Koneksi.Koneksi().prepareCall("SELECT * FROM gudang ORDER BY id_admin ASC");
            }
 
            ResultSet rs = stt.executeQuery();
            while (rs.next()) {
                String[] rsString = new String[3];
                rsString[0] = rs.getString("id");
                rsString[1] = rs.getString("lokasi");
                rsString[2] = rs.getString("id_dmin");
                list.add(rsString);
            }
            
        } catch (Exception e) {
            throw e;
        }
        return list;
    }
    
    public static String IdGudang() throws Exception{
        String result = null;
        try {
            String query = "SELECT * FROM gudang ORDER BY id DESC";
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

               result = "G" + Nol + AN;
            } else {
               result = "G0001";
            }

           }catch(Exception e){
                throw e;
           }
     
        return result;
    }
    
    public static boolean updateData(GudangModel dataIn) throws Exception{
        try {
            GudangModel item = dataIn;
            String id = item.getId();
            String lokasi = item.getLokasi();
            String idAdmin = item.getId_admin();
            
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall("UPDATE gudang SET lokasi='"+lokasi+"',id_admin='"+idAdmin+"'WHERE id='"+id +"'");
            stt.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
    
    public static boolean deleteData(GudangModel Id) throws Exception{
        try {
            GudangModel bM = Id;
            String id = bM.getId();
            
            PreparedStatement stt = Koneksi.Koneksi().prepareCall("DELETE FROM gudang WHERE id='"+id+"'");
            stt.executeUpdate();
            
        } catch (Exception e) {
            throw e;
        }
        return true;
    }
}
