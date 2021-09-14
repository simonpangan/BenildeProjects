<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTableStudents extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_students', function (Blueprint $table) {
            $table->increments('StudentID');
            $table->Integer('CourseID')->unsigned();
            $table->string('start_schoolyear')->nullable();
            $table->string('current_schoolyear')->nullable();
            $table->float('unitsearned', 8, 2)->nullable();
            $table->float('remainingunits', 8, 2)->nullable();  
            $table->float('totalacademicunitsearn', 8, 2)->nullable();
            $table->float('totalnonacademincunitsearn', 8, 2)->nullable();  

                
            $table->foreign('CourseID')->references('CourseID')->on('table_course')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('table_students');
    }
}
