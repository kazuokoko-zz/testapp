app.controller("authority-ctrl", function($scope, $http, $location) {
	$scope.roles = [];
	$scope.admins = [];
	$scope.authorities = [];

	$scope.initialize = function() {

		$http.get("/rest/roles").then(res => {
			$scope.roles = res.data;
		})
			.catch(err => {
				console.log("Error", err);
			})


		$http.get("/rest/accounts?admin=true").then(res => {
			$scope.admins = res.data;
		})
			.catch(err => {
				console.log("Error", err);
			})



		$http.get("/rest/authorities?admin=true").then(res => {
			$scope.authorities = res.data;
		})
			.catch(err => {
				console.log("Error", err);
				$location.path("/unauthorized");
			})
	}

	$scope.authority_of = function(account, role) {
		if ($scope.authorities) {
			return $scope.authorities.find(au => au.account.username == account.username && au.role.id == role.id);
		}
	}

	$scope.authority_changed = function(account, role) {
		let authority = $scope.authority_of(account, role);
		if (authority) {
			$scope.revoke_authority(authority);
		}
		else {
			authority = { account: account, role: role };
			$scope.grant_authority(authority);
		}
	}

	$scope.revoke_authority = function(authority) {
		$http.delete(`/rest/authorities/${authority.id}`)
			.then(res => {
				let idx= $scope.authorities.findIndex(au => au.id ==authority.id);
				$scope.authorities.splice(index, 1);
				alert("Đã thu hồi quyền");
			})
			.catch(err => {
				alert("Thu hồi quyền thất bại");
				console.log("Error", err);
			})
	}



	$scope.grant_authority = function(authority) {
		$http.post(`/rest/authorities`, authority)
			.then(res => {
				$scope.authorities.push(res.data);
				alert("Đã cấp quyền");
			})
			.catch(err => {
				alert("Cấp quyền thất bại");
				console.log("Error", err);
			})
	}


	$scope.initialize();

 	






})