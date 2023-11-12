<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>entJoin</h1>
	
	<fieldset>
		<form action="" method="post" enctype="multipart/form-data"> <br>
			아이디 : <input type="text" name="own_id" required="required"> <br>
			이름 : <input type="text" name="own_name" required="required"> <br>
			비밀번호 : <input type="password" name="own_pw" required="required"> <br>
			전화번호 : <input type="text" name="own_tel" required="required"> <br>
			이메일 : <input type="text" name="own_email" required="required"> <br>
			상호명 : <input type="text" name="ent_name" required="required"> <br>
			업종 : <input type="text" name="ent_cate" required="required"> <br>
			주소 : <input type="text" name="ent_addr" required="required"> <br>
			통신판매업 : <input type="text" name="ent_mo" required="required"> <br>
			사업자등록증 : <input type="file" name="ent_file" required="required"> <br>
			<input type="submit" value="가입하기">
		</form>
	</fieldset>

</body>
</html>