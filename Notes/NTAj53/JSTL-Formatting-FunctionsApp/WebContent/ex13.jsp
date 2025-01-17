<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!--  set Locale -->
<fmt:setLocale value="fr_CA"/>
<!-- set bundle -->
<fmt:setBundle basename="com/nt/commons/myfile"/>
<!-- Format message -->
<fmt:message var="msg" key="wishMsg"/>
Message is : ${msg }. <br>

<!-- format date -->
 <jsp:useBean id="sysDate"  class="java.util.Date"/>
 <fmt:formatDate  var="fdate" value="${sysDate }"/>
 Formatted  date is : ${fdate }. <br>
 
 <!-- Format numbers -->
 <fmt:formatNumber var="fPrice"  value="3434.33"/>
 Formatted  price is : ${fPrice }.

