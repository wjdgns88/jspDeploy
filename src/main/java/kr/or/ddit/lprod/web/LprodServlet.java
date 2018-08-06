package kr.or.ddit.lprod.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.LprodService;

/**
 * Servlet implementation class LprodServlet
 */
@WebServlet("/lprodList")
public class LprodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 1 : Integer.parseInt(pageSizeStr);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("pageSize", pageSize);
		
		//학생 페이지 리스트, 전체 건수 조회
		LprodService lprodService = new LprodService();
		//List<StudentVo> studentList = studentService.getStudentPageList(paramMap);
		Map<String, Object> resultMap = lprodService.getLprodPageList(map);
		
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("pageList");
		request.setAttribute("lprodList", lprodList);
		
		//페이지 네비게이션 문자열
		String pageNavi = (String) resultMap.get("pageNavi");
		request.setAttribute("pageNavi", pageNavi);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lprod/lprodList.jsp");
		rd.forward(request, response);
	}


}
