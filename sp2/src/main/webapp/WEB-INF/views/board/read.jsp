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

			<button  class="btn btn-primary">
			<a href="/board/modify?bno=${vo.bno}">Modify/Delete</a></button>

			<hr>


			<a href="/board/list" class="btn btn-secondary"> Go to List </a>

		</div>

	</div>
	<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<script>
	var flag = '${result}';

	if (flag === 'success') {
		alert("작업이 성공했습니다.");
	}
</script>

<%@include file="../includes/footer.jsp"%>



</body>
</html>