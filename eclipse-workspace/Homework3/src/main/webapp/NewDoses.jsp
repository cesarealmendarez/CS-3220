<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>New Doses</title>
	</head>
	<body>
		<div style="margin-left: 40px;">
			<form action="NewDoses" method="post">		
		        <table border="1" cellpadding="5" cellspacing="2">
		            <tbody>
		                <tr>
		                    <th>Vaccine</th>
		                    <td><select name="newDosesVaccineID">
		                    		<c:forEach items="${vaccines}" var="vaccine">
		                            	<option value="${vaccine.id}">${vaccine.name}</option>
		                            </c:forEach>
		                        </select>
		                    </td>
		                </tr>
		                <tr>
		                    <th>New Doses Received</th>
		                    <td><input type="text" name="newDosesAmount"></td>
		                </tr>
		                <tr>
		                    <td colspan="2" scope="row">
		                    	<input type="submit" name="add" value="Add" />
		                    </td>
		                </tr>
		            </tbody>
		        </table>
			</form>
	    </div>	
	</body>
</html>




