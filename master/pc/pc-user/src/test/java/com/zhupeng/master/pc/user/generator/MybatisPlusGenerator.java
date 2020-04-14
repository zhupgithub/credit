package com.zhupeng.master.pc.user.generator;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MybatisPlusGenerator {
    private static String basePath = "";
    private static String mapperPath = "";

    private static final String AUTHOR = "zhupeng";
    private static final String PACKAGENAME = "com.zhupeng.master.pc.user";

    private static final String DATABASE = "credit";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/" + DATABASE + "?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2b8&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String DRIVERNAME = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";


    public static void main(String[] args) {
        generate();
    }

    private static void generate() {

        // 全局配置
        GlobalConfig globalConfig = initGlobalConfig();
        // 数据源配置
        DataSourceConfig dataSourceConfig = initDataSourceConfig();
        // 包配置
        PackageConfig packageConfig = packageConfig();
        // 模板引擎配置
        FreemarkerTemplateEngine templateEngine = new FreemarkerTemplateEngine();

        //每一个entity都需要单独设置InjectionConfig, StrategyConfig和TemplateConfig
//        Map<String, String> names = new JdbcRepository().getEntityNames(tablePrefix);

        /*
         * TODO 数据库表手工指定
         */
        Map<String, String> tableInfo = new HashMap<String, String>();
        String table = "pc_role";
        String bean = "pcRole";
        tableInfo.put(table, bean);

        if (CollectionUtils.isEmpty(tableInfo)) {
            return;
        }

        for (String tableName : tableInfo.keySet()) {
            // 代码生成器
            AutoGenerator autoGenerator = new AutoGenerator();
            autoGenerator.setGlobalConfig(globalConfig);
            autoGenerator.setDataSource(dataSourceConfig);
            autoGenerator.setPackageInfo(packageConfig);
            autoGenerator.setTemplateEngine(templateEngine);

            // 自定义配置
            InjectionConfig cfg = initInjectionConfig(PACKAGENAME);
            autoGenerator.setCfg(cfg);

            // 策略配置
            StrategyConfig strategy = initStrategyConfig(tableName, "");
            autoGenerator.setStrategy(strategy);

            // 模板配置
            // mapper文件
            String mapperFile = mapperPath
                    + "/" + tableInfo.get(tableName) + "Mapper" + StringPool.DOT_JAVA;

            TemplateConfig templateConfig = initTemplateConfig(mapperFile);
            autoGenerator.setTemplate(templateConfig);

            //开始执行
            autoGenerator.execute();
        }
    }

    /**
     *  包配置
     * @return
     */
    private static PackageConfig packageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        //pc.setModuleName(scanner("模块名"));
        packageConfig.setParent(PACKAGENAME);
        packageConfig.setEntity("entity");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        return packageConfig;
    }

    /**
     * 覆盖Entity以及xml
     * @param mapperFile
     * @return
     */
    private static TemplateConfig initTemplateConfig(String mapperFile) {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setXml(null);
        //如果当前Entity已经存在,那么仅仅覆盖Entity
        File file = new File(mapperFile);
        if (file.exists()) {
            templateConfig.setController(null);
            templateConfig.setMapper(null);
            templateConfig.setService(null);
            templateConfig.setServiceImpl(null);
            templateConfig.setEntityKt(null);
        }

        return templateConfig;
    }

    /**
     * 策略配置
     * @param tableName
     * @param tablePrefix
     * @return
     */
    private static StrategyConfig initStrategyConfig(String tableName, String tablePrefix) {
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setEntityLombokModel(true);
        strategy.setTablePrefix(tablePrefix);
        strategy.setInclude(tableName);
        strategy.setRestControllerStyle(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        return strategy;
    }

    /**
     * 自定义配置
     * @param packageName
     * @return
     */
    private static InjectionConfig initInjectionConfig(String packageName) {
        InjectionConfig injectionConfig = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        List<FileOutConfig> focList = new ArrayList<>();
        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                //自定义输入文件名称
                return mapperPath
                        + "/xml/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        injectionConfig.setFileOutConfigList(focList);

        return injectionConfig;
    }

    /***
     * 数据源配置
     * @return
     */
    private static DataSourceConfig initDataSourceConfig() {
        return new DataSourceConfig()
                .setUrl(URL)
                .setDriverName(DRIVERNAME)
                .setUsername(USERNAME)
                .setPassword(PASSWORD);
    }

    /**
     * 全局配置
     * @return
     */
    private static GlobalConfig initGlobalConfig() {
        GlobalConfig globalConfig = new GlobalConfig();

        String classPath = MybatisPlusGenerator.class.getResource("").getPath();
        String codePath = classPath.substring(0, classPath.indexOf("/target"));

        basePath = codePath + "/src/main/java";

        mapperPath = basePath + "/" + PACKAGENAME.replace(".", "/") + "/mapper";

        globalConfig.setOutputDir(basePath);
        globalConfig.setAuthor(AUTHOR);
        globalConfig.setOpen(true);
        //// service 命名方式
        globalConfig.setServiceName("%sService");
        // service impl 命名方式
        globalConfig.setServiceImplName("%sServiceImpl");
        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        globalConfig.setMapperName("%sMapper");
        globalConfig.setXmlName("%sMapper");

        globalConfig.setFileOverride(false);// 是否覆盖同名文件，默认是false
        globalConfig.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        globalConfig.setEnableCache(false);// XML 二级缓存
        globalConfig.setBaseResultMap(true);// XML ResultMap
        globalConfig.setBaseColumnList(true);// XML columList

        return globalConfig;
    }






    public static class JdbcRepository {
        private static Pattern linePattern = Pattern.compile("_(\\w)");
        private JdbcOperations jdbcOperations;

        public JdbcRepository() {
            DataSource dataSource = DataSourceBuilder.create()
                    //如果不指定类型，那么默认使用连接池，会存在连接不能回收而最终被耗尽的问题
                    .type(DriverManagerDataSource.class)
                    .driverClassName(DRIVERNAME)
                    .url(URL)
                    .username(USERNAME)
                    .password(PASSWORD)
                    .build();
            this.jdbcOperations = new JdbcTemplate(dataSource);
        }

        /**
         * 获取所有实体类的名字,实体类由数据库表名转换而来.
         * 例如: 表前缀为auth,完整表名为auth_first_second,那么entity则为FirstSecond
         * @param tablePrefixArray 数据库表名前缀,可能为空
         * @return
         */
        public Map<String, String> getEntityNames(String... tablePrefixArray) {
            //该sql语句目前支持mysql
            String sql = "SELECT table_name FROM INFORMATION_SCHEMA.TABLES WHERE table_schema = '" + DATABASE + "'";
            if (tablePrefixArray != null && tablePrefixArray.length != 0) {
                sql += " and (";
                for (String prefix : tablePrefixArray) {
                    sql += " or table_name like '" + prefix + "_%'";
                }
                sql += ")";
            }
            sql = sql.replaceFirst("or", "");
            List<String> tableNames = jdbcOperations.query(sql, SingleColumnRowMapper.newInstance(String.class));
            if (CollectionUtils.isEmpty(tableNames)) {
                return new HashMap<>();
            }


            Map<String, String> result = new HashMap<>();
            tableNames.forEach(
                    tableName -> {
                        String entityName = underlineToCamel(tableName);
                        if (tablePrefixArray != null && tablePrefixArray.length != 0) {
                            for (String prefix : tablePrefixArray) {
                                //如果有前缀,需要去掉前缀
                                if (tableName.startsWith(prefix)) {
                                    String tableNameRemovePrefix = tableName.substring((prefix + "_").length());
                                    entityName = underlineToCamel(tableNameRemovePrefix);
                                }
                            }
                        }

                        result.put(tableName, entityName);
                    }
            );


            return result;
        }


        /**
         * 下划线转驼峰
         *
         * @param str
         * @return
         */
        private static String underlineToCamel(String str) {
            if (null == str || "".equals(str)) {
                return str;
            }
            str = str.toLowerCase();
            Matcher matcher = linePattern.matcher(str);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
            }
            matcher.appendTail(sb);

            str = sb.toString();
            str = str.substring(0, 1).toUpperCase() + str.substring(1);

            return str;
        }

    }
}
