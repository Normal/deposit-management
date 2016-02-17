$(function () {

    $("#status").fadeOut(3000);

    $("#toUser").change(function () {
        var userName = $("#toUser").val();

        if (userName) {
            $.ajax({
                url: "/api/byuser",
                data: {
                    user: userName
                },
                success: function (data) {
                    $("#toDeposit").remove();
                    var sel = $('<select id="toDeposit" name="toDeposit">').appendTo('#to');
                    $(data).each(function() {
                        sel.append($("<option>").attr('value', this.number)
                                       .text(this.number + " - " + this.balance));
                    });
                }
            });
        }
    });

    $("#transfer_form").submit(function (event) {
        var from = $("#fromDeposit").find("option:selected");
        var to = $("#toDeposit").find("option:selected");
        var balance = from.attr("data");
        var amount = $("#amount").val();

        if (!amount) {
            handleError("Amount should be determined", event);
        }

        if (!to.length || !from.length) {
            handleError("Deposits should be defined", event);
        }

        if (balance - amount < 0) {
            handleError("Updated balance value can't be negative", event);
        }
    });
});

function handleError(message, event) {
    $("#error").html(message);
    event.preventDefault();
}