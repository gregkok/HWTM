package com.example.HWTM;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private DataSource dataSource;

    public UserRepository() {
    }


    public List<User> getAllUsers() {


        List<User> users = new ArrayList<>();
        try (Connection conn = dataSource.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM USERS")) {
            while (rs.next()) {
                users.add(rsUser(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public User rsUser(ResultSet rs) throws SQLException {
        return new User(rs.getLong("id"),
                rs.getString("first_Name"),
                rs.getString("last_Name"),
                rs.getString("userName"),
                rs.getString("email"),
                rs.getString("user_password"),
                rs.getString("address"),
                rs.getString("url"));

    }

    public void saveUser(User user) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO USERS (FIRST_NAME, LAST_NAME, USERNAME, USER_PASSWORD, ADDRESS, EMAIL, URL) values (?,?,?,?,?,?, ?)")) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getUser_password());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getEmail());
            ps.setString(7,user.getUrl());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUser(User user) {

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE USERS SET first_name = ?, last_name = ?, username = ?, user_password = ?, address = ?, email = ? WHERE id = ?")) {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getUser_password());
            ps.setString(5, user.getAddress());
            ps.setString(6, user.getEmail());
            ps.setLong(7, user.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getUserDetails(long id){

        List<User> allUsers = getAllUsers();

        for(User u : allUsers){
            if(u.getId() == id){
                return u;
            }
        }
        return null;
    }


}

