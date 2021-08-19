package com.food.myapp.board;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="boardList")//루트엘리먼트 태그이름 설정 
@XmlAccessorType(XmlAccessType.FIELD)
public class BoardListVO {
	@XmlElement(name="board") // 그 하위 엘리먼트 태그 이름 설정
	private List<BoardVO> boardList;

	public List<BoardVO> getBoardList() {
		return boardList;
	}

	public void setBoardList(List<BoardVO> boardList) {
		this.boardList = boardList;
	}
	
	
}
