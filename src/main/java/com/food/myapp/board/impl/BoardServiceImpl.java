package com.food.myapp.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.myapp.board.BoardService;
import com.food.myapp.board.BoardVO;
import com.food.myapp.board.PagingVO;


@Service("BoardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDAO;
	
	// 높은 결합도
	// 클래스의 변경이나 메서드의 변화에대해(유지보수에대해)
	// 대처가 유연하지않다!
	
	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getContent().equals("aaa")) {
//			throw new RuntimeException("예외 일부러 발생!");
//		}
		boardDAO.insertBoard(vo);
	//	boardDAO.insertBoard(vo);
		// 똑같은 id가 바로 insert될수있게 일부러 insert()x2 수행
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
	
	public int viewCntPlus(BoardVO vo) {
		
	 return boardDAO.viewCntPlus(vo);
	}

	
	public int countBoard(BoardVO vo) {
		return boardDAO.countBoard(vo);
	}


	public List<BoardVO> selectBoard(PagingVO pvo) {
		return boardDAO.selectBoard(pvo);
	}


	

}
