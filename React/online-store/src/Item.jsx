import './Item.css'

function Item({item, cart, updateCart}) {

    let currentItemIndex = -1;
    function addToCart() {
        for (let i = 0; i < cart.length; i++) {
            if (cart[i].name === item.name) {
                currentItemIndex = i;
                break;
            }
        }        

        if (currentItemIndex > -1) {
            cart[currentItemIndex].count++;
            updateCart(cart);
        } else {
            updateCart([...cart, {...item, count: 1}])
        }
    }    
    return <div key={item.id}>
        <h4>Име на артикула: {item.name}</h4>
        <h4>Цена на артикула: {item.price}</h4>
        <img src={`assets\\${item.imageURL}`} />
        <button onClick={addToCart}>Добави в количката</button>
    </div>
}

export default Item;