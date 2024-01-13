<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<header class="p-3 text-bg-dark">
	<div class="container">
		<div
			class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="index.jsp"
				class="d-flex align-items-center mb-3 mb-md-0 me-md-auto link-body-emphasis text-decoration-none">
				<svg class="bi me-2" width="40" height="32">
                        <use xlink:href="#bootstrap"></use>
                    </svg> <span class="fs-4 btn btn-info fw-bold">SSAFIT</span>
			</a> <a href="/"
				class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
				<svg class="bi me-2" width="40" height="32" role="img"
					aria-label="Bootstrap">
                        <use xlink:href="#bootstrap"></use>
                    </svg>
			</a>

			<div class="text-end">
				<button type="button" class="btn btn-outline-light me-2 fw-bold">Login</button>
				<button type="button" class="btn btn-warning fw-bold">Join</button>
			</div>
		</div>
	</div>
</header>