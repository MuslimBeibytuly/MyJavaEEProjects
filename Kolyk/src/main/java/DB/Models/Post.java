package DB.Models;

import DB.DTO.PostDTO;

import java.sql.SQLException;
import java.util.List;

public interface Post {
    public List<PostDTO> getPosts() throws SQLException;
    public PostDTO getPostById(Long id) throws SQLException;
    public PostDTO createPost(PostDTO postDTO) throws SQLException;

}
