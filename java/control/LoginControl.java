package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.singup;

/**
 * Servlet implementation class LoginControl
 */

@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			
			singup lobj=new singup();
			lobj.setEmail(email);
			lobj.setPassword(password);
			DAO.singupserviesimp rdao=new DAO.singupserviesimp();
			List<Model.singup> lst=new ArrayList<Model.singup>();
			lst.add(lobj);
			boolean b= rdao.validateUser(lst);
			if(b) {
				request.getSession().setAttribute(email, password);
				
				response.sendRedirect("pets.html");
				
			}else {
				HttpSession session= request.getSession();
				session.setAttribute("usernot Found",lobj);
				response.sendRedirect("LOGIN.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
