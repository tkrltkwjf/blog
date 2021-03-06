<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<%@ include file="/WEB-INF/jspf/head.jspf" %> 
<title>Login</title> 
</head> 
<body> 
     <%@ include file="/WEB-INF/jspf/nav.jspf" %> 
      
     <header class="intro-header" style="background-image: url('http://blog.millky.com/image/contact-bg.jpg')"> 
         <div class="container"> 
             <div class="row"> 
                 <div class="col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1"> 
                     <div class="page-heading"> 
                         <h1>Login</h1> 
                         <hr class="small"> 
                         <span class="subheading">Connect to Facebook</span> 
                     </div> 
                 </div> 
             </div> 
         </div> 
     </header> 
 

 	<div class="container">
 		<div id="con_facebook">
	 		<h3>Connect to Facebook API v2.3</h3> 
	 
	
	 		<form action="/signin/facebook" method="POST"> 
	 			<input type="hidden" name="_csrf" value="${_csrf.token}"></input> 
	 			<div class="formInfo"> 
	 				<p>You aren't connected to Facebook yet. Click the button to connect this application with your Facebook account.</p> 
	 			</div> 
	 			<p> 
	 				<button type="submit">Connect to Facebook</button> 
	 			</p> 
	 		</form> 
 		</div> 
 		<div id="con_twitter">
	 		<h3>Connect to Twitter API v2.3</h3> 
	 
	
	 		<h3>Connect to Twitter</h3>
			<span th:if="${social_provider_error}">Provider error (maybe you need to configure the app id and secret?)</span>
			<form action="/signin/twitter" method="POST">
				<div class="formInfo">
					<p>You aren't connected to Twitter yet. Click the button to connect this application with your Twitter account.</p>
				</div>
				<p><button type="submit">Connect to Twitter</button></p>
			</form>

 		</div> 
 	</div> 
 

 	<%@ include file="/WEB-INF/jspf/footer.jspf" %> 
 </body> 
 </html>