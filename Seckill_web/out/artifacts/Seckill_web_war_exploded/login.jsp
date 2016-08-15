<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="WEB-INF/jsp/common/head.jsp"%>
</head>
<body>
	<!-- <form action="seckill/login" >
	
	</form> -->
	<input id="submit" type="button" value="提交"/>
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	<script type="text/javascript">
		$("#submit").click(function(){
			$.ajax({
				url:'seckill/login',
				success:function(result){
					alert("aa"+result);
				}
				 ,
				error:function(message){
					alert("bb");
					loading.result(message||'登录失败');
					isSubmiting = false;
				
				}
			});
		});
		
	</script>
</body>
</html>