<?php

use Illuminate\Database\Seeder;

class table_schoolnameSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {

        $data =[
            ['SchoolName'=>'Deaf Education and Applied Studies'],
            ['SchoolName'=>'Hotel, Restaurant and Institution Management'],
            ['SchoolName'=>'Diplomacy and Governance'],
            ['SchoolName'=>'Design and Arts'],
            ['SchoolName'=>'Management and Information Technology'],
        ];
        DB::table('table_schoolname')->insert($data);
        $data2 =[
            ['SchoolNameID'=>'5','coursename' => "Human Resource Management"],
            ['SchoolNameID'=>'3','coursename' => "Consular and Diplomatic Affairs"],
            ['SchoolNameID'=>'3','coursename' => "Governance and Public Affairs"],
            ['SchoolNameID'=>'3','coursename' => "Diplomacy and International Affairs"],
            ['SchoolNameID'=>'4','coursename' => "Industrial Design"],
            ['SchoolNameID'=>'2','coursename' => "International Hospitality Management"],
            ['SchoolNameID'=>'4','coursename' => "Multimedia Arts"],
            ['SchoolNameID'=>'2','coursename' => "Culinary Arts"],
            ['SchoolNameID'=>'2','coursename' => "Hospitality Management"],
            ['SchoolNameID'=>'5','coursename' => "Export Management"],
            ['SchoolNameID'=>'4','coursename' => "Film"],
            ['SchoolNameID'=>'1','coursename' => "Deaf Education and Applied Studies"],
  
        ];
        DB::table('table_course')->insert($data2);

    /*
        $data2 =[
            ['SchoolNameID'=>'1','coursename' => "Deaf Education and Applied Studies"],
            ['SchoolNameID'=>'2','coursename' => "Culinary Arts"],
            ['SchoolNameID'=>'2','coursename' => "Hospitality Management"],
            ['SchoolNameID'=>'2','coursename' => "Travel and Tourism Management"],
            ['SchoolNameID'=>'2','coursename' => "International Hospitality Management"],
            ['SchoolNameID'=>'3','coursename' => "Consular and Diplomatic Affairs"],
            ['SchoolNameID'=>'3','coursename' => "Diplomacy and International Affairs"],
            ['SchoolNameID'=>'3','coursename' => "Governance and Public Affairs"],
            ['SchoolNameID'=>'4','coursename' => "Animation"],
            ['SchoolNameID'=>'4','coursename' => "Arts Management"],
            ['SchoolNameID'=>'4','coursename' => "Film"],
            ['SchoolNameID'=>'4','coursename' => "Multimedia Arts"],
            ['SchoolNameID'=>'4','coursename' => "Music Production"],
            ['SchoolNameID'=>'4','coursename' => "Photography"],
            ['SchoolNameID'=>'4','coursename' => "Production Design"],
            ['SchoolNameID'=>'4','coursename' => "Fashion Design and Merchandising"],
            ['SchoolNameID'=>'4','coursename' => "Theater Arts"],
            ['SchoolNameID'=>'4','coursename' => "Dance"],
            ['SchoolNameID'=>'4','coursename' => "Architecture"],
            ['SchoolNameID'=>'4','coursename' => "Industrial Design"],
            ['SchoolNameID'=>'4','coursename' => "Interior Design"],
            ['SchoolNameID'=>'5','coursename' => "Business Intelligence and Analytics"],
            ['SchoolNameID'=>'5','coursename' => "Computer Applications"],
            ['SchoolNameID'=>'5','coursename' => "Export Management"],
            ['SchoolNameID'=>'5','coursename' => "Human Resource Management"],
            ['SchoolNameID'=>'5','coursename' => "Real Estate Management"],
    
            ['SchoolNameID'=>'5','coursename' => "Interactive Entertainment and Multimedia Computing"],
            ['SchoolNameID'=>'5','coursename' => "Business Management"],
            ['SchoolNameID'=>'5','coursename' => "Marketing Management"],
        ];
        DB::table('table_course')->insert($data2);
*/
   

       DB::table('table_course')->insert(
           
    ['SchoolNameID'=>'5',
    'coursename' => "Information Systems",
    'academicunitstotal' => 0,
    'nonacademicunitstotal' => 0 ],);
        /*
        
        $data3 =[
            ['CourseID'=>'27','subjectcode' => "FUNPROG"],
            ['CourseID'=>'27','subjectcode' => "WEBDEV"],
            ['CourseID'=>'27','subjectcode' => "INTEPRO"],
            ['CourseID'=>'27','subjectcode' => "ENTPROG"],
            ['CourseID'=>'27','subjectcode' => "DSTALGO "],
        
      
      
        ];
        DB::table('table_subjects')->insert($data3);

        */



        $data4 =[
            ['professorsname' => "Abram John Limpin"],
            ['professorsname' => "Angel Martin Manansala"],
            ['professorsname' => "Oliver Liwanag"],
            ['professorsname' => "Catherine Mojado"],
            ['professorsname' => "Eisen Lewis Sy"],
            ['professorsname' => "Roger Del Cano"],
        ];
        DB::table('table_professors')->insert($data4);

/*
        $data5 =[
            ['sectionsname' => "TI101"],
            ['sectionsname' => "TI102"],
            ['sectionsname' => "TI103"],
            ['sectionsname' => "TI001"],
            ['sectionsname' => "TI002"],
            ['sectionsname' => "TI003"],
         
        ];
        DB::table('table_sections')->insert($data5);
*/
        /*
        $adada =[
            ['CourseID' => "30",'ElectivesName' => "infosec"],
            ['CourseID' => "30",'ElectivesName' => "dataman"],
            ['CourseID' => "30",'ElectivesName' => "extremeprog"],
            
        
        ];
        DB::table('table_electives')->insert($adada);
*/

    }
}
