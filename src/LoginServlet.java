

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import UserClass.User;


@WebServlet("/LoginServletPath")


//controller
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userId, passward;
		
		userId = request.getParameter("userId");
		passward = request.getParameter("userPassward");

		
		LoginService loginService = new LoginService();
		boolean result =  loginService.authenticate(userId, passward);
		
		
		
		//model
		if(result)
		{
			User user = (User) loginService.getUserDetails(userId);
			
			request.getSession().setAttribute("userobj", user);
			response.sendRedirect("success.jsp");
			//if you want to redirect to other servlet then you have to specify path of that servlet in above method
			
		}
		else
		{
			response.sendRedirect("loginform.jsp");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
