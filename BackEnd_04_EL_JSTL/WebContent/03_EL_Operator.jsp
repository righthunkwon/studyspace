<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Operator</title>
</head>
<body>
	<!-- 괄호 안의 문자로 대체 가능 -->
	산술연산자 : +, -, *, /(div), %(mod) <br/>
	관계연산자 : ==(eq) !=(nq), <(lt), >(gt), <=(le), >=(ge) <br/>
	조건연산자 : 조건 ? true : false <br/>
	논리연산자 : &&(and), ||(or), !(not) <br/>
	null : empty <br/><br/> <!-- 조건문에서 편하게 활용할 수 있다. --> 
	
	<!-- 예시-->
	\${5+2} : ${5+2} <br/>
	\${5 > 2} : ${5 > 2} <br/>
	\${5 gt 2} : ${5 gt 2 }<br/>
	\${5 eq 2} : ${5 eq 2 }<br/>
</body>
</html>