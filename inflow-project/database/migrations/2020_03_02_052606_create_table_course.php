<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTableCourse extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_course', function (Blueprint $table) {
            $table->increments('CourseID');
            $table->integer('SchoolNameID')->unsigned();
            $table->string('coursename',100);
            $table->float('academicunitstotal', 8, 2)->nullable();
            $table->float('nonacademicunitstotal', 8, 2)->nullable();
        

            $table->foreign('SchoolNameID')->references('SchoolNameID')->on('table_schoolname');
     
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('table_course');
    }
}
