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
		int id = Integer.parseInt(req.getParameter("id")); 
		String name= req.getParameter("name"); 
	 	String number= req.getParameter("number");
		String email= req.getParameter("email");
		
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
