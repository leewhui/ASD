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

public class editInfoTest
{
    private MongoCollection<Document> collection = null;
    private MongoClient mongoClient = null;
    private MongoDatabase db = null;
    private User user = null;

    @Before
    public void start()
    {
        mongoClient = new MongoClient(new MongoClientURI("mongodb+srv://wenhuili:lwh971213@cluster0.bgi8l.mongodb.net/ASD?retryWrites=true&w=majority"));
        db = mongoClient.getDatabase("ASD");
        collection = dbConnect.getMongoCollection("User");
    }

    @Test
    public void testGetCollection() throws Exception
    {
        collection = dbConnect.getMongoCollection("User");
    }

    @Test
    public void updateUser()
    {

        User user = new User();
        dbConnect.updateOneUser(user);
    }
}
