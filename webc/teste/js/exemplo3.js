//para puder obter respostas na consola
//const prompt = require('prompt-sync')()



const btn1 = document.getElementById("btn1")

//'https://dummyjson.com/recipes/1'

function Mostrarreceita(){
    fetch(`https://dummyjson.com/recipes/1`)
    .then(res => res.json())
    .then((res)=> {
        const adicionar = document.createElement('p');
        adicionar.innerHTML = `
        <hr>
        Nome: ${res.nome} <br>
        Ingredientes: ${res.ingredients} <br>
        Preparação: ${res.instructions} <br>
        Tempo de preparo: ${res.prepTimeMinutes} <br>
        Tempo de cuzimento: ${res.cookTimeMinutes}<br>
        Porções: ${res.servings}<br>
        Difficuldade: ${res.difficulty}<br>
        Cozinha: ${res.cuisine}<br>
        Calorias por porção: ${res.caloriesPerServing}<br>
        Tags: ${res.tags}<br>
        Rating: ${res.rating}<br>
        Comentarios: ${res.reviewCount}<br>
        Tipo: ${res.mealType}<br>
        <img src="${res.image}" style="width: 500px"> <hr>`;
        document.body.appendChild(adicionar);

    })
    .catch(error => {
        console.log("Erro")
    })
}

btn1.addEventListener('click', function(e) {
    Mostrarreceita()
    })




/*
// Desafio API: Retornar todos os utilizadores que tenham um determinado nome (prompt). No maximo 5 utilizadores


let nome = prompt("Nome: ")
fetch(`https://dummyjson.com/users/filter?key=firstName&value=${nome}&limit=5`)
.then(res => res.json())
.then(console.log);

*/

/*

//fetch

//'https://dummyjson.com/products?limit=10'

const id = 24
fetch(`https://dummyjson.com/products/${id}`)
    .then(response => {
        if(response.ok){
            return response.json()
        }
    })
    .then(data => console.log(data))
    .catch(error => console.log(`Erro: ${error}`))

*/

/*

// assincronismo
 
function sendMessage(msg, time) {
    setTimeout(() => {
        console.log(msg)
    }, time)
}
 
sendMessage("Hello", 2000)
sendMessage("All Good?", 1500)
sendMessage("Byeeee", 800)
 
/*
Promise
    resolve (resposta) -> then / async  
    reject (erro) -> catch
*/


/*

// timer
let count = 0
 
const timer = setInterval(() => {
    count++;
    console.log(count)
}, 1000)
 
setTimeout(() => {
    clearInterval(timer)
    console.log("Terminei!!!")
}, 6000)

*/


/*

// tratamento de erros
 
const val = 3
try {
    console.log(val/0)
}
catch (error){
    console.log(error)
}
finally {
    console.log("Terminou")
}

*/

/*

// destruturação
const arr = [1,2,3,4,5]
const [n1, n2, ...n3] = arr
console.log(n3)
 
const pessoa = {
    nome : 'Paula',
    idade : 23,
    morada: {
        rua : 'Rua qq coisa',
        localidade : 'Porto'
    }
}
 
const {nome, idade, morada: {localidade}} = pessoa
console.log(localidade)

*/