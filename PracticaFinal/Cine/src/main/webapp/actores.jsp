<%-- 
    Document   : actores
    Created on : 31 dic 2023, 5:02:07
    Author     : Jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es" class="no-js">
    <%@include file="components/head.jsp"%>
    <body>
        <%@include file="components/preloading.jsp"%>
        <%@include file="components/login.jsp"%>
        <%@include file="components/singup.jsp"%>
        <%@include file="components/header.jsp"%>

        <div class="hero common-hero">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="hero-ct">
					<h1>Actores</h1>
					<ul class="breadcumb">
						<li class="active"><a href="index.jsp">Home</a></li>
						<li> <span class="ion-ios-arrow-right"></span> Lista de Actores</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
        <!-- celebrity list section-->
        <div class="page-single">
                <div class="container">
                        <div class="row ipad-width2">
                                <div class="col-md-9 col-sm-12 col-xs-12">
                                        <div class="topbar-filter">
                                                <p class="pad-change">Se han encontrado <span>8 actores</span> en total</p>
                                                <label>Ordenado por:</label>
                                                <select>
                                                        <option value="popularity">Nombre</option>
                                                </select>
                                        </div>
                                        <div class="row">
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist1.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Dan Stevens</a></h2>
                                                                        <span>actor, usa</span>
                                                                        <p>Dan Stevens was born at Croydon in Surrey on 10th October 1982. His parents are teachers. He was educated at Tonbridge School and trained in acting at the National Youth Theatre of Great Britain... </p>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist2.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Luke Evans</a></h2>
                                                                        <span>actor, mexico</span>
                                                                        <p>Luke George Evans was born in Pontypool, Wales, and grew up in Aberbargoed, in the south of Wales. He is the son of Yvonne (Lewis) and David Evans. He moved to Cardiff at the age 17...</p>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist3.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Scarlett Johansson</a></h2>
                                                                        <span>actress, france</span>
                                                                        <p>Scarlett Ingrid Johansson was born in New York City. Her mother, Melanie Sloan, is from a Jewish family from the Bronx, and her father, Karsten Johansson, is a Danish-born architect, from Copenhagen...</p>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist4.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Emma Watson</a></h2>
                                                                        <span>actress, uk</span>
                                                                        <p>Emma Charlotte Duerre Watson was born in Paris, France, to English parents, Jacqueline Luesby and Chris Watson, both lawyers. She moved to Oxfordshire when she was five...</p>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist5.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Tom Hardy</a></h2>
                                                                        <span>actor, italy	</span>
                                                                        <p>Joan Crawford was born Lucille Fay LeSueur on March 23, 1905, in San Antonio, Texas, to Anna Belle (Johnson) and Thomas E. LeSueur, a laundry laborer. By the time she was born her parents had separated....</p>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist6.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Joan Crawford</a></h2>
                                                                        <span>director, sweden</span>
                                                                        <p>Joan Crawford was born Lucille Fay LeSueur on March 23, 1905, in San Antonio, Texas, to Anna Belle (Johnson) and Thomas E. LeSueur, a laundry laborer. By the time she was born her parents had separated....</p>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist7.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Margot Robbie</a></h2>
                                                                        <span>actress, chile</span>
                                                                        <p>Margot Robbie is an Australian actress born in Dalby, Queensland, and raised on the Gold Coast, spending much of her time at the farm belonging to her grandparents. Her mother, Sarie Kessler, is a physiotherapist....</p>
                                                                </div>
                                                        </div>
                                                </div>
                                                <div class="col-md-12">
                                                        <div class="ceb-item-style-2">
                                                                <img src="images/uploads/ceblist8.jpg" alt="">
                                                                <div class="ceb-infor">
                                                                        <h2><a>Jason Momoa</a></h2>
                                                                        <span>actor, usa</span>
                                                                        <p>Joseph Jason Namakaeha Momoa was born on August 1, 1979 in Honolulu, Hawaii. He is the son of Coni (Lemke), a photographer, and Joseph Momoa, a painter...</p>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div>
                                        <div class="topbar-filter">
                                        </div>
                                </div>
                                <div class="col-md-3 col-xs-12 col-sm-12">
                                        <div class="sidebar">
                                                <div class="ads">
                                                        <img src="images/uploads/ads1.png" alt="">
                                                </div>
                                                <div class="celebrities">
                                                        <h4 class="sb-title">Futuras celebridades</h4>
                                                        <div class="celeb-item">
                                                                <a href="#"><img src="images/uploads/ava1.jpg" alt=""></a>
                                                                <div class="celeb-author">
                                                                        <h6><a href="#">Samuel N. Jack</a></h6>
                                                                        <span>Actor</span>
                                                                </div>
                                                        </div>
                                                        <div class="celeb-item">
                                                                <a href="#"><img src="images/uploads/ava2.jpg" alt=""></a>
                                                                <div class="celeb-author">
                                                                        <h6><a href="#">Benjamin Carroll</a></h6>
                                                                        <span>Actor</span>
                                                                </div>
                                                        </div>
                                                        <div class="celeb-item">
                                                                <a href="#"><img src="images/uploads/ava3.jpg" alt=""></a>
                                                                <div class="celeb-author">
                                                                        <h6><a href="#">Beverly Griffin</a></h6>
                                                                        <span>Actor</span>
                                                                </div>
                                                        </div>
                                                        <div class="celeb-item">
                                                                <a href="#"><img src="images/uploads/ava4.jpg" alt=""></a>
                                                                <div class="celeb-author">
                                                                        <h6><a href="#">Justin Weaver</a></h6>
                                                                        <span>Actor</span>
                                                                </div>
                                                        </div>
                                                </div>
                                        </div>
                                </div>
                        </div>
                </div>
        </div>
        <!-- end of celebrity list section-->

        <%@include file="components/footer.jsp"%>
    </body>
    
</html>
