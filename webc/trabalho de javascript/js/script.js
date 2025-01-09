
function PreencherCategorias(data){
    //vai buscar o elemento que vai ter as categorias adicionadas
    const divCategoria = document.getElementById('divcategorias')
    
    // apagar caso exista algo na div categorias
    divCategoria.innerHTML = ""

    //vai preencher as categorias
    data.forEach(res => {
        //cria novo elemento e seus atributos
        let novoElemento = document.createElement('p')
        novoElemento.className = "categorialink"
        //adiciona a função de chamar a função desejada com a categoria do elemento
        novoElemento.onclick = () => ApiProdutos(res.slug)
        novoElemento.textContent = res.name
        //adiciona o elemento ao respetivo elemento da pagina
        divCategoria.appendChild(novoElemento)
    });

}

function PreencherProdutos(data){
    //vai buscar o elemento que vai ter as categorias adicionadas
    const divProdutos = document.getElementById('divprodutos')

    // apagar caso exista algo na div categorias
    divProdutos.innerHTML = ""

    //cria o elemento para o titulo da coluna dos produtos e seus atributos
    let novoElemento = document.createElement('h2')
    novoElemento.className = "tituloProdutos"
    novoElemento.textContent = `Products in category ${data.products[0].category}`
    //adiciona o elemento ao respetivo elemento da pagina
    divProdutos.appendChild(novoElemento)

    data.products.forEach(res => {
        // espaço em branco
        let novoElemento = document.createElement('br')
        divProdutos.appendChild(novoElemento)
        //adiciona 
        //...o titulo do produto
        novoElemento = document.createElement('h3')
        novoElemento.className = "h3Produtos"
        novoElemento.textContent = res.title
        divProdutos.appendChild(novoElemento)
        //...produto o preço
        novoElemento = document.createElement('h4')
        novoElemento.className = "h4Produtos"
        novoElemento.textContent = `Price: $${res.price}`
        divProdutos.appendChild(novoElemento)
        //...produto o rating
        novoElemento = document.createElement('h4')
        novoElemento.className = "h4Produtos"
        novoElemento.textContent = `Rating: $${res.rating}`
        divProdutos.appendChild(novoElemento)
        // linha de divisão de produtos
        novoElemento = document.createElement('hr')
        divProdutos.appendChild(novoElemento)
    });

    
}

//função para ir buscar as categorias
function ApiCategorias(){

    //pedido a api
    fetch(`https://dummyjson.com/products/categories`)
        .then(response => {
            if(response.ok) {
                return response.json()
            }})
        .then(data => {
            //chama a função para preencher as categorias e envia a informação recebida
            PreencherCategorias(data); 
            })
        .catch(error => {
            console.log("Erro")
        })

}

//função para ir buscar os produtos da categoria desejada
function ApiProdutos(categoria){

    //pedido a api
    fetch(`https://dummyjson.com/products/category/${categoria}`)
        .then(response => {
            if(response.ok) {
                return response.json()
            }})
        .then(data => {
            //chama a função para preencher os produtos e envia a informação recebida
            PreencherProdutos(data);
            })
        .catch(error => {
            console.log("Erro")
        })

}


//chama a função para carregar as categorias no load da pagina
window.onload = function() {
    ApiCategorias()
}