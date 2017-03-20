$(document).ready(function() {
	/* form init validation */
	$("#password").val("");
	$("#newPassword").val("");
	var oldUsername = $("#oldUsername").val();
	var form = $("#userForm");

	// 提交当前活动的form，多个tab时候需要知道当前的tab
	$(":submit", "#buttons").on("click", function(e) {
		form.submit();
	});

	// JQuery validate 插件看文档
	// form validation
	form.validate({
		rules : {
			username : {
				remote : "/system/user/unique?oldUsername=" + oldUsername
			},
			mobile : {
				mobileCN : true
			},
			confirmPassword : {
				equalTo : "#password"
			}
		},
		messages : {
			username : {
				remote : "该用户名已存在!"
			},
			confirmPassword : {
				equalTo : "输入与上面相同的密码"
			},
			mobile : {
				remote : "只能输入纯数字的手机号"
			}
		}
	});
});