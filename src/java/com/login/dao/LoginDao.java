
package com.login.dao;

import com.login.DB.DBConnection;
import com.login.bean.LoginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
    
    public boolean validateLogin(LoginBean bean){
        
        String userName = bean.getUserName();
        String password = bean.getPassword();
        
        Connection con = DBConnection.createConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM Registration WHERE name=? AND password=?";
        
        try{
            
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, password);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                if(rs.getString("name").equals(userName) && rs.getString("password").equals(password))
                    return true;
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        return false;
    }
}
