
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <title> Transparent Login Form Design </title>
    <link rel="stylesheet" type="text/css" href="login.css">   
</head>
    <body>
        <div class="login-box">
    <img src="avatar.png" class="avatar">
        <h1>Login Here</h1>



        <form action="/Model2Architecture/CookieLoginServlet" method="post">
            <table>
                <tr>
                    <td>User Name</td>
                    <td>
                        <input type="text" name="userName">
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>
                        <input type="password" name="password">
                    </td>
                </tr>

                <tr>
                    <td align="right" colspan="2">
                           <input type="submit" name="login" value="Login">
             
                    </td>

                </tr>
            </table>
                    <%
            if (request.getAttribute("errMessage")!=null) {
                %>
                
                <p>Invalid user name or password</p>
       

        </form>
    <a href="forgotpass.html">Forget Password</a>  <br>
            <a href="register.html">New User? Register</a>
            
        </div>
</body>
</html>
