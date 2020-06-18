package cn.even.kingsum.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.web.bind.annotation.RestController;
import cn.even.common.BaseController;
import cn.even.common.ResponseEntity;
import cn.even.common.Facade;
import cn.even.kingsum.entity.FloorPartition;
/**
 * <p>
    * 建筑物 - 楼层 - 分区 前端控制器
    * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-06-15
 */
@RestController
@RequestMapping("/sys/floorPartition")
public class FloorPartitionController extends BaseController
    <Facade> {

  /**
   * 根据条件分页查询FloorPartition
   * @param model 实体对象
   * @return 查询列表
   */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public IPage<FloorPartition> list(@RequestBody FloorPartition model){
        //return facade.getIFloorPartitionService().list(model);
        return null;
    }

    /**
    * 根据主键查询单个对象
    * @param model 实体对象包含uuid
    * @return 成功或失败
    */
    @RequestMapping(value = "getById", method = RequestMethod.POST)
    public ResponseEntity getById(@RequestBody FloorPartition model) {
        //return facade.getIFloorPartitionService().getModelById(model.getUuid());
        return null;
    }

    /**
	 * 新增实体对象
	 *
     * @param model 实体对象
	 * @return 新增是否成功
	 */
    @RequestMapping(value="/save",method = RequestMethod.POST)
	public ResponseEntity save(@RequestBody FloorPartition model) {
		//return facade.getIFloorPartitionService().saveModel(model);
        return null;
	}

    /**
	 * 批量新增实体对象
	 *
     * @param modelList 实体对象列表
	 * @return 新增是否成功
	 */
	@RequestMapping(value="/saveBatch",method = RequestMethod.POST)
	public ResponseEntity saveBatch(@RequestBody List<FloorPartition> modelList) {
		//return facade.getIFloorPartitionService().saveModelBatch(modelList);
        return null;
	}

    /**
	 * 根据主键删除实体
	 *
     * @param uuid 实体携带主键
	 * @return 删除是否成功
	 */
	@RequestMapping(value="/removeById",method = RequestMethod.POST)
	public ResponseEntity removeById(@RequestBody FloorPartition uuid) {
		//return facade.getIFloorPartitionService().removeModelById(uuid);
        return null;
	}

     /**
	 * 根据主键列表删除实体
	 *
     * @param idList 实体主键
	 * @return 删除是否成功
	 */
	@RequestMapping(value="/removeByIdList",method = RequestMethod.POST)
	public ResponseEntity removeByIdList(@RequestBody List<FloorPartition> idList) {
        //return facade.getIFloorPartitionService().removeModelByIdList(idList,new FloorPartition());
        return null;
    }

    /**
    * 根据主键修改实体
    *
    * @param model 等待修改的对象
    * @return 修改是否成功
    */
    @RequestMapping(value="/updateById",method = RequestMethod.POST)
    public ResponseEntity updateModelById(@RequestBody FloorPartition model) {
        //return facade.getIFloorPartitionService().updateModelById(model);
        return null;
    }

    /**
    * 根据主键列表修改实体列表
    *
    * @param modelList 等待修改的对象列表
    * @return 修改是否成功
    */
    @RequestMapping(value="/updateByIdBatch",method = RequestMethod.POST)
    public ResponseEntity updateModelByIdBatch(@RequestBody List<FloorPartition> modelList) {
        //return facade.getIFloorPartitionService().updateModelByIdBatch(modelList,new FloorPartition());
        return null;
    }
}
