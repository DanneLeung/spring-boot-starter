require
		.config({
			baseUrl : "/",
			paths : {
				"jquery" : themeRoot + "/assets/plugins/jquery-1.10.2.min",
				"jquery-ui" : themeRoot
						+ "/assets/plugins/jquery-ui/jquery-ui-1.10.3.custom.min",
				"jquery-migrate" : themeRoot
						+ "/assets/plugins/jquery-migrate-1.2.1.min",
				"bootstrap" : themeRoot
						+ "/assets/plugins/bootstrap/js/bootstrap.min",
				"bootstrap-hover-dropdown" : themeRoot
						+ "/assets/plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min",
				"datatable" : themeRoot
						+ "/assets/plugins/data-tables/js/jquery.dataTables",
				"datatable-bootstrap" : themeRoot
						+ "/assets/plugins/data-tables/js/dataTables.bootstrap",
				"bootbox" : themeRoot + "/assets/plugins/bootbox/bootbox.min",
				"slimscroll" : themeRoot
						+ "/assets/plugins/jquery-slimscroll/jquery.slimscroll.min",
				"blockui" : themeRoot + "/assets/plugins/jquery.blockui.min",
				"cookie" : themeRoot + "/assets/plugins/jquery.cookie.min",
				"uniform" : themeRoot
						+ "/assets/plugins/uniform/jquery.uniform.min",
				"validate" : themeRoot
						+ "/assets/plugins/jquery-validation/dist/jquery.validate.min",
				"validate-additional" : themeRoot
						+ "/assets/plugins/jquery-validation/dist/additional-methods.min",
				"validate-messages" : themeRoot
						+ "/assets/plugins/jquery-validation/dist/jquery.validate.messages_zh",
				"backstretch" : themeRoot
						+ "/assets/plugins/backstretch/jquery.backstretch.min",
				"gritter" : themeRoot
						+ "/assets/plugins/gritter/js/jquery.gritter",
				"jquery-flot" : themeRoot + "/assets/plugins/flot/jquery.flot",
				"jquery-flot-resize" : themeRoot
						+ "/assets/plugins/flot/jquery.flot.resize",
				"select2" : themeRoot + "/assets/plugins/select2/select2.min",
				"toastr" : themeRoot
						+ "/assets/plugins/bootstrap-toastr/toastr.min",
				"domReady" : themeRoot + "/assets/scripts/domReady",
				"ckeditor" : themeRoot + "/assets/plugins/ckeditor/ckeditor",
				"moment" : themeRoot
						+ "/assets/plugins/bootstrap-daterangepicker/moment.min",
				"datepicker" : themeRoot
						+ "/assets/plugins/bootstrap-datepicker/js/bootstrap-datepicker",
				"daterangepicker" : themeRoot
						+ "/assets/plugins/bootstrap-daterangepicker/daterangepicker",
				"datetimepicker" : themeRoot
						+ "/assets/plugins/bootstrap-datetimepicker/js/bootstrap-datetimepicker",
				"timepicker" : themeRoot
						+ "/assets/plugins/bootstrap-timepicker/js/bootstrap-timepicker",
				"clockface" : themeRoot
						+ "/assets/plugins/clockface/js/clockface",
				"bootstrap-colorpicker" : themeRoot
						+ "/assets/plugins/bootstrap-colorpicker/js/bootstrap-colorpicker",
				"validate-setup" : themeRoot
						+ "/assets/scripts/setup_validation",
				"angular" : ctx + "/html/js/lib/angular",
				"angular-route" : ctx + "/html/js/lib/angular-route",
				"angular-ui-route" : ctx + "/html/js/lib/angular-ui-router",
				"angular-ui-bootstrap" : ctx
						+ "/html/js/lib/ui-bootstrap-tpls-0.13.4.min",
				"angular-animate" : ctx + "/html/js/lib/angular-animate",
				"angular-cookies" : ctx + "/html/js/lib/angular-cookies",
				"Global" : themeRoot + "/assets/scripts/global",
				"App" : themeRoot + "/assets/scripts/app"
			},
			shim : {
				"jquery-ui" : [ "jquery" ],
				"jquery-migrate" : [ "jquery" ],
				"bootstrap" : [ "jquery" ],
				"bootstrap-hover-dropdown" : [ "bootstrap" ],
				"datatable" : [ "jquery" ],
				"datatable-bootstrap" : [ "bootstrap" ],
				"moment" : [ "bootstrap" ],
				"datepicker" : [ "bootstrap" ],
				"daterangepicker" : [ "bootstrap", "moment" ],
				"datetimepicker" : [ "bootstrap" ],
				"timepicker" : [ "bootstrap" ],
				"bootbox" : [ "bootstrap" ],
				"slimscroll" : [ "jquery" ],
				"blockui" : [ "jquery" ],
				"cookie" : [ "jquery" ],
				"uniform" : [ "jquery" ],
				"validate" : [ "jquery" ],
				"validate-additional" : [ "jquery", "validate" ],
				"validate-messages" : [ "jquery", "validate" ],
				"backstretch" : [ "jquery" ],
				"gritter" : [ "jquery" ],
				"flot" : [ "jquery" ],
				"flot-resize" : [ "jquery" ],
				"select2" : [ "jquery" ],
				"toastr" : [ "jquery" ],
				"validate-setup" : [ "jquery", "validate" ],
				"Global" : [ "jquery" ],
				"App" : [ "jquery", "bootstrap" ],
				"angular" : {
					exports : 'angular'
				},
				"angular-route" : {
					deps : [ "angular" ]
				},
				"angular-ui-route" : {
					deps : [ "angular" ]
				},
				"angular-ui-bootstrap" : {
					deps : [ "angular" ]
				},
				"angular-animate" : {
					deps : [ "angular" ]
				},
				"angular-cookies" : {
					deps : [ "angular" ]
				}
			}
		});
