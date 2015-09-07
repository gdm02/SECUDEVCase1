package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class DBManager {

	public void addAccount(Account newAccount){
		String query = "INSERT INTO accounts (fname,lname,gender,salutation,birthdate,username,password,about,level) VALUES("
						+ "'" + newAccount.getFirstname() + "',"
						+ "'" + newAccount.getLastname() + "',"
						+ "'" + newAccount.getGender() + "',"
						+ "'" + newAccount.getSalutation() + "',"
						+ "'" + newAccount.getBirthdate() + "',"
						+ "'" + newAccount.getUsername() + "',"
						+ "'" + newAccount.getPassword() + "',"
						+ "'" + newAccount.getAbout() + "',"
						+ "'" + newAccount.getLevel() + "')";
		try{
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(query);
			pstmt.executeUpdate();
			conn.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Account getAccount(String user, String pass){
		String query = "SELECT id,fname,lname,salutation,level FROM accounts WHERE username = ? AND password = ?";
		Account acc = null;
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(query);
			pstmt.setString(1, user);
			pstmt.setString(2, pass);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				acc = new Account();
				acc.setId(Account.ID_col);
				acc.setFirstname(Account.FIRSTNAME_col);
				acc.setLastname(Account.LASTNAME_col);
				acc.setSalutation(Account.SALUTATION_col);
				acc.setLevel(Account.LEVEL_col);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return acc;
	}
	
}
