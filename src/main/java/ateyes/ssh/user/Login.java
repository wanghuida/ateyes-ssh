package ateyes.ssh.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        response.setContentType("text/html;charset=utf-8");

          PrintWriter out=response.getWriter();
          out.println("<html>");
          out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
          out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
          out.println("<HEAD><TITLE>用户信息</TITLE></HEAD>");
          out.println("<h1>你的信息如下：</h1>");
          out.println("<BODY>");
          out.println("<br>用户："+request.getParameter("username")+"<br>");
          out.println("<br>密码："+request.getParameter("password")+"<br>");  
          out.println("</BODY>");
          out.println("</html>");
          
          System.out.println(username);
          System.out.println(passwd);
    }

}
