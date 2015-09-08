package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<Account> getAccounts(){
		String query = "SELECT fname,lname,gender,salutation,birthdate,username,password,about,level FROM accounts";
		ArrayList<Account> accounts = new ArrayList<Account>();
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Account acc = new Account();
				acc.setId(Account.ID_col);
				acc.setFirstname(Account.FIRSTNAME_col);
				acc.setLastname(Account.LASTNAME_col);
				acc.setBirthdate(Account.BIRTHDATE_col);
				acc.setGender(Account.GENDER_col);
				acc.setUsername(Account.USERNAME_col);
				acc.setPassword(Account.PASSWORD_col);
				acc.setAbout(Account.ABOUT_col);
				acc.setSalutation(Account.SALUTATION_col);
				acc.setLevel(Account.LEVEL_col);
				accounts.add(acc);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accounts;
	}
	
}
