<?php

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\Hash;

class StudentSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
                //---

        $asdasda =[
            ['RoleName' => 'Student'],
            ['RoleName' => 'Admin'],
        ];
        DB::table('table_roles')->insert($asdasda);


        //------------


        $asdasasdda =[
            ['RoleID' => '1',
            'IdNumber' => '11818027',
            'FirstName' => 'Simon Joseph',
            'MiddleName' => 'Umali',
            'LastName' => 'Pangan',
            'email' => 'simon_pangan@yahoo.com',
            'password' =>  Hash::make('simonpangan')
            ], 
            ['RoleID' => '2',
            'IdNumber' => '11817331',
            'FirstName' => 'Simon Joseph',
            'MiddleName' => 'Umali',
            'LastName' => 'Pangan',
            'email' => 'admin@yahoo.com',
            'password' =>  Hash::make('admin123')
            ],
        ];

        DB::table('table_accounts')->insert($asdasasdda);



        $asdasasddaasdas =[
            ['CourseID' => '13',
            'start_schoolyear'=> 2018-2019,
            'unitsearned' => '89',
            'remainingunits' => '91',
            'totalacademicunitsearn' => '80',
            'totalnonacademincunitsearn' => '9',
         ], 
       
        ];

        DB::table('table_students')->insert($asdasasddaasdas);
       
       
        /*
       
        $data4 =[
            ['CourseID' =>  13,'totalacademicunitsearn' => 0, 'totalnonacademincunitsearn' => 0],
         
        ];
        DB::table('table_students')->insert($data4);

        */
        $data10=[
            ['SubjectsID' => 1, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 2, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 3, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 4, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 5, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 6, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 7, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 8, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 9, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 10, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 11, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 12, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 13, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 14, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 15, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 16, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 17, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 18, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 19, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 20, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 21, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 22, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 23, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 24, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 25, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 26, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 27, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 28, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 29, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 30, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 31, 'StudentID' => 1, 'status' => "Passed"],
            ['SubjectsID' => 32, 'StudentID' => 1, 'status' => "Enrolled"],
            ['SubjectsID' => 33, 'StudentID' => 1, 'status' => "Enrolled"],
            ['SubjectsID' => 34, 'StudentID' => 1, 'status' => "Enrolled"],
            ['SubjectsID' => 35, 'StudentID' => 1, 'status' => "Enrolled"],
            ['SubjectsID' => 36, 'StudentID' => 1, 'status' => "Enrolled"],
            ['SubjectsID' => 37, 'StudentID' => 1, 'status' => "Enrolled"],

            ['SubjectsID' => 38, 'StudentID' => 1, 'status' => "Enlisted"],
            ['SubjectsID' => 39, 'StudentID' => 1, 'status' => "Enlisted"],
            ['SubjectsID' => 40, 'StudentID' => 1, 'status' => "Enlisted"],
            ['SubjectsID' => 41, 'StudentID' => 1, 'status' => "Enlisted"],
            ['SubjectsID' => 42, 'StudentID' => 1, 'status' => "Enlisted"],
            ['SubjectsID' => 43, 'StudentID' => 1, 'status' => "Enlisted"],

            ['SubjectsID' => 44, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 45, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 46, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 47, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 48, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 49, 'StudentID' => 1, 'status' => "Unenlisted"],

            ['SubjectsID' => 50, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 51, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 52, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 53, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 54, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 55, 'StudentID' => 1, 'status' => "Unenlisted"],

            ['SubjectsID' => 56, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 57, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 58, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 59, 'StudentID' => 1, 'status' => "Unenlisted"],
            ['SubjectsID' => 60, 'StudentID' => 1, 'status' => "Enlistable"],

            ['SubjectsID' => 61, 'StudentID' => 1, 'status' => "Unenlisted"],


        
         ];

         DB::table('table_subjectstaken')->insert($data10);
         
    }
}
