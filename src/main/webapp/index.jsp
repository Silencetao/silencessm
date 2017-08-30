<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>陈涛个人博客-一个不会写bug的Silence个人博客网站</title>
	</head>
	<style type="text/css">
		.leftDiv, .rightDiv {
			float: left;
			position: relative;
			width: 50px;
			height: 100px;
			overflow: hidden;
		}
		.leftInnerDiv, .rightInnerDiv {
			position: absolute;
			width: 200%;
			height: 100%;
			border: 5px solid yellowgreen;
			border-radius: 50%;
			box-sizing: border-box;
		}
		.leftInnerDiv {
			clip: rect(0px, 100px, 100px, 50px);
			animation: rotate 2s 2s linear forwards;
		}
		.rightInnerDiv {
			left: -100%;
			/* clip: rect(0px, 50px, 100px, 0px);
			animation: rotate 2s linear forwards; */
		}
		@keyframes rotate {
			from {
				transform: rotate(0deg);
			}
			to {
				transform: rotate(100deg);
			}
		}
	</style>
	<body>
		<div class="outDiv">
			<div class="leftDiv">
				<div class="leftInnerDiv"></div>
			</div>
			<div class="rightDiv">
				<div class="rightInnerDiv"></div>
			</div>
		</div>
	</body>
</html>

