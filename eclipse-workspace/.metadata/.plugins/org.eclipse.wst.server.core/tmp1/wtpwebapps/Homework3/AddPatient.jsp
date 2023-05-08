<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Add Patient</title>
	</head>
	<body>
		<div style="margin-left: 40px;">
	        <table border="1" cellpadding="5" cellspacing="2">
	            <tbody>
	                <tr>
	                    <th>Patient</th>
	                    <td><input type="text"></td>
	                </tr>
	                <tr>
	                    <th>Vaccine</th>
	                    <td><select>
	                            <option>Pfizer/BioNTech</option>
	                            <option>Johnson &amp; Johnson</option>
	                        </select>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="2" scope="row"><button>Add</button></td>
	                </tr>
	            </tbody>
	        </table>
	    </div>		
	</body>
</html>