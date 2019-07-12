var replyService = (function() {

	var idx = 0;
	
	/*var csrfHeaderName = "${_csrf.headerName}";
	var csrfTokenValue =  "${_csrf.token}";*/
	
	const host = "/replies/";

	function removeReply(rno, callback) {
		$.ajax({
			type : "delete",
			url : host + rno,
			success : function() {
				if (callback) {
					callback();
				}
			}
		})
	}
	function modifyReply(obj, callback) {
		$.ajax({
			type : "put",
			url : host + "modify",
			data : JSON.stringify(obj),
			contentType : "application/json;charset=UTF-8",

			success : function() {
				console.log("실행성공");
				if (callback) {
					callback();
				}
			}
		})
	}

	function countUp() {
		return ++idx;
	}
	function addReply(obj, callback) {
		$.ajax({
			type : "post",
			url : host + "new",
			data : JSON.stringify(obj),
			contentType : "application/json;charset=UTF-8",
			success : function() {
				if (callback) {
					callback();
				}
			}
		})
	}
	function addReply2(obj, callback) {
		$.ajax({
			type : "post",
			url : host + "reply",
			data : JSON.stringify(obj),
			contentType : "application/json;charset=UTF-8",
			success : function() {
				if (callback) {
					callback();
				}
			}
		})
	}

	function getList(bno, page, callback) {
		var skip = (page - 1) * 10;

		$.getJSON(host + bno + "/" + skip + ".json", null, function(arr) {
			if (callback) {
				callback(arr);
			}
		})
	}
	function getreList(bno, callback) {
		$.getJSON(host + "re/" + bno + ".json", null, function(arr) {
			if (callback) {
				callback(arr);
			}
		})
	}

	function getReply(rno, callback) {
		$.getJSON(host + rno + ".json", null, function(arr) {
			if (callback) {
				callback(arr);
			}
		})
	}

	return {
		addReply2 : addReply2,
		getreList : getreList,
		modifyReply : modifyReply,
		removeReply : removeReply,
		getList : getList,
		getReply : getReply,
		countUp : countUp,
		addReply : addReply

	}

})();