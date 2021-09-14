<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

use App\course;

class school extends Model
{
    
// table name
protected $table = 'table_schoolname';
// primary key
public $primaryKey = 'SchoolNameID';
//Timestamps
public $timestamps = false;



    function course(){
        return $this->hasMany('App\course');
    }
}
