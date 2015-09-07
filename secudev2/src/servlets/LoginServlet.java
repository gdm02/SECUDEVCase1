package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import db.DBConn;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		System.out.println("logging");
		HttpSession session = request.getSession();
		
		String username, password;
		username = request.getParameter("username");
		password = request.getParameter("password");
		
		Statement stmt = null;
		String sql = "";
		ResultSet rs;
		
		boolean exists = false;
		try {
			Connection con = DBConn.getConnection();
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sql = "SELECT fname,lname,gender,salutation,birthdate,username,password,about,level FROM accounts";
		try {
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs);
				if (username.equals(rs.getString(Account.USERNAME_col)) && password.equals(rs.getString(Account.PASSWORD_col))) {
					System.out.println(username + " exists");
					exists = true;
					session.setAttribute("fname", rs.getString(Account.FIRSTNAME_col));
					session.setAttribute("lname", rs.getString(Account.LASTNAME_col));
					String gender = rs.getString(Account.GENDER_col);
					String gend = "";
					if(gender.equals("M"))
						gend = "Male";
					else
						gend = "Female";
					session.setAttribute("gender", gend);
					session.setAttribute("salutation", rs.getString(Account.SALUTATION_col));
					session.setAttribute("birthdate", rs.getString(Account.BIRTHDATE_col));
					session.setAttribute("username", rs.getString(Account.USERNAME_col));
					session.setAttribute("password", rs.getString(Account.PASSWORD_col));
					session.setAttribute("aboutme", rs.getString(Account.ABOUT_col));
					String access = rs.getString(Account.LEVEL_col);
					String accesslvl = "";
					if(access.equals("A"))
						accesslvl = "Admin";
					else
						accesslvl = "User";
					session.setAttribute("accesslvl", accesslvl);
					response.sendRedirect("homepage.jsp");
					return;
					//request.getRequestDispatcher("homepage.jsp").forward(request, response);  
				}
			}
			
			if (!exists) {
				System.out.println("Account does not exist.");
				response.sendRedirect("login.jsp");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
