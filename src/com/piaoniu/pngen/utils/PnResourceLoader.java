package com.piaoniu.pngen.utils;

import org.apache.sanselan.util.IOUtils;
import org.apache.velocity.runtime.resource.loader.StringResourceLoader;
import org.apache.velocity.runtime.resource.util.StringResourceRepositoryImpl;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

import static org.apache.velocity.runtime.resource.loader.StringResourceLoader.REPOSITORY_NAME_DEFAULT;

/**
 * @author code4crafter@gmail.com
 *         Date: 16/7/28
 *         Time: 下午6:52
 */
public class PnResourceLoader  {

	private StringResourceRepositoryImpl repo;

	public PnResourceLoader() {
		repo = new StringResourceRepositoryImpl();
		StringResourceLoader.setRepository(REPOSITORY_NAME_DEFAULT, repo);
	}

	public void init(String file) throws IOException {
		if (repo.getStringResource(file) == null) {
			repo.putStringResource(file, loadFile(file));
		}
	}

	@NotNull
	private String loadFile(String fileName) throws IOException {
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
		return new String(IOUtils.getInputStreamBytes(inputStream), "UTF-8");
	}

}
