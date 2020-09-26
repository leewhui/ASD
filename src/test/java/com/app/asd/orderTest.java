import com.app.asd.Model.*;
import com.app.asd.Utils.dbConnect;
import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

public class orderTest {
    private MongoCollection<Document> collection = null;
    private MongoClient mongoClient = null;
    private MongoDatabase db = null;

    @Before
    public void start()
    {
        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
        db = mongoClient.getDatabase("ASD");
        collection = dbConnect.getMongoCollection("Order");
    }

    @Test
    public void testGetCollection() throws Exception
    {
        collection = dbConnect.getMongoCollection("Order");
    }

    @Test
    public void testInsertOrder()
    {
        Document document = new Document("orderID", "100001");
        document.append("orderComment","junit Test");
        dbConnect.insertOneDocument("Order", document);
    }
    
    @Test
    public void testGetOrder()
    {
        BasicDBObject obj = new BasicDBObject("userEmail", "test1@gmail.com");
        MongoCursor<Document> resultList = dbConnect.queryCursor("Order", obj);

        System.out.println(resultList);
    }
}
