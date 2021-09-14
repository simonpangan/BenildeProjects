<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Role extends Model
{

    protected $table = 'table_roles';
    protected $primaryKey = 'RoleID';
    
    public function users(){
        return $this->hasMany('App\User');
 
    }

}
