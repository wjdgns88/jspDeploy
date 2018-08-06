package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVo;

public interface LprodServiceInf {
	
	/**
	* Method : selectAllLprod
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC01
	* 변경이력 :
	* @return
	* Method 설명 : 상품 전체 정보를 조회
	*/
	List<LprodVo> selectAllLprod();
	
	/**
	* Method : getLprodPageList
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC01
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 상품 페이지 리스트 조회
	*/
	Map<String, Object> getLprodPageList(Map<String, Integer> map);
	
	/**
	* Method : getLprodTotCnt
	* 최초작성일 : 2018. 7. 11.
	* 작성자 : PC01
	* 변경이력 :
	* @return
	* Method 설명 : 전체 상품 수 조회
	*/
}
