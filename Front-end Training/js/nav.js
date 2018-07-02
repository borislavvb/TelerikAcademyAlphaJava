var nav = document.getElementById('nav');

window.onscroll = function(){
    
    if(window.pageYoffset > 100){
        nav.style.background = white;
        nav.style.boxShadow = "0px 4px 2px yellow";
    }
    else{
        nav.style.background = "transparent";
        nav.style.boxShadow = "none";

    }
}