<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:url var="link1" value="http://localhost:3030/JSTLCoreApp/ex1.jsp"/>
<a href="${link1}"> Go home</a>
<br>
<c:import url="ex3.jsp"/>