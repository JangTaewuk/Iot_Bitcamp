<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">Board Read Page</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Read</h6>
		</div>
		<div class="card-body">

			<div class="form-group">
				<input type="text" name="bno" readonly="readonly"
					value='글번호: <c:out value="${vo.bno}"/>'
					class="form-control form-control-user">
			</div>

			<div class="form-group">
				<input type="text" name="title" readonly="readonly"
					value='제목: <c:out value="${vo.title}"/>'
					class="form-control form-control-user">
			</div>
			<div class="form-group">
				<input type="text" name="content" readonly="readonly"
					value='내용: <c:out value="${vo.content}"/>'
					class="form-control form-control-user">
			</div>
			<div class="form-group">
				<input type="text" name="writer" readonly="readonly"
					value='작성자: <c:out value="${vo.writer}"/>'
					class="form-control form-control-user">
			</div>

			<button class="btn btn-primary modBtn">Modify/Delete</button>

			<button class="btn btn-secondary listBtn">Go to List</button>

			<hr>


		</div>

	</div>
	<!-- /.container-fluid -->
	<form id="actionForm" action="/board/modify" method="get">
		<input type="hidden" name="bno" value="${cri.bno}"> 
		<input type="hidden" name="page" value="${cri.page}"> 
		<input	type="hidden" name="amount" value="${cri.amount}">
		<input type="hidden" name="type" value="${cri.type}">
		<input type="hidden" name="keyword" value="${cri.keyword}">
	</form>

</div>
<!-- End of Main Content -->

<script>
var actionForm = $("#actionForm");

	$(".modBtn").on("click", function(e) {
		actionForm.submit();	
	})
	$(".listBtn").on("click", function(e) {
		actionForm.find("input[name='bno']").remove();		
		actionForm.attr("action","/board/list").submit();

	})
</script>


<%@include file="../includes/footer.jsp"%>



</body>
</html>