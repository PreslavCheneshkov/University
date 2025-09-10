import type Game from './../../Types/Game';

export default async function Game({params}:PageProps<'/games/[id]'>) {

    const gameResponse = await fetch(`http://localhost:3001/games/${(await params).id}`);
    const game = await gameResponse.json();

    return (
        <div className="gameContainer">
            <h4>Title: {game.name}</h4>
            <h4>Category: {game.category}</h4>
            <h4>Year: {game.year}</h4>
        </div>
    )
}