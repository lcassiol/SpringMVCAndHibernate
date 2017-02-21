<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Movie Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Movie
</h1>

<c:url var="addAction" value="/movie/add" ></c:url>

<form:form action="${addAction}" commandName="movie">
<table>
	<c:if test="${!empty movie.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="director">
				<spring:message text="director"/>
			</form:label>
		</td>
		<td>
			<form:input path="director" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="writers">
				<spring:message text="writers"/>
			</form:label>
		</td>
		<td>
			<form:input path="writers" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="year">
				<spring:message text="year"/>
			</form:label>
		</td>
		<td>
			<form:input path="year" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="sinopse">
				<spring:message text="sinopse"/>
			</form:label>
		</td>
		<td>
			<form:input path="sinopse" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="stars">
				<spring:message text="stars"/>
			</form:label>
		</td>
		<td>
			<form:input path="stars" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="gender">
				<spring:message text="gender"/>
			</form:label>
		</td>
		<td>
			<form:input path="gender" />
		</td>
	</tr>

	<tr>
		<td colspan="2">
			<c:if test="${!empty movie.name}">
				<input type="submit"
					value="<spring:message text="Edit Movie"/>" />
			</c:if>
			<c:if test="${empty movie.name}">
				<input type="submit"
					value="<spring:message text="Add Movie"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Movie List</h3>
<c:if test="${!empty listMovies}">
	<table class="tg">
	<tr>
		<th width="80">Movie ID</th>
		<th width="120">Movie Name</th>
		<th width="120">Movie Director</th>
		<th width="120">Movie Writers</th>
		<th width="120">Movie Year</th>
		<th width="120">Movie Sinopse</th>
		<th width="120">Movie Stars</th>
		<th width="120">Movie Gender</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listMovies}" var="movie">
		<tr>
			<td>${movie.id}</td>
			<td>${movie.name}</td>
			<td>${movie.director}</td>
			<td>${movie.writers}</td>
			<td>${movie.year}</td>
			<td>${movie.sinopse}</td>
			<td>${movie.stars}</td>
			<td>${movie.gender}</td>
			<td><a href="<c:url value='/edit/${movie.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${movie.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
