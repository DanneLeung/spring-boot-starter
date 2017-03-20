$(document)
	.ready(
		function () {
			var table = $('table#table')
				.DataTable(
					$
					.extend(
						opts, {
							ajax: '/system/user/datatable',
							order: [
								[2, 'asc']
							],
							columns: [{
									data: 'id',
									sortable: false,
									defaultContent: '',
									'class': 'text-center',
									render: function (
										data,
										type,
										row,
										meta) {
										return '<input type="checkbox" name="ids" value="' +
											data +
											'"/>'
									}
								},
								{
									data: 'username'
								},
								{
									data: 'email'
								},
								{
									data: 'fullname'
								},
								{
									data: "roles",
									defaultContent: '',
									'class': 'text-center',
									render: function (
										data,
										type,
										row,
										meta) {
										var result = [];
										if (data) {
											for (var i in data) {
												result
													.push(data[i].name)
											}
										}
										return result ? result
											.join(', ') :
											'';
									}
								},
								{
									data: 'lastModifiedDate',
									'class': 'text-center',
									defaultContent: ''
								},
								{
									data: "enabled",
									defaultContent: '',
									'class': 'text-center',
									render: function (
										data,
										type,
										row,
										meta) {
										var result = '<a class="btn btn-sm btn-default enable" href="javascript:;">';
										if (data) {
											result += '<i title="激活/禁用" class="fa fa-check-square-o"/>';
										} else {
											result += '<i title="激活/禁用" class="fa fa-square-o"/>';
										}
										result += '</a>';
										return result;
									}
								},
								{
									data: "",
									defaultContent: '',
									sortable: false,
									'class': 'text-center',
									render: function (
										data,
										type,
										row,
										meta) {
										return '<div class="btn-group">' +
											'<a class="btn btn-default btn-sm" title="修改" href="/system/user/edit/' +
											row.id +
											'"><i class="fa fa-edit"></i></a>' +
											'<a class="btn btn-default btn-sm del" title="删除" href="#"><i class="fa fa-trash-o"></i></a>' +
											'</div>' +
											'&nbsp;&nbsp;' +
											'<div class="btn-group">' +
											'<a class="btn btn-default btn-sm resetpwd" title="重置密码" href="javascript:;"><i class="fa fa-refresh"></i></a>' +
											'</div>';
									}
								}
							]
						}))
				.on('draw.dt', function () {
					$("#tableWrapper").fadeIn();
					$('#tableWrapper input:checkbox').iCheck({
						checkboxClass: 'icheckbox_square-blue',
						radioClass: 'iradio_square-blue',
						increaseArea: '20%' // optional
					});
				});
			table.on('click', '.del', function () {
				var id = table.row($(this).parents('tr')).data().id;
				$("#delForm #ids").val(id);
				if (id) {
					bootbox.confirm("确定要删除数据吗?", function (result) {
						if (result) {
							$("#delForm").submit();
						}
					});
				}
			});
			table.on('click', '.enable', function () {
				var that = this;
				var data = table.row($(this).parents('tr')).data();
				var id = data.id;
				var enabled = data.enabled;
				$.get("/system/user/enable", {
					enabled: !enabled,
					ids: id
				}, function (res) {
					if (res) {
						data.enabled = !enabled;
						$(that).find("i").removeClass(
							"fa-" + (enabled ? "check-" : "") +
							"square-o").addClass(
							"fa-" + (!enabled ? "check-" : "") +
							"square-o");
					}
				});
			});
			table.on('click', '.resetpwd', function () {
				var that = this;
				var data = table.row($(this).parents('tr')).data();
				var id = data.id;
				bootbox.confirm("确定要重置该用户密码吗?", function (e) {
					if (e) {
						$.get("/system/user/resetpwd", {
							ids: id
						}, function (res) {
							if (res) {
								bootbox.alert("密码重置成功!");
							}
						});
					}
				});
			});

			$(".btn.delAll").on("click", function (e) {
				var ids = [];
				$('#table>tbody input:checked').each(function (i, item) {
					ids.push($(item).val());
				});
				$("#delForm #ids").val(ids.join(","));
				if (ids.length > 0) {
					bootbox.confirm("确定要删除选中的数据吗?", function (result) {
						if (result) {
							$("#delForm").submit();
						}
					});
				} else {
					bootbox.alert("请选择要删除的数据.");
				}
			});
		});