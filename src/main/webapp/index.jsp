<%@ page pageEncoding="UTF-8"%>
<jsp:include page="head.jsp" flush="true" >
    <jsp:param name="active" value="1" />
</jsp:include>



<div class="container-fluid">
    <div class="row-fluid">
        <% if(request.getAttribute("success") != null) { %>
        <div class="alert alert-success">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <%= request.getAttribute("success") %>
        </div>
        <% } %>
        
        <div class="hero-unit">
        <h1><a href="/register.jsp">立即注册</a></h1>
        </div>
    </div>
</div>



<jsp:include page="foot.jsp" flush="true" ></jsp:include>