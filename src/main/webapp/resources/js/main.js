function showCollectionsList() {
    document.getElementById('collectionsList').style.display = 'none';
    if (document.getElementById('subcollectionCheck').checked) {
        document.getElementById('collectionsList').style.display = 'block';
    }
}