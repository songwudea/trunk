package org.apache.jsp.WEB_002dINF.jsp.admin.employee;

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

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
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
      out.write("    <script type=\"text/javascript\" >\n");
      out.write("    $(document).ready(function() {\n");
      out.write("    \t$('#tt').datagrid({  \n");
      out.write("    \t\ttitle:\"员工管理列表\",\n");
      out.write("    \t\tloadMsg:\"正在加载......\",\n");
      out.write("    \t\ttoolbar:[{\n");
      out.write("\t        \ttext:'新增',  \n");
      out.write("\t         \ticonCls:'icon-add',\n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tdocument.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/employee/doEdit.html\";\n");
      out.write("\t         \t}\n");
      out.write("     \t\t },{  \n");
      out.write("\t        \ttext:'修改',  \n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \ticonCls:'icon-edit',\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar row = $('#tt').datagrid('getSelected');\n");
      out.write("\t         \t\tdocument.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/employee/doEdit.html?id=\" + row.id;\n");
      out.write("\t         \t}\n");
      out.write("     \t\t },{\n");
      out.write("\t        \ttext:'分配角色',  \n");
      out.write("\t         \ticonCls:'icon-add',\n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar row = $('#tt').datagrid('getSelected');\n");
      out.write("\t         \t\tdocument.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/employee/doEmployeerole.html?employeeId=\" + row.id;\n");
      out.write("\t         \t}\n");
      out.write("     \t\t},{\n");
      out.write("     \t\t\ttext:'分配站点',\n");
      out.write("     \t\t\ticonCls:'icon-add',\n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar row = $('#tt').datagrid('getSelected');\n");
      out.write("\t         \t\tdocument.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/employee/assortSite.html?employeeId=\" + row.id;\n");
      out.write("\t         \t}\n");
      out.write("     \t\t}],\n");
      out.write("\t\t\trows:15,\n");
      out.write("\t\t\tpageSize:15,\n");
      out.write("\t\t\tpageList:[15],\n");
      out.write("\t\t\tstriped:true,\n");
      out.write("\t\t\trownumbers:true,\n");
      out.write("\t\t\twidth:\"820\",\n");
      out.write("\t\t\tmethod:\"post\",\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/employee/list.html',  \n");
      out.write("\t\t\tpagination:true,\n");
      out.write("\t\t\tsingleSelect:true,\n");
      out.write("\t\t\tsortName:'id',\n");
      out.write("    \t\tsortOrder:'asc',\n");
      out.write("\t     \tcolumns:[[  \n");
      out.write("\t        \t{field:'account',title:'用户名',width:80},\n");
      out.write("\t        \t{field:'position',title:'职位',width:80, sortable:true},\n");
      out.write("\t        \t{field:'department',title:'部门',width:80, sortable:true},\n");
      out.write("\t        \t{field:'email',title:'邮箱',width:140, sortable:true},\n");
      out.write("\t        \t{field:'name',title:'真实姓名',width:80, sortable:true},\n");
      out.write("\t        \t{field:'gender',title:'性别',width:60,formatter:function(value){return value==\"m\" ?'男':'女';}, sortable:true},\n");
      out.write("\t        \t{field:'telphone',title:'电话',width:90},\n");
      out.write("\t        \t{field:'mobile',title:'手机',width:90}\n");
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
      out.write("    var searchlist = function() {\n");
      out.write("    \tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.sta_username= $('#sta_username').val();\n");
      out.write("\t    \n");
      out.write("    \tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.sta_email= $('#sta_email').val();\n");
      out.write("\n");
      out.write("    \tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.sta_loginstatus= $('#sta_loginstatus').val();\n");
      out.write("\t    \n");
      out.write("    \tvar queryParams = $('#tt').datagrid('options').queryParams;\n");
      out.write("\t    queryParams.sta_station= $('#sta_station').val();\n");
      out.write("\t    \n");
      out.write(" \t\t$('#tt').datagrid('options').queryParams=queryParams; \n");
      out.write("\t\t$(\"#tt\").datagrid('reload');\n");
      out.write("    }\n");
      out.write("\t    \n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("\t<body>\n");
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
}
