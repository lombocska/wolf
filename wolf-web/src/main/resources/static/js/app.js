var stompClient = null;

function connect() {
    var socket = new SockJS('/wolf-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        // setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/home', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });
    });
}

function showGreeting(customer) {
    $("#customer").append("<tr><td>" + customer.name + "</td></tr>");
}

connect();