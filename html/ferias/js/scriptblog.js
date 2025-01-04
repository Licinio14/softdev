
//variaveis globais
const dropnoticia = document.getElementById("opnoticia")
const apresentarnoticia = document.getElementById("apresentarnoticia")


//função para preencher a dropbox do blog
function PreencherNoticias(){
    for(let i = 1; i <= 5; i++){
        // acrescenta opções
        var escolha = document.createElement('option')  
        escolha.value = i
        escolha.id = i
        escolha.text = `Noticia ${i}`
        dropnoticia.appendChild(escolha)
    }
}

//chamar on load
window.onload = function() {
    PreencherNoticias()
}

function MostrarAnoticia(){
    apresentarnoticia.innerHTML = ""
    if(dropnoticia.value == 1){
        document.getElementById("apresentarnoticia").style.display = "block"
        //informação da noticia
        var escolha = document.createElement('h1')
        escolha.id = 1
        escolha.textContent = `Noticia imperdivel nº${dropnoticia.value}!!!`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var div = document.createElement('div')
        div.className = "text-center"
        div.innerHTML = '<img src="Imagens/pexels-alex-andrews-271121-1203808.jpg" class="imagemblognoticias">';
        apresentarnoticia.appendChild(div)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var escolha = document.createElement('h2')
        escolha.id = 2
        escolha.textContent = `Descobertas Marítimas em Portugal: Um Legado de Exploração`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var p = document.createElement('p')
        p.className = "paragrafoblog"
        p.textContent = 'Portugal é conhecido como o berço das grandes navegações, sendo pioneiro na Era dos Descobrimentos, entre os séculos XV e XVI. Navegadores como Vasco da Gama e Pedro Álvares Cabral expandiram os horizontes do mundo conhecido, traçando rotas marítimas para a Índia, Brasil e outras regiões.'
        apresentarnoticia.appendChild(p)
        var p1 = document.createElement('p')
        p1.className = "paragrafoblog"
        p1.textContent = 'Hoje, o legado das explorações portuguesas é celebrado em monumentos como o Padrão dos Descobrimentos, em Lisboa, e no Museu Marítimo de Belém. Além disso, a navegação continua a desempenhar um papel importante na economia do país, com os portos portugueses liderando no comércio europeu.'
        apresentarnoticia.appendChild(p1)
        var p2 = document.createElement('p')
        p2.className = "paragrafoblog"
        p2.textContent = 'A paixão pela exploração e o mar continuam vivos, inspirando gerações a descobrir novos mundos. 🌍🚢'
        apresentarnoticia.appendChild(p2)
    }else if(dropnoticia.value == 2){
        document.getElementById("apresentarnoticia").style.display = "block"
        //informação da noticia
        var escolha = document.createElement('h1')
        escolha.id = 1
        escolha.textContent = `Noticia imperdivel nº${dropnoticia.value}!!!`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var div = document.createElement('div')
        div.className = "text-center"
        div.innerHTML = '<img src="Imagens/estrada_outono.jpg" class="imagemblognoticias">';
        apresentarnoticia.appendChild(div)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var escolha = document.createElement('h2')
        escolha.id = 2
        escolha.textContent = `Estradas em Florestas de Portugal: Um Encontro com a Natureza`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var p = document.createElement('p')
        p.className = "paragrafoblog"
        p.textContent = 'As estradas que serpenteiam pelas florestas de Portugal são verdadeiros cenários de beleza natural. Desde a tranquilidade do Parque Nacional da Peneda-Gerês até as densas matas de Sintra, essas rotas oferecem paisagens deslumbrantes, onde a conexão com a natureza é inevitável.'
        apresentarnoticia.appendChild(p)
        var p1 = document.createElement('p')
        p1.className = "paragrafoblog"
        p1.textContent = 'Essas vias não apenas ligam comunidades, mas também proporcionam experiências únicas, com caminhos ladeados por pinheiros, eucaliptos e carvalhos, especialmente encantadores durante o outono, quando as folhas ganham tons dourados e avermelhados.'
        apresentarnoticia.appendChild(p1)
        var p2 = document.createElement('p')
        p2.className = "paragrafoblog"
        p2.textContent = 'Além de seu valor estético, essas estradas têm importância estratégica para o turismo e o acesso a áreas rurais. No entanto, a preservação ambiental é uma preocupação constante, com iniciativas que buscam minimizar o impacto humano e proteger as florestas do país.'
        apresentarnoticia.appendChild(p2)
        var p3 = document.createElement('p')
        p3.className = "paragrafoblog"
        p3.textContent = 'Viajar por essas estradas é um convite para apreciar a harmonia entre infraestrutura e natureza. 🌲🚗'
        apresentarnoticia.appendChild(p3)
    }else if(dropnoticia.value == 3){
        document.getElementById("apresentarnoticia").style.display = "block"
        //informação da noticia
        var escolha = document.createElement('h1')
        escolha.id = 1
        escolha.textContent = `Noticia imperdivel nº${dropnoticia.value}!!!`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var div = document.createElement('div')
        div.className = "text-center"
        div.innerHTML = '<img src="Imagens/diario.jpg" class="imagemblognoticias">';
        apresentarnoticia.appendChild(div)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var escolha = document.createElement('h2')
        escolha.id = 2
        escolha.textContent = `Estudos com Tecnologia em Portugal: Inovação e Futuro`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var p = document.createElement('p')
        p.className = "paragrafoblog"
        p.textContent = 'Portugal tem se destacado como um hub emergente para a pesquisa e inovação tecnológica. Universidades como o Instituto Superior Técnico (IST) e a Universidade do Porto lideram projetos em áreas como inteligência artificial, ciência de dados e energias renováveis. Além disso, o país tem atraído investimentos em centros de investigação e startups tecnológicas.'
        apresentarnoticia.appendChild(p)
        var p1 = document.createElement('p')
        p1.className = "paragrafoblog"
        p1.textContent = 'Iniciativas como o programa INCoDe.2030 promovem o desenvolvimento de competências digitais na educação, preparando novas gerações para os desafios da economia digital. Tecnologias como blockchain, 5G e computação quântica estão no centro dos estudos, com aplicações práticas em setores como saúde, agricultura e mobilidade urbana.'
        apresentarnoticia.appendChild(p1)
        var p2 = document.createElement('p')
        p2.className = "paragrafoblog"
        p2.textContent = 'Portugal não apenas investe em tecnologia, mas também em colaboração internacional, fortalecendo sua posição como um país comprometido com a inovação científica e o progresso tecnológico. 💻🇵🇹'
        apresentarnoticia.appendChild(p2)
    }else if(dropnoticia.value == 4){
        document.getElementById("apresentarnoticia").style.display = "block"
        //informação da noticia
        var escolha = document.createElement('h1')
        escolha.id = 1
        escolha.textContent = `Noticia imperdivel nº${dropnoticia.value}!!!`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var div = document.createElement('div')
        div.className = "text-center"
        div.innerHTML = '<img src="Imagens/pao_de_forma.jpg" class="imagemblognoticias">';
        apresentarnoticia.appendChild(div)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var escolha = document.createElement('h2')
        escolha.id = 2
        escolha.textContent = `O Carro "Pão-de-Forma": Um Ícone nas Estradas de Portugal`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var p = document.createElement('p')
        p.className = "paragrafoblog"
        p.textContent = 'O clássico Volkswagen "Pão-de-Forma", conhecido oficialmente como VW Type 2 ou Kombi, conquistou gerações em Portugal. Popularizado nas décadas de 60 e 70, este veículo tornou-se símbolo de liberdade e aventura, especialmente entre famílias e entusiastas do campismo.'
        apresentarnoticia.appendChild(p)
        var p1 = document.createElement('p')
        p1.className = "paragrafoblog"
        p1.textContent = 'Com seu design arredondado e versátil, o "Pão-de-Forma" era presença certa nas estradas portuguesas, desde viagens ao Algarve até explorações pelas montanhas do Gerês. Muitas unidades foram adaptadas como autocaravanas ou veículos de trabalho, refletindo a sua durabilidade e funcionalidade.'
        apresentarnoticia.appendChild(p1)
        var p2 = document.createElement('p')
        p2.className = "paragrafoblog"
        p2.textContent = 'Hoje, o "Pão-de-Forma" mantém seu charme intemporal e é objeto de colecionadores e amantes de carros clássicos. Encontros de entusiastas em Portugal celebram este ícone, que permanece vivo nas memórias e nas estradas. 🚐✨'
        apresentarnoticia.appendChild(p2)
    }else if(dropnoticia.value == 5){
        document.getElementById("apresentarnoticia").style.display = "block"
        //informação da noticia
        var escolha = document.createElement('h1')
        escolha.id = 1
        escolha.textContent = `Noticia imperdivel nº${dropnoticia.value}!!!`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var div = document.createElement('div')
        div.className = "text-center"
        div.innerHTML = '<img src="Imagens/pexels-lureofadventure-28365967.jpg" class="imagemblognoticias">';
        apresentarnoticia.appendChild(div)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var escolha = document.createElement('h2')
        escolha.id = 2
        escolha.textContent = `Acampar nas Florestas de Portugal: Uma Experiência de Tranquilidade`
        escolha.className = "maplabel text-center"
        apresentarnoticia.appendChild(escolha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var quebraLinha = document.createElement('br')
        apresentarnoticia.appendChild(quebraLinha)
        var p = document.createElement('p')
        p.className = "paragrafoblog"
        p.textContent = 'Acampar nas florestas de Portugal é uma forma única de se conectar com a natureza e explorar a rica biodiversidade do país. Regiões como o Parque Nacional da Peneda-Gerês, as Serras da Estrela e de Monchique oferecem locais perfeitos para montar uma tenda e desfrutar da paz das paisagens verdes.'
        apresentarnoticia.appendChild(p)
        var p1 = document.createElement('p')
        p1.className = "paragrafoblog"
        p1.textContent = 'Com áreas bem preservadas, estas florestas proporcionam uma experiência de acampamento que vai desde trilhos em meio a árvores centenárias até noites estreladas ao som da natureza. Muitos parques naturais oferecem infraestruturas básicas, como zonas de piquenique e trilhas sinalizadas, garantindo segurança e conforto aos campistas.'
        apresentarnoticia.appendChild(p1)
        var p2 = document.createElement('p')
        p2.className = "paragrafoblog"
        p2.textContent = 'Embora o camping selvagem seja restrito em algumas regiões, existem parques de campismo bem equipados que permitem explorar a beleza natural com responsabilidade ambiental. Acampar em Portugal é mais do que uma viagem, é uma imersão em cenários únicos que revitalizam o corpo e a alma. 🌲🏕️'
        apresentarnoticia.appendChild(p2)
    }else if(dropnoticia.value == 0){
        document.getElementById("apresentarnoticia").style.display = "none"
        apresentarnoticia.innerHTML = ""
    }
}

//atribuir as cidades em função com o pais
dropnoticia.addEventListener('change', function(e) {
    MostrarAnoticia()
})