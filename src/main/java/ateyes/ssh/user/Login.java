package ateyes.ssh.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.apache.log4j.Logger;

import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Logger log;
    /**
     * Default constructor. 
     */
    public Login() {
    	super();
    	this.log = Logger.getLogger(Login.class);
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
        //request.setCharacterEncoding("UTF-8");
        //response.setCharacterEncoding("utf-8");
    	String rdbPath = null;
    	try {
	    	URL rdb = this.getClass().getClassLoader().getResource("ssh.rdb");
			rdbPath = rdb.toURI().getPath();
            log.info(rdbPath);
            
            Class.forName("org.sqlite.JDBC");
		} catch (URISyntaxException e) {
			log.fatal(e.getMessage());
		} catch (ClassNotFoundException e) {
			log.fatal(e.getMessage());
		}
    	
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        
        try {
			Connection conn = DriverManager.getConnection("jdbc:sqlite:" + rdbPath);
			String sql = "select * from user where username = ? and passwd = ?;";
			PreparedStatement stat = conn.prepareStatement(sql);
			stat.setString(1, username);
			stat.setString(2, passwd);
			ResultSet result = stat.executeQuery();
			if (result.next()) {
				//todo: encryption
				Cookie cookie = new Cookie("ateyesuid",result.getString("username"));
				cookie.setMaxAge(86400 * 30);
				response.addCookie(cookie);
				response.sendRedirect("index.jsp");
			} else {
				request.setAttribute("error", "登陆失败，请输入正确的账号和密码");
		        request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			result.close();
			stat.close();
			conn.close();
			return;
		} catch (SQLException e) {
			log.fatal(e.getMessage());
		}
    }

}
