package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.singupserviesimp;
import Model.singup;


/**
 * Servlet implementation class singupControl
 */
@MultipartConfig
@WebServlet("/singupControl")

public class singupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public singupControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		PrintWriter out=response.getWriter();
		
		
//		fetch all form data
		
		String check=request.getParameter("check");
		if(check==null)
		{
			out.println("box not checked...");
		}
		else {
		//data 
		String UserName=request.getParameter("username");
		String PhoneNo=request.getParameter("phoneno");
		String email=request.getParameter("email");
		String Password=request.getParameter("password");
		
//		create user object and set all data to that object
		singup man=new singup();
		man.setUsername(UserName);
		man.setPhoneno(PhoneNo);
		man.setEmail(email);
		man.setPassword(Password);
		
		
		System.out.println("Welcome to petcare");
		
//		out.println("Welcome to Our Website "+UserName+"");
//		out.println("Registration Succesfully...");
		
//		create and call the data of object signup
		List<singup> lst=new ArrayList<singup>();
		lst.add(man);
		
		//create serviceImpl object.....
		singupserviesimp rdao=new singupserviesimp();
		int i=rdao.create(lst);
//		condition i is greater than 0 value is pass to redirect to the login page
		if(i>0) {
			out.println("done");
//			out.println("<a href='LOGIN.jsp'>Click Here</a>");
			//response.sendRedirect("LOGIN.jsp");
			System.out.println("data save");
			
			
		}
		 
			else {
				
				out.println("error");
				}
			}
		
			
	}

}
