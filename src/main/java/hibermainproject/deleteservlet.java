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
@WebServlet("/del") 
public class deleteservlet extends HttpServlet {
@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException 
	{ 
		int id=Integer.parseInt(req.getParameter("id")); 
		SessionFactory sf=new Configuration().configure().buildSessionFactory(); 
		Session s=sf.openSession(); 
		s.beginTransaction(); 
		Query q=s.createQuery("delete from Blog b where b.id=:id");
		q.setParameter("id",id); 
		q.executeUpdate(); 
		s.getTransaction().commit();
		res.sendRedirect("bloginfo.jsp");
		
		
	} 
}
