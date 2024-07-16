<html>
<?php
require_once "./templates/header.php";

session_start();
error_reporting(E_ERROR | E_PARSE);

if(isset($_POST['action']) && !empty($_POST['action'])) {
		$action = $_POST['action'];
		switch($action) {
			case 'play_turn' : play_turn();break;
			case 'new_game' : new_game();break;
			case 'refresh_values' : refresh_values();break;
			case 'toggle_leaderboard' : toggle_leaderboard();break;
		}
	}

$player_names = ["Player 1", "Player 2"];
$players_positions;
$hole_starts;
$hole_ends;
$rolls = array();
$moves = array();
$turn_of_player;
$_SESSION['HOLE_ENCOUNTER_TYPES'];
$_SESSION['HOLE_ENCOUNTERS'];

$_SESSION['P1_GAMES_PLAYED'];
$_SESSION['P1_GAMES_WON'];
$_SESSION['P1_GAMES_LOST'];
$_SESSION['P1_QUICKEST_WIN'];

$_SESSION['P2_GAMES_PLAYED'];
$_SESSION['P2_GAMES_WON'];
$_SESSION['P2_GAMES_LOST'];
$_SESSION['P2_QUICKEST_WIN'];

function toggle_leaderboard() {
	echo "<script>
		var lb = document.getElementById('leaderboard-table');
		if (lb.style.display === 'none') {
			lb.style.display = 'block';
		} 
		else {
			lb.style.display = 'none';
		}
		</script>";
		
		//Load values from the database
		load_from_database();
		
}

function refresh_values() {

//	echo "<script type='text/javascript'>alert('reloaded');</script>";
	for ($i = 0; $i < count($_SESSION['CELL_CONTENTS']); $i++) {
		$cell_id = "cell" . $i;
		$content = $_SESSION['CELL_CONTENTS'][$i];
		echo "<script> document.getElementById('$cell_id').innerHTML='$content'</script>";
	}
	
}

function load_from_database(){

	//Read player data from the results table of the spacejump database

    //Connection to MySQL
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "spacejump";

    // Create connection
    $conn = mysqli_connect($servername, $username, $password, $dbname);
    // Check connection
    if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }
	
	//Reading Player 1's row
	$sql = "SELECT gamesplayed, won, lost, quickest, ratio FROM results WHERE player='Player 1'";
	
	if (mysqli_query($conn, $sql)) {} 
	else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }
	
	$result = mysqli_query($conn, $sql);
	
    while($row = mysqli_fetch_assoc($result)){
 
		$_SESSION['P1_GAMES_PLAYED'] = $row["gamesplayed"];
		$_SESSION['P1_GAMES_WON'] = $row["won"];
		$_SESSION['P1_GAMES_LOST'] = $row["lost"];
		$_SESSION['P1_QUICKEST_WIN'] = $row["quickest"];
    }
	
	//Reading Player 2's row
	$sql = "SELECT gamesplayed, won, lost, quickest, ratio FROM results WHERE player='Player 2'";
	
	if (mysqli_query($conn, $sql)) {} 
	else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }
	
	$result = mysqli_query($conn, $sql);
	
    while($row = mysqli_fetch_assoc($result)){
 
		$_SESSION['P2_GAMES_PLAYED'] = $row["gamesplayed"];
		$_SESSION['P2_GAMES_WON'] = $row["won"];
		$_SESSION['P2_GAMES_LOST'] = $row["lost"];
		$_SESSION['P2_QUICKEST_WIN'] = $row["quickest"];
    }
	
	//We are done with the database bit
	mysqli_close($conn);
	
	//Assigning session variable values to normal variable values for easier echo output
	$p1_games_played = $_SESSION['P1_GAMES_PLAYED'];
	$p1_games_won = $_SESSION['P1_GAMES_WON'];
	$p1_games_lost = $_SESSION['P1_GAMES_LOST'];
	$p1_quickest_win = $_SESSION['P1_QUICKEST_WIN'];
	$p1_ratio = 0;
	if ($p1_games_lost != 0){
		$p1_ratio = $p1_games_won/$p1_games_lost;
	}

	$p2_games_played = $_SESSION['P2_GAMES_PLAYED'];
	$p2_games_won = $_SESSION['P2_GAMES_WON'];
	$p2_games_lost = $_SESSION['P2_GAMES_LOST'];
	$p2_quickest_win = $_SESSION['P2_QUICKEST_WIN'];
	$p2_ratio = 0;
	if ($p2_games_lost != 0){
		$p2_ratio = $p2_games_won/$p2_games_lost;
	}
	
	echo "<script> document.getElementById('p1-games-played').innerHTML='$p1_games_played'</script>";
	echo "<script> document.getElementById('p1-games-won').innerHTML='$p1_games_won'</script>";
	echo "<script> document.getElementById('p1-games-lost').innerHTML='$p1_games_lost'</script>";
	echo "<script> document.getElementById('p1-quickest-win').innerHTML='$p1_quickest_win'</script>";
	echo "<script> document.getElementById('p1-ratio').innerHTML='$p1_ratio'</script>";
	
	echo "<script> document.getElementById('p2-games-played').innerHTML='$p2_games_played'</script>";
	echo "<script> document.getElementById('p2-games-won').innerHTML='$p2_games_won'</script>";
	echo "<script> document.getElementById('p2-games-lost').innerHTML='$p2_games_lost'</script>";
	echo "<script> document.getElementById('p2-quickest-win').innerHTML='$p2_quickest_win'</script>";
	echo "<script> document.getElementById('p2-ratio').innerHTML='$p2_ratio'</script>";
	
}

function save_to_database() {

	//Insert player data into the results table of the spacejump database

    //Connection to MySQL
    $servername = "localhost";
    $username = "root";
    $password = "";
    $dbname = "spacejump";

    // Create connection
    $conn = mysqli_connect($servername, $username, $password, $dbname);
    // Check connection
    if (!$conn) {
        die("Connection failed: " . mysqli_connect_error());
    }
	
	$p1_games_played = $_SESSION['P1_GAMES_PLAYED'];
	$p1_games_won = $_SESSION['P1_GAMES_WON'];
	$p1_games_lost = $_SESSION['P1_GAMES_LOST'];
	$p1_quickest_win = $_SESSION['P1_QUICKEST_WIN'];
	$p1_ratio = 0;
	if ($p1_games_lost != 0){
		$p1_ratio = $p1_games_won/$p1_games_lost;
	}

	$p2_games_played = $_SESSION['P2_GAMES_PLAYED'];
	$p2_games_won = $_SESSION['P2_GAMES_WON'];
	$p2_games_lost = $_SESSION['P2_GAMES_LOST'];
	$p2_quickest_win = $_SESSION['P2_QUICKEST_WIN'];
	$p2_ratio = 0;
	if ($p2_games_lost != 0){
		$p2_ratio = $p2_games_won/$p2_games_lost;
	}
	
	//Delete all previous entries
	$sql = "DELETE FROM results";
	if (mysqli_query($conn, $sql)) {} 
	else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }

    //Insert P1 Data Into MySQL Using MySQLi
    $sql = "INSERT INTO results (player, gamesplayed, won, lost, quickest, ratio)
                VALUES ('Player 1', '$p1_games_played', '$p1_games_won', '$p1_games_lost', '$p1_quickest_win','$p1_quickest_win')";
	if (mysqli_query($conn, $sql)) {} 
	else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }
	
	//Insert P2 Data Into MySQL Using MySQLi
    $sql = "INSERT INTO results (player, gamesplayed, won, lost, quickest, ratio)
                VALUES ('Player 2', '$p2_games_played', '$p2_games_won', '$p2_games_lost', '$p2_quickest_win','$p2_quickest_win')";
	if (mysqli_query($conn, $sql)) {} 
	else {
        echo "Error: " . $sql . "<br>" . mysqli_error($conn);
    }

    mysqli_close($conn);
	
	echo "<script> document.getElementById('p1-games-played').innerHTML='$p1_games_played'</script>";
	echo "<script> document.getElementById('p1-games-won').innerHTML='$p1_games_won'</script>";
	echo "<script> document.getElementById('p1-games-lost').innerHTML='$p1_games_lost'</script>";
	echo "<script> document.getElementById('p1-quickest-win').innerHTML='$p1_quickest_win'</script>";
	echo "<script> document.getElementById('p1-ratio').innerHTML='$p1_ratio'</script>";
	
	echo "<script> document.getElementById('p2-games-played').innerHTML='$p2_games_played'</script>";
	echo "<script> document.getElementById('p2-games-won').innerHTML='$p2_games_won'</script>";
	echo "<script> document.getElementById('p2-games-lost').innerHTML='$p2_games_lost'</script>";
	echo "<script> document.getElementById('p2-quickest-win').innerHTML='$p2_quickest_win'</script>";
	echo "<script> document.getElementById('p2-ratio').innerHTML='$p2_ratio'</script>";
	
}

function play_turn() {
	global $hole_starts;
	global $hole_ends;
	
	$_SESSION['TURN_NUMBER']++;

	//Display the roll of the dice upon button press
	echo 'Dice roll: ' . $_SESSION['ROLLS'][$_SESSION['TURN_NUMBER']];
	
	//We need to introduce a pair of variables because echoing the session variables would include too many quotation marks and would result in an error
	$p1name =  $_SESSION['PLAYER1_NAME'] . "\'s turn";
	$p2name =  $_SESSION['PLAYER2_NAME'] . "\'s turn";
	
	
	//Check for hole encounters
	for ($i = 0; $i < count($_SESSION['HOLE_ENCOUNTERS']); $i++) {
		if ($_SESSION['TURN_NUMBER'] == $_SESSION['HOLE_ENCOUNTERS'][$i]){
		
			$hole_index = $_SESSION['HOLE_ENCOUNTER_TYPES'][$i];
			
			$hole_startfield = $_SESSION['HOLE_STARTS'][$hole_index];
			
			$hole_endfield = $_SESSION['HOLE_ENDS'][$hole_index];
			
			if ($hole_index < 3){
				echo "<script type='text/javascript'>alert('Wormhole encountered!');</script>";
				$hole_message = '<br>*Wormhole ';
			}
			else{
				echo "<script type='text/javascript'>alert('Black hole encountered!');</script>";
				$hole_message = '<br>*Black hole ';
			}
			
			//We only want to write the hole text into the cell if it is not there yet
			if(!str_contains($_SESSION['CELL_CONTENTS'][$hole_startfield], 'entry') ){
				$_SESSION['CELL_CONTENTS'][$hole_startfield] = $_SESSION['CELL_CONTENTS'][$hole_startfield] . $hole_message . 'entry*';
				$cell_id = "cell" . $hole_startfield;
				echo "<script> document.getElementById('$cell_id').innerHTML+='$hole_message entry*'</script>";
				
				$_SESSION['CELL_CONTENTS'][$hole_endfield] = $_SESSION['CELL_CONTENTS'][$hole_endfield] . $hole_message. 'exit*';
				$cell_id = "cell" . $hole_endfield;
				echo "<script> document.getElementById('$cell_id').innerHTML+='$hole_message exit*'</script>";
			}
			
				
		}
		
	}
	
	//
	
	
	if ($_SESSION['TURN_NUMBER'] % 2 == 0){
		//Update turn text
		echo "<script> document.getElementById('current-player').innerHTML='$p2name' </script>";
		
		//Let's remove the current player's name from the previous cell they occupied
		
		if ($_SESSION['TURN_NUMBER'] > 1){
			//The current player's previously occupied cell has the index of current turn number - 2
			$cell_index = $_SESSION['MOVES'][$_SESSION['TURN_NUMBER'] - 2];
		}
		else{
			$cell_index = 0;
		}
			
			//Save what the cell currently contains
			$cellcontent = $_SESSION['CELL_CONTENTS'][$cell_index];
			
			//replace the player's name with nothing
			$name_to_replace = '<br>'.$_SESSION['PLAYER1_NAME'];
			$cellcontent = str_replace($name_to_replace, '', $cellcontent);
			$_SESSION['CELL_CONTENTS'][$cell_index] = $cellcontent;

			//Update the HTML element of the old cell with the new value
			$cell_id = "cell" . $cell_index;
			echo "<script> document.getElementById('$cell_id').innerHTML='$cellcontent'</script>";
			
		//Now let's put the name of the players inside the table cell where they are supposed to be
		$cell_index = $_SESSION['MOVES'][$_SESSION['TURN_NUMBER']];
		$name=$_SESSION['PLAYER1_NAME'];
		$_SESSION['CELL_CONTENTS'][$cell_index] = $_SESSION['CELL_CONTENTS'][$cell_index].'<br>'.$_SESSION["PLAYER1_NAME"];
		$cell_id = "cell" . $cell_index;
		echo "<script> document.getElementById('$cell_id').innerHTML+='<br>$name'</script>";
		
	}
	else{
		//Update turn text
		echo "<script> document.getElementById('current-player').innerHTML='$p1name' </script>";
		
		//Let's remove the current player's name from the previous cell they occupied
		
		if ($_SESSION['TURN_NUMBER'] > 1){
			//The current player's previously occupied cell has the index of current turn number - 2
			$cell_index = $_SESSION['MOVES'][$_SESSION['TURN_NUMBER'] - 2];
		}
		else{
			$cell_index = 0;
		}
			
			//Save what the cell currently contains
			$cellcontent = $_SESSION['CELL_CONTENTS'][$cell_index];
			
			//replace the player's name with nothing
			$name_to_replace = '<br>'.$_SESSION['PLAYER2_NAME'];
			$cellcontent = str_replace($name_to_replace, '', $cellcontent);
			$_SESSION['CELL_CONTENTS'][$cell_index] = $cellcontent;
			
			//Update the HTML element of the old cellwith the new value
			$cell_id = "cell" . $cell_index;
			echo "<script> document.getElementById('$cell_id').innerHTML='$cellcontent'</script>";
		
		//Now let's put the name of the players inside the table cell where they are supposed to be
		$cell_index = $_SESSION['MOVES'][$_SESSION['TURN_NUMBER']];
		$name=$_SESSION['PLAYER2_NAME'];
		$_SESSION['CELL_CONTENTS'][$cell_index] = $_SESSION['CELL_CONTENTS'][$cell_index].'<br>'.$_SESSION["PLAYER2_NAME"];
		$cell_id = "cell" . $cell_index;
		echo "<script> document.getElementById('$cell_id').innerHTML+='<br>$name'</script>";
		
	}
	
	//Check whether it is the last turn
	if ($_SESSION['TURN_NUMBER']+1 == count($_SESSION['MOVES']) ){
		if ($_SESSION['TURN_NUMBER'] % 2 == 0){
			$name = $_SESSION['PLAYER1_NAME'];
			echo "<script>alert('$name won!');</script>";
			
			//Update the variables used for the leaderboard
			$_SESSION['P1_GAMES_PLAYED']++;
			$_SESSION['P2_GAMES_PLAYED']++;
			$_SESSION['P1_GAMES_WON']++;
			$_SESSION['P2_GAMES_LOST']++;
			
			if ($_SESSION['TURN_NUMBER'] < $_SESSION['P1_QUICKEST_WIN'] || is_null($_SESSION['P1_QUICKEST_WIN']) ){
				$_SESSION['P1_QUICKEST_WIN'] = $_SESSION['TURN_NUMBER'];
			}
			
		}
		else{
			$name = $_SESSION['PLAYER2_NAME'];
			echo "<script>alert('$name won!');</script>";
			
			//Update the variables used for the leaderboard
			$_SESSION['P1_GAMES_PLAYED']++;
			$_SESSION['P2_GAMES_PLAYED']++;
			$_SESSION['P2_GAMES_WON']++;
			$_SESSION['P1_GAMES_LOST']++;
			
			if ($_SESSION['TURN_NUMBER'] < $_SESSION['P2_QUICKEST_WIN'] || is_null($_SESSION['P2_QUICKEST_WIN']) ){
				$_SESSION['P2_QUICKEST_WIN'] = $_SESSION['TURN_NUMBER'];
			}
			
		}
		
		save_to_database();
		
		echo "<script>document.getElementById('dicebtn').disabled = true;</script>";
		
	}
	
}

function new_game()
{
	global $player_names;
	global $players_positions;
	global $hole_starts;
	global $hole_ends;
	global $rolls;
	global $moves;
	global $turn_of_player;
	
	$_SESSION['HOLE_ENCOUNTERS'] = array();
	$_SESSION['HOLE_ENCOUNTER_TYPES'] = array();
	
	echo "<script>document.getElementById('dicebtn').disabled = false;</script>";
	
	//Set the turn number to 0
	$_SESSION['TURN_NUMBER'] = -1;
	
	//Table contents array
	$_SESSION['CELL_CONTENTS'] = [	'1','2','3','4','5','6',
								'7','8','9','10','11','12',
								'13','14','15','16','17','18',
								'19','20','21','22','23','24',
								'25','26','27','28','29','30',
								'31','32','33','34','35','36'];
								
	for ($i = 0; $i < count($_SESSION['CELL_CONTENTS']); $i++) {
		$cell_id = "cell" . $i;
		$content = $_SESSION['CELL_CONTENTS'][$i];
		echo "<script> document.getElementById('$cell_id').innerHTML='$content'</script>";
	}
	
	$p1name =  $_SESSION['PLAYER1_NAME'] . "\'s turn";
	echo "<script> document.getElementById('current-player').innerHTML='$p1name' </script>";
	
	$name=$_SESSION['PLAYER1_NAME'];
	echo "<script> document.getElementById('cell0').innerHTML+='<br>$name'</script>";
	$_SESSION['CELL_CONTENTS'][0] = $_SESSION['CELL_CONTENTS'][0].'<br>'.$_SESSION["PLAYER1_NAME"];
	$name=$_SESSION['PLAYER2_NAME'];
	echo "<script> document.getElementById('cell0').innerHTML+='<br>$name'</script>";
	$_SESSION['CELL_CONTENTS'][0] = $_SESSION['CELL_CONTENTS'][0].'<br>'.$_SESSION["PLAYER2_NAME"];
	
	$player_names = [$_SESSION['PLAYER1_NAME'], $_SESSION['PLAYER2_NAME'] ];
	$rolls = array();
	$moves = array();

	//create the 3 wormholes and 2 black holes
    $hole_starts = [0,0,0,0,0];
	$hole_ends = [0,0,0,0,0];
	
	//create wormholes
	for ($i = 0; $i < 3; $i++) {
	//the start of the wormholes can be anywhere except for the start and final square, or at another wormhole
		$accepted = False;
		while(!$accepted) {
			$hole_starts[$i] = rand(1, 34);
			//Is there a wormhole with that starting index already?
			$match_found = False;
			
			for ($j = 0; $j < $i; $j++) {
				if ($hole_starts[$i] == $hole_starts[$j] && $i != $j)
					$match_found = True;
			}
			
			if (!$match_found)
				$accepted = True;
			
		}
    }
	for ($i = 0; $i < 3; $i++) {
	//the end of the wormholes can be anywhere as long as they are ahead of their start
        $hole_ends[$i] = $hole_starts[$i] + rand(1, 35-$hole_starts[$i]);
    }
	
	//create black holes
	for ($i = 3; $i < 5; $i++) {
	//the start of the black holes can be anywhere except for the start and final square, or at the start of a wormhole or another black hole
	$accepted = False;
		while(!$accepted) {
			$hole_starts[$i] = rand(1, 34);
			//Is there a wormhole or black hole with that starting index already?
			$match_found = False;
			
			for ($j = 0; $j < 5; $j++) {
				if ($hole_starts[$j] == $hole_starts[$i] && $i != $j)
					$match_found = True;
			}
			
			if (!$match_found)
				$accepted = True;
			
		}
    }
	
	for ($i = 3; $i < 5; $i++) {
	//the end of the black holes can be anywhere as long as they are behind their start, and not at the start of a wormhole
	$accepted = False;
		while(!$accepted) {
			$hole_ends[$i] = rand(0, $hole_starts[$i]-1);
			//Is there a wormhole with that ending index already?
			$match_found = False;
			
			for ($j = 0; $j < 3; $j++) {
				if ($hole_starts[$j] == $hole_ends[$i])
					$match_found = True;
			}
			
			if (!$match_found)
				$accepted = True;
			
		}
		
    }
	
	echo "wormhole 1: " . $hole_starts[0]+1 . " to " . $hole_ends[0]+1 ."<br>";
	echo "wormhole 2: " . $hole_starts[1]+1 . " to " . $hole_ends[1]+1 ."<br>";
	echo "wormhole 3: " . $hole_starts[2]+1 . " to " . $hole_ends[2]+1 ."<br>";
	echo "black hole 1: " . $hole_starts[3]+1 . " to " . $hole_ends[3]+1 ."<br>";
	echo "black hole 2: " . $hole_starts[4]+1 . " to " . $hole_ends[4]+1 ."<br>";

	$_SESSION['HOLE_STARTS'] = $hole_starts;
	$_SESSION['HOLE_ENDS'] = $hole_ends;
	
	echo "<br>";
	
	//Both players start on field 0
	$players_positions = [0,0];
	
	//Player 1 is the first to start
	$turn_of_player = 0;
	
	//Loop until one of the players reach field 36 (indexed 35)
	while($players_positions[0] != 35 && $players_positions[1] != 35) {
		
		$dice_throw = rand(1, 6);
		array_push($rolls, $dice_throw);
		echo $player_names[$turn_of_player] . " rolled " . $dice_throw .", ";
		
		if ($players_positions[$turn_of_player] + $dice_throw < 36){
			//
			check_field($turn_of_player, $dice_throw);
			//
		}
		else{
			echo " stays on " . $players_positions[$turn_of_player]+1 ."<br>";
			array_push($moves, $players_positions[$turn_of_player]);
		}
		
		//Change player, 0->1, 1->0
		$turn_of_player = 1 - $turn_of_player;
		
	}
	
	//Then the while loop ends, a winner will have emerged
	if ($players_positions[0] == 35){
		echo $player_names[0] . " won!";
	}
	else{
		echo $player_names[1] . " won!";
	}
	
	$_SESSION['ROLLS'] = $rolls;
	$_SESSION['MOVES'] = $moves;
	
	echo "<br>";
	echo "<br>";
	echo "List of rolls: ";
	print_r($rolls);
	echo "<br>";
	echo "List of moves: ";
	print_r($moves);
	echo "<br>";
	echo "Holes encountered on turns: ";
	print_r($_SESSION['HOLE_ENCOUNTERS']);
	echo "<br>";
	echo "Holes encountered of types: ";
	print_r($_SESSION['HOLE_ENCOUNTER_TYPES']);
	echo "<br>";
	
}

function check_field($turn_of_player, $dice_throw){
	global $player_names;
	global $players_positions;
	global $hole_starts;
	global $hole_ends;
	global $moves;
	global $rolls;
	
	echo "moves " . " from " . $players_positions[$turn_of_player]+1 . " to " . $players_positions[$turn_of_player]+1 + $dice_throw ."<br>";
	$players_positions[$turn_of_player] += $dice_throw;
	$moves[] = $players_positions[$turn_of_player];
	
	
	$accepted = False;
	while(!$accepted) {
	
		$match_found = False;
	
		for ($i = 0; $i < 5; $i++) {
			if ($players_positions[$turn_of_player] == $hole_starts[$i]){
				$match_found = True;
				
				//We note down the # of the turn that a player has encountered a hole
				$_SESSION['HOLE_ENCOUNTERS'][] = count($rolls)-1 ;
				$_SESSION['HOLE_ENCOUNTER_TYPES'][] = $i ;
				
				if ($i < 3){
					echo $player_names[$turn_of_player] . " encounters a wormhole, ";
				}
				else{
					echo $player_names[$turn_of_player] . " encounters a black hole, ";
				}
				
				echo "moves " . " from " . $players_positions[$turn_of_player]+1 . " to " . $hole_ends[$i]+1 ."<br>";
				
				$players_positions[$turn_of_player] = $hole_ends[$i];
				//The end result for the player is going to be the field that the hole transports them to, so we do not need to remember the field they stepped on with the hole on it
				array_pop($moves);
				array_push($moves, $players_positions[$turn_of_player]);
				break;
			}
		}
		
		if (!$match_found)
				$accepted = True;
	
	}
	
}

?>
</html>