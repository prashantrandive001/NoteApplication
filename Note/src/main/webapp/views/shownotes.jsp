<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.rtl.min.css"
	integrity="sha384-dpuaG1suU0eT09tx5plTaGMLBsfDLzUCCUXOY2j/LSvXYuG6Bqs43ALlhIqAJVRb"
	crossorigin="anonymous">

<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous">
	
</script>

<!-- Option 2: Separate Popper and Bootstrap JS -->

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
	integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
	crossorigin="anonymous">
	
</script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js"
	integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy"
	crossorigin="anonymous">
	
</script>

<title>All Notes</title>

</head>
<body>


<div style="margin-bottom: 90px" >
	<nav class="navbar navbar-expand-lg bg-info" style="position: top;  width: 100%" >
		<div class="container-fluid"  >
			<a class="navbar-brand" href="/"> <img
				src="notes.png" alt="note" width="30" height="24">
				Note

			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/">Home</a></li>

					<li class="nav-item"><a class="nav-link " href="/addnote">Add
							Note</a></li>

					<li class="nav-item"><a class="nav-link " href="/shownotes">Show
							Notes</a></li>

				</ul>
				<form class="d-flex" role="search " action="/search">
					<input class="form-control me-2" name="find" type="search" placeholder="Search"
						aria-label="Search" style="margin-right: 5px">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
</div>


<c:forEach items="${notes }" var="n"  >
	<div class="container " style="margin-bottom: 55px; text-align: left;">
	
		<div class="card mt-3" style="">

				<img src="pencil.png" style="max-width: 100px; margin-right: 1013px;" class="card-img-top  bg-light" alt=".">

				<div class="card-body px-5 ">
					<h5 class="card-title ">${n.getTitle()}</h5><hr>
					<p class="card-text ">${n.getContent()}</p>
					<p class="card-text "><b>${n.getDate()}</b></p>
					
					<div class="text-center">

						<a href='deletenote?id=${n.getId()}' class="btn btn-danger">Delete</a> 
						<a href='updatenote?id=${n.getId()}' class="btn btn-primary">Edit</a>
					</div>
				</div>
				
		</div>
	</div>
</c:forEach>

<div>
	<footer class="bg-body-tertiary text-center" style=" position:bottom; width: 100%">
		
		<div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.05);">
			&copy 2024 Copyright: <a class="text-body" href="#">prashantrandive</a>
		</div>

	</footer>
</div>
</body>
</html>