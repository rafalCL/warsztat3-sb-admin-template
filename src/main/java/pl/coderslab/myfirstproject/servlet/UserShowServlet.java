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

@WebServlet(urlPatterns = "/user/show")
public class UserShowServlet extends HttpServlet {
    private UserDao userDao;

    public UserShowServlet() {
        try {
            this.userDao = new UserDao(DbUtil.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("user", userDao.readById(id));
            getServletContext().getRequestDispatcher("/template/show.jsp").forward(request, response);
            return;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/template/error.jsp").forward(request, response);
    }
}
