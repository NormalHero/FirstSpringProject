<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<div class="gtco-section">
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12">
					<div class="col-md-6 animate-box">
					<h3>후기 작성</h3>
					<c:if test="${!empty sessionScope.log_info }">
					<form action="insertBoard.do" method="post">
						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="name">글 제목</label>
								<input type="text" name="title" class="form-control" placeholder="제목을 입력하세요!">
							</div>
							
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="writer">작성자</label>
								
								<input type="text" name="writer" class="form-control" placeholder="작성자를 입력하세요!" value="${sessionScope.log_info}" readonly>
								
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12">
								<label class="sr-only" for="content">내용</label>
								<textarea name="content" cols="30" rows="10" class="form-control" placeholder="내용을 입력하세요!"></textarea>
							</div>
						</div>
						<div class="form-group">
							<input type="submit" value="글 등록하기" class="btn btn-primary">
						</div>

					</form>		
					</c:if>
				    <c:if test="${empty sessionScope.log_info }">
							   <h1>로그인이후 이용가능합니다 !</h1>
									
					</c:if>
					<br><br>
<a href="getBoardList.do">게시글 목록보기</a>
				</div>

				</div>
			</div>
		</div>
	</div>