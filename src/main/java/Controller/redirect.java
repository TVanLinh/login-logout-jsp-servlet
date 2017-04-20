package Controller;

import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by linhtran on 20/04/2017.
 */
@WebServlet(name = "redirect",urlPatterns = "/redirect")
public class redirect extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookie=req.getCookies();
        for(int i=0;i<cookie.length;i++)
        {
            System.out.println(cookie[i].getName()+" :  "+cookie[i].getValue());
        }
    //    req.re
        User user=new User();
        for(Cookie cookie1:cookie)
        {
            if(cookie1.getName().equals("user"))
            {
                user.setUserName(cookie1.getValue());
            }
            if(cookie1.getName().equals("pass"))
            {
                user.setPassWord(cookie1.getValue());
            }
        }
        System.out.println("name user "+user.getUserName());
        if(user.getUserName()!=null)
        {
            req.setAttribute("user",user.getUserName());
            req.setAttribute("pass",user.getPassWord());
            req.getRequestDispatcher("susscess.jsp").forward(req,resp);
        }
        else
        {
            resp.sendRedirect("index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
