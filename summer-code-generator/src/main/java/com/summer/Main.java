package com.summer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import java.io.PrintWriter;

public class Main {
    public static class SummerSecurityProviderApplication {

        public static void main(String[] args) {
            // 创建引擎
            VelocityEngine ve=new VelocityEngine();
            ve.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, "D:\\zengfeiyue\\workspace\\summer\\summer-code-generator\\src");

            try {
                //进行初始化操作
                ve.init();
                //加载模板，设定模板编码
                Template t=ve.getTemplate("main/resources/temple/Service.vm","gbk");
                //设置初始化数据
                VelocityContext context = new VelocityContext();
                context.put("basePackage", "com.summer");
                //设置输出
                PrintWriter writer = new PrintWriter("D://Service.java");
                //将环境数据转化输出
                t.merge(context, writer);
                writer.close();

                t=ve.getTemplate("/main/resources/temple/ServiceImpl.vm","gbk");
                //设置输出
                PrintWriter writer2 = new PrintWriter("D://ServiceImpl.java");
                //将环境数据转化输出
                t.merge(context, writer2);
                writer2.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
