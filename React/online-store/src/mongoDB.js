import {MongoClient} from 'mongodb';

export async function getStoreItems() {
    let uri = "mongodb://localhost:27017";
    let client = new MongoClient(uri);

    try {
        const database = client.db('mydatabase');

        const items =  database.collection('tireshop')
        const query = { price: {
            $gte: 0
        }}
        const result = await items.find(query).toArray();
        console.log(result);
        return result;
    }
    finally {
        client.close();
    }
}

export async function getCheapStoreItems() {
    let uri = "mongodb://localhost:27017";
    let client = new MongoClient(uri);

    try {
        const database = client.db('mydatabase');

        const items =  database.collection('tireshop')
        const query = { price: {
            $gte: 0,
            $lt: 300
        }}
        const result = await items.find(query).toArray();
        console.log(result);
        return result;
    }
    finally {
        client.close();
    }
}
