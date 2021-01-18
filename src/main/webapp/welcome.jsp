<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<center>
<h1>
    Welcome <%= session.getAttribute("user").getUsername() %>!
</h1>
</body>
</html>