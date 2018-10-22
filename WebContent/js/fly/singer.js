$(function() {

	// 文章加载完成后 进行请求

	function getParamer(paramer) {
		
		var url = window.location.href.split("?")[1]; /* 获取url里"?"后面的值 */
		if (url == null) {
			return "";
		}
		if (url.indexOf("&") > 0) { /* 判断是否是一个参数还是多个参数 */
			urlParamArry = url.split("&"); /* 分开每个参数，并放到数组里 */
			for (var i = 0; i < urlParamArry.length; i++) {
				var paramerName = urlParamArry[i].split("="); /* 把每个参数名和值分开，并放到数组里 */
				if (paramer == paramerName[0]) { /* 匹配输入的参数和数组循环出来的参数是否一样 */
					return paramerName[1]; /* 返回想要的参数值 */
				}
			}
		} else { /* 判断只有个参数 */
			var paramerValue = url.split("=")[1];
			return paramerValue;
		}
	}

	var id = getParamer(id);
	if (id =="") {
		id = 1;
	}
	// 按照id选择对应的左侧分类
	$("#" + id).addClass("active");

	if (id != "") {
		// 发送AJAX请求

		$.ajax({
			cache : false,

			type : "GET",

			dataType : "json",

			data : {
				id : id
			},

			url : "loadSinger",

			async : true,

			error : function(request) {
				alert("发送请求失败！");
			},
			success : function(data) {
				/**向着页面输出*/
				for (var i = 0; i<data.length;i++) {
					
					var html = "<div class='col-xs-6 col-sm-4 col-md-3 col-lg-2'>"+
                         "<div class='item'>"+
                            "<div class='pos-rlt'>"+
                              "<div class='item-overlay opacity r r-2x bg-black'>"+
                                "<div class='center text-center m-t-n'>"+
                                  "<a href='singermessage.html?id="+data[i].id+"'><i class='fa fa-play-circle i-2x'></i></a>"+
                                "</div>"+
                              "</div>"+
                              "<a href='track-detail.html'><img src='../flymusicImg/singerImg/small/"+data[i].smallImg+"' alt='' class='r r-2x img-full'></a>"+
                            "</div>"+
                            "<div class='padder-v'>"+
                              "<a href='track-detail.html' data-bjax data-target='#bjax-target' data-el='#bjax-el' data-replace='true' class='text-ellipsis'>"+data[i].name+"</a>"+
                              "<a href='track-detail.html' data-bjax data-target='#bjax-target' data-el='#bjax-el' data-replace='true' class='text-ellipsis text-xs text-muted'>"+data[i].country+"</a>"+
                            "</div>"+
                          "</div>"+
                        "</div>";
					
					$("#singer").append(html);
				}
				
				
			}

		})

	}

})
