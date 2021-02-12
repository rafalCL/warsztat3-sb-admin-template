package pl.coderslab.myfirstproject.servlet;

import pl.coderslab.myfirstproject.dao.UserDao;
import pl.coderslab.myfirstproject.model.User;
import pl.coderslab.myfirstproject.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UserList", urlPatterns = "/user/list")
public class UserListServlet extends HttpServlet {
    private UserDao userDao;

    public UserListServlet() {
        this.userDao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<User> users = this.userDao.readAll();
            request.setAttribute("users", users);
            request.setAttribute("user", users.get(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/WEB-INF/user/list.jsp").forward(request, response);
    }
}
