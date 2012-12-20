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
import java.sql.Statement;

import java.net.URISyntaxException;
import java.net.URL;
import java.net.URI;

/**
 * Servlet implementation class Save
 */
public class Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Save() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().print("cao");
		
		URL rdb = this.getClass().getClassLoader().getResource("ssh.rdb");
		String rdbPath = null; 
		try {
			rdbPath = rdb.toURI().getRawPath();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}   
		
        Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:" + rdbPath);	        
			Statement stat = conn.createStatement();   
	        stat.executeUpdate("insert into user (username,passwd) values ('wanghuida3', '63137246');");   
	        //conn.commit();   	        
	        //ResultSet rs = stat.executeQuery("select * from people;");   
	        //while (rs.next()) {   
	        //    System.out.println("name = " + rs.getString("name"));   
	        //    System.out.println("occupation = " + rs.getString("occupation"));   
	        //}   
	        //rs.close();   
		    conn.close();   
		} catch (SQLException e) {
			e.printStackTrace();
		}   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
