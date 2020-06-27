// Função escrita por Guilherme Grillo
$(function(){
	var words = ['SOBRE O RAFAEL'];
	var indexWord = 0;
	var indexChar = 0;
	var interval;
	var elInput = $('.sobre input[type=text]'); 

	// elInput.focus();
	
	run();

	function run(){
		interval = setInterval(function(){
				if(indexChar < words[indexWord].length){
					indexChar++;
					elInput.val(words[indexWord].substr(0,indexChar));	
				}else if(indexWord < words.length-1){
					indexWord++;
					indexChar = 0;
				}else{
					//Deixa a palavra na tela pr 5 segundos antes de recomeçar
					indexWord = 0;
					indexChar = 0;		
					clearInterval(interval);
					setTimeout(function(){
						run();
					},1600)
				}			
		},400);	
	}
})