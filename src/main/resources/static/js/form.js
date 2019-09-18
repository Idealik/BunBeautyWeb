$(window).load(function () {
    var phones = [{"mask": "+7(###) ###-##-##"}];
    $('#phone').inputmask({
        mask: phones,
        greedy: false,
        definitions: {'#': {validator: "[0-9]", cardinality: 1}}
    });
});


/*$("button").click(function () {
    alert("lol")
    if ($('#name-input').val() === '') {
        $('#name-input').popover({
            container: 'body'
        })
    }
});*/
