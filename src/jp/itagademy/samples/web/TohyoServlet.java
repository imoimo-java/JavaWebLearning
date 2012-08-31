package jp.itagademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/tohyo")
public class TohyoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int SECONDS_PER_YEAR = 365 * 24 * 60 * 60;
	private static final String GETUP_KEY = "getup";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] options = {"�S�͂ŏ�������","�]�T�Œ��H���Ƃ�1���Ԓx������", "1���x��"};
		String[] options_code ={"a","b","c"};
		String getup = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for (Cookie c: cookies){
				if (c.getName().equals(GETUP_KEY)){
					getup = c.getValue();
					break;
				}
			}
		}
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>�ЂƂ�1�[�̓��[�T�C�g</title>");
		out.println("<p>���N������o�����Ԃł����B�ǂ����܂����H</p>getup:" + getup);
		out.println("<form action=\"/JavaWebLearning/tohyo\" method=\"post\"");
		out.println("<p>");
		for(int i=0; i < options.length; i++ ){
			out.println("<input id=\"" + GETUP_KEY + i + "\" type=\"radio\" name=\"" + GETUP_KEY + "\" value=\"" + options_code[i] + "\"");
			if (getup.equals(options_code[i])){
				out.println(" checked=\"checked\"");
			}
			out.println(">");
			out.println("<label for=\"" + GETUP_KEY + i + "\">" + options[i] + "</label><br/>");
		}
		out.println("</p>");
		if (getup == null)
			out.println("<p><input type=\"submit\" value=\"���[����\"></p>");
		else
			out.println("<p>���łɓ��[�ς݂ł�</p>");
		out.println("</form>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>�ЂƂ�1�[�̓��[�T�C�g</title>");
		
		String getup = request.getParameter(GETUP_KEY);
		if(getup != null){
			Cookie cookie = new Cookie(GETUP_KEY, getup);
			cookie.setMaxAge(SECONDS_PER_YEAR);
			response.addCookie(cookie);
			out.println("<p>���[���󂯕t���܂���</p>");
		}else{
			out.println("<p>���Âꂩ��I�����Ă�������</p>");
			out.println("<p><a href=\"/JavaWebLearning/tohyo\" >���[���</a></p>");
		}
	}
}
