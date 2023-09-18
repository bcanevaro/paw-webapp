<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<body>
<h1><c:out value="${loggedUser.name}" escapeXml="true"/></h1>
<h2><spring:message code="register.title"/></h2>
<c:url var="registerUrl" value="/register"/>
    <form:form modelAttribute="${userForm}" action="${registerUrl}" method="post">
    <div>
        <form:label path="name"><spring:message code="register.form.name"/>
            <form:input path="name"/>
        </form:label>
    </div>
    <div>
        <form:label path="password"><spring:message code="register.form.password"/>
            <form:input type="password" path="password"/>
        </form:label>
        <form:errors path="password" cssClass="error" element="p"/>
    </div>
        <div>
            <form:label path="repeatPassword"><spring:message code="register.form.repeatPassword"/>
                <form:input type="password" path="repeatPassword"/>
            </form:label>
            <form:errors path="repeatPassword" cssClass="error" element="p"/>
        </div>
    <div>
        <input type="submit" value="Let's go!"/>
    </div>
    </form:form>
</body>
</html>
