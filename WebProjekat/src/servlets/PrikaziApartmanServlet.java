package servlets;


import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Apartman;
import dao.ApartmanDAO;

/**
 * Servlet implementation class PrikaziApartmanServlet
 */
@WebServlet("/PrikaziApartmanServlet")
public class PrikaziApartmanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ApartmanDAO apartmandao= new ApartmanDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikaziApartmanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stu
		apartmandao.ucitajApartmane();
		Collection<Apartman> apartmani= apartmandao.findAll();
		request.setAttribute("listaApartmana", apartmandao.findAll());
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledApartmana.jsp");
		disp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
