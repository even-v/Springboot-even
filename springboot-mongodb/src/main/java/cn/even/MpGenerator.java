package cn.even;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.SqlServerTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * <p>
 * 代码生成器
 * </p>
 */
public class MpGenerator {

    /**
     * <p>
     * 生成演示
     * </p>
     */
    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Veloctiy
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        final GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("jiangjingwei@yysoft.org.cn");
//        gc.setOutputDir("D:/workspace/ideaWorkspace/AndonPlus/src/main/java");
        gc.setOutputDir("C:\\Users\\even\\Desktop\\temp\\src\\main\\java");
        gc.setFileOverride(true);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(false);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setOpen(false);
        //gc.setSwagger2(true);//开启Swagger2
        gc.setDateType(DateType.ONLY_DATE);

        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                //将数据库中decimal转换成BigDecimal
                if (fieldType.toLowerCase().contains("decimal")) {
                    return DbColumnType.BIG_DECIMAL;
                }

                //将数据库中datetime转换成date
                if(fieldType.toLowerCase().contains("datetime")){
                    return DbColumnType.DATE;
                }
                return super.processTypeConvert(gc, fieldType);
            }
        });
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/kingsum?characterEncoding=UTF-8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();

        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略


        strategy.setTablePrefix(new String[] { "socialunit_" });// 此处可以修改为您的表前缀
//        String [] tables={ "iot_device", "iot_device_buildings","iot_device_collect","iot_park","iot_park_principal"};
//        String [] tables={"org_platform"};
        String [] tables={ "socialunit_building", "socialunit_floor","socialunit_floor_partition","socialunit_floor_principal"};
//        String [] tables={ "sys_employee", "sys_menu","sys_modular","sys_org","sys_role","sys_role_interface","sys_role_menu","sys_user","sys_user_role","sys_version"};

        strategy.setInclude(tables); // 需要生成的表

        // 自定义实体父类
        strategy.setSuperEntityClass("cn.even.common.BaseEntity");
        // 自定义实体，公共字段
        strategy.setSuperEntityColumns(
                new String[]{"id"});
        // 自定义 mapper 父类
        //strategy.setSuperMapperClass("com.baomidou.mybatisplus.core.mapper.BaseMapper");

        // 自定义 service 父类
        strategy.setSuperServiceClass("cn.even.common.BaseService");
        // 自定义 service 实现类父类
        strategy.setSuperServiceImplClass("cn.even.common.BaseServiceImpl");
        // 自定义 controller 父类
        strategy.setSuperControllerClass("cn.even.common.BaseController");
        //使用restController
        strategy.setRestControllerStyle(true);

        //使用lombok
        strategy.setEntityLombokModel(true);


        //使用字段注解
        strategy.setEntityTableFieldAnnotationEnable(true);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.even.kingsum");

        mpg.setPackageInfo(pc);

        // 执行生成
        mpg.execute();
    }

}