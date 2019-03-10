$(document).ready(function(){
	
	
	
	
	$('div.login').hide();
		
	
	
	
	$('div.buy_box').on('click',function(){
		$('div.login').fadeToggle();
		
	});
	

						
	
		
		
	$('div.menu_buttn').on('click',function(){
		$('div.gnb').slideToggle(1000);
		
	});
		
	$('div.gnb>ul>li.men3').on('click',function(){
							$('.temp_02').slideToggle();
						
							
	});
	
	$('div.gnb>ul>li.men2').on('click',function(){
							$('.temp_03').slideToggle();
							
	});

	
	$(window).resize(function(){
		
		if($('body').width()>768){
			$("div.gnb").hide();
			
		}});
	
	
	
	});
	

function GettingHere(){
		location.href='/NosAlive_Clone/GettingHere.html';
	}
	
function LineupPage(){
		location.href='/NosAlive_Clone/LineupPage.html';
	}
	
	
function FAQ(){
		location.href='/NosAlive_Clone/FAQ.html';
	}
	
	
function nosalive(){
		location.href='/NosAlive_Clone/nosalive.html';
	}
	
	
function ticket(){
		location.href='/NosAlive_Clone/ticket.html';
	}
	
function sponsors(){
		location.href='/NosAlive_Clone/sponsors.html';
	}
function atthefestival(){
		location.href='/NosAlive_Clone/atthefestival.html';
	}

function schedule(){
		location.href='/NosAlive_Clone/images/Lineup/allLineUp.jpg';
}
	
	
