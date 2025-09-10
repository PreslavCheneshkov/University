import Item from './Item.jsx'
import imgWheel16 from './assets/wheel16.webp'
import imgWheel17 from './assets/wheel17.jpg'
import imgTire16 from './assets/continental16.jpg'
import imgTire17 from './assets/michellin17.webp'
import { useEffect, useState } from 'react'

function Shop({cart, updateCart}) {

    let [availableItems, setAvailableItems] = useState([]);

    async function getItems() {
        const itemListJSON = await fetch('http://localhost:3001/tireshop/cheap');
        console.log(itemListJSON);
        const itemList = await itemListJSON.json();
        setAvailableItems(itemList);
    }

    useEffect(() => {
        getItems();
    }, []);
    
    return <>
        <h2>Налични артикули:</h2>
        {availableItems.map(item => <Item key={item.id} item={item} cart={cart} updateCart={updateCart} />)}

        <hr />
        <h2>Брой артикули в количката: {cart.length}</h2>
    </>
}

export default Shop;