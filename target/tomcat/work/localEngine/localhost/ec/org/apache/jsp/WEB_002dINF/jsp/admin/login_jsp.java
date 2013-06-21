package org.apache.jsp.WEB_002dINF.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("    <title>jQuery.EasyUI</title>\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("\t<!--\n");
      out.write("\tbody {\n");
      out.write("\t    font-family: Arial, Helvetica, sans-serif;\n");
      out.write("\t    font-size:12px;\n");
      out.write("\t    color:#666666;\n");
      out.write("\t    background:#fff;\n");
      out.write("\t    text-align:center;\n");
      out.write("\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t* {\n");
      out.write("\t    margin:0;\n");
      out.write("\t    padding:0;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\ta {\n");
      out.write("\t    color:#1E7ACE;\n");
      out.write("\t    text-decoration:none;   \n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\ta:hover {\n");
      out.write("\t    color:#000;\n");
      out.write("\t    text-decoration:underline;\n");
      out.write("\t}\n");
      out.write("\th3 {\n");
      out.write("\t    font-size:14px;\n");
      out.write("\t    font-weight:bold;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tpre,p {\n");
      out.write("\t    color:#1E7ACE;\n");
      out.write("\t    margin:4px;\n");
      out.write("\t}\n");
      out.write("\tinput, select,textarea {\n");
      out.write("\t    padding:1px;\n");
      out.write("\t    margin:2px;\n");
      out.write("\t    font-size:11px;\n");
      out.write("\t}\n");
      out.write("\t.buttom{\n");
      out.write("\t    padding:1px 10px;\n");
      out.write("\t    font-size:12px;\n");
      out.write("\t    border:1px #1E7ACE solid;\n");
      out.write("\t    background:#D0F0FF;\n");
      out.write("\t}\n");
      out.write("\t#formwrapper {\n");
      out.write("\t    width:450px;\n");
      out.write("\t    margin:15px auto;\n");
      out.write("\t    padding:20px;\n");
      out.write("\t    text-align:left;\n");
      out.write("\t    border:1px #1E7ACE solid;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfieldset {\n");
      out.write("\t    padding:10px;\n");
      out.write("\t    margin-top:5px;\n");
      out.write("\t    border:1px solid #1E7ACE;\n");
      out.write("\t    background:#fff;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfieldset legend {\n");
      out.write("\t    color:#1E7ACE;\n");
      out.write("\t    font-weight:bold;\n");
      out.write("\t    padding:3px 20px 3px 20px;\n");
      out.write("\t    border:1px solid #1E7ACE;   \n");
      out.write("\t    background:#fff;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfieldset label {\n");
      out.write("\t    float:left;\n");
      out.write("\t    width:120px;\n");
      out.write("\t    text-align:right;\n");
      out.write("\t    padding:4px;\n");
      out.write("\t    margin:1px;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tfieldset div {\n");
      out.write("\t    clear:left;\n");
      out.write("\t    margin-bottom:2px;\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t.enter{ text-align:center;}\n");
      out.write("\t.clear {\n");
      out.write("\t    clear:both;\n");
      out.write("\t}\n");
      out.write("\t-->\n");
      out.write("\t</style>\n");
      out.write("\t</head>\n");
      out.write("\t\n");
      out.write("\t<div id=\"formwrapper\">\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\t\n");
      out.write("\t\t<form method=\"post\" name=\"form\" id=\"form\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/login.html\">\n");
      out.write("\t\t\t<fieldset>\n");
      out.write("\t\t\t\t<legend>管理员登录</legend>\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<label for=\"name\">用户名</label>\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"name\" class=\"input\" id=\"name\" size=\"20\" maxlength=\"30\"/><br/>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div>\n");
      out.write("\t\t\t\t\t<label for=\"password\">密码</label>\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"password\" class=\"input\" id=\"password\" size=\"20\" maxlength=\"30\"/><br/>\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<div class=\"enter\">\n");
      out.write("\t\t\t\t\t<input name=\"submit\" type=\"submit\" class=\"buttom\" value=\"登录\" />\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t</fieldset>\n");
      out.write("\t\t</form>\n");
      out.write("</div>\n");
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
    // /WEB-INF/jsp/admin/login.jsp(97,2) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
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
