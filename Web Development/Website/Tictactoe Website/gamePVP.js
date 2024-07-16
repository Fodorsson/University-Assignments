var count = 0;
var gameover = false;

function displayLetter(id){
	
	if (document.getElementById(id).innerHTML == "" && !gameover){
	
		if(count%2==0)
			document.getElementById(id).innerHTML="X";
		else
			document.getElementById(id).innerHTML="O";
		
		count++;
		checkForWinner();
		
	}

}

function checkForWinner(){
	if (count>3){
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
			else
				alert("Player O wins");
			gameover = true;
		}
		else if (c4==c5 && c4==c6 && c4!=""){
			if (4=="X")
				alert("Player X wins");
			else
				alert("Player O wins");
			gameover = true;
		}
		else if (c7==c8 && c7==c9 && c7!=""){
			if (c7=="X")
				alert("Player X wins");
			else
				alert("Player O wins");
			gameover = true;
		}
		
		else if (c1==c4 && c1==c7 && c1!=""){
			if (c1=="X")
				alert("Player X wins");
			else
				alert("Player O wins");
			gameover = true;
		}
		else if (c2==c5 && c2==c8 && c2!=""){
			if (c2=="X")
				alert("Player X wins");
			else
				alert("Player O wins");
			gameover = true;
		}
		else if (c3==c6 && c3==c9 && c3!=""){
			if (c3=="X")
				alert("Player X wins");
			else
				alert("Player O wins");
			gameover = true;
		}
		
		else if (c1==c5 && c1==c9 && c1!=""){
			if (c1=="X")
				alert("Player X wins");
			else
				alert("Player O wins");
			gameover = true;
		}
		else if (c3==c5 && c3==c7 && c3!=""){
			if (c3=="X")
				alert("Player X wins");
			else
				alert("Player O wins");
			gameover = true;
		}
		else if (c1!="" && c1!="" && c2!="" && c3!="" && c4!="" && c5!="" && c6!="" && c7!="" && c8!="" && c9!=""){
			alert("Draw");
			gameover = true;
		}
		
	}
}