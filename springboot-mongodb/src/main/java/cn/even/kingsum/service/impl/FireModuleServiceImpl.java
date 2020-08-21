package cn.even.kingsum.service.impl;

import cn.even.common.ResponseEntity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.even.kingsum.entity.FireModule;
import cn.even.kingsum.mapper.FireModuleMapper;
import cn.even.kingsum.service.IFireModuleService;
import cn.even.common.BaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * <p>
 * 系统类型 服务实现类
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-07-07
 */

@Service
public class FireModuleServiceImpl extends BaseServiceImpl<FireModuleMapper,FireModule> implements IFireModuleService {

    /**
    * 分页查询实体列表
    * @param model 查询参数
    * @return 查询结果
    */
    @Override
    public <T extends FireModule> IPage<FireModule> list( T model){
        IPage<FireModule> page = new Page<>();
        QueryWrapper<FireModule> wrapper = new QueryWrapper<>();
        setParam(wrapper,model);
        return page(page,wrapper);
    }

    /**
    * 根据主键删除实体对象，返回值封装成ResponseEntity，若成功则会把要删除的主键计入返回的ResponseEntity
    *
    * @param id 主键
    * @return 删除是否成功
    */
    @Override
    public ResponseEntity removeModelById(String id){
        FireModule model=new FireModule();
       // model.setDeleted(true);
        return removeModelById(model);
    }

    private <T extends FireModule> void setParam(QueryWrapper<FireModule> wrapper, T model) {
        if (model == null) {
        return;
        }
    }
}
