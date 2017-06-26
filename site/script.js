<meta charser="utf-8">
<script>
	function playGame() {
		var i = 0;
		if(document.getElementById("puzzle1").value == "ель") { i++; }
		if(document.getElementById("puzzle2").value == "морковь") { i++; }
		alert("Количество правильных ответов: " + i);
	}
</script>