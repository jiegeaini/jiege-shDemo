
/**
 * 查询歌手
 */
$.ajax({
  				type:"POST",//提交方式
  				url:"UserAction!likemusic",//请求服务器地址
  				dataType:"json",//服务器给客户端相应到格式
  				success:function(data){
  					for(var i=0;i<data.length;i++){
  						if(data==""){
  							alert("haha");
  						}else {
  							var html = ' <li class="list-group-item">'+
                            '<a href="#" class="thumb-sm pull-left m-r-sm">'+
                              '<img src="http://localhost:80/flymusicImg/singerImg/small/'+data[i].img+'" class="img-circle">'+
                            '</a>'+
                            '<a href="#" class="clear">'+
                              '<small class="pull-right">2018-10-15</small>'+
                              '<strong class="block">'+data[i].name+'</strong>'+
                              '<small>'+data[i].singername+'</small>'+
                            '</a>'+
                          '</li>'
                            
                            $("#music").append(html);
                            
  						}
  						
  					}
  					
  					
  				},
  				error:function(e){
  					
  				}
  			});

/**
 * 查询歌手
 */
$.ajax({
		type:"POST",//提交方式
		url:"UserAction!likesiger",//请求服务器地址
		dataType:"json",//服务器给客户端相应到格式
		success:function(data){
			for(var i=0;i<data.length;i++){
				if(data==""){
					alert("haha");
				}else {
					var html = ' <li class="list-group-item">'+
                '<a href="#" class="thumb-sm pull-left m-r-sm">'+
                  '<img src="http://localhost:80/flymusicImg/singerImg/small/'+data[i].img+'" class="img-circle">'+
                '</a>'+
                '<a href="#" class="clear">'+
                  '<small class="pull-right">2018-10-15</small>'+
                  '<strong class="block">'+data[i].name+'</strong>'+
                  '<small>'+data[i].where+'</small>'+
                '</a>'+
              '</li>'
               
                $("#siger").append(html);
				}
				
			}
		},
		error:function(e){
			
		}
	});

/**
 * 查询歌单
 */
$.ajax({
	type:"POST",//提交方式
	url:"UserAction!likemusicpage",//请求服务器地址
	dataType:"json",//服务器给客户端相应到格式
	success:function(data){
		for(var i=0;i<data.length;i++){
			if(data==""){
				alert("haha");
			}else {
				var html =
                '<li class="list-group-item">'+
                
    '<div class="item pos-rlt">'+
     ' <a href="#" class="item-overlay active opacity wrapper-md font-xs">'+
       ' <span class="block h3 font-bold text-info">'+data[i].name+'</span>'+
       ' <span class="text-muted">'+data[i].upold+'</span>'+
        '<span class="bottom wrapper-md block">- <i class="icon-arrow-right i-lg pull-right"></i></span>'+
      '</a>'+
      '<a href="#">'+
        '<img class="img-full" src="http://localhost:80/flymusicImg/musicpageImg/big/'+data[i].img+'">'+
      '</a>'+
    '</div>'+
   
             '</li>'
       		

            $("#musicpage").append(html);
			}
			
		}
		
		
		
	},
	error:function(e){
		
	}
});


/**
 * 查询用户名
 */
$.ajax({
	type:"POST",//提交方式
	url:"UserAction!username",//请求服务器地址
	dataType:"json",//服务器给客户端相应到格式
	success:function(data){
				var html = '<div  class="h3 m-t-xs m-b-xs">'+data[0].username+'</div>'
				
            $("#username").append(html);
			},
			error:function(e){
		
			}
});



/**
 * 查询喜欢的歌曲
 */
$.ajax({
	type:"POST",//提交方式
	url:"UserAction!likesiger",//请求服务器地址
	dataType:"json",//服务器给客户端相应到格式
	success:function(data){

			var html = '<span class="m-b-xs h4 block">'+data.length+'</span>'
			
            $("#likepeople").append(html);
			
			},error:function(e){
			
			}
});


$.ajax({
	type:"POST",//提交方式
	url:"UserAction!likemusic",//请求服务器地址
	dataType:"json",//服务器给客户端相应到格式
	success:function(data){
			
			var html = '<span class="m-b-xs h4 block">'+data.length+'</span>'
			
            $("#likemusic").append(html);
			
			},error:function(e){
			
			}
});