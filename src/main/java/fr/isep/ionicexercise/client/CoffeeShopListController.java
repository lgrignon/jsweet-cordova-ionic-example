package fr.isep.ionicexercise.client;

import static jsweet.util.Globals.object;

import def.angular_translate.ng.translate.ITranslateService;
import def.angular_ui_router.ng.ui.IStateService;
import def.angularjs.ng.IScope;
import def.es6_promise.Promise;
import def.ionic.ionic.popup.IonicPopupConfirmOptions;
import def.ionic.ionic.popup.IonicPopupService;
import def.ionic.ionic.tabs.IonicTabsDelegate;
import fr.isep.ionicexercise.client.model.ServiceLocation;
import fr.isep.ionicexercise.client.model.care.CareDto;
import jsweet.lang.Array;
import jsweet.lang.Interface;

@Interface
abstract class CoffeeShopListViewModel extends IScope {
	Array<CareDto> cares;

	Runnable onInstituteLocationClicked;
	Runnable onHomeLocationClicked;

	ServiceLocation location;
}

class CoffeeShopListController extends AbstractController {
	private CareListViewModel $scope;
	private CareService careService;
	private Basket userBasket;
	private BasketService basketService;
	private IonicTabsDelegate $ionicTabsDelegate;

	CoffeeShopListController( //
			CareListViewModel $scope, //
			ITranslateService $translate, //
			IStateService $state, //
			IonicPopupService $ionicPopup, //
			IonicTabsDelegate $ionicTabsDelegate, //
			AuthenticationService authenticationService, //
			UserSession userSession, //
			CareService careService, //
			BasketService basketService) {
		super($translate, $state, $ionicPopup, userSession, authenticationService);
		this.$scope = $scope;
		this.$ionicTabsDelegate = $ionicTabsDelegate;
		public Promise<CareDto[]> getCares(String careLocation) {
			logger.info("careLocation=" + careLocation);
			return server.post(new RequestParameters<CareListDto>() {
				{
					path = "/api/cares/list";
					data = object(new CareQueryParameters() {
						{
							location = careLocation;
						}
					});
				}
			}, null).thenOnFulfilledFunction((CareListDto model) -> {
				logger.info("model=", model);
				return model.cares;
			});
		}
	}

	public void onHomeLocationSelected() {
		logger.info("home location selected");
		$scope.location = ServiceLocation.HOME;
		onLocationChangeRequested();
	}

	public void onInstituteLocationSelected() {
		logger.info("institute location selected");
		$scope.location = ServiceLocation.INSTITUTE;
		onLocationChangeRequested();
	}

	private void onLocationChangeRequested() {
		$scope.cares.splice(0, $scope.cares.length);

		if (userBasket == null) {
			// view not loaded, do not load cares
			return;
		}

		$ionicTabsDelegate.select($scope.location.ordinal());
		if (userBasket.location != $scope.location && !userBasket.isEmpty()) {

			$ionicPopup.confirm(new IonicPopupConfirmOptions() {
				{
					title = $translate.instant("WARNING");
					template = $translate.instant("LOCATION_CHANGED_BASKET_ERASED");
					okText = $translate.instant("OK");
					cancelText = $translate.instant("CANCEL");
				}
			}).thenSuccessCallbackFunction((Boolean accepted) -> {
				userBasket.selectedCareIds = new Array<String>();
				changeLocation();

				return null;
			});

		} else {
			changeLocation();
		}

	}

	private void changeLocation() {
		userBasket.location = $scope.location;
		basketService.saveBasket(userSession.getLoggedUserId(), userBasket).catchOnRejectedFunction(this::onError);

		this.careService.getCares($scope.location.name()).thenOnFulfilledFunction((CareDto[] cares) -> {
			logger.info("cares", cares);
			for (CareDto care : cares) {
				$scope.cares.push(care);
			}

			this.updateUI($scope);

			return null;
		}).catchOnRejectedFunction(this::onError);
	}
}
