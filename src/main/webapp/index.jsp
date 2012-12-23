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
        
        <% if(request.getAttribute("error") != null) { %>
        <div class="alert alert-error">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <%= request.getAttribute("error") %>
        </div>
        <% } %>
        
        <div class="hero-unit">
        <h1><a href="/register.jsp">立即注册</a></h1>
        </div>
       
        <% 
        Cookie cookies[] = request.getCookies(); 
        String ateyesuid = null;
        for (int i=0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("ateyesuid")) {
                ateyesuid = cookies[i].getValue();  
            }
        }
        %> 
        
        <form action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post">
			<input type="hidden" name="cmd" value="_s-xclick">
			<input type="hidden" name="hosted_button_id" value="YJGV9AUH2HPB4">
			<input type="hidden" name="charset" value="utf-8" />
			<input type="hidden" name="notify_url" value="http://ssh.ateyes.com/purchased">
			<input type="hidden" name="custom" value="<%= ateyesuid %>">
			<table>
			<tr><td><input type="hidden" name="on0" value="&#35831;&#36873;&#25321;使用&#26102;&#38388;">&#35831;&#36873;&#25321;使用&#26102;&#38388;</td></tr><tr><td><select name="os0">
			    <option value="包月">包月 $8.00 HKD</option>
			    <option value="半年">半年 $40.00 HKD</option>
			</select></td></tr>
			</table>
			<input type="hidden" name="currency_code" value="HKD">
			<input type="image" src="https://www.sandbox.paypal.com/zh_HK/HK/i/btn/btn_buynowCC_LG_wCUP.gif" border="0" name="submit" alt="PayPal － 更安全、更簡單的網上付款方式！">
			<img alt="" border="0" src="https://www.sandbox.paypal.com/zh_HK/i/scr/pixel.gif" width="1" height="1">
		</form>
        
        
        <!--  
        <form action="https://www.paypal.com/cgi-bin/webscr" method="post">
			<input type="hidden" name="cmd" value="_s-xclick">
			<input type="hidden" name="hosted_button_id" value="XARV39NDJADRS">
			<input type="hidden" name="charset" value="utf-8" />
			<table>
			<tr><td><input type="hidden" name="on0" value="选择使用时间">选择使用时间</td></tr><tr><td><select name="os0">
			    <option value="购买一周">购买一周 $ 0.20 USD</option>
			    <option value="购买整月">购买整月 $ 0.80 USD</option>
			    <option value="购买半年">购买半年 $ 4.50 USD</option>
			    <option value="购买整年">购买整年 $ 8.00 USD</option>
			</select> </td></tr>
			</table>
			<input type="hidden" name="currency_code" value="USD">
			<input type="image" src="https://www.paypalobjects.com/zh_XC/C2/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal——最安全便捷的在线支付方式！">
			<img alt="" border="0" src="https://www.paypalobjects.com/zh_XC/i/scr/pixel.gif" width="1" height="1">
		</form>
		-->
        
    </div>
</div>



<jsp:include page="foot.jsp" flush="true" ></jsp:include>