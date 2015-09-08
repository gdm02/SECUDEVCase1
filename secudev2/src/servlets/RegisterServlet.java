package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBManager;
import model.Account;
import model.RegisterData;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Boolean valid = true;
		
		String firstname, lastname, gender, salutation, birthdate, username,password, aboutme,accesslvl;
		firstname = lastname = gender = salutation = birthdate = username = password = aboutme = accesslvl = "";
		
		firstname = request.getParameter("firstname");
		lastname = request.getParameter("lastname");
		
		
		String gend = request.getParameter("gender");
		salutation = request.getParameter("salutation");
		
		if(gend.equals("male")){
			gender = "M";
			if(!RegisterData.maleSalutations.contains(salutation)){
				System.out.println("here");
				valid = false;
			}
		}
		else if(gend.equals("female")){
			gender = "F";
			if(!RegisterData.femaleSalutations.contains(salutation))
				valid = false;
		}
		
		else {
			System.out.println("invalid gender");
			valid = false;
		}
		
		birthdate = request.getParameter("birthdate");
		username = request.getParameter("username");
		password = request.getParameter("password");
		aboutme = request.getParameter("aboutme");
		
		String access = "User";
		accesslvl = "U";
		
		if(valid){
			Account newAccount = new Account();
			newAccount.setAbout(aboutme);
			newAccount.setFirstname(firstname);
			newAccount.setLastname(lastname);
			newAccount.setGender(gender);
			newAccount.setSalutation(salutation);
			newAccount.setBirthdate(birthdate);
			newAccount.setUsername(username);
			newAccount.setPassword(password);
			newAccount.setLevel(accesslvl);
			
			DBManager dbm = new DBManager();
			dbm.addAccount(newAccount);
			
			HttpSession session = request.getSession();
			session.setAttribute("fname", firstname);
			session.setAttribute("lname", lastname);
			session.setAttribute("gender", gend);
			session.setAttribute("salutation",salutation);
			session.setAttribute("birthdate", birthdate);
			session.setAttribute("username",username);
			session.setAttribute("password", password);
			session.setAttribute("aboutme", aboutme);
			session.setAttribute("accesslvl", access);
			
			response.sendRedirect("homepage.jsp");
			return;
		}
		else{
			System.out.println("Invalid request");
			response.sendRedirect("register.jsp");
		}
		//request.getRequestDispatcher("homepage.jsp").forward(request, response); 
		
	}

}
