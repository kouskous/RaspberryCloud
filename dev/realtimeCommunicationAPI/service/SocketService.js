class SocketService {
    

    constructor(){
        this.clients = [] ;
    }

    connect(socket) {
        this.clients.push({
            type: null,
            identifier: null,
            websocket: socket
        })
        // TODO store in db
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
            //TODO check identity in API
            this.clients.forEach(client => {
                if (socket === client) {
                   // TODO process message in API and get destination identifiers
                   // TODO send message to them if they are connected
                }
            });
        }
    }

}

module.exports = SocketService