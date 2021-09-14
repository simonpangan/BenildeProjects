<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateSubjectsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_subjects', function (Blueprint $table) {
            $table->increments('SubjectsID');
            $table->integer('CourseID')->unsigned();
            $table->char('subjectcode',8)->nullable();
            $table->char('subjectname',100)->nullable();
       //     $table->char('title',100)->nullable();
            $table->longText('descriptions')->nullable();
            $table->float('units')->nullable();
            $table->char('type',20)->nullable();
            $table->char('typeofsubject',20)->nullable();
        //    $table->char('track',20)->nullable();
            $table->integer('yearflwochart')->nullable();
            $table->integer('termflowchart')->nullable();
       //     $table->string('coursename',100)->nullable();
            $table->dateTime('CreationDate')->nullable();
            $table->dateTime('ModifiedDate')->nullable();
          //  $table->Integer('WrittenByAccountID')->unsigned();
            //$table->Integer('LastModifiedByAccountID')->unsigned()->nullable();



            $table->foreign('CourseID')->references('CourseID')->on('table_course')->onDelete('cascade');;
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('subjects');
    }
}
