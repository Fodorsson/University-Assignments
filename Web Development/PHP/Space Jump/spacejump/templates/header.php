<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1">
    <title>Space Jump by David Fodor</title>
	<script src="jquery-3.6.0.min.js"></script>
    <link rel='stylesheet' href='spacejump.css' type='text/css'/>
	
	<script type="text/javascript">
	function checkRefresh()
	{
		if( document.refreshForm.visited.value == "" ){   
			
			$.ajax({ url: 'snakes.php',
				data: {action: 'refresh_values'},
				type: 'post',
				success: function(data) {
						$('#dummy').html(data);
						}
			});
			
			document.refreshForm.visited.value = "1";
		}
		
	}
	</script> 
</head>
<body onLoad="checkRefresh()">

	<form name="refreshForm">
	<input type="hidden" name="visited" value="" />
	</form>

    <div class="wrapper">
