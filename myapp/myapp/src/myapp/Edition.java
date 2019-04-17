package myapp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class edition
 */
@WebServlet("/Edition")
public class Edition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edition() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			   throws IOException, ServletException
			{
			   String id = request.getParameter("id");
			   String name = request.getParameter("name");
			   String firstName = request.getParameter("firstName");
			   String birthday = request.getParameter("birthday");
			   String mail = request.getParameter("mail");
			  
			   /*Création d'une nouvelle personne et remplacement */
			   Person p = new Person();
			   Group group = new Group("Test",0);
			   p.initPerson(Integer.parseInt(id), name, firstName,birthday,mail, group);
			   request.getSession().setAttribute("person", p);
			   System.out.println(p);
			   
			   
			   request.getRequestDispatcher("edition.jsp").forward(request, response);
			}

}
