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
	
	// ���� ���յ�
	// Ŭ������ �����̳� �޼����� ��ȭ������(��������������)
	// ��ó�� ���������ʴ�!
	
	@Override
	public void insertBoard(BoardVO vo) {
//		if(vo.getContent().equals("aaa")) {
//			throw new RuntimeException("���� �Ϻη� �߻�!");
//		}
		boardDAO.insertBoard(vo);
	//	boardDAO.insertBoard(vo);
		// �Ȱ��� id�� �ٷ� insert�ɼ��ְ� �Ϻη� insert()x2 ����
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
