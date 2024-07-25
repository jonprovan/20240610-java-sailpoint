function changeParagraph() {
	console.log(document.getElementById("myParagraph").innerText);
	document.getElementById("myParagraph").innerText = "Well, whaddaya know...it worked!";
	console.log(document.getElementById("myParagraph").innerText);
}