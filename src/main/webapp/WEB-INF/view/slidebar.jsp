<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="img/icon.png" type="image/png"
	sizes="16x16">
</head>
<body>
	<ul
		class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
		id="accordionSidebar">

		<!-- Sidebar - Brand -->
		<a
			class="sidebar-brand d-flex align-items-center justify-content-center"
			href="dashboard">
			<div class="sidebar-brand-icon rotate-n-15">
				<i class="fas fa-bone"></i>
			</div>
			<div class="sidebar-brand-text mx-3">
				PetMarkets <sup>Management</sup>
			</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">
		<!-- Heading -->
		<div class="sidebar-heading">Function</div>
		

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed"
			data-toggle="collapse" data-target="#collapseTwo"
			aria-expanded="true" aria-controls="collapseTwo"><i
				class="fas fa-list" style="color: white"></i></i> <span>Posts</span> </a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Details</h6>

					<a class="collapse-item" href="postList"><i
						class="fas fa-bookmark" style="color: #4e73df"></i><span>
							List posts</span></a> <a class="collapse-item" href="getlisthotpost"><i
						class="fab fa-hotjar" style="color: #4e73df"></i><span> Hot
							posts</span></a> <a class="collapse-item" href="listPostPackage"><i
						class="fas fa-box-open" style="color: #4e73df"></i><span> Post Package</span></a>
				</div>
			</div></li>

		<!-- Nav Item - Utilities Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed"
			href="userList" aria-expanded="true"> <i class="fas fa-users"
				style="color: white"></i> List users
		</a></li>

		<li class="nav-item"><a class="nav-link collapsed"
			href="listcoinpackages" aria-expanded="true"><i
				class="fas fa-coins" style="color: white"></i> Coin Packages </a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			href="listPetType" aria-expanded="true"> <i class="fas fa-paw"
				style="color: white"></i> Pet Type
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			href="rankings" aria-expanded="true"> <i
				class="fas fa-sort-amount-down" style="color: white"></i> Rankings
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			href="listHistory" aria-expanded="true"> <i
				class="fas fa-history" style="color: white"></i> History
		</a></li>

	</ul>
</body>
</html>