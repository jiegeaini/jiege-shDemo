$.ajax({
	type:"get",
    url: "getMusic",
    dataType: "json",
	async: false,
	success: function(data) {
		$("#musicpage").css({
			"display":"none"
		})
		for(var i = 0; i < data.length; i++){
			var html = '<div class="item pos-rlt pageid"><span style="display:none">'+data[i].id+'</span>'+
	        '<a class="item-overlay active opacity wrapper-md font-xs">'+
	         '<span class="block h3 font-bold text-info">'+data[i].name+'</span>'+
	         '<span class="text-muted">'+data[i].username+'</span>'+
	         '<span class="bottom wrapper-md block">'+
	         '- <i class="icon-arrow-right i-lg pull-right"></i></span>'+
	         '</a><a>'+
	         '<img class="img-full" '+
	         'src="http://localhost/flymusicImg/musicpageImg/big/'+data[i].img+'" alt="...">'+
	         '</a></div>';
			$("#musicpage").prepend(html);
		}
		$("#musicpage").fadeIn(2000);
		
		$(".pageid").click(function(){
			var id = $($(this).children("span").get(0)).html();
			var img1 = $($(this).children("a").get(1));
			var img = $($(img1).children("img").get(0)).attr('src');
			$.ajax({
				type:"get",
				data:{id:id},
			    url: "getMusic!getMusicpageMusicId",
			    dataType: "json",
				async: false,
				success: function(data) {
					$("#musicname").css({
						"display":"none"
					})
					$("#pageImg").css({
						"display":"none"
					})
					$("#musicname").empty();
					for(var i = 0; i < data.length; i++){
						var html = '<li class="list-group-item mmid"><span style="display:none">'+data[i].id+'</span>'+
			                '<div class="clear text-ellipsis">'+
			                '<span>'+data[i].name+'</span></div></li>';
						$("#musicname").append(html);
					}
					$("#pageImg").attr("src",img);
					$("#musicname").fadeIn(2000);
					$("#pageImg").fadeIn(2000);
					
					$(".mmid").click(function(){
						var id = $($(this).children("span").get(0)).html();
						$.ajax({
							type:"get",
							data:{id:id},
						    url: "getMusic!getMusicID",
						    dataType: "json",
							async: false,
							success: function(data) {
								$("#fly_audio").attr('src',"http://localhost/flymusicImg/music/"+data.mp3);
					            var fry_audio=$("#fly_audio").get('0');
					            fry_audio.load()
					             fry_audio.play();
					            $(".jp-play").css({"display":"none"});
					            $(".jp-pause").css({"display":"inline-block"});
							},
							error: function() {
							   alert("网络错误 请重试");
							}
							});	
					})
	
				},
				error: function() {
				   alert("网络错误 请重试");
				}
				});	
		})
	},
	error: function() {
	   alert("网络错误 请重试");
	}
	});	

$.ajax({
	type:"get",
    url: "getMusic!getMusic",
    dataType: "json",
	async: false,
	success: function(data) {
		$("#fly-music").css({
			"display":"none"
		})
		for(var i = 0; i < data.length; i++){
			var html = '<li class="list-group-item clearfix musicid"><span style="display:none">'+data[i].id+'</span>'+
            '<a class="pull-left thumb-sm m-r">'+
            '<img src="http://localhost/flymusicImg/singerImg/small/'+data[i].img+'" alt="...">'+
            '</a><a class="clear" href="#">'+
            '<span class="block text-ellipsis">'+data[i].name+'</span>'+
            '<small class="text-muted">'+data[i].singerName+'</small>'+
            '</a></li>';
			$("#fly-music").append(html);
		}
		$("#fly-music").fadeIn(2000);
		$(".musicid").click(function(){
			var id = $($(this).children("span").get(0)).html();
			$.ajax({
				type:"get",
				data:{id:id},
			    url: "getMusic!getMusicID",
			    dataType: "json",
				async: false,
				success: function(data) {
					$("#fly_audio").attr('src',"http://localhost/flymusicImg/music/"+data.mp3);
		            var fry_audio=$("#fly_audio").get('0');
		            fry_audio.load()
		             fry_audio.play();
		            $(".jp-play").css({"display":"none"});
		            $(".jp-pause").css({"display":"inline-block"});
				},
				error: function() {
				   alert("网络错误 请重试");
				}
				});	
		})
	},
	error: function() {
	   alert("网络错误 请重试");
	}
	});	

$.ajax({
	type:"get",
    url: "getMusic!getMusicpageMusic",
    dataType: "json",
	async: false,
	success: function(data) {
		$("#musicname").css({
			"display":"none"
		})
		for(var i = 0; i < data.length; i++){
			var html = '<li class="list-group-item mmid"><span style="display:none">'+data[i].id+'</span>'+
                '<div class="clear text-ellipsis">'+
                '<span>'+data[i].name+'</span></div></li>';
			$("#musicname").append(html);
		}
		$("#musicname").fadeIn(2000);
		$(".mmid").click(function(){
			var id = $($(this).children("span").get(0)).html();
			$.ajax({
				type:"get",
				data:{id:id},
			    url: "getMusic!getMusicID",
			    dataType: "json",
				async: false,
				success: function(data) {
					$("#fly_audio").attr('src',"http://localhost/flymusicImg/music/"+data.mp3);
		            var fry_audio=$("#fly_audio").get('0');
		            fry_audio.load()
		             fry_audio.play();
		            $(".jp-play").css({"display":"none"});
		            $(".jp-pause").css({"display":"inline-block"});
				},
				error: function() {
				   alert("网络错误 请重试");
				}
				});	
		})

	},
	error: function(e) {
	   alert("网络错误 请重试");
	}
	});	

function pause(){
	   $(".jp-play").css({"display":"inline-block"});
       $(".jp-pause").css({"display":"none"});
       $("#fly_audio").get('0').pause()
}
function play(){
	  $(".jp-play").css({"display":"none"});
      $(".jp-pause").css({"display":"inline-block"});
    $("#fly_audio").get('0').play()
}
