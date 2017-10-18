package Servlets;

import DB.DAO.PostDAO;
import DB.DAO.UserDAO;
import DB.DBManager;
import DB.DTO.PostDTO;
import Exceptions.DBException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("")
public class MainServlet extends HttpServlet {
    public MainServlet() {
        super();
    }

    private List<PostDTO> postDTOs;
    private Connection connection;
    private PostDAO postDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        Connection connection = null;

        try {
            connection = DBManager.connect();
        } catch (DBException e) {
            e.printStackTrace();
        }
        postDAO = new PostDAO(connection);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("username in main servlet: " + session.getAttribute("username"));
        if (session.getAttribute("username") != null) {
            request.setAttribute("username", session.getAttribute("username"));
        }

        postDTOs = new ArrayList<>();
        try {
            postDTOs = postDAO.getPosts();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for(PostDTO postDTO:postDTOs){
            System.out.println(postDTO.getTitle());
            System.out.println(postDTO.getBody());
            System.out.println(postDTO.getAge());
            System.out.println(postDTO.getCity());
            System.out.println(postDTO.getDate());
            System.out.println(postDTO.getPrice());
            System.out.println(postDTO.getUserId());
        }
        request.setAttribute("postDTOs", postDTOs);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
