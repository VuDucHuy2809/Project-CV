import React from 'react'

function About() {
  return (
    <div>
      <div class="mail animated wow zoomIn" data-wow-delay=".5s">
        <div class="container">
          <h3>About Us</h3>
          <p class="est">Welcome to World</p>
          <div class="mail-grids">
            <div class="col-md-8 mail-grid-left animated wow slideInLeft" data-wow-delay=".5s">

            </div>
            <div class="col-md-4 mail-grid-right animated wow slideInRight" data-wow-delay=".5s">
              <div class="mail-grid-right1">
                <img src="images/huy.jpg" alt=" " class="img-responsive" />
                <h4>HuyCuteHiHii <span>Manager</span></h4>
                <ul class="phone-mail">
                  <li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>Phone: +1234 567 893</li>
                  <li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>Email: <a href="mailto:info@example.com">fsforever2809@gmail.com</a></li>
                </ul>
                <ul class="social-icons">
                  <li><a href="https://www.facebook.com/huycutehihi.2809" class="facebook"></a></li>
                  <li><a href="https://twitter.com/v37771030" class="twitter"></a></li>
                  <li><a href="#" class="g"></a></li>
                  <li><a href="https://www.instagram.com/__hheehhe__/" class="instagram"></a></li>
                </ul>
              </div>
            </div>
            <div class="clearfix"> </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default About