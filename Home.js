import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import Booking from "./Booking";
import Title from "./Title";
import logo from "./images/logo.png";
import Services from "./Services";
import Contact from "./AboutUs"
export default class Home extends Component {



    render() {
        return (
            <Router>
            <div className="home">

                <nav class="navbar navbar-expand-lg fixed-top">
                    <div class="container-fluid">
                        <img src={logo} class="navbar-brand" alt=""></img>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                          <Link className="cl" to={"/title"}>Home</Link>
                          <Link className="cl" to={"/Services"}>Services</Link>
                          <Link className="cl" to={"/Contact"}>About Us</Link>
                          <Link className="btne" to={"/Booking"}>Book now</Link>

                       </div>
                        </div>
                    </div>
                </nav>
                         <Switch>
                         <Route  path='/home' component={Title} />
                         <Route  path='/title' component={Title} />
                        <Route path="/Booking" component={Booking} />
                        <Route  path='/Services' component={Services} />
                        <Route path="/Contact" component={Contact} />
                        </Switch>
              
            </div> 
            <div className="footer">
      <p>&copy; Copyright 2020 <i>@snehalmiraje</i></p>
    </div>
             </Router>

            
        );
    }

}