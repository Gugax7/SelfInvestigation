const http = require("http");
const WebSocketServer = require('websocket').server;

const httpServer = http.createServer();

const connections = [];

const webSocket = new WebSocketServer({
  "httpServer": httpServer
});

httpServer.listen(8080, () => console.log("My server is listening on port 8080"));

webSocket.on("request", (request) => {
  const connection = request.accept(null, request.origin);
  connection.on("message", (message) => {
    connections.forEach(c => {
      c.send(`User ${connection.socket.remotePort} sent: ${message.utf8Data}`)
    })
  })

  connections.push(connection);
  connections.forEach(c => c.send(`User ${connection.socket.remotePort} joined the chat.`));
})