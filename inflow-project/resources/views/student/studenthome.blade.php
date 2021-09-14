<!DOCTYPE html>
<html>
<head>
	<title>modal</title>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

	
      <link rel="stylesheet" type="text/css" href="{{ asset('css/flowchart.css') }}">

      <style>
        
          .modal-body{
          text-align: left;
          }
          li{
            padding-left: 11px;
          }
         .student{
          padding-left: 20px;
         }
         
      


        </style>
</head>
<body>


  <a href="{{ route('logout') }}"style=" float: right;" class="btn btn-success"
  onclick="event.preventDefault();
                document.getElementById('logout-form').submit();">
   {{ __('Logout') }}
  </a>
  
  <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none; float: right;">
   @csrf
  </form>

  <br/><br/>
  <div class="row">
    <div class="col-lg-12">
      <div class="row">
        <div class="col-sm-4">
        <p class ="student">{{Auth::user()->LastName}}, {{Auth::user()->FirstName}} {{Auth::user()->MiddleName}}</br>
          {{Auth::user()->IdNumber}}</br>
          School Year Batch: 2018-2019</br>
          School of Management and Information Technology </br>
          BACHELOR OF SCIENCE IN INFORMATION SYSTEMS</p>
          </br>
          <br>
         <p class="lvl" >Freshman </p> 
        </div>
    <div class="col-lg-1">
      <p class="lvl2" >Sophomore </p> 
    </div>
    <div class="col-lg-1">
      <p class="lvl3" >Junior</p> 
    </div>
    <div class="col-lg-1">
      <p class="lvl4" >Senior</p> 
    </div>
    </div>
  </div>
 
    
<!--start of flowchart table-->

<!--1ST YEAR 1ST TERM-->

      @php 
      $academicunits=0;
      $NonAcademic =0;

      @endphp

     <div class="row">
       <div class="col-lg-1">
        <div class="p-1">
          <div class="text-center">
           <div class="unitbox"> <div class="number"> 1 </div></div>
            <br>

            @foreach ($subjectinfo as $subject) 
              @if($subject->yearflwochart == 1 && $subject->termflowchart == 1)

            
@foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>  
    @endif
    @endif
@endforeach
              
              @include('layouts.studentscontent')
              
              @php if($subject->type == "nonacad") 
              $NonAcademic += $subject->units; 
              elseif($subject->type == "acad")
              $academicunits += $subject->units; 
              @endphp @endif 
              
              @endforeach

            <div class="totalbox"><div class="number">  {{$academicunits}}.0({{$NonAcademic}}.0) </div></div>
          </div>
        </div>
      </div>
     </div>

     @php $academicunits2=0; $NonAcademic2 =0; @endphp

     <div class="row">
      <div class="col-lg-1">
       <div class="p-1">
         <div class="text-center">
          <div class="unitbox"> <div class="number"> 2 </div> </div>
           <br>
           @foreach ($subjectinfo as $subject) 
           @if($subject->yearflwochart == 1 && $subject->termflowchart == 2)

         
           @foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else <div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>      
    @endif
    @endif
@endforeach
           @include('layouts.studentscontent')
           
           @php if($subject->type == "acad") $academicunits2 += $subject->units; 
           elseif($subject->type == "nonacad")$NonAcademic2 += $subject->units; @endphp @endif 
           @endforeach
           <div class="totalbox"><div class="number"> {{$academicunits2}}.0({{$NonAcademic2}}.0)  </div></div>
          </div>
       </div>
     </div>
    </div>

    
    @php $academicunits3=0; $NonAcademic3 =0; @endphp
    <div class="row">
      <div class="col-lg-1">
       <div class="p-1">
         <div class="text-center">
          <div class="unitbox"> <div class="number"> 3 </div> </div>
           <br>
           @foreach ($subjectinfo as $subject) 
              @if($subject->yearflwochart == 1 && $subject->termflowchart == 3)

            
              @foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else <div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div> 
    @endif
    @endif
@endforeach
              @include('layouts.studentscontent')
              
              @php if($subject->type == "nonacad") 
              $NonAcademic3 += $subject->units; 
              elseif($subject->type == "acad")
              $academicunits3 += $subject->units; 
              @endphp @endif 
              @endforeach<div class="totalbox"><div class="number"> {{$academicunits3}}.0({{$NonAcademic3}}.0)  </div></div>
          </div>
       </div>
     </div>
    </div>

    <div class="summerbox"><div class="summer"> summer </div></div>

    @php $academicunits4=0; $NonAcademic4 =0; @endphp
    <div class="row">
      <div class="col-lg-1">
       <div class="p-1">
         <div class="text-center">
          <div class="unitbox"> <div class="number"> 4 </div> </div>
           <br>
           @foreach ($subjectinfo as $subject) 
           @if($subject->yearflwochart == 2 && $subject->termflowchart == 1)

         
           @foreach ($subjectstaken as $taken)
           @if($subject->SubjectsID == $taken->SubjectsID)
             @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
             @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
               @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
             @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
             @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
             @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
             @else<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>  
             @endif
             @endif
         @endforeach
           @include('layouts.studentscontent')
           
           @php if($subject->type == "nonacad") 
           $NonAcademic4 += $subject->units; 
           elseif($subject->type == "acad")
           $academicunits4 += $subject->units; 
           @endphp @endif 
           @endforeach<div class="totalbox" style="margin-top: 61px;"><div class="number"> {{$academicunits4}}.0({{$NonAcademic4}}.0)  </div></div>
          </div>
       </div>
     </div>
    </div>

    @php $academicunits5=0; $NonAcademic5 =0; @endphp
    <div class="row">
     <div class="col-lg-1">
      <div class="p-1">
        <div class="text-center">
          <div class="unitbox"> <div class="number"> 5 </div> </div>
          <br>
          @foreach ($subjectinfo as $subject) 
          @if($subject->yearflwochart == 2 && $subject->termflowchart == 2)

        
          @foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else <div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>    
    @endif
    @endif
@endforeach
          @include('layouts.studentscontent')
          
          @php if($subject->type == "nonacad") 
          $NonAcademic5 += $subject->units; 
          elseif($subject->type == "acad")
          $academicunits5 += $subject->units; 
          @endphp @endif 
          @endforeach<div class="totalbox" style="margin-top: 121px;"><div class="number"> {{$academicunits5}}.0({{$NonAcademic5}}.0)  </div></div>
        </div>
      </div>
    </div>
   </div>

   
   @php $academicunits6=0; $NonAcademic6 =0; @endphp
   <div class="row">
     <div class="col-lg-1">
      <div class="p-1">
        <div class="text-center">
          <div class="unitbox"> <div class="number"> 6 </div> </div>
          <br>
          @foreach ($subjectinfo as $subject) 
              @if($subject->yearflwochart == 2 && $subject->termflowchart == 3)

            
              @foreach ($subjectstaken as $taken)
              @if($subject->SubjectsID == $taken->SubjectsID)
                @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
                @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
                  @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
                @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
                @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
                @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
                @else <div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>    
                @endif
                @endif
            @endforeach
              @include('layouts.studentscontent')
              
              @php if($subject->type == "nonacad") 
              $NonAcademic6 += $subject->units; 
              elseif($subject->type == "acad")
              $academicunits6 += $subject->units; 
              @endphp @endif 
              @endforeach<div class="totalbox" style="margin-top: 121px;"><div class="number">{{$academicunits6}}.0({{$NonAcademic6}}.0) </div></div>
        </div>
      </div>
    </div>
   </div>

   <div class="summerbox"><div class="summer"> summer </div></div>

   @php $academicunits7=0; $NonAcademic7 =0; @endphp 
   <div class="row">
    <div class="col-lg-1">
     <div class="p-1">
       <div class="text-center">
        <div class="unitbox"> <div class="number"> 7 </div> </div>
         <br>
         @foreach ($subjectinfo as $subject) 
         @if($subject->yearflwochart == 3 && $subject->termflowchart == 1)

       
         @foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else <div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>  
    @endif
    @endif
@endforeach
         @include('layouts.studentscontent')
         
         @php if($subject->type == "nonacad") 
         $NonAcademic7 += $subject->units; 
         elseif($subject->type == "acad")
         $academicunits7 += $subject->units; 
         @endphp @endif 
         @endforeach<div class="totalbox" style="margin-top: 121px;"><div class="number"> {{$academicunits7}}.0({{$NonAcademic7}}.0)  </div></div>
        </div>
     </div>
   </div>
  </div>

  @php $academicunits8=0; $NonAcademic8 =0; @endphp
  <div class="row">
    <div class="col-lg-1">
     <div class="p-1">
       <div class="text-center">
        <div class="unitbox"> <div class="number"> 8 </div> </div>
         <br>
         @foreach ($subjectinfo as $subject) 
         @if($subject->yearflwochart == 3 && $subject->termflowchart == 2)

       
         @foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div> 
    @endif
    @endif
@endforeach
         @include('layouts.studentscontent')
         
         @php if($subject->type == "nonacad") 
         $NonAcademic8 += $subject->units; 
         elseif($subject->type == "acad")
         $academicunits8 += $subject->units; 
         @endphp @endif 
         @endforeach<div class="totalbox" style="margin-top: 121px;"><div class="number"> {{$academicunits8}}.0({{$NonAcademic8}}.0)  </div></div>
        </div>
     </div>
   </div>
  </div>

 
  @php $academicunits9=0; $NonAcademic9 =0; @endphp 
 <div class="row">
   <div class="col-lg-1">
    <div class="p-1">
      <div class="text-center">
        <div class="unitbox"> <div class="number"> 9 </div> </div>
        <br>
        @foreach ($subjectinfo as $subject) 
        @if($subject->yearflwochart == 3 && $subject->termflowchart == 3)

      
        @foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else <div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @endif
    @endif
@endforeach
        @include('layouts.studentscontent')
        
        @php if($subject->type == "nonacad") 
        $NonAcademic9 += $subject->units; 
        elseif($subject->type == "acad")
        $academicunits9 += $subject->units; 
        @endphp @endif 
        @endforeach<div class="totalbox"style="margin-top: 181px;"><div class="number"> {{$academicunits9}}.0({{$NonAcademic9}}.0)  </div></div>      </div>
    </div>
  </div>
 </div>

 
 <div class="summerbox"><div class="summer"> summer </div></div>
 @php $academicunits10=0; $NonAcademic10 =0; @endphp
 <div class="row">
  <div class="col-lg-1">
   <div class="p-1">
     <div class="text-center">
      <div class="unitbox"> <div class="number"> 10 </div> </div>
      <br>
      @foreach ($subjectinfo as $subject) 
      @if($subject->yearflwochart == 4 && $subject->termflowchart == 1)

    
      @foreach ($subjectstaken as $taken)
  @if($subject->SubjectsID == $taken->SubjectsID)
    @if($taken->status == "Passed") <div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>          
    @elseif($taken->status == "Enrolled")<div class="gap"><a href="" class="current" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
      @elseif($taken->status == "Enlisted")<div class="gap"><a href="" class="enlisted" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Unenlisted")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Enlistable")<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @elseif($taken->status == "Failed")<div class="gap"><a href="" class="passed" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>
    @else<div class="gap"><a href="" class="junior" data-toggle="modal" data-target="#myModal{{$subject->SubjectsID}}">{{$subject->subjectcode}}<br>{{$subject->units}}.0</br></a></div>  
    @endif
    @endif
@endforeach
      @include('layouts.studentscontent')
      
      @php if($subject->type == "nonacad") 
      $NonAcademic10 += $subject->units; 
      elseif($subject->type == "acad")
      $academicunits10 += $subject->units; 
      @endphp @endif 
      @endforeach<div class="totalbox"style="margin-top: 422px;"><div class="number">{{$academicunits10}}.0({{$NonAcademic10}}.0) </div></div>
      </div>
   </div>
 </div>
</div>

<div class="row">
 <div class="col-lg-1">
  <div class="p-1">
    <div class="text-center">
      <div class="unitbox"> <div class="number"> 11 </div> </div>
      <br>
   </div>
  </div>
</div>
</div>

<div class="row">
  <div class="col-lg-1">
   <div class="p-1">
     <div class="text-center">
      <div class="unitbox"> <div class="number"> 12</div> </div>
      <br>
      </div>
   </div>
 </div>
</div>


     </div>

</body>
<hr>

<footer class="page-footer font-small indigo">
  <div class="container text-center text-md-left">
    <div class="row">
      <div class="col-md-3 mx-auto">
        <table style="width:100%">
        <h5 class="text-uppercase">Legend:</h5>
        <tr>
          <th><div class="legbox"><div class="PassLeg"></div></div></th>
          <th>Passed Subjects</th>
        </tr>
        <tr>
          <th><div class="legbox"><div class="EnroLeg"></div></div></th>
          <th>Enrolled Subjects</th>
        </tr>
        <tr>
          <th> <div class="legbox"><div class="EnliLeg"></div></div></div></div></th>
          <th>Enlisted Subjects</th>
        </tr>
        <tr>
          <th><div class="legbox"><div class="FutuLeg"></div></div></th>
          <th>Future Subjects</th>
        </tr>
        </table>
      </div>

      <hr class="clearfix w-100 d-md-none">

      <!-- Grid column -->
      <div class="col-md-3 mx-auto">



        <ul class="list-unstyled">
          <li>
            <p class ="information">Total Number of Academic Units Earned:  {{$academic}}
            </p>
          </li>
          <li>
            <p class ="information">Total Number of Non-Academic Units Earned: {{$nonacademic}}</p>
          </li>
          <li>
            <p class ="information">Total Number of Units Earned: {{$nonacademic + $academic}}</p>
          </li>
          <li>
            <p class ="information">Out Of: {{($courseid->academicunitstotal + $courseid->nonacademicunitstotal)}}</p>
          </li>
          <li>
            <p class ="information">Remaining Units:  {{($courseid->academicunitstotal + $courseid->nonacademicunitstotal) - ($nonacademic + $academic)}}</p>
          </li>
        </ul>
      </div>
      <!-- Grid column -->

      <hr class="clearfix w-100 d-md-none">

      </div>
    <!-- Grid row -->

  </div>
  <!-- Footer Links -->


</footer>