<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin 2 - Tables</title>

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
<style>
.carousel-item {
	text-align: center;
	min-height: 280px;
	/* Prevent carousel from being distorted if for some reason image doesn't load */
}
</style>
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
					<h1 class="h3 mb-2 text-gray-800">List posts</h1>


					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">Posts</h6>
						</div>
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered table table-striped"
									id="dataTable" width="100%" cellspacing="0">
									<thead>

										<tr>
											<th>#</th>
											<th>Post ID</th>
											<th>Area</th>
											<th>Pet Breeds</th>
											<th>Gender</th>
											<th>Health</th>
											<th>Approval</th>
											<th>Limit Day</th>
											<th>Action</th>
										</tr>
									</thead>
									<tbody>


										<c:forEach items="${postList}" var="post" varStatus="loop">
											<tr>
												<td>${loop.count}</td>
												<td>${post.postId}</td>
												<td>${post.area}</td>
												<td>${post.breed}</td>
												<td>${post.gender}</td>
												<td>${post.healthGuarantee}</td>
												<c:choose>
													<c:when test="${post.hidden eq true}">
													<td><span class="badge badge-pill badge-success" style="color: white">APPROVED</span></td>
													</c:when>
													<c:when test="${post.hidden eq false}">
													<td><span class="badge badge-pill badge-warning" style="color: white">WAITING</span></td>
													</c:when>
												</c:choose>
												<td>${post.limitDay}</td>
												<td>
													<!-- edit post Modal-->
													<div class="modal fade bd-example-modal-lg"
														id="editpostModal${post.postId}" tabindex="-1"
														role="dialog" aria-labelledby="exampleModalLabel"
														aria-hidden="true">
														<div class="modal-dialog modal-lg" role="document">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">
																		Chi tiết bài đăng <label class="form-label"
																			for="form6Example1" style="margin-left: 0px;"><b
																			style="color: red">${post.postId}</b></label>
																	</h5>
																	<button class="close" type="button"
																		data-dismiss="modal" aria-label="Close">
																		<span aria-hidden="true">×</span>
																	</button>
																</div>
																<div class="modal-body">
																	<form>
																		<!-- 2 column grid layout with text inputs for the first and last names -->
																		<div class="row mb-4">
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example1"
																						style="margin-left: 0px;">Tiêu đề<b
																						style="color: red"> *</b></label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68.8px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example1"
																						class="form-control" value="${post.title}">
																				</div>
																			</div>
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example2"
																						style="margin-left: 0px;">Người đăng <b
																						style="color: red"> *</b></label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example2"
																						class="form-control"
																						value="${post.poster}"/>
																				</div>
																			</div>
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example2"
																						style="margin-left: 0px;">Loại tin<b
																						style="color: red"> *</b></label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example2"
																						class="form-control" value="Cần bán">
																				</div>
																			</div>
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example2"
																						style="margin-left: 0px;">Khu vực<b
																						style="color: red"> *</b>
																					</label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example2"
																						class="form-control" value="${post.area}">
																				</div>
																			</div>
																		</div>
																		<div class="row mb-4">
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example1"
																						style="margin-left: 0px;">Loại thú cưng<b
																						style="color: red"> *</b></label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68.8px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example1"
																						class="form-control" value="${post.peType}">
																				</div>
																			</div>
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example2"
																						style="margin-left: 0px;">Giống vật nuôi<b
																						style="color: red"> *</b></label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example2"
																						class="form-control" value="${post.breed}">

																				</div>
																			</div>
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example2"
																						style="margin-left: 0px;">Giống<b
																						style="color: red"> *</b></label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example2"
																						class="form-control" value="${post.gender}">
																				</div>
																			</div>
																			<div class="col">
																				<div class="form-outline">
																					<label class="form-label" for="form6Example2"
																						style="margin-left: 0px;">Giá<b
																						style="color: red"> *</b>
																					</label>
																					<div class="form-notch">
																						<div class="form-notch-leading"
																							style="width: 9px;"></div>
																						<div class="form-notch-middle"
																							style="width: 68px;"></div>
																						<div class="form-notch-trailing"></div>
																					</div>
																					<input type="text" id="form6Example2"
																						class="form-control" value="${post.price}">
																				</div>
																			</div>
																		</div>



																		<div class="form-outline mb-4">
																			<label class="form-label" for="form6Example7"
																				style="margin-left: 0px;">Thông tin thêm</label>
																			<div class="form-notch">
																				<div class="form-notch-leading" style="width: 9px;"></div>
																				<div class="form-notch-middle"
																					style="width: 135.2px;"></div>
																				<div class="form-notch-trailing"></div>
																			</div>
																			<textarea class="form-control" id="form6Example7"
																				rows="4">Không có.</textarea>

																		</div>
																		<div>
																			<label class="form-label" for="form6Example7"
																				style="margin-left: 0px;">Hình ảnh</label>
																		</div>
																		<div id="carouselExampleIndicators"
																			class="carousel slide" data-ride="carousel">
																			<ol class="carousel-indicators">
																				<c:forEach items="${post.images}" varStatus="loop1">
																					<c:choose>
																						<c:when test="${loop1.count - 1 eq 0 }">
																							<li data-target="#carouselExampleIndicators"
																								data-slide-to="0" class="active"></li>
																						</c:when>
																						<c:when test="${loop1.count - 1 ne 0 }">
																							<li data-target="#carouselExampleIndicators"
																								data-slide-to="${loop1.count}"></li>
																						</c:when>
																					</c:choose>
																				</c:forEach>
																			</ol>
																			<div class="carousel-inner">
																				<c:forEach items="${post.images}" var="image"
																					varStatus="loop3">

																					<c:choose>
																						<c:when test="${loop3.count - 1 eq 0 }">
																							<div class="carousel-item active">
																								<img
																									src="https://firebasestorage.googleapis.com/v0/b/pet-market-6996.appspot.com/o/images%2F${image}?alt=media&token=cba8b49d-965c-4ca4-a6fc-980357fc575a"
																									alt="Slide" ${loop3.count} width="550px" height="550px">
																							</div>
																						</c:when>
																						<c:when test="${loop3.count - 1 ne 0 }">
																							<div class="carousel-item">
																								<img
																									src="https://firebasestorage.googleapis.com/v0/b/pet-market-6996.appspot.com/o/images%2F${image}?alt=media&token=cba8b49d-965c-4ca4-a6fc-980357fc575a"
																									alt="Slide" ${loop3.count}  width="550px" height="550px">
																							</div>
																						</c:when>
																					</c:choose>
																				</c:forEach>
																			</div>
																			<a class="carousel-control-prev"
																				href="#carouselExampleIndicators" role="button"
																				data-slide="prev"> <span
																				class="carousel-control-prev-icon"
																				aria-hidden="true"></span> <span class="sr-only">Previous</span>
																			</a> <a class="carousel-control-next"
																				href="#carouselExampleIndicators" role="button"
																				data-slide="next"> <span
																				class="carousel-control-next-icon"
																				aria-hidden="true"></span> <span class="sr-only">Next</span>
																			</a>
																		</div>
																		</br>
																		<!-- Submit button -->
																		<div class="text-center">
																			<a href="approvedPost?idPost=${post.postId}" class="btn btn-success">
																				<i class="fa fa-check" aria-hidden="true">&nbsp;</i>Duyệt
																				bài đăng
																			</a>
																			<a href="refusePost?idPost=${post.postId}" class="btn btn-warning">
																				<i class="fas fa-comment-slash"></i>&nbsp;Từ chối
																				bài đăng
																			</a>
																		</div>

																	</form>
																</div>
																<div class="modal-footer text-center">
																	<button class="btn btn-danger" type="button"
																		data-dismiss="modal">
																		<i class="fa fa-times" aria-hidden="true">&nbsp;</i>Đóng
																	</button>
																</div>
															</div>
														</div>
													</div> <!-- end edit post modal --> <a href=""
													data-toggle="modal"
													data-target="#editpostModal${post.postId}"
													data-whatever="@fat" ><button class="btn btn-info"><i
														class="fas fa-info-circle" style="color: white"></i></button></a>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
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

	<script type="text/javascript">
		$('.carousel').carousel()
	</script>
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