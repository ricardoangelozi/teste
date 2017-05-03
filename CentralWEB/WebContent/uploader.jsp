<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Central da Revendedora</title>	
	<link rel="shortcut icon" type="image/png" href="img/favicon2.png"/>
	
	<link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,300italic,400italic,600,700,600italic,200,200italic' rel='stylesheet' type='text/css' />    
    <link href='http://fonts.googleapis.com/css?family=Play:400,700' rel='stylesheet' type='text/css' />
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
    
	<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css" /> 
    <link rel="stylesheet" type="text/css" href="resources/css/primeCSS.css" /> 
	
	<link rel="stylesheet" type="text/css" href="SITE/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="SITE/css/animate.css" />
    <link rel="stylesheet" type="text/css" href="SITE/css/skillset.css" />
    <link rel="stylesheet" type="text/css" href="SITE/css/owl.carousel.css" /> 
    <link rel="stylesheet" type="text/css" href="SITE/css/owl.transitions.css" />
    <link rel="stylesheet" type="text/css" href="SITE/css/owl.theme.css" />
    <link rel="stylesheet" type="text/css" href="SITE/css/style.css" />
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
</head>



<body class="bodyLogin">
	
<header class="main_header sticky">
  <div class="row">
     	<a class="logo" href="./SITE/index.jsp"><img src="./SITE/img/logo.png" alt="" width="100%"/></a>
      <div class="mobile-toggle"> <span></span> <span></span> <span></span></div>
      <nav>
        <ul class="main_menu">
          <li><a href="SITE/index.jsp">Voltar para o site</a></li>                    
        </ul>
      </nav>
  </div>
</header>

<section id="cadastroEntregas" style="margin-top: 75px;">
	<div class="row">
		<div class="col-lg-12">
	   	<h2 class="section-heading">Faça upload de seus documentos</h2>
	       <hr class="primary" />
	       <div class="subTitulo">Envie seus documentos para a Central </div>
	    </div>
	</div>
</section>
	

	<form action="upload.do" enctype="multipart/form-data" method="post" class="formUploader">
<div class="col-lg-12">	 
    <div id="rg" class="col-lg-3">
    	<label for="docRG">Anexo 01</label><br/>
    	<input type="file" name="fileRG" id="fileRG">
    	<input type="button" onclick="addAruivo('cpf')" value="Add outro" class="submit_btn2" >
    </div>
    
    <div id="cpf" class="col-lg-3" style="visibility: hidden;">
    	<label for="docCPF">Anexo 02</label><br/>
    	<input type="file" name="fileCPF" id="fileCPF" >
    	<input type="button" onclick="addAruivo('comprovante')" value="Add outro" class="submit_btn2"  >
    </div>
    
    <div id="comprovante" class="col-lg-3" style="visibility: hidden;">
    	<label for="docCompro">Anexo 03</label><br/>
    	<input type="file" name="fileCompro" id="fileCompro">
    	<input type="button" onclick="addAruivo('doc01')" value="Add outro" class="submit_btn2" >
    	 	
    </div>
    
    </div>
    <div class="col-lg-12">
    
     <div id="doc01" class="col-lg-3" style="visibility: hidden;">
    	<label for="doc01">Anexo 04</label><br/>
    	<input type="file" name="fileDoc01" id="fileDoc01">
    	<input type="button" onclick="addAruivo('doc02')" value="Add outro" class="submit_btn2" >
    	 	
    </div>
    
    <div id="doc02" class="col-lg-3" style="visibility: hidden;">
    	<label for="doc02">Anexo 05</label><br/>
    	<input type="file" name="fileDoc02" id="fileDoc02">
    	 	
    </div>
    
    
</div>

<input type="submit" value="Enviar Documentos " class="submit_btn2"/>    
</form>



<script type="text/javascript" src="SITE/js/main.js"></script>

	<script type="text/javascript">
		function addAruivo(campo){		
			var valor = campo;
			var divRg = document.getElementById(campo);
			divRg.style.visibility="visible";
		}
	</script>

</body>
</html>