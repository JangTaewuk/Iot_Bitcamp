<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="../includes/header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800">List Page</h1>
	

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href='/board/register'>게시물등록</a></h6>
			<select class="opt">
			<option value="10" ${pm.cri.amount == 10? "selected" : "" }>10</option>
			<option value="20" ${pm.cri.amount == 20? "selected" : "" }>20</option>
			<option value="50" ${pm.cri.amount == 50? "selected" : "" }>50</option>
			<option value="100" ${pm.cri.amount == 100? "selected" : "" }>100</option>
			
			</select>
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
							<td><a href='${pm.getLink("/board/read",pm.current)}&bno=${vo.bno}'><c:out
										value="${vo.title}" /></a></td>
							<td><c:out value="${vo.writer}" /></td>
							<td><c:out value="${vo.regdate}" /></td>
						</tr>
					</c:forEach>
				</table>
				<ul class="pagination">

					<c:if test="${pm.prev}">
						<li class="page-item"><a class="page-link" href='${pm.getLink("/board/list",pm.getStart()-1)}'>Previous</a></li>
					</c:if>
					<c:forEach begin="${pm.start}" end="${pm.end}" var="idx">
						<li class="page-item ${pm.current == idx ? "active":"" } "><a class="page-link" href='${pm.getLink("/board/list",idx)}'>${idx}</a></li>
					</c:forEach>

					<c:if test="${pm.next}">
						<li class="page-item"><a class="page-link" href='${pm.getLink("/board/list",pm.getEnd()+1)}'>Next</a></li>
					</c:if>
				</ul>

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
	
	$(".opt").on("change",function(e){
		var amountValue = this.value;
		
		self.location="/board/list?page=1&amount="+amountValue;
	})
	
</script>

<%@include file="../includes/footer.jsp"%>



</body>
</html>