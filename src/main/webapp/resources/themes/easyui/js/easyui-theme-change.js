var changeThemeFun = function(themeName) {
	var $easyuiTheme = $('#easyui_theme_id');
	var url = $easyuiTheme.attr('href');
	var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName
			+ '/easyui.css';
	$easyuiTheme.attr('href', href);

	var $iframe = $('iframe');

	// 判断该页面是iframe框架页面
	if ($iframe.length > 0) {
		for (var i = 0; i < $iframe.length; i++) {
			var ifr = $iframe[i];
			$(ifr).contents().find('#easyuiTheme').attr('href', href);
		}
	}

	// 设置cookie的持续时间是7天，跨整个站
	$.cookie('easyuiThemeName', themeName, {
		expires : 7,
		path : '/'
	});
};

// 如果cookie中有值，取值用之
if ($.cookie('easyuiThemeName')) {
	changeThemeFun($.cookie('easyuiThemeName'));
}
