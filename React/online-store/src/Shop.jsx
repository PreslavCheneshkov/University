import Item from './Item.jsx'
import imgWheel16 from './assets/wheel16.webp'
import imgWheel17 from './assets/wheel17.jpg'
import imgTire16 from './assets/continental16.jpg'
import imgTire17 from './assets/michellin17.webp'

function Shop({cart, updateCart}) {

    const availableItems = [
        {
            id: 0,
            name: "Джанти 16 цола",
            price: 289.99,
            imageURL: imgWheel16
        },
        {
            id: 1,
            name: "Джанти 17 цола",
            price: 379.99,
            imageURL: imgWheel17
        },
        {
            id: 2,
            name: "Гуми Continental 205/55/16",
            price: 289.99,
            imageURL: imgTire16
        },
        {
            id: 3,
            name: "Гуми Michellin 225/45/17",
            price: 289.99,
            imageURL: imgTire17
        }
    ];
    
    return <>
        <h2>Налични артикули:</h2>
        {availableItems.map(item => <Item key={item.id} item={item} cart={cart} updateCart={updateCart} />)}

        <hr />
        {console.log(cart)}
        <h2>Брой артикули в количката: {cart.length}</h2>
    </>
}

export default Shop;