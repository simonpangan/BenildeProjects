@extends('layouts.main')



@section('content')
  
@include('layouts.header')


<br/>
<br/>


      

        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
         
          <div class="modal-content form-elegant">
            <!--Header-->

           
            <div class="modal-header text-center">
              <h4 class="modal-title ">Add Subject</h4>
             
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
           
     <form action="{{ url('formsubmit')}}" method="post" id="dynamic_form">
  
        @csrf
             

            <div class="modal-body mx-4">
              <div class="container">
              <div class="md-form mb-2">
                <label data-error="wrong" data-success="right" for="Form-email1" >Subject Code:</label>
                  <input type="text"  name="subjectcode" 
                  id="Form-email1"
                  maxlength="7" 
                   class="form-control validate"required>
              </div>
              <div class="md-form mb-2">
                <label data-error="wrong" data-success="right" for="Form-email1">Subject Name:</label>
                  <input type="text"  name="subjectname" 
                  id="Form-email1"
                   class="form-control validate"required>
              </div>

              <div class="md-form mb-2">
                <label data-error="wrong" data-success="right" for="textarea">Subject Description:</label>
              <textarea id="textarea" class="form-control mb-4" rows=11 cols=50 maxlength=250
               name="description" placeholder="Subject Description" required></textarea>
             </div>
              
          
           
            <div class="row">
              <div class="col">
                <div class="md-form mb-3">
                    <label data-error="wrong" data-success="right" for="Form-email1">Units:</label>
                      <input type="number" id="Form-email1" name="Units" class="form-control validate"
                      min="1" max="6"required >
                  </div>
              </div>
              <div class="col">
              </div>
            </div>
       
      
            <div>
              <label class="md-form mb-1">Academic or Non Academic Unit?</label>
            <div class="custom-control custom-radio">
              <input type="radio" class="custom-control-input" id="defaultUnchecked" name="type"value="nonacad"required>
              <label class="custom-control-label" for="defaultUnchecked">Non Academic</label>
            </div>
            <div class="custom-control custom-radio">
              <input type="radio" class="custom-control-input" id="defaultChecked" name="type"value="acad" >
              <label class="custom-control-label" for="defaultChecked">Academic</label>
            </div>
          </div>
      
          <br>
          <div>
            <label class="md-form mb-1">Type of Subject:</label>
          <!-- Group of default radios - option 1 -->
          <div class="custom-control custom-radio">
            <input type="radio" class="custom-control-input" id="defaultGroupExample1" name="typeofsubject" value="Major"required>
            <label class="custom-control-label" for="defaultGroupExample1">Major</label>
          </div>
        
          <!-- Group of default radios - option 2 -->
          <div class="custom-control custom-radio">
            <input type="radio" class="custom-control-input" id="defaultGroupExample2"  value="Minor"name="typeofsubject">
            <label class="custom-control-label" for="defaultGroupExample2">Minor</label>
          </div>
        
          <!-- Group of default radios - option 3 -->
          <div class="custom-control custom-radio">
            <input type="radio" class="custom-control-input mb-1" id="defaultGroupExample3"  value="Electives"name="typeofsubject">
            <label class="custom-control-label" for="defaultGroupExample3">Electives</label>
          </div>
          </div>
      
          <div class="input_fields_wrap2">
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
            
  
         </div>
        
         

          <div class="input_fields_wrapprofessors">
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
        
  
         </div>


        
         </div>
          <div class="container">
            <div class="row">
              <div class="col">
                <div class="md-form mb-3">
                    <label data-error="wrong" data-success="right" for="Form-email1">Flowchart Priority Time</label>
                      <input type="number" name="yearflwochart"id="Form-email1" min="1" max="8"class="form-control validate" placeholder="Year">
                  </div>
              </div>
              <div class="col">
                <div class="md-form">
                  <label data-error="wrong" data-success="right" for="Form-email1">(Year & Term)</label>
                <input type="number" id="Form-email1" name="termflowchart"    class=" form-control validate"min="1" max="3"  placeholder="Term">	
                  </div>
              </div>
            </div>
          </div>
      
          <div class="container">
            <div class="input_fields_wrapyearterm">

              <label data-error="wrong" data-success="right" for="Form-email1">
                Year & Term to be taken (if Flowchart is not followed)</label>
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
                 
          
            </div>

            
                <div class="text-center mb-3">
                  <button type="submit" value="{{$id}}" id="submit"name="submit"
                  class="btn btn-outline-success btn-block btn-rounded z-depth-1a">Submit</button>
           
                </div>
                
        
           
              </div>
  
           </div>      
             
            
           </div>
     </form>
            <!--Footer-->
            <div class="modal-footer mx-5 pt-3 mb-1">
            </div>
          </div>
          <!--/.Content-->
        </div>
      </div>
      








      
   
        <br/>
        <div class="row">

      
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">TOTAL SUBJECTS: 

                  </div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800">  {{$arrayinfo[0]}}</div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-calendar fa-2x text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-success shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                    TOTAL UNITS: 
                    
                   </div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800"> {{$arrayinfo[1]}}</div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>

        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-primary shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">TOTAL non acadUNITS: 
                    </div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800">{{$arrayinfo[3]}}</div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-calendar fa-2x text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>

        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-success shadow h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                    TOTAL acad UNITS: 
                   </div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800"> {{$arrayinfo[2]}}</div>
                </div>
                <div class="col-auto">
                  <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                </div>
              </div>
            </div>
          </div>
        </div>

        </div>

<br/>
<br/>
      <center>
    <a href="" class="btn btn-outline-success" data-toggle="modal" data-target="#myModal">Insert Subject</a>
            
    <a href="/schoolcourses/{{$id}}/subject/flowchart"
        class="btn btn-outline-dark">View Course FlowChart </a> 
      </center>


        <br/> <br/>
        <table id="table_id"  class="display nowrap" style="width:100%">
          <thead>
              <tr>
                   <th></th>
                  <th>Subject Code</th>
                  <th>Subject Name</th>
                  <th>Type</th>
                  <th>Type of subject</th>
                  <th>CreationDate</th>
                  <th>ModifiedDate</th>
                  <th></th>
                  <th></th>
              </tr>
          </thead>
          <tbody>
            @foreach($posts as $key => $post)
            
            <tr>

              <td></td>
              <td id="subjectcode{{$key}}">{{$post->subjectcode}}</td>
              <td >{{$post->subjectname}}</td>
                    <td >{{$post->type}}</td>
              <td>{{$post->typeofsubject}}</td>
            <td id="creation{{$key}}" name="creation"> 
                  
              </td>

              @if($post->ModifiedDate)
              <td id="modified{{$key}}" name="modified"> 
                  
              </td>

              @else

              <td> 
                  
              </td>
              @endif
              <td> <a href="/schoolcourses/{{$post->CourseID}}/subject/{{$post->SubjectsID}}" name="edit"
                class="btn btn-default">Edit Subject Information </a>  </td>
              <td><form action="{{ url('delete')}}" method="get" id="deleteform"style="display: inline;">
                
                @csrf
                <input type="hidden" value="{{$post->SubjectsID}}" name="temp" />

              <button type="submit" value="{{$post->SubjectsID}}" id="delete{{$key}}"name="delete"> Delete</button> 
 
                  </form> </td>
           </tr>

           @endforeach
          </tbody>
      </table>


    
       
      
    


    </td>

     <a href=""id="myLink"
        class="btn btn-default">Go back </a> 
         
        
@endsection
@section('javascriptcontent')



<script type="text/javascript">


 var a = document.getElementById('myLink');
 
url = sessionStorage.getItem("URL");
a.href ="{{ url('schoolcourses')}}" +url;



$(document).ready(function(){

  
//ssssion get kuhanin value nung session
    var exist = '{{Session::has('alert')}}';
    if(exist){
      
        const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        onOpen: (toast) => {
          toast.addEventListener('mouseenter', Swal.stopTimer)
          toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
      })

          Toast.fire({
            icon: 'success',
            title: 'Created Successfully'
          })
    }



    var exist = '{{Session::has('successMsg')}}';
    if(exist){
      
        const Toast = Swal.mixin({
        toast: true,
        position: 'top-end',
        showConfirmButton: false,
        timer: 3000,
        timerProgressBar: true,
        onOpen: (toast) => {
          toast.addEventListener('mouseenter', Swal.stopTimer)
          toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
      })

          Toast.fire({
            icon: 'success',
            title: 'Updated Successfully'
          })
    }


    //alert


 


//get json of data from controller 
  var tmp = {!! json_encode($posts->toArray()) !!};
  console.log(tmp);
  tmp.forEach(myFunction);


function myFunction(item, index) {


//for delete
  $('#delete' + '' + index +'').on('click', function(e){
    e.preventDefault();
    
    var temp;
              Swal.fire({
            title: 'Are you sure?',
            text: "You won't be able to revert this!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
          }).then((result) => {
            if (result.value) {

              
                Swal.fire(
                    'Deleted!',
                    'Your file has been deleted.',
                    'success'
                  )
            
              $('#delete' + '' + index +'').value = 'Changed';
              $("#deleteform").submit();
            }
          });
});
  
//for datetime

  let m = moment();
  m = moment(item.CreationDate);  
  
  $('#creation' + '' + index +'').html(m.format('MMMM Do YYYY, h:mm a'));


  let z = moment();
  z = moment(item.ModifiedDate);  
  
  $('#modified' + '' + index +'').html(z.format('MMMM Do YYYY, h:mm a'));


}



 
//----
  
 // $('#table_id').DataTable(); 
 $(document).ready(function() {
			        $('#table_id').DataTable( {
			            responsive: {
			                details: {
			                    type: 'column', 
			                    target: 'tr'
			                }
			            },
			            columnDefs: [ {
			                className: 'control',
			                orderable: false,
			                targets:   0
			            } ],
			            order: [ 1, 'asc' ]
			        } );
			    } );

//----------
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
	})



</script>
@endsection