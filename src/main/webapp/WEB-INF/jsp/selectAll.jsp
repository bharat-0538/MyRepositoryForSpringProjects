<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Students List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>sno</th><th>Name</th><th>mail_id</th><th>marks1</th><th>marks2</th><th>marks3</th><th>Delete</th><th>Edit</th></tr>  
   <c:forEach var="std" items="${list}">   
   <tr>  
   <td>${std.sno}</td>  
   <td>${std.sname}</td>  
   <td>${std.mailId}</td>  
   <td>${std.marks1}</td>  
   <td>${std.marks2}</td>  
   <td>${std.marks3}</td> 
   <td><a href="http://localhost:8080/student_details/delete.htm/${std.sno}">delete</a></td> 
   <td><a href="http://localhost:8080/student_details/edit.htm/${std.sno}">Edit</a></td>
   </tr>  
   </c:forEach>  
   </table>  
</body>
<h3><a href="http://localhost:8080/student_details/index.htm">Back</a></h3>
</html>