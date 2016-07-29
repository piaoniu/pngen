package com.piaoniu.pngen.convert;

import com.piaoniu.pngen.model.Column;
import com.piaoniu.pngen.model.Table;
import org.junit.Test;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午6:06
 */
public class SqlGeneratorTest {

	@Test
	public void test() throws Exception {
		SqlGenerator sqlGenerator = new SqlGenerator();
		Table table = new Table();
		table.setName("PN_User");
		Column column = new Column();
		column.setName("name");
		column.setType("VARCHAR(255)");
		column.setComment("用户名");
		table.getColumns().add(column);
		String generate = sqlGenerator.generate(table);
		System.out.println(generate);
	}
}
