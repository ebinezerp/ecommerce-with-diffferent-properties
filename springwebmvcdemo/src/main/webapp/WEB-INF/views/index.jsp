<%@page isELIgnored="false"%>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<spring:url value="/staticresources/images" var="images"></spring:url>
<spring:url value="/staticresources/styles" var="styles"></spring:url>

<html>

<head>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<link rel="stylesheet" href="${styles}/style.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</head>

<body>
	<header class="container">
		<nav class="nav navbar bg-dark navbar-expand-md navbar-light">
			<a class="nav-brand" href="#"><img src="${images}/logo.png" /></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarTogglerDemo02"
				aria-controls="navbarTogglerDemo02" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo02">
				<form action="" method="post" class="form-inline">
					<div class="form-inline">
						<input type="search" name="search" id="" class="form-control"
							placeholder="Search" aria-describedby="helpId"> <input
							type="submit" value="GO" class="btn btn-primary">
					</div>
				</form>
				<ul class="nav ml-auto">
					<li class="nav-item"><a class="nav-link" href="">Special
							Offer</a></li>
					<li class="nav-item"><a class="nav-link btn btn-primary"
						href="">Login</a></li>
				</ul>
			</div>
		</nav>
	</header>

</body>

</html>