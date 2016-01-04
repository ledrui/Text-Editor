// a simple TCP server which listens on port 1337 and echoes whatervern you send it

var net = require('net');

var server = net.createServer(function (socket){
	socket.write('Echo server\r\n');
	socket.pipe(socket);
});

server.listen(3000, '127.0.0.1');
