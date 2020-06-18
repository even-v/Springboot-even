package cn.even.common;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.InputStream;
import java.util.Collection;
import java.util.List;

/**
 *
 * @param <M>
 */
public interface BaseService<M> extends IService<M> {
    ResponseEntity saveModel(M model);

    ResponseEntity saveOrUpdateModel(M model);

    ResponseEntity saveModelBatch(Collection<M> modelList);

    ResponseEntity saveOrUpdateModelBatch(Collection<M> modelList);

    ResponseEntity removeModelById(String id);

    ResponseEntity removeModelById(M m);

    ResponseEntity removeModelByIdList(List<M> modelList, M model);

    ResponseEntity updateModelById(M model);

    ResponseEntity updateModelByIdBatch(List<M> idList, M model);

    ResponseEntity updateModelBatch(M model, Wrapper<M> wrapper);

    ResponseEntity getModelById(String id);

    //ResponseEntity importHandler(Class<M> clz, InputStream input);
}