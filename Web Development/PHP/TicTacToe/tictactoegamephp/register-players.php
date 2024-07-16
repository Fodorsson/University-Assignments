<?php



require_once "functions.php";

//var_dump($_SESSION);
//exit("I AM HERE");

registerPlayers($_POST['player-x'], $_POST['player-o']);

if (playersRegistered()) {
    header("location: play.php");
}
