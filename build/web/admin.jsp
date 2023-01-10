<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login | Event Management System</title>
	<link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
</head>
<body>
	<div class="login-wrap">
            <form action="<%=request.getContextPath()%>/login" method="post">
		<div class="login-html">
			<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">Sign In</label>
			<input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab"></label>
			<div class="login-form">
				<div class="sign-in-htm">
					<div class="group">
						<label for="email" class="label">Email</label>
						<input name="email" id="email" type="text" class="input" required>
					</div>
					<div class="group">
						<label for="pass" class="label">Password</label>
						<input name="password" id="pass" type="password" class="input" data-type="password" required>
					</div>
					<div class="group">
						<input type="submit" class="button" value="Login">
					</div>
				</div>
				
			</div>
		</div>
            </form>
	</div>
</body>
</html>

<!--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <br>
        <br>
        <div class="container">
            <a class="btn btn-success btn-lg" href="StaffServlet?action=list">Staff</a>
            <a class="btn btn-success btn-lg" href="StattendanceServlet?action=list">Attendance</a>
            <a class="btn btn-success btn-lg" href="LeaveServlet?action=list">Leave</a>
            <a class="btn btn-success btn-lg" href="SalaryServlet?action=list">Salary</a>
            <a class="btn btn-success btn-lg" href="UserServlet?action=list">Users</a>
        </div>
    </body>
</html>-->
