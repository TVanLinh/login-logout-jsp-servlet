package Controller;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import  Model.*;
/**
 * Created by linhtran on 20/04/2017.
 */
public class XuLyNguoiDung extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        xyLyDangNhap(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        xyLyDangNhap(req, resp);
    }

    private void xyLyDangNhap(HttpServletRequest request,HttpServletResponse response) throws IOException ,ServletException{
        String action=request.getParameter("action");
        String userName=request.getParameter("user_name");
        String pass_word=request.getParameter("pass_word");
        String remember =request.getParameter("remember");
       // System.out.println(remember);
        if(action.equals("login"))
        {
            if(userName.equals("linh")&&pass_word.equals("123456"))
            {
                HttpSession session=request.getSession();
                User user=new User(userName,pass_word);
                session.setAttribute("user",user);
                request.setAttribute("user_name",userName);
                if(remember!=null)
                {
                   // response.addCookie(new Cookie("remember","remember"));
                    response.addCookie(new Cookie("user",userName));
                    response.addCookie(new Cookie("pass",pass_word));
                    System.out.println("ok");
                }
                request.getRequestDispatcher("susscess.jsp").forward(request,response);
            }
            else
            {
                request.setAttribute("error","username or password not correct");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }

        if(action.equals("logout"))
        {
            HttpSession session=request.getSession();
            if(!session.isNew())
            {
                session.removeAttribute("user");
                System.out.println("log out");
//                request.getRequestDispatcher("index.jsp").forward(request,response);
                response.sendRedirect("index.jsp");
            }
        }
    }


}
