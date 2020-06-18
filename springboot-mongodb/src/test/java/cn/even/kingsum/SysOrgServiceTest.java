package cn.even.kingsum;

import cn.even.App;
import cn.even.kingsum.entity.Org;
import cn.even.kingsum.origin.entity.SysOrg;
import cn.even.kingsum.origin.service.SysOrgService;
import cn.even.kingsum.service.impl.OrgServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: SysOrgServiceTest
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 3:02 PM
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class SysOrgServiceTest {

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private OrgServiceImpl orgService;

    @Test
    public void testSelect(){
        List<SysOrg> sysOrgList = sysOrgService.selectAll();
        sysOrgList.forEach(System.out::println);
        List<Org> list=transfer(sysOrgList);

        System.out.println(list);
        orgService.saveBatch(list);
        Assert.assertNotNull(sysOrgList);
    }

    public List<Org> transfer(List<SysOrg> sysOrgList) {
        List<Org> list=new ArrayList<>();
        sysOrgList.forEach(sysOrg -> {
            Org org=new Org();
            org.setId(sysOrg.get_id());
            org.setOrgCode(sysOrg.getOrgCode());
            org.setOrgName(sysOrg.getOrgName());
            org.setProvId(sysOrg.getProvId());
            org.setCityId(sysOrg.getCityId());
            org.setAreaId(sysOrg.getAreaId());
            org.setParentId(sysOrg.getParentArr());
            org.setValid(false);
            if("1".equals(sysOrg.getIsVal())){
                org.setValid(true);
            }
            org.setOrgType(Integer.parseInt(sysOrg.getOrgType()));
            org.setLevel(Integer.parseInt(sysOrg.getLevel()));
            org.setCompanyFlag(false);
            if("1".equals(sysOrg.getCompflag())){
                org.setCompanyFlag(true);
            }
//            if()
            org.setShortName(sysOrg.getShortName());
            org.setMatchingOrg(sysOrg.getMatchingOrg());
            org.setRootOrgId(sysOrg.getRootOrgId());
            org.setFireRisk(sysOrg.getFireRisk());
            org.setAddress(sysOrg.getAddress());
            org.setSex(sysOrg.getSex());
            org.setAccountNum(sysOrg.getAccountNum());
            org.setTel(sysOrg.getTel());
            org.setEmail(sysOrg.getEmail());
            org.setLatitude(sysOrg.getLatitude());
            org.setLongitude(sysOrg.getLongitude());
            org.setMobilePhone(sysOrg.getMobilePhone());
            org.setOtherContact(sysOrg.getOtherContact());
            org.setSuperviseLevel(sysOrg.getSuperviseLevel());
            list.add(org);
        });

        return list;
    }

}
