package cn.even.mongodb.demo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * FileName: Demo1
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     5/25/2020 10:07 AM
 * Description: 测试链接mongodb数据库
 */
public class Demo1 {
    public static void main(String[] args) {
        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "localhost" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("demo");
            System.out.println("Connect to database successfully");
            mongoDatabase.createCollection("test");
            MongoCollection<Document> test = mongoDatabase.getCollection("test");
        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
