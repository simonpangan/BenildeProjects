$(document).ready(function() {

  $('#electives').click(function(e){

  
    var myOptions = [];

    var count = 0;
  var values = $("input[name='tracks[]']").map(function(){
    
    myOptions[count] = $(this).val();
    count++;
  }).get();
  


  var mySelect = $('#choices');
$.each(myOptions, function(val, text) {
    mySelect.append(
        $('<option></option>').val(val).html(text)
    );
});



});



//---------------------------------------------

/*
    var wrapper2   		= $(".input_fields_wrapyearterm"); //Fields wrapper
	var add_button2      = $(".add_field_buttonyearterm"); //Add button ID
    var y = 1;
    $(add_button2).click(function(e){ //on add input button click
		e.preventDefault();
	
			y++; //text box increment
			$(wrapper2).append('<div>  <input type="number" name="year[]" placeholder="year" min="2020" required> <input type="number" name="term[]" placeholder="term[]" min="1" max="3"><a href="#" class="remove_fieldtaken" required>Remove</a></div>'); //add input box
		
	});

	

    $(wrapper2).on("click",".remove_fieldtaken", function(e){ //user click on remove text
    e.preventDefault(); $(this).parent('div').remove(); y--;
    
    $(wrapper3).on("click",".remove_fieldprofessots", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); z--;
	})

	})
*/

//---------------------------------------------

    

	


//---------------------------------------------

	var wrapper4  		= $(".inputfieldtracks"); //Fields wrapper
	var add_button4      = $(".addbuttontracks"); //Add button ID
    var z = 1;
    $(add_button4).click(function(e){ //on add input button click
		e.preventDefault();
	
        z++; //text box increment
			$(wrapper4).append('<div> '
			+ '   <input type="text" name="topics[]" ><a href="#" class="remove_fieldprofessots" required>Remove</a></div>'); //add input box
		
	});

	

    $(wrapper4).on("click",".remove_fieldprofessots", function(e){ //user click on remove text
		e.preventDefault(); $(this).parent('div').remove(); z--;
	})






});
