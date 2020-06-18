package cn.even.kingsum.service.impl;

import cn.even.common.ResponseEntity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.even.kingsum.entity.Version;
import cn.even.kingsum.mapper.VersionMapper;
import cn.even.kingsum.service.IVersionService;
import cn.even.common.BaseServiceImpl;
import org.springframework.stereotype.Service;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-06-15
 */

@Service
public class VersionServiceImpl extends BaseServiceImpl<VersionMapper,Version> implements IVersionService {

    /**
    * 分页查询实体列表
    * @param model 查询参数
    * @return 查询结果
    */
    @Override
    public <T extends Version> IPage<Version> list( T model){
        IPage<Version> page = new Page<>(1,1);
        QueryWrapper<Version> wrapper = new QueryWrapper<>();
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
        Version model=new Version();
       // model.setDeleted(true);
        return removeModelById(model);
    }

    private <T extends Version> void setParam(QueryWrapper<Version> wrapper, T model) {
        if (model == null) {
        return;
        }
    }
}
