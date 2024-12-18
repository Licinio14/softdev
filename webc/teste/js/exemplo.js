//para puder obter respostas na consola
const prompt = require('prompt-sync')()








const pessoa = {
    name : "Maria",
    job : "Secretary",
    city : "Coimbra",
    salary : 3220.89,
    print(){
        console.log(`${this.name} ganha ${this.salary}€`)
    }
}

pessoa.print()





/*
const numeros = [3,7,4,6,95,21,56,7,6,15,89,47]

const double = numeros.map((val) => val * 2)
console.log(double)
*/

/*
const pessoas = [
    {nome: "Pedro", idade: 23},
    {nome: "Afonseca", idade: 41},
    {nome: "Ana", idade: 19}
]


if (!("job" in pessoas)) pessoas[0].job = "Formador"

console.log(pessoas)
*/


/*
const numeros = [3,7,4,6,95,21,56,7,6,15,89,47]
//filter pares
let pares = numeros.filter((val) => val%2 == 0)
console.log(pares)

//filter valores > 10
pares = numeros.filter((val) => val > 10)
console.log(pares)

const pessoas = [
    {nome: "Pedro", idade: 23},
    {nome: "Afonseca", idade: 41},
    {nome: "Ana", idade: 19}
]

// 1 - pessoas com idade menor que 30
pares = pessoas.filter((val) => val.idade < 30)
console.log(pares)

// 2 - nome menor que 4 carateres
pares = pessoas.filter((val) => val.nome.length < 4)
console.log(pares)

// 3 - nome começa letra a
pares = pessoas.filter((val) => val.nome.charAt(0) == "A")
console.log(pares)
*/

/*
const pessoa = []

function Imprimir(){
    if (pessoa.length > 0) console.log(pessoa)
        else console.log("Nao tem nada para mostrar")
    
}

function ExecutarManual(){
    let vali = true
    let count = 0
    do{
        console.log("Insira o nome da pessoa. Insira n para terminar.")
        let op = prompt("Opção: ")

        if (op == "n") vali = false
        else{
            console.log("Insira a idade da pessoa.")
            let idade = prompt("Opção: ") 
            console.log("Insira a localidade da pessoa.")
            let localidade = prompt("Opção: ")
            pessoa.push({ nome: op, idade: idade, localidade: localidade })
        }
        count++
        
    }while(vali)    
}

ExecutarManual()
Imprimir()
*/

/*
const numeros = Array()

function Random(max, min){
    return Math.floor(Math.random() * (max - min) + min)
}

function Imprimir(){
    console.log(numeros)
}


function ExecutarManual(){
    
    for(let i = 0;i < 5;i++){
        console.log("Insira um numero entre 1 e 30")
        let num = parseInt(prompt("Opção: "))
        if (num > 0 && num < 31){
            numeros.push(num)
        }else{
            i--
            console.log("Numero invalido")
        }
    } 
    
}

function Executar(max, min){
    
    for(let i = 0;i < 5;i++){
        let num = Random(max, min)
        if (num % 5 == 0){
            numeros.push(num)
        }else{
            i--
            let num = Random(51, 1)
        }
    } 
    
}

let max = 51
let min = 1
ExecutarManual()
Executar(max,min)
Imprimir()
*/


/*
const prompt = require('prompt-sync')()
 
function mensagem(msg="hello") {
    console.log(msg)
}
 
function soma(val1, val2) {
    return val1+val2
}
 
function ePar(val1) {
    return val1 % 2 == 0
}
 
function multiplos() {
    const val1 = 3
    const val2 = 5
    return [val1, val2]
}
 
// destruturação
const [n1,n2] = multiplos()
//console.log(n1)
mensagem("sdfsfsdfsdfsdf")
*/



/*

//exercicio de meno para inserir notas e terminar com "fim"
const notas = Array()
let vali = true


function Visualizar(){
    if(notas.length == 0) console.log("Nao existe notas para mostrar")
    else console.log(notas)
}

function Inserir(){
    console.log("Insira uma nota. Insira \"Fim\" para terminar.")
    const op = prompt("Opção: ")
    if( op.toLowerCase() == "fim"){
        return
    }else{
        const teste = parseInt(op)
        if (isNaN(teste) == false){
            let validacao = notas.includes(teste)
            if(validacao == false) notas.push(teste)
                else console.log("O valor ja existe!")
        }else {
            console.log("Tem de inserir apenas numeros")
        }
    }
}

function Pesquisar(){
    if(notas.length == 0) {
        console.log("Nao existe notas para pesquisar")
        return
    }


    console.log("Insira uma nota para pesquisar. Insira \"Fim\" para terminar.")
    const op = prompt("Opção: ")

    if( op.toLowerCase() == "fim"){
        return
    }else{
        const teste = parseInt(op)
        if (isNaN(teste) == false){
            let id = notas.indexOf(teste)
            if(id < 0) console.log("O valor ja existe!")
                else console.log("O valor esta na posição: " + id)
        }else {
            console.log("Tem de inserir apenas numeros")
        }
    }
}

function Remover(){
    if(notas.length == 0) {
        console.log("Nao existe notas para remover")
        return
    }


    Visualizar()
    console.log("Insira uma posição para eliminar entre 0 e " + notas.length + ". Insira \"Fim\" para terminar.")
    const op = prompt("Opção: ")

    if( op.toLowerCase() == "fim"){
        return
    }else{
        const teste = parseInt(op)
        if (isNaN(teste) == false){
            if(teste >= 0 && teste < notas.length) notas.splice(teste, 1)
                else console.log("Posição invalida")
            
        }else {
            console.log("Tem de inserir apenas numeros")
        }
    }
}

function Estatisticas(){
    if(notas.length == 0) {
        console.log("Nao existe notas para fazer estatisticas")
        return
    }


    let max, min, media = 0
    for (let i = 0; i < notas.length; i++){
        if (i == 0){
            max = notas[i]
            min = notas[i]
        }else{
            if (notas[i] > max ) max = notas[i]
        if (notas[i] < min ) min = notas[i]
        }
        media += notas[i]
    }

    media = media / notas.length
    console.log(`O maximo é ${max} e o minimo é ${min}`)
    console.log(`A media é ${media}`)
    console.log("O array tem: " + notas.length + " elementos.")


}


function Menu(){
    do{
        
        if (notas.length > 0){
            console.log("1 - Visualizar \n 2 - Inserir \n 3 - Pesquisar \n 4 - Remover \n 5 - Estatisticas \n 6 - Sair")
        }else{
            console.log("1 - Visualizar \n 2 - Inserir \n  6 - Sair")
        }

        const op = prompt("Opção: ")
        
        if (isNaN(op) == false){
            switch (parseInt(op)){
                case 1:
                    Visualizar()
                    break
                case 2:
                    Inserir()
                    break
                case 3:
                    Pesquisar()
                    break
                case 4:
                    Remover()
                    break
                case 5:
                    Estatisticas()
                    break
                case 6:
                    return
                default:
                    console.log("Insira uma opção valida")
    
            }
        }else {
            console.log("Tem de inserir apenas numeros")
        }
    }while(vali)
}

Menu()
*/


/*

//EX1


const numeros = Array()
let vali = true

do{
    console.log("Insira um valor numerico. Insira 0 para terminar.")
    const op = parseInt(prompt("Opção: "))
    if (isNaN(op) == false){
        if ( op === 0) vali = false;
        else numeros.push(op)
    }else {
        console.log("Tem de inserir apenas numeros")
    }
}while(vali)


let max, min, media = 0, elementos

for (let i = 0; i < numeros.length; i++){
    if (i == 0){
        max = numeros[i]
        min = numeros[i]
    }else{
        if (numeros[i] > max ) max = numeros[i]
    if (numeros[i] < min ) min = numeros[i]
    }
    media += numeros[i]
}

media = media / numeros.length

console.log(numeros)
console.log(`O maximo é ${max} e o minimo é ${min}`)
console.log(`A media é ${media}`)
console.log("O array tem: " + numeros.length + " elementos.")

*/


/*
const prompt = require('prompt-sync')()
 
// globals
values = [2,8,1,3,4]
 
function maximo(vec) {
    let max = undefined
    if(vec.length > 0) {
        for(let i in vec) { // problema: no for in qd fazemos let i ele guarda o valor como texto - key
            if(i == 0) max = vec[i]
            else {
                if(vec[i] > max) max = vec[i]
            }
            console.log(`i:${i} vec:${max}`)
        }
    }
    return max
}
 
function maximoV2(vec) {
    let max = undefined
    if(vec.length > 0) {
        for(let value of vec) {
           if(max === undefined || value > max) max = value
        }
    }
    return max
}
 
function maximoV3(vec) {
    let max = undefined
    if(vec.length > 0) {
        for(let i = 0; i < vec.length; i++) {
            if(i === 0) max = vec[i]
            else {
                if(vec[i] > max) max = vec[i]
            }
        }
    }
    return max
}
 
console.log(maximo(values))
console.log(maximoV2(values))
console.log(maximoV3(values))
*/

/*
const pesoas = ["Ana", "Sofia", "Carlos", "Pedro", "Alberto"]

let i = 0
while(i < pesoas.length){
    console.log(pesoas[i])
    i++
}

i = 0

do{
    console.log(pesoas[i])
    i++
}while(i < pesoas.length)

while(True){
    //condição de paragem
    if(i === 9) break
    console.log(i ** 2)
    i++
}
*/

/*
const pessoa = {
    nome : "Maria",
    idade : 44,
    salario : 1234.56,
    morada : {
        localidade : "Ovar",
        cod_postal : "3880-123",
        porta : 2
    }
}

//console.log(pessoa)
//console.log(pessoa.morada.porta)

// for (let elem in pessoa) {
//     console.log(`índice: ${elem} valor: ${pessoa[elem]}`)
// }

const arrPessoas = []
arrPessoas.push(pessoa)
console.log(arrPessoas)
*/

/*
const pesoas = ["Ana", "Sofia", "Carlos", "Pedro", "Alberto"]

for (let i = 0; i < pesoas.length; i++){
    console.log(pessoas[i])
}

for (let i in pesoas){
    console.log(pessoas[i])
}

for (let pessoa of pesoas){
    console.log(pessoa)
}
*/

/*
const arr1 = [1,2,3]
const arr2 = [7,8,9]
//const arr3 = arr1.concat(arr2)
//os pontos serve para que adicione o conteudo dos arrays
arr3 = [...arr1,4,5,6,...arr2]
//insere os arrays no array 4
arr4 = [arr1,arr2]
console.log(arr3)
*/


/*
const arr2 = ["Texto", 12, 13.34, true, [1,2,3,4]]

// slices do inicio ate ao penultimo
const slice = arr2.slice(0,-1)
console.log(slice)
*/


/*
let texto = "Eu sou um texto"
// texto = "dfgdfgfdrg" - nova atribuição
const textoArray = texto.split(" ")
textoArray[0] = "X"
texto = textoArray.join(" ")
console.log(textoArray)
console.log(texto)
*/

/*

 // val é passado por cópia e vec por referência
 val+=1
 vec[0] = "Alterou?????"
}

let x = 3
const arr2 = ["Texto", 12, 13.34, true, [1,2,3,4]]
altera(x, arr2)
console.log(x)
console.log(arr2)
*/

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