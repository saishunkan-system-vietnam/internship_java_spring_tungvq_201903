function confirmAction() {
	return confirm("DO YOU WANT DELETE ?")
  }
  
  $(function(){
	  $('#json-click').click(function(){
	/*   alert("aa") */
	  var data = {};
          $.ajax({
              url : 'http://localhost:8080/api/building/list',	
              type : 'get',
              dataType : 'text',
              data: data,
              success : function (result){
                  console.log(result[1].name);
                  var obj = JSON.parse(result);
                  $("#div_show").html(result);
	                  obj.forEach(function(element){
	                	 console.log(element.name);
	                  });
	                  
	              }
	          });
	      });
  });