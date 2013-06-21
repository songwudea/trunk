package org.apache.jsp.WEB_002dINF.jsp.admin.refund;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/common/jspHead.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    <title>jQuery.EasyUI</title>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("    \n");
      out.write("    $(document).ready(function() {\n");
      out.write("    \t$('#tt').datagrid({  \n");
      out.write("    \t\ttitle:\"退款单列表\",\n");
      out.write("    \t\tloadMsg:\"正在加载......\",\n");
      out.write("\t\t\trows:15,\n");
      out.write("\t\t\tpageSize:15,\n");
      out.write("\t\t\tpageList:[15],\n");
      out.write("\t\t\twidth:\"820\",\n");
      out.write("\t\t\theight:\"500\",\n");
      out.write("\t\t\tstriped:true,\n");
      out.write("\t\t\tmethod:\"post\",\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/refund/list.html',  \n");
      out.write("\t\t\tpagination:true,\n");
      out.write("\t\t\trownumbers:true,\n");
      out.write("\t\t\tsingleSelect:true,\n");
      out.write("\t\t\tsortName:'id',\n");
      out.write("    \t\tsortOrder:'desc',\n");
      out.write("    \t\ttoolbar:[{\n");
      out.write("\t        \ttext:'确认退款',  \n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \ticonCls:'icon-edit',\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar row = $('#tt').datagrid('getSelected');\n");
      out.write("\t         \t\tvar status = row.status;\n");
      out.write("\t         \t\tvar id = row.id;\n");
      out.write("\t         \t\tif(status == 'ORDER_REFUND_STATUS_WAIT') {\n");
      out.write("\t         \t\t\t$.post('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/refund/comfireRefund.html',{id:id},function(data){\n");
      out.write("\t         \t\t\t\tif(data == \"suss\") {\n");
      out.write("\t\t\t\t\t        \t$('#tt').datagrid('reload');//刷新当前页数据\n");
      out.write("\t\t\t\t\t       \t\t$.messager.alert('退款操作','确认退款操作成功','info');\n");
      out.write("\t         \t\t\t\t} else {\n");
      out.write("\t\t\t\t\t       \t\t$.messager.alert('退款操作','确认退款操作失败','info');\n");
      out.write("\t         \t\t\t\t}\n");
      out.write("\t\t\t\t    \t});\n");
      out.write("\t         \t\t} else if(status == 'ORDER_REFUND_STATUS_COMFIRE') {\n");
      out.write("\t         \t\t\talert('已经退款了不能重复操作');\n");
      out.write("\t         \t\t}\n");
      out.write("\t         \t}\n");
      out.write("     \t\t}],\n");
      out.write("\t     \tcolumns:[[  \n");
      out.write("\t        \t{field:'orderNumber',title:'订单编号',width:150,sortable:true},\n");
      out.write("\t        \t{field:'account',title:'退款账户',width:150},\n");
      out.write("\t        \t{field:'price',title:'退款金额',width:100,formatter:function(value){return \"￥\" + parseFloat(value) / 100;}},\n");
      out.write("\t        \t{field:'status',title:'退款状态',width:100,formatter:function(value){\n");
      out.write("\t        \t\tif(value=='ORDER_REFUND_STATUS_WAIT') {\n");
      out.write("\t        \t\t\treturn \"等待确认退款\";\n");
      out.write("\t        \t\t}\n");
      out.write("\t        \t\tif(value=='ORDER_REFUND_STATUS_COMFIRE') {\n");
      out.write("\t        \t\t\treturn \"已确认并退款\";\n");
      out.write("\t        \t\t}\n");
      out.write("\t        \t}},\n");
      out.write("\t        \t{field:'createdAt',title:'退款单创建时间',width:130,formatter:function(value) {\n");
      out.write("\t        \t\tif(value == null) {\n");
      out.write("\t        \t\t\treturn \"\";\n");
      out.write("\t        \t\t} else {\n");
      out.write("\t        \t\t\tvar date = new Date(value)  \n");
      out.write("\t        \t \t\treturn date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + \" \" + date.getHours() + \":\" + date.getMinutes() + \":\" + date.getSeconds();\n");
      out.write("\t        \t\t}\t\n");
      out.write("\t        \t}},\n");
      out.write("\t        \t{field:'refundDate',title:'退款时间',width:130,formatter:function(value) {\n");
      out.write("\t        \t\tif(value == null) {\n");
      out.write("\t        \t\t\treturn \"\";\n");
      out.write("\t        \t\t} else {\n");
      out.write("\t        \t\t\tvar date = new Date(value)  \n");
      out.write("\t        \t \t\treturn date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate() + \" \" + date.getHours() + \":\" + date.getMinutes() + \":\" + date.getSeconds();\n");
      out.write("\t        \t\t}\t\n");
      out.write("\t        \t}},\n");
      out.write("\t        \t{field:'createByEmployeeName',title:'提交退款人',width:150},\n");
      out.write("\t        \t{field:'confirmByEmployeeName',title:'退款审核人',width:150}\n");
      out.write("\t    \t]]  \n");
      out.write("\t\t}); \n");
      out.write("\t\t\n");
      out.write("\t\tvar pager = $('#tt').datagrid('getPager');   \n");
      out.write("\t\tpager.pagination({\n");
      out.write("\t\t\tshowPageList:false,\n");
      out.write("\t\t\tshowRefresh:false,\n");
      out.write("\t\t\tdisplayMsg:\"显示 {from} 到 {to} 总数 {total} 项\",\n");
      out.write("\t\t\tbeforePageText : \"页\"\n");
      out.write("\t\t});\n");
      out.write("    });\n");
      out.write("    \n");
      out.write("\tvar searchlist = function() {\n");
      out.write("\t\tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.orderNumber= $('#orderNumber').val();\n");
      out.write("\t    \n");
      out.write("\t\tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.status= $('#status').val();\n");
      out.write("\t\n");
      out.write("\t\tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.userName= $('#userName').val();\n");
      out.write("\t    \n");
      out.write("\t\tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.shiptel= $('#shiptel').val();\n");
      out.write("\t    \n");
      out.write("\t\t$('#tt').datagrid('options').queryParams=queryParams; \n");
      out.write("\t\t$(\"#tt\").datagrid('reload');\n");
      out.write("    }\n");
      out.write("\t    \n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<div id=\"tb\" style=\"padding:5px;height:auto;float:left;\">  \n");
      out.write("\t\t\t订单编号编号:<input style=\"width:150px\" id=\"orderNumber\" />  \n");
      out.write("\t\t\t订单状态:<select name=\"status\" id=\"status\">\n");
      out.write("\t\t\t\t<option value=\"all\">全部</option>\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\t    </select>\n");
      out.write("\t\t\t用户姓名:<input style=\"width:70px\" id=\"userName\" />   \n");
      out.write("\t\t\t手机:<input style=\"width:150px\" id=\"shiptel\" />  \n");
      out.write("\t\t\t<a href=\"#\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" onclick=\"searchlist();\">查询</a>  \n");
      out.write("\t\t</div>\t\n");
      out.write("\t\t<div style=\"clear:both\"></div>\n");
      out.write("\t\t<table id=\"tt\">\n");
      out.write("\t\t</table>\n");
      out.write("\t</body>\n");
      out.write("</html>");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/admin/refund/index.jsp(115,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("status");
    // /WEB-INF/jsp/admin/refund/index.jsp(115,4) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/jsp/admin/refund/index.jsp(115,4) '${status}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${status}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t<option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${status.value}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</option>\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
