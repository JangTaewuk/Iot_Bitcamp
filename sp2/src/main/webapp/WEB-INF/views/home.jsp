<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>

<form action="/uploadFormAction" method="post"
	enctype="multipart/form-data">

	<input type='file' name='uploadFile' multiple>

	<button>Submit</button>