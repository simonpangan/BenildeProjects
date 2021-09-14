<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTableLogs extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_logs', function (Blueprint $table) {
            $table->increments('UserLogID');
            $table->integer('AccountID')->unsigned();
            $table->string('logtype');
            $table->datetime('LogTime');

            $table->foreign('AccountID')->references('AccountID')->on('table_accounts')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('table_logs');
    }
}
