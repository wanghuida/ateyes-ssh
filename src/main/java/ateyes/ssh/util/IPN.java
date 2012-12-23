package ateyes.ssh.util;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;

import org.apache.log4j.Logger;

public class IPN {
	
	private String verifyAddr;
	
	private Logger log;

	public IPN (String verifyAddr) {
		this.verifyAddr = verifyAddr;
		this.log = Logger.getLogger(IPN.class);
	}
	
	public void handle (HttpServletRequest req) {
		Enumeration en = req.getParameterNames();
		StringBuffer strBuffer = new StringBuffer();
		String name,val;
		while(en.hasMoreElements()) {
			name = (String) en.nextElement();
			val = req.getParameter(name);
			strBuffer.append("&").append(name).append("=").append(java.net.URLEncoder.encode(val));
		}			
		
		try {
			URL url = new URL("https://" + this.verifyAddr + "/cgi-bin/webscr");
			System.out.println(url);
			this.log.info(url.toString());
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Host", this.verifyAddr);
			PrintWriter pw = new PrintWriter(conn.getOutputStream());
			pw.println(strBuffer.toString());
			pw.close();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String res = in.readLine();
			in.close();
			
			if( res.toString().equals("VERIFIED") ) {
				this.fail(req);
			}else{
				this.success(req);
			}
		} catch (MalformedURLException e) {
			log.fatal(e.getMessage());
		} catch (IOException e) {
			log.fatal(e.getMessage());
		}

		
//		try {
//			BufferedReader postReader = req.getReader();
//			StringBuffer sb = new StringBuffer();
//			String tmp;
//			while ( (tmp = postReader.readLine()) != null ) {
//				sb.append(tmp);
//			}
//			
//			URL url = new URL (this.verifyAddr);
//			URLConnection conn = url.openConnection();
//			conn.setDoOutput(true);
//			OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
//			System.out.println(sb.toString());
//			writer.write(sb.toString());
//			writer.flush();
//			writer.close();
//			
//			InputStreamReader in = new InputStreamReader(conn.getInputStream());
//			BufferedReader reader = new BufferedReader(in);
//			sb = new StringBuffer();
//			tmp = null;
//			while ((tmp = reader.readLine()) != null) {
//				sb.append(tmp);
//			}
//			
//			if( sb.toString().equals("VERIFIED") ) {
//				this.fail(req);
//			}else{
//				this.success(req);
//			}
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//			log.fatal(e.getMessage());
//		}
	}
	
	private void fail (HttpServletRequest req) {
		System.out.println("process fail");
	}
	
	private void success (HttpServletRequest req) {
		System.out.println("process ok");
		System.out.println(req.getParameter("custom"));
	}
}
