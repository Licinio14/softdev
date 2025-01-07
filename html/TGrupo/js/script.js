

const data = null;

const xhr = new XMLHttpRequest();
xhr.withCredentials = true;



async function executar(){
    const url = 'https://asos2.p.rapidapi.com/products/v4/detail?lang=en-US&store=US&sizeSchema=US&currency=USD';
const options = {
	method: 'GET',
	headers: {
		'x-rapidapi-key': 'd26551221cmsh7587b71a1eb4effp198a5bjsn9e4ca84ff255',
		'x-rapidapi-host': 'asos2.p.rapidapi.com'
	}
};

try {
	const response = await fetch(url, options);
	const result = await response.text();
	console.log(result);
} catch (error) {
	console.error(error);
}
}


// 7276d7f9-b810-4743-8c11-eccb260bbecd