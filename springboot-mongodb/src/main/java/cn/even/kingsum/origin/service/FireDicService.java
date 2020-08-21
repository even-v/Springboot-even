package cn.even.kingsum.origin.service;

import cn.even.kingsum.origin.entity.SysOrg;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName: SysOrgService
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 2:48 PM
 * Description:
 */
@Service
@Slf4j
public class FireDicService {
    public final static String COLL_NAME = "fire_dic";

    @Autowired
    private MongoTemplate mongoTemplate;

    //测试方法
    /*
    public Document selectAll() {
        Document condition = new Document();//查询条件
        condition.put("dicKey", "patrolType");

        SysOrg org = new SysOrg();
        MongoCollection<Document> collection = mongoTemplate.getCollection(COLL_NAME);
        FindIterable<Document> documents = collection.find(condition);
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            Document document = iterator.next();
        }
        return null;
    }*/

    /**
     * 查询巡查设施类型
     * @return
     */
    public FindIterable<Document> selectPatrol() {
        Document condition = new Document();//查询条件
        condition.put("dicKey", "patrolType");

        MongoCollection<Document> collection = mongoTemplate.getCollection(COLL_NAME);
        return collection.find(condition);
    }

    /**
     * 查询监测实施类型
     * @return
     */
    public FindIterable<Document> selectMonitor() {
        Document condition = new Document();//查询条件
        condition.put("dicKey", "monitorType");

        MongoCollection<Document> collection = mongoTemplate.getCollection(COLL_NAME);
        return collection.find(condition);
    }

    /**
     * 查询消防电源监测设施类型
     * @return
     */
    public FindIterable<Document> selectPowerMonitor() {
        Document condition = new Document();//查询条件
        condition.put("dicKey", "powerMonitorType");

        MongoCollection<Document> collection = mongoTemplate.getCollection(COLL_NAME);
        return collection.find(condition);
    }
}
