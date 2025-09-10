export default function Add() {
    return (
        <>
            <h4>Add a new game:</h4>
            <form>
                <label>Name:</label><input type='text' />
                <label>Category:</label><input type='text' />
                <label>Year:</label><input type='number' />

            </form>
        </>
    );
}