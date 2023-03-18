import { Link } from 'react-router-dom';
import Rating from './Rating';
import React, {useEffect, useState, useReducer, useContext } from 'react'
import { Store } from '../../../Store';
import axios from 'axios';

function ProductsMain2(props) {
    const {product} = props;
    const {state, dispatch: ctxDispatch} = useContext(Store);
    const {
        cart: { cartItems},
    } = state;

    const addToCartHandler = async () => {
        const existItem = cartItems.find((x) => x._id === product._id);
        const quantity = existItem ? existItem.quantity + 1 : 1;
        const {data} = await axios.get(`/api/products/${product._id}`);
        if(data.countInStock < quantity ){
            window.alert('Sorry . Product is out if stock');
            return ;
        }
        ctxDispatch({
            type: 'CART_ADD_ITEM',
            payload: {...product,quantity},
        });
    }
  return (
    <div>
        {/* <h4><Link to={`/products/${product._id}`}>{product.name}</Link></h4> */}
        <div  className="col-md-3 new-collections-grid">
        <div className="new-collections-grid1 animated wow slideInUp" data-wow-delay=".5s">
            <div className="new-collections-grid1-image">
                <Link to={`products/${product.slug}`} className="product-image"><img src={product.image} alt={product.name} className="img-responsive" /></Link>
                <div className="new-collections-grid1-image-pos">
                    <Link to={`products/${product.slug}`}>Quick View</Link>
                </div>
                <div className="new-collections-grid1-right">
                    <div className="rating">
                        <Rating rating = {product.rating} numReviews={product.numReviews}></Rating>
                        <div className="clearfix"> </div>
                    </div>
                </div>
            </div>
            <h4><Link to={`/product/${product._id}`}>{product.name}</Link></h4>
            <p>{product.description}</p>
            <div className="new-collections-grid1-left simpleCart_shelfItem">
                {product.countInStock <= 0 ? <span class="badge bg-success">on Stock</span>
                :
                    // <p><i>$340</i> <span className="item_price">${product.price}</span><button className='btnAdd' onClick={() => addToCartHandler(product)}><p><a>Add sto cart</a></p></button></p>
                    <span class="badge bg-success">In Stock</span>
                }
            </div>
        </div>
        </div>
    </div>
  )
}

export default ProductsMain2
