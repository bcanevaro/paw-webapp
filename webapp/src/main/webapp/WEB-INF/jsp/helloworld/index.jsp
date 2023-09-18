<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <link href="/css/main.css" rel="stylesheet"/>
</head>
<body>
<h1><c:out value="${loggedUser.name}" escapeXml="true"/></h1>
    <h2><spring:message code="index.greeting" arguments="${user.username},<i>unsafe</i>" htmlEscape="true"/></h2>
    <h5><spring:message code="index.userid" arguments="${user.userId}"/></h5>
</body>
</html>