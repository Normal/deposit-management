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
        var balance = $("#fromDeposit").find("option:selected").attr("data");
        var amount = $("#amount").val();

        // TODO: add additional conditions here
        if (balance - amount >= 0) {
            return;
        }

        event.preventDefault();
    });
});