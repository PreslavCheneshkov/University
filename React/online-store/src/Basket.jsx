import CartItem from './CartItem'

function Basket({cart, updateCart}) {
    console.log(cart);  
    return <>
        <h2>Вашата кошница:</h2>
        {cart.map(ci => <CartItem key={ci.id} item={ci} cart={cart} updateCart={updateCart} />)}
    </>
}

export default Basket;