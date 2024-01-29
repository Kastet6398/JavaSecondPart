function loadPersonDetails() {
    $.ajax({
        url: '/api/person',
        type: 'GET',
        dataType: 'json',
        success: function (data) {
            $('#name').val(data.name);
            $('#age').val(data.age);
        },
        error: function () {
            console.error('Error loading person details.');
        }
    });
}

function submitPersonDetails() {
    var name = $('#name').val();
    var age = $('#age').val();

    $.ajax({
        url: '/api/person',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({ name: name, age: age }),
        success: function () {
            console.log('Person details updated successfully.');
        },
        error: function () {
            console.error('Error updating person details.');
        }
    });
}

$(document).ready(function () {
    loadPersonDetails();
    setInterval(loadPersonDetails, 500);
});
