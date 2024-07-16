<?php

session_start();
error_reporting(E_ERROR | E_PARSE);

function registerPlayers($player1="", $player2="") {
    $_SESSION['PLAYER1_NAME'] = $player1;
    $_SESSION['PLAYER2_NAME'] = $player2;
}

function playersRegistered() {
    return $_SESSION['PLAYER1_NAME'] && $_SESSION['PLAYER2_NAME'];
}

registerPlayers($_POST['player1'], $_POST['player2']);

if (playersRegistered()) {
    header("location: play.php");
}
