<?php
require_once "./templates/header.php";

session_start();
error_reporting(E_ERROR | E_PARSE);
?>

<form method="post" action="register-players.php">
    <div class="welcome">
        <h1>Play Space Jump!</h1>
        <h2>Enter your names</h2>

        <div class="p-name">
            <label for="player1"> Player 1</label>
            <input type="text" id="player1" name="player1" required />
        </div>

        <div class="p-name">
            <label for="player2"> Player 2</label>
            <input type="text" id="player2" name="player2" required />
        </div>

        <button type="submit" >Start</button>
    </div>
</form>


<?php
require_once "./templates/footer.php";
