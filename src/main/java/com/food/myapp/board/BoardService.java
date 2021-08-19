package com.food.myapp.board;

import java.util.List;

public interface BoardService {
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public BoardVO getBoard(BoardVO vo);
	public List<BoardVO> getBoardList(BoardVO vo);
	public int viewCntPlus(BoardVO vo);


	// 게시물 총 갯수
	public int countBoard(BoardVO vo);

	// 페이징 처리 게시글 조회
	public List<BoardVO> selectBoard(PagingVO pvo);
	



}
