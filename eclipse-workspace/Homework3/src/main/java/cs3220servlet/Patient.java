package cs3220servlet;


import java.util.Date;

public class Patient {
	
	private int id;
	
    private String name;
    
    private int vaccineID;
    
    private Date firstDoseDate;
    
    private Date secondDoseDate;
    
	public Patient(int id, String name, int vaccineID, Date firstDoseDate, Date secondDoseDate) {
		
		this.id = id;
		
		this.name = name;
		
		this.vaccineID = vaccineID;
		
		this.firstDoseDate = firstDoseDate;
		
		this.secondDoseDate = secondDoseDate;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVaccineID() {
		return vaccineID;
	}

	public void setVaccineID(int vaccineID) {
		this.vaccineID = vaccineID;
	}

	public Date getFirstDoseDate() {
		return firstDoseDate;
	}

	public void setFirstDoseDate(Date firstDoseDate) {
		this.firstDoseDate = firstDoseDate;
	}

	public Date getSecondDoseDate() {
		return secondDoseDate;
	}

	public void setSecondDoseDate(Date secondDoseDate) {
		this.secondDoseDate = secondDoseDate;
	}	
}
