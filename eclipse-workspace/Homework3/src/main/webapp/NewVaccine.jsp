<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>New Vaccine</title>
	</head>
	<body>
		<div style="margin-left: 40px;">
			<form action="NewVaccine" method="post">
	        	<table border="1" cellpadding="5" cellspacing="2">
	            	<tbody>
		                <tr>
		                    <th>Name</th>
		                    <td><input type="text" name="newVaccineName"></td>
		                </tr>
		                <tr>
		                    <th>Doses Required</th>
		                    <td><select name="newVaccineDosesRequired">
		                            <option>2</option>
		                            <option>1</option>
		                        </select>
		                    </td>
		                </tr>
		                <tr>
		                    <th>Days Between Doses</th>
		                    <td><input type="text" name="vaccineDaysBetweenDoses"></td>
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


