$('#loadSells').click(() => {
   reloadSells()
});

function reloadSells() {
    $("#author.container").empty();

    fetch("http://localhost:8080/all-sells").
        then(response => response.json()).
        then(json => json.forEach(sell => {
            let tableRow = '<tr>' +

        '<td>'+sell.egg  +'</td>' +
        '<td>'+sell.base  +'</td>'  +
        '<td>'+sell.countOfEgg  +'</td>'  +
        '<td>'+sell.cartons  +'</td>'  +
        '<td>'+sell.addDate  +'</td>'  +
        '<td>'+sell.client.firmName  +'</td>'  +
       ' <td>' +
           ' <button>Редактирай</button>' +
           ' <button>Изтрий</button>'+
        '</td>'+
         '</tr>'
        $("#authors-container").append(tableRow)
    }))
}