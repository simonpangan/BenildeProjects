<?php

namespace App;

use Illuminate\Database\Eloquent\Model;
use App\school;


class course extends Model
{
    protected $table = 'table_course';
    // primary key
    public $primaryKey = 'CourseID';
    //Timestamps
    public $timestamps = false;


    public function school(){
        return $this->hasOne('App\school');
    }
    
}
