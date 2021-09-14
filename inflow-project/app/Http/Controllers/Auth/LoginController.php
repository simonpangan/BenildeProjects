<?php

namespace App\Http\Controllers\Auth;

use App\Http\Controllers\Controller;
use App\Providers\RouteServiceProvider;
use Illuminate\Foundation\Auth\AuthenticatesUsers;
use Illuminate\Support\Facades\Auth;
use Illuminate\Http\Request;
use Datetime;
use DB;
use DateTimeZone;

class LoginController extends Controller
{
    /*
    |--------------------------------------------------------------------------
    | Login Controller
    |--------------------------------------------------------------------------
    |
    | This controller handles authenticating users for the application and
    | redirecting them to your home screen. The controller uses a trait
    | to conveniently provide its functionality to your applications.
    |
    */
    use AuthenticatesUsers;


        /*
            public function logout(Request $request)
        {
            $this->doLogout($request);

            return redirect()->route('/adminindex');
        }
    */
    
    protected function logout(Request $request)
    {
        DB::table('table_logs')->insert(
            ['AccountID' => Auth::id(), 'logtype' =>  "Logout into the system",
            'LogTime' => new DateTime("now", new DateTimeZone('Asia/Singapore'))
        ]);   


        $this->guard()->logout();

        $request->session()->flush();

        $request->session()->regenerate();

        return redirect('/login');
    }

  

    /**
     * Where to redirect users after login.
     *
     * @var string
     */
  

    /**
     * Create a new controller instance.
     *
     * @return void
     */
    public function __construct()
    {
        $this->middleware('guest')->except('logout');
    }

    public function redirectTo(){
        
        // User role
        $role = Auth::user()->RoleID; 

        DB::table('table_logs')->insert(
            ['AccountID' => Auth::id(), 'logtype' =>  "Login into the system",
            'LogTime' => new DateTime("now", new DateTimeZone('Asia/Singapore'))
        ]);   
        // Check user role
        switch ($role) {
            case 1:
                
                    return '/studenthome';
                break;
            case 2:
                    return '/adminindex';
                break; 
            default:
                    return '/login'; 
                break;
        }
    }
            

}
