/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.55
 * Generated at: 2022-10-11 08:58:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<h1>Hello Spring MVC Java</h1>\r\n");
      out.write("	<img src=\"image/bmwmodel_205.png\"/><br>\r\n");
      out.write("	<a href=\"test1?data1=100&data2=200\">test1 get</a><br>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<form action=\"test2\" method=\"post\">\r\n");
      out.write("		data1: <input type=\"text\" name=\"data1\"/> \r\n");
      out.write("		data2: <input type=\"text\" name=\"data2\"/> \r\n");
      out.write("	<button type=\"submit\">test2 post</button>\r\n");
      out.write("	</form>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<form action=\"test2_2\" method=\"get\">\r\n");
      out.write("	<input type=\"hidden\" name=\"data1\" value=300>\r\n");
      out.write("	<input type=\"hidden\" name=\"data2\" value=400>\r\n");
      out.write("	<button type=\"submit\">test2_2 get</button>\r\n");
      out.write("	</form>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<form action=\"test3\" method=\"get\">\r\n");
      out.write("	data1: \r\n");
      out.write("	<input type=\"checkbox\" name=\"data1\" value=\"100\" >100\r\n");
      out.write("	<input type=\"checkbox\" name=\"data1\" value=\"200\" >200\r\n");
      out.write("	<input type=\"checkbox\" name=\"data1\" value=\"300\" >300\r\n");
      out.write("	<input type=\"checkbox\" name=\"data1\" value=\"400\" >400\r\n");
      out.write("	<br>\r\n");
      out.write("	data2: \r\n");
      out.write("	<input type=\"checkbox\" name=\"data2\" value=\"100\" >100\r\n");
      out.write("	<input type=\"checkbox\" name=\"data2\" value=\"200\" >200\r\n");
      out.write("	<input type=\"checkbox\" name=\"data2\" value=\"300\" >300\r\n");
      out.write("	<input type=\"checkbox\" name=\"data2\" value=\"400\" >400\r\n");
      out.write("	<br>\r\n");
      out.write("	data3: \r\n");
      out.write("	<input type=\"checkbox\" name=\"data3\" value=\"100\" >100\r\n");
      out.write("	<input type=\"checkbox\" name=\"data3\" value=\"200\" >200\r\n");
      out.write("	<input type=\"checkbox\" name=\"data3\" value=\"300\" >300\r\n");
      out.write("	<input type=\"checkbox\" name=\"data3\" value=\"400\" >400\r\n");
      out.write("	<br>\r\n");
      out.write("	<button type=\"submit\">result3</button>\r\n");
      out.write("	</form>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test4?data1=100&data2=200&data3=300&data4=400&data5=500\">test4</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test5/100/200/300/400/500\">test5</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test6?data1=100&data2=200&data3=300&data4=400&data5=500\">test6</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test7?data1=100&data2=200&data3=300&data4=400&data5=500\">test7</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test8?data1=100&data2=200&data3=300\">test8</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test9?data1=100&data2=200&data3=300\">test9</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test10?data1=100&data2=200&data3=300\">test10</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test11?data1=100&data2=200&data3=300\">test11</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test12?data1=100&data2=200&data2=300\">test12</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test13?data1=100&data2=200&data2=300&data2=400\">test13</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test14?data1=100&data2=200&data2=300&data2=400&data3=500&data4=600&data4=700\">test14</a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test15\">test15 data1, data2 - HttpServletRequest, request </a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test16\">test16 data3, data4 - Model, model </a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test17\">test17 data5, data6 - ModelAndView, mav </a>\r\n");
      out.write("	<hr>\r\n");
      out.write("	<a href=\"test18\">test18 data1, data2 - DataBean3, bean3 </a>\r\n");
      out.write("	<form action=\"test19\" method=\"post\">\r\n");
      out.write("		data1: <input type=\"text\" name=\"data1\"/>\r\n");
      out.write("		data2: <input type=\"text\" name=\"data2\"/>\r\n");
      out.write("		<button type=\"submit\">확인</button>\r\n");
      out.write("	</form>\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("<!-- \r\n");
      out.write(" Parameter 추출하기\r\n");
      out.write("-------------------------\r\n");
      out.write("클라이언트 요청 발생 시 전달하는 파라미터 데이터를 손쉽게 주입 받을 수 있도록 다양한 방식을 제공하고 있습니다.\r\n");
      out.write("Spring MVC는 Servlet/JSP 처럼 요청 방식에 따라 파라미터 추출하는 방식이 달라지지는 않습니다.\r\n");
      out.write("\r\n");
      out.write(" - HttpServletRequest 사용하기\r\n");
      out.write(" 1) Spring MVC는 필요한 객체나 데이터는 주입을 받아 사용하게 됩니다.\r\n");
      out.write(" 2) Servlet/JSP에서 파라미터 데이터를 추출할 때 HttpServletRequest request 객체를 통하게 되는데 \r\n");
      out.write("    Spring MVC에서 이 객체를 주입 받아 사용할 수 있습니다.\r\n");
      out.write(" 3) 파라미터 추출 뿐만 아니라 HttpServletRequest 객체가 필요할 경우 사용하면 됩니다.\r\n");
      out.write("\r\n");
      out.write("	@GetMapping(\"/test1\")\r\n");
      out.write("	public String test1(HttpServletRequest request) {\r\n");
      out.write("\r\n");
      out.write("	String data1 = request.getParameter(\"data1\");\r\n");
      out.write("	String data2 = request.getParameter(\"data2\");\r\n");
      out.write("	String [] data3 = request.getParameterValues(\"data3\");\r\n");
      out.write("\r\n");
      out.write("				… 생략\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" - WebRequest 사용하기\r\n");
      out.write("   WebRequest는 HttpServletRequest 클래스를 확장한 클래스입니다.\r\n");
      out.write(" \r\n");
      out.write("  @GetMapping(\"/test3\")\r\n");
      out.write("   public String test3(WebRequest request) {\r\n");
      out.write("\r\n");
      out.write("   String data1 = request.getParameter(\"data1\");\r\n");
      out.write("   String data2 = request.getParameter(\"data2\");\r\n");
      out.write("   String [] data3 = request.getParameterValues(\"data3\");\r\n");
      out.write("\r\n");
      out.write("   				 …생략…\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" - @PathVariable\r\n");
      out.write("     데이터가 요청 주소에 있을 경우 값을 주입 받을 수 있는 어노테이션입니다.\r\n");
      out.write("   Restful API 서버 프로그래밍시 많이 사용하는 방식입니다.\r\n");
      out.write("            데이터1/2/3\r\n");
      out.write("      요청주소/값1/값2/값3\r\n");
      out.write("\r\n");
      out.write("	형 변환\r\n");
      out.write("	@GetMapping(\"/test4/{data1}/{data2}/{data3}\")\r\n");
      out.write("	public String test4(@PathVariable int data1, \r\n");
      out.write("					    @PathVariable int data2, \r\n");
      out.write("			 			@PathVariable int data3) {\r\n");
      out.write("			 	.........\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write("- @RequestParam\r\n");
      out.write("	1) 파라미터 데이터를 직접 주입 받을 수 있습니다.\r\n");
      out.write("	2) 지정된 변수의 이름과 파라미터의 이름이 같을 경우 값을 주입 받습니다.\r\n");
      out.write("	3) 가능한 경우 형 변환도 처리해줍니다.\r\n");
      out.write("	4) value : 파라미터의 이름과 변수의 이름이 다를 경우 파라미터 이름을 지정합니다.\r\n");
      out.write("	5) required : false를 설정하면 지정된 이름의 파라미터가 없을 경우 null이 주입되고, \r\n");
      out.write("		있으면 넘어온 값으로 됩니다.(문자인 경우)\r\n");
      out.write("	6) (defaultValue = \"0\")설정하면 기본값으로 설정되고,  있으면 넘어온 값으로 됩니다. \r\n");
      out.write("		\r\n");
      out.write("	@GetMapping(\"/test7\")\r\n");
      out.write("	public String test7(@RequestParam(value = \"data1\") String value1,\r\n");
      out.write("			  @RequestParam(value = \"data2\", required = false) String value2,\r\n");
      out.write("			  @RequestParam(value = \"data3\", defaultValue = \"default\") String value3) {\r\n");
      out.write("			  \r\n");
      out.write("			  ..........	\r\n");
      out.write("	 }\r\n");
      out.write("\r\n");
      out.write(" - Map으로 주입 받기\r\n");
      out.write(" 1) 클라이언트가 전달 하는 모든 파라미터 데이터를 한번에 Map으로 받을 수 있습니다. \r\n");
      out.write(" 2) 단, 동일 명으로 전달되는 2개 이상의 파라미터는 하나만 담기게 됩니다.\r\n");
      out.write(" 3) 동일명으로 전달되는 파라미터가 2개 이상이라면 List로 주입 받아야 합니다.\r\n");
      out.write("\r\n");
      out.write("  public String test1(@RequestParam Map<String, String> map, \r\n");
      out.write("		  @RequestParam List<String> data3) {\r\n");
      out.write("\r\n");
      out.write("	}\r\n");
      out.write("\r\n");
      out.write(" - @ModelAttribute\r\n");
      out.write("  1) ModelAttribute 어노테이션을 사용하면 파라미터를 객체로 주입받을 수 있습니다.\r\n");
      out.write("  2) 전달되는 파라미터의 이름과 동일한 프로퍼티에 자동으로 주입됩니다.\r\n");
      out.write("  3) 이 어노테이션은 생략이 가능합니다. 이러한 객체를 커맨드 객체(Command Object)라고 부릅니다.\r\n");
      out.write("\r\n");
      out.write("  public String test2(@ModelAttribute DataBean1 bean1, \r\n");
      out.write("		      @ModelAttribute DataBean2 bean2) {\r\n");
      out.write("\r\n");
      out.write("  }\r\n");
      out.write("  \r\n");
      out.write("  .ViewResolver\r\n");
      out.write("------------------\r\n");
      out.write("  - 컨트롤러에서 전달 받은 View의 이름을 토대로 jsp를 찾아 선택하고 jsp 데이터를 분석해 응답결과를 만들어 전달하는 요소 입니다.\r\n");
      out.write("본 과정에서는 ViewResolver가 사용할 View의 이름을 지정하는 방법과 jsp 를 통해 응답 결과를 만들 때 필요한 데이터를 전달하는 방법에 대해 살펴봅니다\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" - HttpServletRequest\r\n");
      out.write(" - Spring MVC는 jsp 를 처리할 때 HttpServletRequest 객체를 jsp 쪽으로 전달합니다.\r\n");
      out.write("ViewResolver는 이를 이용해 JSP 작업시 데이터를 사용할 수 있습니다.\r\n");
      out.write("\r\n");
      out.write("  public String test2(HttpServletRequest request) {\r\n");
      out.write("     request.setAttribute(\"value1\", 100);\r\n");
      out.write("     request.setAttribute(\"value2\", 200);\r\n");
      out.write("     return \"test2\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" - Model\r\n");
      out.write("Model 객체를 주입 받아 셋팅하면 HttpServletRequest 객체에 담겨 이를 JSP로 전달할 수 있습니다.\r\n");
      out.write("\r\n");
      out.write("public String test3(Model model) {\r\n");
      out.write("model.addAttribute(\"value3\", 300);\r\n");
      out.write("model.addAttribute(\"value4\", 400);\r\n");
      out.write("return \"test3\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" - ModelAndView\r\n");
      out.write("\r\n");
      out.write("ModelAndView는 Model에 값을 셋팅하는 기능과 View의 이름을 지정하는 기능을 모두 가지고 있습니다.\r\n");
      out.write("public ModelAndView test5(ModelAndView mv) {\r\n");
      out.write("mv.addObject(\"value3000\", 3000);\r\n");
      out.write("mv.addObject(\"value4000\", 4000);\r\n");
      out.write("mv.setViewName(\"test5\");\r\n");
      out.write("return mv;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ViewResolver에 의해 JSP가 실행되고 응답결과가 만들어집니다.\r\n");
      out.write("Controller 에서 View를 지정할 때 ViewResolver가 사용할 데이터를 Request 영역에 저장할 수 있습니다.\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".커맨드 객체\r\n");
      out.write("-------------------\r\n");
      out.write(" 클라이언트가 전달해 주는 파라미터 데이터를 주입 받기 위해 사용하는 객체\r\n");
      out.write("\r\n");
      out.write(" - Request를 통해 전달\r\n");
      out.write("@PostMapping(\"/test1\")\r\n");
      out.write("public String test1(@ModelAttribute DataBean bean) {\r\n");
      out.write("	return \"test1\";\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(" \r\n");
      out.write("커맨드 객체는 HttpServletRequest 객체에 자동으로 담기고 jsp로 전달됩니다.\r\n");
      out.write("이 때, HttpServletRequest 객체에 저장되는 이름은 클래스의 이름으로 결정됩니다.\r\n");
      out.write("@PostMapping(\"/test1\")\r\n");
      out.write("public String test1(@ModelAttribute DataBean bean) {\r\n");
      out.write("	return \"test1\";\r\n");
      out.write("}\r\n");
      out.write(" -->");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
