function showCollectionsList() {
    document.getElementById('collectionsList').style.display = 'none';
    if (document.getElementById('subcollectionCheck').checked) {
        document.getElementById('collectionsList').style.display = 'block';
    }
}

$(document).ready(function(){
    $("#searchInput").on("keyup", function() {
      var value = $(this).val().toLowerCase();
      $("#coinsTable tr").filter(function() {
        $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
      });
    });
  });