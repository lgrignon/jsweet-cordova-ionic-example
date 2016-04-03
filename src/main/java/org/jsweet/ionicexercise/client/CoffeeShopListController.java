package org.jsweet.ionicexercise.client;

import static jsweet.dom.Globals.console;

import org.jsweet.ionicexercise.client.model.CoffeeShopDto;

import def.angular_ui_router.ng.ui.IStateService;
import def.angularjs.ng.IScope;
import def.ionic.ionic.popup.IonicPopupService;
import jsweet.lang.Array;
import jsweet.lang.Interface;

@Interface
abstract class CoffeeShopListViewModel extends IScope {
	Array<CoffeeShopDto> coffeeshops;
}

class CoffeeShopListController extends AbstractController {
	private CoffeeShopListViewModel $scope;

	CoffeeShopListController( //
			CoffeeShopListViewModel $scope, //
			IStateService $state, //
			IonicPopupService $ionicPopup) {
		super($state, $ionicPopup);
		this.$scope = $scope;

		console.log("get coffee shops");
		server.<Array<CoffeeShopDto>> get("/coffeeshop/list", null, (Array<CoffeeShopDto> coffeeShops) -> {
			$scope.coffeeshops = coffeeShops;

			updateUI($scope);
		});
	}

}
