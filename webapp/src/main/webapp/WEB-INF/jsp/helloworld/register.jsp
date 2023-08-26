<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h2>Register!</h2>
<c:url var="registerUrl" value="/register"/>
<form action="${registerUrl}" method="post">
    <div>
        <label>Email:
            <input type="text" name="email"/>
        </label>
    </div>
    <div>
        <label>Password:
            <input type="password" name="password"/>
        </label>
    </div>
    <div>
        <input type="submit" value="Let's go!"/>
    </div>
</form>
</body>
</html>
