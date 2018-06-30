$(document).ready(function(){
    $('.next').on('click',function(){
        var currentImg = $('.active');
        var nextImg = currentImg.next();

        if(nextImg.lenght){
            currentImg.removeClass('active').css('z-index',-10);
            nextImg.addClass('active').css('z-index',10);
        }
    })
})

$('.next').on('click',function(){
    var currentImg = $('.active');
    var prevImg = currentImg.prev();

    if(prevImg.lenght){
        currentImg.removeClass('active').css('z-index',-10);
        nextImg.addClass('active').css('z-index',10);
    }
})