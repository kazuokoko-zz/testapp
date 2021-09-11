const app = angular.module("shopping-cart-app", []);

app.controller("shopping-cart-ctrl", function($scope, $http) {
	//alert("angular")	

	$scope.cart = {
		items: [],
		add(id) {
			var item = this.items.find(item => item.id == id);
			if (item) {
				item.qty++;
				this.saveToLocalStorage();
			} else {
				$http.get(`/rest/product/${id}`)
					.then(resp => {
						resp.data.qty = 1;
						this.items.push(resp.data);
						this.saveToLocalStorage();
					})
			}
			//			alert(id);
		},
		remove(id) {
			var index = this.items.findIndex(item => item.id == id);
			this.items.splice(index, 1);
			this.saveToLocalStorage();
		},
		clear() {
			this.items = [];
			this.saveToLocalStorage();
		},
		amt_of(id) { },
		get count() {
			return this.items
				.map(item => item.qty)
				.reduce((total, qty) => total += qty, 0);
		},
		get amount() {
			return this.items
				.map(item => item.qty * item.price)
				.reduce((total, qty) => total += qty, 0);
		},
		saveToLocalStorage() {
			var json = JSON.stringify(angular.copy(this.items));
			localStorage.setItem("cart", json);
		}
		,
		loadFromLocalStorage() {
			var json = localStorage.getItem("cart");
			this.items = json ? JSON.parse(json) : [];
		}


	};

	$scope.cart.loadFromLocalStorage();

	$scope.order = {
		createDate: new Date(),
		address: "",
		account: { username: $("#username").text() },
		get orderDetails() {
			return $scope.cart.items.map(
				item => {
					return {
						product: { id: item.id },
						price: item.price,
						quantity: item.qty
					}
				}
			)
		},
		purchase() {
			var order = angular.copy(this);

			if (confirm("Xác nhận đặt hàng")) {
				$http.post("/rest/orders", order)
					.then(res => {
						alert("Đặt hàng thành công!");
						$scope.cart.clear();
						location.href = "/order/detail/" + res.data.id;
					})
					.catch(err => {
						alert("đặt hàng lỗi");
						console.log(err);
					})
			}
		}

	}



})