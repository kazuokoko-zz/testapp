app = angular.module("admin-app", ["ngRoute"]);
app.config(function($routeProvider) {
	$routeProvider
		.when("/product", {
			templateUrl: "/assets/admin/product/index.html",
			controller: "product-ctrl"
		})
		.when("/authorize", {
			templateUrl: "/assets/admin/authority/index.html",
			controller: "authority-ctrl"
		})
		.when("/unauthorized", {
			templateUrl: "/assets/admin/authority/unauthorized.html",
			controller: "authority-ctrl"
		})
		.otherwise({
			template: "<div class='text-center bg-info' style='line-height: 40px;'>HUNGMVPH12447 - JAVA 6</div>"
		})

})