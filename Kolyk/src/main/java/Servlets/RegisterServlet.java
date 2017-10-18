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

@WebServlet("/register/")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public RegisterServlet() {
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
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        if (username.length() > 0 && email.length() > 0
                && password.length() > 0 && repassword.length() > 0
                && (password).equals(repassword)) {
            UserDTO userDTO = new UserDTO(username, email, password);
            try {
                userDTO = userDAO.createUser(userDTO);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (userDTO != null) {
                HttpSession session = request.getSession();
                session.setAttribute("username", userDTO.getUsername());
                response.sendRedirect("/");
            } else {
                request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
        }
    }
}
