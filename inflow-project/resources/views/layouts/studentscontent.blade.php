
<div class="modal fade" id="myModal{{$subject->SubjectsID}}" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
 <div class="modal-content">

 <left>
  <div class="modal-header">
      <h4 class="modal-title">{{$subject->subjectcode}}</h4>
      <button type="button" class="close" data-dismiss="modal">&times;</button>
    </div>

  <div class="modal-body pull-right">
      <strong> Subject Code:</strong>  {{$subject->subjectcode}}     <br/> 
     <strong>Subject Name:</strong> {{$subject->subjectname}}
      <br/><strong> Descriptions:</strong> {{$subject->descriptions}}
      <br/><strong> Units: </strong>{{$subject->units}}
      <br/> <strong>Academic or Non Academic Unit? </strong>{{$subject->type}}
      <br/><strong> Type of Subject:</strong> {{$subject->typeofsubject}}
      <br/> <strong> Topics:   </strong>
    
              @foreach($subjecttopics as $key => $topics)

                  @if($topics->SubjectsID == $subject->SubjectsID)
                  <li>{{$topics->topicname}} </li>
                @endif
          
              @endforeach

 

     <strong>Professors  </strong>
           
        @foreach($subjectprofessors as $key => $intake)
          
          @if($intake->SubjectsID == $subject->SubjectsID)
          <li> {{$professors[$intake->professorsID -1]->professorsname}} </li>
            
          @endif
        @endforeach



    <strong> Year and Term to be taken(Priortity):</strong> {{ $subject->yearflwochart }} & {{ $subject->termflowchart }}
      

  



      <br/> <strong>Possible Year and term to be taken: </strong>  
          <br/>  
      @foreach($subjectintake as  $intake)
            @if($intake->SubjectsID == $subject->SubjectsID)
              <li>
             Yr: {{$intake->yearlevel}} ,
              Term: {{$intake->termlevel}}
              </li>
            @endif
     

      @endforeach

  </div>

 </left>
  <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
  </div>
</div>
</div>
</div>  