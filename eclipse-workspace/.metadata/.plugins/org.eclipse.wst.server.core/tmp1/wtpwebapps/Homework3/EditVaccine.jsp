<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit Vaccine</title>
	</head>
	<body>
		<div style="margin-left: 40px;">
			<form action="EditVaccine" method="post">
				<input type="hidden" name="editVaccineID" value="${param.id}">
		        <table border="1" cellpadding="5" cellspacing="2">
		            <tbody>
		                <tr>
		                    <th>Name</th>
		                    <td><input type="text" name="editVaccineName" value="${param.name}"></td>
		                </tr>
		                <tr>
		                    <th>Doses Required</th>
		                    <td>
		                    	<select name="editVaccineDosesRequired">
		                    		<c:if test="${param.dosesRequired == 1}">
		                    			<option selected="">1</option>
		                    			<option >2</option>
		                    		</c:if>
		                    		
		                    		<c:if test="${param.dosesRequired == 2}">
		                    			<option>1</option>
		                    			<option selected="">2</option>
		                    		</c:if>
		                        </select>
		                    </td>
		                </tr>
		                <tr>
		                    <th>Days Between Doses</th>
		                    <td><input type="text" name="editVaccineDaysBetweenDoses" value="${param.daysBetweenDoses}"></td>
		                </tr>
		                <tr>
		                    <td colspan="2" scope="row">
		                    	<input type="submit" name="add" value="Save" />
		                    </td>
		                </tr>
		            </tbody>
		        </table>
			</form>
	    </div>
	</body>
</html>