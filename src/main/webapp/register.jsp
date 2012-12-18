<%@ page pageEncoding="UTF-8"%>
<jsp:include page="head.jsp" flush="true" >
	<jsp:param name="active" value="0" />
</jsp:include>


<div class="container-fluid">
<div class="row-fluid">
<div class="span12">
	<h3>申请注册</h3>
	<form class="form-horizontal">
		<div class="control-group">
		    <label class="control-label" for="inputEmail">用户名</label>
		    <div class="controls">
		      <input type="text" id="username" />
		    </div>
		</div>
		
		<div class="control-group">
		    <label class="control-label" for="inputEmail">密码</label>
		    <div class="controls">
		      <input type="password" id="passwd" />
		    </div>
		</div>
		
		<div class="control-group">
		    <label class="control-label" for="inputEmail">确认密码</label>
		    <div class="controls">
		      <input type="password" id="passwd2" />
		    </div>
		</div>
		
		<div class="control-group">
		    <div class="controls">
		      <button type="submit" class="btn">确认</button>
		    </div>
		</div>
		
	</form>
		
</div>
</div>
</div>



<jsp:include page="foot.jsp" flush="true" ></jsp:include>