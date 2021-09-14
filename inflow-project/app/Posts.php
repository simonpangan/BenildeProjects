<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Posts extends Model
{
    protected $table = 'posts';
    protected $primaryKey = 'ID';
    public $timestamps = false;

    protected $fillable = [
        'Firstname', 'Lastname', 'Quiz',
        'Seatwork', 'Homework', 'Midterm',
        'Final'
    ];
 
}
