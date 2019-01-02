<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
function doAjaxSubmit() {
	var no = $('#no')
    var name = $("#name").val();
    var mail = $("#mail").val();
    var marks1 = $("#marks1").val();
    var marks2 = $("#marks2").val();
    var marks3 = $("#marks3").val();

    var sendInfo = 
    		"No:"+no+" Name:"+ name+"Mail:"+mail+"Marks1:"+marks1+"Marks2:"+marks2+"Marks3:"+marks3;
    		
    		
$.ajax({
    type: "GET",
    
    url:"http://localhost:8080/student_details/form.htm",
    success: function (msg) {
        if (msg) {
            alert("Somebody" + name + " was added in list !");
            location.reload(true);
        } else {
            alert("Cannot add to list !");
        }
    },error:function(res){
    alert("error"+res.status);	
    },
    
    data: sendInfo
});
}
</script>
</head>
<body>
<h2><marquee><strong><i>Student Details</i></strong></marquee></h2>

	<form:form action="form.htm" method="post" modelAttribute="command">
		<table>
			<tr>
				<td>Student No :</td>
				<td><form:input id="no" path="sno"/></td>
			</tr>
			<tr>
				<td>Student Name :</td>
				<td><form:input id="name" path="sname"/></td>
			</tr>
			<tr>
				<td>Student Mail-ID :</td>
				<td><form:input id="mail" path="mailId"/></td>
			</tr>
			<tr>
				<td>Marks1 :</td>
				<td><form:input id="marks1" path="marks1"/></td>
			</tr>
			<tr>
				<td>Marks2 :</td>
				<td><form:input id="marks2"  path="marks2"/></td>
			</tr>
			<tr>
		     <tr>
				<td>marks3 :</td>
				<td><form:input id="marks3" path="marks3"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="addDetails" ></td>
			</tr>
		</table>
		
		
		</form:form>
		<br>
		<br>
		<h1 style="color:green"><strong><i>${msg}</i></strong></h1>
		<br><br><br>
		<h4 style="color:sky"><a href="selectAll.htm">Get All Student Records</a></h4>
		<!-- <h4><a href="select.htm"><font color="black">Select Student by Sno</font></a></h4> -->
		<form:form action="select.htm">
		<h4>Select the Student detail By sno</h4><br>
		Input the Student Sno :<form:input id="no" path="sno"/><br>
		<input type="submit" value="getData">
		<br>
		<br>
		<br>
		<table border="2" width="70%" cellpadding="2">  
<tr><th>sno</th><th>Name</th><th>mail_id</th><th>marks1</th><th>marks2</th><th>marks3</th></tr>  
<tr><td>${vo.sno}</td><td>${vo.sname}</td><td>${vo.mailId}</td><td>${vo.marks1}</td><td>${vo.marks2}</td><td>${vo.marks3}</td></tr>
</table>
       <%-- ${vo.sno} &nbsp;&nbsp;&nbsp;${vo.sname}&nbsp;&nbsp;&nbsp;${vo.mailId}&nbsp;&nbsp;&nbsp;${vo.marks1}&nbsp;&nbsp;&nbsp;${vo.marks2}&nbsp;&nbsp;&nbsp;${vo.marks3} --%>
		</form:form>		
</body>
</html>