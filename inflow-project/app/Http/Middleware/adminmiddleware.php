<?php

namespace App\Http\Middleware;

use Closure;
use Response;

class adminmiddleware
{
    /**
     * Handle an incoming request.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \Closure  $next
     * @return mixed
     */
    public function handle($request, Closure $next)
    {
    if ($request->user() && $request->user()->RoleID != 2)
        {
            return redirect('/unathorized');
       
        }
    return $next($request);
    }
}
