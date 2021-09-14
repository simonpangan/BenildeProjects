<div class="logo">
    <a href="#">
    <img src="{{ asset('img/benilde.png') }}"> </a>
</div>

<nav>
    
    <div class="navbar">
        <ul class="h1 navbar-nav ml-auto">
            <li><a href="{{ route('logout') }}"
                onclick="event.preventDefault();
                              document.getElementById('logout-form').submit();">
                 {{ __('Logout') }}
                </a>
                
                <form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
                 @csrf
                </form>
                
            
           </li>
        </ul>
    </div>
</nav>