@extends('layouts.main')
@section('headcontent')

<link rel="stylesheet" type="text/css" href="{{ asset('css/login.css') }}">


@endsection
@section('content')

<div class="logo">
	<img src="{{ asset('img/benilde.jpg') }}">
</div>
<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
<div class="container">
		<div class="row">
		    <div class="col">
			    <div class="md-form mb-3">
			    	<form method="POST" action="{{ route('login') }}"class="border border-light p-5">
					    <p class="h2 mb-2 text-center">Log in</p>
                        <p class="h5 mb-4 text-center">To Continue to Inflow</p>
 
                            @csrf

                        <input type="email" id="email"
                         class="form-control mb-4 @error('email') is-invalid @enderror" 
                         placeholder="E-mail"     name="email" value="{{ old('email') }}"
                          required autocomplete="email" autofocus>

                         @error('email')
                             <span class="invalid-feedback" role="alert">
                                 <strong>{{ $message }}</strong>
                             </span>
                         @enderror




                        <input type="password" id="password
                        
                        " class="form-control mb-4 @error('password') is-invalid @enderror"
                        name="password" required autocomplete="current-password" placeholder="Password">
                             
                        @error('password')
                            <span class="invalid-feedback" role="alert">
                                <strong>{{ $message }}</strong>
                            </span>
                        @enderror


					    <button class="btn btn-outline-success btn-block my-4" type="submit">Log In</button>
					</form> 
	        	</div>
		    </div>
		    <div class="col">
		    	<div class="md-form">
		    <img src="{{ asset('img/csb.jpg') }}" alt="Nature" class="responsive">
	    </div>
	 </div>
	</div>
</div>
@endsection
