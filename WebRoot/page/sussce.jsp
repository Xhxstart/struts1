<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*"%> 
<%@page import="com.xhx.froms.UserForm"%>  
<%  
UserForm user = (UserForm)request.getAttribute("userForm");  
 %>  
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>  
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body> 
   welcome!<input type="text" id="username" name="username" value="<%=user.getUsername() %>" /> 
  </body>
</html>