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
	// ����Ͻ� ������Ʈ
	
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
	public String insertBoard(BoardVO vo){ // == Command��ü
		System.out.println("�Խñ� ��� ��Ʈ�ѷ�");
		
		boardService.insertBoard(vo); // ����Ͻ� �޼��� 
		
		return "getBoardList.do"; // redirect:
	}
	
	@ModelAttribute("resultMap")
	public HashMap<String,String> searchMap() {
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("����","title");
		map.put("����", "content");
		map.put("�ۼ���", "writer");
		return map;
	}
	/*@RequestMapping(value="/getBoardList.do")
	public String getBoardList(@RequestParam(value="search",defaultValue="title",required=false)String search,@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,BoardDAO dao,Model m)  {
		System.out.println("�Խ��� ��Ϻ��� ��Ʈ�ѷ�");

		System.out.println(search);
		System.out.println(searchContent);
		List<BoardVO> boardList=dao.getBoardList(vo);
		
		m.addAttribute("boardList", boardList);
	
		return "getBoardList.jsp";
	}*/
	
	@RequestMapping(value="/getBoardList.do") //�˻��� ���� �������� ����ϴ� ��찡 ���� 
	public String getBoardList(BoardVO vo,Model m //,PagingVO pvo, @RequestParam(value="nowPage", required=false)String nowPage
			//, @RequestParam(value="cntPerPage", required=false)String cntPerPage 
			)  {
		System.out.println("�Խ��� ��Ϻ��� ��Ʈ�ѷ�+�˻�");
		//������ ����ϸ� ���� �˻������ ���°� ������ �ɼ����� 
		if(vo.getSearch()==null) {
			vo.setSearch("title"); //�⺻��jsp���������� 
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
		System.out.println("�Խñ� ����ȸ ��Ʈ�ѷ�");

		BoardVO v=boardService.getBoard(vo);
		boardService.viewCntPlus(vo);
		m.addAttribute("boardData",v);
		
		return "getBoard.jsp";
	}
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo,BoardDAO dao) {
		System.out.println("�Խñ� ���� ��Ʈ�ѷ�");
		
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("boardData")BoardVO vo) {
		System.out.println("�Խñ� ���� ���� ��Ʈ�ѷ�");
		System.out.println(vo.getWriter());
		// view���� ����ڰ� ���� �Է��������� �������ؼ� null�� ���´�!
			
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	
}
