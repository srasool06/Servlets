
<%@taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c"%>

<c:forEach var="p" items="${paramValues}">
   Name==> <c:out value="${p.key}" /> <br>
    Value==>
    <c:forEach var="pv" items="${p.value}">
          <c:out value="${pv}" /> 
    </c:forEach>
    <br>
</c:forEach>