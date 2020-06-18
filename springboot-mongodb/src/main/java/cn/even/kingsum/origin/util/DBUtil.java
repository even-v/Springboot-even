package cn.even.kingsum.origin.util;
import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndUpdateOptions;

/**
 * MongoDB util inited by spring ioc container,and destroyed by container close
 * invoking destroy method
 * 
 * @author ruijf
 * 
 */
public class DBUtil {
	// private Logger logger = Logger.getLogger(DBUtil.class);
	private String uri;
	private MongoClientURI mongoURI; 
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public MongoClientURI getMongoURI() {
		return mongoURI;
	}

	public void setMongoURI(MongoClientURI mongoURI) {
		this.mongoURI = mongoURI;
	}

	public void init(){
		mongoURI = new MongoClientURI(uri);
		mongoClient = new MongoClient(mongoURI);
		database = mongoClient.getDatabase(mongoURI.getDatabase());
	}

	public void destroy() {
		if (mongoClient != null) {
			/*
			 * if (logger.isDebugEnabled()) {
			 * logger.debug("closing the db collection...closed"); }
			 */
			mongoClient.close();
		}
	}

	public MongoCollection<Document> getColl(String name) {
		return database.getCollection(name);
	}
	

	public int nextValue(String counterName) {
		Document filter = new Document("name", counterName);
		Document fields = new Document("value", true);
		Document update = new Document("$inc", new Document("value", 1));
		
		FindOneAndUpdateOptions options = new FindOneAndUpdateOptions()
			.projection(fields)
			.upsert(true);
		Document newObj = database.getCollection("counter").findOneAndUpdate(filter, update,options);
		return newObj.getInteger("value");
	}
	
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

}
