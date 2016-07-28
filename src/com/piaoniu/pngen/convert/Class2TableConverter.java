package com.piaoniu.pngen.convert;

import com.intellij.psi.*;
import com.piaoniu.pngen.model.Column;
import com.piaoniu.pngen.model.Table;

import java.util.HashMap;
import java.util.Map;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午5:30
 */
public class Class2TableConverter {

	public static final String DEFAULT_TYPE = "VARCHAR(512)";
	private String prefix = "PN_";

	private String primaryKey = "id";

	private static Map<PsiPrimitiveType,String> psiPrimitiveTypeMap;

	private static Map<String,String> classTypeMap;

	static {
		psiPrimitiveTypeMap = new HashMap<PsiPrimitiveType, String>();
		psiPrimitiveTypeMap.put(PsiType.BOOLEAN, "TINYINT");
		psiPrimitiveTypeMap.put(PsiType.BYTE, "SMALLINT");
		psiPrimitiveTypeMap.put(PsiType.CHAR, "SMALLINT");
		psiPrimitiveTypeMap.put(PsiType.DOUBLE, "DOUBLE");
		psiPrimitiveTypeMap.put(PsiType.FLOAT, "FLOAT");
		psiPrimitiveTypeMap.put(PsiType.SHORT, "SMALLINT");
		psiPrimitiveTypeMap.put(PsiType.INT, "INT");
		psiPrimitiveTypeMap.put(PsiType.LONG, "BIGINT");
		classTypeMap = new HashMap<String, String>();
		classTypeMap.put("java.lang.String","VARCHAR(255)");
		classTypeMap.put("java.math.BigDecimal","DECIMAL(10,2)");
		classTypeMap.put("java.util.Date","TIMESTAMP");
	}

	public Table convert(PsiClass psiClass){
		Table table = new Table();
		table.setName(prefix + psiClass.getName());
		for (PsiField psiField : psiClass.getAllFields()) {
			Column column = new Column();
			column.setName(psiField.getName());
			if (psiField.getType() instanceof PsiPrimitiveType) {
				column.setType(psiPrimitiveTypeMap.get(psiField.getType()));
			} else if (psiField.getType() instanceof PsiClassType) {
				column.setType(classTypeMap.get(((PsiClassType)psiField.getType()).getCanonicalText()));
			}
			column.setType(DEFAULT_TYPE);
			table.getColumns().add(column);
		}
		return table;
	}

	public static void main(String[] args) {
		PsiType a = PsiType.CHAR;
		System.out.println(a.getCanonicalText());
	}

}
