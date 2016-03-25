package fr.isep.ionicexercise.client;

import static jsweet.dom.Globals.console;
import static jsweet.util.Globals.object;

import def.angular_ui_router.ng.ui.IStateService;
import def.angularjs.ng.IScope;
import def.ionic.ionic.popup.IonicPopupAlertOptions;
import def.ionic.ionic.popup.IonicPopupService;

abstract class AbstractController {

	protected final IonicPopupService $ionicPopup;
	protected final IStateService $state;

	protected final Server server;
	protected final App app;

	public AbstractController( //
			IStateService $state, //
			IonicPopupService $ionicPopup) {
		this.$state = $state;
		this.$ionicPopup = $ionicPopup;

		this.app = App.instance;
		this.server = app.server;

		console.log("location is: ", $state.current.name);
	}

	protected void updateUI(IScope $scope) {
		Object phase = $scope.$$phase;
		if (phase == null || phase.toString() != "$apply" && phase.toString() != "$digest") {
			$scope.$digest();
		}
	}

	protected void alertTechnicalError() {
		$ionicPopup.alert(new IonicPopupAlertOptions() {
			{
				title = "Erreur";
				template = "Une erreur est survenue";
			}
		});
	}

	protected Object onError(Object error) {
		if (object(error).$get("label") != null) {
			$ionicPopup.alert(new IonicPopupAlertOptions() {
				{
					title = "Erreur";
					template = (String) object(error).$get("label");
				}
			});
		} else {
			alertTechnicalError();
		}

		return null;
	}
}