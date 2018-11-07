<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Chọn năm</title>
<link rel="stylesheet" href="../Css/chooseYear.css">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body>
	<div id="container">
		<div id="header"></div>
		<div id="sidebar">
			<div id="content">
				<label id="NameUser">Phan Văn Hội</label>
				<div class="chooseYear">
					<select>
						<option value="" disabled selected>Chọn Năm Học</option>
						<option>Năm học: 2014-2015</option>
						<option>Năm học: 2015-2016</option>
						<option>Năm học: 2016-2017</option>
						<option>Năm học: 2017-2018</option>
					</select>
				</div>

				<div class="chooseYear">
					<select class="chonHocKy">
						<option value="" disabled selected>Chọn Học Kỳ</option>
						<option>Học Kỳ I</option>
						<option>Học Kỳ II</option>
						<option>Học Kỳ Hè</option>
					</select>
				</div>

				<button type="button" class="btn btn-secondary" onclick="Redirect();">Tiếp Tục</button>
				<script type="text/javascript">
					function Redirect() {
						window.location = "TimeTableAssumes.jsp";
					}			
				</script>
			</div>
			<div id="footer"></div>
		</div>
	</div>
</body>
</html>