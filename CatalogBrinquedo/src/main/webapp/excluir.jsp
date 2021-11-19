<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"
	integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./css/style.css">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
	crossorigin="anonymous"></script>
<title>Atualizar Categoria</title>
</head>
<body>
	<header>
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<div class="col-4">
					<a class="navbar-brand" href="Index"> <img src="./img/tt.png"
						class="img-fluid" width="200" height="20"></a>
				</div>
				<div class="col-4">
					<a class="navbar-brand">Toy Store Company</a>
				</div>
				<div class="col-4">
					<form class="d-flex">
						<input class="form-control me-2  ml-1" type="text"
							placeholder="Username" /> <input class="form-control me-2  ml-1"
							type="password" placeholder="Password" />
						<button class="btn btn-warning  ml-3" type="submit">Login</button>
					</form>
				</div>
			</div>
		</nav>
	</header>
	<main>
		<div class="container-fluid d-flex justify-content-center"
			style="font-family: Comic Sans MS; color: rgb(1, 79, 145); font-size: 20px;">
			<form action="ServletCatBrinquedo?cmd=exc" method="post">
				<p class="d-flex justify-content-center mt-3 font-weight-bold">Exclusão da
					Categoria</p>
				<div class="form-row">
					<div class="form-group col-md-12">
						<label for="Codigo">Codigo Categoria</label> <input type="txt"
							class="form-control" name="txtCod" id="Codigo" placeholder="1">
					</div>
					<div class="col-md-12 d-flex justify-content-center">
						<input type="submit" class="btn btn-warning" value="Enviar"
							style="width: 10rem;">
						</button>
					</div>
				</div>
	</main>
	<footer class="bg-secondary text-white fixed-bottom">
		<div class="container-fluid py-3">
			<div class="col-12 ">
				<div class="row d-flex justify-content-center">
					<p>Brinquedos TOYS</p>
				</div>
				<div class="row d-flex justify-content-center">
					<ul class="nav">
						<li class="nav-link"><i class="fab fa-facebook fa-3x "></i></li>
						<li class="nav-link"><i class="fab fa-instagram fa-3x"></i></li>
						<li class="nav-link"><i class="fab fa-twitter fa-3x"></i></li>
						<li class="nav-link"><i class="fab fa-whatsapp fa-3x"></i></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="text-center"; padding: 20px;" >
			&copy 2021 Copyright: <a href="#">Brinquedos</a>
		</div>
	</footer>
</body>
</html>