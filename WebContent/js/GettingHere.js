$(document).ready(function(){
	

	
	$('div.air_1').click(function(){
		$('img.iconrot').eq(0).toggleClass('rotationicon');
		$(this).toggleClass('changeBackground');
		$('div.air_2').slideToggle();
	});
	
	$('div.air_3').click(function(){
		$('img.iconrot').eq(1).toggleClass('rotationicon');
		$(this).toggleClass('changeBackground');
		$('div.air_4').slideToggle();
	});
	
	
	$('div.tra_1').click(function(){
		$('img.iconrot').eq(2).toggleClass('rotationicon');
		$(this).toggleClass('changeBackground');
		$('div.tra_2').slideToggle();
	});
	
	$('div.tra_3').click(function(){
		$('img.iconrot').eq(3).toggleClass('rotationicon');
		$(this).toggleClass('changeBackground');
		$('div.tra_4').slideToggle();
	});
	
	$('div.bus_1').click(function(){
		$('img.iconrot').eq(4).toggleClass('rotationicon');
		$(this).toggleClass('changeBackground');
		$('div.bus_2').slideToggle();
	});
	
	$('div.bus_3').click(function(){
		$('img.iconrot').eq(5).toggleClass('rotationicon');
		$(this).toggleClass('changeBackground');
		$('div.bus_4').slideToggle();
	});
	
	$('div.bus_5').click(function(){
		$('img.iconrot').eq(6).toggleClass('rotationicon');
		$(this).toggleClass('changeBackground');
		$('div.bus_6').slideToggle();
	});
});
	
	
	
	