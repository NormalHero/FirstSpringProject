package com.food.myapp.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.myapp.board.BoardVO;
import com.food.myapp.board.PagingVO;


@Repository("boardDAO")
public class BoardDAO {

	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertBoard(BoardVO vo) {
		mybatis.insert("BoardDAO.insertBoard", vo);
	}
	
	public void updateBoard(BoardVO vo) {
		mybatis.update("BoardDAO.updateBoard",vo);

	}
	
	public void deleteBoard(BoardVO vo) {
		mybatis.delete("BoardDAO.deleteBoard",vo);
		
	}
	
	public BoardVO getBoard(BoardVO vo) {
		return (BoardVO)mybatis.selectOne("BoardDAO.getBoard",vo);
	}
	
	public List<BoardVO> getBoardList(BoardVO vo) {
		return mybatis.selectList("BoardDAO.getBoardList",vo);
	}
	public int viewCntPlus(BoardVO vo) {
		return mybatis.update("BoardDAO.viewCntPlus",vo);
	}
	

 public int countBoard(BoardVO vo) {
	 return mybatis.selectOne("BoardDAO.countBoard",vo);
 }

public List<BoardVO> selectBoard(PagingVO pvo) {
	// TODO Auto-generated method stub
	return mybatis.selectList("BoardDAO.selectBoard",pvo);
}

	
}
