<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        
               <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
	                <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
                <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
            
               
              
                <link rel="stylesheet" type="text/css" href="{{ asset('css/admin.css') }}">


                <link rel="stylesheet" type="text/css" href="{{ asset('css/modal.css') }}">
     
                <link rel="stylesheet" type="text/css" href="{{ asset('sweetalert/sweetalert2.min.css  ')}}">
                  
   
                
           
                <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"/>
                <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/responsive/2.2.1/css/responsive.dataTables.min.css"/>
             
                
        
              <style>
                .navbar a {
                  float: left;
                  font-size: 20px;
                  color: white;
                  text-align: center;
                  padding: 30px;
                  text-decoration: none;
                }
                    .mb-6{
                  margin-top: -20px !important;
                }

                .left {
                  margin-left:5%;
                }
               
                </style>
    </head>
<body>

    <!--
       
 
    -->
  


    @yield('content')


 
</body>


<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script> 
<script src="{{ asset('sweetalert/sweetalert2.all.min.js')}}"></script>
<script src="https://momentjs.com/downloads/moment.js"></script>
<script src="https://momentjs.com/downloads/moment-with-locales.js"></script>
<script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js"></script>

</html>
       


@yield('javascriptcontent')