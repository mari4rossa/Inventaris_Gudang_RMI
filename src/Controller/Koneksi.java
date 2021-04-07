
package Controller;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

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
                dataSource.setDatabaseName("db_gudang");
                dataSource.setUser("root");
                dataSource.setPassword("Matiu5252");
                
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