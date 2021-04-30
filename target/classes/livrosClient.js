$(function(){
	$(".js-load-books").on('click', function(){
		$.ajax({
			url: "http://localhost:8080/livros",
			type: "get",
			headers: {
				"Authorization": "Basic cGhpbGlwcG86czNuaDQ="
			},
			success: function(response) {
				alert(response);
			}
		});
	})
})