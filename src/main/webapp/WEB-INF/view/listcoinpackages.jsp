<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
  <link  rel="shortcut icon" href="img/icon.png" type="image/png" sizes="16x16">

<title>Manage </title>

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="/WEB-INF/view/slidebar.jsp"></jsp:include>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<jsp:include page="/WEB-INF/view/topbar.jsp"></jsp:include>

				<!-- End of Topbar -->

				<!-- Begin Page Content -->
				<div class="container-fluid">

					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">Manage coin packages</h1>

					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Details</h6>
						</div>

						<div class="card-body">
							<c:if test="${deleted eq 1}">
								<div class="alert alert-success" role="alert">Deleted coin
									successfully.</div>
							</c:if>

							<c:if test="${deleted eq 0}">
								<div class="alert alert-warning" role="alert">Action was
									failed.</div>
							</c:if>


							<div class="table-responsive">

								<table class="table table-bordered table-striped text-center"
									id="dataTable" width="100%" cellspacing="0">
									<thead>
										<tr>
											<th> &nbsp;  #</th>
											<th>Value</th>
											<th>Action</th>

										</tr>
									</thead>

									<tbody>
										<c:forEach items="${listcoinpackages}" var="coin"
											varStatus="loop">

											<tr>
												<td>${loop.count}</td>
												<td><fmt:formatNumber value="${coin.value}"
														type="number" minFractionDigits="0" /> đ</td>

												<td>
													<!-- Modal edit coin -->
													<div class="modal fade" id="exampleModaledit${coin.coinId}"
														tabindex="-1" role="dialog"
														aria-labelledby="exampleModalLabel" aria-hidden="true">
														<div class="modal-dialog" role="document">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">New
																		coins</h5>
																	<button type="button" class="close"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">&times;</span>
																	</button>
																</div>
																<form method="post" action="addCoinPackages">
																	<div class="modal-body">
																		<div class="form-group">
																			<label for="recipient-name" class="col-form-label">Coin
																				ID:</label> <input type="text" class="form-control"
																				name="coinId" value="${coin.coinId}"
																				id="recipient-name">
																		</div>
																		<div class="form-group">
																			<label for="recipient-name" class="col-form-label">Coin
																				Value:</label> <input type="text" class="form-control"
																				name="value" value="${coin.value}"
																				id="recipient-name">
																		</div>

																	</div>
																	<div class="modal-footer">
																		<button type="button" class="btn btn-secondary"
																			data-dismiss="modal">Close</button>
																		<button type="submit" class="btn btn-primary">OK</button>
																	</div>
																</form>
															</div>
														</div>
													</div> <!-- end modal edit coin --> <a class="btn btn-warning"
													href="editCoinPackages?id=${coin.coinId}"
													data-toggle="modal"
													data-target="#exampleModaledit${coin.coinId}"
													data-whatever="@fat"><i class="fas fa-edit"
														style="color: white"> </i></a> &nbsp; &nbsp; <a class="btn btn-danger"
													href="deletecoinpackages?id=${coin.coinId}"> <i
														class="fas fa-trash" style="color: white"></i>
												</a>
												</td>
											</tr>
										</c:forEach>
									</tbody>

								</table>
							</div>

							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#exampleModal" data-whatever="@fat">
								<i class="fas fa-plus"> Add new coins</i>
							</button>
						</div>
					</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->
			<footer class="sticky-footer bg-white">
				<div class="container my-auto">
					<div class="copyright text-center my-auto">
						<span>Copyright &copy; Your Website 2020</span>
					</div>
				</div>
			</footer>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	
	<!-- Add coins modal -->

	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">New coins</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form method="post" action="addCoinPackages">
					<div class="modal-body">
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Coin
								ID:</label> <input type="text" class="form-control" name="coinId"
								id="recipient-name">
						</div>
						<div class="form-group">
							<label for="recipient-name" class="col-form-label">Coin
								Value:</label> <input type="text" class="form-control" name="value"
								id="recipient-name">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">OK</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- End add coins modal -->


	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="vendor/datatables/jquery.dataTables.min.js"></script>
	<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="js/demo/datatables-demo.js"></script>

</body>
</html>