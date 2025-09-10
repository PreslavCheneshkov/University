import Link from "next/link";
import type Game from "./Types/Game";

export default async function Home() {

  const gamesResp =  await fetch("http://localhost:3001/games", { cache: 'no-store' });
  const games = await gamesResp.json()

  return (
    <>
      <h1>Welcome to the Game Catalogue!</h1>
      <h2>Your games:</h2>
      <div className="your-games-container">
        {games.map((game: Game) => 
          <Link href={"games/" + game.id} key={game.id}>{game.name}</Link>
        )}
      </div>
    </>
  );
}
