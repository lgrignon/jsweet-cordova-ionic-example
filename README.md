# Ionic exercise: rate your coffee shops [CLIENT]

This exercise shows a basic JSweet + Ionic + Cordova example which communicates with a [JAX-RS server api](https://github.com/lgrignon/jsweet-jaxrs-server)

## Pre-requisits

* Ensure java version is 8 using `java -version`
* Ensure maven command line (mvn) is in PATH by typing `mvn -version`, if command not found, download apache maven 3.3.x and include its bin folder in PATH, then try again
* Ensure node packet manager (npm) is in PATH by typing `npm -v`, if command not found, download and install NodeJS, then try again
* Install Cordova 5.3 if not done yet: `npm install cordova@5.3.3 -g`, -g switch means install globally
* Install Ionic 1.7 if not done yet: `npm install ionic@1.7.13 -g`

## Compiling

Compile JSweet using
```
mvn clean generate-sources
```

JavaScript files are generated in `www/js/app/`, check that they are up to date

## Running

Just type (change browser if you need anything else)
```
ionic serve -w chrome
```

## Exercise steps

### 1. Run the app successfully without modifications
### 2. Enable the Add button under the coffee shop list
### 3. Respond to click on this Add button
Add in CoffeeShopListViewModel, the member Runnable onAddClicked; which will respond to click
In CoffeeShopListController, assign this member in the given $scope and try to handle as following:
$scope.onAddClicked = () -> {
	console.log("add button clicked");
};
### 4. Add a create coffee shop view and its controller in App's ionic configuration, with the routing
### 5. Creates the html file corresponding to your view
Copy the coffee shop list file and replace view content with a form using inline labels (see [ionic components](http://ionicframework.com/docs/components/#forms-inline-labels))
Post to the following server's api method to create your coffee shop:
server.post("/coffeeshop/add", $map("name", "test", "address", "test")) // example to add a coffee shop named "test", at address "test address"

### 6. Save the coffee shop with an add button 
Use a runnable which respond to click and call the server using this.server 

### 7. Add a view coffee shop detail view, accessible by clicking on a coffee shop item in the main coffee shop list
Access the coffee shop details through server.get("/coffeeshop/getDetails", { id: '1' }, details -> { /* ... */ console.log(details); })

### 8. Add, on the detail consultation view, a rate button, using the following api's method:
server.post("/coffeeshop/rate", $map("id", 1, "rate", 4)) // example to rate coffee shop at id 1 with a 4 grade