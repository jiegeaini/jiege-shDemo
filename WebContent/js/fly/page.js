$(function (){
	//当div中有数据时，返回长度为1
	if($("#musicpage").length == 1) {
		
		$.ajax({
			type : "post",
			url : "GetPage!getPageNum",
			dataType : "json",
			success : function (msg){
				//循环向div中添加数据（歌单）
				for(var i = 0; i < msg.num; i++) {
					if(i == 0){
						var html = '<li><a><i class="fa fa-chevron-left"></i></a></li>';
						var html1 = '<li class="active"><a>1</a></li>';
						$("#fy").append(html);
						$("#fy").append(html1);
					}
					if(i > 0){
						var html = '<li><a >'+(i+1)+'</a></li>';
						$("#fy").append(html);
					}
					if(i == msg.num-1){
						var html = '<li><a><i class="fa fa-chevron-right"></i></a></li>';
						$("#fy").append(html);
					}
				}
				
				$("#fy li").click(function(){
					var a = $(this).text();
					//移除所有li的类
					$("#fy li").removeClass("active")
					//给当前li追加类
					$(this).addClass("active");
					if(a != "") {
						$.ajax({
							type : "post",
							url : "GetPage!getPage",
							dataType : "json",
							data : {num:a},
							success : function (msg){
								//清空当前div中的所有子元素
								$("#musicpage").empty();
								//隐藏当前div中的样式（为下面的fadeIn(1000)1秒后浮现铺垫）
								$("#musicpage").css({
									"display":"none"
								});	
								for(var i = 0; i < msg.length; i++ ){
								var text = ' <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">'+
											'<div class="item">'+
//											'<div class="pos-rlt">'+
//											'<div class="item-overlay opacity r r-2x bg-black">'+
//											'<div class="center text-center m-t-n">'+
//											'<a><i class="fa fa-play-circle i-2x"></i></a>'+
//											'</div>'+
//											'</div>'+
//											'</div>'+
											'<a><img onclick="imgers('+msg[i].id+')" src="http://localhost/flymusicImg/musicpageImg/small/'+msg[i].smallImg+'" alt="" class="r r-2x img-full"></a>'+
											'</div>'+
											'<div class="padder-v">'+
											'<a data-bjax data-target="#bjax-target" data-el="#bjax-el" data-replace="true" class="text-ellipsis">'+msg[i].name+'</a>'+
											'<a data-bjax data-target="#bjax-target" data-el="#bjax-el" data-replace="true" class="text-ellipsis text-xs text-muted">'+msg[i].jieshao+'</a>'+
											'</div>'+
					                  		'</div>';
								//向前追加元素
								$("#musicpage").prepend(text);
								//一秒后浮现
								$("#musicpage").fadeIn(1000);
								}
							},
							error : function (e){
								alert("网络错误！");
							}
						});
					}
				});
			},
			error : function (e){	
				alert("网络错误2！");
			}
		});
		
		$.ajax({
			type : "post",
			url : "GetPage!getPage",
			dataType : "json",
			data : {num:1},
			success : function (msg){
				for(var i = 0; i < msg.length; i++ ){
				var text = ' <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">'+
							'<div class="item">'+
//							'<div class="pos-rlt">'+
//							'<div class="item-overlay opacity r r-2x bg-black">'+
//							'<div class="center text-center m-t-n">'+
//							'<a><i class="fa fa-play-circle i-2x"></i></a>'+
//							'</div>'+
//							'</div>'+
//							'</div>'+
							'<a><img onclick="imgers('+msg[i].id+')" src="http://localhost/flymusicImg/musicpageImg/small/'+msg[i].smallImg+'" alt="" class="r r-2x img-full"></a>'+
							'</div>'+
							'<div class="padder-v">'+
							'<a data-bjax data-target="#bjax-target" data-el="#bjax-el" data-replace="true" class="text-ellipsis">'+msg[i].name+'</a>'+
							'<a data-bjax data-target="#bjax-target" data-el="#bjax-el" data-replace="true" class="text-ellipsis text-xs text-muted">'+msg[i].jieshao+'</a>'+
							'</div>'+
	                  		'</div>';
				$("#musicpage").prepend(text);
				}
			},
			error : function (e){
				alert("网络错误3！");
			}

		});
		
	}else if($("#musicpage").length > 1){
		$("#fy li").click(function(){
			var a = $(this).html();
			alert(a);
		})
	};
	
});

function imgers(e){
	
	$(location).attr('href', 'muiscpage.html?id='+e);
	
}