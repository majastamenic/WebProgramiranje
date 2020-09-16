package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Apartman;
import beans.Domacin;
import beans.Lokacija;
import beans.StatusApartman;
import beans.TipApartmana;
import dao.ApartmanDAO;

/**
 * Servlet implementation class IzmenaApartmanaServlet
 */
@WebServlet("/IzmenaApartmanaServlet")
public class IzmenaApartmanaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String idApartmana;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IzmenaApartmanaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idApartmana = request.getParameter("id");
		
		if(idApartmana!=null) {
			Apartman apartman = ApartmanDAO.findApartmentById(Integer.parseInt(idApartmana));
			request.setAttribute("brojSoba", apartman.getBrojSoba());
			request.setAttribute("brojGostiju", apartman.getBrojGostiju());
			request.setAttribute("cenaPoNoci", apartman.getCenaPoNoci());
			RequestDispatcher disp = request.getRequestDispatcher("/JSP/izmenaApartmana.jsp");
			disp.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		Integer id = Integer.parseInt(idApartmana);
		TipApartmana tip = TipApartmana.valueOf(request.getParameter("tip"));
		int brojSoba = Integer.parseInt(request.getParameter("brojSoba"));
		int brojGostiju = Integer.parseInt(request.getParameter("brojGostiju"));;
		Lokacija lokacija = ApartmanDAO.findApartmentById(id).getLokacija();
		Date datumZaIzdavanje = ApartmanDAO.findApartmentById(id).getDatumZaIzdavanje();
		Domacin domacin = ApartmanDAO.findApartmentById(id).getDomacin();
		float cenaPoNoci = Float.parseFloat(request.getParameter("cenaPoNoci"));
		String vremeZaPrijavu = request.getParameter("vremeZaPrijavu");
		String vremeZaOdjavu = request.getParameter("vremeZaOdjavu");
		StatusApartman status = StatusApartman.valueOf(request.getParameter("status"));

		
		Apartman a = new Apartman(id, tip, brojSoba, brojGostiju, lokacija, datumZaIzdavanje,
				  domacin, cenaPoNoci,
				 vremeZaPrijavu, vremeZaOdjavu, status);
		ApartmanDAO.izmeniApartman(a);
		
		
	}

}
