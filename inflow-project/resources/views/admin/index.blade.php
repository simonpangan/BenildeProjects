@extends('layouts.main')



@section('content')

@include('layouts.header')
<br>
<br>
<br>
<br>
<div class="container">
      <div class="row">
           <div class="col">
              <table width="200">
              
                  <tbody>
                      <tr>
                          <td colspan="20" valign="top" style="border:#3b9c3d thin solid">
                              <div class="content" align="center">
                                  <br><br>
                                  2nd Term, 2019-2020<br><br>
                                
                                  {{Auth::user()->LastName}},  {{Auth::user()->FirstName}}
                                  
                                  @php
                                    $string = Auth::user()->MiddleName;
                                  echo $string[0];
                                   @endphp
                                  
                                  <br><br>
                                11817331<br><br>
                                Admin<br><br>
                                <br><br>
                              </div>
                          </td>	
                      </tr>
                  </tbody>
              </table>
          </div>
          <div class="col-8">
              <br>
              <font color="red">*</font>Required Field
              <br><br> 
              <form action="{{ url('schoolcourses')}}" method="get">
              
  
                    @csrf

                  <div class="form-group row">
                      <label class="col-sm-2 col-form-label"><h6><font color="red">*</font>SY:</h6></label>
                      <div class="col-sm-10">
                          <select class="form-control form-control-sm" style="width: 110px;" name="schoolyear" required>
                          <option></option>
                          <option>2019-2020</option>
                          </select>
                    </div>
                  </div>

                  <div class="form-group row">
                      <label class="col-sm-2 col-form-label"><h6><font color="red">*</font>School:</h6></label>
                      <div class="col-sm-10">
                          <select class="form-control form-control-sm" style="width: 110px;" name="schoolname" required>
                          <option value="">Select Type</option>
                          <option value="Deaf Education and Applied Studies">SDEAS</option>
                          <option value="Hotel, Restaurant and Institution Management">
                            SHRIM</option>
                          <option value="Diplomacy and Governance">SDG</option>
                          <option value="Design and Arts">SDA</option>
                          <option value="Management and Information Technology">
                            SMIT</option>
                        </select>
                    </div>
                  </div>
                  <button type="submit" class="btn btn-outline-success">View Courses</button>
              </form>
          </div>
      </div>
</div>

@endsection