<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>List of clients:</h2>
<c:forEach items="${clients}" var="client">
        <h3>${client.name}</h3>
        <p>${client.province}</p>
        <br/>
</c:forEach>
<h2>Client for testing</h2>
<p>${client.name}</p>
</body>
</html>
