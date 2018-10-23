<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Home Page</title>
	<style type="text/css">
		.item{
			display: block;
			float: none;
			clear: both;
			z-index: 99998;
			border-top: #ccc solid 1px;
			background: none;
			background-color: #fff;
			margin: 0;
			padding: 1px;

			background-image: url("images/1.png");
			background-repeat: no-repeat;

			color: #000;
			cursor: pointer;
			height: 32px;
			line-height: 39px;
			padding-left: 41px;

			width: 180px;
			float: left;
			padding-top: 5px;
			color: #464646;
			font-weight: bold;
			margin-right: 17px;
			text-align: left;
		}
		.accordion2 ul{
			list-style-type: none;
			margin: 0px;
			display: none;
			width: 224px;
			float: left;
 			left: 0px;
 			top: 0;

		}

		.accordion2 ul li{
			padding: 0px;
		}

		.accordion2{
			width: 500px;
			height: 300px;
		}
		.item:hover {
			background-image: url("images/2.png");
			background-repeat: no-repeat;
			display: block;
			/* sdsd */
		}
	</style>
</head>
<body>
	<div class="accordion2" id="area-leftmenu">
				<p class='item'  class='he'>Thông tin Cá nhân</p>
				<ul>
					<li>
						<a href='#' >
							<span>Thông tin Cá nhân</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Mật khẩu</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Tìm kiếm Người</span>
						</a>
					</li>
				</ul>

				<p class='item' >Tin tức & Thông báo</p>
				<ul>
					<li>
						<a href='#' >
							<span>Tin tức & Sự kiện</span>&nbsp;
							<span class='notreadnum'></span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Thông báo</span>&nbsp;
							<span class='notreadnum'></span>
						</a>
					</li>
				</ul>

				<p class='item active' >Lịch</p>
				<ul>
					<li>
						<a href='#' >
							<span>Lịch cá nhân</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Lịch dạy</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Lịch học</span>
						</a>
					</li>
				</ul>

				<p class='item' >Học tập</p>
				<ul>
					<li>
						<a href='#' >
							<span>Đăng ký Môn học</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Đăng ký Lịch giả định</span>
						</a>
					</li>
					<li>
						<a href='#' ><span>Bảng điểm</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Chương Trình học</span>
						</a>
					</li>
					<li>
						<a href='#' ><span>Đề cương Môn học</span>
						</a>
					</li>
				</ul>

				<p class='item' >Học phí</p>
				<ul>
					<li>
						<a href='#'>
							<span>Dự trù Học phí</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Hóa đơn Học phí</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Lịch sử Thanh toán</span>
						</a>
					</li>
					<li>
						<a href='#' >
							<span>Quy định Học phí</span>
						</a>
					</li>
				</ul>

				<p class='item' >Cố vấn Học tập</p>
				<ul>
					<li>
						<a href='#'><span>Giảng viên Cố vấn</span></a>
					</li>
					<li>
						<a href='#' >
							<span>Cảnh báo Học tập</span>
						</a>
					</li>
				</ul>

				<p class='item' >Đánh giá</p>

				<ul>
					<li>
						<a href='#' >
							<span>Đánh giá Giảng viên</span>
						</a>
					</li>
					<li>
						<a href='#'>
							<span>Phiếu khảo sát Sinh viên năm cuối</span>
						</a>
					</li>
				</ul>
			</div>
	</body>
</html>