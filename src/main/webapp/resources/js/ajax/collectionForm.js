$(document).ready(function () {
    const oldName = document.getElementById("collectionName").value;
    let validate = false;

    const form = document.getElementById("updateCollection");

    form.addEventListener("submit", function (event) {

        let name = document.getElementById("collectionName").value;

        if (oldName !== name) {
            validate = true;
        }

        if (validate) {
            let validity = true;

            const div = document.getElementById("ajaxText");
            div.innerHTML = "";

            $.ajax({
                url: "/api/collections/get_unique_name",
                type: "GET",
                data: {name:name},
                dataType: 'text',
                success:function (response) {
                    if (response === 'false') {
                        validity = false;
                    }
                },
                async: false
            });

            if (!validity) {
                div.innerHTML += "Name must be Unique";
                event.preventDefault();
            }
        }

    })
});