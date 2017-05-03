<%@ page language="java" contentType="text/html; charset=utf8" pageEncoding="utf8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Central da Revendedora - JSP</title>
	
	<link rel="shortcut icon" type="image/png" href="./img/favicon2.png"/>
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" >
	<link rel="stylesheet" type="text/css" href="css/animate.css">
    <link rel="stylesheet" type="text/css" href="css/skillset.css">
    <link rel="stylesheet" type="text/css" href="css/owl.carousel.css"> 
    <link rel="stylesheet" type="text/css" href="css/owl.transitions.css">
    <link rel="stylesheet" type="text/css" href="css/owl.theme.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
     <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
     <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

	<script type="text/javascript" src="js/jssor.slider.min.js"></script>
	<script type="text/javascript" src="js/jssor.sliderMain.js"></script>
		
</head>

<body>
<!--preloader-->
    <div id="preloader">
      <div id="status">&nbsp;</div>
    </div> 


<header class="main_header sticky">
  <div class="row">
     	<a class="logo" href="index.jsp"><img src="img/logo.png" alt="" width="100%"/></a>
      <div class="mobile-toggle"> <span></span> <span></span> <span></span></div>
      <nav>
        <ul class="main_menu">
          <li><a href=".banner_area">Promoções</a></li>
          <li><a href=".work_area">Faça Parte</a></li>
          <li><a href=".portfolio_area">Catálogos</a></li>
          <li><a href=".blog_area">Datas de Pedidos</a></li>
          <li><a href=".contact_area">Contato</a></li>
          <li><a href="../uploader_cpf_form.faces">Envio de Documentos</a></li> <!-- TELA NOVA DE ENVIO DE DOCUMENTOS -->
        </ul>
      </nav>
  </div> 
</header>



	
	<div class="row" style="margin-top: 75px;">
		<div class="col-md-6 bannerHome">
			<div class="carousel fade-carousel slide" data-ride="carousel" data-interval="2000" id="bs-carousel">
			   	<div class="single_service">
	    	        <div id="jssor_1" style="position: relative; margin: 0 auto; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden; visibility: hidden;">
					    <div data-u="slides" style="cursor: default; position: relative; top: 0px; left: 0px; width: 600px; height: 300px; overflow: hidden;">
					       <div data-p="112.50" style="display: none;">
						       <img data-u="image" src="img/bannerHiroshima/1.jpg" />
					        </div>
					    	<div data-p="112.50" style="display: none;">
					    		<img data-u="image" src="img/bannerHiroshima/2.jpg" />
					    	</div>
					        <div data-p="112.50" style="display: none;">
					        	<img data-u="image" src="img/bannerHiroshima/3.jpg" />
					        </div>
					        <div data-p="112.50" style="display: none;">
					        	<img data-u="image" src="img/bannerHiroshima/4.jpg" />
					        </div>
					        <div data-p="112.50" style="display: none;">
					        	<img data-u="image" src="img/bannerHiroshima/5.jpg" />
					        </div>
					        <div data-p="112.50" style="display: none;">
					        	<img data-u="image" src="img/bannerHiroshima/7.jpg" />
					        </div>
					        <div data-p="112.50" style="display: none;">
					        	<img data-u="image" src="img/bannerHiroshima/9.jpg" />
					        </div>
					        	<a data-u="ad" href="http://www.jssor.com" style="display:none">jQuery Slider</a>
					    </div>
					    <div data-u="navigator" class="jssorb01" style="bottom:16px;right:16px;">
					    	<div data-u="prototype" style="width:12px;height:12px;"></div>
					    </div>
					    <span data-u="arrowleft" class="jssora05l" style="top:0px;left:8px;width:40px;height:40px;" data-autocenter="2"></span>
					    <span data-u="arrowright" class="jssora05r" style="top:0px;right:8px;width:40px;height:40px;" data-autocenter="2"></span>
				   	</div>
					<script>
					jssor_1_slider_init();
					</script>
	    		</div>
   			</div>
		</div>
   			
		<div class="col-md-6 btnRev">
			<a href="../form_catalogo.faces" class="btn-especial">SEJA UMA REVENDEDORA</a>
      		<a href="../form_cpf_pedido.faces" class="btn-especial" >FAÇA SEU PEDIDO</a>
		</div>
 		
   	</div>
     
<div class="getit_area">
    <div class="row">
      <div class="getit_section">
        <h3 class="col-sm-4 col-md-4 col-lg-4">20% de Desconto</h3>
		<h3 class="col-sm-4 col-md-4 col-lg-4">Prazo para Pagamento</h3>
		<h3 class="col-sm-4 col-md-4 col-lg-4">Entrega Gratuita</h3>
      </div>  
    </div>
</div><!--  getit area end -->

<div class="banner_area">
    <div class="row">
      <div class="service_section wow bounceInLeft animated">
          
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
            <div class="single_service">        
              <h3>Mega Oferta</h3>
              <p>A cada catálogo uma grande oferta a preço de custo para as revendedoras.</p>
              <button class="submit_btn2" id="submit_btn" onclick="location.href='megaOferta.html';">Saiba Mais</button>
            </div>
          </div>
          
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">  
            <div class="single_service">        
              <h3>Boleto Premiado</h3>
              <p>Todo boleto quitado até o vencimento, concorre a diversos prêmios mensais.</p>
              <button class="submit_btn2" id="submit_btn" onclick="location.href='boletoPremiado.html';">Saiba Mais</button>
            </div>
          </div>
          
          <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
          	<div class="single_service">        
              <h3>Indique e Ganhe</h3>
              <p>Você indica uma amiga para ser revendedora e ganha um brinde.</p>
               <button class="submit_btn2" id="submit_btn" onclick="location.href='indiqueGanhe.html';">Saiba Mais</button>
            </div>
          </div>
          
          

      </div>
    </div>
</div><!-- banner area end   -->

<div class="work_area">
  <div class="row">  
      <div class="work_section">
        <h2 class="wow bounceInLeft">Venha para<span> Central da Revendedora</span></h2>
          <div class="col-md-12 wow bounceInRight animated">
            <div class="bs-example">
              <ul class="nav nav-tabs">
                  <li class="active"><a data-toggle="tab" href="#sectionA"><i class="fa fa-lightbulb-o"></i>Revendedora</a></li>
                  <li><a data-toggle="tab" href="#sectionB"><i class="fa fa-compass"></i>Promotora</a></li>
                  <li><a data-toggle="tab" href="#sectionD"><i class="fa fa-file-text-o"></i>Envio de Documentos</a></li>
                  <li><a data-toggle="tab" href="#sectionC"><i class="fa fa-lightbulb-o"></i>Quem Somos</a></li>
                  
                  
              </ul>
              <div class="tab-content">
                  <div id="sectionA" class="tab-pane fade in active">
                      <h3>Seja uma Revendedora Hiroshima</h3>
                      <p>
					Venha fazer parte de uma equipe que cresce diariamente, oferecendo uma variedade de mais de 1.000 itens, todos com excelente qualidade e ótimo atendimento.
					Não perca a chance de alcançar todos os seus objetivos profissionais, além de fazer novas amizades e viver novas experiências.
					<br />
					* Desconto de 20% em cada produto<br />
					* Prazo médio para pagamento de 14 dias no boleto,<br />
					* Entregas em casa sem custo,<br />
 					Horário flexível. A revendedora pode realizar suas vendas em qualquer dia da semana.
 					<br /><br />
 					<a href="../form_catalogo.faces" class="submit_btn2" >Seja uma Revendedora Hiroshima</a>
					</p>
                  </div>
                  <div id="sectionB" class="tab-pane fade">
                      <h3>Seja uma Promotora de Vendas Hiroshima</h3>
                      <p>
                      Ser uma Promotora de Vendas é a chance de alcançar a sua realização profissional, fazer novas amizades e viver novas experiências, com a facilidade de horário flexível, ou seja, é você quem determina quando trabalhar e quantas horas trabalhar.
						<br />
						O nosso novo sistema visa a lucratividade e a simplicidade na contratação de revendedoras.
						<br />
						Veja como é fácil formar uma equipe e agregar mais lucratividade ao seu negócio.
						<br />
						* Não é necessário ponto comercial ou empresa aberta,<br />
						* Fornecemos banners,<br />
						* Fornecemos panfletos para divulgação,<br />
						* Não cobramos catálogos,<br />
						* Separamos as caixas por revendedora, <br />
						* Calculamos e emitimos os boletos,<br />
						* Entregamos na casa das revendedoras,<br />
						* Somos responsáveis pela cobrança.<br />
						<br />
						Como você pode ver, uma Promotora de Vendas deverá apenas recrutar as revendedoras e recolher os pedidos.
						<br /><br />
 						<a href="../form_catalogo.faces" class="submit_btn2">Seja uma promotora Hiroshima</a>
					  </p>
                  </div>
                  
                  <div id="sectionD" class="tab-pane fade">
                      <h3>Como enviar seus documentos</h3>
                      <p>
		                    Formamos uma equipe que atua há mais de 30 anos no mercado de venda porta a porta, constituímos uma empresa sólida e confiável, pois sempre buscamos o respeito e credibilidade perante nossas revendedoras e clientes.
							Oferecemos a comodidade do atendimento via web e telefone, com uma central equipada e atendentes preparados para tirar suas dúvidas e receber seus pedidos.
		<br />
							Além da qualidade no atendimento, oferecemos entrega gratuita e prazo para pagamento no boleto bancário.
		<br />
							Atualmente nos orgulhamos de sermos uma das empresas mais eficientes do ramo, com o melhor atendimento do mercado. Venha fazer parte dessa equipe de sucesso!
					  </p>
                  </div>
                  
                  <div id="sectionC" class="tab-pane fade">
                      <h3>Quem somos</h3>
                      <p>
		                    Formamos uma equipe que atua há mais de 30 anos no mercado de venda porta a porta, constituímos uma empresa sólida e confiável, pois sempre buscamos o respeito e credibilidade perante nossas revendedoras e clientes.
							Oferecemos a comodidade do atendimento via web e telefone, com uma central equipada e atendentes preparados para tirar suas dúvidas e receber seus pedidos.
		<br />
							Além da qualidade no atendimento, oferecemos entrega gratuita e prazo para pagamento no boleto bancário.
		<br />
							Atualmente nos orgulhamos de sermos uma das empresas mais eficientes do ramo, com o melhor atendimento do mercado. Venha fazer parte dessa equipe de sucesso!
					  </p>
                  </div>
                  
                 
              </div>
            </div>
          </div>
          
          
          
      </div>
    </div>  
</div><!-- work area end   -->
      <jsp:useBean id="dao" scope="request"  class="com.mb.IndexBean"></jsp:useBean>

<!-- Catálogos  -->
<div class="portfolio_area">
   <div class="row"> 
      <div class="portfolio_section">
          <div class="col-md-12 portfolio_top">
              <h2>Catálogos</h2>
              <p>Aqui você confere os catálogos Hiroshima</p>
          </div>  
      </div>

    <div id="portfoliolist">
    
	   <c:forEach var="catalogos"  items="${dao.listaCatalogo}">
	   		<div class="portfolio">
		        <div class="portfolio-wrapper">       
		          <a href="${catalogos.catUrl}" class="text-title" target="_blanck" ><img src="${catalogos.catPhoto}"/></a>
		          <div class="label">
		            <div class="label-text">
		              <a href="${catalogos.catUrl}" class="text-title" target="_blanck">${catalogos.catNomeCatalogo}</a>
		              <span class="text-category"> ${catalogos.catNome}</span>
		            </div>
		            <div class="label-bg"></div>
		          </div>
		        </div>
      		</div>     
	  </c:forEach>  
            
    </div>
    
  </div>
</div><!-- portfolio area end   -->

<div class="blog_area">
    <div class="row">
      <div class="blog_section">
          <h2>Acompanhe as <span>Datas de Fechamento</span></h2>
          	<div class="single_blog col-md-12">
	          	<table border="1" class="table table-bordered">
	          	
				
	          	
	          	
	          	
	          	
				  <thead>
				    <tr>
				      <th>Cidades</th>
				      <th>Entrada do Pedido</th>
				      <th>Entrega da Caixa</th>
				      <th>Boleto de Pagamento</th>
				    </tr>
				  </thead>
				  <tbody>
				  
				  <c:forEach var="teste"  items="${dao.listaUser}">
	          		<tr>
				      <td>${teste.dsCidade}</td> <!-- Nome da cidade -->
				       <td>${teste.entradaPedido}</td> <!-- DT PEDIDO-->
				       <td>${teste.entregaCaixa}</td> <!-- DT CAIXA-->
				       <td>${teste.boletoPagamento}</td> <!-- DT PAGAMENTO -->
				    </tr>
				</c:forEach>
				  
				    
				  </tbody>
				</table>
        	</div>
		</div>    
    </div>
</div>

<!-- blog area end   -->



<div class="contact_area">
    <div class="row">
      <div class="contact_section">
          <h2>Fale Conosco</h2>
          <p>Envie suas dúvidas, criticas, sugestões e informações conforme assuntos relacionados nos itens do formulário abaixo.</p>

                    
                        <div class="col-md-6 contact_form">
	                        <form id="contact_form" method="get" action="../enviaEmail">
	                            <div id="result"></div>
	                                <label for="name">
	                                	<input type="text" name="nome" id="nome" placeholder="Nome" title="Preencha o campo Nome"  />
	                                </label>
	                                
	                                <label for="email">
	                                	<input type="email" name="email" id="email" placeholder="E-mail" title="Preencha o email" />
	                                </label>
	                                
	                                <label for="phone">
	                                	<input type="text" name="phone" id="phone" placeholder="Telefone" title="Preencha o telefone" />
	                                </label>
	                                
	                                <label for="assunto">
		                                <select id="assuntoID" name="assuntoID" title="Preencha o assunto" >
		                                 	<option value="Dúvidas" >Dúvidas</option>
		                                  	<option value="Críticas">Críticas</option>
		                                   	<option value="Sugestões">Sugestões</option>
		                                    <option value="Quero Comprar">Quero Comprar</option>
		                                    <option value="Quero Revender">Quero Revender</option>
		                                </select>
	                                </label>
	                                                                
	                                <label for="message">
	                                	<textarea name="message" id="message" placeholder="Digite sua mensagem" title="Preencha a Mensagem" ></textarea>
	                                </label>
	                                
	                                <button class="submit_btn" id="submit_btn">Enviar</button>
	                        </form>                           
                        </div>
                    
                    <div class="col-md-6">
                        <div class="contact_text">
                            <h3>CONTATO</h3>
                            <ul class="contact_info">
                                <li>contato@centraldarevendedora.com.br</li>
                                <li>11 3297-5252 (São Paulo)</li>
                                <li>21 4062-7605 (Rio de Janeiro) </li>
                                <li>31 4062-7544 (Minas Gerais)</li>
                                <li>27 4062-9170 (Espirito Santo)</li>
                            </ul>
                            <h3>Mídias</h3>
                            <ul class="contact_social">
                                <li><a href="https://www.facebook.com/hiroshimacatalogo" target="_blank"><i class="fb fa fa-facebook-square"></i></a></li>
                                <li><a href="../login.faces"><i class="fa fa-location-arrow" aria-hidden="true"></i></a></li>
                            </ul>                            
                        </div>
                    </div>
                    
                    <div class="col-md-12">
                        <div class="contact_text_rodape">
                            <span>Central da Revendedora © 2016 Todos Direitos Reservados - Fotos e textos sob responsabilidade do cliente.</span>
                        </div>
                    </div>
    </div>
  </div> 
</div><!-- contact area end   -->
	
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
    
    <script src="js/wow.js"></script>

    <script src="js/jquery.nicescroll.js"></script>
    
    <script type="text/javascript" src="js/jquery.easing.min.js"></script>  
    <script type="text/javascript" src="js/jquery.mixitup.min.js"></script>
    <script src="js/imagesloaded.pkgd.min.js"></script>

   <script src="js/skillset.js"></script>

   <script src="js/owl.carousel.js"></script> 


   <script src="js/scrollupto.js"></script>
   <script type="text/javascript" src="js/main.js"></script>
   
   
  
   
   
</body>
</html>