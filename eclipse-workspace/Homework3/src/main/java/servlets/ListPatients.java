package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
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
import models.Patient;
import models.PatientViewModel;

@WebServlet("/ListPatients")
public class ListPatients extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ListPatients() {
        super();
    }
    
    public void init( ServletConfig config ) throws ServletException {
    	super.init(config);
    	
//    	getServletContext().removeAttribute("patients");
//    	
//    	Connection connection = null;
//		
//    	try {
//	      	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu02";
//	      	
//	      	String username = "cs3220stu02";
//	      	
//	      	String password = "Pn01IFHp50Sq";
//	      	
//	    	connection = DriverManager.getConnection(url, username, password);
//	    	
//	      	Statement selectPatientsSTM = connection.createStatement();
//	      	
//	      	ResultSet selectPatientsRS = selectPatientsSTM.executeQuery("SELECT * FROM patients;");
//	      	
//	      	List<PatientViewModel> patients = new ArrayList<PatientViewModel>(); 
//	      	
//	      	while(selectPatientsRS.next()) {
//	      		
//	      		int patientID = selectPatientsRS.getInt("id");
//	      		
//	      		String patientName = selectPatientsRS.getString("name");
//	      		
//	      		int patientVaccineID = selectPatientsRS.getInt("vaccineID");
//	      		
//	      		Date patientFirstDoseDate = selectPatientsRS.getDate("firstDoseDate");
//	      		
//	      		Date patientSecondDoseDate = selectPatientsRS.getDate("secondDoseDate");
//	      		
//	      		Statement selectPatientVaccineSTM = connection.createStatement();
//		      	
//		      	ResultSet selectPatientVaccineRS = selectPatientVaccineSTM.executeQuery("SELECT * FROM vaccines WHERE id = " + patientVaccineID + ";");
//		      	
//		      	String patientVaccineName = "";
//		      	int patientVaccineDosesRequired = 0;
//		      	int patientVaccineDaysBetweenDoses = 0;
//		      	int patientVaccineDosesReceived = 0;
//		      	int patientVaccineDosesLeft = 0;
//		      	
//		      	
//		      	while(selectPatientVaccineRS.next()) {
//		      		patientVaccineName = selectPatientVaccineRS.getString("name");
//		      		patientVaccineDosesRequired = selectPatientVaccineRS.getInt("dosesRequired");
//		      		patientVaccineDaysBetweenDoses = selectPatientVaccineRS.getInt("daysBetweenDoses");
//		      		patientVaccineDosesReceived = selectPatientVaccineRS.getInt("dosesReceived");
//		      		patientVaccineDosesLeft = selectPatientVaccineRS.getInt("dosesLeft");
//		      	}
//		      	
//		      	PatientViewModel patientViewModel = new PatientViewModel(patientID, patientName, patientVaccineID, patientVaccineName, patientVaccineDosesRequired, patientVaccineDosesLeft, patientFirstDoseDate, patientSecondDoseDate);
//		      	
//		      	patients.add(patientViewModel);
//		      
//	      	}
//	      	
////	      	System.out.println(patients.get(0).getId());
////	      	System.out.println(patients.get(0).getName());
////	      	System.out.println(patients.get(0).getVaccineName());
//	      	System.out.println(patients.get(1).getSecondDoseDate());
//	      	
//	      	getServletContext().setAttribute("patients", patients);
//    	} catch(Exception e) {
//    		System.out.println(e);
//    	}
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		getServletContext().removeAttribute("patients");
    	getServletContext().removeAttribute("patients");
    	
    	Connection connection = null;
		
    	try {
	      	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu02";
	      	
	      	String username = "cs3220stu02";
	      	
	      	String password = "Pn01IFHp50Sq";
	      	
	    	connection = DriverManager.getConnection(url, username, password);
	    	
	      	Statement selectPatientsSTM = connection.createStatement();
	      	
	      	ResultSet selectPatientsRS = selectPatientsSTM.executeQuery("SELECT * FROM patients;");
	      	
	      	List<PatientViewModel> patients = new ArrayList<PatientViewModel>(); 
	      	
	      	while(selectPatientsRS.next()) {
	      		
	      		int patientID = selectPatientsRS.getInt("id");
	      		
	      		String patientName = selectPatientsRS.getString("name");
	      		
	      		int patientVaccineID = selectPatientsRS.getInt("vaccineID");
	      		
	      		Date patientFirstDoseDate = selectPatientsRS.getDate("firstDoseDate");
	      		
	      		Date patientSecondDoseDate = selectPatientsRS.getDate("secondDoseDate");
	      		
	      		Statement selectPatientVaccineSTM = connection.createStatement();
		      	
		      	ResultSet selectPatientVaccineRS = selectPatientVaccineSTM.executeQuery("SELECT * FROM vaccines WHERE id = " + patientVaccineID + ";");
		      	
		      	String patientVaccineName = "";
		      	int patientVaccineDosesRequired = 0;
		      	int patientVaccineDaysBetweenDoses = 0;
		      	int patientVaccineDosesReceived = 0;
		      	int patientVaccineDosesLeft = 0;
		      	
		      	
		      	while(selectPatientVaccineRS.next()) {
		      		patientVaccineName = selectPatientVaccineRS.getString("name");
		      		patientVaccineDosesRequired = selectPatientVaccineRS.getInt("dosesRequired");
		      		patientVaccineDaysBetweenDoses = selectPatientVaccineRS.getInt("daysBetweenDoses");
		      		patientVaccineDosesReceived = selectPatientVaccineRS.getInt("dosesReceived");
		      		patientVaccineDosesLeft = selectPatientVaccineRS.getInt("dosesLeft");
		      	}
		      	
		      	PatientViewModel patientViewModel = new PatientViewModel(patientID, patientName, patientVaccineID, patientVaccineName, patientVaccineDosesRequired, patientVaccineDosesLeft, patientFirstDoseDate, patientSecondDoseDate);
		      	
		      	patients.add(patientViewModel);
		      
	      	}
	      	
//	      	System.out.println(patients.get(0).getId());
//	      	System.out.println(patients.get(0).getName());
//	      	System.out.println(patients.get(0).getVaccineName());
//	      	System.out.println(patients.get(1).getSecondDoseDate());
	      	
	      	getServletContext().setAttribute("patients", patients);
    	} catch(Exception e) {
    		System.out.println(e);
    	}		
		request.getRequestDispatcher("ListPatients.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int patientID = Integer.parseInt(request.getParameter("patientID"));
		
		int patientVaccineID = Integer.parseInt(request.getParameter("patientVaccineID"));
		
		int patientVaccineDosesLeft = Integer.parseInt(request.getParameter("patientVaccineDosesLeft"));
		
		java.util.Date utilDate = new java.util.Date(); // Create a new java.util.Date object representing the current time
		long milliseconds = utilDate.getTime(); // Get the number of milliseconds since January 1, 1970, 00:00:00 GMT
		java.sql.Date sqlDate = new java.sql.Date(milliseconds); // Create a new java.sql.Date object representing the current date and time
		
        Connection connection = null;
        
        try {
	      	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu02";
	      	
	      	String username = "cs3220stu02";
	      	
	      	String password = "Pn01IFHp50Sq";
	      		
	      	connection = DriverManager.getConnection(url, username, password);
	      	
	      	String updatePatientSTM = "UPDATE patients SET secondDoseDate = ? WHERE id = ?";
	      	
	      	PreparedStatement updatePatientPSTM = connection.prepareStatement(updatePatientSTM);
	      	
	      	updatePatientPSTM.setDate(1, sqlDate);
	      	updatePatientPSTM.setInt(2, patientID);
	      	
	      	updatePatientPSTM.executeUpdate();
	      	
	      	updatePatientPSTM.close();
	      	
	      	String updateVaccineSTM = "UPDATE vaccines SET dosesLeft = ? WHERE id = ?";
	      	
	      	PreparedStatement updateVaccinePSTM = connection.prepareStatement(updateVaccineSTM);
	      	
	      	updateVaccinePSTM.setInt(1, patientVaccineDosesLeft - 1);
	      	updateVaccinePSTM.setInt(2, patientVaccineID);
	      	
	      	updateVaccinePSTM.executeUpdate();
	      	
	      	updateVaccinePSTM.close();
	      	
        } catch(Exception e) {
        	System.out.println(e);
        }
        
        response.sendRedirect("ListPatients");
//		int patientID = Integer.parseInt(request.getParameter("patientID"));
//		
////		System.out.println(patientID);
//			
//		java.util.Date utilDate = new java.util.Date(); // Create a new java.util.Date object representing the current time
//		long milliseconds = utilDate.getTime(); // Get the number of milliseconds since January 1, 1970, 00:00:00 GMT
//		java.sql.Date sqlDate = new java.sql.Date(milliseconds); // Create a new java.sql.Date object representing the current date and time
//		
//		for (PatientViewModel patientViewModel : ((List<PatientViewModel>) getServletContext().getAttribute("patients"))) {
//			if(patientViewModel.getId() == patientID) {
//				System.out.println(patientViewModel.getSecondDoseDate());
//				patientViewModel.setSecondDoseDate(sqlDate);
//				System.out.println(patientViewModel.getSecondDoseDate());
//				
////				vaccine.setDosesLeft(vaccine.getDosesLeft() + vaccineDosesRecieved);
////				vaccinesNewLeftRecieved = vaccine.getDosesLeft() + vaccineDosesRecieved;
////				
////				vaccine.setDosesRecieved(vaccine.getDosesRecieved() + vaccineDosesRecieved);
////				vaccinesNewDosesRecieved = vaccine.getDosesRecieved() + vaccineDosesRecieved;
//			}
//		}
//		
//		response.sendRedirect("ListPatients");
	}
}