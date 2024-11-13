function testConnection(randomId) {
    console.log("Inside test: " + randomId);

    // Make the API request to Spring Boot backend
    fetch(`http://127.0.0.1:8080/api/resource/${randomId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        }
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok: ' + response.statusText);
        }
        return response.json(); // Parse the JSON from the response
    })
    .then(data => {
        console.log(data);
        // Display the fetched data in JSON format
        document.getElementById('output').textContent = JSON.stringify(data, null, 2);
    })
    .catch(error => {
        console.error('Error:', error);
    });
}

function uuidv4() {
    var randomid = 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'
    .replace(/[xy]/g, function (c) {
        const r = Math.random() * 16 | 0,
            v = c == 'x' ? r : (r & 0x3 | 0x8);
        return v.toString(16);
    });
    console.log('Generated UUID:', randomid);
    testConnection(randomid);
}
