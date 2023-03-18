import React, { useContext } from 'react'
import {Link} from 'react-router-dom'
import { Store } from '../../Store';

function Header() {
	const {state} = useContext(Store);
	const {cart} = state;
  return (
    <div>
		<div className="header">
			<div className="container">
				<div className="header-grid">
					<div className="header-grid-left animated wow slideInLeft" data-wow-delay=".5s">
						<ul>
							<li><i className="glyphicon glyphicon-envelope" aria-hidden="true"></i><a href="mailto:info@example.com">fsforever2809@gmail.com</a></li>
							<li><i className="glyphicon glyphicon-earphone" aria-hidden="true"></i>+1234 567 892</li>
							<li><i className="glyphicon glyphicon-log-in" aria-hidden="true"></i><Link to="/login">Login</Link></li>
							<li><i className="glyphicon glyphicon-book" aria-hidden="true"></i><Link to="/register">Register</Link></li>
						</ul>
					</div>
					<div className="header-grid-right animated wow slideInRight" data-wow-delay=".5s">
						<ul className="social-icons">
							<li><a href="#" className="facebook"></a></li>
							<li><a href="#" className="twitter"></a></li>
							<li><a href="#" className="g"></a></li>
							<li><a href="#" className="instagram"></a></li>
						</ul>
					</div>
					<div className="clearfix"> </div>
				</div>
				<div className="logo-nav">
					<div className="logo-nav-left animated wow zoomIn" data-wow-delay=".5s">
						<h1><Link to="/">Best Store <span>Shop anywhere</span></Link></h1>
					</div>
					<div className="logo-nav-left1">
						<nav className="navbar navbar-default">
						<div className="navbar-header nav_2">
							<button type="button" className="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
								<span className="sr-only">Toggle navigation</span>
								<span className="icon-bar"></span>
								<span className="icon-bar"></span>
								<span className="icon-bar"></span>
							</button>
						</div> 
						<div className="collapse navbar-collapse" id="bs-megadropdown-tabs">
							<ul className="nav navbar-nav">
								<li className="active"><Link to="/" className="act">Home</Link></li>	
								<li className="dropdown">
									{/* <a href="#" className="dropdown-toggle" data-toggle="dropdown"><Link to="/products" className="dropdown-toggle" data-toggle="dropdown">Product</Link><b className="caret"></b></a> */}
									<Link to="/products" className="dropdown-toggle" data-toggle="dropdown">Product<b className="caret"></b></Link>
									<ul className="dropdown-menu multi-column columns-3">
										<div className="row">
											<div className="col-sm-4">
												<ul className="multi-column-dropdown">
													<h6>Men's Wear</h6>
													<li><a href="products.html">Shirt</a></li>
													<li><a href="products.html">Jean</a></li>
			
							
												</ul>
											</div>
											<div className="col-sm-4">
												<ul className="multi-column-dropdown">
													<h6>Women's Wear</h6>
													<li><a href="products.html">Dress</a></li>
													<li><a href="products.html">Jean</a></li>
													
												</ul>
											</div>
											<div className="col-sm-4">
												<ul className="multi-column-dropdown">
													<h6>Accessories</h6>
													<li><a href="products.html">Wallets</a></li>
													<li><a href="products.html">Shoes</a></li>
													<li><a href="products.html">Watches</a></li>
												</ul>
											</div>
											<div className="clearfix"></div>
										</div>
									</ul>
								</li>
								<li className="dropdown">
									<a href="#" className="dropdown-toggle" data-toggle="dropdown">Furniture <b className="caret"></b></a>
									<ul className="dropdown-menu multi-column columns-3">
										<div className="row">
											<div className="col-sm-4">
												<ul className="multi-column-dropdown">
													<h6>Home Collection</h6>
													<li><a href="furniture.html">Cookware</a></li>
													<li><a href="furniture.html">Sofas</a></li>
													<li><a href="furniture.html">Dining Tables</a></li>
													<li><a href="furniture.html">Shoe Racks</a></li>
													<li><a href="furniture.html">Home Decor</a></li>
												</ul>
											</div>
											<div className="col-sm-4">
												<ul className="multi-column-dropdown">
													<h6>Office Collection</h6>
													<li><a href="furniture.html">Carpets</a></li>
													<li><a href="furniture.html">Tables</a></li>
													<li><a href="furniture.html">Sofas</a></li>
													<li><a href="furniture.html">Shoe Racks</a></li>
													<li><a href="furniture.html">Sockets</a></li>
													<li><a href="furniture.html">Electrical Machines</a></li>
												</ul>
											</div>
											<div className="col-sm-4">
												<ul className="multi-column-dropdown">
													<h6>Decorations</h6>
													<li><a href="furniture.html">Toys</a></li>
													<li><a href="furniture.html">Wall Clock</a></li>
													<li><a href="furniture.html">Lighting</a></li>
													<li><a href="furniture.html">Top Brands</a></li>
												</ul>
											</div>
											<div className="clearfix"></div>
										</div>
									</ul>
								</li>
								<li><Link to="/about">About Us</Link></li>
								<li><Link to="/mail">Mail Us</Link></li>
							</ul>
						</div>
						</nav>
					</div>
					<div className="logo-nav-right">
						<div className="search-box">
							<div id="sb-search" className="sb-search">
								<form>
									<input className="sb-search-input" placeholder="Enter your search term..." type="search" id="search"/>
									<input className="sb-search-submit" type="submit" value=""/>
									<span className="sb-icon-search"> </span>
								</form>
							</div>
						</div>
							<script src="../../bs5/js/classNameic"></script>
							<script src="../../bs5/js/js/uisearch"></script>
								<script>
									new UISearch( document.getElementById( 'sb-search' ) );
								</script>
					</div>
					<div className="header-right">
						<div className="cart box_1">
							<Link to="/checkout">
								<h3> <div className="total">
									<span>${cart.cartItems.reduce((a, c) => a + c.price + c.quantity, 0)}</span>
									({cart.cartItems.length >0 && (<span>{cart.cartItems.reduce((a, c) => a + c.quantity, 0)} item</span>)})</div>
									<img src="images/bag.png" alt="" />
								</h3>
							</Link>
							<p><Link to="/checkout" className="simpleCart_empty">Empty Cart</Link></p>
							<div className="clearfix"> </div>
						</div>	
					</div>
					<div className="clearfix"> </div>
				</div>
			</div>
		</div>
		<div>
			<div className="banner-bottom">
				<div className="container"> 
					<div className="banner-bottom-grids">
						<div className="banner-bottom-grid-left animated wow slideInLeft" data-wow-delay=".5s">
							<div className="grid">
								<figure className="effect-julia">
									<img src="images/4.jpg" alt=" " className="img-responsive" />
									<figcaption>
										<h3>Best <span>Store</span><i> in online shopping</i></h3>
										<div>
											<p>Cupidatat non proident, sunt</p>
											<p>Officia deserunt mollit anim</p>
											<p>Laboris nisi ut aliquip consequat</p>
										</div>
									</figcaption>			
								</figure>
							</div>
						</div>
						<div className="banner-bottom-grid-left1 animated wow slideInUp" data-wow-delay=".5s">
							<div className="banner-bottom-grid-left-grid left1-grid grid-left-grid1">
								<div className="banner-bottom-grid-left-grid1">
									<img src="images/1.jpg" alt=" " className="img-responsive" />
								</div>
								<div className="banner-bottom-grid-left1-pos">
									<p>Discount 45%</p>
								</div>
							</div>
							<div className="banner-bottom-grid-left-grid left1-grid grid-left-grid1">
								<div className="banner-bottom-grid-left-grid1">
									<img src="images/2.jpg" alt=" " className="img-responsive" />
								</div>
								<div className="banner-bottom-grid-left1-position">
									<div className="banner-bottom-grid-left1-pos1">
										<p>Latest New Collections</p>
									</div>
								</div>
							</div>
						</div>
						<div className="banner-bottom-grid-right animated wow slideInRight" data-wow-delay=".5s">
							<div className="banner-bottom-grid-left-grid grid-left-grid1">
								<div className="banner-bottom-grid-left-grid1">
									<img src="/images/3.jpg" alt=" " className="img-responsive" />
								</div>
								<div className="grid-left-grid1-pos">
									<p>top and classNameic designs <span>2022 Collection</span></p>
								</div>
							</div>
						</div>
						<div className="clearfix"> </div>
					</div>
				</div>
			</div>
		</div>
		
	</div>
  )
}

export default Header