package DB.DAO;

import DB.DTO.UserDTO;
import DB.Models.User;

import java.sql.*;
import java.util.List;

public class UserDAO implements User {
    private Connection connection;
    public UserDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<UserDTO> getUsers() throws SQLException {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) throws SQLException {
        String query = "INSERT INTO users(username, email, password) values (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, userDTO.getUsername());
        statement.setString(2, userDTO.getEmail());
        statement.setString(3, userDTO.getPassword());
        int rows = statement.executeUpdate();
        ResultSet result = statement.getGeneratedKeys();
        if(result.next() && result != null) {
            userDTO = new UserDTO();
            userDTO.setId(result.getLong("id"));
            userDTO.setUsername(result.getString("username"));
            userDTO.setEmail(result.getString("email"));
            userDTO.setPassword(result.getString("password"));
            return userDTO;
        }
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) throws SQLException {
        return null;
    }

    @Override
    public UserDTO getUserByEmailAndPassword(String email, String password) throws SQLException {
        String query = "select * from users where email=? and password=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if(result.next() && result != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(result.getLong("id"));
            userDTO.setUsername(result.getString("username"));
            userDTO.setEmail(result.getString("email"));
            userDTO.setPassword(result.getString("password"));
            return userDTO;
        }
        return null;
    }
}
