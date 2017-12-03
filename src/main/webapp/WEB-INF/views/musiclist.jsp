<%@ page language="java" contentType="text/html; charset=Utf-8"
	pageEncoding="Utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<title>音乐列表</title>
<!-- web路径：不以开始的相对路径，找资源，以当前资源的路径为基准，经常容易出问题，
以/开始的相对路径，找资源，以服武器的路径为标准(http://localhost:3306)，需要加上项目名、
http://localhost:3306/gqccc -->
<!-- 引入jQuery -->
<script src="${APP_PATH} /static/js/jquery-latest.js"></script>
<!-- 引入样式 -->
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<!-- 搭建显示页面 -->
	<div class="container">
		<!-- 标题 -->
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<h1>歌曲猜猜猜后台管理系统</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-primary">新增</button>
				<button type="button" class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 信息 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th>#</th>
						<th>mAddress</th>
						<th>mName</th>
						<th>mCD</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list}" var="music">
						<tr>
							<th>${music.mid}</th>
							<th>${music.maddress}</th>
							<th>${music.mmusicname}</th>
							<th>${music.mcd}</th>
							<th>
								<button type="button" class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil"></span> 编辑
								</button>
								<button type="button" class="btn btn-danger btn-sm">
									<span class=" glyphicon glyphicon-trash"></span> 删除
								</button>
							</th>
						</tr>
					</c:forEach>

				</table>
			</div>
		</div>
		<!-- 分页 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-5">当前${pageInfo.pageNum }页，总${pageInfo.pages}页，总${pageInfo.total}条记录
			</div>
			<!-- 分页条信息 -->
			<div class="col-md-7">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="${APP_PATH }/musics?pn=1">首页</a></li>
					<c:if test="${ pageInfo.hasPreviousPage}">
						<li><a href="${APP_PATH }/musics?pn=${ pageInfo.pageNum-1}"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>

					<c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
						<c:if test="${page_Num == pageInfo.pageNum}">
							<li class="active"><a href="#">${page_Num}</a></li>
						</c:if>

						<c:if test="${page_Num != pageInfo.pageNum}">
							<li><a href="${APP_PATH }/musics?pn=${page_Num}">${page_Num}</a></li>
						</c:if>

					</c:forEach>
					<c:if test="${pageInfo.hasNextPage }">
						<li><a href="${APP_PATH }/musics?pn=${ pageInfo.pageNum + 1}"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="${APP_PATH }/musics?pn=${ pageInfo.pages}">末页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
</body>
</html>