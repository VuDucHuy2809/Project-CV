import axios from 'axios';
import React, {useEffect, useState, useReducer, useContext } from 'react'
import { Link, Navigate, useNavigate } from 'react-router-dom';
import {Store} from '../../../Store'

function Chekout() {
  const navigate = useNavigate();
  const {state, dispatch: ctxDispatch} = useContext(Store);
  const {
    cart: { cartItems },
  } = state ;
  const updateCartHandler = async (item, quantity) => {
    const { data } = await axios.get(`/api/products/${item._id}`);
    if(data.countInStock < quantity ) {
        window.alert('Sorry. product is out of stock');
        return ;
    }
    ctxDispatch({
      type: 'CART_ADD_ITEM',
      payload: {...item,quantity},
    });
  }
  const removeItemHandler = (item) => {
    ctxDispatch({ type: 'CART_REMOVE_ITEM', payload: item });
  };
  const checkoutHandler = () => {
    navigate('/signin?redirect=/shipping');
  };
  return (
    <div>
      <div class="breadcrumbs">
        <div class="container">
          <ol class="breadcrumb breadcrumb1 animated wow slideInLeft" data-wow-delay=".5s">
            <li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span>Home</a></li>
            <li class="active">Checkout Page</li>
          </ol>
        </div>
      </div>
      <div class="checkout">
        <div class="container">
          <h3 class="animated wow slideInLeft" data-wow-delay=".5s">Your shopping cart contains: <span>3 Products</span></h3>
          <div class="checkout-right animated wow slideInUp" data-wow-delay=".5s">
            <table class="timetable_sub">
              <thead>
                <tr>
                  <th>SL No.</th>	
                  <th>Product</th>
                  <th>Quality</th>
                  <th>Product Name</th>
                  <th>Service Charges</th>
                  <th>Price</th>
                  <th>Remove</th>
                </tr>
              </thead>
              {cartItems.length === 0 ? (
                <div>Cart is emty. <Link to="/">Go shopping</Link></div>
              ):
              ( 
                <>
                  {cartItems.map((item) => (
                    <tr key={item._id} class="rem1">
                      <td class="invert">1</td>
                      <td class="invert-image"><Link to="/"><img src={item.image} alt=" " class="img-responsive" /></Link></td>
                      <td class="invert">
                        <div class="quantity"> 
                          <div class="quantity-select">                           
                            <button class="entry value" onClick={() => updateCartHandler(item,item.quantity - 1)} disabled={item.quantity === 1} class="entry value-minus">&nbsp;</button>
                            <div class="entry value"><span>{item.quantity}</span></div>
                            <button onClick={() => updateCartHandler(item,item.quantity + 1)} disabled={item.quantity === item.countStock} class="entry value-plus active">&nbsp;</button>
                          </div>
                        </div>
                      </td>
                      <td class="invert">{item.name}</td>
                      <td class="invert">$5.00</td>
                      <td class="invert">{item.price}</td>
                      <td class="invert">
                        <div class="rem">
                          <button className='btnAdd' onClick={() => removeItemHandler(item)}>
                            <i class="fa-solid fa-trash"></i>
                          </button>
                        </div>
                      </td>
                    </tr>
                  ))}      
                </>
              )}
            </table>
          </div>
          <div class="checkout-left">	
            <div class="checkout-left-basket animated wow slideInLeft" data-wow-delay=".5s">
              <h4>Continue to basket</h4>
                <ul>
                  {cartItems.map((item) => (
                    <li>{item.name} <i>x{item.quantity}</i> <span>${item.price * item.quantity} </span></li>
                  ))}
                </ul>
              <ul>
                <li>Total <i>-</i> <span>${cartItems.reduce((a, c)=> a+ c.price * c.quantity, 0)}</span></li>
              </ul>
            </div>
            <div class="checkout-right-basket animated wow slideInRight" data-wow-delay=".5s">
              <button disabled={cartItems.length === 0} onClick={checkoutHandler} className='btnAdd'><a><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Continue Shopping</a></button>
            </div>
            <div class="clearfix"> </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Chekout