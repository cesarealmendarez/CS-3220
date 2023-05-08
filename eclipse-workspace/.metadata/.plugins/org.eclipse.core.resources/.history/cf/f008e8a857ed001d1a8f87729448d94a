package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Vaccine;

@WebServlet(urlPatterns = "/FrontPage", loadOnStartup = 1)
public class FrontPage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public FrontPage() {
        super();
    }
    
    public void init( ServletConfig config ) throws ServletException {
    	super.init(config);
    	
    	getServletContext().removeAttribute("vaccines");
    	
    	Connection connection = null;
    		
    	try {
	      	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu02";
	      	
	      	String username = "cs3220stu02";
	      	
	      	String password = "Pn01IFHp50Sq";
	      	
	    	connection = DriverManager.getConnection(url, username, password);
	    	
	      	Statement selectVaccinesSTM = connection.createStatement();
	      	
	      	ResultSet selectVaccinesRS = selectVaccinesSTM.executeQuery("SELECT * FROM vaccines;");
	      	
	      	List<Vaccine> vaccines = new ArrayList<Vaccine>(); 
	      	
	      	while(selectVaccinesRS.next()) {	      		
	      		int vaccineID = selectVaccinesRS.getInt("id");
	      		
	      		String vaccineName = selectVaccinesRS.getString("name");
	      		
	      		int vaccineDosesRequired = selectVaccinesRS.getInt("dosesRequired");
	      		
	      		int vaccineDaysBetweenDoses = selectVaccinesRS.getInt("daysBetweenDoses");
	      		
	      		int vaccineDosesReceived = selectVaccinesRS.getInt("dosesReceived");
	      		
	      		int vaccineDosesLeft = selectVaccinesRS.getInt("dosesLeft");
	      		
	      		Vaccine vaccine = new Vaccine(vaccineID, vaccineName, vaccineDosesRequired, vaccineDaysBetweenDoses, vaccineDosesReceived, vaccineDosesLeft);
	      		
	      		vaccines.add(vaccine);
	      		
	      	}
	      	
//	      	System.out.println(vaccines.size());
	      	
	      	getServletContext().setAttribute("vaccines", vaccines);
    	} catch(Exception e) {
    		System.out.println(e);
    	}
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("FrontPage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}