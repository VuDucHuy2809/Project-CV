import React from 'react'

function Mail() {
  return (
    <div>
        <div class="mail animated wow zoomIn" data-wow-delay=".5s">
            <div class="container">
                <h3>Mail Us</h3>
                <p class="est">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
                    deserunt mollit anim id est laborum.</p>
                <div class="mail-grids">
                    <div class="col-md-8 mail-grid-left animated wow slideInLeft" data-wow-delay=".5s">
                        <form>
                            <input type="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}" required=""/>
                            <input type="email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required=""/>
                            <input type="text" value="Subject" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Subject';}" required=""/>
                            <textarea type="text"  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Message...';}" required="">Message...</textarea>
                            <input type="submit" value="Submit Now" />
                        </form>
                    </div>
                    <div class="col-md-4 mail-grid-right animated wow slideInRight" data-wow-delay=".5s">
                        <div class="mail-grid-right1">
                            <img src="images/3.png" alt=" " class="img-responsive" />
                            <h4>Rita Williumson <span>Manager</span></h4>
                            <ul class="phone-mail">
                                <li><i class="glyphicon glyphicon-earphone" aria-hidden="true"></i>Phone: +1234 567 893</li>
                                <li><i class="glyphicon glyphicon-envelope" aria-hidden="true"></i>Email: <a href="mailto:info@example.com">info@example.com</a></li>
                            </ul>
                            <ul class="social-icons">
                                <li><a href="#" class="facebook"></a></li>
                                <li><a href="#" class="twitter"></a></li>
                                <li><a href="#" class="g"></a></li>
                                <li><a href="#" class="instagram"></a></li>
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

export default Mail