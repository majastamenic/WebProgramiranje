package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Amenities;

import dao.AmenitiesDAO;

/**
 * Servlet implementation class IzmeniPogodnostServlet
 */
@WebServlet("/IzmeniPogodnostServlet")
public class IzmeniPogodnostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String idPogodnosti;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmeniPogodnostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		idPogodnosti = request.getParameter("id");
		if(idPogodnosti != null) {
			AmenitiesDAO.ucitajPogodnosti();
			Amenities pogodnost = AmenitiesDAO.findAmenitiesById(Integer.parseInt(idPogodnosti));
			
			request.setAttribute("naziv", pogodnost.getNaziv());
		}
		RequestDispatcher disp = request.getRequestDispatcher("/JSP/izmenaPogodnosti.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		idPogodnosti = request.getParameter("id");
		String naziv = request.getParameter("naziv");
		
		for(Amenities pogodnost:AmenitiesDAO.ucitajPogodnosti().values()) {
			if(pogodnost.getId().toString().equals(idPogodnosti)) {
				
				AmenitiesDAO.izmeniPogodnost(new Amenities(pogodnost.getId(), naziv));
				
			}
		}
		
		
	}

}
