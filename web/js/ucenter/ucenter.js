function changecolumns(){
	document.getElementsByClassName("colums")[0].style.display = "none";
	document.getElementsByClassName("colums hide")[0].style.display = "block";
	
}

function getSession(){
	$.ajax({
		type:'get',
		url:'haveLogin.action',
		async:false,
		dataType:'json',
		success:function(data){
			alert(data);
		},
		error:function(data){
			alert("error");
		}
	});
}
