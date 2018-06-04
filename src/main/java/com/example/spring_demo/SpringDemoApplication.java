package com.example.spring_demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * SpringBoot-HelloWorld-Plus
 * DONE:
 * 日志系统 logback+self4j（配置还不是很完善）
 * Spring JPA配置
 * 美化输出的JSON，使其带有缩进
 * 热重载 https://blog.csdn.net/com3294/article/details/79104513
 * TODO:
 * 一套完善的基础DAO，Service，controller：
 * 查全部，查一个，条件查询，条件查询并分页（有可选的排序）
 * 增一个，增多个（两个版本？一个普通，一个Batch版？）
 * 通过id改一部分属性，通过条件查询改一部分属性
 * 删一个，全部删除，条件删除
 *
 * 一套REST ful的Controller
 * 完备的表单数据验证器，
 * 数据格式工具formatter
 *  * 日期格式处理：JSON转换中的格式规定，接受日期参数的日期约束和格式化
 *  * 日期类型：Java8的LocalDateTime？？
 *  * sql中的日期类型选什么？timestamp还是datetime
 * 全局异常处理:格式化的异常信息
 * 复杂service或dao的事务处理
 * 缓存
 * 权限验证
 * swagger2.9支持+Auth支持: 基本支持已经完成
 * Hibernate自动时间戳，updateAt createAt。该在java代码中设置，还是在数据库中就定义好？还是两者都要。
 * 精准浮点数的处理
 * WebSocket支持
 * request response 的gzip压缩配置
 * 上传文件，下载文件的简单支持和接口
 * NoSQL的支持：Redis和Monogo
 * devtools配置学习（还有shell?）
 */
@SpringBootApplication
@EnableSwagger2
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}


