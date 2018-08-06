package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		// 파라미터를 받아서 sysout으로 console 창에 출력
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		// 로그인 프로세스
		// 가짜 (fake) service, dao객체를 생성
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.getUser(userId);

		// userSerivce에서 받아온userVo의 정보와 사용자가 입력한 정보가 동일할 경우
		// [로그인 성공] 메세지를 화면에 출력
		// 정보가 틀릴경우
		// [로그인 실패] 메세지를 화면에 출력
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter();

		// 로그인 성공시 : forward /main.jsp : [main.jsp]
		// 로그인 실패시 : redirect login.jsp

		// 로그인 성공시 userVo 객체를 저장하여 (적당한 영역에)
		// main.jsp에서 사용자 아이디를 화면에 출력
		// 단 새로운 탭에서 main.jsp를 직접 접속해도 사용자 아이디가 화면에 나와야한다.
		if (userVo.validateUser(userId, password)) {
			HttpSession session = request.getSession();
			session.setAttribute("userVo", userVo);
			request.getRequestDispatcher("/jsp/main.jsp").forward(request,
					response);
		} else {
			// response.sendRedirect("/login/login.jsp");
			request.getRequestDispatcher("/login/login.jsp").forward(request,
					response);
		}

		System.out.println("userId : " + userId);
		System.out.println("password : " + password);
	}

}
