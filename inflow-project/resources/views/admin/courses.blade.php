@extends('layouts.main')


@section('content')


    @include('layouts.header')
    
	<br>
	<br>
	<br>
	<br>
	<div class="container">
    <h3>School of {{$schoolname}}</h3>
		<section class="visual-list-container">

        @php
           $counter = 0; 

        @endphp
            @for($i = 0; $i < 5; $i++)
			<div class="row">
               
			  <div class="col-sm">
                @if($counter != count($schoolcourses))
			  	<div class="hovereffect">
			  		<figure><img class="img-responsive" src="{{ asset('img/sda/'. $schoolcourses[$counter]->coursename .'.jpg') }}" style="width:100%"></figure>
			  		<div>
                      <a class="info" href="/schoolcourses/{{$schoolcourses[$counter]->CourseID}}/subject">{{$schoolcourses[$counter]->coursename}}</a>
                        @php
                            $counter++;
                        @endphp
			  		</div>
                  </div>
                  @endif
              </div>
          
             
			  <div class="col-sm">
                @if($counter != count($schoolcourses))
			  	<div class="hovereffect">
                    <figure><img class="img-responsive" src="{{ asset('img/sda/'. $schoolcourses[$counter]->coursename .'.jpg') }}" style="width:100%"></figure>
			  		<div>
                        <a class="info" href="/schoolcourses/{{$schoolcourses[$counter]->CourseID}}/subject">{{$schoolcourses[$counter]->coursename}}</a>
                        @php
                            $counter++;
                        @endphp
			  		</div>
                  </div>
                  @endif
              </div>
            
              <div class="col-sm">
                @if($counter != count($schoolcourses))
			  	<div class="hovereffect">
                    <figure><img class="img-responsive" src="{{ asset('img/sda/'. $schoolcourses[$counter]->coursename .'.jpg') }}" style="width:100%"></figure>
			  		<div>
                        <a class="info" href="/schoolcourses/{{$schoolcourses[$counter]->CourseID}}/subject">{{$schoolcourses[$counter]->coursename}}</a>
                        @php
                            $counter++;
                        @endphp
			  		</div>
                  </div>
                  @endif
              </div>
        
              
         
            </div>
              @endfor
              <br/>
              <br/>
              <a href="{{url('adminindex')}}"
              class="btn btn-outline-success">Go back </a>
		</section>
    </div>
   
</div>


    
@endsection

@section('javascriptcontent')
<Script>

$( document ).ready(function() {
    var queryDict = {}
location.search.substr(1).split("&").forEach(function(item) {queryDict[item.split("=")[0]] = item.split("=")[1]})
const queryString = window.location.search;

sessionStorage.setItem("URL", queryString);

});


</script>
@endsection
