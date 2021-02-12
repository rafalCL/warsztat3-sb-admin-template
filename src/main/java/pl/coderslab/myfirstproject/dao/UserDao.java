package pl.coderslab.myfirstproject.dao;

import pl.coderslab.myfirstproject.model.User;
import pl.coderslab.myfirstproject.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> readAll() throws SQLException {
        List<User> result = new ArrayList<>();

        try(Connection c = DbUtil.getConnection();
            PreparedStatement ps = c.prepareStatement("SELECT id, userName, password, email FROM users;");
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                result.add(new User(rs.getInt("id"), rs.getString("userName"),
                        rs.getString("email"), rs.getString("password")));
            }
        }

        return result;
    }
}
