/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

/**
 *
 * @author Maria
 */
import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Koneksi {
    private static Connection koneksi;
    /**
    * Membuat koneksi ke database
    * @return koneski yang telah diatur ke database
    */
    public static Connection Koneksi() {
        if(koneksi == null) {
            try {
                MysqlDataSource dataSource = new MysqlDataSource();

                dataSource.setServerName("localhost");
                dataSource.setPort(8111);
                dataSource.setDatabaseName("db_gudang");
                dataSource.setUser("root");
                dataSource.setPassword("");
                
                koneksi = dataSource.getConnection();
            } catch(SQLException se){
                se.printStackTrace();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return koneksi;
    }
}