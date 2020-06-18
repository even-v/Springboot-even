package cn.even.kingsum.origin.service;

import cn.even.kingsum.origin.entity.SysOrg;
import lombok.extern.slf4j.Slf4j;
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
public class SysOrgService {
     @Autowired
     private MongoTemplate mongoTemplate;

     public List<SysOrg> selectAll(){
         SysOrg org=new SysOrg();
         List<SysOrg> orgList = mongoTemplate.findAll(SysOrg.class, org.collName);
         log.info(orgList.toString());
         return orgList;
     }


}
