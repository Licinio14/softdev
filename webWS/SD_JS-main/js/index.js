let shopingList = [];

let vali = true

let response = ""

// do{

//     response = prompt("Que item deseja adicionar? |Apagar -> agaga o ultimo item|Enviar -> emvia a lista|")


//     if(response === "apagar"){
//         shopingList.pop()
//     }else if(response === "enviar"){
//         vali = false
//     }else {
//         shopingList.push(response)
//     }

// }while(vali)

function Inserir(){
    response = prompt("Que item deseja adicionar? |Apagar -> agaga o ultimo item|Enviar -> emvia a lista|")
    shopingList.push(response.toLowerCase())
}

function Apagar(){

    if(shopingList.length > 0 ){
        shopingList.pop()
    alert('Item foi apagado com sucesso!')
    }

}

function Mostrar(){
    for (const element of shopingList) {
        alert(element)
    }


    // console.log(shopingList)
}


const fullNames = [
    {first: 'Albus', last: 'Dumbledore'}, 
    {first: 'Harry', last: 'Potter'}, 
    {first: 'Hermione', last: 'Granger'}, 
    {first: 'Ron', last: 'Weasley'}, 
    {first: 'Rubeus', last:'Hagrid'}, 
    {first: 'Minerva', last: 'McGonagall'}, 
    {first: 'Severus', last: 'Snape'}
];jjgjgjggyhjgg



let firstNames = fullNames.map(name => name.first.toUpperCase())

console.log(firstNames)
    