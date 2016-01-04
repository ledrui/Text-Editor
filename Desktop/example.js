// a simple web server written in node respond with the message "Up and running" 

var http = require('http');
var requestFunc = function (req, res) {
	res.writeHead(200, {'Conten-Type': 'text/plain'});
	res.end('Up and running \n');
}

var server = http.createServer(requestFunc);

server.listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
