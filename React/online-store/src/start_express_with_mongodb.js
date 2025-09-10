import express from 'express';
import cors from 'cors';
import { getStoreItems, getCheapStoreItems } from './mongodb.js';

var app = express();    
app.use(express.json());

app.use(cors());        
app.listen(3001);       

app.get('/tireshop', async function(req, res) {
    let items = await getStoreItems();
    console.log(items);
    res.setHeader('Content-Type', 'application/json');
    res.send(items);
});

app.get('/tireshop/cheap', async function(req, res) {
    let items = await getCheapStoreItems();
    console.log(items);
    res.setHeader('Content-Type', 'application/json');
    res.send(items);
});