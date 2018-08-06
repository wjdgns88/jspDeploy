package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class LprodDaoTest {
	
	//@Before --> @Test --> @After
	
		//테스트 메소드 안에 중복되는 내용 :  LprodDao 구현체에 대한 생성 로직
		//	--> @Before 어노테이션이 붙은 setup 메소드에 위임
		//모든 테스트 메소드에서 LprodDao 객체를 참조할 수 있게끔 클래스 변수로 생성할 필요가 있고
		//클래스 변수를 setup메소드에서 초기화하는 로직이 필요
	
	private LprodDaoInf lprodDao;
	
	@Before
	public void setup(){
		lprodDao = new LprodDao();
	}

	/**
	 * 
	 * Method : selectAllLprodstest
	 * 최초작성일 : 2018. 7. 10.
	 * 작성자 : PC01
	 * 변경이력 :
	 * Method 설명 : 전체 학생 정보를 조회한다.
	 */
	@Test
	public void selectAllLprodstest() {
		/***Given***/
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.selectAllLprod();
		
		for(LprodVo vo : lprodList)
			System.out.println(vo);
			System.out.println("//////////////////////////////////////////////////////");

		/***Then***/
		assertEquals(15, lprodList.size());
		
	}
	
	@Test
	public void getLprodPageListTest(){
		/***Given***/
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", 2);
		map.put("pageSize", 10);
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.getLprodPageList(map);
		
		/***Then***/
		assertEquals(5, lprodList.size());
		
	}
}
