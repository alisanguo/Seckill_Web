<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>秒杀列表页</title>
<%@include file="common/head.jsp"%>
<%@include file="common/tag.jsp"%>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>秒杀商品列表</h2>
			</div>
			<div class="panel-body">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>秒杀商品名称</th>
							<th>库存</th>
							<th>秒杀开始时间</th>
							<th>秒杀结束时间</th>
							<th>秒杀创建时间</th>
							<th>秒杀详情</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sk" items="${list}">
						<tr>
							<td>${sk.seckillId}</td>
							<td>${sk.name}</td>
							<td>${sk.number}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${sk.beginTime}"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${sk.endTime}"/></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${sk.createTime}"/></td>
							<td><a href="seckill/${sk.seckillId}/detail" class="btn btn-info" target="_blank">link</a></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
	<script
		src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>