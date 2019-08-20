'use strict';

const
  io = require("socket.io"),
  server = io.listen(8080),
  SocketService = require('./service/SocketService.js'),
  socketService = new SocketService();

console.log("listening in port: 8080");

server.on("connection", (socket) => {
  socketService.connect(socket);

  socket.on('message', function (message) {
    socketService.processMessage(socket, message);
  });

  socket.on("disconnect", () => {
    socketService.disconnect(socket);
  });
});