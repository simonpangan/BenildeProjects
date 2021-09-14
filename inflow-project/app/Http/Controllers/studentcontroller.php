<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use DB;
use Auth;

class studentcontroller extends Controller
{



#region studentHome
public function studentHome()
    {
  

      $id = DB::table('table_students') 
      ->where('StudentID', Auth::id())->first()->CourseID; //course id of the student
      $studentid = Auth::id();//student id oof the user
 
   
      $subjects = DB::table('table_subjects') ->where('table_subjects.CourseID', $id)
      ->get();


     $subjectsintake = DB::table('table_subjects')
     ->join('table_subjectintake', 'table_subjects.SubjectsID', '=', 'table_subjectintake.SubjectsID')
     ->where('table_subjects.CourseID', $id)
      ->get();

      $subjectprofessors = DB::table('table_subjects')
     ->join('table_subjectsprofessors', 'table_subjects.SubjectsID', '=', 'table_subjectsprofessors.SubjectsID')
     ->where('table_subjects.CourseID', $id)
      ->get();


      $professors =  DB::table('table_professors')->get();
      
      $subjecttopics = DB::table('table_subjects')
      ->join('table_subjecttopics', 'table_subjects.SubjectsID', '=', 'table_subjecttopics.SubjectsID')
      ->where('table_subjects.CourseID', $id)
       ->get();




      

      $nonacademic = 0;

      $academic = 0;

      foreach($subjects as $data){

        if($data->type == "nonacad")$nonacademic += $data->units;
        if($data->type == "acad")$academic += $data->units;
      } 

    

    DB::table('table_course')
    ->where('CourseID', $id)
    ->update(['academicunitstotal' => $academic,
              'nonacademicunitstotal' => $nonacademic ]);


              
  //------
  $subjectstaken = DB::table('table_subjectstaken')->where('StudentID', 1)
       ->get();


    $nonacademic = 0;

    $academic = 0;

      foreach($subjectstaken as $data){


        $temp = DB::table('table_subjects')->where('SubjectsID', $data->SubjectsID)
       ->first();

       if($data->status == "Passed"){
        if($temp->type == "nonacad")$nonacademic += $temp->units;
        if($temp->type == "acad")$academic += $temp->units;
       }
        
      } 


    $courseid = DB::table('table_course')->where('CourseID', $id)
  ->first();
    


  //for subject status
  $subjectstaken = DB::table('table_subjectstaken')
  ->where('StudentID', $studentid)
       ->get();

    



  

     
       
    return view('student.studenthome')
    ->with('subjectinfo', $subjects)

    ->with('subjectintake', $subjectsintake)
    ->with('subjectprofessors', $subjectprofessors)
    ->with('professors', $professors)
    ->with('subjectstaken', $subjectstaken)
    ->with('subjecttopics', $subjecttopics)
    ->with('nonacademic', $nonacademic)
    ->with('academic', $academic)
    ->with('courseid', $courseid);


    
    
    
    }
}
#endregion