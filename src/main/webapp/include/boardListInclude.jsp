<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>



	<!-- Board.css -->
	<link rel="stylesheet" href="css/board.css">

<script>
function selChange() {
	var sel = document.getElementById('cntPerPage').value;
	location.href="getBoardList.do?nowPage=${paging.nowPage}&cntPerPage="+sel;
}
</script>


<div id="gtco-subscribe tableBody">
		<div class="gtco-container">
			
							<div class="form-group">
							<p></p>
<hr>
<!-- 검색기능을 추가하게된다면, 검색 셀렉박스를 구현해볼수도있겠다! -->

<form action="getBoardList.do" method="post">
	<table border="1" width="800">
		<tr>
			<td align="right" bgcolor="pink">
			<select name="search">
			<c:forEach items="${resultMap}" var="o">
			<option value="${o.value}">${o.key}</option>
			</c:forEach>
			</select>
			<input type="text" name="searchContent">
			<input type="submit" value="검색">
			</td>
		</tr>
	</table>
</form>
<a href="getBoardList.do" class="srchMargin">초기화</a>

<!--  페이징 갯수처리 옵션선택 끝 
<div id="outter">
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div>--> 

<table border="1" id="boardListTB">
	<tr>
		<th  id="bdcolor" class="boardTextNum txtCenter ">글 번호</th>
		<th id="bdcolor"  class="boardtt txtCenter ">제목</th>
		<th id="bdcolor"  class="boardWr txtCenter ">작성자</th>
		<th id="bdcolor"   class="boarddate txtCenter ">작성일</th>
		<th id="bdcolor"   class="boardcnt txtCenter  "  >조회수</th>
	</tr>
	<c:forEach items="${boardList}" var="v">
		<tr>
			<td>${v.id}</td>
			<td><a href="getBoard.do?id=${v.id}">${v.title}</a></td>
			<td>${v.writer}</td>
			<td><fmt:formatDate pattern ="yyyy-MM-dd HH:mm:ss" value="${v.wdate}"/></td>
			<td>${v.cnt}</td>
		</tr>
	</c:forEach>
</table>
<br><br>
<!-- 페이징처리 부분 

<div>
		<c:if test="${paging.startPage != 1 }">
			<a href="getBoardList.do?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="getBoardList.do?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="getBoardList.do?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
</div> -->
<a href="insertBoard.jsp">글 작성</a>
						
								
							</div>
						</div>

		</div>