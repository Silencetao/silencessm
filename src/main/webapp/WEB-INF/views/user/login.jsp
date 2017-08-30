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
		<title>用户登录-一个不会写bug的Silence个人博客网站</title>
	</head>
	<body>
		<input type="file" style="display: none;" id="image" onchange="showImage(this)" />
		<label for="image">
			点击这里选择要上传的图片
		</label><br /><br />
		<input type="button" value="开始上传" onclick="upload()" /><br /><br />
		<span id="response-msg"></span><br /><br />
		<progress id="progress-bar" style="width: 200px;" value="0" max="100" ></progress>
		<span id="percent-bar">0%</span><br /><br />
		<img alt="" src="" id="img-show"><br /><br />
	</body>
	<script type="text/javascript" src="/silencessm/resources/js/common/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="/silencessm/resources/js/common/ajaxfileupload.js"></script>
	<script type="text/javascript">
		function showImage(target) {
			if(typeof FileReader === 'undefined') {
				alert("浏览器不支持……");
				return ;
			}
			
			var reader = new FileReader();
			
			reader.onload = function(e) {
				$('#img-show').attr('src', this.result);
			}
			
			reader.readAsDataURL(document.getElementById($(target).attr('id')).files[0]);
		}
		
		function upload() {
			showStatus();
			var data = {};
			$.ajaxFileUpload({
				url : '/silencessm/user/upload',
				fileElementId : ['image'],
				secureuri : false,
				dataType : 'json',
				data : {'sign' : 'image'},
				type : 'POST',
				success: function(data) {
					$('#response-msg').text(data.message);
				},
				error: function(data) {
					console.log(data);
				}
			});
		}
		
		function showStatus() {
			var timer = setInterval(function(){
				$.get("/silencessm/user/getprogress",{},function(data,status){
					if (data.data && data.data.percent >= 1) {
						clearTimeout(timer);
					}
					$('#progress-bar').val(data.data.percent * 100);
					$('#percent-bar').text(data.data.percent * 100 + '%');
				},"json");
			},50);
		}
	</script>
</html>

