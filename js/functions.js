$(function(){    
    var menuLateralAltura = $('.menuLateral').height();    
    var seta = $('.fa-angle-double-down');    
    var distSetaAteTopo = calculaDist();
    var menuMobile = $('.fa-bars');
    var slideProjeto = $('.slider');
    

    //Exibe o menu Mobile
    menuMobile.click(function(){
        $('.menuMobile').fadeIn();
        $('.fa-times').fadeIn();
    })

    //Some com o menuMobile ao clicar no botão de fechar
    $('.fa-times').click(function(){
        $('.menuMobile').fadeOut();
        $(this).fadeOut();
    })
    
    //Recalcula a distância do nosso Menu ao entrarmos no responsivo.
    $(window).resize(function(){         
        distSetaAteTopo = calculaDist();        
    })

     //Animação ao clicarmos na seta
    seta.click(function(){
        $('html, body').animate({'scrollTop': distSetaAteTopo}, 1000);
    })

    //TO DO
    // $('.sliderSingle').click(function(){
    //     var el = $(this);
    //     verificarLinksProjetos(el);
    // })

    

    function verificarLinksProjetos(el) {
        console.log(el.attr('attr'));
    }

    $('.mockup1').click(function(){
        // var el = $(this);        
        window.open("projetos/Projeto02/index.html");
    })

    $('.mockup2').click(function(){
        window.open("projetos/Projeto03/index.html");
    })

    $('.mockup3').click(function(){            
        window.open("projetos/Projeto04/index.html");
    })

    $('.mockup4').click(function(){             
        window.open("projetos/Projeto05/index.html");
    })


    //Scroll suave no menu
    $('.menuDesktop ul li a').click(scrollSuave);
    $('section.mainHomePage a').click(scrollSuave);

    
    //Configuração do slider
    slideProjeto.slick({
        'infinite': true,
        'slidesToShow': 1,
        'arrows': false,
        'dots': true,
        'autoplay': true,
        'autoplaySpeed': 3000,
        'pauseOnHover': false,
        'pauseOnFocus': false,
        'speed': 2000,
    });


    //Ao clicarmos em qlqr item do nosso menu Mobile
    //Fecha o menu e o botão de fechar e realiza animação até determinada section.
    $('.menuMobile li a').click(function(){
        event.preventDefault();
        $('.menuMobile').fadeOut();
        $('.fa-times').hide();
        var href = $(this).attr('href');
        var offsetTop = $(href).offset().top;
        $('html, body').animate({'scrollTop': offsetTop - menuLateralAltura},1000)
    });
    
    
   
  

    function scrollSuave() {
        //ID de cada elemento que clicarmos
        var href = $(this).attr('href');

        var offsetTop = $(href).offset().top;

        $('html, body').animate({'scrollTop': offsetTop},1000)
        
        //Evitar que nossa página fique sem animação
        event.preventDefault();
    }

    function calculaDist() {
        if ($(window).width() > 768) {
            distSetaAteTopo = $('.projetos').offset().top;
        } else {
            distSetaAteTopo = $('.projetos').offset().top - menuLateralAltura;
        }
            return distSetaAteTopo
    }

})


