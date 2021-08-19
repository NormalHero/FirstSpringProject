<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

	<!-- 로그인스타일 -->
	<link rel="stylesheet" href="css/logStyle.css">

	<!-- Modernizr JS -->
<script type="text/javascript">
function logNullCk() {
	var form = document.loginForm;

        if (form.id.value == "") {
            alert("아이디를 입력해주세요 !");
            form.id.focus();
            return false;
        }
        if (form.password.value == "") {
            alert("비밀번호를 입력해주세요 !");
            form.id.focus();
            return false;
        }
        	form.submit();
        
  }
   
</script>


<header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">수제 샐러드 ... <a href="https://www.instagram.com/cafe_n.wave/" target="_blank">인스타그램</a></span>
							<h1 class="cursive-font">NATURAL WAVE</h1>	
						</div>
						<div class="col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">
							<div class="form-wrap">
								<div class="tab">
									
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<span id="logmainText">로그인 </span> 
											<form name="loginForm" action="login.do" method="post">
												<div class="row form-group">
													<div class="col-md-12">
														<label >아이디</label>
														<input type="text"  name="id" class="form-control">
										
														
														
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label >비밀번호</label>
														<input type="password" name="password" class="form-control">
													</div>
												</div>
												<p><input id="logSubmit" type="button" value="로그인" onclick="logNullCk()" ></p>
												

														
											</form>	
											<a href="insertUser.jsp">회원가입</a>
										</div>

										
									</div>
								</div>
							</div>
						</div>
					</div>
							
					
				</div>
			</div>
		</div>
	</header>