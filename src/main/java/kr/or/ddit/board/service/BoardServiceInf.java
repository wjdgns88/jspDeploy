package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {
	
	
	/**
	* Method : getBoardlist
	* 최초작성일 : 2018. 7. 5.
	* 작성자 : PC01
	* 변경이력 :
	* @return
	* Method 설명 :
	*/
	List<BoardVo> getBoardlist();
}
