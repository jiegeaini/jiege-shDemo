
  	function login(){
  	
  		var username = $("#uname").val();
  		var password = $("#upass").val();
  		if(username == ""){
  			alert("账户不能为空");
  		}else if(password == ""){
  			alert("密码不能为空");
  		}else{
  			$.ajax({
  				type:"GET",
  				dataType:"json",
  				data:{
  					username:username,password:password
  				},
  				url:"UserAction",
  				async:false,
  				success:function(data){
  					if(data.mess == "ok"){
  						alert("登录成功");
  						window.open("genres.html");
  					}else{
  						alert("登录失败");
  						window.open("signin.html");
  					}
  				},
  				error:function(e){
  					alert(e);
  				}
  			});
  		}
  		
  	}
  	
  	
  	function signup(){
  		var username = $("#username").val();
  		var phone = $("#phone").val();
  		var password = $("#password").val();
  		
  		if(username == ""){
  			alert("用户名不能为空");
  		}else if(phone == ""){
  			alert("手机号不能为空");
  		}else if(phone.length!=11){
  			alert("手机号码格式不正确");
  		}else if(password == ""){
  			alert("密码不能为空");
  		}else{
  			$.ajax({
  				type:"POST",//提交方式
  				url:"UserAction!signupAction",//请求服务器地址
  				dataType:"json",//服务器给客户端相应到格式
  				data:{username:username,phone:phone,password:password},
  				async:false,
  				success:function(data){					
  				if(data.success == "notok"){
  						alert("此账号已被使用");
  				}else {
  						alert("注册成功");
  				}
  				},
  				error:function(e){
  					alert("fdd");
  				}
  			});
  		}
  	}
