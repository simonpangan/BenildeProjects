<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\school;
use App\course;
use App\subjects;
use App\User;
use App\Role;
use Datetime;
use DB;
use DateTimeZone;
use Auth;


class admincontroller extends Controller
{
   
#viewschoolcourse
  
public function viewschoolcourses(Request $request){


    $validatedData = $request->validate([
      'schoolyear' => 'required',
      'schoolname' => 'required',
    ]);


    //--------- get input values
    $schoolyear = $request->input('schoolyear');
    $schoolname = $request->input('schoolname');




    $schoolid = DB::table('table_schoolname')->where('SchoolName', $schoolname)->first()->SchoolNameID;


    $schoolcourses = DB::table('table_schoolname')->join('table_course', 
    'table_schoolname.SchoolNameID', '=', 'table_course.SchoolNameID')
    ->where('table_schoolname.SchoolNameID', $schoolid)->get();  
      

      $countdatas = count($schoolcourses)/3;


    // dd(ceil($countdatas));
      // 
      return view('admin.courses')
      ->with('schoolname', $schoolname)
      ->with('countdatas', $countdatas)
      ->with('schoolcourses', $schoolcourses);
}


#endregion


#region submit
public static function  formSubmit(Request $request)
    {

       
      
        $validatedData = $request->validate([
          'subjectcode' => 'required',
          'subjectname' => 'required',
          'description' => 'required',
          'Units' => 'required',
          'type' => 'required',
          'typeofsubject' => 'required',
           'yearflwochart' => 'required',
            'termflowchart' => 'required',
          
         
        ]);
        

       
        DB::table('table_logs')->insert(
          ['AccountID' => Auth::id(), 'logtype' =>  "Created new subject name " .
           ucwords($request->input('subjectname')),
          'LogTime' => new DateTime("now", new DateTimeZone('Asia/Singapore'))
      ]);  
  
     
        $dt = new DateTime("now", new DateTimeZone('Asia/Singapore') );
        $post = new subjects;
        
       
        $post ->CourseID =  $request->input('submit');
        $post ->subjectcode = strtoupper($request->input('subjectcode'));
        $post ->subjectname = ucwords($request->input('subjectname'));
        $post ->descriptions= $request->input('description');
        $post ->units= $request->input('Units');
        $post->yearflwochart = $request->input('yearflwochart');
        $post->termflowchart = $request->input('termflowchart');
        $post->type = $request->input('type');
        $post->typeofsubject = $request->input('typeofsubject');
    //    $dt = new DateTime();
 
        $post->CreationDate =$dt;
        $post->save();


        


    //kuhanin yung mga ininput
        $topic = $request->input('topics');
        $subjectcode = $request->input('subjectcode');
        $topics = $request->input('topics');
        $professors = $request->input('professors');
        $year =  $request->input('year');
        $term =  $request->input('term');
        $units =  $request->input('Units');
        $type = $request->input('type');
        $course = $request->input('submit');
        
    
      //insert sa database yung electives na ininput

      $subjectid = DB::table('table_subjects')
      ->where('subjectcode', '=', $subjectcode)->first()->SubjectsID;

  

      //check kung may ininput ba sa topic

   
      if(!$topics){
        $topics = null;
    }
       //iiinput na sa subject topics lahat ng nilagay niya
  
       foreach($topics as $topic){

        DB::table('table_subjecttopics')->insert(
          ['SubjectsID' => $subjectid, 'topicname' =>  $topic]);     
        }
  
    //check kung mau ininput ba sa term level and year level

  
    if(!$year && !$term){
        $year = null;
        $term = null;
    }

  
    for ($x = 0; $x < count($year); $x++) {
      DB::table('table_subjectintake')->insert(
        ['SubjectsID' => $subjectid, 'yearlevel' =>  $year[$x] , 'termlevel' => $term[$x]]);
 
  }
 


    if(empty($professors[0])){

        $professors= null;
        DB::table('table_subjectsprofessors')->insert(
            ['SubjectsID' => $subjectid,  'professorsID' =>  $professors]);
     
         
      }else{    
    
  
       
        foreach($professors as $professor){
          $professorid = DB::table('table_professors')
          ->where('professorsname', '=', $professor)->first()->professorsID;
     
         DB::table('table_subjectsprofessors')->insert(
          ['SubjectsID' => $subjectid, 'professorsID' =>  $professorid]);

        }}

    
          



      //insert sa database yung units 

      //step 1 : get mo muna yung total units

      $temp="";
      if( $type == "nonacad")
      { 
        $temp ="nonacademicunitstotal";
      }
      elseif( $type == "acad")
      {
        $temp ="academicunitstotal";
      }
     
      $numberofunits = DB::table('table_course')
      ->where('CourseID', '=', $course)->first()->$temp;
        

      $numberofunits = $numberofunits + $units;
      //update na yung table
      DB::table('table_course')
      ->where('CourseID', $course)
      ->update([$temp => $numberofunits]);


      $subjectid =   DB::table('table_subjects')
      ->where('subjectcode',  $subjectcode)->first()->SubjectsID;

      
     DB::table('table_subjectstaken')->insert( 
      ['StudentID'=> 1, 'SubjectsID' => $subjectid, 
      'status' =>  "NewSubject"]);




    
 
     return back()->with('update', 'Updated!');

}
  
  #endregion

#region subject update
 public function update(Request $request){


        //--------- get input values
        $id = $request->input('submit');
        $subjectcode = $request->input('subjectcode');
        $subjectname = $request->input('subjectname');   
        $description = $request->input('description');  
        $Units = $request->input('Units');  
        $topics = $request->input('topics');  
       $sections = $request->input('sections');
       $professors = $request->input('professors');
       $yearflwochart = $request->input('yearflwochart');
       $termflowchart = $request->input('termflowchart');
       $year = $request->input('year');  
       $term = $request->input('term');

       $temporary = DB::table('table_subjects')->where('SubjectsID', '=', $id)->first()->CourseID;
  

       
       DB::table('table_logs')->insert(
        ['AccountID' => Auth::id(), 'logtype' =>  "Update subject id " . $id ,
        'LogTime' => new DateTime("now", new DateTimeZone('Asia/Singapore'))
    ]);
       //update
        $post = subjects::find($id);
      


       $courseid= DB::table('table_subjects')->where('SubjectsID', '=', $id)->first()->CourseID;
        
        $post ->subjectcode = $subjectcode;
        $post ->subjectname = $subjectname;
        $post ->descriptions = $description;
        $post ->units =    $Units;
        $post->type = $request->input('type');
        $post->typeofsubject = $request->input('typesubject');
        $post ->yearflwochart = $yearflwochart;
        $post ->termflowchart = $termflowchart;
       // $dt = new DateTime();
        $dt = new DateTime("now", new DateTimeZone('Asia/Singapore') );
        $post->ModifiedDate =$dt;
        $post->save();



       
//update subject topics

DB::table('table_subjecttopics')->where('SubjectsID', '=', $id)->delete();


foreach($topics as $topic){
  DB::table('table_subjecttopics')->insert(
    ['SubjectsID' => $id,  'topicname' =>  $topic]);
}



//update professor



DB::table('table_subjectsprofessors')->where('SubjectsID', '=', $id)->delete();


if(empty($professors[0])){

  $professor = null;

  DB::table('table_subjectsprofessors')->insert(
    ['SubjectsID' => $id,  'professorsID' =>  $professor]);

 
  
}else{
  foreach($professors as $professor){

    $idprof = DB::table('table_professors')->where('professorsname', $professor)->first();
  
  
    DB::table('table_subjectsprofessors')->insert(
      ['SubjectsID' => $id,  'professorsID' =>  $idprof->professorsID]);
  }
}



//update course all units


$type = $request->input('type');
if( $type == "nonacad")
{ 
  $temp ="nonacademicunitstotal";
 
}
elseif( $type == "acad")
{
  $temp ="academicunitstotal";
  
}





$datas = DB::table('table_subjects')
->where('type', '=', $type)->get(); 

$datatemp = 0;

foreach($datas as $data){
$datatemp += $data->units;
}





DB::table('table_course')
->where('CourseID', '=', $temporary)
->update([$temp => $datatemp]);


//update subject intake

DB::table('table_subjectintake')->where('SubjectsID', '=', $id)->delete();

$year = $request->input('year');  
$term = $request->input('term');

if(empty($year[0])||empty($term[0])){
  $year = null;
  $term = null;

}


foreach($year as $key => $years){
  DB::table('table_subjectintake')->insert(
    ['SubjectsID' => $id,  'yearlevel' =>  $years,'termlevel' =>  $term[$key]]);
}

$tempcourseid = DB::table('table_subjects')->where('SubjectsID', '=', $id)->first()->CourseID;


$routetemp = '/schoolcourses/' . $courseid. '/subject';


return redirect($routetemp)->with('successMsg', 'Record updated!');

 }
#endregion

#region course subjects
public function showsubject($id){

   // $posts = DB::table('table_subjects') ->where('SubjectsID', '=', $id)->get();
   $posts = subjects::where('CourseID', '=', $id)->get();
  
   $professors =  DB::table('table_professors')->get();
 //  $electives =  DB::table('table_electives')->get();

 /*
 $users = subjects::where([
  'CourseID', '=', $id,
 'column2' => value2,
])->get();
*/

$temporaryshit = 0;
$acadunit =0;
$nonacadunit = 0;

$Electives = 0;
$major = 0;
$minor =0;
foreach($posts as $post){

  if($post->type == "nonacad"){
    $nonacadunit += $post->units;
  }else{
    $acadunit += $post->units;
  }




  if($post->typeofsubject == "Electives"){
    $Electives++;
  }else if($post->typeofsubject == "Major"){

    $major++;
  }else if($post->typeofsubject == "Minor"){
    $minor++;
  }

}
$temporaryshit = $acadunit + $nonacadunit;

    $arrayinfo = array(count($posts),
    $temporaryshit,
    $acadunit,
    $nonacadunit,
    $Electives,
    $major,
    $minor
  );
     
  

  

   //dd( $electives );
    return view('admin.subject')
    ->with('posts',$posts)
    ->with('arrayinfo',$arrayinfo)
    ->with('professors',$professors)
   // ->with('electives',$electives)
    ->with('id',$id);

    
}
#endregion

#region subject description
public function showsubjectinfo($id, $idsubject){
// $posts=subjects::where(array('CourseID' => $id,'subjectcode' => $name)) ->get();
 
$subjectinfo = DB::table('table_subjects')->where('table_subjects.SubjectsID', $idsubject)->first();

$topics = DB::table('table_subjects')->join('table_subjecttopics', 'table_subjects.SubjectsID', '=', 'table_subjecttopics.SubjectsID')
->where('table_subjects.SubjectsID', $idsubject)->get();
  

$intake = DB::table('table_subjects')->join('table_subjectintake', 'table_subjects.SubjectsID', '=', 'table_subjectintake.SubjectsID')
->where('table_subjects.SubjectsID', $idsubject)->get();


$listofprofessors = DB::table('table_subjects')->join('table_subjectsprofessors', 'table_subjects.SubjectsID', '=', 'table_subjectsprofessors.SubjectsID')
->where('table_subjects.SubjectsID', $idsubject)->get();


/*
$electiveslist = DB::table('table_electiveslist')
->where('CourseID', $id)->get();

dd($electives);
*/

$professors =  DB::table('table_professors')->get(); 

    return view('admin.subjectinfo')
    ->with('info',$subjectinfo)
    ->with('idsubject',$idsubject)
    ->with('topics',$topics)  
    
    ->with('intake',$intake)
    ->with('listofprofessors',$listofprofessors)
    ->with('professors',$professors)
    ->with('id',$id);
 }
#endregion


#region course flowchart 
 public function showcourseflowchart($id){
    
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

  $courseid = DB::table('table_course')->where('CourseID', $id)
->first();
  
//dd($subjectsintake);
  return view('admin.flowchart')
  ->with('subjectinfo', $subjects)
  ->with('subjectintake', $subjectsintake)
  ->with('subjectprofessors', $subjectprofessors)
  ->with('professors', $professors)
 
  ->with('subjecttopics', $subjecttopics)
  ->with('courseid', $courseid);


  }
#endregion


#region delete
public function delete(Request $request ){
    
   DB::table('table_logs')->insert(
          ['AccountID' => Auth::id(), 'logtype' =>  "Deleted a subject ",
          'LogTime' => new DateTime("now", new DateTimeZone('Asia/Singapore'))
      ]);  
  
    // $posts = subjects::find($id);
    $subjectid = $request->input('delete');
    $temp = $request->input('temp');

   

    $post = subjects::find($temp);

   $post->delete();

    return back();
 }
 #endregion

}
