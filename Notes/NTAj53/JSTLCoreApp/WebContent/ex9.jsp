<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>
<%@page import="java.util.*"%>

<b> <i> Traditional for loop</i></b> <br>
<c:forEach var="i" begin="1" end="10" step="1">
  <c:out value="2  *  ${i} = ${2*i} "/> <br>
</c:forEach>

<b> <i> Enhanced for loop</i></b> <br>
 <jsp:scriptlet>
    String names[]={"raja","rani","jani","begum"};
    request.setAttribute("studNames",names);
 </jsp:scriptlet>
   <br> the names are <br>
  <c:forEach var="name"   items="${studNames}">
     <c:out value="${name }"/>
  </c:forEach>
  <br>
  <b> <i> Enhanced for loop</i></b> <br>
 <jsp:scriptlet>
 <![CDATA[
    List<String> list=new ArrayList<String>();
    list.add("java"); list.add(".net"); list.add("oracle");
    request.setAttribute("courses",list);
    ]]>
 </jsp:scriptlet>
  <br> the courses are <br>
  <c:forEach var="course"   items="${courses}">
     <c:out value="${course}"/>
  </c:forEach>
  
