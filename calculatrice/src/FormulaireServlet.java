

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormulaireServlet
 */
@WebServlet("/FormulaireServlet")
public class FormulaireServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormulaireServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operande1 = request.getParameter("operande1");
		String operande2 = request.getParameter("operande2");
		String operation = request.getParameter("operation");
		double resultat = 0;
		
		if (operande1 == null || operande1.equals("") || operande2 == null || operande2.equals("") || operation == null || operation.equals("")) {
			request.setAttribute("erreur", "Veuillez remplir tous les champs.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/erreur.jsp");
			dispatcher.forward(request, response);
		} else {
			double op1 = Double.parseDouble(operande1);
			double op2 = Double.parseDouble(operande2);
			
			switch (operation) {
				case "addition":
					resultat = op1 + op2;
					break;
				case "soustraction":
					resultat = op1 - op2;
					break;
				case "multiplication":
					resultat = op1 * op2;
					break;
				case "division":
					resultat = op1 / op2;
					break;
			}
			
			request.setAttribute("resultat", resultat);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/response.jsp");
			dispatcher.forward(request, response);
		}
	}
}
		
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
