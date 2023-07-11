var app = angular.module('myApp', ['ui.bootstrap']);
app.controller('myCtrl', function($scope) {
  $scope.customers = [{
    "Name": "Alfreds Futterkiste",
    "City": "In Progress",
    "Country": "Link"
  }, {
    "Name": "Ana Trujillo Emparedados y helados",
    "City": "In Progress",
    "Country": "Link"
  }, {
    "Name": "Antonio Moreno Taquería",
    "City": "Completed.",
    "Country": "Link"
  }, {
    "Name": "Around the Horn",
    "City": "Completed",
    "Country": "Link"
  }, {
    "Name": "B's Beverages",
    "City": "Completed",
    "Country": "Link"
  }, {
    "Name": "Berglunds snabbköp",
    "City": "Completed",
    "Country": "Link"
  }, {
    "Name": "Blauer See Delikatessen",
    "City": "Completed",
    "Country": "Link"
  }, {
    "Name": "Blondel père et fils",
    "City": "In Progress",
    "Country": "Link"
  }, {
    "Name": "Bólido Comidas preparadas",
    "City": "In Progress",
    "Country": "Spain"
  }, {
    "Name": "Bon app'",
    "City": "In Progress",
    "Country": "Link"
  }, {
    "Name": "Bottom-Dollar Marketse",
    "City": "In Progress",
    "Country": "Link"
  }, {
    "Name": "Cactus Comidas para llevar",
    "City": "In Progress",
    "Country": "Link"
  }, {
    "Name": "Centro comercial Moctezuma",
    "City": "México D.F.",
    "Country": "Link"
  }, {
    "Name": "Chop-suey Chinese",
    "City": "Completed",
    "Country": "Link"
  }, {
    "Name": "Comércio Mineiro",
    "City": "In Progress",
    "Country": "Link"
  }],
  $scope.people=[],
  $scope.currentPage = 1,
  $scope.numPerPage = 5,
  $scope.maxSize = 5;
  
  
  
  $scope.numPages = function () {
    return Math.ceil($scope.customers.length / $scope.numPerPage);
  };
  
  $scope.$watch('currentPage + numPerPage', function() {
    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
    , end = begin + $scope.numPerPage;
    
    $scope.people = $scope.customers.slice(begin, end);
  });
  
  
});