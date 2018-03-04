var stompClient = null;

function connect() {
    var socket = new SockJS('/wolf-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/home', function (customerDTO) {
            showNewCustomer(JSON.parse(customerDTO.body));
        });
    });
}

function showNewCustomer(customerDTO) {
    $("#customer").append(
        "<tr>" +
        "<td>" + customerDTO.name + "</td>" +
        "<td>" + customerDTO.address + "</td>" +
        "<td>" + customerDTO.email + "</td>" +
        "</tr>");
}
