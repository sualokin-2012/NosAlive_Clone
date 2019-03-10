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
		location.href='/Group_Project/GettingHere.html';
	}
	
function LineupPage(){
		location.href='/Group_Project/LineupPage.html';
	}
	
	
function FAQ(){
		location.href='/Group_Project/FAQ.html';
	}
	
	
function nosalive(){
		location.href='/Group_Project/nosalive.html';
	}
	
	
function ticket(){
		location.href='/Group_Project/ticket.html';
	}
	
function sponsors(){
		location.href='/Group_Project/sponsors.html';
	}
function atthefestival(){
		location.href='/Group_Project/atthefestival.html';
	}

function schedule(){
		location.href='/Group_Project/images/Lineup/allLineUp.jpg';
}
	
	
