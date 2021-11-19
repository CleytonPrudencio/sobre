<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.edu.unicid.bean.Brinquedo"%>
<%@page import="br.edu.unicid.bean.Categoria"%>
<%@page import="br.edu.unicid.dao.BrinquedoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Catalogo de Brinquedos</title>
</head>
<body>
	<header> <nav class="navbar navbar-light bg-light">
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
                    <input class="form-control me-2  ml-1" type="text" placeholder="Username" />
                    <input class="form-control me-2  ml-1" type="password" placeholder="Password" />
                    <button class="btn btn-warning  ml-3" type="submit">Login</button>
                </form>
		</div>
	</div>
	</nav> </header>
	<main>

	<div class="container-fluid">
		<div class="row">
			<div class="col-2 slidebarw bg-danger">
				<div class="wrapper">
					<nav id="sidebar">
					<ul class="list-unstyled">
						<li><a href="Index?cmd=listar"><i class="fas fa-home"></i>
								Home </a></li>
						<li class="active"><a href="#Administracaoo"
							data-toggle="collapse" aria-expanded="false"
							class="dropdown-toggle"><i class="fas fa-cogs"></i>Area
								administrativa</a>
							<ul class="collapse" id="Administracaoo">
								<li><a href="#Categorias" data-toggle="collapse"
									aria-expanded="false" class="dropdown-toggle"> Categorias</a>
									<ul class="collapse list-unstyled" id="Categorias">
										<li><a href="incluir.jsp">Incluir</a></li>
										<li><a href="atualizar.jsp">Atualizar</a></li>
										<li><a href="consultar.jsp">Consultar</a></li>
										<li><a href="excluir.jsp">Excluir</a></li>
										<li><a href="ServletCatBrinquedo?cmd=listar">Listar</a></li>
									</ul></li>
								<li><a href="#Brinquedos" data-toggle="collapse"
									aria-expanded="false" class="dropdown-toggle">
										Brinquedos</a>
									<ul class="collapse list-unstyled" id="Brinquedos">
										<li><a href="ServletCatBrinquedo?cmd=listarDrop">Incluir</a></li>
										<li><a href="#">Atualizar</a></li>
										<li><a href="#">Consultar</a></li>
										<li><a href="#">Excluir</a></li>
										<li><a href="#">Listar</a></li>
									</ul></li>
								<li><a href="#Usuarios" data-toggle="collapse"
									aria-expanded="false" class="dropdown-toggle">Adm. Usuarios</a>
									<ul class="collapse list-unstyled" id="Usuarios">
										<li><a href="#">Incluir</a></li>
										<li><a href="#">Atualizar</a></li>
										<li><a href="#">Consultar</a></li>
										<li><a href="#">Excluir</a></li>
										<li><a href="#">Listar</a></li>
									</ul></li>

							</ul></li>
						<li><a href="#pageSubmenu" data-toggle="collapse"
							aria-expanded="false" class="dropdown-toggle"><i
								class="fas fa-th-list"></i>Categorias</a> <%
 List<Categoria> listaCategoria = new ArrayList<Categoria>();
 listaCategoria = (ArrayList) request.getAttribute("categoriasList");
 for (Categoria a : listaCategoria) {
 %>

							<ul class="collapse list-unstyled" id="pageSubmenu">
								<li><a href="Index?categoria=<%=a.getCod_categoria()%>"><%=a.getNomeCategoria()%></a></li>
							</ul> <%
 }
 %></li>
					</ul>
					</nav>

				</div>
			</div>
			<div class="col-10 bg-light ">
				<div class="d-flex flex-wrap">
					<%
					List<Brinquedo> lista = new ArrayList<Brinquedo>();
					lista = (ArrayList) request.getAttribute("brinquedoList");
					for (Brinquedo b : lista) {
					%>

					<div class="card text-center mr-3 mt-4 " style="width: 18rem;">
						<p class="card-text"><%=b.getCod_brinquedo()%></p>
						<img src="ServletImagem?nome=<%=b.getImagemBrinquedo()%>"
							class="card-img-top rounded" style="height: 15rem;">
						<div class="card-body">
							<h5 class="card-title"><%=b.getNomeBrinquedo()%></h5>
							<p class="card-text">
							
								<%=b.getNomeCategoria()%></p>
							<p class="card-text">
								R$
								<%=b.getPrecoBrinquedo()%></p>
							<!-- Botão para acionar modal -->
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#model<%=b.getCod_brinquedo()%>">+Detalhes
							</button>

							<!-- Modal -->
							<div class="modal fade" id="model<%=b.getCod_brinquedo()%>"
								tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header center">
											<h5 class="modal-title text-center" id="exampleModalLabel"><%=b.getNomeBrinquedo()%></h5>
										</div>
										<div class="modal-body text-center">
											<img src="ServletImagem?nome=<%=b.getImagemBrinquedo()%>"
												class="card-img-top rounded" style="width: 15rem;">
											<p>
											Codigo: <%=b.getCod_brinquedo() %> <br>
											Produto: <%=b.getNomeBrinquedo() %> <br>
											Preço: R$ <%=b.getPrecoBrinquedo() %> <br>
											Categoria: <%=b.getCategoria() %> <br> <br>
											Descrição: <%=b.getDescricaoBrinquedo() %>
											</p>
										</div>
										<div class="modal-footer d-flex justify-content-center">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Fechar</button>

										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<%
					}
					%>
				</div>
			</div>
		</div>
	</main>
	<footer class="bg-secondary text-white ">
	<div class="container-fluid py-3">
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
	<div class="text-center"; padding: 20px;" >
		&copy 2021 Copyright: <a href="#">Brinquedos</a>
	</div>
	</footer>
</body>
</html>