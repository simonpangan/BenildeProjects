<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateTableAccounts extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('table_accounts', function (Blueprint $table) {
            $table->increments('AccountID');
            $table->Integer('RoleID')->unsigned();
            $table->Integer('IdNumber')->nullable();
            
            $table->string('FirstName')->nullable();
            $table->string('MiddleName')->nullable();
            $table->string('LastName')->nullable();
            $table->string('email')->nullable();
            $table->string('password')->nullable();
            $table->string('contactnumber')->nullable();
            $table->string('address')->nullable();
            $table->string('image')->nullable();
            $table->dateTime('created_at')->nullable();
            $table->dateTime('updated_at')->nullable();

        


            $table->foreign('RoleID')->references('RoleID')->on('table_roles')->onDelete('cascade');
  
           
            
            

        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('table_accounts');
    }
}
