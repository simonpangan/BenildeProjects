<?php

namespace App\Http\Middleware;

use Closure;
use Response;

class studentmiddleware
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
        if ($request->user() && $request->user()->RoleID != 1)
        {
        
            return redirect('/unathorized');
        }
        return $next($request);
    }
}
