<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>List Patients</title>
	</head>
	<body>
		<p style="margin-left: 40px;"><a href="NewPatient">New Patient</a></p>
		
		<div style="margin-left: 40px;">
	        <table border="1" cellpadding="5" cellspacing="2">
	            <thead>
	                <tr>
	                    <th>ID</th>
	                    <th>Name</th>
	                    <th>Vaccine</th>
	                    <th>1st Dose</th>
	                    <th>2nd Dose</th>
	                </tr>
	            </thead>
	            <tbody>
	            	<c:forEach items="${patients}" var="patient">
	            		<form action="ListPatients" method="post">
	            			<input type="hidden" name="patientID" value="${patient.id}"/>
	            			<input type="hidden" name="patientVaccineID" value="${patient.vaccineID}"/>
	            			<input type="hidden" name="patientVaccineDosesLeft" value="${patient.vaccineDosesLeft}"/>
			                <tr>
			                    <td>${patient.id}</td>
			                    <td>${patient.name}</td>
			                    <td>${patient.vaccineName}</td>
			                    <td>${patient.firstDoseDate}</td>
			                    
			                    <c:if test="${patient.vaccineDosesRequired > 1}">
			                    	<c:if test="${patient.secondDoseDate == null}">
			                    		<c:if test="${patient.vaccineDosesLeft > 0}">
			                    			<td>
			                    				<input type="submit" name="add" value="Received" />
			                    			</td>
			                    		</c:if>
			                    		
			                    		<c:if test="${patient.vaccineDosesLeft <= 0}">
			                    			<td>Out of Stock</td>
			                    		</c:if>
			                    	</c:if>	
			                    	
			                    	<c:if test="${patient.secondDoseDate != null}">
			                    		<td>${patient.secondDoseDate}</td>
			                    	</c:if>
			                    </c:if>
			                    
			                    <c:if test="${patient.vaccineDosesRequired <= 1}">
			                    	<td style="text-align: center;">-</td>
			                    </c:if>
			                </tr>
		                </form>
	                </c:forEach>
	            </tbody>
	        </table>
	    </div>		
	</body>
</html>