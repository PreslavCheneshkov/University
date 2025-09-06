import { useEffect, useState } from 'react'
import './App.css'
import Shop from './Shop.jsx'
import Menu from './Menu.jsx'
import Basket from './Basket.jsx'
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  const [cart, updateCart] = useState([]);

  return (
    <>
    <BrowserRouter>
      <Menu />
      <Routes>
        <Route path="/" element={<Shop cart={cart} updateCart={updateCart} />} />
        <Route path="/basket" element={ <Basket cart={cart} updateCart={updateCart} />} />
      </Routes>
    </BrowserRouter>
    </>
  )
}

export default App
