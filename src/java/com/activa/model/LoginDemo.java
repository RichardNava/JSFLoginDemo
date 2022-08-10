package com.activa.model;

import com.activa.db.DAO;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named(value = "loginDemo")
@SessionScoped
public class LoginDemo implements Serializable {

    private String userName;
    private String password;

    public LoginDemo() {
    }

    public String getUser() {
        return userName;
    }

    public void setUser(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        UserManager um = new UserManager();
        List<User> users = um.findUserByName(userName);
        if (!users.isEmpty()) {
            if (password.equals(users.get(0).getPassword())) {
                return "login";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }
    public String loginJDBC() {
        try {
            User user = new DAO().findUserByName(userName);       
            if (password.equals(user.getPassword())) return "login";
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "error";
    }
}
