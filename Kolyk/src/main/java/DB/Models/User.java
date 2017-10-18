package DB.Models;

import DB.DTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public interface User {
    public List<UserDTO> getUsers() throws SQLException;
    public UserDTO createUser(UserDTO userDTO) throws SQLException;
    public UserDTO getUserById(Long id) throws SQLException;
    public UserDTO getUserByEmailAndPassword(String email, String password) throws SQLException;
}
