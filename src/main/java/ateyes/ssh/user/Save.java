package ateyes.ssh.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class Save
 */
public class Save extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    private Logger log;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save() {
        super();
        this.log = Logger.getLogger(Save.class);
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String rdbPath = null; 
        try {
            URL rdb = this.getClass().getClassLoader().getResource("ssh.rdb");
            rdbPath = rdb.toURI().getRawPath();
            log.info(rdbPath);
            
            Class.forName("org.sqlite.JDBC");
        } catch (URISyntaxException e) {
            log.fatal(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.fatal(e.getMessage());
        }   
        
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        String passwd2 = request.getParameter("passwd2");
        if (!passwd.equals(passwd2)) {
            response.sendRedirect("register.jsp");
            return;
        }
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:" + rdbPath);            
            String sql = "insert into user (username,passwd) values (?,?);";
            PreparedStatement stat = conn.prepareStatement(sql);   
            stat.setString(1, username);
            stat.setString(2, passwd);
            stat.execute();
            conn.close();   
        } catch (SQLException e) {
            log.fatal(e.getMessage());
        }   
        request.setAttribute("success", "恭喜，成功注册用户！");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
