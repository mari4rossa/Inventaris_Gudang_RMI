/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controller.Koneksi;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Model.UserModel;

/**
 *
 * @author Matius Andreatna
 */
public class UserDao {

    public static UserModel loadUser(UserModel userModel) throws Exception {
        List<UserModel> list = new ArrayList<>();
        try {
            String username = userModel.getUsername();
            String password = userModel.getPassword();
            
            String query = "SELECT * FROM user WHERE username='"+username+"' AND password='"+password+"'";
            PreparedStatement stt = Koneksi.Koneksi().prepareCall(query);
            ResultSet rs = stt.executeQuery();
            while (rs.next()) {
                if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    list.add(userModel);
                }
            }
            
        } catch (Exception e) {
            throw e;
        }
        return list.get(0);
    }
}
