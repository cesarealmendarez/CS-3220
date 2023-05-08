package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import java.util.Date;


import models.PatientViewModel;
import models.Vaccine;

@WebServlet("/NewPatient")
public class NewPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewPatient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("NewPatient.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int newPatientID = 3;
		int newPatientID = (((List<PatientViewModel>) getServletContext().getAttribute("patients")).get(((List<PatientViewModel>) getServletContext().getAttribute("patients")).size() - 1).getId() + 1);
		
		String newPatientName = request.getParameter("newPatientName");
		
		int newPatientVaccineID = Integer.parseInt(request.getParameter("newPatientVaccineID"));
		
		String newPatientVaccineName = "";
				
		int newPatientVaccineDosesRequired = 0;
		
		int newPatientVaccineDosesLeft = 0;
		
//		Date newPatientFirstDoseDate = new Date();
		java.util.Date utilDate = new java.util.Date(); // Create a new java.util.Date object representing the current time
		long milliseconds = utilDate.getTime(); // Get the number of milliseconds since January 1, 1970, 00:00:00 GMT
		java.sql.Date sqlDate = new java.sql.Date(milliseconds); // Create a new java.sql.Date object representing the current date and time

		
		for (Vaccine vaccine : ((List<Vaccine>) getServletContext().getAttribute("vaccines"))) {
		    if(vaccine.getId() == newPatientVaccineID) {
		    	newPatientVaccineName = vaccine.getName();
		    	
		    	newPatientVaccineDosesRequired = vaccine.getDosesRequired();
		    	
		    	newPatientVaccineDosesLeft = vaccine.getDosesLeft();
		    	
		    	break;
		    }
		}
		
        Connection connection = null;
        
        try {
	      	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu02";
	      	
	      	String username = "cs3220stu02";
	      	
	      	String password = "Pn01IFHp50Sq";
	      		
	      	connection = DriverManager.getConnection(url, username, password);
	      	
	      	String insertPatientSTM  = "INSERT INTO patients (name, vaccineID, firstDoseDate, secondDoseDate) VALUES (?, ?, ?, ?);";

	      	PreparedStatement insertPatientPSTM = connection.prepareStatement(insertPatientSTM);
	      	
	      	insertPatientPSTM.setString(1, newPatientName);
	      	insertPatientPSTM.setInt(2, newPatientVaccineID);
	      	insertPatientPSTM.setDate(3, sqlDate);
	      	insertPatientPSTM.setNull(4, java.sql.Types.INTEGER);
	      	
	      	insertPatientPSTM.executeUpdate();
	      	
	      	insertPatientPSTM.close();
	      	
        } catch(Exception e) {
        	System.out.println(e);
        }
		
		PatientViewModel patientViewModel = new PatientViewModel(newPatientID, newPatientName, newPatientVaccineID, newPatientVaccineName, newPatientVaccineDosesRequired, newPatientVaccineDosesLeft, sqlDate, null);
		
		((List<PatientViewModel>) getServletContext().getAttribute("patients")).add(patientViewModel);
		
		response.sendRedirect("ListPatients");
	}

}
