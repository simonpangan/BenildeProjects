<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTableSubjectstaken extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_subjectstaken', function (Blueprint $table) {
            $table->increments('SubjectTakenID');
            $table->integer('StudentID')->unsigned();
            $table->integer('SubjectsID')->unsigned();
            $table->char('status',10)->nullable();
   

            $table->foreign('StudentID')->references('StudentID')->on('table_students')->onDelete('cascade');
            $table->foreign('SubjectsID')->references('SubjectsID')->on('table_subjects')->onDelete('cascade');
      
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('table_subjectstaken');
    }
}
