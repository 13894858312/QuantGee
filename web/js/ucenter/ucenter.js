function changecolumns(){
	document.getElementsByClassName("colums")[0].style.display = "none";
	document.getElementsByClassName("colums hide")[0].style.display = "block";
	
}

function getSession(){
	var value = <%=session.getAttribute("username")%>;
}
