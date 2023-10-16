package pl.coderslab.myfirstproject.servlet;

import pl.coderslab.myfirstproject.dao.UserDao;
import pl.coderslab.myfirstproject.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/user/add")
public class UserAddServlet extends HttpServlet {
    private UserDao userDao;

    public UserAddServlet() {
        try {
            this.userDao = new UserDao(DbUtil.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            getServletContext().getRequestDispatcher("/template/add.jsp").forward(request, response);
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }

        getServletContext().getRequestDispatcher("/template/error.jsp").forward(request, response);
    }
}
