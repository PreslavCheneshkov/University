import { Link } from "react-router-dom";
import './Menu.css'

function Menu() {
    return <>
            <Link to="/">Магазин</Link>
            <Link to="/basket">Количка</Link>
        </>
}

export default Menu;