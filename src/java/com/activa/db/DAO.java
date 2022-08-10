/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.activa.db;

import com.activa.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author richa
 */
public class DAO {

    public User findUserByName(String consulta) throws SQLException {
        User user = new User();
        try ( Connection con
                = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "")) {
            String sql = "SELECT * FROM user WHERE name=?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, consulta);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                user.setName(rs.getString("Name"));
                user.setPassword(rs.getString("Password"));
            }
        }
        return user;
    }

}
