package cn.even.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;
import java.util.*;

/**
 * FileName: BaseServiceImpl
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 10:38 AM
 * Description:
 */
public class BaseServiceImpl<Mapper extends BaseMapper<M>, M extends BaseEntity<?>> extends ServiceImpl<Mapper, M> implements BaseService<M> {
    @Autowired
    protected Mapper baseMapper;

    public BaseServiceImpl() {
    }

    public Mapper getBaseMapper() {
        return this.baseMapper;
    }

    public ResponseEntity saveModel(M model) {
        if (model == null) {
            return Result.failure(MessageConstants.DATA_IS_NULL);
        } else {
            this.initModel(model);
            boolean flag = this.save(model);
            return flag ? Result.success(model) : Result.failure(MessageConstants.SQL_EXCEPTION);
        }
    }

    public ResponseEntity saveOrUpdateModel(M model) {
        if (model == null) {
            return Result.failure(MessageConstants.DATA_IS_NULL);
        } else {
            this.initModel(model);
            boolean flag = this.saveOrUpdate(model);
            return flag ? Result.success(model) : Result.failure(MessageConstants.SQL_EXCEPTION);
        }
    }

    public ResponseEntity saveModelBatch(Collection<M> modelList) {
        if (modelList != null && modelList.size() != 0) {
            modelList.forEach(this::initModel);
            boolean flag = this.saveBatch(modelList, 100);
            return flag ? Result.success() : Result.failure(MessageConstants.SQL_EXCEPTION);
        } else {
            return Result.failure(MessageConstants.DATA_IS_NULL);
        }
    }

    public ResponseEntity saveOrUpdateModelBatch(Collection<M> modelList) {
        if (modelList != null && modelList.size() != 0) {
            modelList.forEach(this::initModel);
            boolean flag = this.saveOrUpdateBatch(modelList, 100);
            return flag ? Result.success() : Result.failure(MessageConstants.SQL_EXCEPTION);
        } else {
            return Result.failure(MessageConstants.DATA_IS_NULL);
        }
    }

    public ResponseEntity removeModelById(String id) {
        if (id == null) {
            return Result.failure(MessageConstants.DATA_IS_NULL);
        } else {
            boolean flag = this.removeById(id);
            return flag ? Result.success(id) : Result.failure(MessageConstants.SQL_EXCEPTION);
        }
    }

    public ResponseEntity removeModelById(M m) {
        removeById(m);
        return null;
    }

    public ResponseEntity removeModelByIdList(List<M> modelList, M model) {
        return null;
    }

    public ResponseEntity updateModelById(M model) {
        updateById(model);
        return null;
    }

    public ResponseEntity updateModelByIdBatch(List<M> idList, M model) {
        return null;
    }

    public ResponseEntity updateModelBatch(M model, Wrapper<M> wrapper) {
        if (model == null) {
            return Result.failure(MessageConstants.DATA_IS_NULL);
        } else {
            boolean flag = this.update(model, wrapper);
            return flag ? Result.success(model) : Result.failure(MessageConstants.SQL_EXCEPTION);
        }
    }

    public ResponseEntity getModelById(String id) {
        if (StringUtil.isEmpty(id)) {
            return Result.failure(MessageConstants.PARAM_IS_NULL);
        } else {
            M m = this.getById(id);
            return m == null ? Result.failure(MessageConstants.DATA_IS_NULL) : Result.success(m);
        }
    }

    public List<M> list() {
        QueryWrapper<M> wrapper = new QueryWrapper();
        this.initCondition(wrapper);
        return super.list(wrapper);
    }


    protected <T extends BaseEntity> void initModel(T model) {
        Date now = new Date();
        model.setId(model.getId() != null ? model.getId() : UUID.randomUUID().toString());
    }

    protected void initCondition(QueryWrapper<? extends BaseEntity> wrapper) {
        wrapper.eq("deleted", false);
        wrapper.eq("locked", false);
        wrapper.eq("available", true);
    }

    protected void initCondition(UpdateWrapper<? extends BaseEntity> wrapper) {
        wrapper.eq("deleted", false);
        wrapper.eq("locked", false);
        wrapper.eq("available", true);
    }
}
