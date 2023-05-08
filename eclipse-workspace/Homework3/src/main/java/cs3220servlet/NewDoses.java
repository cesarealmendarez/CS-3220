package cs3220servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NewDoses")
public class NewDoses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NewDoses() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NewDoses.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int vaccineID = Integer.parseInt(request.getParameter("newDosesVaccineID"));
		
		int vaccineDosesRecieved = Integer.parseInt(request.getParameter("newDosesAmount"));
		
		int vaccinesNewDosesRecieved = 0;
		int vaccinesNewLeftRecieved = 0;
		
			
		for (Vaccine vaccine : ((List<Vaccine>) getServletContext().getAttribute("vaccines"))) {
			if(vaccine.getId() == vaccineID) {
//				vaccine.setDosesLeft(vaccine.getDosesLeft() + vaccineDosesRecieved);
				vaccinesNewLeftRecieved = vaccine.getDosesLeft() + vaccineDosesRecieved;
				
//				vaccine.setDosesRecieved(vaccine.getDosesRecieved() + vaccineDosesRecieved);
				vaccinesNewDosesRecieved = vaccine.getDosesRecieved() + vaccineDosesRecieved;
				
//		        vaccine.setDosesLeft(vaccine.getDosesLeft() + vaccineDosesRecieved);
//		        vaccinesNewLeftRecieved = vaccine.getDosesLeft();
//		        
//		        vaccine.setDosesRecieved(vaccine.getDosesRecieved() + vaccineDosesRecieved);
//		        vaccinesNewDosesRecieved = vaccine.getDosesRecieved();
			}
		}
		
		Connection connection = null;
		
		try {
	      	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu02";
	      	
	      	String username = "cs3220stu02";
	      	
	      	String password = "Pn01IFHp50Sq";
	      	
	      	connection = DriverManager.getConnection(url, username, password);
	      	
	      	String updateVaccineDosesSTM = "UPDATE vaccines SET dosesReceived = ?, dosesLeft = ? WHERE id = ?";
	      	
	      	PreparedStatement updateVaccineDosesPSTM = connection.prepareStatement(updateVaccineDosesSTM);
	      	
	      	updateVaccineDosesPSTM.setInt(1, vaccinesNewDosesRecieved);
	      	updateVaccineDosesPSTM.setInt(2, vaccinesNewLeftRecieved);
	      	updateVaccineDosesPSTM.setInt(3, vaccineID);
	      	
	      	updateVaccineDosesPSTM.executeUpdate();
	      	
		} catch(Exception e) {
			System.out.println(e);
		}
		
		response.sendRedirect("ListVaccines");
		
	}

}
