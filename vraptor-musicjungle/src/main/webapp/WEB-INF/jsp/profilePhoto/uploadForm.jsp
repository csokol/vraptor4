<%@ include file="/header.jsp"%>

<form method="post" enctype="multipart/form-data">

	<img src="<c:url value="/images/upload.png" />">
	
	<label>Image: 
		<input type="file" name="image">
	</label>
	<br> 
	<input type="submit" name="submit" value="Send">
</form>

<%@ include file="/footer.jsp"%>