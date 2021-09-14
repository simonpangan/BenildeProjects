<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class subjects extends Model
{
    //

    protected $table = 'table_subjects';
    protected $primaryKey = 'SubjectsID';
    public $timestamps = false;

    protected $fillable = ['CourseID','subjectcode'

];

}
