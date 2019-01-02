<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
        <h1>Add New Employee</h1>  
       <form:form  action="http://localhost:8080/student_details/save.htm">    
        <table >    
         <tr>    
             
          <td><form:hidden path="sno"  /></td>  
         </tr>    
         <tr>    
          <td>Student Name :</td>    
          <td><form:input path="sname" /></td>  
         </tr> 
         <tr>    
          <td>Student Mail_id :</td>    
          <td><form:input path="mailId" /></td>  
         </tr>
         <tr>    
          <td>Marks 1 :</td>    
          <td><form:input path="marks1" /></td>  
         </tr>
         <tr>    
          <td>Marks 2 :</td>    
          <td><form:input path="marks2" /></td>  
         </tr>
         <tr>    
          <td>Marks 3 :</td>    
          <td><form:input path="marks3" /></td>  
         </tr>  
         <tr>  
          <td> </td>    
          <td><input type="submit" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>   
       <h3><a href="http://localhost:8080/student_details/selectAll.htm">Back</a></h3>
     
     
     
     
     
     
     
     
     
     
     
     
     
      