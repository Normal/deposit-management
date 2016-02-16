$(function () {

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
            alert("Amount should be determined");
            event.preventDefault();
        }

        if (!to.length) {
            alert("Transfer destination should be defined");
            event.preventDefault();
        }

        if (balance - amount <= 0) {
            alert("Updated balance value can't be negative");
            event.preventDefault();
        }
    });
});