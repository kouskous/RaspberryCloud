const axios = require('axios');

class SocketService {

    constructor() {
        this.clients = [];
    }

    connect(socket) {
        this.clients.push({
            identifier: null,
            websocket: socket
        })
        console.log(this.clients.length);
    }

    disconnect(socket) {
        this.clients.forEach(client => {
            if (socket === client.websocket) {
                this.clients.splice(this.clients.indexOf(client), 1);
            }
        });

        console.log(this.clients.length);
        // TODO store in db
    }

    processMessage(socket, message) {
        if (message.token !== undefined) {
            console.log(message);
            //setting token
            this.clients.forEach(client => {
                if (client.websocket === socket) {
                    client.identifier = message.token;
                }
            });
            //processing message
            axios.post('http://163.172.162.79:5000/message', message).then((res) => {
                let destinationIdentifiers = res.data;
                destinationIdentifiers.forEach(identifier => {
                    this.clients.forEach(client => {
                        if (client.identifier === identifier) {
                            client.websocket.send(JSON.stringify(message));
                        }
                    });
                })
            })
        }
    }
}

module.exports = SocketService