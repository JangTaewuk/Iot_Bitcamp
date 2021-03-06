<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">Board Modify/Delete Page</h1>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Modify/Delete</h6>
		</div>
		<div class="card-body">
			<form id='form1'>

				<input type="hidden" name="bno" value="${cri.bno}"> 
				<input type="hidden" name="page" value="${cri.page}"> 
				<input type="hidden" name="amount" value="${cri.amount}">
				<input type="hidden" name="type" value="${cri.type}">
				<input type="hidden" name="keyword" value="${cri.keyword}">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

				<div class="form-group">
					<input type="text" name="bno" readonly="readonly"
						value='<c:out value="${vo.bno}"/>'
						class="form-control form-control-user">
				</div>

				<div class="form-group">
					<input type="text" name="title"
						value='<c:out value="${vo.title}"/>'
						class="form-control form-control-user">
				</div>
				<div class="form-group">
					<input type="text" name="content"
						value='<c:out value="${vo.content}"/>'
						class="form-control form-control-user">
				</div>
				<div class="form-group">
					<input type="text" name="writer" readonly="readonly"
						value='<c:out value="${vo.writer}"/>'
						class="form-control form-control-user">
				</div>
			</form>

			<button class="btn btn-warning">Modify</button>

			<button class="btn btn-danger">Delete</button>

			<hr>
			<button class="btn btn-secondary listBtn">Go to List </button>

		</div>

	</div>
	<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<script>
	$(".btn-danger").on(
			"click",
			function() {
				console.log("delet button click");
				var formObj = $("#form1");

				formObj.attr("action", "/board/remove").attr("method", "post")
						.submit();
			});
	$(".btn-warning").on(
			"click",
			function() {
				console.log("delet button click");
				var formObj = $("#form1");

				formObj.attr("action", "/board/modify").attr("method", "post")
						.submit();
			});
	$(".listBtn").on("click", function(e) {
		var formObj = $("#form1");
		formObj.find("input[name='bno']").remove();		
		formObj.attr("action","/board/list").attr("method", "get").submit();

	});
</script>

<%@include file="../includes/footer.jsp"%>
