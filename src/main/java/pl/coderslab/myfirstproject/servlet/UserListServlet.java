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

@WebServlet(urlPatterns = "/user/list")
public class UserListServlet extends HttpServlet {
    private UserDao userDao;

    public UserListServlet() {
        try {
            this.userDao = new UserDao(DbUtil.getConnection());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("users", userDao.readAll());
        } catch (SQLException e) {
            request.setAttribute("users", List.of());
        }

        getServletContext().getRequestDispatcher("/template/list.jsp").forward(request, response);
    }
}
