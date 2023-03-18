import React, {useEffect, useState, useReducer } from 'react'
import { Link } from 'react-router-dom'
import data from '../../../data'
import logger from 'use-reducer-logger';
import ProductsMain2 from './ProductsMain2'
import axios from 'axios'
import LoadingBox from '../../err/LoadingBox';

const reducer = (state, action) => {
    switch (action.type) {
      case 'FETCH_REQUEST':
        return { ...state, loading: true };
      case 'FETCH_SUCCESS':
        return { ...state, products: action.payload, loading: false };
      case 'FETCH_FAIL':
        return { ...state, loading: false, error: action.payload };
      default:
        return state;
    }
  };


function Products() {
    const [{ loading, error, products }, dispatch] = useReducer(logger(reducer), {
        products: [],
        loading: true,
        error: '',
      });
      // const [products, setProducts] = useState([]);
      useEffect(() => {
        const fetchData = async () => {
          dispatch({ type: 'FETCH_REQUEST' });
          try {
            const result = await axios.get('/api/products');
            dispatch({ type: 'FETCH_SUCCESS', payload: result.data });
          } catch (err) {
            dispatch({ type: 'FETCH_FAIL', payload: err.message });
          }
    
          // setProducts(result.data);
        };
        fetchData();
      }, []);
    // const [products, setProducts] = useState([]);
  return (
    // <div>
    //     {data.products.map((product) =>(<ProductsMain2 key={product._id} product={product}></ProductsMain2>))}
    // </div>
        <div>
            <div className="new-collections">
                <div className="container">
                    <h3 className="animated wow zoomIn" data-wow-delay=".5s">New Collections</h3>
                    <p className="est animated wow zoomIn" data-wow-delay=".5s">No need to change the entire wardrobe, with just a few items and these simple tips, you will still be "cooler" in the eyes of the opposite person.</p>
                    <div className="new-collections-grids">
                            <div>{ loading ? (
                                <LoadingBox></LoadingBox>
                            ) : error ? (
                                <div>{error}</div>
                            ) : (
                                products.map((product) =>(
                                  <div key={product.slug}>
                                    <ProductsMain2  product={product}></ProductsMain2>
                                  </div>
                                )))}
                            </div>
                    <div className="clearfix"> </div>
                </div>
            </div>
        </div>
    </div>
  )
}

export default Products