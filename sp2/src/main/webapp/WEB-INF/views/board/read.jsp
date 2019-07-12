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
					value='<c:out value="${vo.bno}"/>'
					class="form-control form-control-user">
			</div>

			<div class="form-group">
				<input type="text" name="title" readonly="readonly"
					value='<c:out value="${vo.title}"/>'
					class="form-control form-control-user">
			</div>
			<div class="form-group">
				<input type="text" name="content" readonly="readonly"
					value='<c:out value="${vo.content}"/>'
					class="form-control form-control-user">
			</div>
			<div class="form-group">
				<input type="text" name="writer" readonly="readonly"
					value='작성자: <c:out value="${vo.writer}"/>'
					class="form-control form-control-user">
			</div>

			<button class="btn btn-primary modBtn">Modify/Delete</button>

			<button class="btn btn-secondary listBtn">Go to List</button>

			<button class="btn btn-outline-success addReplyBtn">Add
				Reply</button>



			<hr>

		</div>

		<div class="card shadow mb-4">
			<div class="card-body">
				<ul class="replyList list-group">
					<li class="list-group-item">AAAAAAAAAAAA</li>
					<li class="list-group-item">BBBBBBBBBBBB</li>
				</ul>
			</div>
		</div>

		<ul class="pagination">
			<li class="page-item"><a class="page-link prev" href="">Previous</a></li>
			<li class="page-item"><a class="page-link next" href="">Next</a></li>
		</ul>

	</div>
	<!-- /.container-fluid -->
	<form id="actionForm" action="/board/modify" method="get">
		<input type="hidden" name="bno" value="${cri.bno}"> <input
			type="hidden" name="page" value="${cri.page}"> <input
			type="hidden" name="amount" value="${cri.amount}"> <input
			type="hidden" name="type" value="${cri.type}"> <input
			type="hidden" name="keyword" value="${cri.keyword}">
	</form>

</div>

<div class="modal fade" id="replyModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Add Reply</h5>
				<button class="close" type="button" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<input type="text" class="form-control mbno" name="bno"
					value="${cri.bno}" readonly="readonly"> <input type="text"
					class="form-control mrno" name="rno" value="" readonly="readonly">
				<input type="text" class="form-control" name="reply" value="샘플댓글">
				<input type="text" class="form-control" name="replyer" value="도라에몽">
			</div>
			<div class="modal-footer">
				<button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
				<button class="btn btn-primary replyBtn">ADD REPLY</button>
				<button class="btn btn-primary rereBtn hide">ADD REREPLY</button>
				<button class="btn btn-info modifyBtn hide">Modify Reply</button>
				<button class="btn btn-danger deleteBtn hide">Delete Reply</button>

			</div>
		</div>
	</div>
</div>

<style>
.modal-footer .hide {
	display: none
}
</style>

<!-- End of Main Content -->
<script type="text/javascript" src="/resources/js/reply.js"></script>
<script>
	console.log(replyService);
	var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue =  "${_csrf.token}";
	
	$(document).ajaxSend(function(e,xhr,options){
		xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);
	});

	var actionForm = $("#actionForm");
	
	 var bno = ${vo.bno};
	 var replyPage = ${cri.replyPage};

	 var replyList = $(".replyList");
	 
	 showPage();
	 
	 $(".modifyBtn").on("click",function(e){
		 console.log("수정버든")
		 
		 let obj = {
					rno : $("input[name='rno']").val(),
					reply : $("input[name='reply']").val(),
					replyer : $("input[name='replyer']").val()
				};
		 replyService.modifyReply(obj, function() {
				alert("댓글 등록 성공");
				$("#replyModal").modal("hide");
				showPage();
			});
		 
		 
	 });
	 
	 
	 
	 
	 replyList.on("click","li",function(e){
		 var rno =$(this).attr("data-rno");
		 
		 replyService.getReply(rno,function(reply){
			 
			$(".mrno").val(reply.rno);
			$("input[name='reply']").val(reply.reply);
			$("input[name='replyer']").val(reply.replyer);
			$("#replyModal").modal("show");
			
			$(".modifyBtn").removeClass("hide");
			$(".replyBtn").addClass("hide");
			$(".deleteBtn").removeClass("hide");
			$(".rereBtn").addClass("hide");
			
			 
		 });
		 
		 
	 });
	

	$(".addReplyBtn").on("click", function() {
		$("#replyModal").modal("show");
		
		$(".modifyBtn").addClass("hide");
		$(".replyBtn").removeClass("hide");
		$(".deleteBtn").addClass("hide");
		$(".rereBtn").addClass("hide");
	});

	$(".replyBtn").on("click", function(e) {

		let obj = {
			bno : $("input[name='bno']").val(),
			reply : $("input[name='reply']").val(),
			replyer : $("input[name='replyer']").val(),
		};

		replyService.addReply(obj, function() {
			alert("댓글 등록 성공");
			$("#replyModal").modal("hide");
			showPage();
		});

	});
	
	replyList.on("click","button",function(e){
		var rno = $(this).attr("data-rno");
		$(".mrno").val(rno);
		$("#replyModal").modal("show");
		
		$(".modifyBtn").addClass("hide");
		$(".replyBtn").addClass("hide");
		$(".deleteBtn").addClass("hide");
		$(".rereBtn").removeClass("hide");
	});
	$(".rereBtn").on("click",function(){
		
		let obj = {
				bno : $("input[name='bno']").val(),
				rno2 : $(".mrno").val(),
				reply : $("input[name='reply']").val(),
				replyer : $("input[name='replyer']").val(),
			};
		replyService.addReply2(obj, function() {
			alert("댓글 등록 성공");
			$("#replyModal").modal("hide");
			showPage();
		});
		
		
	});
	
	
	$(".prev").on("click",function(e){
		e.preventDefault();
		replyPage -= 1;
		if(replyPage < 1){
			alert("이전페이지가 없습니다");
			replyPage +=1;
		}
		showPage();
	});
	
	
	$(".next").on("click",function(e){
		e.preventDefault();
		replyPage += 1;
		if(replyPage > (${vo.replycnt}/10)+1){
			alert("다음페이지가 없습니다");
			replyPage -=1;
		}
		showPage();
	});
	
	
	function showPage(){

        replyList.html("");
        var rereply = {};
        replyService.getreList(bno,function (arr) {
        	rereply = arr;
        });
        console.log(replyPage);

        replyService.getList(bno,replyPage,function (arr) {

            // 구조 분해 할당 문법
            // 탬플릿 문법 [ 백픽`` ]
            var str = '';
            var x = 0;
            var resize = rereply.length;
				  for(var i=0;i<arr.length;i++){
		                var {rno,bno,reply,replyer,replyDate} = arr[i];
		                str += "<div><li class='list-group-item' data-rno="+rno+">"+ 
                        "<div class='rno'>"+rno+"</div>"+
                        "<div class='reply'>"+reply+"</div>"+
                        "<div class='replyer'>"+replyer+"</div>"+
                        "</li>"+
                        "<button class='btn-primary replyBtn2' data-rno="+rno+">댓글달기</button></div>";
				  }
			/* else
			{
            for(var i=0;i<arr.length;i++){
                var {rno,bno,reply,replyer,replyDate} = arr[i];
                	//console.log("rereply rno2: "+rereply[j].rno2);
                	//console.log("rereply rno: "+rereply[j].rno);
                	//console.log("arr rno: "+ arr[i].rno);
                	console.log("arr "+arr[i].rno);
                	console.log("rereply "+rereply[x].rno);
                	console.log("rereply rno2: "+rereply[x].rno2);

                		if(arr[i].rno == rereply[x].rno2){
                			str += "<div><li class='list-group-item' data-rno="+rno+">"+ 
	                        "<div class='rno'>"+rno+"</div>"+
	                        "<div class='reply'>"+reply+"</div>"+
	                        "<div class='replyer'>"+replyer+"</div>"+
	                        "</li>"+
	                        "<button class='btn-primary replyBtn2' data-rno="+rno+">댓글달기</button></div>";
                			str += "<div style='margin-left:50px;'><li class='list-group-item' data-rno="+rno+">"+ 
                            "<div class='rno'>"+rereply[x].rno+"</div>"+
                            "<div class='reply'>"+rereply[x].reply+"</div>"+
                            "<div class='replyer'>"+rereply[x].replyer+"</div>"+
                            "</li>"+
                            "<button class='btn-primary replyBtn2' data-rno="+rno+">댓글달기</button></div>";
                            if(x < rereply.length-1){
	                            x += 1;
                        	}
                		}
                		else if(arr[i].rno == rereply[x-1].rno | arr[i].rno == rereply[x].rno){
                			console.log("대댓글이여서 미출력");
                		}
                        else
                    	{
    	                		str += "<div><li class='list-group-item' data-rno="+rno+">"+ 
    	                        "<div class='rno'>"+rno+"</div>"+
    	                        "<div class='reply'>"+reply+"</div>"+
    	                        "<div class='replyer'>"+replyer+"</div>"+
    	                        "</li>"+
    	                        "<button class='btn-primary replyBtn2' data-rno="+rno+">댓글달기</button></div>";
                    	}    
                        
                		
                    	
                    
                		
                	}// end for   } */
			
                	
            
            replyList.append(str);
        });

    }

	$(".modBtn").on("click", function(e) {
		actionForm.submit();
	})
	$(".listBtn").on("click", function(e) {
		actionForm.find("input[name='bno']").remove();
		actionForm.attr("action", "/board/list").submit();
	})
	
	
	$(".deleteBtn").on("click",function(){
		var rno = $("input[name='rno']").val();
		
		replyService.removeReply(rno,function(){
			alert("remove.....")
			showPage();
			$("#replyModal").modal("hide");
		})
	});
	
</script>


<%@include file="../includes/footer.jsp"%>



</body>
</html>