@extends('layouts.main')

@section('content')


@include('layouts.header')


    <br/>
    <br/>

    <form action="{{ url('update')}}" method="post">
    
      @csrf


    <div class="container " style="width: 400px; ">
        <h2 > Update Subject </h2>

        <br/>
        <br/>
    <div class="md-form mb-2">
      <label data-error="wrong" data-success="right" for="Form-email1" >Subject Code:</label>
        <input type="text" value="{{$info->subjectcode}}" name="subjectcode" 
        id="Form-email1"
        maxlength="7" 
         class="form-control validate"required>
    </div>
    <div class="md-form mb-2">
      <label data-error="wrong" data-success="right" for="Form-email1">Subject Name:</label>
        <input type="text"   value="{{$info->subjectname}}"name="subjectname" 
        id="Form-email1"
         class="form-control validate"required>
    </div>

    <div class="md-form mb-2">
      <label data-error="wrong" data-success="right" for="textarea">Subject Description:</label>
    <textarea id="textarea"  class="form-control mb-4" rows=11 cols=50 maxlength=250
     name="description" placeholder="Subject Description" required>{{$info->descriptions}}</textarea>
   </div>
    

 
  <div class="row">
    <div class="col">
      <div class="md-form mb-3">
          <label data-error="wrong" data-success="right" for="Form-email1">Units:</label>
            <input type="number" value="{{$info->units}}" id="Form-email1" name="Units" class="form-control validate"
            min="1" max="6"required >
        </div>
    </div>
    <div class="col">
    </div>
  </div>


  @if($info->type == "nonacad")
  <div>
    <label class="md-form mb-1">Academic or Non Academic Unit?</label>
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultUnchecked" name="type"value="nonacad"required checked>
    <label class="custom-control-label" for="defaultUnchecked">Non Academic</label>
  </div>
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultChecked" name="type"value="acad" >
    <label class="custom-control-label" for="defaultChecked">Academic</label>
  </div>
  </div>

  @elseif($info->type == "acad")


  <div>
    <label class="md-form mb-1">Academic or Non Academic Unit?</label>
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultUnchecked" name="type"value="nonacad"required >
    <label class="custom-control-label" for="defaultUnchecked">Non Academic</label>
  </div>
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultChecked" name="type"value="acad" checked>
    <label class="custom-control-label" for="defaultChecked">Academic</label>
  </div>
  </div>


  @else
  <div>
    <label class="md-form mb-1">Academic or Non Academic Unit?</label>
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultUnchecked" name="type"value="nonacad"required >
    <label class="custom-control-label" for="defaultUnchecked">Non Academic</label>
  </div>
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultChecked" name="type"value="acad" >
    <label class="custom-control-label" for="defaultChecked">Academic</label>
  </div>
  </div>

  @endif


<br>
<div>
  <label class="md-form mb-1">Type of Subject:</label>

  @if($info->typeofsubject == "Major")

<div class="custom-control custom-radio">
  <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="typesubject" value="Major"required checked>
  <label class="custom-control-label" for="defaultGroupExample1">Major</label>
</div>

<!-- Group of default radios - option 2 -->
<div class="custom-control custom-radio">
  <input type="radio" class="custom-control-input" id="defaultGroupExample2"  value="Minor"name="typesubject">
  <label class="custom-control-label" for="defaultGroupExample2">Minor</label>
</div>

<!-- Group of default radios - option 3 -->
<div class="custom-control custom-radio">
  <input type="radio" class="custom-control-input mb-1" id="defaultGroupExample3"  value="Electives"name="typesubject">
  <label class="custom-control-label" for="defaultGroupExample3">Electives</label>
</div>
  @elseif($info->typeofsubject == "Minor")
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="typesubject" value="Major"required>
    <label class="custom-control-label" for="defaultGroupExample1">Major</label>
  </div>
  
  <!-- Group of default radios - option 2 -->
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultGroupExample2"  value="Minor"name="typesubject" checked>
    <label class="custom-control-label" for="defaultGroupExample2">Minor</label>
  </div>
  
  <!-- Group of default radios - option 3 -->
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input mb-1" id="defaultGroupExample3"  value="Electives"name="typesubject">
    <label class="custom-control-label" for="defaultGroupExample3">Electives</label>
  </div>
  @elseif($info->typeofsubject == "Electives")
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="typesubject" value="Major"required>
    <label class="custom-control-label" for="defaultGroupExample1">Major</label>
  </div>
  
  <!-- Group of default radios - option 2 -->
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultGroupExample2"  value="Minor"name="typesubject">
    <label class="custom-control-label" for="defaultGroupExample2">Minor</label>
  </div>
  
  <!-- Group of default radios - option 3 -->
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input mb-1" id="defaultGroupExample3"  value="Electives"
    name="typesubject" checked>
    <label class="custom-control-label" for="defaultGroupExample3">Electives</label>
  </div>
  @else

  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="typesubject" value="Major"required>
    <label class="custom-control-label" for="defaultGroupExample1">Major</label>
  </div>
  
  <!-- Group of default radios - option 2 -->
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input" id="defaultGroupExample2"  value="Minor"name="typesubject">
    <label class="custom-control-label" for="defaultGroupExample2">Minor</label>
  </div>
  
  <!-- Group of default radios - option 3 -->
  <div class="custom-control custom-radio">
    <input type="radio" class="custom-control-input mb-1" id="defaultGroupExample3"  value="Electives"name="typesubject">
    <label class="custom-control-label" for="defaultGroupExample3">Electives</label>
  </div>
  @endif

</div>



<div class="input_fields_wrap2">
  @if(empty($topics))
  <div class="form-row">
  <div class="form-group col-md-6">
    <label data-error="wrong" data-success="right" for="Form-email1">Topics:</label>
    <input type="text" id="Form-email1" name="topics[]" placeholder="Topics"class="form-control validate">
    
  </div>
  <div class="form-group col-md-6">
    <label data-error="wrong" data-success="right" for="Form-email1"></label>
    <button class="btn btn-outline-success btn-block mt-2 add_field_button2"  type="button">Add More Fields</button>
  </div>  

  </div>
  @endif


  
  @foreach ($topics as $key=> $topic)
      @if($key == 0)

      <div class="form-row">
        <div class="form-group col-md-6">
          <label data-error="wrong" data-success="right" for="Form-email1">Topics:</label>
          <input type="text" id="Form-email1" name="topics[]" value="{{$topic->topicname}}" placeholder="Topics"class="form-control validate">
          
        </div>
        <div class="form-group col-md-6">
          <label data-error="wrong" data-success="right" for="Form-email1"></label>
          <button class="btn btn-outline-success btn-block mt-2 add_field_button2"  type="button">Add More Fields</button>
        </div>  
      
        </div>

      @else 
    <div class="form-row">
              <div class="form-group col-md-6 mb-6" >
           <label data-error="wrong" data-success="right" for="Form-email1"></label>
           <input type="text" name="topics[]" value="{{$topic->topicname}}"id="Form-email1" class="form-control validate" required>
         </div>
         <div class="form-group col-md-6 mb-6" >
           <label data-error="wrong" data-success="right" for="Form-email1"></label>
           <button class="btn btn-outline-danger btn-block remove_field" type="button">Remove</button>
        
         </div> 

     </div>




      @endif
  @endforeach


</div>



<div class="input_fields_wrapprofessors">
  @foreach ($listofprofessors as $key=> $listofprofessor)
     @if($key == 0 )

        @if(empty($listofprofessor->professorsID))

            <div class="form-row">
                <div class="form-group col-md-6">
                  <label data-error="wrong" data-success="right" for="Form-email1"> Professors:</label>
                  <select name="professors[]" class="browser-default custom-select mb-2" id="select">
                    <option value="">Select..</option>
                    @foreach ($professors as $professor)
                        <option value="{{ $professor->professorsname }}">{{ $professor->professorsname }}</option>
                    @endforeach
                </select>
                </div>
                <div class="form-group col-md-6">
                  <label data-error="wrong" data-success="right" for="Form-email1"></label>
                    <button class="btn btn-outline-success btn-block mt-2 add_field_buttonprofessors"
                    type="button">Add More Fields</button>
                </div>  
            </div>
        @else

              <div class="form-row">
                <div class="form-group col-md-6">
                  <label data-error="wrong" data-success="right" for="Form-email1"> Professors:</label>
                  <select name="professors[]" class="browser-default custom-select mb-2" id="select">
                    <option value="{{$professors[$listofprofessor->professorsID-1]->professorsname}}">
                      {{$professors[$listofprofessor->professorsID-1]->professorsname}}</option>
                    <option value="">Select..</option>
                    @foreach ($professors as $professor)
                        <option value="{{ $professor->professorsname }}">{{ $professor->professorsname }}</option>
                    @endforeach
                </select>
                </div>
                <div class="form-group col-md-6">
                  <label data-error="wrong" data-success="right" for="Form-email1"></label>
                    <button class="btn btn-outline-success btn-block mt-2 add_field_buttonprofessors"
                    type="button">Add More Fields</button>
                </div>  
            </div>

            @endif

      @else

      <div class="form-row">
        <div class="form-group col-md-6 mb-6" >
           <label data-error="wrong" data-success="right" for="Form-email1"></label>
           <select name="professors[]"  class="form-control validate"  id="select">
           <option value="{{$professors[$listofprofessor->professorsID-1]->professorsname}}">
                      {{$professors[$listofprofessor->professorsID-1]->professorsname}}</option>
                    <option value="">Select..</option> @foreach ($professors as $professor)
               <option value="{{ $professor->professorsname }}">{{ $professor->professorsname }}
              </option> @endforeach
            </select>
         </div>
         <div class="form-group col-md-6 mb-6" >
           <label data-error="wrong" data-success="right" for="Form-email1"></label>
        <button class="btn btn-outline-danger btn-block remove_fieldprofessots" type="button">Remove
          </button>
         </div>

      </div>
          
      @endif

  @endforeach
</div>



</div>
<div class="container " style="width: 400px; ">
  <div class="row">
    <div class="col">
      <div class="md-form mb-3">
          <label data-error="wrong" data-success="right" for="Form-email1">Flowchart Priority Time</label>
            <input type="number" name="yearflwochart" value="{{$info->yearflwochart}}"id="Form-email1" min="1" max="8"class="form-control validate" placeholder="Year">
        </div>
    </div>
    <div class="col">
      <div class="md-form">
        <label data-error="wrong" data-success="right" for="Form-email1">(Year & Term)</label>
      <input type="number" id="Form-email1" name="termflowchart"  value="{{$info->termflowchart}}"  class=" form-control validate"min="1" max="3"  placeholder="Term">	
        </div>
    </div>
  </div>
</div>


<div class="container " style="width: 400px; ">
  <div class="input_fields_wrapyearterm">

    <label data-error="wrong" data-success="right" for="Form-email1">
      Year & Term to be taken (if Flowchart is not followed)</label>

      @foreach ($intake as $key => $intakes)
       @if($key == 0 )
                @if(empty($intakes->yearlevel)) 

                <div class="form-row">         
                  <div class="form-group col mb-6" >
                    <label data-error="wrong" data-success="right" for="Form-email1"></label> 
                    <input type="number" name="year[]" placeholder="Year" min="2020" id="Form-email1" class="form-control validate" >
                  </div><div class="form-group col mb-6" ><label data-error="wrong" data-success="right" for="Form-email1">
                    </label> <input type="number"placeholder="Term" min="1" max="3" name="term[]" id="Form-email1" class="form-control validate" > 
                  </div><div class="form-group col  mb-6" ><label data-error="wrong" data-success="right" for="Form-email1">
                    </label><button class="btn btn-outline-success btn-block add_field_buttonyearterm"type="button" >Add More </button>  
                  </div>
                </div>

                @else 
                <div class="form-row">  
                  <div class="form-group col mb-6" >
                    <label data-error="wrong" data-success="right" for="Form-email1"></label> 
                    <input type="number"value="{{$intakes->yearlevel}}" name="year[]" placeholder="Year" min="2020" id="Form-email1" class="form-control validate" >
                  </div><div class="form-group col mb-6" ><label data-error="wrong" data-success="right" for="Form-email1">
                    </label> <input type="number" value="{{$intakes->termlevel}}"placeholder="Term" min="1" max="3" name="term[]" id="Form-email1" class="form-control validate" > 
                  </div><div class="form-group col  mb-6" ><label data-error="wrong" data-success="right" for="Form-email1">
                    </label><button class="btn btn-outline-success btn-block add_field_buttonyearterm"type="button" >Add More </button>  
                  </div>
                </div>
            

                @endif

          @else
        
       
                  
        <div class="form-row">
        <div class="form-group col mb-6" >
      <label data-error="wrong" data-success="right" for="Form-email1"></label>
       <input type="number" min="2020" name="year[]" value="{{$intakes->yearlevel}}"
       id="Form-email1" class="form-control validate" required></div><div
        class="form-group col mb-6" ><label data-error="wrong" data-success="right" 
        for="Form-email1"></label> <input type="number"  min="1" max="3"
         value="{{$intakes->termlevel}}"name="term[]" id="Form-email1"
          class="form-control validate" required> </div><div class="form-group col  mb-6" >
            <label data-error="wrong" data-success="right" for="Form-email1"></label><button 
            class="btn btn-outline-danger btn-block remove_fieldtaken" type="button">Remove</button> 
           </div></div>

          @endif

        
       
      @endforeach

    </div>

      <div class="text-center mb-3">
        <button type="submit" value="{{$idsubject}}" id="submit"name="submit"
        class="btn btn-outline-success btn-block btn-rounded z-depth-1a">Submit</button>
        <a href="/schoolcourses/{{$id}}/subject"
        class="btn btn-outline-dark btn-block btn-rounded z-depth-1a">Go back </a> 
  
      </div>
    </div>
  
  </div>

  

      

 
    </div>

 </div>      
   
  
    </form>
 
@endsection



@section('javascriptcontent')
<script>
$(document).ready(function() {

    var wrapper   		= $(".input_fields_wrap2"); //Fields wrapper
	var add_button      = $(".add_field_button2"); //Add button ID
	
	var x = 1; //initlal text box count
	$(add_button).click(function(e){ //on add input button click
		e.preventDefault();
	
			x++; //text box increment
			$(wrapper).append(
		
        '<div class="form-row">'+
           '<div class="form-group col-md-6 mb-6" >'+
              '<label data-error="wrong" data-success="right" for="Form-email1"></label>'+
              '<input type="text" name="topics[]" id="Form-email1" class="form-control validate" required>'+
            '</div>'+
            '<div class="form-group col-md-6 mb-6" >'+
              '<label data-error="wrong" data-success="right" for="Form-email1"></label>'+
              '<button class="btn btn-outline-danger btn-block remove_field" type="button">Remove</button>'+
           
            '</div>' 

        +'</div>' 
        );
	});
	$(wrapper).on("click",".remove_field", function(e){ //user click on remove text
    e.preventDefault(); 
   
    $(this).parents().remove('.form-row');
  //  $(this).parent('<div class="form-row">').remove(); 
  });
  



  var wrapper3  		= $(".input_fields_wrapprofessors"); //Fields wrapper
	var add_button3      = $(".add_field_buttonprofessors"); //Add button ID
  
    $(add_button3).click(function(e){ //on add input button click
		e.preventDefault();
	
       
  
			$(wrapper3).append(
        
      
        '<div class="form-row">'+
           '<div class="form-group col-md-6 mb-6" >'+
              '<label data-error="wrong" data-success="right" for="Form-email1"></label>'+
              '<select name="professors[]"  class="form-control validate"  id="select">' +
               '  <option value="">Select..</option> @foreach ($professors as $professor)'+
                  '<option value="{{ $professor->professorsname }}">{{ $professor->professorsname }}</option> @endforeach'+
               '</select>'+
            '</div>'+
            '<div class="form-group col-md-6 mb-6" >'+
              '<label data-error="wrong" data-success="right" for="Form-email1"></label>'+
              '<button class="btn btn-outline-danger btn-block remove_fieldprofessots" type="button">Remove</button>'+
           
            '</div>' 

        +'</div>' 
      
            
    );
  });
    	


    $(wrapper3).on("click",".remove_fieldprofessots", function(e){ //user click on remove text
    
  
      e.preventDefault(); 
      $(this).parents().remove('.form-row');
    });
    
});

    var wrapper2   		= $(".input_fields_wrapyearterm"); //Fields wrapper
	var add_button2      = $(".add_field_buttonyearterm"); //Add button ID
    var y = 1;
    $(add_button2).click(function(e){ //on add input button click
		e.preventDefault();
	
			y++; //text box increment
      $(wrapper2).append(
        
      '  <div class="form-row">'+
        '               <div class="form-group col mb-6" >'+
   '<label data-error="wrong" data-success="right" for="Form-email1"></label> <input type="number" min="2020" name="year[]" id="Form-email1" class="form-control validate" required></div><div class="form-group col mb-6" ><label data-error="wrong" data-success="right" for="Form-email1"></label> <input type="number"  min="1" max="3"name="term[]" id="Form-email1" class="form-control validate" required> </div><div class="form-group col  mb-6" ><label data-error="wrong" data-success="right" for="Form-email1"></label><button class="btn btn-outline-danger btn-block remove_fieldtaken" type="button">Remove</button>  </div></div>'

               
        ); //add input box
		
	});

	

    $(wrapper2).on("click",".remove_fieldtaken", function(e){ //user click on remove text
		e.preventDefault();    $(this).parents().remove('.form-row'); y--;
	});


    

</script>
@endsection

