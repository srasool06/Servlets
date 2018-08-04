<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql"  prefix="sql"%>

<!--  Create DataSource -->
<sql:setDataSource var="ds"  driver="oracle.jdbc.driver.OracleDriver"
                                      url="jdbc:oracle:thin:@localhost:1521:xe" user="system" password="manager"/>
                                      
<!-- create ResultSEt -->
<sql:query  sql="select * from emp" dataSource="${ds}"   var="rs" />     

 <!--  Process the ResultSEt -->
 <c:forEach var="row"  items="${rs.rows}">
    ${row.EMPNO } &nbsp;&nbsp;&nbsp;  ${row.ENAME } <br>
 </c:forEach>

                                
                                      
