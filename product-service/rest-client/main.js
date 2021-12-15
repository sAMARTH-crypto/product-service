function loadCustomers() {
    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/customers",
        success: function (data) {
            data.forEach(function (item) {
                $('tbody').append('<tr>'
                    + '<td>' + item.firstName + '</td>'
                    + '<td>' + item.lastName + '</td>' +
                    '<td>' + item.email + '</td>' +
                    '<td>' + item.telephone + '</td>' +
                    '<td>' + item.address + '</td>' +
                    '<td><a href="customer.html?id=' + item.id + '" class="btn btn-sm btn-warning">View</a></td>' +
                    '</tr>')
            });
        }
    });
}

function getVariables() {
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
    for (var i = 0; i < hashes.length; i++) {
        hash = hashes[i].split('=');
        vars.push(decodeURIComponent(hash[0]));
        vars[decodeURIComponent(hash[0])] = decodeURIComponent(hash[1]);
    }
    if (vars[0] == window.location.href) {
        vars = [];
    }
    return vars;
}

function loadCustomer() {
    var params = getVariables();
    var id = params["id"];

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/customers/" + id,
        success: function (data) {

            var name = data.firstName + " " + data.lastName;

            $("#name").html(name);
            $("#email").html(data.email);
            $("#address").html(data.address);
            $("#telephone").html(data.telephone);

        }
    });
}


function loadCustomerOrders() {
    var params = getVariables();
    var id = params["id"];

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/customers/" + id + "/orders",
        success: function (data) {
            data.forEach(function (item) {
                $('tbody').append('<tr>'
                    + '<td>' + item.date + '</td>'
                    + '<td>' + item.payment + '</td>' +
                    '<td>' + item.total + '</td>' +
                    '<td><a href="orders.html?orderId=' + item.id + '&customerId=' + id + '" class="btn btn-sm btn-warning">View</a></td>' +
                    '</tr>');
            });
        }
    });
}


function loadOrder() {
    var params = getVariables();
    var orderId = params["orderId"];
    var customerId = params["customerId"];

    $.ajax({
        type: "GET",
        dataType: "json",
        url: "http://localhost:8080/customers/" + customerId + "/orders/" + orderId,
        success: function (data) {
            console.log(data);

            $("#date").html(data.date);
            $("#payment").html(data.payment);
            $("#total").html(data.total);

        }
    });
}