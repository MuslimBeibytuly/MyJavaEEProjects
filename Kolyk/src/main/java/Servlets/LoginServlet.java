package Servlets;

import DB.DAO.UserDAO;
import DB.DBManager;
import DB.DTO.UserDTO;
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
@WebServlet("/login/")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public LoginServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        Connection connection = null;

        try {
            connection = DBManager.connect();
        } catch (DBException e) {
            e.printStackTrace();
        }
        userDAO = new UserDAO(connection);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if(email.length() > 0 && password.length() > 0) {
            UserDTO userDTO = null;
            try {
                userDTO = userDAO.getUserByEmailAndPassword(email, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if(userDTO != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", userDTO.getUsername());
                response.sendRedirect("/");
            } else {
                request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }
}