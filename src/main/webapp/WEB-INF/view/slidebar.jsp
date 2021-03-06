<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
				<i class="fas fa-laugh-wink"></i>
			</div>
			<div class="sidebar-brand-text mx-3">
				PetMarkets <sup>Management</sup>
			</div>
		</a>

		<!-- Divider -->
		<hr class="sidebar-divider my-0">

		<!-- Nav Item - Dashboard -->
		<li class="nav-item"><a class="nav-link" href="dashboard"> <i
				class="fas fa-fw fa-tachometer-alt"></i> <span>Dashboard</span></a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">Interface</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed"
			data-toggle="collapse" data-target="#collapseTwo"
			aria-expanded="true" aria-controls="collapseTwo"> <i
				class="fas fa-fw fa-cog"></i> <span>Posts</span>
		</a>
			<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
				data-parent="#accordionSidebar">
				<div class="bg-white py-2 collapse-inner rounded">
					<h6 class="collapse-header">Details:</h6>

					<a class="collapse-item" href="postList">List posts</a> <a
						class="collapse-item" href="getlisthotpost">Hot posts</a>
				</div>
			</div></li>

		<!-- Nav Item - Utilities Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed"
			href="userList" aria-expanded="true"> <i class="fas fa-fw fa-cog"></i>
				List users
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			href="listcoinpackages" aria-expanded="true"> <i
				class="fas fa-fw fa-cog"></i> Coin Packages
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			href="listPetType" aria-expanded="true"> <i
				class="fas fa-fw fa-cog"></i> Pet Type
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			href="rankings" aria-expanded="true"> <i
				class="fas fa-fw fa-cog"></i> Rankings
		</a></li>
			<li class="nav-item"><a class="nav-link collapsed"
			href="listHistory" aria-expanded="true"> <i
				class="fas fa-fw fa-cog"></i> History
		</a></li>
		<li class="nav-item"><a class="nav-link collapsed"
			href="getlistComments" aria-expanded="true"> <i
				class="fas fa-fw fa-cog"></i> Comments
		</a></li>

		<!-- Divider -->
		<hr class="sidebar-divider">

		<!-- Heading -->
		<div class="sidebar-heading">Addons</div>

		<!-- Nav Item - Pages Collapse Menu -->
		<li class="nav-item"><a class="nav-link collapsed" href="#"
			data-toggle="collapse" data-target="#collapsePages"
			aria-expanded="true" aria-controls="collapsePages"> <i
				class="fas fa-fw fa-folder"></i> <span>Pages</span>
		</a></li>


		<!-- Divider -->
		<hr class="sidebar-divider d-none d-md-block">

		<!-- Sidebar Toggler (Sidebar) -->
		<div class="text-center d-none d-md-inline">
			<button class="rounded-circle border-0" id="sidebarToggle"></button>
		</div>

	</ul>
</body>
</html>