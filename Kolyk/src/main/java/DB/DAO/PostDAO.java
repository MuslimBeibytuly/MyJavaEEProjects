package DB.DAO;

import DB.DTO.PostDTO;
import DB.DTO.UserDTO;
import DB.Models.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO implements Post {
    private Connection connection;
    public PostDAO(Connection connection) {
        this.connection = connection;
    }
    @Override
    public List<PostDTO> getPosts() throws SQLException {
        String query = "SELECT * FROM kolyk.posts";
        PreparedStatement statement = this.connection.prepareStatement(query);
        ResultSet result = statement.executeQuery();
        List<PostDTO> postDTOs = new ArrayList<>();
        PostDTO postDTO;
        while(result.next()) {
            postDTO = new PostDTO();
            postDTO.setId(result.getLong("id"));
            postDTO.setTitle(result.getString("title"));
            postDTO.setBody(result.getString("body"));
            postDTO.setCity(result.getString("city"));
            postDTO.setPrice(Integer.parseInt(result.getString("price")));
            postDTO.setAge(Integer.parseInt(result.getString("age")));
            postDTO.setUserId(Long.valueOf(result.getString("userId")));
            postDTOs.add(postDTO);
        }
        System.out.println(postDTOs.size());
        return postDTOs;
    }

    @Override
    public PostDTO getPostById(Long id) throws SQLException {
        return null;
    }

    @Override
    public PostDTO createPost(PostDTO postDTO) throws SQLException {
        String query = "INSERT INTO posts(title, body, city, price, age, date, userId) values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, postDTO.getTitle());
        statement.setString(2, postDTO.getBody());
        statement.setString(3, postDTO.getCity());
        statement.setString(4, String.valueOf(postDTO.getPrice()));
        statement.setString(5, String.valueOf(postDTO.getAge()));
        statement.setString(6, String.valueOf(postDTO.getDate()));
        statement.setString(7, String.valueOf(postDTO.getUserId()));

        int rows = statement.executeUpdate();
        ResultSet result = statement.getGeneratedKeys();
        if(result.next() && result != null) {
            postDTO = new PostDTO();
            postDTO.setId(result.getLong("id"));
            postDTO.setTitle(result.getString("title"));
            postDTO.setBody(result.getString("body"));
            postDTO.setCity(result.getString("city"));
            postDTO.setPrice(Integer.parseInt(result.getString("price")));
            postDTO.setAge(Integer.parseInt(result.getString("age")));
            postDTO.setUserId(Long.valueOf(result.getString("userId")));
            return postDTO;
        }
        return null;
    }
}
