package org.apache.jsp.WEB_002dINF.jsp.admin.item;

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
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005faction;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005faction = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fset_0026_005fvar_005fvalue_005fnobody.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005faction.release();
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
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<head>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n");
      out.write("\t<script type=\"text/javascript\" charset=\"utf-8\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ueditor/editor_config.js\"></script>\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ueditor/editor_all_min.js\"></script>\n");
      out.write("   \t<link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ueditor/themes/default/ueditor.css\"/>\n");
      out.write("    <script type=\"text/javascript\" >\n");
      out.write("    var child,intvl;\n");
      out.write("    var showDialog = function() {\n");
      out.write("\t\tchild = window.open('");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/js/ueditor/dialogs/image/image1.html' + \"?ver=\" + new Date(),'child', 'height=500, width=700, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=no, status=no');\n");
      out.write("\t\tintvl = setInterval(closedProperty,100);\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\tvar delPic = function(value, name) {\n");
      out.write("\t\tvar itemid = $('#id').val();\n");
      out.write("\t\t$.ajax({\n");
      out.write("\t\t  url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/item/deleteItemPic.html\",\n");
      out.write("\t\t  type:\"post\",\n");
      out.write("\t\t  data:{itemId:itemid,picName:name},\n");
      out.write("\t\t  success: function(data){\n");
      out.write("    \t  \t$(value).parent().parent().empty();\n");
      out.write("    \t  \t$('#images').val(data);\n");
      out.write("\t\t  \talert(\"商品图片删除成功.\");\n");
      out.write("\t\t  }\n");
      out.write("\t\t});\n");
      out.write("\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("    var createTable = function() {\n");
      out.write("    \tvar dom = \"<table id='imagetable'><th width='240'>图片名</th><th width='50'>操作</th>\";\n");
      out.write("    \tvar images = $('#images').val();\n");
      out.write("    \tvar json = eval('[' + images + ']');\n");
      out.write("    \t$.each(json,function(index, image){\n");
      out.write("    \t\tif(image.originalFilename != '') {\n");
      out.write("    \t\t\tdom += \"<tr>\";\n");
      out.write("\t\t\t\tdom += \"<td width='80'>\" + image.originalFilename + \"</td>\";\n");
      out.write("\t\t\t\tdom += \"<td width='70'><a href='javascript:;' onclick='delPic(this,\\\"\" + image.url + \"\\\");'>删除</a>|<a href='javascript:;'>默认</a></td>\";\n");
      out.write("\t\t\t\tdom += \"</tr>\";\n");
      out.write("    \t\t}\n");
      out.write("    \t});\n");
      out.write("\t\tdom += \"</table>\";\n");
      out.write("\t\t$('#showimage').after(dom);\n");
      out.write("  \t}\t\t\n");
      out.write("\t\n");
      out.write("\tvar closedProperty = function() {\n");
      out.write("\t\tif (child.closed) {\n");
      out.write("\t\t\tclearInterval(intvl);\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tif($('#imagetable').length > 0) {\n");
      out.write("\t\t\t\t$(\"#imagetable\").empty();  \t\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tcreateTable();\n");
      out.write("  \t\t}\t\t\n");
      out.write("\t}\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("    \n");
      out.write("    $(document).ready(function() {\n");
      out.write("\t\tcreateTable();    \n");
      out.write("    \n");
      out.write("    \t$('#publishOn').datetimebox({\n");
      out.write("    \t\twidth:160\n");
      out.write("    \t});  \n");
      out.write("    \t\n");
      out.write("    \t$('#expireOn').datetimebox({\n");
      out.write("    \t\twidth:160\n");
      out.write("    \t});  \n");
      out.write("\n");
      out.write("    \tvar dd = $('#secondCategoryId').combobox({  \n");
      out.write("\t     \turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/category/childCategory.html?id=' +  $('#fid').val() + '&sid=' + $('#sid').val(),\n");
      out.write("\t     \twidth:130,\n");
      out.write("\t     \tvalueField:'id',\n");
      out.write("\t     \ttextField:'text',\n");
      out.write("\t     \teditable:false\n");
      out.write("    \t});\n");
      out.write("    \t\n");
      out.write("    \tvar ee = $('#thirdCategoryId').combobox({  \n");
      out.write("\t     \turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/category/childCategory.html?id=' +  $('#sid').val() + '&tid=' + $('#tid').val(),\n");
      out.write("\t     \twidth:130,\n");
      out.write("\t     \tvalueField:'id',\n");
      out.write("\t     \ttextField:'text',\n");
      out.write("\t     \teditable:false\n");
      out.write("    \t});\n");
      out.write("    \t\n");
      out.write("    \tvar brand = $('#brandId').combobox({\n");
      out.write("    \t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/brand/getBrands.html?id=' + $('#fid').val() + '&bid=' + $('#bid').val(),\n");
      out.write("    \t\twidth:130,\n");
      out.write("    \t\tvalueField:'id',\n");
      out.write("\t     \ttextField:'text',\n");
      out.write("    \t\teditable:false\n");
      out.write("    \t});\n");
      out.write("    \t\n");
      out.write("    \tvar editor_a = new baidu.editor.ui.Editor({\n");
      out.write("    \t\tautoFloatEnabled: false,\n");
      out.write("    \t\tautoHeightEnabled:false,\n");
      out.write("    \t\telementPathEnabled:false,\n");
      out.write("    \t\ttextarea:'description'\n");
      out.write("    \t});\n");
      out.write("    \t\n");
      out.write("    \tvar editor_item_short_desc = new baidu.editor.ui.Editor({\n");
      out.write("    \t\tautoFloatEnabled: false,\n");
      out.write("    \t\tautoHeightEnabled:false,\n");
      out.write("    \t\telementPathEnabled:false,\n");
      out.write("    \t\ttextarea:'shortDesc',\n");
      out.write("    \t\ttoolbars:[\n");
      out.write("            ['Source', '|', 'Undo', 'Redo', '|',\n");
      out.write("                'Bold', 'Italic', 'Underline', 'StrikeThrough', 'Superscript', 'Subscript', 'RemoveFormat', 'FormatMatch', '|',\n");
      out.write("                'BlockQuote', '|', 'PastePlain', '|', 'ForeColor', 'BackColor', 'InsertOrderedList', 'InsertUnorderedList', '|', 'CustomStyle',\n");
      out.write("                'Paragraph', 'RowSpacing', 'LineHeight', 'FontFamily', 'FontSize', '|',\n");
      out.write("                'DirectionalityLtr', 'DirectionalityRtl', '|', '', 'Indent', '|',\n");
      out.write("                'JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyJustify', '|',\n");
      out.write("                'Link', 'Unlink', 'Anchor', '|',\n");
      out.write("                'Horizontal', 'Date', 'Time', 'Spechars']\n");
      out.write("        \t],\n");
      out.write("        \tminFrameHeight:120\n");
      out.write("    \t});\n");
      out.write("    \t\n");
      out.write("        //渲染编辑器\n");
      out.write("        editor_a.render('description');\n");
      out.write("        editor_item_short_desc.render('shortDesc');\n");
      out.write("    \t   \n");
      out.write("    \n");
      out.write("    \tvar cc = $('#topCategoryId').combobox({\n");
      out.write("\t     \turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/category/rootCategory.html?fid=' + $('#fid').val(),  \n");
      out.write("\t     \tvalueField:'id',\n");
      out.write("\t     \ttextField:'text',\n");
      out.write("\t     \teditable:false,\n");
      out.write("\t     \twidth:130,\n");
      out.write("\t     \tonSelect:function(record){  \n");
      out.write("\t     \t\tdd.combobox('clear');\n");
      out.write("\t     \t\tee.combobox('clear');\n");
      out.write("\t     \t\tbrand.combobox('clear');\n");
      out.write("\t     \t\tbrand.combobox({\n");
      out.write("\t     \t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/brand/getBrands.html?id=' + record.id + '&bid=' + $('#bid').val()\n");
      out.write("\t     \t\t})\n");
      out.write("\t     \t\t\n");
      out.write("\t     \t\t\n");
      out.write("\t\t\t\tdd.combobox({\n");
      out.write("\t\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/category/childCategory.html?id=' + record.id + '&sid=' + $('#sid').val(),\n");
      out.write("\t\t\t\t\tvalueField:'id',\n");
      out.write("\t\t\t\t\ttextField:'text',\n");
      out.write("\t\t\t\t\tonSelect:function(record) {\n");
      out.write("\t\t\t\t\t\tee.combobox({\n");
      out.write("\t\t\t\t\t\t\turl:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("/admin/category/childCategory.html?id=' + record.id + '&tid=' + $('#tid').val(),\n");
      out.write("\t\t\t\t\t\t\tvalueField:'id',\n");
      out.write("\t\t\t\t\t\t\ttextField:'text'\n");
      out.write("\t\t\t\t\t\t}).combobox('clear');\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}).combobox('clear');\t     \t\t\n");
      out.write("\t     \t}\n");
      out.write("\t\t}); \n");
      out.write("    });\n");
      out.write("\t    \n");
      out.write("\t</script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<div id=\"formwrapper\">\n");
      out.write("\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t\n");
      out.write("\t");
      if (_jspx_meth_form_005fform_005f0(_jspx_page_context))
        return;
      out.write("\n");
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
    // /WEB-INF/jsp/admin/item/edit.jsp(161,1) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message!=null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t<div id=xbox>\n");
        out.write("\t\t\t");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\n");
        out.write("\t\t</div>\n");
        out.write("\t");
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

  private boolean _jspx_meth_form_005fform_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  form:form
    org.springframework.web.servlet.tags.form.FormTag _jspx_th_form_005fform_005f0 = (org.springframework.web.servlet.tags.form.FormTag) _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005faction.get(org.springframework.web.servlet.tags.form.FormTag.class);
    _jspx_th_form_005fform_005f0.setPageContext(_jspx_page_context);
    _jspx_th_form_005fform_005f0.setParent(null);
    // /WEB-INF/jsp/admin/item/edit.jsp(167,1) name = modelAttribute type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setModelAttribute("model");
    // /WEB-INF/jsp/admin/item/edit.jsp(167,1) name = method type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setMethod("post");
    // /WEB-INF/jsp/admin/item/edit.jsp(167,1) name = action type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_form_005fform_005f0.setAction((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}/admin/item/edit.html", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_form_005fform_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_form_005fform_005f0 = _jspx_th_form_005fform_005f0.doStartTag();
      if (_jspx_eval_form_005fform_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t<input type=\"hidden\" name=\"id\" id=\"id\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.id}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t<input type=\"hidden\" name=\"fid\" id=\"fid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.topCategoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t<input type=\"hidden\" name=\"sid\" id=\"sid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.secondCategoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t<input type=\"hidden\" name=\"images\" id=\"images\" value='");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.images}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("'/>\n");
          out.write("\t\t<input type=\"hidden\" name=\"bid\" id=\"bid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.brandId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t<input type=\"hidden\" name=\"tid\" id=\"tid\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.thirdCategoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t<fieldset>\n");
          out.write("\t\t\t<legend>商品基本信息</legend>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"name\">商品名称</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"name\" class=\"input\" id=\"name\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.name}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"sort\">排序权重</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"sort\" class=\"input\" id=\"sort\" size=\"20\" maxlength=\"10\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.sort}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"itemTitle\">商品副标题</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"itemTitle\" class=\"input\" id=\"itemTitle\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.itemTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"name\">商品图片</label>\n");
          out.write("\t\t\t\t<button type=\"button\" onclick=\"showDialog();\">上传图片</button>\n");
          out.write("\t\t\t\t<span id=\"showimage\"></span>\n");
          out.write("\t\t\t\t<br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"upcCode\">upcCode</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"upcCode\" class=\"input\" id=\"upcCode\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.upcCode}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"skuCode\">sku编码</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"skuCode\" class=\"input\" id=\"skuCode\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.skuCode}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"sellable\">是否能购买</label>\n");
          out.write("\t\t\t\t<input type=\"checkbox\" id=\"sellable\" name=\"sellable\" ");
          if (_jspx_meth_c_005fif_005f1(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"publishOn\">发布时间</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"publishOn\" class=\"input\" id=\"publishOn\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.publishOn}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"expireOn\">有效期</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"expireOn\" class=\"input\" id=\"expireOn\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.expireOn}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"published\">是否已发布</label>\n");
          out.write("\t\t\t\t<input type=\"checkbox\" id=\"published\" name=\"published\" ");
          if (_jspx_meth_c_005fif_005f2(_jspx_th_form_005fform_005f0, _jspx_page_context, _jspx_push_body_count_form_005fform_005f0))
            return true;
          out.write("/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"shippingType\">物流类型</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"shippingType\" class=\"input\" id=\"shippingType\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.shippingType}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</fieldset>\n");
          out.write("\t\t\n");
          out.write("\t\t<fieldset>\n");
          out.write("\t\t\t<legend>商品页面元素信息</legend>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"name\">html标题</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"htmlTitle\" class=\"input\" id=\"htmlTitle\" size=\"70\" maxlength=\"70\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.htmlTitle}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"metaKeywords\">meta-关键字</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"metaKeywords\" class=\"input\" id=\"metaKeywords\" size=\"70\" maxlength=\"70\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.metaKeywords}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"metaDesc\">meta-描述</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"metaDesc\" class=\"input\" id=\"metaDesc\" size=\"70\" maxlength=\"70\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.metaDesc}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</fieldset>\n");
          out.write("\t\t\n");
          out.write("\t\t<fieldset>\n");
          out.write("\t\t\t<legend>商品分类,品牌,属性信息</legend>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"topCategoryId\">1级分类</label>\n");
          out.write("\t\t\t\t<input id=\"topCategoryId\" name=\"topCategoryId\" type=\"text\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.topCategoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"secondCategoryId\">2级分类</label>\n");
          out.write("\t\t\t\t<input id=\"secondCategoryId\" name=\"secondCategoryId\" type=\"text\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.secondCategoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"thirdCategoryId\">3级分类</label>\n");
          out.write("\t\t\t\t<input id=\"thirdCategoryId\" name=\"thirdCategoryId\" type=\"text\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.thirdCategoryId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"brandId\">品牌</label>\n");
          out.write("\t\t\t\t<input id=\"brandId\" name=\"brandId\" type=\"text\" />\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</fieldset>\n");
          out.write("\t\t<fieldset>\n");
          out.write("\t\t\t<legend>商品价格信息</legend>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"inventory\">库存</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"inventory\" class=\"input\" id=\"inventory\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.inventory}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"bookedQuantity\">预定数量</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"bookedQuantity\" class=\"input\" id=\"bookedQuantity\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.bookedQuantity}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"cmarketPrice\">市场价</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"cmarketPrice\" class=\"input\" id=\"cmarketPrice\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.cmarketPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"ccost\">成本价</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"ccost\" class=\"input\" id=\"ccost\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.ccost}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"cprice\">销售价格</label>\n");
          out.write("\t\t\t\t<input type=\"text\" name=\"cprice\" class=\"input\" id=\"cprice\" size=\"20\" maxlength=\"30\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.cprice}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"/><br/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</fieldset>\n");
          out.write("\t\t\n");
          out.write("\t\t<fieldset>\n");
          out.write("\t\t\t<legend>其他销售渠道</legend>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<label for=\"tmallUrl\">天猫地址</label>\n");
          out.write("\t\t\t\t<input id=\"tmallUrl\" name=\"tmallUrl\" type=\"text\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.tmallUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("\"  size=\"80\"/>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</fieldset>\n");
          out.write("\t\t<fieldset>\n");
          out.write("\t\t\t<legend>商品描述编辑</legend>\n");
          out.write("\t\t\t<div>\n");
          out.write("\t\t\t\t<script type=\"text/plain\" id=\"description\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.description}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</script>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t</fieldset>\n");
          out.write("\t\t<fieldset>\n");
          out.write("\t\t\t<legend>商品短描述</legend>\n");
          out.write("\t\t\t\t<div>\n");
          out.write("\t\t\t\t\t<script type=\"text/plain\" id=\"shortDesc\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.shortDesc}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</script>\n");
          out.write("\t\t\t\t</div>\n");
          out.write("\t\t\t</legend>\n");
          out.write("\t\t</fieldset>\n");
          out.write("\t\t<div class=\"enter\">\n");
          out.write("\t\t\t<input name=\"add\" type=\"submit\" class=\"buttom\" value=\"提交\" />\n");
          out.write("\t\t\t<input name=\"reset\" type=\"reset\" class=\"buttom\" value=\"重置\" />\n");
          out.write("\t\t</div>\n");
          out.write("\t");
          int evalDoAfterBody = _jspx_th_form_005fform_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_form_005fform_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_form_005fform_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_form_005fform_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_form_005fform_005f0.doFinally();
      _005fjspx_005ftagPool_005fform_005fform_0026_005fmodelAttribute_005fmethod_005faction.reuse(_jspx_th_form_005fform_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/jsp/admin/item/edit.jsp(205,57) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.sellable == true}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_form_005fform_005f0, PageContext _jspx_page_context, int[] _jspx_push_body_count_form_005fform_005f0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f2.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_form_005fform_005f0);
    // /WEB-INF/jsp/admin/item/edit.jsp(217,59) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${model.published == true}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f2 = _jspx_th_c_005fif_005f2.doStartTag();
    if (_jspx_eval_c_005fif_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("checked");
        int evalDoAfterBody = _jspx_th_c_005fif_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f2);
    return false;
  }
}
