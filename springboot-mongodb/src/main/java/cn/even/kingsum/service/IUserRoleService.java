package cn.even.kingsum.service;

import cn.even.common.ResponseEntity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import cn.even.kingsum.entity.UserRole;
import cn.even.common.BaseService;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiangjingwei@yysoft.org.cn
 * @since 2020-06-15
 */
public interface IUserRoleService extends BaseService<UserRole> {

 /**
    * 分页查询实体列表
    * @param model 查询参数
    * @return 查询结果
    */
  <T extends UserRole> IPage<UserRole> list( T model);

      /**
      * 根据主键删除实体对象，返回值封装成ResponseEntity，若成功则会把要删除的主键计入返回的ResponseEntity
      *
      * @param id 主键
      * @return 删除是否成功
      */
      ResponseEntity removeModelById(String id);
}
