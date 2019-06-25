<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">List Page</h1>
	<a href='/board/register'>게시물등록</a>

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table border="1">
					<tr>
						<td>BNO</td>
						<td>TITLE</td>
						<td>WRITER</td>
						<td>REGDATE</td>
					</tr>
					<c:forEach items="${list}" var="vo">
						<tr>
							<td><c:out value="${vo.bno}" /></td>
							<td><a href="/board/read?bno=${vo.bno}"><c:out value="${vo.title}" /></a></td>
							<td><c:out value="${vo.writer}" /></td>
							<td><c:out value="${vo.regdate}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
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