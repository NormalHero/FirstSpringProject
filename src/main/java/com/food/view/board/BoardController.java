package com.food.view.board;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.food.myapp.board.BoardListVO;
import com.food.myapp.board.BoardService;
import com.food.myapp.board.BoardVO;
import com.food.myapp.board.PagingVO;
import com.food.myapp.board.impl.BoardDAO;
import com.food.myapp.board.impl.BoardServiceImpl;

@Controller
@SessionAttributes("boardData")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	// 비즈니스 컴포넌트
	
//	   @RequestMapping("/dataTransform.do")
//	   @ResponseBody
//	   public List<BoardVO> dataTransform(BoardVO vo) {
//	      vo.setSearch("title");
//	      vo.setSearchcontent("");
//	      List<BoardVO> datas=boardService.getBoardList(vo);
//	      return datas;
//	   }
	   @RequestMapping("/dataTransform.do")
	   @ResponseBody
	   public BoardListVO dataTransform(BoardVO vo) {
	      vo.setSearch("title");
	      vo.setSearchContent("");
	      List<BoardVO> datas=boardService.getBoardList(vo);
	      BoardListVO blvo = new BoardListVO();
	      blvo.setBoardList(datas);
	      return blvo;
	   }
	
	
	@RequestMapping(value="/insertBoard.do")
	public String insertBoard(BoardVO vo){ // == Command객체
		System.out.println("게시글 등록 컨트롤러");
		
		boardService.insertBoard(vo); // 비즈니스 메서드 
		
		return "getBoardList.do"; // redirect:
	}
	
	@ModelAttribute("resultMap")
	public HashMap<String,String> searchMap() {
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("제목","title");
		map.put("내용", "content");
		map.put("작성자", "writer");
		return map;
	}
	/*@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="search",defaultValue="title",required=false)String search,@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,BoardDAO dao,Model m)  {
		System.out.println("게시판 목록보기 컨트롤러");

		System.out.println(search);
		System.out.println(searchContent);
		List<BoardVO> boardList=dao.getBoardList(vo);
		
		m.addAttribute("boardList", boardList);
	
		return "getBoardList.jsp";
	}*/
	
	@RequestMapping(value="/getBoardList.do") //검색을 하지 않을때도 사용하는 경우가 있음 
	public String getBoardList(BoardVO vo,Model m //,PagingVO pvo, @RequestParam(value="nowPage", required=false)String nowPage
			//, @RequestParam(value="cntPerPage", required=false)String cntPerPage 
			)  {
		System.out.println("게시판 목록보기 컨트롤러+검색");
		//세션을 사용하면 이전 검색기록이 남는게 문제가 될수있음 
		if(vo.getSearch()==null) {
			vo.setSearch("title"); //기본값jsp페이지에서 
		}
		if(vo.getSearchContent()==null) {
			vo.setSearchContent("");
		}
		
		/*
		int total = boardService.countBoard(vo);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		pvo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		m.addAttribute("paging", pvo);
		
		m.addAttribute("viewAll", boardService.selectBoard(pvo));
		*/
		
		List<BoardVO> boardList=boardService.getBoardList(vo);
		//List<BoardVO> boardList=boardService.selectBoard(pvo);
		
		m.addAttribute("boardList", boardList);
	
		return "getBoardList.jsp";
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo,Model m) {
		System.out.println("게시글 상세조회 컨트롤러");

		BoardVO v=boardService.getBoard(vo);
		boardService.viewCntPlus(vo);
		m.addAttribute("boardData",v);
		
		return "getBoard.jsp";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo,BoardDAO dao) {
		System.out.println("게시글 삭제 컨트롤러");
		
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("boardData")BoardVO vo) {
		System.out.println("게시글 내용 변경 컨트롤러");
		System.out.println(vo.getWriter());
		// view에서 사용자가 직접 입력하지않은 값에대해서 null이 들어온다!
			
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	
}
