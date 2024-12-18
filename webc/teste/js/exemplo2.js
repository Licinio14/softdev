function getData() {
    // variables
    const pessoas = []
    const form = document.querySelector(".form")
    const registarBTN = document.querySelector("#registarBTN")
    const resultado = document.querySelector("#resultado")
   
    removePerson = function(index) {
        pessoas.splice(index, 1); // Remove the person from the array
        addPersonToResult(); // Update the list display
        console.log(pessoas)
    }
 
    function addPersonToResult() {
        resultado.innerHTML = ''
        pessoas.forEach((pessoa, index) => {
            resultado.innerHTML += `
            <div>
                <button onclick="removePerson(${index})">Remover</button>
                <span>${pessoa.nome}</span>
                <span>${pessoa.apelido}</span>
                <span>${pessoa.peso}</span>
                <span>${pessoa.altura}</span>
            </div>
            `
        })
    }
 
    function cleanInput() {
        form.querySelector("#nome").value = ''
        form.querySelector("#apelido").value = ''
        form.querySelector("#peso").value = ''
        form.querySelector("#altura").value = ''
    }
 
 
    function submitHandler(e) {
        e.preventDefault()
        const nome = document.querySelector("#nome").value
        const apelido = document.querySelector("#apelido").value
        const peso = document.querySelector("#peso").value
        const altura = document.querySelector("#altura").value
        if(nome && apelido && peso && altura) {
            pessoas.push({nome, apelido, peso, altura})
        }
        console.log(pessoas)
        cleanInput()
        addPersonToResult()
    }
 
    form.addEventListener('submit', submitHandler)
}
 
 
getData()





/*
let count = 0
const pessoas = []
const nome = document.getElementById("nome")
const apelido = document.getElementById("apelido")
const peso = document.getElementById("peso")
const altura = document.getElementById("altura")
const regisarBTN = document.getElementById("registarBTN")
const form = document.querySelector('.form')
//regisarBTN.disabled = true

function Limpar(){
    nome.value = ""
    apelido.value = ""
    peso.value = ""
    altura.value = ""
}

function Adicionar(){
    if(nome.value != "" && apelido.value != "" && peso.value != "" && altura.value != ""){
        pessoas.push({ nome: nome.value, apelido : apelido.value, peso: peso.value, altura : altura.value })
    }else{
        alert("Pessoa nao inserida")
    }
}

function Listar(){
        const adicionar = document.createElement('p');
        adicionar.innerHTML = `Nome: ${pessoas[count].nome} <br>Apelido: ${pessoas[count].apelido} <br>Peso: ${pessoas[count].peso} <br>Altura: ${pessoas[count].altura}<hr>`;
        document.body.appendChild(adicionar);
}


function defineActions(){
    // //registar
    // regisarBTN.addEventListener('click', function(e) {
    //     console.log(nome.value) //e.target.value
    // })
     // input
     nome.addEventListener('input', function(e){
         if(nome.value.lenght > 2) regisarBTN.disabled = false
     })

     form.addEventListener('submit', function(e){
        e.preventDefault()
        if(nome.value === "") {
            alert("Campo nome vazio")
            return
        }
        if(apelido.value === "") {
            alert("Campo apelido vazio")
            return
        }
        if(peso.value === "") {
            alert("Campo peso vazio")
            return
        }
        if(altura.value === "") {
            alert("Campo altura vazio")
            return
        }

        Adicionar()
        Listar()
        Limpar()

        count++
    })
}

defineActions()

*/