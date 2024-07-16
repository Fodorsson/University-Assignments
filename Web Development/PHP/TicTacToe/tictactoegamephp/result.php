<?php
require_once "templates/header.php";

if (! playersRegistered()) {
    header("location: index.php");
}

resetBoard();
?>

<table class="wrapper" cellpadding="0" cellspacing="0">
    <tr>
        <td>

            <div class="welcome">

                <h1>
                    <?php
                    if ($_GET['player']) {
                        echo currentPlayer() . " won!";
                    }
                    else {
                        echo "It's a tie!";
                    }
                    ?>
                                </h1>
                <?php
                // insert players' score into results table of tictactoe database
                $playerx = playerName('x');
                $playerxscore = score('x');
                $playero = playerName('o');
                $playeroscore = score('o');
                $date = date('Y/m/d H:i:s');

                //Connection to MySQL
                $servername = "localhost";
                $username = "root";
                $password = "";
                $dbname = "tictactoe";

                // Create connection
                $conn = mysqli_connect($servername, $username, $password, $dbname);
                // Check connection
                if (!$conn) {
                die("Connection failed: " . mysqli_connect_error());
                }

                //Insert Data Into MySQL Using MySQLi
                $sql = "INSERT INTO results (playerx, playerxscore, playero, playeroscore, dtime)
                VALUES ('$playerx', '$playerxscore', '$playero', '$playeroscore','$date')";

                if (mysqli_query($conn, $sql)) {
                echo "New record created successfully";
                } else {
                echo "Error: " . $sql . "<br>" . mysqli_error($conn);
                }

                mysqli_close($conn);
                ?>
                <div class="player-name">
                    <?php echo playerName('x')?>'s score: <b><?php echo score('x')?></b>
                </div>

                <div class="player-name">
                    <?php echo playerName('o')?>' score: <b><?php echo score('o')?></b>
                </div>

                <a href="play.php">Play again</a><br />

                <a href="index.php" class="reset-btn">Reset</a>
            </div>

        </td>
    </tr>
</table>

</body>
</html>

