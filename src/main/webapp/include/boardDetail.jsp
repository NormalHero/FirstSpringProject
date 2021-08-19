<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>

	<link rel="stylesheet" href="css/boardDetail.css">
	
<div id="gtco-subscribe">
		<div class="gtco-container">
			
							<div class="form-group">
					<hr>
<!-- 검색기능을 추가하게된다면, 검색 셀렉박스를 구현해볼수도있겠다! -->
<div id="boardDetail">
<h2>상세보기 내용</h2>
<hr>
<form action="updateBoard.do" method="post">
	<input type="hidden" value="${boardData.id}" name="id" />
	<table border="1" class="boardtable">
		<tr>
			<td bgcolor="lightblue">글 제목</td>
			<!-- 이름이 같다면 수정할수있게 변경 -->
			
							<c:if test="${sessionScope.log_info != boardData.writer }">
							   <td><input class="boardIn" type="text" name="title" value="${boardData.title} " readonly></td>
							</c:if>
							<c:if test="${sessionScope.log_info == boardData.writer}">
								<td><input class="boardIn" type="text" name="title" value="${boardData.title}"></td>
						    </c:if>
											 
			
		</tr>
		<tr>
			<td bgcolor="lightblue">작성자</td>
			<td>${boardData.writer}</td>
		</tr>
		<tr>
			<td bgcolor="lightblue">상세 내용</td>
							<c:if test="${sessionScope.log_info != boardData.writer}">
							   <td class="boardText"><input class="boardIn" type="text" name="content" value="${boardData.content} " readonly></td>
							</c:if>
							<c:if test="${sessionScope.log_info == boardData.writer }">
			<td class="boardText"><input class="boardIn" type="text" name="content" value="${boardData.content}"></td>
						    </c:if>			
		</tr>
		<tr>
			<td bgcolor="lightblue">작성일</td>
			<td><fmt:formatDate pattern ="yyyy-MM-dd HH:mm:ss" value="${boardData.wdate}"/></td>
		</tr>
		<tr>
			<td bgcolor="lightblue">조회수</td>
			<td>${boardData.cnt}</td>
		</tr>
		
		<!-- 작성자와 이름이 같다면 실행되게 -->
			<c:if test="${sessionScope.log_info == boardData.writer }">
				<tr><td colspan="2"><input type="submit" value="글 내용 변경하기" /></td></tr>
		    </c:if>			
		
			
		
	</table>
</form>
<br><br>

<c:if test="${sessionScope.log_info == boardData.writer ||sessionScope.log_Role == true   }">
<div class="boardButtom_ob">
<a href="deleteBoard.do?id=${boardData.id}">게시글 삭제하기</a>
</div>
</c:if>



<div class="boardButtom_ob">
<a href="getBoardList.do">게시글 목록보기</a>
</div>

<!-- 페이징처리 부분 -->
<div class="boardButtom_ob">
<a href="insertBoard.jsp">글 작성</a>
</div>
</div>
							
								
							</div>
						</div>

		</div>