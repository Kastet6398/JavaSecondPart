function loadPersonName() {
    $.ajax({
        url: '/api/person',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#nameSpan').text(data.name != undefined? ', ' + data.name : '');
        },
        error: function () {
            console.error('Error loading person details.');
        }
    });
}

$(document).ready(function () {
    loadPersonName();
    setInterval(loadPersonName, 500);
});
