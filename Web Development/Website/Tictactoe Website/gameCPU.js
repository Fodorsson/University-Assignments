var count = 0;
var gameover = false;

function displayLetter(id){
	
	if (document.getElementById(id).innerHTML == "" && !gameover){
	
		document.getElementById(id).innerHTML="X";
		
		if (count==0){
			if (id!=5)
				document.getElementById(5).innerHTML="O";
			else
				document.getElementById(1).innerHTML="O";
		}
		else if (count==1){
			if (document.getElementById(5).innerHTML=="O" && document.getElementById(1).innerHTML=="X" && document.getElementById(9).innerHTML=="X")
				document.getElementById(2).innerHTML="O";
			else if (document.getElementById(5).innerHTML=="O" && document.getElementById(3).innerHTML=="X" && document.getElementById(7).innerHTML=="X")
				document.getElementById(2).innerHTML="O";
			else if (document.getElementById(5).innerHTML=="O" && document.getElementById(2).innerHTML=="X" && document.getElementById(4).innerHTML=="X")
				document.getElementById(1).innerHTML="O";
			else if (document.getElementById(5).innerHTML=="O" && document.getElementById(9).innerHTML=="X" && document.getElementById(4).innerHTML=="X")
				document.getElementById(7).innerHTML="O";
			else if (document.getElementById(5).innerHTML=="O" && document.getElementById(9).innerHTML=="X" && document.getElementById(2).innerHTML=="X")
				document.getElementById(3).innerHTML="O";
			else if (document.getElementById(5).innerHTML=="X" && document.getElementById(9).innerHTML=="X" && document.getElementById(1).innerHTML=="O")
				document.getElementById(3).innerHTML="O";
			else if (document.getElementById(5).innerHTML=="O" && document.getElementById(3).innerHTML=="X" && document.getElementById(4).innerHTML=="X")
				document.getElementById(1).innerHTML="O";
			else if (document.getElementById(7).innerHTML=="X" && document.getElementById(2).innerHTML=="X" && document.getElementById(5).innerHTML=="O")
				document.getElementById(1).innerHTML="O";
			else
				killingblow();
			
		}
		else{
			killingblow();
		}

		checkForWinner();
		count++;
		
		
		
	}

}

function checkForWinner(){
	if (count>1){
		var c1 = document.getElementById(1).innerHTML;
		var c2 = document.getElementById(2).innerHTML;
		var c3 = document.getElementById(3).innerHTML;
		var c4 = document.getElementById(4).innerHTML;
		var c5 = document.getElementById(5).innerHTML;
		var c6 = document.getElementById(6).innerHTML;
		var c7 = document.getElementById(7).innerHTML;
		var c8 = document.getElementById(8).innerHTML;
		var c9 = document.getElementById(9).innerHTML;
		
		if (c1==c2 && c1==c3 && c1!=""){
			if (c1=="X")
				alert("Player X wins");
			else if (c1=="O")
				alert("Player O wins");
			gameover = true;
		}
		else if (c4==c5 && c4==c6 && c4!=""){
			if (c4=="X")
				alert("Player X wins");
			else if (c4=="O")
				alert("Player O wins");
			gameover = true;
		}
		else if (c7==c8 && c7==c9 && c7!=""){
			if (c7=="X")
				alert("Player X wins");
			else if (c7=="O")
				alert("Player O wins");
			gameover = true;
		}
		
		else if (c1==c4 && c1==c7 && c1!=""){
			if (c1=="X")
				alert("Player X wins");
			else if (c1=="O")
				alert("Player O wins");
			gameover = true;
		}
		else if (c2==c5 && c2==c8 && c2!=""){
			if (c2=="X")
				alert("Player X wins");
			else if (c2=="O")
				alert("Player O wins");
			gameover = true;
		}
		else if (c3==c6 && c3==c9 && c3!=""){
			if (c3=="X")
				alert("Player X wins");
			else if (c3=="O")
				alert("Player O wins");
			gameover = true;
		}
		
		else if (c1==c5 && c1==c9 && c1!=""){
			if (c1=="X")
				alert("Player X wins");
			else if (c1=="O")
				alert("Player O wins");
			gameover = true;
		}
		else if (c3==c5 && c3==c7 && c3!=""){
			if (c3=="X")
				alert("Player X wins");
			else if (c3=="O")
				alert("Player O wins");
			gameover = true;
		}
		
	}
}

function defensive(){
	if (document.getElementById(1).innerHTML=="X" && document.getElementById(2).innerHTML=="X" && document.getElementById(3).innerHTML=="")
		document.getElementById(3).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="X" && document.getElementById(3).innerHTML=="X" && document.getElementById(2).innerHTML=="")
		document.getElementById(2).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="X" && document.getElementById(3).innerHTML=="X" && document.getElementById(1).innerHTML=="")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="X" && document.getElementById(5).innerHTML=="X" && document.getElementById(6).innerHTML=="")
		document.getElementById(6).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="X" && document.getElementById(6).innerHTML=="X" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="X" && document.getElementById(6).innerHTML=="X" && document.getElementById(4).innerHTML=="")
		document.getElementById(4).innerHTML="O";
	else if (document.getElementById(7).innerHTML=="X" && document.getElementById(8).innerHTML=="X" && document.getElementById(9).innerHTML=="")
		document.getElementById(9).innerHTML="O";
	else if (document.getElementById(7).innerHTML=="X" && document.getElementById(9).innerHTML=="X" && document.getElementById(8).innerHTML=="")
		document.getElementById(8).innerHTML="O";
	else if (document.getElementById(8).innerHTML=="X" && document.getElementById(9).innerHTML=="X" && document.getElementById(7).innerHTML=="")
		document.getElementById(7).innerHTML="O";
					
	else if (document.getElementById(1).innerHTML=="X" && document.getElementById(4).innerHTML=="X" && document.getElementById(7).innerHTML=="")
		document.getElementById(7).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="X" && document.getElementById(7).innerHTML=="X" && document.getElementById(4).innerHTML=="")
		document.getElementById(4).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="X" && document.getElementById(7).innerHTML=="X" && document.getElementById(1).innerHTML=="")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="X" && document.getElementById(5).innerHTML=="X" && document.getElementById(8).innerHTML=="")
		document.getElementById(8).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="X" && document.getElementById(8).innerHTML=="X" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="X" && document.getElementById(8).innerHTML=="X" && document.getElementById(2).innerHTML=="")
		document.getElementById(2).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="X" && document.getElementById(6).innerHTML=="X" && document.getElementById(9).innerHTML=="")
		document.getElementById(9).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="X" && document.getElementById(9).innerHTML=="X" && document.getElementById(6).innerHTML=="")
		document.getElementById(6).innerHTML="O";
	else if (document.getElementById(6).innerHTML=="X" && document.getElementById(9).innerHTML=="X" && document.getElementById(3).innerHTML=="")
		document.getElementById(3).innerHTML="O";
					
	else if (document.getElementById(1).innerHTML=="X" && document.getElementById(5).innerHTML=="X" && document.getElementById(9).innerHTML=="")
		document.getElementById(9).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="X" && document.getElementById(9).innerHTML=="X" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="X" && document.getElementById(9).innerHTML=="X" && document.getElementById(1).innerHTML=="")
		document.getElementById(1).innerHTML="O";
					
	else if (document.getElementById(3).innerHTML=="X" && document.getElementById(5).innerHTML=="X" && document.getElementById(7).innerHTML=="")
		document.getElementById(7).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="X" && document.getElementById(7).innerHTML=="X" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="X" && document.getElementById(7).innerHTML=="X" && document.getElementById(3).innerHTML=="")
		document.getElementById(3).innerHTML="O";
	else
		offensive();
		
		
		
}

function killingblow(){
	if (document.getElementById(1).innerHTML=="O" && document.getElementById(2).innerHTML=="O" && document.getElementById(3).innerHTML=="")
		document.getElementById(3).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="O" && document.getElementById(3).innerHTML=="O" && document.getElementById(2).innerHTML=="")
		document.getElementById(2).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="O" && document.getElementById(3).innerHTML=="O" && document.getElementById(1).innerHTML=="")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="O" && document.getElementById(5).innerHTML=="O" && document.getElementById(6).innerHTML=="")
		document.getElementById(6).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="O" && document.getElementById(6).innerHTML=="O" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="O" && document.getElementById(6).innerHTML=="O" && document.getElementById(4).innerHTML=="")
		document.getElementById(4).innerHTML="O";
	else if (document.getElementById(7).innerHTML=="O" && document.getElementById(8).innerHTML=="O" && document.getElementById(9).innerHTML=="")
		document.getElementById(9).innerHTML="O";
	else if (document.getElementById(7).innerHTML=="O" && document.getElementById(9).innerHTML=="O" && document.getElementById(8).innerHTML=="")
		document.getElementById(8).innerHTML="O";
	else if (document.getElementById(8).innerHTML=="O" && document.getElementById(9).innerHTML=="O" && document.getElementById(7).innerHTML=="")
		document.getElementById(7).innerHTML="O";
					
	else if (document.getElementById(1).innerHTML=="O" && document.getElementById(4).innerHTML=="O" && document.getElementById(7).innerHTML=="")
		document.getElementById(7).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="O" && document.getElementById(7).innerHTML=="O" && document.getElementById(4).innerHTML=="")
		document.getElementById(4).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="O" && document.getElementById(7).innerHTML=="O" && document.getElementById(1).innerHTML=="")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="O" && document.getElementById(5).innerHTML=="O" && document.getElementById(8).innerHTML=="")
		document.getElementById(8).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="O" && document.getElementById(8).innerHTML=="O" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="O" && document.getElementById(8).innerHTML=="O" && document.getElementById(2).innerHTML=="")
		document.getElementById(2).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="O" && document.getElementById(6).innerHTML=="O" && document.getElementById(9).innerHTML=="")
		document.getElementById(9).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="O" && document.getElementById(9).innerHTML=="O" && document.getElementById(6).innerHTML=="")
		document.getElementById(6).innerHTML="O";
	else if (document.getElementById(6).innerHTML=="O" && document.getElementById(9).innerHTML=="O" && document.getElementById(3).innerHTML=="")
		document.getElementById(3).innerHTML="O";
					
	else if (document.getElementById(1).innerHTML=="O" && document.getElementById(5).innerHTML=="O" && document.getElementById(9).innerHTML=="")
		document.getElementById(9).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="O" && document.getElementById(9).innerHTML=="O" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="O" && document.getElementById(9).innerHTML=="O" && document.getElementById(1).innerHTML=="")
		document.getElementById(1).innerHTML="O";
					
	else if (document.getElementById(3).innerHTML=="O" && document.getElementById(5).innerHTML=="O" && document.getElementById(7).innerHTML=="")
		document.getElementById(7).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="O" && document.getElementById(7).innerHTML=="O" && document.getElementById(5).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(5).innerHTML=="O" && document.getElementById(7).innerHTML=="O" && document.getElementById(3).innerHTML=="")
		document.getElementById(3).innerHTML="O";
	else
		defensive();
		
		
}

function offensive(){
	if (document.getElementById(1).innerHTML=="O" && document.getElementById(2).innerHTML=="" && document.getElementById(3).innerHTML=="")
		document.getElementById(2).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="" && document.getElementById(2).innerHTML=="O" && document.getElementById(3).innerHTML=="")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="" && document.getElementById(2).innerHTML=="" && document.getElementById(3).innerHTML=="O")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="O" && document.getElementById(5).innerHTML=="" && document.getElementById(6).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="" && document.getElementById(5).innerHTML=="O" && document.getElementById(6).innerHTML=="")
		document.getElementById(4).innerHTML="O";
	else if (document.getElementById(4).innerHTML=="" && document.getElementById(5).innerHTML=="" && document.getElementById(6).innerHTML=="O")
		document.getElementById(4).innerHTML="O";
	else if (document.getElementById(7).innerHTML=="O" && document.getElementById(8).innerHTML=="" && document.getElementById(9).innerHTML=="")
		document.getElementById(8).innerHTML="O";
	else if (document.getElementById(7).innerHTML=="" && document.getElementById(8).innerHTML=="O" && document.getElementById(9).innerHTML=="")
		document.getElementById(7).innerHTML="O";
	else if (document.getElementById(7).innerHTML=="" && document.getElementById(8).innerHTML=="" && document.getElementById(9).innerHTML=="O")
		document.getElementById(7).innerHTML="O";
					
	else if (document.getElementById(1).innerHTML=="O" && document.getElementById(4).innerHTML=="" && document.getElementById(7).innerHTML=="")
		document.getElementById(4).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="" && document.getElementById(4).innerHTML=="O" && document.getElementById(7).innerHTML=="")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="" && document.getElementById(4).innerHTML=="" && document.getElementById(7).innerHTML=="O")
		document.getElementById(1).innerHTML="O";	
	else if (document.getElementById(2).innerHTML=="O" && document.getElementById(5).innerHTML=="" && document.getElementById(8).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="" && document.getElementById(5).innerHTML=="O" && document.getElementById(8).innerHTML=="")
		document.getElementById(2).innerHTML="O";
	else if (document.getElementById(2).innerHTML=="" && document.getElementById(5).innerHTML=="" && document.getElementById(8).innerHTML=="O")
		document.getElementById(2).innerHTML="O";	
	else if (document.getElementById(3).innerHTML=="O" && document.getElementById(6).innerHTML=="" && document.getElementById(9).innerHTML=="")
		document.getElementById(6).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="" && document.getElementById(6).innerHTML=="O" && document.getElementById(9).innerHTML=="")
		document.getElementById(3).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="" && document.getElementById(6).innerHTML=="" && document.getElementById(9).innerHTML=="O")
		document.getElementById(3).innerHTML="O";	
		
	else if (document.getElementById(1).innerHTML=="O" && document.getElementById(5).innerHTML=="" && document.getElementById(9).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="" && document.getElementById(5).innerHTML=="O" && document.getElementById(9).innerHTML=="")
		document.getElementById(1).innerHTML="O";
	else if (document.getElementById(1).innerHTML=="" && document.getElementById(5).innerHTML=="" && document.getElementById(9).innerHTML=="O")
		document.getElementById(1).innerHTML="O";
					
	else if (document.getElementById(3).innerHTML=="O" && document.getElementById(5).innerHTML=="" && document.getElementById(7).innerHTML=="")
		document.getElementById(5).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="" && document.getElementById(5).innerHTML=="O" && document.getElementById(7).innerHTML=="")
		document.getElementById(3).innerHTML="O";
	else if (document.getElementById(3).innerHTML=="" && document.getElementById(5).innerHTML=="" && document.getElementById(7).innerHTML=="O")
		document.getElementById(3).innerHTML="O";
	else if (!gameover){
		alert("Draw, No More Space");
		gameover = true;
	}
		
		
}