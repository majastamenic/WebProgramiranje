package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Uloga;
import dao.ApartmanDAO;

/**
 * Servlet implementation class SortiraniApartmaniRastuceServlet
 */
@WebServlet("/SortiraniApartmaniRastuceServlet")
public class SortiraniApartmaniRastuceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortiraniApartmaniRastuceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ApartmanDAO.ucitajApartmane();
		
		if(LogInServlet.ulogovaniKorisnik.getUloga().equals(Uloga.Domacin))
			request.setAttribute("listaApartmana", ApartmanDAO.sortiranjePoCeniRastuceDomacin());
		else
			request.setAttribute("listaApartmana", ApartmanDAO.sortiranjePoCeniRastuce());
		
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledApartmanaSortiraniRastuce.jsp");
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
