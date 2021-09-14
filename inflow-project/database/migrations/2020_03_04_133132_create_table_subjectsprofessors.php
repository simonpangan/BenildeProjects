<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTableSubjectsprofessors extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_subjectsprofessors', function (Blueprint $table) {
            $table->Increments('SubjectProfessorID')->unsigned();
            $table->Integer('SubjectsID')->unsigned();
          //   $table->Integer('sectionsid')->unsigned()->nullable();
            $table->Integer('professorsID')->unsigned()->nullable();
         
 
           // $table->foreign('sectionsid')->references('sectionsid')->on('table_sections')->onDelete('cascade');
            $table->foreign('SubjectsID')->references('SubjectsID')->on('table_subjects')->onDelete('cascade');
            $table->foreign('professorsID')->references('professorsID')->on('table_professors')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('table_subjectsprofessors');
    }
}
