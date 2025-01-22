
<?php

//isto é um comentario
// $teste = "Hello world";
// echo $teste;

//criar array
//$meuarray[] = 8;
//$meuarray[] = 3;

//outras maneiras:
// $meuarray = array(8,0);
//$meuarray = [8,0];
//$meuarray = array(0 => 8, 1 => 0);
//$meuarray = array("cao" => 8 , "gato" => 0);


// echo "<pre>";
// print_r($meuarray);
// echo "</pre>";
// echo "<br>";

//para a execução neste ponto
//exit();

//$numeroum = 5;
//$numerodois = 3;
// $soma = $meuarray[0] + $meuarray[1];
// $subt = $meuarray[0] - $meuarray[1];
// $mult = $meuarray[0] * $meuarray[1];

// if ( $meuarray[1] == 0){
	// echo "Nao é possivel fazer a divisao por 0<br>";
// }else {
	// $div = $meuarray[0] / $meuarray[1];
	// echo "divisão é: ${div}<br>";
// }



// usar o "." para concatnar
// echo "soma é: ${soma}<br>" . "subtração é: ${subt}<br>multiplicação é: ${mult}<br>";

$nume = 12;


$array2s = array(2,3,4,5);
/*
foreach ($array2s as $vari){
	if ( $nume % $vari == 0){
		echo "<br>O ${nume} é divisivel por ${vari}<br>";
	}else {
		echo "<br>O ${nume} não é divisivel por ${vari}<br>";
	}
}



for ($i = 0; $i < count($array2s); $i++){
	if ( $nume % $array2s[$i] == 0){
		echo "<br>O ${nume} é divisivel por ${array2s[$i]}<br>";
	}else {
		echo "<br>O ${nume} não é divisivel por ${array2s[$i]}<br>";
	}
}
*/

// $i = 0;
/*
do{
	if ( $nume % $array2s[$i] == 0){
		echo "<br>O ${nume} é divisivel por ${array2s[$i]}<br>";
	}else {
		echo "<br>O ${nume} não é divisivel por ${array2s[$i]}<br>";
	}
	$i++;
}while ($i < count($array2s));
*/


// while ($i < count($array2s)){
	// if ( $nume % $array2s[$i] == 0){
		// echo "<br>O ${nume} é divisivel por ${array2s[$i]}<br>";
	// }else {
		// echo "<br>O ${nume} não é divisivel por ${array2s[$i]}<br>";
	// }
	// $i++;
// }









$quero = 3;
$saida = verificardivisiveis($array2s,$nume);
$resposta = mostrar($saida, $quero);
echo ($resposta);
// print_r($saida);


function mostrar($saida, $quero){
	foreach ($saida as $teste){
		if($teste["numdivisivel"] == $quero){
			return $teste["texto"];
		}
	}
}


function verificardivisiveis($array2s, $nume){
	$i = 0;
	
	do{
	if ( $nume % $array2s[$i] == 0){
		// $results["${array2s[$i]}"] =  "<br>O ${nume} é divisivel por ${array2s[$i]}<br>";
		$results[] = array( "texto" => "<br>O ${nume} é divisivel por ${array2s[$i]}<br>", "numdivisivel" => $array2s[$i]);
	}else {
		// $results["${array2s[$i]}"] = "<br>O ${nume} não é divisivel por ${array2s[$i]}<br>";
		$results[] = array( "texto" => "<br>O ${nume} não é divisivel por ${array2s[$i]}<br>", "numdivisivel" => $array2s[$i]);
	}
	$i++;
	}while ($i < count($array2s));
	return $results;
}









/*
if ( $nume % 2 == 0){
	echo "<br>É divisivel por 2<br>";
}else {
	echo "<br>Não é divisivel por 2<br>";
}
if ( $nume % 3 == 0){
	echo "<br>É divisivel por 3<br>";
}else {
	echo "<br>Não é divisivel por 3<br>";
}
if ( $nume % 4 == 0){
	echo "<br>É divisivel por 4<br>";
}else {
	echo "<br>Não é divisivel por 4<br>";
}
if ( $nume % 5 == 0){
	echo "<br>É divisivel por 5<br>";
}else {
	echo "<br>Não é divisivel por 5<br>";
}
*/


?>