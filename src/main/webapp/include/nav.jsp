<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <link rel="stylesheet" href="css/UserStyle.css">
    
	<nav class="gtco-nav" role="navigation">
		<div class="gtco-container">
			
			<div class="row">
				<div class="col-sm-4 col-xs-12">
					<div id="gtco-logo"><a href="index.jsp">NATURAL WAVE <em>.</em></a></div>
				</div>
				<div class="col-xs-8 text-right menu-1">
					<ul>
						<li><a href="index.jsp#gomenu">Menu</a></li>
						<li class="has-dropdown">
							<a href="#">Service</a>
							<ul class="dropdown">
								<li><a href="getBoardList.do">후기 게시판</a></li>
								<li><a href="info.jsp">매장안내</a></li>
							</ul>
						</li>
		<!-- 로그인여부로 처리 -->	<li class="btn-cta ">
									    	<c:if test="${empty sessionScope.log_info }">
											   <a href="login.jsp"><span>로그인/회원가입</span></a>
									
											 </c:if>
											 
											<c:if test="${!empty sessionScope.log_info }">
												<span class="idColor">${sessionScope.log_info}</span><span class="idAfColor">님 반가워요!</span>
										 		<a href="logout.do"><span>로그아웃</span></a>
										    </c:if>
											 

										 
								</li>
					</ul>	
				</div>
			</div>
			
		</div>
	</nav> 