import React from 'react'
import { Link, useLocation } from 'react-router-dom'

function Login() {
    const { search } = useLocation();
    const redirectInUrl = new URLSearchParams(search).get('redirect');
    const redirect = redirectInUrl ? redirectInUrl : '/';
  return (
    <div>
        <div class="login">
            <div class="container">
                <h3 class="animated wow zoomIn" data-wow-delay=".5s">Login Form</h3>
                <p class="est animated wow zoomIn" data-wow-delay=".5s">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia 
                    deserunt mollit anim id est laborum.</p>
                <div class="login-form-grids animated wow slideInUp" data-wow-delay=".5s">
                    <form >
                        <input type="email" placeholder="Email Address" required=" " controlId="email"/>
                        <input type="password" placeholder="Password" required=" " controlId="password"/>
                        <div class="forgot">
                            <Link to="/forgotpass">Forgot Password?</Link>
                            <Link to={`/signup?redirect=${redirect}`}>Create New Account?</Link>
                        </div>
                        <input type="submit" value="Login"/>
                    </form>
                </div>
                <h4 class="animated wow slideInUp" data-wow-delay=".5s">For New People</h4>
                <p class="animated wow slideInUp" data-wow-delay=".5s"><Link to="/register">Register Here</Link> (Or) go back to <Link to="/">Home<span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span></Link></p>
            </div>
        </div>
    </div>
  )
}

export default Login