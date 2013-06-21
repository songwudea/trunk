package org.apache.jsp.WEB_002dINF.jsp.admin.link;

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
      out.write("\t<meta http-equiv=\"link-Type\" link=\"text/html; charset=utf-8\" />\n");
      out.write("    <title>jQuery.EasyUI</title>\n");
      out.write("     <script type=\"text/javascript\" >\n");
      out.write("    $(document).ready(function() {\n");
      out.write("    \t$('#tt').datagrid({  \n");
      out.write("    \t\ttitle:\"链接列表\",\n");
      out.write("    \t\tloadMsg:\"正在加载......\",\n");
      out.write("    \t\ttoolbar:[{\n");
      out.write("\t        \ttext:'新增',  \n");
      out.write("\t         \ticonCls:'icon-add',\n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tdocument.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/link/edit.html\";\n");
      out.write("\t         \t}\n");
      out.write("     \t\t },{  \n");
      out.write("\t        \ttext:'修改',  \n");
      out.write("\t         \tplain:true,\n");
      out.write("\t         \ticonCls:'icon-edit',\n");
      out.write("\t         \thandler:function() {\n");
      out.write("\t         \t\tvar row = $('#tt').datagrid('getSelected');\n");
      out.write("\t         \t\tdocument.location.href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/link/edit.html?id=\" + row.id;\n");
      out.write("\t         \t}\n");
      out.write("     \t\t }],\n");
      out.write("\t\t\trows:15,\n");
      out.write("\t\t\tpageSize:15,\n");
      out.write("\t\t\tpageList:[15],\n");
      out.write("\t\t\twidth:\"820\",\n");
      out.write("\t\t\tmethod:\"post\",\n");
      out.write("\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/link/list.html',  \n");
      out.write("\t\t\tpagination:true,\n");
      out.write("\t\t\tsingleSelect:true,\n");
      out.write("\t\t\tstriped:true,\n");
      out.write("\t\t\trownumbers:true,\n");
      out.write("\t\t\tsortName:'id',\n");
      out.write("    \t\tsortOrder:'desc',\n");
      out.write("\t     \tcolumns:[[  \n");
      out.write("\t        \t{field:'linkType',title:'链接类型',width:100, formatter:function(value){return value=='MAIN_NAV' ? '主导航':'友情链接'}},\n");
      out.write("\t        \t{field:'linkUrl',title:'链接URL',width:250},\n");
      out.write("\t        \t{field:'linkTarget',title:'打开方式',width:80,formatter:function(value){return value=='_blank' ? '新窗口':'当前页'}}\n");
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
