function test(){
    const name = document.getElementById('inputName').value
    const email = document.getElementById('inputEmail3').value
    const senha = document.getElementById('inputPassword3').value
    const valiemail = validarEmail(email)

    
    if (valiemail == false && name.length <= 3 && senha.length <= 8){
        alert("Insira um nume com mais de 3 letras, um email valido e uma senha com mais de 8 caracteres")
    }else if (valiemail == false && name.length <= 3){
        alert("Insira um email valido e um nome com mais de 3 letras")
    }else if (senha.length <= 8 && name.length <= 3){
        alert("Insira uma senha com mais de 8 caracteres e um nome com mais de 3 letras")
    }else if (valiemail == false && senha.length <= 8){
        alert("Insira um email valido e uma senha com mais de 8 caracteres")
    }else if (valiemail == false){
        alert("Insira um email valido")
    }else if (senha.length <= 8){
        alert("Insira um nome com pelo menos 8 caracteres")
    }else if (name.length <= 3){
        alert("Insira um nome com pelo menos 3 letras")
    }

    const formulario = document.getElementById("meuFormulario");
    formulario.submit();


}

function validarEmail(email) {
    const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    return regex.test(email);
}

function gerarSenha(){
    const letras = "abcdefghijklmnopqrstuvwxyz"
    const numeros = "0123456789"
    const simbolos = "\|!@#£$§%&/=?*+-_:.;,<>"
    let senha = ""
    


    let tamanho
    tamanho = prompt("Digite o numero de caracteres")

    for (let i = 0 ; i < tamanho ; i++){
        let x = 1;
        let y = 7;
        let numero = numeroRandomico(x, y);
        switch (numero){
            case 2:
                x = 0
                y = 9
                numero = numeroRandomico(x, y);
                senha += numeros.charAt(numero)
            break
            case 5:
                x = 0
                y = 22
                numero = numeroRandomico(x, y);
                senha += simbolos.charAt(numero)
            break
            default:
                x = 0
                y = 25
                numero = numeroRandomico(x, y);
                senha += letras.charAt(numero)
            break
        }

    }
    alert("A senha gerada é: " + senha)
    
}

function numeroRandomico(x, y) {
    return Math.floor(Math.random() * (y - x + 1)) + x;
}