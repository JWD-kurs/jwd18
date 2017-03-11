var wafepaApp = angular.module('wafepaApp', ['ngRoute']);

wafepaApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl : '/static/app/html/partial/proba.html'
    })
    .when('/books', {
        templateUrl : '/static/app/html/partial/books.html'
    })
    .when('/activities', {
        templateUrl : '/static/app/html/partial/activities.html'
    })
    .when('/activity/:id', {
        templateUrl : '/static/app/html/partial/activity.html'
    })
    .otherwise({
        redirectTo: '/'
    });
}]);

wafepaApp.controller('booksCtrl', function($scope, $http, $routeParams, $location){
    var config = {params:{}};

    var ucitajAutore = function () {
        $http.get('/api/authors')
            .then(function (resp) {
                $scope.authors = resp.data;
            });
    }

    var ucitajKnjige = function () {
        $http.get('/api/books',config)
            .then(function (resp) {
               $scope.books = resp.data; 
            },function (resp) {
                console.log('error!');
            });
    }

    ucitajAutore();
    ucitajKnjige();

    $scope.prepAuthor = function (author) {
        return author.firstName + ' ' +author.lastName;
    }

    $scope.save = function () {
        console.log($scope.book);
        $http.post('/api/books',$scope.book)
            .then(function () {
                ucitajKnjige();
            });
    }

    $scope.postavi = function (book) {
        $scope.book = angular.copy(book);
    }

    $scope.filtriraj = function () {
        if($scope.priceFrom){
            config.params.priceFrom = $scope.priceFrom;
        }
        if($scope.priceTo){
            config.params.priceTo = $scope.priceTo;
        }
        ucitajKnjige();
    }
});

wafepaApp.controller('activityCtrl', function($scope, $http, $routeParams, $location){
    console.log($routeParams.id);
    var ucitajAktivnosti = function(){
        var activitiesPromise = $http.get('/api/activities/'+$routeParams.id);
        activitiesPromise.then(function (resp, status) {
            //console.log(resp.data);
            $scope.activity = resp.data;
        },function (resp, status){            
            console.log('error');
            console.log(status);
        });
    }
    ucitajAktivnosti();

    $scope.save = function(){
        $http.put('/api/activities/'+$scope.activity.id,$scope.activity).then(function () {
            $location.path('activities');
        });        
    }

});

wafepaApp.controller('activitiesCtrl', function($scope, $http, $location){
    $scope.currentPage=0;
    $scope.totalPages;
    $scope.changePage = function (i) {
        if(($scope.currentPage>0&&i<0)||(i>0&&$scope.currentPage<$scope.totalPages)){
            $scope.currentPage += i;
            $scope.ucitajAktivnosti();
        }
    }

    $scope.filtriraj = function () {
        $scope.currentPage = 0;
        $scope.ucitajAktivnosti();        
    }

    $scope.ucitajAktivnosti = function(){
        var config = {params:{}}
        if($scope.name){
            config.params.name=$scope.name;
        }
        if($scope.currentPage){
            config.params.page=$scope.currentPage;            
        }
        var activitiesPromise = $http
                    .get('/api/activities', config);
        activitiesPromise.then(function (resp, status) {
            //console.log(resp.data);
            $scope.activities = resp.data;
            $scope.totalPages = Number(resp.headers().totalpages);
            $scope.name = '';
        },function (resp, status){            
            console.log('error');
            console.log(status);
        });
    }

    $scope.ucitajAktivnosti();

    $scope.delete = function (id) {
        console.log('delete/'+id);
        $http.delete('/api/activities/'+id).then(function () {
            $scope.ucitajAktivnosti();
        });
    }

    $scope.save = function(){
        console.log('newActivity:',$scope.newActivity);
        if($scope.newActivity.id){
            $http.put('/api/activities/'+$scope.newActivity.id,$scope.newActivity).then(function () {
                $scope.ucitajAktivnosti();
            });        
        }else{
            $http.post('/api/activities/',$scope.newActivity).then(function () {
                $scope.ucitajAktivnosti();
            });
        }
    }

    $scope.setForUpdate = function (activity) {
        $scope.newActivity = angular.copy(activity);
    }

    $scope.gotoActivity = function (id) {
        $location.path('activity/'+id);
    }

});
