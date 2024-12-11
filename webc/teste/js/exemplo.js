

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