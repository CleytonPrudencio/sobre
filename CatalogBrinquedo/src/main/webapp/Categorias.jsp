<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
 <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<title>Categorias</title>
</head>
<body>
<header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="index.jsp">Home</a>
		 
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="Categorias.jsp">Categorias <span class="sr-only">(current)</span></a>
				</li>
			</ul>
			
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="Produtos.jsp">Produtos<span class="sr-only">(current)</span></a>
				</li>
			</ul>
			
			<ul class="navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="Usu�rios">Usu�rios <span class="sr-only">(current)</span></a>
				</li>
			</ul>
		</div>
	</nav>
</header>
<main>
	<h1 align="center">Cadastro de Categorias</h1>
	<center>
	<a href="incluir.jsp">Incluir Categorias</a><br />
	<a href="atualizar.jsp">Alterar Categorias</a><br />
	<a href="consultar.jsp">Consultar Categorias</a><br />
	<a href="excluir.jsp">Excluir Categorias</a><br />
	<a href="ServletCatBrinquedo?cmd=listar">Listar Categorias</a><br />
	</center>

</main>
<footer class="bg-secondary text-white fixed-bottom">
    <div class="container-fluid py-3">
      <div class="col-12 ">
	      <div class="row d-flex justify-content-center">
	        <p>
	           Brinquedos TOYS
	        </p>
	      </div>
	      <div class="row d-flex justify-content-center">
	        <ul class="nav">
	          <li class="nav-link" ><i class="fab fa-facebook fa-3x "></i></li>
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