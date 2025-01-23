<!--
Primeiro Nome
Apelidos
email
confirmação de email
password
confirmação da password
data de nascimento
telemovel
-->
<?php

$firstname = "";
$lastname = "";
$email = "";
$confirmemail = "";
$pass = "";
$confirmpass = "";
$data = "";
$tele = "";

$errors = array();
if($_POST != null){
	
	print_r($_POST);
	$firstname  = $_POST["firstname"];
	$lastname = $_POST["lastname"];
	$email = $_POST["email"];
	$confirmemail = $_POST["confirmemail"];
	$pass = $_POST["password"];
	$confirmpass = $_POST["confirmpassword"];
	$data = $_POST["birthdate"];
	$tele = $_POST["mobilephone"];
	
	
	if(empty($_POST["firstname"])){
		$errors["firstname"] = "O campo é de preenchimento obrigatorio";
	}else if(strlen(trim($_POST["firstname"])) <= 3) {
		$errors["firstname"] = "O campo deve de ter pelo menos 3 caracteres";
	}else {
		$errors["firstname"] = "";
	}
	
	if(empty($_POST["lastname"])){
		$errors["lastname"] = "O campo é de preenchimento obrigatorio";
	}else if(strlen(trim($_POST["lastname"])) <= 3) {
		$errors["lastname"] = "O campo deve de ter pelo menos 3 caracteres";
	}else {
		$errors["lastname"] = "";
	}
	
	if(empty($_POST["email"])){
		$errors["email"] = "O campo é de preenchimento obrigatorio";
	}else if(!filter_var($email, FILTER_VALIDATE_EMAIL)) {
		$errors["email"] = "O campo deve ser preechido com um email valido";
	}else {
		$errors["email"] = "";
	}
}


?>

<form id="myform" method="post">
	<fieldset>
		<legend>First Name: </legend>
		<input type="text" name="firstname" id="firstname" value="<?php echo ($firstname);?>" placeholder="Insira o seu nome"><br>
		<?php if(isset($errors["firstname"])){echo $errors["firstname"];} ?>
	</fieldset>
	<fieldset>
		<legend>Last Name: </legend>
		<input type="text" name="lastname" id="lastname" value="<?php echo ($lastname);?>" placeholder="Insira o seu apelido"><br>
		<?php if(isset($errors["lastname"])){echo $errors["lastname"];} ?>
	</fieldset>
	<fieldset>
		<legend>Email: </legend>
		<input type="text" name="email" id="email" value="<?php echo ($email);?>" placeholder="Insira o seu email"><br>
		<?php if(isset($errors["email"])){echo $errors["email"];} ?>
	</fieldset>
	<fieldset>
		<legend>Confirm Email</legend>
		<input type="text" name="confirmemail" id="confirmemail" value="<?php echo ($confirmemail);?>" placeholder="Confirme o seu email"><br>
	</fieldset>
	<fieldset>
		<legend>Password</legend>
		<input type="text" name="password" id="password" value="<?php echo ($pass);?>" placeholder="Insira a sua password"><br>
	</fieldset>
	<fieldset>
		<legend>Confirm Password</legend>
		<input type="text" name="confirmpassword" id="confirmpassword" value="<?php echo ($confirmpass);?>" placeholder="Confirme a sua password"><br>
	</fieldset>
	<fieldset>
		<legend>Data de Nascimento</legend>
		<input type="date" name="birthdate" id="birthdate" value="<?php echo ($data);?>" placeholder="Insira a sua data de nascimento"><br>
	</fieldset>
	<fieldset>
		<legend>Telemovel</legend>
		<input type="text" name="mobilephone" id="mobilephone" value="<?php echo ($tele);?>" placeholder="Insira o seu telemovel"><br>
	</fieldset>
	<button type="submit">Envidar</button>
</form>