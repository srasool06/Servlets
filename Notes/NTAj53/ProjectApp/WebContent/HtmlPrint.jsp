<%@page import="java.util.ArrayList, com.nt.model.BookBean"  isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<html>

	<script language='javascript'>
		function showprint()
		{
			frames.focus();
			frames.print();
		}
	</script>
	
	
	

<body>
	<center><h2><u>
	 Books belonging to category ${fn:toUpperCase(param.category)}
	 
	<u></h2></center>
	<br>
	<c:choose>
	 <c:when test="${list ne null}">
    	<table border="1" width="100%">
	    	<tr>
		    	<th>BookId</th>
			    <th>BookName</th>
			    <th>AuthorName</th>
			    <th>Status</th>
		  </tr>
		<c:forEach var="bk"  items="${list}">
		<tr>
			<td>${bk.bookId}</td>
			<td>${bk.bookName}</td>
			<td>${bk.authorName}</td>
			<td>${bk.status}</td>
		</tr>
		</c:forEach>
		</table>
	</c:when>
    <c:otherwise>
       <h1><center> No records found</h1></center>
    </c:otherwise>
  </c:choose>
	<center>
	<a href="javascript:showprint()">Print</a>
	</center>
	</form>
</body>
</html>