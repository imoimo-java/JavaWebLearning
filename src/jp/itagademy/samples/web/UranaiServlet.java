package jp.itagademy.samples.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowParametersServlet
 */
@WebServlet("/uranai")
public class UranaiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>���t�^�肢</title>");
		out.println("<link rel=\"stylesheet\" href=\"bmi.css\">");
		out.println("<h1>���Ȃ��̉^���́H</h1>");
		String abo = request.getParameter("abo");
		Calendar date = Calendar.getInstance();
		int day = date.get(Calendar.DAY_OF_MONTH);
		String[] abo_list = {"A","B","O","AB"};
		for(int i=0;i<abo_list.length;i++ ){
			if (abo.equals(abo_list[i])){
				day *= (i + 2);
				break;
			}
		}
		day %= 5;
		switch(day){
		case 0:
			abo = "��g";
			break;
		case 1:
			abo = "���g";
			break;		
		case 2:
			abo = "���g";
			break;		
		case 3:
			abo = "���g";
			break;		
		case 4:
			abo = "��";
			break;		
		}
		out.println("<p>�����̉^���́A" + abo + "�ł��B");
	}

}
