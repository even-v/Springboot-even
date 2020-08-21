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
import cn.even.kingsum.entity.FireModule;
/**
 * <p>
    * 系统类型 前端控制器
    * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-07-07
 */
@RestController
@RequestMapping("/sys/fireModule")
public class FireModuleController extends BaseController
    <Facade> {

  /**
   * 根据条件分页查询FireModule
   * @param model 实体对象
   * @return 查询列表
   */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public IPage<FireModule> list(@RequestBody FireModule model){
        //return facade.getIFireModuleService().list(model);
        return null;
    }

    /**
    * 根据主键查询单个对象
    * @param model 实体对象包含uuid
    * @return 成功或失败
    */
    @RequestMapping(value = "getById", method = RequestMethod.POST)
    public ResponseEntity getById(@RequestBody FireModule model) {
        //return facade.getIFireModuleService().getModelById(model.getUuid());
        return null;
    }

    /**
	 * 新增实体对象
	 *
     * @param model 实体对象
	 * @return 新增是否成功
	 */
    @RequestMapping(value="/save",method = RequestMethod.POST)
	public ResponseEntity save(@RequestBody FireModule model) {
		//return facade.getIFireModuleService().saveModel(model);
        return null;
	}

    /**
	 * 批量新增实体对象
	 *
     * @param modelList 实体对象列表
	 * @return 新增是否成功
	 */
	@RequestMapping(value="/saveBatch",method = RequestMethod.POST)
	public ResponseEntity saveBatch(@RequestBody List<FireModule> modelList) {
		//return facade.getIFireModuleService().saveModelBatch(modelList);
        return null;
	}

    /**
	 * 根据主键删除实体
	 *
     * @param uuid 实体携带主键
	 * @return 删除是否成功
	 */
	@RequestMapping(value="/removeById",method = RequestMethod.POST)
	public ResponseEntity removeById(@RequestBody FireModule uuid) {
		//return facade.getIFireModuleService().removeModelById(uuid);
        return null;
	}

     /**
	 * 根据主键列表删除实体
	 *
     * @param idList 实体主键
	 * @return 删除是否成功
	 */
	@RequestMapping(value="/removeByIdList",method = RequestMethod.POST)
	public ResponseEntity removeByIdList(@RequestBody List<FireModule> idList) {
        //return facade.getIFireModuleService().removeModelByIdList(idList,new FireModule());
        return null;
    }

    /**
    * 根据主键修改实体
    *
    * @param model 等待修改的对象
    * @return 修改是否成功
    */
    @RequestMapping(value="/updateById",method = RequestMethod.POST)
    public ResponseEntity updateModelById(@RequestBody FireModule model) {
        //return facade.getIFireModuleService().updateModelById(model);
        return null;
    }

    /**
    * 根据主键列表修改实体列表
    *
    * @param modelList 等待修改的对象列表
    * @return 修改是否成功
    */
    @RequestMapping(value="/updateByIdBatch",method = RequestMethod.POST)
    public ResponseEntity updateModelByIdBatch(@RequestBody List<FireModule> modelList) {
        //return facade.getIFireModuleService().updateModelByIdBatch(modelList,new FireModule());
        return null;
    }
}
