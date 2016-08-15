<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>秒杀详情页</title>
<%@include file="common/tag.jsp"%>
<%@include file="common/head.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default text-center">
			<div class="panel-head ">
				<h2>${seckill.name}</h2>
			</div>
			<div class="panel-body">
				<h1 class="text-danger">
					<span class="glyphicon glyphicon-time"></span>
					<span class="glyphicon glyphicon-box" id="time_box"></span>
				</h1>
			</div>
		</div>
	</div>
	
	  <!--登录弹出层，输入电话 -->
	  <div id="killPhoneModal" class="modal fade">
	    <div class="modal-dialog">
	      <div class="modal-content">
	        <div class="modal-header">
	          <h3 class="modal-title text-center">
	            <span class="glyphicon glyphicon-phone"></span>秒杀电话：
	          </h3>
	        </div>
	        <div class="modal-body">
	          <div class="row">
	            <div class="col-xs-8 col-xs-offset-2">
	              <input type="text" name="killPhone" id="killPhoneKey" placeholder="填写手机号^o^" class="form-control">
	            </div>
	          </div>
	        </div>
	
	        <div class="modal-footer">
	          <!-- 验证信息-->
	          <span id="killPhoneMessage" class="glyphicon"></span>
	          <button type="button" id="killPhoneBtn" class="btn btn-success">
	            <span class="glyphicon glyphicon-phone"></span>
	            submit
	          </button>
	        </div>
	
	      </div>
	    </div>
	  </div>
</body>

	
	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	<script
		src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<!--引入CDN插件 -->
	<script
		src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script
		src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>
	<!--编写交互逻辑 -->
	<script src="script/seckill.js" type="text/javascript" charset="utf-8"></script>
	
	<script type="text/javascript">
	    $(function(){
	    	  //detail.jsp使用EL表达式向javascript传入参数
		      seckill.detail.init({
		    	  seckillId:${seckill.seckillId},
			      startTime:${seckill.beginTime.time},  //毫秒
			      endTime:${seckill.endTime.time}
		      });
	    });
	</script>
</html>