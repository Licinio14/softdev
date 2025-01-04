//variaveis globais
const listpais = document.getElementById("oppais")
const listcidade = document.getElementById("opcidade")
const map = document.getElementById("mapa")
const maisinfo = document.getElementById("maisinfo")

// função para validar o email
function validarEmail(email) {
    const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/
    return regex.test(email)
}

// função para "submeter" o formulario
function submeterform(){
    name.value = ""
    email.value = ""
    msn.value = ""
}

// função para validar os campos e mostrar o alerta personalizado
function mostraralerta() {
    const formulario = document.getElementById('formcontacto')
    const name = document.getElementById('nome')
    const email = document.getElementById('email')
    const msn = document.getElementById('msn')
    const vali = validarEmail(email.value)

    // valida os campos
    if(name.value == ""){
        document.getElementById("nomevali").innerHTML = "Insira o seu nome!"
    }

    if(!vali){
        document.getElementById("emailvali").innerHTML = "Insira um email valido!"
    }
    
    if(msn.value == ""){
        document.getElementById("msnvali").innerHTML = "Insira uma mensagem!"
    }

    // se tudo tiver ok mostra a mensagem e "submete" o form
    if (formulario.checkValidity()) {
        if (name.value != "" && vali == true && msn.value != ""){
            document.getElementById("alerta").style.display = "block"
            submeterform()
        }
        
    }
    
}
  
// função para esconder o alerta personalizado  
function fecharalerta() {
    document.getElementById("alerta").style.display = "none"
}

// função para quando a dropbox do pais for alterada, alterar as cidades no dropbox das cidades
function MudarCidades() {
    if (listpais.value == 0){
        //remove todas as opções do select
        listcidade.innerHTML = ""
        //acrescenta a default
        var escolha = document.createElement('option')  
        escolha.value = 0
        escolha.id = 0
        escolha.text = "Cidade"
        listcidade.appendChild(escolha)
    }else if (listpais.value == 1){
        //remove todas as opções do select
        listcidade.innerHTML = ""
        //Porto
        var escolha = document.createElement('option')  
        escolha.value = 1
        escolha.id = 1
        escolha.text = "Porto"
        listcidade.appendChild(escolha)
        //lisboa
        var escolha = document.createElement('option')  
        escolha.value = 2
        escolha.id = 2
        escolha.text = "Lisboa"
        listcidade.appendChild(escolha)
    }else if (listpais.value == 2){
        //remove todas as opções do select
        listcidade.innerHTML = ""
        //Madrid
        var escolha = document.createElement('option')  
        escolha.value = 3
        escolha.id = 3
        escolha.text = "Madrid"
        listcidade.appendChild(escolha)
        //Barcelona
        var escolha = document.createElement('option')  
        escolha.value = 4
        escolha.id = 4
        escolha.text = "Barcelona"
        listcidade.appendChild(escolha)
    }
}

function EscolherCidades(){
    if (listcidade.value == 1){
        //mapa
        var escolha = document.createElement('iframe')  
        escolha.value = 1
        escolha.id = 1
        escolha.src = `https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d48059.67686767844!2d-8.663153084466622!3d41.16224682871682!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd2465abc4e153c1%3A0xa648d95640b114bc!2sPorto!5e0!3m2!1sen!2spt!4v1736011971317!5m2!1sen!2spt`
        escolha.width="600"
        escolha.height="200"
        escolha.style="border:0;border-radius:20px;"
        escolha.allowfullscreen=""
        escolha.loading="lazy"
        escolha.referrerpolicy="no-referrer-when-downgrade"
        map.appendChild(escolha)
        //label em baixo
        var escolha2 = document.createElement('h2')
        escolha2.id = 1
        escolha2.textContent = "Living Around - Porto"
        escolha2.className = "maplabel"
        maisinfo.appendChild(escolha2)
        var quebraLinha = document.createElement('br')
        maisinfo.appendChild(quebraLinha)
        var escolha3 = document.createElement('p')
        escolha3.textContent = "Rua do Porto"
        escolha3.className = "maplabel"
        maisinfo.appendChild(escolha3)
        var escolha4 = document.createElement('p')
        escolha4.textContent = "4564-501, Porto"
        escolha4.className = "maplabel"
        maisinfo.appendChild(escolha4)
        var escolha5 = document.createElement('h2')
        escolha5.textContent = "livingaround_porto@living.com"
        escolha5.className = "maplabel"
        maisinfo.appendChild(escolha5)
    }else if (listcidade.value == 2){
        var escolha = document.createElement('iframe')  
        escolha.value = 2
        escolha.id = 2
        escolha.src = `https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d49789.64536434662!2d-9.20093525683055!3d38.74413916430406!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd19331a61e4f33b%3A0x400ebbde49036d0!2sLisbon!5e0!3m2!1sen!2spt!4v1736012752093!5m2!1sen!2spt`
        escolha.width="600"
        escolha.height="200"
        escolha.style="border:0;border-radius:20px;"
        escolha.allowfullscreen=""
        escolha.loading="lazy"
        escolha.referrerpolicy="no-referrer-when-downgrade"
        map.appendChild(escolha)
        //label em baixo
        var escolha2 = document.createElement('h2')
        escolha2.id = 1
        escolha2.textContent = "Living Around - Lisboa"
        escolha2.className = "maplabel"
        maisinfo.appendChild(escolha2)
        var quebraLinha = document.createElement('br')
        maisinfo.appendChild(quebraLinha)
        var escolha3 = document.createElement('p')
        escolha3.textContent = "Rua do Lisboa"
        escolha3.className = "maplabel"
        maisinfo.appendChild(escolha3)
        var escolha4 = document.createElement('p')
        escolha4.textContent = "4564-501, Lisboa"
        escolha4.className = "maplabel"
        maisinfo.appendChild(escolha4)
        var escolha5 = document.createElement('h2')
        escolha5.textContent = "livingaround_lisboa@living.com"
        escolha5.className = "maplabel"
        maisinfo.appendChild(escolha5)
    }else if (listcidade.value == 3){
        var escolha = document.createElement('iframe')  
        escolha.value = 3
        escolha.id = 3
        escolha.src = `https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d200454.59784603424!2d-3.691705615800683!3d40.2993279468684!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd422997800a3c81%3A0xc436dec1618c2269!2sMadrid%2C%20Spain!5e0!3m2!1sen!2spt!4v1736012808646!5m2!1sen!2spt`
        escolha.width="600"
        escolha.height="200"
        escolha.style="border:0;border-radius:20px;"
        escolha.allowfullscreen=""
        escolha.loading="lazy"
        escolha.referrerpolicy="no-referrer-when-downgrade"
        map.appendChild(escolha)
        //label em baixo
        var escolha2 = document.createElement('h2')
        escolha2.id = 1
        escolha2.textContent = "Living Around - Madrid"
        escolha2.className = "maplabel"
        maisinfo.appendChild(escolha2)
        var quebraLinha = document.createElement('br')
        maisinfo.appendChild(quebraLinha)
        var escolha3 = document.createElement('p')
        escolha3.textContent = "Rua do Madrid"
        escolha3.className = "maplabel"
        maisinfo.appendChild(escolha3)
        var escolha4 = document.createElement('p')
        escolha4.textContent = "4564-501, Madrid"
        escolha4.className = "maplabel"
        maisinfo.appendChild(escolha4)
        var escolha5 = document.createElement('h2')
        escolha5.textContent = "livingaround_madrid@living.com"
        escolha5.className = "maplabel"
        maisinfo.appendChild(escolha5)
    }else if (listcidade.value == 4){
        var escolha = document.createElement('iframe')  
        escolha.value = 4
        escolha.id = 4
        escolha.src = `https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d1458045.7712075347!2d0.9940023667015094!3d40.87008291403434!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x12a49816718e30e5%3A0x44b0fb3d4f47660a!2sBarcelona%2C%20Spain!5e0!3m2!1sen!2spt!4v1736012849242!5m2!1sen!2spt`
        escolha.width="600"
        escolha.height="200"
        escolha.style="border:0;border-radius:20px;"
        escolha.allowfullscreen=""
        escolha.loading="lazy"
        escolha.referrerpolicy="no-referrer-when-downgrade"
        map.appendChild(escolha)
        //label em baixo
        var escolha2 = document.createElement('h2')
        escolha2.id = 1
        escolha2.textContent = "Living Around - Barcelona"
        escolha2.className = "maplabel"
        maisinfo.appendChild(escolha2)
        var quebraLinha = document.createElement('br')
        maisinfo.appendChild(quebraLinha)
        var escolha3 = document.createElement('p')
        escolha3.textContent = "Rua do Barcelona"
        escolha3.className = "maplabel"
        maisinfo.appendChild(escolha3)
        var escolha4 = document.createElement('p')
        escolha4.textContent = "4564-501, Barcelona"
        escolha4.className = "maplabel"
        maisinfo.appendChild(escolha4)
        var escolha5 = document.createElement('h2')
        escolha5.textContent = "livingaround_barcelona@living.com"
        escolha5.className = "maplabel"
        maisinfo.appendChild(escolha5)
    }
}

//atribuir as cidades em função com o pais
listpais.addEventListener('change', function(e) {
    MudarCidades()
})

function VerMapa(){
    // limpa a parte do mapa se a lista for alterada
    map.innerHTML = ""
    maisinfo.innerHTML = ""

    document.getElementById("mapa").style.display = "block"
    document.getElementById("maisinfo").style.display = "block"
    EscolherCidades()
}

