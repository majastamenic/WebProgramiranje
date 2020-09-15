package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ApartmanDAO;

/**
 * Servlet implementation class AktivniApartmaniServlet
 */
@WebServlet("/AktivniApartmaniServlet")
public class AktivniApartmaniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AktivniApartmaniServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pretraga = request.getParameter("pretraga");
		ApartmanDAO.ucitajApartmane();
		request.setAttribute("mapaAktivnihApartmana", ApartmanDAO.aktivniApartmani());
		if(pretraga != null) {
			if(pretraga == "") {
				getServletContext().setAttribute("pretraga", null);
			}else {
				getServletContext().setAttribute("pretraga", pretraga);
			}
			RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledAktivnihApartmana.jsp");
			disp.forward(request, response);
		}else {
			RequestDispatcher disp = request.getRequestDispatcher("/JSP/pregledAktivnihApartmana.jsp");
			disp.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
