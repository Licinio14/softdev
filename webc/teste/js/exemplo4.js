
const list = document.getElementById("receitas")
const campo = document.getElementById("campo")
let count = 0



function Listar(data){
  
    data.recipes.forEach(res => {
        var escolha = document.createElement('option')  
        escolha.value = res.id
        escolha.id = res.id
        escolha.text = res.name
        list.appendChild(escolha)
    });

    /*
    for(let i = 0; i < 10 ; i++){
        var escolha = document.createElement('option')  
        escolha.value = i + 1
        escolha.id = i + 1
        escolha.text = data.recipes[i].name
        list.appendChild(escolha)
    }
    */
    
}


function Api(){
    fetch(`https://dummyjson.com/recipes?limit=10&select=name`)
        .then(response => {
            if(response.ok) {
                return response.json()
            }})
        .then(data => {
                Listar(data); 
                
            })
        .catch(error => {
            console.log("Erro")
        })

}

function Imprimir(data){
    campo.innerHTML = `
        <h2>${data.name}</h2>
        <p><strong>Cuisine:</strong> ${data.cuisine}</p>
        <p><strong>Difficulty:</strong> ${data.difficulty}</p>
        <p><strong>Cook Time:</strong> ${data.cookTimeMinutes} minutos</p>
        <p>
            <strong>Ingredients:</strong>
            <ul>
                ${data.ingredients.map(ingredient => `<li>${ingredient}</li>`).join('')}
            </ul>
        </p>
        <p>
            <strong>Instructions:</strong>
            <ul>
                ${data.instructions.map(instruction => `<li>${instruction}</li>`).join('')}
            </ul>
        </p>
        <p><img src='${data.image}' alt='Image of ${data.name}'></p>
       
    `  
}

function Mostrarreceita(){
    let i = list.value
    
    if(parseInt(i) != 0){
        fetch(`https://dummyjson.com/recipes/${i}`)
            .then(res => res.json())
            .then((data)=> {
                Imprimir(data)
            })
            .catch(error => {
                console.log(error)
            })
    }else{
        campo.innerHTML = ``
    }
    
}


list.addEventListener('change', function(e) {
        Mostrarreceita()
    })


//chamar on load
window.onload = function() {
    Api();
}