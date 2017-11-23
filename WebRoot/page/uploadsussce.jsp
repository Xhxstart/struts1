<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page language="java" import="java.util.*"%> 
<%@ page import="com.xhx.froms.CsvfileTorikomiForm"%>  
<%  
CsvfileTorikomiForm fileForm = (CsvfileTorikomiForm)request.getAttribute("fileForm");  
 %>  
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>  
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
 <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css"> 
  <link rel="stylesheet" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
  <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
  <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  </script>
<title>Insert title here</title>
</head>
<body> 
   welcome!<span><%=fileForm.getFilePath().getFileName()%></span>
      
  </body>
</html>