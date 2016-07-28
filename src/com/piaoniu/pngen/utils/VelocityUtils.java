package com.piaoniu.pngen.utils;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午6:27
 */
public class VelocityUtils {

	public static String render(String templateFile, VelocityContext velocityContext) {
		Properties properties = new Properties();
		try {
			properties.load(VelocityUtils.class.getClassLoader().getResourceAsStream("velocity.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			LogUtils.showError("读取文件失败");
		}
		VelocityEngine ve = new VelocityEngine();
		ve.init(properties);
		Template template = ve.getTemplate(templateFile);
		StringWriter stringWriter = new StringWriter();
		template.merge(velocityContext, stringWriter);
		template.process();
		return stringWriter.toString();
	}
}
