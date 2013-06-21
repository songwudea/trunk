package org.apache.jsp.WEB_002dINF.jsp.admin.indexpublish;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class edit_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/common/jspHead.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_005fset_005f0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("\t<script type=\"text/javascript\" >\n");
      out.write("\t\tvar searchItemList = function() {\n");
      out.write("\t    \tvar queryParams = $('#item').datagrid('options').queryParams;\n");
      out.write("\t\t    queryParams.name= $('#itemName').val();\n");
      out.write("\t \t\t$('#item').datagrid('options').queryParams=queryParams; \n");
      out.write("\t\t\t$(\"#item\").datagrid('reload');\n");
      out.write("    \t}\n");
      out.write("    \t\n");
      out.write("    var del = function (id, key ,value, keyname) {\n");
      out.write("    \tvar arr = $(key).val().split(\",\");\n");
      out.write("\t\tarr = $.grep(arr,function(n, i) {\n");
      out.write("\t\t\treturn n != id;\n");
      out.write("\t\t});    \t\n");
      out.write("    \t$(key).val(arr);\n");
      out.write("    \tvar parent = $(value).parent().parent();\n");
      out.write("    \t$(value).parent().parent().empty();\n");
      out.write("    \t$(keyname).val(parent.parent().parent().parent().parent().html());\n");
      out.write("    }\n");
      out.write("\t\n");
      out.write("\tvar showDialog = function(key, type) {\n");
      out.write("\t\t$('#key').val(key);\n");
      out.write("\t\t$('#dlg1').dialog({\n");
      out.write("            minimizable: true,\n");
      out.write("            maximizable: true,\n");
      out.write("            resizable: true,\n");
      out.write("            modal: true,\n");
      out.write("\t\t\ttitle: '选择品牌'\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t$('#dlg2').dialog({\n");
      out.write("            minimizable: true,\n");
      out.write("            maximizable: true,\n");
      out.write("            resizable: true,\n");
      out.write("            modal: true,\n");
      out.write("\t\t\ttitle: '选择内容'\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t$('#dlg').dialog({\n");
      out.write("            minimizable: true,\n");
      out.write("            maximizable: true,\n");
      out.write("            resizable: true,\n");
      out.write("            modal: true,\n");
      out.write("\t\t\ttitle: '选择商品'\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\tif(type == \"item\") {\n");
      out.write("\t\t\t$('#dlg').dialog('open');  \n");
      out.write("\t\t} else if (type == \"brand\") {\n");
      out.write("\t\t\t$('#dlg1').dialog('open');  \n");
      out.write("\t\t} else if (type == \"content\") {\n");
      out.write("\t\t\t$('#dlg2').dialog('open');  \n");
      out.write("\t\t}\n");
      out.write("\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t$(document).ready(function() {\n");
      out.write("\t\tvar json = eval($(\"#sitePageConfigValues\").val());\n");
      out.write("\t\tvar page_publishs = eval( $(\"#pagePublishValues\").val());\n");
      out.write("\t\t$.each(json,function(index, attr) {\n");
      out.write("\t\t\tvar key = attr.entityType + \"_\" + attr.id;\n");
      out.write("\t\t\tvar keyName = attr.entityType + \"_\" + attr.id + \"_name\";\n");
      out.write("\t\t\tvar keyId = attr.entityType + \"_\" + attr.id + \"_id\";\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tvar dom = \"<fieldset><legend>\" + attr.nameKey + \"</legend>\";\n");
      out.write("\t\t\tdom += \"<input type='hidden' name='name_key' id='name_key' value=\\\"\" + attr.nameKey + \"\\\">\";\n");
      out.write("\t\t\tdom += \"<input type='hidden' name='id_key' id='id_key' value=\\\"\" + attr.id + \"\\\">\";\n");
      out.write("\t\t\tdom += \"<input type='hidden' name='entity_type' id='entity_type' value=\\\"\" + attr.entityType + \"\\\">\";\n");
      out.write("\t\t\tdom += \"<input type='hidden' name='\" + keyName + \"' id='\" + keyName + \"'>\";\n");
      out.write("\t\t\tdom += \"<input type='hidden' name='\" + keyId + \"' id='\" + keyId + \"'>\";\n");
      out.write("\t\t\tdom += \"<div><label>可配置数量 : </label>\" + \"<span>\" + attr.quantity + \"</span>\" + \"</div>\";\n");
      out.write("\t\t\tdom += \"<div><label>选择: </label>\";\n");
      out.write("\t\t\tdom += \"<input type='button' onclick='showDialog(\\\"\" + key +  \"\\\",\\\"\" + attr.entityType + \"\\\");' value ='选择' /></div>\";\n");
      out.write("\t\t\tdom += \"<span id='\" + key + \"'>\";\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$.each(page_publishs, function(index, page_publish){\n");
      out.write("\t\t\t\tif(page_publish.nameKey == attr.nameKey) {\n");
      out.write("\t\t\t\t\tif(page_publish.entityName != \"null\") {\n");
      out.write("\t\t\t\t\t\tdom += page_publish.entityName;\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\tdom += \"</span>\";\n");
      out.write("\t\t\tdom += \"</div>\"\n");
      out.write("\t\t\tdom += \"</fieldset>\";\n");
      out.write("\t\t\t$('fieldset:last').after(dom);\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$.each(page_publishs, function(index, page_publish){\n");
      out.write("\t\t\t\tif(page_publish.nameKey == attr.nameKey) {\n");
      out.write("\t\t\t\t\tvar ids = [];\n");
      out.write("\t\t\t\t\tvar entityIds = page_publish.entityId.split(\",\");\n");
      out.write("\t\t\t\t\t$.each(entityIds, function(index, id){\n");
      out.write("\t\t\t\t\t\tids.push(id);\n");
      out.write("\t\t\t\t\t});\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\t$('#' + keyName).val(page_publish.entityName);\n");
      out.write("\t\t\t\t\t$('#' + keyId).val(ids.join(\",\"));\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t\t\n");
      out.write("\t\t$('#item').datagrid({  \n");
      out.write("    \t\tloadMsg:\"正在加载......\",\n");
      out.write("    \t\ttoolbar:[{\n");
      out.write("\t        \ttext:'选择',  \n");
      out.write("\t         \ticonCls:'icon-add',\n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar rows = $('#item').datagrid('getSelections');\n");
      out.write("\t         \t\tvar names = [];\n");
      out.write("\t         \t\tvar ids = [];\n");
      out.write("\t         \t\tfor(var i = 0; i < rows.length; i++) {\n");
      out.write("\t         \t\t\tids.push(rows[i].id);\n");
      out.write("\t         \t\t\tnames.push(rows[i].name);\n");
      out.write("\t         \t\t}  \n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t// 表格显示的key\n");
      out.write("\t         \t\tvar table = '#' +$('#key').val();\n");
      out.write("\t         \t\tvar keyId = table + \"_id\";\n");
      out.write("\t         \t\tvar keyName = table + \"_name\";\n");
      out.write("\t         \t\tvar tableId = \"table_\" + $('#key').val();\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t// 这里判断是否有table这个元素\n");
      out.write("\t         \t\tif($(table + \":has(table)\").length == 0) {\n");
      out.write("\t         \t\t\tvar dom = \"<div style=\\\"text-align:left;\\\">\";\n");
      out.write("\t         \t\t\tdom += \"<table id=\" + tableId + \" style=\\\"margin:auto;width:40%;\\\">\"\n");
      out.write("\t\t\t\t\t\tdom += \"<th>商品名字</th><th>操作</th>\"\n");
      out.write("\t\t\t\t\t\tfor(var i = 0; i < names.length; i++) {\n");
      out.write("\t\t\t\t\t\t\tdom += \"<tr>\";\n");
      out.write("\t\t\t\t\t\t\tdom += \"<td>\";\n");
      out.write("\t\t\t\t\t\t\tdom += names[i];\n");
      out.write("\t\t\t\t\t\t\tvar keyv = $('#key').val() + \"_id\";\n");
      out.write("\t\t\t\t\t\t\tdom += \"</td><td><a onclick='del(\" + ids[i]  + \",\\\"\" + keyId + \"\\\",this,\\\"\" + keyName + \"\\\");'>删除</a></td>\"\n");
      out.write("\t\t\t\t\t\t\tdom += \"</tr>\";\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t$(table).html(dom);\n");
      out.write("\t\t\t\t\t\tdom += \"</table></div>\";\n");
      out.write("\t\t\t\t\t\t$(keyName).val(dom);\n");
      out.write("\t\t         \t\t$(keyId).val(ids.join(\",\"));\n");
      out.write("\t         \t\t} else {\n");
      out.write("\t         \t\t\tvar dom;\n");
      out.write("\t         \t\t\t\n");
      out.write("\t         \t\t\t// 去除重复得\n");
      out.write("\t         \t\t\tvar arr = $(keyId).val().split(\",\");\n");
      out.write("\t         \t\t\t$.each(names, function(index, name){\n");
      out.write("\t         \t\t\t\t\n");
      out.write("\t         \t\t\t\t// 判断是否重复了\n");
      out.write("\t         \t\t\t\tif($.inArray(ids[index] + \"\",arr) < 0) {\n");
      out.write("\t         \t\t\t\t\tarr.push(ids[index]);\n");
      out.write("\t\t         \t\t\t\tdom += \"<tr>\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"<td>\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += name;\n");
      out.write("\t\t\t\t\t\t\t\tvar keyv = $('#key').val() + \"_id\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"</td><td><a onclick='del(\" + ids[i]  + \",\\\"\" + keyId + \"\\\",this,\\\"\" + keyName + \"\\\");'>删除</a></td>\"\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"</tr>\";\n");
      out.write("\t         \t\t\t\t} \n");
      out.write("\t         \t\t\t});\n");
      out.write("\t         \t\t\t$('#' + tableId).find(\"tr:last\").after(dom);\n");
      out.write("\t         \t\t\t// 读取table内容\n");
      out.write("\t         \t\t\t$(keyName).val($('#' + tableId).parent().parent().html());\n");
      out.write("\t         \t\t\t$(keyId).val(arr.join(\",\"));\n");
      out.write("\t         \t\t}\n");
      out.write("\t         \t\t$('#dlg').dialog('close');  \n");
      out.write("\t         \t\t$('#item').datagrid('clearSelections');\n");
      out.write("\t         \t}\n");
      out.write("     \t\t}],\n");
      out.write("\t\t\trows:2000,\n");
      out.write("\t\t\tpageSize:2000,\n");
      out.write("\t\t\tpageList:[2000],\n");
      out.write("\t\t\tmethod:\"post\",\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/item/list.html',  \n");
      out.write("\t\t\tsortName:'id',\n");
      out.write("    \t\tsortOrder:'asc',\n");
      out.write("    \t\tpagination:false,\n");
      out.write("\t     \tcolumns:[[  \n");
      out.write("\t        \t{field:'id',title:'',width:60, checkbox:true},\n");
      out.write("\t        \t{field:'name',title:'商品名称',width:120}\n");
      out.write("\t    \t]]  \n");
      out.write("\t\t}); \n");
      out.write("\t\t\n");
      out.write("\t\t$('#brand').datagrid({  \n");
      out.write("    \t\tloadMsg:\"正在加载......\",\n");
      out.write("\t\t\trows:2000,\n");
      out.write("\t\t\tpageSize:2000,\n");
      out.write("\t\t\tpageList:[2000],\n");
      out.write("\t\t\ttoolbar:[{\n");
      out.write("\t        \ttext:'选择',  \n");
      out.write("\t         \ticonCls:'icon-add',\n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar rows = $('#brand').datagrid('getSelections');\n");
      out.write("\t         \t\tvar names = [];\n");
      out.write("\t         \t\tvar ids = [];\n");
      out.write("\t         \t\tfor(var i = 0; i < rows.length; i++) {\n");
      out.write("\t         \t\t\tids.push(rows[i].id);\n");
      out.write("\t         \t\t\tnames.push(rows[i].name);\n");
      out.write("\t         \t\t}  \n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t// 表格显示的key\n");
      out.write("\t         \t\tvar table = '#' +$('#key').val();\n");
      out.write("\t         \t\tvar keyId = table + \"_id\";\n");
      out.write("\t         \t\tvar keyName = table + \"_name\";\n");
      out.write("\t         \t\tvar tableId = \"table_\" + $('#key').val();\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t// 这里判断是否有table这个元素\n");
      out.write("\t         \t\tif($(table + \":has(table)\").length == 0) {\n");
      out.write("\t         \t\t\tvar dom = \"<div style=\\\"text-align:left;\\\">\";\n");
      out.write("\t         \t\t\tdom += \"<table id=\" + tableId + \" style=\\\"margin:auto;width:40%;\\\">\"\n");
      out.write("\t\t\t\t\t\tdom += \"<th>商品名字</th><th>操作</th>\"\n");
      out.write("\t\t\t\t\t\tfor(var i = 0; i < names.length; i++) {\n");
      out.write("\t\t\t\t\t\t\tdom += \"<tr>\";\n");
      out.write("\t\t\t\t\t\t\tdom += \"<td>\";\n");
      out.write("\t\t\t\t\t\t\tdom += names[i];\n");
      out.write("\t\t\t\t\t\t\tvar keyv = $('#key').val() + \"_id\";\n");
      out.write("\t\t\t\t\t\t\tdom += \"</td><td><a onclick='del(\" + ids[i]  + \",\\\"\" + keyId + \"\\\",this,\\\"\" + keyName + \"\\\");'>删除</a></td>\"\n");
      out.write("\t\t\t\t\t\t\tdom += \"</tr>\";\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t$(table).html(dom);\n");
      out.write("\t\t\t\t\t\tdom += \"</table></div>\";\n");
      out.write("\t\t\t\t\t\t$(keyName).val(dom);\n");
      out.write("\t\t         \t\t$(keyId).val(ids.join(\",\"));\n");
      out.write("\t         \t\t} else {\n");
      out.write("\t         \t\t\tvar dom;\n");
      out.write("\t         \t\t\t\n");
      out.write("\t         \t\t\t// 去除重复得\n");
      out.write("\t         \t\t\tvar arr = $(keyId).val().split(\",\");\n");
      out.write("\t         \t\t\t$.each(names, function(index, name){\n");
      out.write("\t         \t\t\t\t\n");
      out.write("\t         \t\t\t\t// 判断是否重复了\n");
      out.write("\t         \t\t\t\tif($.inArray(ids[index] + \"\",arr) < 0) {\n");
      out.write("\t         \t\t\t\t\tarr.push(ids[index]);\n");
      out.write("\t\t         \t\t\t\tdom += \"<tr>\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"<td>\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += name;\n");
      out.write("\t\t\t\t\t\t\t\tvar keyv = $('#key').val() + \"_id\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"</td><td><a onclick='del(\" + ids[i]  + \",\\\"\" + keyId + \"\\\",this,\\\"\" + keyName + \"\\\");'>删除</a></td>\"\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"</tr>\";\n");
      out.write("\t         \t\t\t\t} \n");
      out.write("\t         \t\t\t});\n");
      out.write("\t         \t\t\t$('#' + tableId).find(\"tr:last\").after(dom);\n");
      out.write("\t         \t\t\t// 读取table内容\n");
      out.write("\t         \t\t\t$(keyName).val($('#' + tableId).parent().parent().html());\n");
      out.write("\t         \t\t\t$(keyId).val(arr.join(\",\"));\n");
      out.write("\t         \t\t}\n");
      out.write("\t         \t\t$('#dlg1').dialog('close');  \n");
      out.write("\t         \t\t$('#brand').datagrid('clearSelections');\n");
      out.write("\t         \t}}],\n");
      out.write("\t\t\tmethod:\"post\",\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/brand/list.html',  \n");
      out.write("\t\t\tpagination:false,\n");
      out.write("\t\t\tsortName:'id',\n");
      out.write("    \t\tsortOrder:'asc',\n");
      out.write("\t     \tcolumns:[[  \n");
      out.write("\t        \t{field:'id',title:'',width:60, checkbox:true},\n");
      out.write("\t        \t{field:'name',title:'品牌名称',width:60}\n");
      out.write("\t    \t]]  \n");
      out.write("\t\t}); \n");
      out.write("\t\t\n");
      out.write("\t\t$('#content').datagrid({  \n");
      out.write("    \t\tloadMsg:\"正在加载......\",\n");
      out.write("\t\t\trows:2000,\n");
      out.write("\t\t\tpageSize:2000,\n");
      out.write("\t\t\tpageList:[2000],\n");
      out.write("\t\t\t\ttoolbar:[{\n");
      out.write("\t        \ttext:'选择',  \n");
      out.write("\t         \ticonCls:'icon-add',\n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar rows = $('#content').datagrid('getSelections');\n");
      out.write("\t         \t\tvar names = [];\n");
      out.write("\t         \t\tvar ids = [];\n");
      out.write("\t         \t\tfor(var i = 0; i < rows.length; i++) {\n");
      out.write("\t         \t\t\tids.push(rows[i].id);\n");
      out.write("\t         \t\t\tnames.push(rows[i].htmlTitle);\n");
      out.write("\t         \t\t}  \n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t// 表格显示的key\n");
      out.write("\t         \t\tvar table = '#' +$('#key').val();\n");
      out.write("\t         \t\tvar keyId = table + \"_id\";\n");
      out.write("\t         \t\tvar keyName = table + \"_name\";\n");
      out.write("\t         \t\tvar tableId = \"table_\" + $('#key').val();\n");
      out.write("\t         \t\t\n");
      out.write("\t         \t\t// 这里判断是否有table这个元素\n");
      out.write("\t         \t\tif($(table + \":has(table)\").length == 0) {\n");
      out.write("\t         \t\t\tvar dom = \"<div style=\\\"text-align:left;\\\">\";\n");
      out.write("\t         \t\t\tdom += \"<table id=\" + tableId + \" style=\\\"margin:auto;width:40%;\\\">\"\n");
      out.write("\t\t\t\t\t\tdom += \"<th>商品名字</th><th>操作</th>\"\n");
      out.write("\t\t\t\t\t\tfor(var i = 0; i < names.length; i++) {\n");
      out.write("\t\t\t\t\t\t\tdom += \"<tr>\";\n");
      out.write("\t\t\t\t\t\t\tdom += \"<td>\";\n");
      out.write("\t\t\t\t\t\t\tdom += names[i];\n");
      out.write("\t\t\t\t\t\t\tvar keyv = $('#key').val() + \"_id\";\n");
      out.write("\t\t\t\t\t\t\tdom += \"</td><td><a onclick='del(\" + ids[i]  + \",\\\"\" + keyId + \"\\\",this,\\\"\" + keyName + \"\\\");'>删除</a></td>\"\n");
      out.write("\t\t\t\t\t\t\tdom += \"</tr>\";\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t$(table).html(dom);\n");
      out.write("\t\t\t\t\t\tdom += \"</table></div>\";\n");
      out.write("\t\t\t\t\t\t$(keyName).val(dom);\n");
      out.write("\t\t         \t\t$(keyId).val(ids.join(\",\"));\n");
      out.write("\t         \t\t} else {\n");
      out.write("\t         \t\t\tvar dom;\n");
      out.write("\t         \t\t\t\n");
      out.write("\t         \t\t\t// 去除重复得\n");
      out.write("\t         \t\t\tvar arr = $(keyId).val().split(\",\");\n");
      out.write("\t         \t\t\t$.each(names, function(index, name){\n");
      out.write("\t         \t\t\t\t\n");
      out.write("\t         \t\t\t\t// 判断是否重复了\n");
      out.write("\t         \t\t\t\tif($.inArray(ids[index] + \"\",arr) < 0) {\n");
      out.write("\t         \t\t\t\t\tarr.push(ids[index]);\n");
      out.write("\t\t         \t\t\t\tdom += \"<tr>\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"<td>\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += name;\n");
      out.write("\t\t\t\t\t\t\t\tvar keyv = $('#key').val() + \"_id\";\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"</td><td><a onclick='del(\" + ids[i]  + \",\\\"\" + keyId + \"\\\",this,\\\"\" + keyName + \"\\\");'>删除</a></td>\"\n");
      out.write("\t\t\t\t\t\t\t\tdom += \"</tr>\";\n");
      out.write("\t         \t\t\t\t} \n");
      out.write("\t         \t\t\t});\n");
      out.write("\t         \t\t\t$('#' + tableId).find(\"tr:last\").after(dom);\n");
      out.write("\t         \t\t\t// 读取table内容\n");
      out.write("\t         \t\t\t$(keyName).val($('#' + tableId).parent().parent().html());\n");
      out.write("\t         \t\t\t$(keyId).val(arr.join(\",\"));\n");
      out.write("\t         \t\t}\n");
      out.write("\t         \t\t$('#dlg2').dialog('close');  \n");
      out.write("\t         \t\t$('#content').datagrid('clearSelections');\n");
      out.write("\t         \t}}],\n");
      out.write("\t\t\tmethod:\"post\",\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/content/list1.html',  \n");
      out.write("\t\t\tpagination:false,\n");
      out.write("\t\t\tsortName:'id',\n");
      out.write("    \t\tsortOrder:'asc',\n");
      out.write("\t     \tcolumns:[[  \n");
      out.write("\t        \t{field:'id',title:'',width:60, checkbox:true},\n");
      out.write("\t        \t{field:'title',title:'标题',width:60}\n");
      out.write("\t    \t]]  \n");
      out.write("\t\t}); \n");
      out.write("\t\t\n");
      out.write("\t\t\n");
      out.write("    });\n");
      out.write("    </script>\n");
      out.write("\t\n");
      out.write("\t<div id=\"formwrapper\">\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<form method=\"post\" name=\"form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/indexpublish/edit.html\">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"sitePageConfigValues\" id=\"sitePageConfigValues\" value=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sitePageConfigValues}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(">\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"pagePublishValues\" id=\"pagePublishValues\" value='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pagePublishValues}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("'>\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"keyName\" id=\"keyName\" />\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"keyId\" id=\"keyId\" />\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"pageType\" id=\"pageType\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageType}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"categoryId\" id=\"categoryId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${categoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"key\" id=\"key\" />\n");
      out.write("\t\t\t<fieldset>\n");
      out.write("\t\t\t\t<label>首页属性配置</label>\n");
      out.write("\t\t\t</fieldset>\n");
      out.write("\t\t\t<div class=\"enter\">\n");
      out.write("\t\t\t\t<input name=\"add\" type=\"submit\" class=\"buttom\" value=\"完成\" />\n");
      out.write("\t\t\t\t<input name=\"submit\" type=\"reset\" class=\"buttom\" value=\"重置\" />\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</form>\n");
      out.write("\t</div>\n");
      out.write("\t\n");
      out.write("\t <div id=\"dlg\" class=\"easyui-dialog\" style=\"width:400px;height:280px;padding:10px 20px\"  \n");
      out.write("\t         closed=\"true\" buttons=\"#dlg-buttons\">  \n");
      out.write("\t     <div id=\"tb\" style=\"padding:5px;height:auto;\">  \n");
      out.write("\t\t\t商品名称 : <input style=\"width:90px\" id=\"itemName\" />  \n");
      out.write("\t\t\t<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" onclick=\"searchItemList();\">查询</a>  \n");
      out.write("\t\t </div>  \n");
      out.write("\t     <div id=\"item\"></div>\n");
      out.write("\t </div>\t\n");
      out.write("\t </div>  \n");
      out.write("\t \n");
      out.write("\t <div id=\"dlg1\" class=\"easyui-dialog\" style=\"width:400px;height:280px;padding:10px 20px\"  \n");
      out.write("\t         closed=\"true\" buttons=\"#dlg-buttons\">  \n");
      out.write("\t     <div id=\"brand\"></div>\n");
      out.write("\t </div>  \n");
      out.write("\t \n");
      out.write("\t <div id=\"dlg2\" class=\"easyui-dialog\" style=\"width:400px;height:280px;padding:10px 20px\"  \n");
      out.write("\t         closed=\"true\" buttons=\"#dlg-buttons\">  \n");
      out.write("\t     <div id=\"content\"></div>\n");
      out.write("\t </div>  \n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fset_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_005fset_005f0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_005fset_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fset_005f0.setParent(null);
    // /common/jspHead.jsp(4,0) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setVar("ctx");
    // /common/jspHead.jsp(4,0) name = value type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fset_005f0.setValue(new org.apache.jasper.el.JspValueExpression("/common/jspHead.jsp(4,0) '${pageContext.request.contextPath}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${pageContext.request.contextPath}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int _jspx_eval_c_005fset_005f0 = _jspx_th_c_005fset_005f0.doStartTag();
    if (_jspx_th_c_005fset_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.reuse(_jspx_th_c_005fset_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent(null);
    // /WEB-INF/jsp/admin/indexpublish/edit.jsp(350,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t<div id=xbox>\n");
        out.write("\t\t\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\n");
        out.write("\t\t\t</div>\n");
        out.write("\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }
}
