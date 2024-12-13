
/*
const prompt = require('prompt-sync')()
 
function menu() {
    while(true) {
        console.log("\nMenu:\n1 - Ler valores\n2 - Ver valores\n3 - Média\n4 - Máximo\n5 - Mínimo\n6 - Sair")
        op = parseInt(prompt("Opção: "))
        switch(op) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                console.log(`\nClicou na opção ${op}`)
                break
            case 6:
                return
            default:
                console.log("\nErro: opção inválida!\n")
        }
    }
}
 
menu()
*/ 


/*
const login = "xpto"
const password = "12345"

const sucess = login === "teste" && password ==="12345"
console.log(sucess)
*/

/*
const numero = prompt("qual é o numero")
document.body.innerHTML += `<p>Número inserido: ${numero} </p>`
document.body.innerHTML += `<p>Raiz quadrada: ${Math.sqrt(numero)} </p>`
document.body.innerHTML += `<p> ${numero} é inteiro: ${Number.isInteger(numero)} </p>`
document.body.innerHTML += `<p> ${numero} é NaN: ${Number.isNaN(numero)} </p>`
document.body.innerHTML += `<p> Arredondado para baixo: ${Math.floor(numero)} </p>`
document.body.innerHTML += `<p> Arredondado para cima: ${Math.ceil(numero)} </p>`
document.body.innerHTML += `<p> Arredondado para cima: ${(numero).toFixed(2)} </p>`
*/

/*
const n1 = 4.1355456
//console.log(n1.toFixed(3))
 
// if(Number.isInteger(n1)) console.log("Inteiro")
// else console.log("NOT Inteiro")
 
console.log(typeof n1)
//isNaN
if(typeof n1 == "number") console.log("Número")
else console.log("NOT Número")    
*/

/*
nome = prompt("Qual é o seu nome?")
document.body.innerHTML += `<p>Chamo-me <strong>${nome}</strong></p>`
const tamanho = nome.length
document.body.innerHTML += `<p>O ${nome} tem ${tamanho} letras</p>`
const segunda = nome[1]
document.body.innerHTML += `<p>A segunda letra do meu nome é: ${segunda}</p>`
const indece = nome.indexOf('e')
document.body.innerHTML += `<p>O indice da letra "e" do meu nome é: ${indece}</p>`
document.body.innerHTML += `<p>O ultimo indice da letra "r" do meu nome é: ${nome.lastIndexOf("r")}</p>`
document.body.innerHTML += `<p>As ultimas 3 letras do meu nome sao: ${nome.slice(-3)}</p>`
document.body.innerHTML += `<p>Nome em minusculas: ${nome.toLowerCase()} e em maiusculas:  ${nome.toUpperCase()} </p>`

*/

/*
const teste = "eu gosto de JS"
let novo = ""

function vowels(){
    for (let i = 0; i < teste.length; i++){
        if (teste[i] == "a" || teste[i] == "e" || teste[i] == "i" || teste[i] == "o" || teste[i] == "u"){
            novo += teste[i].toUpperCase();
        }else{
            novo += teste[i].toLowerCase();
        }
    }
    return novo
}

console.log(vowels())

*/

/*
//       012345
const texto = "ef sef sefsefsef sef sf<fsefs es<fsfgrdgd rgdrg drgdrgdrg"
 
// índices 0 até N-1 (N n.º de elementos)
console.log(texto[0])
console.log(texto.charAt(texto.length - 1))
console.log(texto.indexOf('a'))
console.log(texto.slice(0,5))
console.log(texto.slice(-3))
palavras = texto.split(" ")
console.log(palavras[1].toLowerCase())
console.log(palavras[1].toUpperCase())

*/
/*
 num1 = parseInt(prompt("digite o primeiro numero"))
 num2 = parseInt(prompt("digite o primeiro numero"))
alert(num1 + num2);
*/
/*

//crie uma função que retorne um valor numerico gerado entre x e y

function generateRandomNumbers(min, max){
    let vali = true
    while (vali) {
        let num = ((Math.random()*100)+1).toFixed(0)
        if (num > min && num < max){
            vali = false
            return num;
        }else {
            vali = true
        }
    }
}


let numero = generateRandomNumbers(1, 100)
console.log(numero)

*/
/*
//Math

const pi = 3.1415

//console.log(Math.floor(pi))
//console.log(Math.ceil(pi))
//console.log(Math.random())

//gerar 10 numeros inteiros entre 1 e 100
function generate10RandomNumbers(number){
    for (let i = 0; i < number; i++){
        console.log(((Math.random()*100)+1).toFixed(0))
    }
}

generate10RandomNumbers(5)
*/
/*
num1 = 3.13

console.log(Number.isInteger(num1))

if (typeof num1 == 'number'){
    console.log("Number!")
}
*/


/* ficha 1
const peso = 65
const altura = 1.75
const nome = "Pedro"
const apelido = "Fonseca"
let imc


imc = (peso / (altura ** 2)).toFixed(2)

console.log(`O(a) ${nome} ${apelido} tem um imc de ${imc}!`)

*/

/*
//cast
const b = parseInt("4")
const c = parseFloat("4.56")
const d = Number("5.11")
console.log(c.toString())

//ver os tipos da variavel
//console.log(typeof age)

//console.log("O(a) " + name + " tem " + age + " anos!")

//template string
//console.log(`O(a) ${name} tem ${age} anos!`)

*/