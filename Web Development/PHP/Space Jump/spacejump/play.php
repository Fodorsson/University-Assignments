<?php
require_once "templates/header.php";

session_start();
error_reporting(E_ERROR | E_PARSE);

function playersRegistered() {
    return $_SESSION['PLAYER1_NAME'] && $_SESSION['PLAYER2_NAME'];
}

if (! playersRegistered()) {
    header("location: index.php");
}

?>

<form method="post" action="play.php">

<div class="row">

	<div class="column-left">
		<h2>Game Text</h2>
		<div id="gametext"></div>
		<div id="dummy" hidden></div>
	</div>
  
	<div class="column-center">
		<table class="spacejump-field" cellpadding="0" cellspacing="0">
			<tbody>
				<?php
				
				$array = [	1,2,3,4,5,6,
							12,11,10,9,8,7,
							13,14,15,16,17,18,
							24,23,22,21,20,19,
							25,26,27,28,29,30,
							36,35,34,33,32,31];
							
							for ($i = 0; $i < count($array); $i++){
								echo "<td id=cell" . $array[$i]-1 . ">" . $array[$i] . "</td>";
								if ($i % 6 == 5)
									echo "</tr>";
							}
				
				?>

				</tr>
			</tbody>
		</table>
	</div>
  
	<div class="column-right">
		<h2 id="current-player"></h2>
		
		<button type="button" onclick="start_new_game(); return false;">Reset</button>
		<br><br>
		<button type="button" onclick="click_leaderboard(); return false;">Leaderboard</button>
		<br><br>
		
		<input id="dicebtn" type="image" src="die-icon.png" alt="Roll die" style='width:4vw;height:4vw;' onclick="click_dice(); return false;"/>
		<br><br>
		<div id="dicey"></div>
		<br>
		
		<table class="spacejump-field" id="leaderboard-table" cellpadding="0" cellspacing="0" style='display:none;'>
		<tbody>
		  <tr>
			<th>Player</th>
			<th>Games Played</th>
			<th>Won</th>
			<th>Lost</th>
			<th>Quickest Win</th>
			<th>Win/Lose Ratio</th>
		  </tr>
		  <tr>
			<td>Player 1</td>
			<td id="p1-games-played"></td>
			<td id="p1-games-won"></td>
			<td id="p1-games-lost"></td>
			<td id="p1-quickest-win"></td>
			<td id="p1-ratio"></td>
		  </tr>
		  <tr>
			<td>Player 2</td>
			<td id="p2-games-played"></td>
			<td id="p2-games-won"></td>
			<td id="p2-games-lost"></td>
			<td id="p2-quickest-win"></td>
			<td id="p2-ratio"></td>
		  </tr>
		  </tbody>
		</table>
		
	</div>
  
</div>

</form>

<script type="text/javascript">
	
    function click_dice() {
		
		$.ajax({ url: 'snakes.php',
         data: {action: 'play_turn'},
         type: 'post',
         success: function(data) {
                      $('#dicey').html(data);
                  }
		});

	}
	
	function start_new_game() {
		
		$.ajax({ url: 'snakes.php',
         data: {action: 'new_game'},
         type: 'post',
         success: function(data) {
                      $('#gametext').html(data);
                  }
		});

	}
	
	function click_leaderboard() {
		
		$.ajax({ url: 'snakes.php',
         data: {action: 'toggle_leaderboard'},
         type: 'post',
         success: function(data) {
                      $('#dummy').html(data);
                  }
		});

	}
</script>

<?php
require_once "templates/footer.php";
