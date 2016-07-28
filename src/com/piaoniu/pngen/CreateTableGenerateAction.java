package com.piaoniu.pngen;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.piaoniu.pngen.convert.Class2TableConverter;
import com.piaoniu.pngen.convert.SqlGenerator;
import com.piaoniu.pngen.model.Table;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

import static com.piaoniu.pngen.utils.LogUtils.showError;
import static com.piaoniu.pngen.utils.LogUtils.showInfo;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午4:20
 */
public class CreateTableGenerateAction extends AnAction{

	private Class2TableConverter class2TableConverter = new Class2TableConverter();
	private SqlGenerator sqlGenerator = new SqlGenerator();

	public void actionPerformed(AnActionEvent e) {
		PsiElement data = DataKeys.PSI_ELEMENT.getData(e.getDataContext());

		if (!(data instanceof PsiClass)){
			showError("必须选择一个类");
			return;
		}

		Table table = class2TableConverter.convert((PsiClass) data);
		String createSql = sqlGenerator.generate(table);
		showInfo("生成成功,sql已复制到剪切板");
		Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable tText = new StringSelection(createSql);
		clip.setContents(tText, null);
	}


}
