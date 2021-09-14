<?php

use Illuminate\Database\Seeder;
use App\subjects;
class SubjectSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {

       


 
        $data7=[
        ['CourseID' => 13, 'subjectcode' => "INCOMPU"],
        ['CourseID' => 13, 'subjectcode' => "FUNDSYS"],
        ['CourseID' => 13, 'subjectcode' => "ITINFRA"],
        ['CourseID' => 13, 'subjectcode' => "UNDSELF"],
        ['CourseID' => 13, 'subjectcode' => "MATWRLD"],
        ['CourseID' => 13, 'subjectcode' => "CRITHNK"],
        ['CourseID' => 13, 'subjectcode' => "PEONEPF"],
        ['CourseID' => 13, 'subjectcode' => "CSBLIFE"],
        ['CourseID' => 13, 'subjectcode' => "FUNPROG"],
        ['CourseID' => 13, 'subjectcode' => "ISDBASE"],
        ['CourseID' => 13, 'subjectcode' => "PROFISS"],
        ['CourseID' => 13, 'subjectcode' => "BUSPROC"],
        ['CourseID' => 13, 'subjectcode' => "PURPCOM"],
        ['CourseID' => 13, 'subjectcode' => "BIBCHUR"],
        ['CourseID' => 13, 'subjectcode' => "PETWODA"],
        ['CourseID' => 13, 'subjectcode' => "NSTP-01"],
        ['CourseID' => 13, 'subjectcode' => "APPDEVT"],
        ['CourseID' => 13, 'subjectcode' => "INTEPRO"],
        ['CourseID' => 13, 'subjectcode' => "DSTALGO"],
        ['CourseID' => 13, 'subjectcode' => "LEADMGT"],
        ['CourseID' => 13, 'subjectcode' => "SCITECH"],
        ['CourseID' => 13, 'subjectcode' => "MARFAMI"],
        ['CourseID' => 13, 'subjectcode' => "PETRIID"],
        ['CourseID' => 13, 'subjectcode' => "NSTP-02"],
        ['CourseID' => 13, 'subjectcode' => "APPINTR"],
        ['CourseID' => 13, 'subjectcode' => "ENTPROG"],
        ['CourseID' => 13, 'subjectcode' => "INFOMGT"],
        ['CourseID' => 13, 'subjectcode' => "BUSSFIN"],
        ['CourseID' => 13, 'subjectcode' => "SYSANDE"],
        ['CourseID' => 13, 'subjectcode' => "REEXSPI"],
        ['CourseID' => 13, 'subjectcode' => "PEFORTS"],
        ['CourseID' => 13, 'subjectcode' => "APPADVC"],
        ['CourseID' => 13, 'subjectcode' => "WEBDEVT"],
        ['CourseID' => 13, 'subjectcode' => "MANSTRA"],
        ['CourseID' => 13, 'subjectcode' => "PROJMGT"],
        ['CourseID' => 13, 'subjectcode' => "ARTAPRI"], 
         ['CourseID' => 13, 'subjectcode' => "INTEFIL"],
        ['CourseID' => 13, 'subjectcode' => "ISELEC1"],
        ['CourseID' => 13, 'subjectcode' => "MOBDEVT"],
        ['CourseID' => 13, 'subjectcode' => "HUMANCI"],
        ['CourseID' => 13, 'subjectcode' => "ENTARCH"],
        ['CourseID' => 13, 'subjectcode' => "CONWORL"],
        ['CourseID' => 13, 'subjectcode' => "FILDISI"],
        ['CourseID' => 13, 'subjectcode' => "ISELEC2"],
        ['CourseID' => 13, 'subjectcode' => "ISRSRCH"],
        ['CourseID' => 13, 'subjectcode' => "DESPTRN"],
        ['CourseID' => 13, 'subjectcode' => "QUANT-T"],
        ['CourseID' => 13, 'subjectcode' => "IETHICS"],
        ['CourseID' => 13, 'subjectcode' => "JORIZAL"],
        ['CourseID' => 13, 'subjectcode' => "ISELEC3"],
        ['CourseID' => 13, 'subjectcode' => "ISPROJ1"],
        ['CourseID' => 13, 'subjectcode' => "SOFTEST"],
        ['CourseID' => 13, 'subjectcode' => "BUSEVAL"],
        ['CourseID' => 13, 'subjectcode' => "LITEPOP"],
        ['CourseID' => 13, 'subjectcode' => "READHIS"],
        ['CourseID' => 13, 'subjectcode' => "ISELEC4"],
        ['CourseID' => 13, 'subjectcode' => "ISPROJ2"],
        ['CourseID' => 13, 'subjectcode' => "ISENTRP"],
        ['CourseID' => 13, 'subjectcode' => "ASEANST"],
        ['CourseID' => 13, 'subjectcode' => "CSBGRAD"],
        ['CourseID' => 13, 'subjectcode' => "ISPRACT"],
    

        ];
        DB::table('table_subjects')->insert($data7);

        $data8=[
            ['SubjectsID' => 1, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 2, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 3, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 4, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 5, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 6, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 7, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 8, 'yearflwochart' => 1, 'termflowchart' => 1],
            ['SubjectsID' => 9, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 10, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 11, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 12, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 13, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 14, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 15, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 16, 'yearflwochart' => 1, 'termflowchart' => 2],
            ['SubjectsID' => 17, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 18, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 19, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 20, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 21, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 22, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 23, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 24, 'yearflwochart' => 1, 'termflowchart' => 3],
            ['SubjectsID' => 25, 'yearflwochart' => 2, 'termflowchart' => 1],
            ['SubjectsID' => 26, 'yearflwochart' => 2, 'termflowchart' => 1],
            ['SubjectsID' => 27, 'yearflwochart' => 2, 'termflowchart' => 1],
            ['SubjectsID' => 28, 'yearflwochart' => 2, 'termflowchart' => 1],
            ['SubjectsID' => 29, 'yearflwochart' => 2, 'termflowchart' => 1],
            ['SubjectsID' => 30, 'yearflwochart' => 2, 'termflowchart' => 1],
            ['SubjectsID' => 31, 'yearflwochart' => 2, 'termflowchart' => 1],
            ['SubjectsID' => 32, 'yearflwochart' => 2, 'termflowchart' => 2],
            ['SubjectsID' => 33, 'yearflwochart' => 2, 'termflowchart' => 2],
            ['SubjectsID' => 34, 'yearflwochart' => 2, 'termflowchart' => 2],
            ['SubjectsID' => 35, 'yearflwochart' => 2, 'termflowchart' => 2],
            ['SubjectsID' => 36, 'yearflwochart' => 2, 'termflowchart' => 2],
            ['SubjectsID' => 37, 'yearflwochart' => 2, 'termflowchart' => 2],

            ['SubjectsID' => 38, 'yearflwochart' => 2, 'termflowchart' => 3],
            ['SubjectsID' => 39, 'yearflwochart' => 2, 'termflowchart' => 3],
            ['SubjectsID' => 40, 'yearflwochart' => 2, 'termflowchart' => 3],
            ['SubjectsID' => 41, 'yearflwochart' => 2, 'termflowchart' => 3],
            ['SubjectsID' => 42, 'yearflwochart' => 2, 'termflowchart' => 3],
            ['SubjectsID' => 43, 'yearflwochart' => 2, 'termflowchart' => 3],

            ['SubjectsID' => 44, 'yearflwochart' => 3, 'termflowchart' => 1],
            ['SubjectsID' => 45, 'yearflwochart' => 3, 'termflowchart' => 1],
            ['SubjectsID' => 46, 'yearflwochart' => 3, 'termflowchart' => 1],
            ['SubjectsID' => 47, 'yearflwochart' => 3, 'termflowchart' => 1],
            ['SubjectsID' => 48, 'yearflwochart' => 3, 'termflowchart' => 1],
            ['SubjectsID' => 49, 'yearflwochart' => 3, 'termflowchart' => 1],

            ['SubjectsID' => 50, 'yearflwochart' => 3, 'termflowchart' => 2],
            ['SubjectsID' => 51, 'yearflwochart' => 3, 'termflowchart' => 2],
            ['SubjectsID' => 52, 'yearflwochart' => 3, 'termflowchart' => 2],
            ['SubjectsID' => 53, 'yearflwochart' => 3, 'termflowchart' => 2],
            ['SubjectsID' => 54, 'yearflwochart' => 3, 'termflowchart' => 2],
            ['SubjectsID' => 55, 'yearflwochart' => 3, 'termflowchart' => 2],

            ['SubjectsID' => 56, 'yearflwochart' => 3, 'termflowchart' => 3],
            ['SubjectsID' => 57, 'yearflwochart' => 3, 'termflowchart' => 3],
            ['SubjectsID' => 58, 'yearflwochart' => 3, 'termflowchart' => 3],
            ['SubjectsID' => 59, 'yearflwochart' => 3, 'termflowchart' => 3],
            ['SubjectsID' => 60, 'yearflwochart' => 3, 'termflowchart' => 3],

            ['SubjectsID' => 61, 'yearflwochart' => 4, 'termflowchart' => 1],


        
         ];

         foreach ($data8 as ["SubjectsID" => $id, "yearflwochart" => $year,"termflowchart" => $term]) {
            $post = subjects::find($id);
            $post ->yearflwochart = $year;
            $post ->termflowchart = $term;
         
            $post->save();
        }
        DB::table('table_subjects')
        ->update(['type'=> 'nonacad']);
    
       
       
        DB::table('table_subjects')
        ->update(['typeofsubject'=> 'Major']);
    
       

       


        }
}
