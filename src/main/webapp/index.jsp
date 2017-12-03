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
<script src="${APP_PATH}/static/js/jquery-latest.js"></script>
<script src="${APP_PATH}/static/js/jquerysession.js"></script>
<!-- 引入样式 -->
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>

<script
	src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/fileinput.min.js"
	type="text/javascript"></script>
<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/zh.js"
	type="text/javascript"></script>
<link
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/fileinput.min.css"
	media="all" rel="stylesheet" type="text/css" />
</head>
<body>

	<!-- 员工添加的模态框 -->
	<!-- Modal -->
	<div class="modal fade" id=musicAddModel tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document" style="width: 700px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增音乐</h4>
				</div>
				<div class="modal-body">
					<form enctype="multipart/form-data" id='modal-form'>
					<p>文件名请不要出现中文</p>
						<input id="myfile" name="myfile" class="file-loading" type="file"
							multiple data-min-file-count="1"> <br>
					</form>
					<table contentEditable="true"  class="table table-striped" id="response-table"
						style="display: none;"></table>
						<p id = 'response-message'></p>
				</div>
				<div class="modal-footer">
					<button id="next" disabled="disabled" type="button"
						class="btn btn-default">下一步</button>
						<button id="ok" type="button"
						class="btn btn-default">确认</button>
					<button id="savebtn" style="display: none;" type="button"
						class="btn btn-primary">保存修改</button>
						<button id="updateBtn" style="display: none;" type="button"
						class="btn btn-primary">更新</button>
				</div>
			</div>
		</div>
	</div>
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
				<button id="music_add_modal_btn" type="button"
					class="btn btn-primary">新增</button>
				<button type="button" class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 信息 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover" id="musics_table">
					<thead>
						<tr>
							<th>#</th>
							<th>mAddress</th>
							<th>mName</th>
							<th>mCD</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
		</div>
		<!-- 分页 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-5" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-7" id="page_nav_area"></div>
		</div>
	</div>

	<script type="text/javascript">

	
	$("#music_add_modal_btn").click(function() {
		$("#next").css('display','block');
		$("#next").attr("disabled",true); 
		$("#ok").css('display','none'); 
		$('#savebtn').css('display','none'); 
		$("#updateBtn").css('display','none'); 
		$('#modal-form').css('display','block'); 
		$('#response-table').css('display','none'); 
		$('#response-table').empty();
		$('<tr></tr>').append($('<th></th>').append('mid'))
		.append($('<th></th>').append('mAddress'))
		.append($('<th></th>').append('mName'))
		.append($('<ta></ta>').attr("colspan","2").append('操作'))
		.appendTo('#response-table');
		$(".fileinput-remove-button").click(); 
		$("#musicAddModel").modal({
			backdrop : "static"
		});
	
	});
	
		$("#next").click(function(){
			
			$('#modal-form').css('display','none'); 
			$('#response-table').css('display','block'); 
			
			$("#next").css('display','none'); 
			$('#savebtn').css('display','block'); 
		});
		
		$("#savebtn").click(function(){
			var array = [];
			var table = $('#response-table');
			 var head = table.find("th");
			 table.find("tr").each(function () {
				var json = {};
				$(this).find("td").each(function (i) {
				json[head.eq(i).html()] = $(this).text();
				 });
				array.push(json);
			 });
			 
			console.log(array);
			$.ajax({
				url : "${APP_PATH}/insertmusics",
				data : {"datalist":JSON.stringify(array)},
				type : "POST",
				success : function(result) {
					$('#response-table').css('display','none'); 
					$('#response-table').empty();
					$('#savebtn').css('display','none'); 
					console.log(result.code);
					console.log(result.msg);
					if(result.code == 100){
						//success
						$("#response-message").html(result.msg);
						
					}else{
						//fail
						
						$("#response-message").html(result.extend.failinfo);
						
					}
					$("#ok").css('display','block'); 
				}
			});
		});
		
		$("#ok").click(function(){
			$("#response-message").html("");
			$('#musicAddModel').modal('hide');
			//window.location.reload();
			to_page(pageNum);
		});
		
		$("#myfile").fileinput({
			language : 'zh',
			uploadUrl : 'upload', // you must set a valid URL here else you will get an error  
			allowedFileExtensions : [ 'mp3' ],
			maxFileCount : 5, //同时最多上传3个文件  
			minFileCount : 1,
			//allowedFileTypes: ['image', 'video', 'flash'],  这是允许的文件类型 跟上面的后缀名还不是一回事  
			//这是文件名替换  
			slugCallback : function(filename) {
				return filename.replace('(', '_').replace(']', '_');
			}
		});
		//异步上传返回结果处理
		$('#myfile').on('fileerror', function(event, data, msg) {
			console.log("fileerror");
			console.log(data);
		});
	
		//异步上传返回结果处理
		$("#myfile").on("fileuploaded",
				function(event, data, previewId, index) {
					console.log("fileuploaded");
					var ref = $(this).attr("data-ref");
					$("input[name='" + ref + "']").val(data.response.url);
					if(data.response.code == 100){
						console.log(data.response.extend.mName);
						console.log(data.response.extend.maddress);
						//console.log("tr:"+$("#response-table").find("tr").length);
						var count = $("#response-table").find("tr").length;
						$("<tr></tr>").append($("<td></td>").append(data.response.extend.mid+count))
						.append($("<td></td>").append(data.response.extend.maddress))
						.append($("<td></td>").append(data.response.extend.mName))
						.append($("<ta></ta>").append($("<button></button>").attr("id","moveup").addClass(
						"btn btn-primary btn-xs").append("<span></span>").addClass("glyphicon glyphicon-chevron-up")))
						.append($("<ta></ta>").append($("<button></button>").attr("id","movedown").addClass(
						"btn btn-warning btn-xs").append("<span></span>").addClass("glyphicon glyphicon-chevron-down")))
						.appendTo("#response-table");
						$("#next").attr("disabled",false); 
				
						
					}else{
						alert("上传失败");
						$('#myfile').on('fileerror', function(event, data, msg) {
							console.log("fileerror");
							console.log(data);
						});
						
					}
				});
		//上传前
		$('#myfile').on('filepreupload',
				function(event, data, previewId, index) {
					console.log("filepreupload");
				});
/*
 * 上移 下移 表格tr
 */
 $(document).on("click","#moveup",function(){
 
 var objParentTR=$(this).parent().parent(); 
 var prevTR=objParentTR.prev(); 
 var prevprevTR = prevTR.prev();

 if(prevTR.length>0&&prevprevTR.length>0) 
 { 
 prevTR.insertAfter(objParentTR); 
 } 
 });
 
 $(document).on("click","#movedown",function(){
 var objParentTR=$(this).parent().parent(); 
 var nextTR=objParentTR.next(); 
 if(nextTR.length>0) 
 { 
 nextTR.insertBefore(objParentTR); 
 } 
 }); 

		
		
		
		
		//1、页面加载完成以后，直接发送ajax请求，要到分页数据
		var modal_form;
		var response_table;
		var pageNum = 1;
		$(function() {
			modal_form = $('#modal-form');
			response_table = $('#response-table');
			if($.session.get('key')!="jwj1648"){
			var key = prompt("请输入密码","");
			 $.session.set('key', key)
			 }
			if($.session.get('key') == "jwj1648"){
			to_page(pageNum);
			}else{
				alert("输入错误");
				$("body").remove();
			}
			
		
		});

		function to_page(pn) {
		
			$.ajax({
				url : "${APP_PATH}/api/musics",
				data : "pn=" + pn + "&uid=admin",
				type : "GET",
				success : function(result) {
					//console.log(result);
					//1、解析并显示分页信息
					build_musics_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					build_page_nav(result);
				}
			});
		
		}

		function build_musics_table(result) {

			$("#musics_table tbody").empty();

			var musics = result.extend.pageInfo.list;
			$.each(musics, function(index, item) {
				var midTd = $("<td></td>").append(item.mid);
				var maddressTd = $("<td></td>").append(item.maddress);
				var mmusicnameTd = $("<td></td>").append(item.mmusicname);
				var mcdTd = $("<td></td>").append(item.mcd);
				var editBtn = $("<button></button>").attr("id","editBtn").addClass(
						"btn btn-primary btn-sm").append(
						$("<span></span>").addClass(
								"glyphicon glyphicon-pencil")).append($("<c></c>").append("编辑"));
				var delBtn = $("<button></button>").attr("id","delBtn").addClass(
						"btn btn-danger btn-sm").append(
						$("<span></span>")
								.addClass("glyphicon glyphicon-trash")).append(
						"删除");
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(
						delBtn);
				$("<tr></tr>").append(midTd).append(maddressTd).append(
						mmusicnameTd).append(mcdTd).append(btnTd).appendTo(
						"#musics_table tbody");
				
			});
			
		}
		//解析显示分页信息
		function build_page_info(result) {
			$("#page_info_area").empty();

			$("#page_info_area").append(
					"当前" + result.extend.pageInfo.pageNum + "页，总"
							+ result.extend.pageInfo.pages + "页，总"
							+ result.extend.pageInfo.total + "条记录 ");
		}
		//解析显示页条
		function build_page_nav(result) {
			$("#page_nav_area").empty();

			var ul = $("<ul></ul>").addClass("pagination");

			var firstPageLi = $("<li></li>").append(
					$("<a></a>").append("首页").attr("href", "#"));
			var prePageLi = $("<li></li>").append(
					$("<a></a>").append("&laquo;"));
			if (result.extend.pageInfo.hasPreviousPage == false) {
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}
			firstPageLi.click(function() {
				pageNum = 1;
				to_page(pageNum);
			});
			prePageLi.click(function() {
				if (result.extend.pageInfo.pageNum > 1)
					pageNum = result.extend.pageInfo.pageNum-1;
					to_page(pageNum);
			});

			var nextPageLi = $("<li></li>").append(
					$("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append(
					$("<a></a>").append("末页").attr("href", "#"));
			if (result.extend.pageInfo.hasNextPage == false) {
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}
			nextPageLi
					.click(function() {
						if (result.extend.pageInfo.pageNum < result.extend.pageInfo.pages)
							pageNum = result.extend.pageInfo.pageNum + 1;
							to_page(pageNum);
					});
			lastPageLi.click(function() {
				pageNum = result.extend.pageInfo.pages;
				to_page(pageNum);
			});

			ul.append(firstPageLi).append(prePageLi);

			$.each(result.extend.pageInfo.navigatepageNums, function(index,
					item) {
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if (result.extend.pageInfo.pageNum == item) {
					numLi.addClass("active");
				}
				numLi.click(function() {
					pageNum = item;
					to_page(pageNum);
				});
				ul.append(numLi);
			});
			ul.append(nextPageLi).append(lastPageLi);

			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		//单个删除
		$(document).on("click","#delBtn",function(){
			var mid = $(this).parents("tr").find("td:eq(0)").text();
			var mName = $(this).parents("tr").find("td:eq(2)").text();
			var delInfo = "是否删除 ："+mid+" ， "+ mName;
			//alert("是否删除 ："+$(this).parents("tr").find("td:eq(0)").text()+" ， "+$(this).parents("tr").find("td:eq(2)").text());
			if(confirm(delInfo)){
				$.ajax({
					url : "${APP_PATH}/delmusic/"+mid,
					type : "DELETE",
					success:function(result){
						alert(result.msg);
						to_page(pageNum);
					}
				});
			}
		});
		$(document).on("click","#editBtn",function(){
			var mid = $(this).parents("tr").find("td:eq(0)").text();
			var mAddress = $(this).parents("tr").find("td:eq(1)").text();
			var mName = $(this).parents("tr").find("td:eq(2)").text();
			$("#next").css('display','none');
			$("#ok").css('display','none'); 
			$('#savebtn').css('display','none'); 
			$("#updateBtn").css('display','block'); 
			$('#response-table').css('display','block'); 
			$('#modal-form').css('display','none'); 
			$('#response-table').empty();
			$('<tr></tr>').append($('<th></th>').append('mid')).append($('<th></th>').append('mAddress'))
			.append($('<th></th>').append('mName')).appendTo('#response-table');
			$('<tr></tr>').append($('<td></td>').append(mid)).append($('<td></td>').append(mAddress))
			.append($('<td></td>').append(mName)).appendTo('#response-table');
			$(".fileinput-remove-button").click(); 
			$("#musicAddModel").modal({
				backdrop : "static"
			});
		});
		$("#updateBtn").click(function(){
			var array = [];
			var table = $('#response-table');
			 var head = table.find("th");
			 table.find("tr").each(function () {
				var json = {};
				$(this).find("td").each(function (i) {
				json[head.eq(i).html()] = $(this).text();
				 });
				array.push(json);
			 });
			//+$('#response-table').find("td").eq(0).html()
			$.ajax({
				url : "${APP_PATH}/updatemusic/",
				type : "POST",
				data : {"datalist":JSON.stringify(array)},
				success:function(result){
					$('#response-table').css('display','none'); 
					$('#response-table').empty();
					$('#updateBtn').css('display','none'); 
					console.log(result.code);
					console.log(result.msg);
				
						$("#response-message").html(result.msg);
					
					$("#ok").css('display','block'); 
					
				}
			});
		});
	</script>


</body>
</html>