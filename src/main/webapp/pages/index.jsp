<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha"%>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-2.1.0.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/jqueyMask.js" />"></script>
<script src="<c:url value="/resources/js/mainScript.js" />"></script>

<title>user managament aplication</title>
</head>
<body>

	<div id="dialog-confirm" title="Empty the recycle bin?"></div>


	<div id="dialog" title="Update your info">
		<p>
			Name: <input id="editName" type="text" placeholder="" /> </br> Surame: <input
				id="editSurname" type="text" placeholder="" /> </br> Phone: <input
				id="editPhoneNo" type="text" placeholder="" />
			<button id="dialogEditButton">Edit</button>
			<button id="dialogCloseButton">Cancel</button>
			</br> </br> </br>
		</p>
	</div>

	<h3>Add user</h3>
	<form:form id="myUserForm" modelAttribute="userForm"
		action="submitedform">
		<fieldset>
			<div class="form-row">
				<label for="userName">Name:</label> <span class="input"><form:input
						path="userName" /></span>
			</div>
			<div class="form-row">
				<label for="userSurname">Surname:</label> <span class="input"><form:input
						path="userSurname" /></span>
			</div>
			<div class="form-row">
				<label for="phoneNo">Phone numbers:</label> <span class="input"><form:input
						id="phoneNo" path="phoneNo" /></span>
			</div>
			<%
				ReCaptcha c = ReCaptchaFactory.newReCaptcha(
							"6LdryPASAAAAAJ7_wNiG-XKE1GU16pAjrgUnnIrT",
							"6LdryPASAAAAAK-sSiErRVQDSkl7NYyc9v18FKGO", false);
					out.print(c.createRecaptchaHtml(null, null));
			%>

			<div class="form-buttons">
				<div class="button">
					<input type="submit" id="save" value="Save" />
				</div>
			</div>
		</fieldset>
	</form:form>


	<div style="color: red;">${wrongCaptcha}</div>


	<h1>User list</h1>

	<c:forEach items="${myUserList}" var="i">
		<table id="${i.userId}table" border="1px" cellpadding="0"
			cellspacing="0">
			<thead>
				<tr>
					<th width="15%">Name</th>
					<th width="10%">Surname</th>
					<th width="10%">Phone numbers</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td id="${i.userId}tablename">${i.userName}</td>
					<td id="${i.userId}tablesurname">${i.userSurname}</td>
					<td id="${i.userId}tablephoneno">${i.phoneNo}</td>
					<td><button class="opener" id="${i.userId}opener">Edit</button>
						<br>
						<button class="remover" id="${i.userId}remover">Remove</button> <br></td>
				</tr>

			</tbody>
		</table>
	</c:forEach>

</body>
</html>