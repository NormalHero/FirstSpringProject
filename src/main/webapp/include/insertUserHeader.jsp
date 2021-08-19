<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.2.1.min.js">
</script>
	<script type="text/javascript">

		
		function insertUserNullCk() {
	var form = document.insertUsersForm;

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
        if (form.name.value == "") {
            alert("이름을 입력해주세요 !");
            form.id.focus();
            return false;
        }
        //아이디에 공백 사용하지 않기
        if (form.id.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다.")
            form.id.focus();
            form.id.select()
            return false;
        }
        if (form.password.value != form.passwordCk.value) {
            alert("비밀번호와  비밀번호 확인이 일치하지 않습니다!")
            form.id.focus();
            form.id.select()
            return false;
        }

        
        alert("회원가입 되었습니다! 로그인 해주세요!");
        	form.submit();
  }
		
		
		function fn_idChk(){
			
			
			
			$.ajax({
				url : "idChk.do",
				type : "post",
				dataType : "json",
				data : {"id" : $("#id").val()},
				success : function(data){
					if(data == 1){
						alert("중복된 아이디입니다.");
						$("#submitBar").attr("disabled", "disabled");
					}else if(data == 0){
						$("#idChk").attr("value", "Y");
						alert("사용가능한 아이디입니다.");
						$("#submitBar").removeAttr("disabled");
					}
				}
			})
		}
		
	$(function () {
		
		$("#id").on("propertychange change keyup paste input", function(){
			newValue = $(this).val();
			$("#submitBar").attr("disabled", "disabled");
		});
		
		
		
		});
	
	 function check_pw(){
		 
         var password = document.getElementById('password').value;
         var check_SC = 0;
		 
         if(password.length < 4 || password.length>20){
             window.alert('비밀번호는 4글자 이상, 20글자 이하만 이용 가능합니다.');
             document.getElementById('password').value='';
         }
		 
		 if(document.getElementById('password').value !='' && document.getElementById('passwordCk').value!=''){
		        if(document.getElementById('password').value==document.getElementById('passwordCk').value){
		            document.getElementById('check').innerHTML='비밀번호가 일치합니다.'
		            document.getElementById('check').style.color='blue';
		        }
		        else{
		            document.getElementById('check').innerHTML='비밀번호가 일치하지 않습니다.';
		            document.getElementById('check').style.color='red';
		        }
		    }
		 
	 }
	


	
	</script>






	<header id="gtco-header" class="gtco-cover gtco-cover-md" role="banner" style="background-image: url(images/img_bg_1.jpg)" data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="gtco-container">
			<div class="row">
				<div class="col-md-12 col-md-offset-0 text-left">
					

					<div class="row row-mt-15em">
					<!--  
						<div class="col-md-7 mt-text animate-box" data-animate-effect="fadeInUp">
							<span class="intro-text-small">Hand-crafted by <a href="http://gettemplates.co" target="_blank">GetTemplates.co</a></span>
							<h1 class="cursive-font">All in good taste!</h1>	
						</div>
						-->
						<div class="insetUserBox col-md-4 col-md-push-1 animate-box" data-animate-effect="fadeInRight">		
							<!--  <div class="form-wrap">-->
							<!-- 
								<div class="tab">
									
									<div class="tab-content">
										<div class="tab-content-inner active" data-content="signup">
											<h3 class="cursive-font">회원가입</h3>   폰트변경 
											<form action="login.do">
												<div class="row form-group">
													<div class="col-md-12">
														<label >아이디</label>
														<input type="text" name="id" class="form-control">
										
														
														
													</div>
												</div>
												<div class="row form-group">
													<div class="col-md-12">
														<label >비밀번호</label>
														<input type="password" name="password" class="form-control">
													</div>
												</div>

													
											
											</form>	
											<a href="insertUser.jsp">회원가입</a>
										</div>

										
									</div>
									
								</div>
								-->

							<!--  </div>-->
						<div id="insertUserStart">
							<form name = "insertUsersForm" action="insertUsers.do" method="post">
									<h3 class="titlename">회원가입</h3>
								<div id="IUgrop">
									<div>
										<p>이름</p>
										<p><input class="inputboxIU" class="inputbar" type="text" id="name" name="name"></p>
									</div>
									<div>
										<p>아이디</p>
										<p><input class="inputboxIU" type="text" id="id"name="id">
										<button type="button" onclick="fn_idChk();" id="idChk" value="N">중복확인</button>
										</p>
									</div>
									<div>
										<p>비밀번호</p>
										<p><input class="inputboxIU" type="password" id="password" name="password"  onchange="check_pw()"></p>
									</div>
									<div>
										<p>비밀번호 확인</p>
										<p>
											<input class="inputboxIU" type="password" id="passwordCk" name="passwordCk"  onchange="check_pw()">&nbsp;
												<span id="check"></span>
										</p>
									</div>
									<div>
										<p>
										권한 <select class="rolecolor" name="role"><option class="rolecolor" selected>USER</option><option class="rolecolor">ADMIN</option></select>
										</p>
									</div>
									<div>
						<p>	<input class="inputboxIU"  id="submitBar" type="button" value="회원가입" disabled="disabled" onclick="insertUserNullCk();"/></p>
									
									</div>
							
								 </div>
							 </form>
						</div>
								
						</div>
					</div>
							
					
				</div>
			</div>
		</div>
	</header>