<!DOCTYPE html>
<html>
<head>
    <link href="<%=request.getContextPath()%>/public/css/mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
<form action="xuly?action=login" method="post">
    <div class="imgcontainer">
        <img src="<%=request.getContextPath()%>/public/images/img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container ">
        <div class="text-center form">
            <label><b>Username</b></label>
            <input type="text" placeholder="Enter Username" name="user_name" required><br>

            <label><b>Password</b></label>
            <input type="password" placeholder="Enter Password" name="pass_word" required>
            <%
                String str=(String)request.getAttribute("error");
                if(str!=null)
                {
                    out.print("<p>");
                    out.print(str);
                    out.print( "</p>");
                }
            %>
            <button type="submit" onclick="return test()">Login</button>
            <%--<button type="button" onclick="return test()">Login2</button>--%>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </div>

    </div>

    <div class="container">
        <div class="form">
            <button type="button" class="cancelbtn">Cancel</button>
            <span class="psw">Forgot <a href="#">password?</a></span>
        </div>

    </div>
</form>
    <script>
        function test()
        {
            var name=document.getElementsByName("user_name")[0].value;
            var pass=document.getElementsByName("pass_word")[0].value;
            console.log(name);
            if(name.trim()==""||pass.trim()=="")
            {
                alert("User and pass not empty");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
