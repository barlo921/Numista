$(document).ready(function () {

    const date = new Date().getFullYear() + 1;
    document.getElementById('coinYear').setAttribute("max", date);

    $("#topLevelCollectionsList").change(function(){

        const collectionId = document.getElementById("topLevelCollectionsList").value;

        $.ajax({
            url: "/api/collections/get_subcollections",
            type: "GET",
            data: {id:collectionId},
            dataType: 'json',
            success:function(response){

                const len = response.length;

                $("#collectionsList").empty();
                for( let i = 0; i<len; i++){
                    let id = response[i]['id'];
                    let name = response[i]['name'];

                    $("#collectionsList").append("<option value='"+id+"'>"+name+"</option>");

                }
            }
        });
    });
});
