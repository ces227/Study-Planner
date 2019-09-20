$(function() {
	$.fn.serializeObject = function() {

		  var result = {}
		  var extend = function(i, element) {
		    var node = result[element.name]
		    if ("undefined" !== typeof node && node !== null) {
		      if ($.isArray(node)) {
		        node.push(element.value)
		      } else {
		        result[element.name] = [node, element.value]
		      }
		    } else {
		      result[element.name] = element.value
		    }
		  }

		  $.each(this.serializeArray(), extend)
		  return result
		}
	
}); //$(function() { 끝

function submitForm() {
	var formData = $("#Ggraphform").serialize();
	
	$.ajax({
		type: 'POST',
		url: "Ggraphupdate",
		data: formData,
		success: function (result) {
			alert('정상 처리되었습니다.');
			location.href = 'redirect:/GgraphDetail';
		}
	}) //ajax 끝	
} //함수 끝

	
