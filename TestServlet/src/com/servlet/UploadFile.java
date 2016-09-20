package com.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadFile
 */
@WebServlet("/UploadFile")
@MultipartConfig
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadFile() {
        super();
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
		PrintWriter out = response.getWriter();
		Part p = request.getPart("x");
		long a = p.getSize();
		String x = request.getParameter("xs");
		String z = getServletContext().getRealPath("/File")+"\\coba.rar";
		
		InputStream is = p.getInputStream();
		OutputStream os = new FileOutputStream(z);
		byte[] buffer = new byte[1024];
		int n = 0;
        while ((n = is.read(buffer)) != -1) {
            os.write(buffer, 0, n);
        }
        is.close();
        os.close();
        
//		String y = p.getHeader("content-disposition");
		
//		String zz = "";
//		for(String headerPart : y.split(";"))
//	    {
//	        if(headerPart.trim().startsWith("filename"))
//	        {
//	            zz = headerPart.substring(headerPart.indexOf('=') + 1).trim();
//	        }
//	    }
//		
		out.print(z);
	}

}
