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
    private final Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    public List<User> readAll() throws SQLException {
        List<User> result = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement("SELECT id, userName, password, email FROM users;");
            ResultSet rs = ps.executeQuery()){
            while(rs.next()){
                result.add(new User(rs.getInt("id"), rs.getString("userName"),
                        rs.getString("email"), rs.getString("password")));
            }
        }

        return result;
    }

    public User readById(int id) throws SQLException {
        try(PreparedStatement ps = connection.prepareStatement("SELECT id, userName, password, email FROM users WHERE id = ?;")) {
            ps.setInt(1, id);
            try(ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(rs.getInt("id"), rs.getString("userName"),
                            rs.getString("email"), rs.getString("password"));
                }
            }
        }

        throw new SQLException("Data not present for id="+id);
    }
}
