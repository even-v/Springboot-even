package cn.even.kingsum;

import cn.even.App;
import cn.even.kingsum.entity.FireFacility;
import cn.even.kingsum.entity.FireModule;
import cn.even.kingsum.origin.service.FireDicService;
import cn.even.kingsum.service.IFireFacilityService;
import cn.even.kingsum.service.IFireModuleService;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * FileName: FileDicServiceTest
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 3:02 PM
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class FileDicServiceTest {

    @Resource
    private FireDicService fireDicService;

    @Resource
    private IFireFacilityService iFireFacilityService;

    @Resource
    private IFireModuleService iFireModuleService;


    @Test
    public void test1() {

//        FindIterable<Document> findIterable = fireDicService.selectPatrol();
//        FindIterable<Document> findIterable = fireDicService.selectMonitor();
        FindIterable<Document> findIterable = fireDicService.selectPowerMonitor();
        MongoCursor<Document> iterator = findIterable.iterator();

        List<FireModule> fireModuleList = new ArrayList<>();
        List<FireFacility> fireFacilityList=new ArrayList<>();

        while (iterator.hasNext()) {
            Document document = iterator.next();

            List<Document> son = (List<Document>) document.get("childs");
            son.forEach(doc -> {
                FireModule fireModule = new FireModule();
                fireModule.setId(UUID.randomUUID().toString());
                fireModule.setDeleted(false);
                fireModule.setCreateTime(document.getObjectId("_id").getDate());
                fireModule.setName(document.getString("dicName"));
                fireModule.setRemark(document.getString("remark"));
                fireModule.setModuleName(doc.getString("val"));
                fireModule.setModuleRemark(doc.getString("jinganSname"));
                fireModule.setSequence(Integer.parseInt(doc.getString("key")));
                fireModuleList.add(fireModule);

                List<Document> grandson=(List<Document>)doc.get("childs");
                grandson.forEach(d->{
                    FireFacility fireFacility=new FireFacility();
                    fireFacility.setCreateTime(document.getObjectId("_id").getDate());
                    fireFacility.setDeleted(false);
                    fireFacility.setModuleId(fireModule.getId());
                    fireFacility.setModuleName(fireModule.getModuleName());
                    fireFacility.setModuleRemark(fireModule.getModuleRemark());
                    fireFacility.setName(d.getString("val"));
                    fireFacility.setRemark(d.getString("remark"));
                    fireFacility.setSequence(Integer.parseInt(d.getString("key")));
                    fireFacility.setType(document.getString("dicName"));
                    fireFacility.setId(UUID.randomUUID().toString());
                    fireFacilityList.add(fireFacility);
                });
            });

            iFireFacilityService.saveModelBatch(fireFacilityList);
            iFireModuleService.saveModelBatch(fireModuleList);


        }
    }
}
