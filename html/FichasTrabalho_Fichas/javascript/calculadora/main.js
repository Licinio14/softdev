let n5 = 0;
let operacao;

function enviar(n1){
    document.getElementById('view').value += n1;
}

function somar(){
    if (n5 == null || n5 == 0){
        n5 = parseInt(document.getElementById('view').value);
    }else{
        n5 = n5 + parseInt(document.getElementById('view').value);
    };
    operacao = "+";
    document.getElementById('view').value = "";
}

function subtrair(){
    if (n5 == null || n5 == 0){
        n5 = parseInt(document.getElementById('view').value);
    }else{
        n5 = n5 - parseInt(document.getElementById('view').value);
    };
    operacao = "-";
    document.getElementById('view').value = "";
}

function dividir(){
    if (n5 == null || n5 == 0){
        n5 = parseInt(document.getElementById('view').value);
    }else{
        n5 = n5 / parseInt(document.getElementById('view').value);
    };
    operacao = "/";
    document.getElementById('view').value = "";
}

function multiplicar(){
    if (n5 == null || n5 == 0){
        n5 = parseInt(document.getElementById('view').value);
    }else{
        n5 = n5 * parseInt(document.getElementById('view').value);
    };
    operacao = "*";
    document.getElementById('view').value = "";
}

function resetar(n2){
    n5 = n2;
}

function calcular(){
    if (operacao == "+"){
        n5 = n5 + parseInt(document.getElementById('view').value);
    }else if (operacao == "-"){
        n5 = n5 - parseInt(document.getElementById('view').value);
    }else if (operacao == "*"){
        n5 = n5 * parseInt(document.getElementById('view').value);
    }else if (operacao == "/"){
        n5 = n5 / parseInt(document.getElementById('view').value);
    }
    document.getElementById('view').value = n5;
    n5 = 0;
}

function multiplicar2(){
    let multi = 0;
    multi = (parseInt(document.getElementById('numero1').value)) * (parseInt(document.getElementById('numero2').value));
    document.getElementById('resultado').value = multi;
}

function dividir2(){
    let multi = 0;
    multi = (parseInt(document.getElementById('numero1').value)) / (parseInt(document.getElementById('numero2').value));
    document.getElementById('resultado').value = multi;
}

function somar2(){
    let multi = 0;
    multi = (parseInt(document.getElementById('numero1').value)) + (parseInt(document.getElementById('numero2').value));
    document.getElementById('resultado').value = multi;
}

function subtrair2(){
    let multi = 0;
    multi = (parseInt(document.getElementById('numero1').value)) - (parseInt(document.getElementById('numero2').value));
    document.getElementById('resultado').value = multi;
}