import React, { useContext } from 'react'
import {Routes , Route} from  'react-router-dom'
import Products from './products/Products'
import ProductsMain from './products/ProductsMain'
import Login from './auth/Login'
import Register from './auth/Register'
import Mail from './contact/Mail'
import About from './contact/About'
import Chekout from './cart/Chekout'
import ProductDetail from './products/ProductDetail'
function Pages() {
  return (
    <Routes>
      <Route path='/' element={<Products />} />
      <Route path='/products' element={<ProductsMain />} />
      <Route path='/products/:slug' element={<ProductDetail />} />
      <Route path='/signin' element={<Login />} />
      <Route path='/register' element={<Register />} />
      <Route path='/about' element={<About />} />
      <Route path='/mail' element={<Mail />} />
      <Route path='/checkout' element={<Chekout />}/>
    </Routes>
  )
}

export default Pages