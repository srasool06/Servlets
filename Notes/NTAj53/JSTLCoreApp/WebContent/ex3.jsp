<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:catch var="e">
 <jsp:scriptlet>
    int x=Integer.parseInt("10");
    out.println("value"+x);
 </jsp:scriptlet>
</c:catch>
 <c:out value="${e}"/>




