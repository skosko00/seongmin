<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% int firstValue = Integer.parseInt(request.getParameter("firstValue"));
   int secondValue = Integer.parseInt(request.getParameter("secondValue")); 
   String select = request.getParameter("cal"); 
   String str = "";
   switch(select)
   {
   case "+":
	   str = firstValue + "+" + secondValue + "=" + (firstValue+secondValue); 
	   break;
   case "-":
	   str = firstValue + "-" + secondValue + "=" + (firstValue-secondValue); 
	   break;
   case "*":
	   str = firstValue + "*" + secondValue + "=" + (firstValue*secondValue); 
	   break;
   case "/":
	   str = firstValue + "/" + secondValue + "=" + (firstValue/(double)secondValue); 
	   break;
   }
%> 
<%= str %>
</body>
</html>