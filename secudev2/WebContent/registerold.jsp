<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src = "jquery-1.11.3.min.js"></script>
<script src = "parsley.js"></script>
<link rel="stylesheet" type="text/css" href="parsley.css">
<title>Registration</title>
</head>

<body>
<script>
	$(document).ready(function() {
		changeSalutation($('#gender').val());
		$('#gender').on("change", function() {
			changeSalutation($('#gender').val());
		});
		
		//var oldsubmit = $('#formpubregister').data('events').submit[0].handler;
		
		$('#formpubregister').submit(function(e) {
			if (checkLegalAge($('#birthdate').val())){
				return true;
			}
			else {
				alert("You need to be at least 18 years old to view the content.");
				return false;
			}
		}); 
	});
	
	function checkLegalAge(inputDate) {
		var today = new Date();
		var birthDate = new Date(inputDate);
		var age = today.getFullYear() - birthDate.getFullYear();
		var m = today.getMonth() - birthDate.getMonth();
		if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) 
		    age--;
		
		if(age < 18) 
		    return false;
		
		return true;
	}
	
	function changeSalutation(gender) {
		$('#salutation').empty();
		if (gender == "male") {
			$('#salutation').append('<option value = "Mr">Mr</option>');
			$('#salutation').append('<option value = "Sir">Sir</option>');
			$('#salutation').append('<option value = "Senior">Senior</option>');
			$('#salutation').append('<option value = "Count">Count</option>');
		} else if (gender == "female") {
			$('#salutation').append('<option value = "Miss">Miss</option>');
			$('#salutation').append('<option value = "Ms">Ms</option>');
			$('#salutation').append('<option value = "Mrs">Mrs</option>');
			$('#salutation').append('<option value = "Madame">Madame</option>');
			$('#salutation').append('<option value = "Majesty">Majesty</option>');
			$('#salutation').append('<option value = "Seniora">Seniora</option>');
		}
	}
</script>

<form id = "formpubregister" action = "./RegisterServlet" method = "POST" data-parsley-validate>
	<label>Firstname: </label>
	<input type = "text" name = "firstname" data-parsley-required = "true" data-parsley-maxlength="50" data-parsley-pattern="^[a-zA-Z0-9 ]*$"/>
	<br> <br>
	<label>Lastname: </label>
	<input type = "text" name = "lastname" data-parsley-required = "true" data-parsley-maxlength="50" data-parsley-pattern="^[a-zA-Z0-9 ]*$"/>
	<br> <br>
	<label>Gender: </label>
	<select name = "gender" id = "gender">
		<option value = "male" id = "gender_M">Male</option>
		<option value = "female" id = "gender_F">Female</option>
	</select>
	<br> <br>
	<label>Salutation:</label>
	<select name = "salutation" id = "salutation">
	</select>
	<br> <br>
	<label>Birthdate: </label>
	<input type = "date" name = "birthdate" id = "birthdate" data-parsley-required = "true"/>
	<br> <br>
	<label>Username: </label>
	<input type = "text" name = "username" data-parsley-required = "true" data-parsley-maxlength = "50" data-parsley-pattern="^[a-zA-Z0-9_]*$"/>
	<br> <br>
	<label>Password: </label>
	<input type = "password" name = "password" data-parsley-required = "true" data-parsley-maxlength = "50"/>
	<br> <br>
	<label>About Me: </label>
	<br> <br>
	<textarea name ="aboutme" id = "aboutme" rows = "4" cols = "50" data-parsley-maxlength = "255"></textarea>
	<br> <br>
	<input type = "submit" value = "Submit"/>
</form>
</body>
</html>