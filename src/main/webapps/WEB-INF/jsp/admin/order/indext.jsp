<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>jQuery.EasyUI</title>
    <script type="text/javascript" >    
   $(document).ready(function() {
    	  $('#tt').treegrid({
		      method:"post",
		      url:'${ctx}/admin/order/list.html',
		      idField:'id',  
		      treeField:'orderNumber',  
		      rownumbers:false,
		      pagination:true,
		      fitColumns:true,
		      autoRowHeight:false,
		      pageSize:15
	  	});             
	  	                
	    var pager = $('#tt').treegrid('getPager');      
		pager.pagination({
				onSelectPage:function(pageNumber,pageSize){
				var orderNumber = $('#orderNumber').val();
				var status = $('#status').val();
				var userName = $('#userName').val();
				var shiptel = $('#shiptel').val(); 
	         	$(this).pagination('loading'); 
	            $('#tt').treegrid('options').url = '${ctx}/admin/order/list.html?pageNo='+pageNumber+'&orderNumber='+orderNumber+'&userName='+userName+'&shiptel='+shiptel+'&status='+status; 
	            $('#tt').treegrid('reload');
	            $('#tt').treegrid('loadData');
      		} 
		});
    });
    
    	var searchlist = function() {
			var orderNumber = $('#orderNumber').val();
			var status = $('#status').val();
			var userName = $('#userName').val();
			var shiptel = $('#shiptel').val(); 
			var url= '${ctx}/admin/order/list.html?pageNo= 1&orderNumber='+orderNumber+'&userName='+userName+'&shiptel='+shiptel+'&status='+status;
            $('#tt').treegrid('options').url = url; 
            $('#tt').treegrid('reload');
            $('#tt').treegrid('loadData');
            
           //$.post(url, {}, 
           //function(data){
           //    var d = data;        
           //     $('#tt').treegrid('loadData',d);
           //     $('#tt').treegrid('loadData',d);
           //}, 'json');
	    }
    </script>
			 

   <script>
		function downorders(){
			var loadingTip = $('#loadingTip');
     		loadingTip.show();
            loadingTip.ajaxStart(function(){
                loadingTip.text('loading...');
            });
     		$.post('${ctx}/admin/order/downorder.html',
     		{
     			orderNumber:$("#orderNumber").val(),
     			status:$("#status").val(),
     			userName:$("#userName").val(),
     			shiptel:$("#shiptel").val()
     		},
     		function(data){
    			if(data != '') {
    				loadingTip.ajaxStop(function(){
		                loadingTip.empty();
		                loadingTip.hide();
		            });
            		$('#tt').datagrid('reload');//刷新当前页数据
            		window.location.href = "${ctx}"+data;
            		$.messager.alert('操作成功','导出订单成功','info');
    			} else {
    				$.messager.alert('操作失败','导出订单失败','info');
    			}
             });
		}
		
	</script>
</head>
<body>
	<div id="loadingTip" style="height:80px;width:300px; display:none; color:red; align:middle; font-size:24px;"></div>
		<form method="post" name="form" action="${ctx}/admin/order/list.html">
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			订单编号编号:<input style="width:150px" id="orderNumber" name="orderNumber" value="${order.orderNumber}" />  
			订单状态:<select name="status" id="status" name="status">
				<option value="all" <c:if test="${'all' == statuss}">selected="selected"</c:if> >全部</option>
				<c:forEach var="sta" items="${status}">
					<c:if test="${statuss != 'all'}">
						<option value="${sta}" <c:if test="${sta == statuss}">selected="selected"</c:if> >${sta.value}</option>
					</c:if>
					<c:if test="${statuss == 'all'}">
						<option value="${sta}" >${sta.value}</option>
					</c:if>
				</c:forEach>
			    </select>
			用户姓名:<input style="width:70px" id="userName" name="userName" value="${order.userName}"/>   
			手机:<input style="width:150px" id="shiptel" name="shiptel" value="${order.shiptel}"/>  
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchlist();">查询</a>  
		</div>
		</form>
		<div id="tb" style="padding:5px;height:auto;float:left;">  
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" onclick="downorders();">下载订单</a>
		</div>	
		<div style="clear:both"></div>
	<table id="tt" title="订单管理" class="easyui-treegrid" style="width:900px;height:500px">
		<thead>
			<tr>
				<th data-options="field:'orderNumber',editor:'text'" rowspan="2" width="150">订单编号</th>
				<th colspan="4" width="550">订单详情</th>
			</tr>
			<tr>
				<th data-options="field:'id',editor:'text'" width="137">ID</th>
				<th data-options="field:'userName',editor:'text'" width="137">用户</th>
				<th data-options="field:'createdAtS',editor:'text'" width="137">创建时间</th>
				<th data-options="field:'status',editor:'text'" width="137">状态</th>
			</tr>
		</thead>
	</table>
	
</body>
</html>
