package hibermainproject;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@WebServlet("/blogdata")
public class BlogServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
	{
		String idStr = req.getParameter("id").trim();
		int id = 0;
		try {
		    id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
		    // Redirect to error page or set default
		    res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid ID format");
		    return;
		}
		String name = req.getParameter("name").trim();
		String number = req.getParameter("number").trim();
		String email = req.getParameter("email").trim();

		
		Blog bo=new Blog(); 
		bo.setId(id);
		bo.setName(name);
		bo.setNumber(number); 
		bo.setEmail(email); 
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		Session s=sf.openSession(); 
		s.beginTransaction(); 
		s.save(bo); 
		s.getTransaction().commit();
		res.sendRedirect("bloginfo.jsp");
	}
	
	
}
