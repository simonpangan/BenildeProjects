<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/


        Route::get('/unathorized', function () {
          return view('unathorized');
        });
        Route::get('/test', function () {
          return view('testing');
        });

        Auth::routes();

        Route::get('/home', 'HomeController@index')->name('home');

        Route::middleware(['auth'])->group(function(){

                      //--for admin
                Route::group(['middleware' => 'App\Http\Middleware\adminmiddleware'], function()
                  {
                Route::get('/adminindex', function () {
                    return view('admin.index');
                });
                Route::get('/schoolcourses',"admincontroller@viewschoolcourses");
                Route::get('/schoolcourses/{id}/subject', 'admincontroller@showsubject');
              Route::post('/formsubmit',"admincontroller@formSubmit");
                Route::get('/delete',"admincontroller@delete");
                Route::post('/update',"admincontroller@update");
                Route::get('/schoolcourses/{id}/subject/flowchart',"admincontroller@showcourseflowchart");
                Route::get('/schoolcourses/{id}/subject/{name}',"admincontroller@showsubjectinfo")->where('name','^(?!search).+');
            
                  });


                  //forstudent
                Route::group(['middleware' => 'App\Http\Middleware\studentmiddleware'], function()
                {

                Route::get('/studenthome','studentcontroller@studentHome');

                });


        });
      

   
