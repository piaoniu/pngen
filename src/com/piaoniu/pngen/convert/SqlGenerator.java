package com.piaoniu.pngen.convert;

import com.piaoniu.pngen.model.Table;
import com.piaoniu.pngen.utils.VelocityUtils;
import org.apache.velocity.VelocityContext;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午4:20
 */
public class SqlGenerator {

	public String generate(Table table){
		VelocityContext velocityContext = new VelocityContext();
		velocityContext.put("table",table);
		return VelocityUtils.render("create_table.vm",velocityContext);
	}

}
