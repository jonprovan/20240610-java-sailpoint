function changeParagraph() {
	console.log(document.getElementById("myParagraph").innerText);
	document.getElementById("myParagraph").innerText = "Well, whaddaya know...it worked!";
	console.log(document.getElementById("myParagraph").innerText);
}

function createOffice() {
	console.log("Creating...");
}

// this function must be async because we're going to be awaiting within it
// we're going to use the fetch API for these calls
// fetch calls take two parameters -- a URL and an options block
async function getAllOffices() {
	
	// setting up the URL
	// the plugin helper only needs the total suffix from your endpoint to find it
	const url = PluginHelper.getPluginRestUrl('OfficePlugin/getall');
	
	// setting up our headers
	// we must include the CSRF token to validate the request
	const newHeaders = new Headers();
	newHeaders.append("X-XSRF-TOKEN", PluginHelper.getCsrfToken());
	
	// setting up our options block
	const options = {
		method: "GET",
		headers: newHeaders
	}
	
	// using fetch to actually make the call
	// this is async, so we must await before continuing
	const response = await fetch(url, options);
	
	// unpacking the JSON from the response
	// must await this, too, since it deals with a Promise
	const responseJSON = await response.json();
	
	for (let office of responseJSON) {
		let row = document.createElement('tr');
		row.innerHTML = '<td>' + office.id + '</td><td>' + office.department + '</td><td>' + office.address + '</td>';
		document.getElementById('table-body').appendChild(row);
	}
}

// the code below will actually run when the page loads
// we call our getAllOffices function by default on load

getAllOffices();