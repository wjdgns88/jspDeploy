package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sumCalculation
 */
@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String start = req.getParameter("start");
		String end = req.getParameter("end");
		
		int s = Integer.parseInt(start);
		int e = Integer.parseInt(end);
		int sum = 0;
		for (int i = s+1; i < e; i++) {
			sum += i;
		}
//		System.out.println(start+"와 " + end + "의 사이 숫자들의 합은 : " + sum);
//		request.getParameter 사용자가 보낸 파라미터를 받아오는 작업
//		request객체에 일시적으로 값을 저장하는 방법
		req.setAttribute("sumResult", sum);
		
		//session에 sumResult를 저장한다.
		HttpSession session = req.getSession();
		session.setAttribute("sumResult", sum);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/sumResult.jsp");
		rd.forward(req, resp);
		
	}


}
