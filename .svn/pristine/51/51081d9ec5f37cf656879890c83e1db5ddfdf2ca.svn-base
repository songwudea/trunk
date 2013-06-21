<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="/common/jspHead.jsp" %>
<!doctype html>
	<script type="text/javascript" >
		var searchItemList = function() {
	    	var queryParams = $('#item').datagrid('options').queryParams;
		    queryParams.name= $('#itemName').val();
	 		$('#item').datagrid('options').queryParams=queryParams; 
			$("#item").datagrid('reload');
    	}
    	
    var del = function (id, key ,value, keyname) {
    	var arr = $(key).val().split(",");
		arr = $.grep(arr,function(n, i) {
			return n != id;
		});    	
    	$(key).val(arr);
    	var parent = $(value).parent().parent();
    	$(value).parent().parent().empty();
    	$(keyname).val(parent.parent().parent().parent().parent().html());
    }
	
	var showDialog = function(key, type) {
		$('#key').val(key);
		$('#dlg1').dialog({
            minimizable: true,
            maximizable: true,
            resizable: true,
            modal: true,
			title: '选择品牌'
		});
		
		$('#dlg2').dialog({
            minimizable: true,
            maximizable: true,
            resizable: true,
            modal: true,
			title: '选择内容'
		});
		
		$('#dlg').dialog({
            minimizable: true,
            maximizable: true,
            resizable: true,
            modal: true,
			title: '选择商品'
		});
		
		if(type == "item") {
			$('#dlg').dialog('open');  
		} else if (type == "brand") {
			$('#dlg1').dialog('open');  
		} else if (type == "content") {
			$('#dlg2').dialog('open');  
		}
		
	}
	
	$(document).ready(function() {
		var json = eval($("#sitePageConfigValues").val());
		var page_publishs = eval( $("#pagePublishValues").val());
		$.each(json,function(index, attr) {
			var key = attr.entityType + "_" + attr.id;
			var keyName = attr.entityType + "_" + attr.id + "_name";
			var keyId = attr.entityType + "_" + attr.id + "_id";
			
			var dom = "<fieldset><legend>" + attr.nameKey + "</legend>";
			dom += "<input type='hidden' name='name_key' id='name_key' value=\"" + attr.nameKey + "\">";
			dom += "<input type='hidden' name='id_key' id='id_key' value=\"" + attr.id + "\">";
			dom += "<input type='hidden' name='entity_type' id='entity_type' value=\"" + attr.entityType + "\">";
			dom += "<input type='hidden' name='" + keyName + "' id='" + keyName + "'>";
			dom += "<input type='hidden' name='" + keyId + "' id='" + keyId + "'>";
			dom += "<div><label>可配置数量 : </label>" + "<span>" + attr.quantity + "</span>" + "</div>";
			dom += "<div><label>选择: </label>";
			dom += "<input type='button' onclick='showDialog(\"" + key +  "\",\"" + attr.entityType + "\");' value ='选择' /></div>";
			dom += "<span id='" + key + "'>";
			
			$.each(page_publishs, function(index, page_publish){
				if(page_publish.nameKey == attr.nameKey) {
					if(page_publish.entityName != "null") {
						dom += page_publish.entityName;
					}
				}
			});
			dom += "</span>";
			dom += "</div>"
			dom += "</fieldset>";
			$('fieldset:last').after(dom);
			
			$.each(page_publishs, function(index, page_publish){
				if(page_publish.nameKey == attr.nameKey) {
					var ids = [];
					var entityIds = page_publish.entityId.split(",");
					$.each(entityIds, function(index, id){
						ids.push(id);
					});
					
					$('#' + keyName).val(page_publish.entityName);
					$('#' + keyId).val(ids.join(","));
				}
			});
		});
		
		$('#item').datagrid({  
    		loadMsg:"正在加载......",
    		toolbar:[{
	        	text:'选择',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var rows = $('#item').datagrid('getSelections');
	         		var names = [];
	         		var ids = [];
	         		for(var i = 0; i < rows.length; i++) {
	         			ids.push(rows[i].id);
	         			names.push(rows[i].name);
	         		}  
	         		
	         		
	         		
	         		// 表格显示的key
	         		var table = '#' +$('#key').val();
	         		var keyId = table + "_id";
	         		var keyName = table + "_name";
	         		var tableId = "table_" + $('#key').val();
	         		
	         		// 这里判断是否有table这个元素
	         		if($(table + ":has(table)").length == 0) {
	         			var dom = "<div style=\"text-align:left;\">";
	         			dom += "<table id=" + tableId + " style=\"margin:auto;width:40%;\">"
						dom += "<th>商品名字</th><th>操作</th>"
						for(var i = 0; i < names.length; i++) {
							dom += "<tr>";
							dom += "<td>";
							dom += names[i];
							var keyv = $('#key').val() + "_id";
							dom += "</td><td><a onclick='del(" + ids[i]  + ",\"" + keyId + "\",this,\"" + keyName + "\");'>删除</a></td>"
							dom += "</tr>";
						}
						$(table).html(dom);
						dom += "</table></div>";
						$(keyName).val(dom);
		         		$(keyId).val(ids.join(","));
	         		} else {
	         			var dom;
	         			
	         			// 去除重复得
	         			var arr = $(keyId).val().split(",");
	         			$.each(names, function(index, name){
	         				
	         				// 判断是否重复了
	         				if($.inArray(ids[index] + "",arr) < 0) {
	         					arr.push(ids[index]);
		         				dom += "<tr>";
								dom += "<td>";
								dom += name;
								var keyv = $('#key').val() + "_id";
								dom += "</td><td><a onclick='del(" + ids[i]  + ",\"" + keyId + "\",this,\"" + keyName + "\");'>删除</a></td>"
								dom += "</tr>";
	         				} 
	         			});
	         			$('#' + tableId).find("tr:last").after(dom);
	         			// 读取table内容
	         			$(keyName).val($('#' + tableId).parent().parent().html());
	         			$(keyId).val(arr.join(","));
	         		}
	         		$('#dlg').dialog('close');  
	         		$('#item').datagrid('clearSelections');
	         	}
     		}],
			rows:2000,
			pageSize:2000,
			pageList:[2000],
			method:"post",
			url:'${ctx}/admin/item/list.html',  
			sortName:'id',
    		sortOrder:'asc',
    		pagination:false,
	     	columns:[[  
	        	{field:'id',title:'',width:60, checkbox:true},
	        	{field:'name',title:'商品名称',width:120}
	    	]]  
		}); 
		
		$('#brand').datagrid({  
    		loadMsg:"正在加载......",
			rows:2000,
			pageSize:2000,
			pageList:[2000],
			toolbar:[{
	        	text:'选择',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var rows = $('#brand').datagrid('getSelections');
	         		var names = [];
	         		var ids = [];
	         		for(var i = 0; i < rows.length; i++) {
	         			ids.push(rows[i].id);
	         			names.push(rows[i].name);
	         		}  
	         		
	         		
	         		
	         		// 表格显示的key
	         		var table = '#' +$('#key').val();
	         		var keyId = table + "_id";
	         		var keyName = table + "_name";
	         		var tableId = "table_" + $('#key').val();
	         		
	         		// 这里判断是否有table这个元素
	         		if($(table + ":has(table)").length == 0) {
	         			var dom = "<div style=\"text-align:left;\">";
	         			dom += "<table id=" + tableId + " style=\"margin:auto;width:40%;\">"
						dom += "<th>商品名字</th><th>操作</th>"
						for(var i = 0; i < names.length; i++) {
							dom += "<tr>";
							dom += "<td>";
							dom += names[i];
							var keyv = $('#key').val() + "_id";
							dom += "</td><td><a onclick='del(" + ids[i]  + ",\"" + keyId + "\",this,\"" + keyName + "\");'>删除</a></td>"
							dom += "</tr>";
						}
						$(table).html(dom);
						dom += "</table></div>";
						$(keyName).val(dom);
		         		$(keyId).val(ids.join(","));
	         		} else {
	         			var dom;
	         			
	         			// 去除重复得
	         			var arr = $(keyId).val().split(",");
	         			$.each(names, function(index, name){
	         				
	         				// 判断是否重复了
	         				if($.inArray(ids[index] + "",arr) < 0) {
	         					arr.push(ids[index]);
		         				dom += "<tr>";
								dom += "<td>";
								dom += name;
								var keyv = $('#key').val() + "_id";
								dom += "</td><td><a onclick='del(" + ids[i]  + ",\"" + keyId + "\",this,\"" + keyName + "\");'>删除</a></td>"
								dom += "</tr>";
	         				} 
	         			});
	         			$('#' + tableId).find("tr:last").after(dom);
	         			// 读取table内容
	         			$(keyName).val($('#' + tableId).parent().parent().html());
	         			$(keyId).val(arr.join(","));
	         		}
	         		$('#dlg1').dialog('close');  
	         		$('#brand').datagrid('clearSelections');
	         	}}],
			method:"post",
			url:'${ctx}/admin/brand/list.html',  
			pagination:false,
			sortName:'id',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'id',title:'',width:60, checkbox:true},
	        	{field:'name',title:'品牌名称',width:60}
	    	]]  
		}); 
		
		$('#content').datagrid({  
    		loadMsg:"正在加载......",
			rows:2000,
			pageSize:2000,
			pageList:[2000],
				toolbar:[{
	        	text:'选择',  
	         	iconCls:'icon-add',
	         	plain:true,
	         	handler:function() {
	         		var rows = $('#content').datagrid('getSelections');
	         		var names = [];
	         		var ids = [];
	         		for(var i = 0; i < rows.length; i++) {
	         			ids.push(rows[i].id);
	         			names.push(rows[i].htmlTitle);
	         		}  
	         		
	         		
	         		
	         		// 表格显示的key
	         		var table = '#' +$('#key').val();
	         		var keyId = table + "_id";
	         		var keyName = table + "_name";
	         		var tableId = "table_" + $('#key').val();
	         		
	         		// 这里判断是否有table这个元素
	         		if($(table + ":has(table)").length == 0) {
	         			var dom = "<div style=\"text-align:left;\">";
	         			dom += "<table id=" + tableId + " style=\"margin:auto;width:40%;\">"
						dom += "<th>商品名字</th><th>操作</th>"
						for(var i = 0; i < names.length; i++) {
							dom += "<tr>";
							dom += "<td>";
							dom += names[i];
							var keyv = $('#key').val() + "_id";
							dom += "</td><td><a onclick='del(" + ids[i]  + ",\"" + keyId + "\",this,\"" + keyName + "\");'>删除</a></td>"
							dom += "</tr>";
						}
						$(table).html(dom);
						dom += "</table></div>";
						$(keyName).val(dom);
		         		$(keyId).val(ids.join(","));
	         		} else {
	         			var dom;
	         			
	         			// 去除重复得
	         			var arr = $(keyId).val().split(",");
	         			$.each(names, function(index, name){
	         				
	         				// 判断是否重复了
	         				if($.inArray(ids[index] + "",arr) < 0) {
	         					arr.push(ids[index]);
		         				dom += "<tr>";
								dom += "<td>";
								dom += name;
								var keyv = $('#key').val() + "_id";
								dom += "</td><td><a onclick='del(" + ids[i]  + ",\"" + keyId + "\",this,\"" + keyName + "\");'>删除</a></td>"
								dom += "</tr>";
	         				} 
	         			});
	         			$('#' + tableId).find("tr:last").after(dom);
	         			// 读取table内容
	         			$(keyName).val($('#' + tableId).parent().parent().html());
	         			$(keyId).val(arr.join(","));
	         		}
	         		$('#dlg2').dialog('close');  
	         		$('#content').datagrid('clearSelections');
	         	}}],
			method:"post",
			url:'${ctx}/admin/content/list1.html',  
			pagination:false,
			sortName:'id',
    		sortOrder:'asc',
	     	columns:[[  
	        	{field:'id',title:'',width:60, checkbox:true},
	        	{field:'title',title:'标题',width:60}
	    	]]  
		}); 
		
		
    });
    </script>
	
	<div id="formwrapper">
		<c:if test="${message!=null}">
			<div id=xbox>
				${message}
			</div>
		</c:if>
		
		<form method="post" name="form" action="${ctx}/admin/indexpublish/edit.html">
			<input type="hidden" name="sitePageConfigValues" id="sitePageConfigValues" value=${sitePageConfigValues}>
			<input type="hidden" name="pagePublishValues" id="pagePublishValues" value='${pagePublishValues}'>
			<input type="hidden" name="keyName" id="keyName" />
			<input type="hidden" name="keyId" id="keyId" />
			<input type="hidden" name="pageType" id="pageType" value="${pageType}" />
			<input type="hidden" name="categoryId" id="categoryId" value="${categoryId}" />
			<input type="hidden" name="key" id="key" />
			<fieldset>
				<label>首页属性配置</label>
			</fieldset>
			<div class="enter">
				<input name="add" type="submit" class="buttom" value="完成" />
				<input name="submit" type="reset" class="buttom" value="重置" />
			</div>
		</form>
	</div>
	
	 <div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"  
	         closed="true" buttons="#dlg-buttons">  
	     <div id="tb" style="padding:5px;height:auto;">  
			商品名称 : <input style="width:90px" id="itemName" />  
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="searchItemList();">查询</a>  
		 </div>  
	     <div id="item"></div>
	 </div>	
	 </div>  
	 
	 <div id="dlg1" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"  
	         closed="true" buttons="#dlg-buttons">  
	     <div id="brand"></div>
	 </div>  
	 
	 <div id="dlg2" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px"  
	         closed="true" buttons="#dlg-buttons">  
	     <div id="content"></div>
	 </div>  
