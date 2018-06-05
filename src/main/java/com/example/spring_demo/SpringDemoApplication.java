package com.example.spring_demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot-HelloWorld-Plus
 * DONE:
 * 日志系统 logback+self4j（配置还不是很完善）
 * 美化输出的JSON，使其带有缩进
 * 热重载 https://blog.csdn.net/com3294/article/details/79104513
 * HTTP response 的gzip压缩配置
 * lombok集成
 * TODO:
 * 一套完善的基础DAO/Service：(基本完成)
 * 增一个，增多个（两个版本:一个普通，一个Batch版）
 * 用Id查一个，用多个Id查多个
 * 查全部，查询全部+排序，查全部+分页（有可选的排序）
 * 条件查询，条件查询+排序，条件查询+分页（有可选的排序）
 * 条件查询模糊查询（排序,分页）
 * 通过id改属性，通过多个id改属性,通过条件查询改属性
 * 用Id删一个，用多个Id删除多个，全部删除，条件删除
 *
 * Spring Data JPA配置:
 * 使用lombok+接口的形式来构建VO
 * 应用并测试SpringData JPA对Web MVC的支持：支持Controller属性直接查询并注入
 * 自定义Repository的实现类，并实现自己需要的一些方法。
 * 审计功能的尝试使用
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
 * Spring Security
 * 权限验证
 * swagger2.9支持+Auth支持: 基本支持已经完成
 * Hibernate自动时间戳，updateAt createAt。该在java代码中设置，还是在数据库中就定义好？还是两者都要。
 * 精准浮点数的处理
 * WebSocket支持
 * 上传文件，下载文件的简单支持和接口
 * NoSQL的支持：Redis和Monogo
 * devtools配置学习（还有shell?）
 * 简单Excel数据读写
 * 用Dozer完成PO到VO的转换，DTO到PO的转换 http://www.hollischuang.com/archives/1613
 * 主页：简单地显示swagger文档页面地址
 */
@SpringBootApplication
//@EnableSwagger2
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringDemoApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}


