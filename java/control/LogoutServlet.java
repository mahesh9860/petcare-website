package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			
		if((request.getSession().getAttribute("auth") != null)) {
			
			request.getSession().removeAttribute("auth ");
			response.sendRedirect("LOGIN.jsp");
		}
		else
		{
			response.sendRedirect("HOME.jsp");
		}
			
			
			
		}catch(Exception e)
		{
			
		
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session = request.getSession(false);
		    if (session != null) {
		      session.invalidate();
		    }
		    response.sendRedirect(request.getContextPath() + "/login.jsp");
		  }
	

}
