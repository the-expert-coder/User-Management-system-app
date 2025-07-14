package hibermainproject;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
@WebServlet("/upd")
public class updateservelet extends HttpServlet{

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{
		int id = Integer.parseInt(req.getParameter("id")); 
		String name= req.getParameter("name"); 
	 	String number= req.getParameter("number");
		String email= req.getParameter("email");
		
		SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
		Session s=sf.openSession(); 
		s.beginTransaction(); 
		
		Query q=s.createQuery("update Blog b set name=:n, number=:no, email=:e where id=:id"); 
		q.setParameter("id", id);
		q.setParameter("n", name); 
		q.setParameter("no", number); 
		q.setParameter("e",email);
		
		q.executeUpdate(); 
		s.getTransaction().commit();; 
		res.sendRedirect("bloginfo.jsp");
		
		
	}
}
