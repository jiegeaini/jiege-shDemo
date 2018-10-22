var end = 0;
var endY = 0;
var max = 0;
$.ajax({
			type:"post",
			url: "H_MusicAdd",
			dataType:"json",
		    async: false,
			success: function(data) {
				 max =data.max;
				if(max % 5 != 0){
					endY = max%5;
				}
				var html = '<li><a href="#"><i class="fa fa-chevron-left">t</i></a></li>'+
                        '<li class="active"><a href="#">1</a></li>'+
                        '<li><a >2</a></li>'+
                        '<li><a>3</a></li>'+
                        '<li><a>4</a></li>'+
                        '<li><a >5</a></li>'+
                        '<li><a ><i class="fa fa-chevron-right">l</i></a></li>';
				$(".pagination").append(html);
				
				$(".pagination li").click(function(){
					var zhi = $(this).text();
					if(zhi == "t"){
						if($(".pagination li").eq(1).text() != "1"){
							for(var i = 1;i<6;i++){
								var tt = $(".pagination li").eq(i).text();
								$(".pagination li a").eq(i).text(parseInt(tt)-parseInt(5))
							}
						}
					} else if(zhi == "l"){
						for(var j = 1;j<6;j++){
							if($(".pagination li").eq(j).text() == max){
								return false
							}else if(j == 5){
								for(var i = 1;i<6;i++){
									var tt = $(".pagination li").eq(i).text();
									$(".pagination li a").eq(i).text(parseInt(tt)+parseInt(5))
								}
							}
						}
						
					}else{
						if(zhi <= max){
							$(".pagination li").removeClass("active")
							$(this).addClass("active");
							$.ajax({
								type:"get",
								url: "H_MusicAdd!zhi",
								data:{count:zhi},
								dataType:"json",
							    async: false,
								success: function(data) {
									$("tbody").empty();
									for(var i = 0; i<data.length;i++){
										var html = '<tr><td>'+data[i].id+'</td><td>'+data[i].music+'</td>'+
							            '<td>'+data[i].name+'</td><td>'+data[i].singer+'</td>'+
							            '<td><a href="update.html?id='+data[i].id+'" class="templatemo-edit-btn">Edit</a></td>'+
							            '<td><a class="templatemo-link dele">Delete<span style="display:none">'+data[i].id+'</span></a></td>'+
							            '</tr>';
										$("tbody").append(html);
									}
									$(".dele").click(function(){
										var id = $($(this).children("span").get(0)).html();
										var tishi = confirm('确实要删除该内容吗?');
										if(tishi){
											$.ajax({
												type:"post",
												url: "H_MusicAdd!delete",
												data:{id:id},
												dataType:"json",
											    async: false,
												success: function(data) {
													alert(data.mess);
													window.location.reload()
												}
											})
										}
									
									})
								}
							})
							
						}
					}
				})
	
			},
		    error: function() {
				alert("网络错误 请重试");
	        }
		});	

$.ajax({
	type:"get",
	url: "H_MusicAdd!zhi",
	data:{count:'1'},
	dataType:"json",
    async: false,
	success: function(data) {
		for(var i = 0; i<data.length;i++){
			var html = '<tr><td>'+data[i].id+'</td><td>'+data[i].music+'</td>'+
            '<td>'+data[i].name+'</td><td>'+data[i].singer+'</td>'+
            '<td><a href="update.html?id='+data[i].id+'" class="templatemo-edit-btn">Edit</a></td>'+
            '<td><a class="templatemo-link dele">Delete<span style="display:none">'+data[i].id+'</span></a></td>'+
            '</tr>';
			$("tbody").append(html);
		}
		$(".dele").click(function(){
			var id = $($(this).children("span").get(0)).html();
			var tishi = confirm('确实要删除该内容吗?');
			if(tishi){
				$.ajax({
					type:"post",
					url: "H_MusicAdd!delete",
					data:{id:id},
					dataType:"json",
				    async: false,
					success: function(data) {
						alert(data.mess);
						window.location.reload()
					}
				})
			}
		})
	}
})

