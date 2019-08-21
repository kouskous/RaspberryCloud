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
    }

    disconnect(socket) {
        this.clients.forEach(client => {
            if (socket === client) {
                this.clients.splice(this.clients.indexof(client), 1);
            }
        });
        // TODO store in db
    }

    processMessage(socket, message) {
        if (message.token !== undefined) {
            console.log(message);
            //setting token
            this.clients.forEach(client => {
                if (client.websocket === socket) {
                    client.identifier = message.token;
                    console.log("setting token "+ client.identifier);
                }
            });
            //processing message
            axios.post('http://163.172.162.79:5000/message', message).then((res) => {
                let destinationIdentifiers = res.data;
                destinationIdentifiers.forEach(identifier => {
                    this.clients.forEach(client => {
                        if (client.identifier === identifier) {
                            client.websocket.emit('message', message);
                        }
                    });
                })
            })
        }
    }
}

module.exports = SocketService