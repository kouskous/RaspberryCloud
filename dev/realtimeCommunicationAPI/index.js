'use strict';

const
  WebSocket = require('ws'),
  wss = new WebSocket.Server({ port: 8080 }),
  SocketService = require('./service/SocketService.js'),
  socketService = new SocketService();


wss.on('connection', function connection(socket) {
  socketService.connect(socket);
  socket.on('message', function incoming(message) {
    try {
      var messageObject = JSON.parse(message);
      socketService.processMessage(socket, messageObject);
    } catch (e) {

    }
  });

  socket.on('close', function close() {
    socketService.disconnect(socket);
    
  });
});




