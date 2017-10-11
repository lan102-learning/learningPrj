<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" crossorigin="anonymous">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
<script type="text/javascript" src="js/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
<title>福建师大后勤公告推送</title>
<script type="text/javascript">
$(document).ready(function(){
    $("#addTime").click(function(){
      $("#catchTime").append("<div class=\"input-group date form_time col-md-5\" data-date=\"\" data-date-format=\"hh:ii\" data-link-field=\"dtp_input3\" data-link-format=\"hh:ii\"> <input class=\"form-control\" size=\"16\" type=\"text\" value=\"\" readonly> <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-remove\"></span></span> <span class=\"input-group-addon\"><span class=\"glyphicon glyphicon-time\"></span></span> <span id=\"removeTime\" class=\"input-group-addon\"><span class=\"glyphicon glyphicon-minus\"></span></span> </div>");
    });
  
  $("#catchTime div removeTime").click(function(){
      var current = $(this);
  });
  
  });    
</script>
<style type="text/css">
.littlebutton{
padding: 0px;
}
</style>
</head>
<body>
<div class="container col-md-12" >
    <h1 class="text-center" >福建师大后勤公告推送</h1>
    <form>
	  <div id="catchTime" class="form-group">
	   <label >抓取信息时间：每日</label>
	   <button id="addTime" type="button" class="btn btn-default glyphicon glyphicon-plus littlebutton" > </button>
	   <div class="input-group date form_time col-md-5" data-date="" data-date-format="hh:ii" data-link-field="dtp_input3" data-link-format="hh:ii">
          <input class="form-control" size="16" type="text" value="" readonly>
          <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
          <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
          <span class="input-group-addon"><span class="glyphicon glyphicon-minus"></span></span>
       </div>
	  </div>
	  <div class="form-group">
        <label >推送邮箱</label>
        <input type="email" class="form-control" size="16" id="exampleInputEmail1" placeholder="邮箱"  >
      </div>
	   <button type="submit" class="btn btn-default">保存</button>
    </form>
</div>
<script type="text/javascript">
    $('.form_datetime').datetimepicker({
        //language:  'fr',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        forceParse: 0,
        showMeridian: 1
    });
    $('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
    $('.form_time').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 1,
        minView: 0,
        maxView: 1,
        forceParse: 0
    });
    
</script>
</body>
</html>