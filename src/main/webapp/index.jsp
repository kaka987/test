<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<body>
<div class='container'>
	<div class='row' style='margin:20px 0 10px 0;'>
  	<div class="col-lg-6" style='padding-left:0;'>
    	<div class="input-group">
      		<input type="text" class="form-control user-search-value" placeholder="enter username">
      		<span class="input-group-btn">
        		<button class="btn btn-default user-search" type="button">Search</button>
      		</span>
    	</div><!-- /input-group -->
  	</div>
  </div>

<div class="panel panel-default">
  

  <table class="table table-striped" id="user-table">
  <thead>
  	<tr class="active">
  		<td>ID</td>
  		<td>Name</td>
  		<td>Age</td>
  		<td>Email</td>
  		<td>Operation</td>
  	</tr>
  </thead>
  <tbody>	

  </tbody>	
  </table>
</div>
<button type="button" class="btn btn-primary user-add">Add</button>
</div>

<!-- dialog -->
<div id="dialog" title="Basic dialog"  style="display:none;">
	<form role="form" id="userform">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
	  </div>
	  <div class="form-group">
	    <label for="userName">UserName</label>
	    <input type="text" class="form-control" id="userName" placeholder="Enter username">
	  </div>
	  <div class="form-group">
	    <label for="age">Age</label>
	    <input type="text" class="form-control" id="age" placeholder="Enter age">
	  </div>

	  <button type="submit" class="btn btn-default" >Submit</button>
	</form>  
</div>

<!-- dialog -->
<div id="dialog-edit" title="Basic dialog"  style="display:none;">
	<form role="form" id="userform-edit">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
	  </div>
	  <div class="form-group">
	    <label for="username">UserName</label>
	    <input type="text" class="form-control" id="username" placeholder="Enter username">
	  </div>
	  <div class="form-group">
	    <label for="age">Age</label>
	    <input type="text" class="form-control" id="age" placeholder="Enter age">
	  </div>
	  <input type="hidden" id="userid" />
	  <button type="submit" class="btn btn-default" >Submit</button>
	</form>  
</div>
 

<script src="http://cdn.bootcss.com/jquery/3.1.0/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<script type="text/javascript">

var str = "";
$.get("/test/user",function(data,status){  
	//console.log(data.data);  
   	$.each(data.data,function(i,h){
   		str += "<tr data='"+h.id+"'>";
   		str += "<td class='id'>"+h.id+"</td>";
   		str += "<td class='username'>"+h.username+"</td>";
   		str += "<td class='age'>"+h.age+"</td>";
   		str += "<td class='email'>"+h.email+"</td>";
   		str += '<td><button type="button" class="btn btn-success user-edit">Edit</button> <button type="button" class="btn btn-danger user-del">Delete</button></td>';
   		str += "</tr>";
   	});
  
   	$("#user-table").append(str);
});

$(function () {
	
	userEdit();
	userDel();
	
	$(".user-search").click(function(){
		var username = $(".user-search-value").val();
		var str = "";
		$.get("/test/usersearch?username="+username, function(data,status){
			var h = data.data[0];
			console.log(h);
			
			str += "<tr data='"+h.id+"'>";
			str += "<td class='id'>"+h.id+"</td>";
	   		str += "<td class='username'>"+h.username+"</td>";
	   		str += "<td class='age'>"+h.age+"</td>";
	   		str += "<td class='email'>"+h.email+"</td>";
	   		str += '<td><button type="button" class="btn btn-success user-edit">Edit</button> <button type="button" class="btn btn-danger user-del">Delete</button></td>';
	   		str += "</tr>";
	   		$("#user-table tbody").html(str);
	   		
	   		userUpdate();
	   		userDel();
		},"json");
	})
	
	// add a new user
	$("#userform").submit(function() {
		var user = {};
		user.email = $("#dialog #exampleInputEmail1").val();
		user.username = $("#dialog #userName").val();
		user.age = $("#dialog #age").val();
		
		// do some valid
		// return false;
		
		$.post("/test/useradd",user,function(data,status){
			console.log(data);
			if(data.status==1) {
				location.reload();
				return true;
			}
			return false;
		})
	})
	
	//弹出框
	var _set = {
			autoOpen:false,   
	        modal:true,
	        width:500,
	        title:"Add a new user"
		}
	$(".user-add").click(function(){
		$("#dialog").dialog("open");	
	})
	$( "#dialog" ).dialog(_set);
	$( "#dialog-edit" ).dialog(_set);
	userUpdate();
	
})

function userEdit() {
	$("#userform-edit").submit(function() {
		var user = {};
		user.userid = $("#dialog-edit #userid").val();
		user.email = $("#dialog-edit #exampleInputEmail1").val();
		user.username = $("#dialog-edit #userName").val();
		user.age = $("#dialog-edit #age").val();
		$.post("/test/useredit",user,function(data,status){
			console.log(data);
			if(data.status==1) {
				location.reload();
				return true;
			}
			return false;
		})
	})
}

function userUpdate() {
	$(".user-edit").bind("click",function(){
		var _this = $(this).parent().parent();
		var _d = {};
		_d.email = _this.find(".email").text();
		_d.username = _this.find(".username").text();
		_d.age = _this.find(".age").text();
		_d.userid = _this.attr("data");
		console.log(_d);
		$("#dialog-edit #exampleInputEmail1").val(_d.email);
		$("#dialog-edit #username").val(_d.username);
		$("#dialog-edit #age").val(_d.age);
		$("#dialog-edit #userid").val(_d.userid);
		$("#dialog-edit").dialog("open");	
	})
}

function userDel() {
	$(".user-del").bind("click",function(){
		console.log(123);
		if (confirm("Delete this user?")==true) {
			var userid = $(this).parent().parent().attr("data");
			$.post("/test/userdel",{"userid":userid},function(data,status){
				console.log(data);
				if(data.status==1) {
					location.reload();
				}
				return false;
			})
		}
	})
}
</script>
</body>
</html>
