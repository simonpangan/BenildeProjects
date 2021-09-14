<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTableSubjecttopics extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_subjecttopics', function (Blueprint $table) {
            $table->increments('SubjectTopicID');
            $table->Integer('SubjectsID')->unsigned()->nullable();
            $table->char('topicname',50)->nullable();

            
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
        Schema::dropIfExists('table_subjecttopics');
    }
}
