package org.jsweet.ionicexercise.client;

import static def.angularjs.Globals.angular;
import static def.jquery.Globals.$;
import static jsweet.dom.Globals.console;
import static jsweet.dom.Globals.document;
import static jsweet.dom.Globals.window;
import static jsweet.util.Globals.function;
import static jsweet.util.Globals.union;

import def.angular_ui_router.ng.ui.IState;
import def.angular_ui_router.ng.ui.IStateProvider;
import def.angular_ui_router.ng.ui.IUrlRouterProvider;
import def.angularjs.ng.IModule;
import def.cordova.Cordova;

public class App {

	public static final String MODULE_NAME = "ionic-exercise";

	public static App instance = new App();

	private Cordova cordova;
	private String platformId;
	public Server server;

	public void initialize() {
		cordova = (Cordova) window.$get("cordova");
		platformId = cordova == null ? "browser" : cordova.platformId;
		console.log("initializing - cordova=" + cordova + " platformId=" + platformId);

		server = Server.instance();
		server.setWebRoot("http://jsweet.org/ionic-exercise-server/api");
		server.setPingPath(null);
		server.addPersistentHeader("Content-Type", "application/json");

		$(document).ready(() -> {
			initializeIonic();
			return null;
		});
	}

	private void initializeIonic() {
		console.log("configuring ionic app");

		String[] importedModules = { "ionic" };
		IModule app = angular.module(MODULE_NAME, importedModules);

		app.config(function((IStateProvider $stateProvider, IUrlRouterProvider $urlRouterProvider) -> {

			$stateProvider.state("app", new IState() {
				{
					url = union("/app");
					Abstract = true;
					templateUrl = union("templates/menu.html");
					controller = union("MenuController");
				}
			});
			
			$stateProvider.state("app.coffeeshops", new IState() {
				{
					url = union("/coffeeshops");
					views = new Views() {
						{
							$set("menuContent", new IState() {
								{
									templateUrl = union("templates/coffeeshops.html");
									$set("controller", "CoffeeShopListController");
								}
							});
						}
					};
				}
			});
			$urlRouterProvider.otherwise("/app/coffeeshops");
		}));

		jsweet.lang.Function controller = function(CoffeeShopListController.class);
		console.log("CoffeeShopListController: ", controller);
		app.controller("CoffeeShopListController", controller);

		controller = function(MenuController.class);
		console.log("MenuController: ", controller);
		app.controller("MenuController", controller);

		console.log("bootstraping app");
		angular.bootstrap(document.body, new String[] { MODULE_NAME });
	}

	public static void main(String[] args) {
		console.log("starting app");

		App.instance.initialize();
	}
}
