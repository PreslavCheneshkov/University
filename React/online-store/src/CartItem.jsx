import plusIcon from './assets/plus.png'
import minusIcon from './assets/minus.png'
import deleteIcon from './assets/delete.png'
import './CartItem.css'

function CartItem({item, cart, updateCart}) {
    function decreaseAmount() {
        changeAmount(-1);
    }

    function increaseAmount() {
        changeAmount(1);
    }

    function changeAmount(amount) {
        updateCart(cart.map(cartItem => {
            if (cartItem.name === item.name)
            {
                if (cartItem.count + amount >= 0) {
                    cartItem.count += amount;
                }
            }
            return cartItem;
        }));
    }

    function deleteItem() {
        updateCart(cart.filter(cartItem => {
            if (cartItem.name === item.name) {
                return false
            }
            return true;
        }));
    }

    return <>
                <h4>Име на артикул:</h4><p>{item.name}</p>
                <h4>Цена на артикул:</h4><p>{item.price}</p>
                <h4>Брой на артикул:</h4>
                <div className='cartItemAmount'>
                    <img onClick={decreaseAmount} className='cartItemIcon cartItemAmount' src={minusIcon} />
                    <p className='cartItemAmount' >{item.count}</p>
                    <img onClick={increaseAmount} className='cartItemIcon cartItemAmount' src={plusIcon} />
                    <img onClick={deleteItem} className='classItemIcon cartItemAmount' src={deleteIcon} />
                </div>
                <hr />
    </>
}

export default CartItem;