package org.qq120011676.snow.listener;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.qq120011676.snow.framework.ProjectInit;
import org.qq120011676.snow.properties.ProjectProperties;
import org.qq120011676.snow.tag.PageTag;
import org.qq120011676.snow.util.FileUtils;
import org.qq120011676.snow.util.ProjectUtils;
import org.qq120011676.snow.util.StringUtils;
import org.qq120011676.snow.xml.SqlXmlParse;

public class InitListener extends ProjectInit implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		super.initProjectRealPath(servletContext.getRealPath("/"));
		this.setFileEncoding(servletContext.getInitParameter("fileEncoding"));
		this.readConfig(servletContext.getInitParameter("configFilePath"));
		this.readMessages(servletContext.getInitParameter("messagesFilePath"));
		try {
			super.initFreemarker(ProjectUtils.getProjectClassPath());
			this.pageTemplate();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			new SqlXmlParse().sqlXmlParse(ProjectUtils.getProjectClassPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		servletContext.setAttribute("path", servletContext.getContextPath());

	}

	private void pageTemplate() throws IOException {
		String pageTagFileAddr = ProjectUtils.getProjectClassPath()
				+ PageTag.PAGE_TAG_FILE_PATH;
		if (!FileUtils.isFileOrFolder(pageTagFileAddr.substring(pageTagFileAddr
				.lastIndexOf("\\")))) {
			FileUtils.createFolder(pageTagFileAddr.substring(pageTagFileAddr
					.lastIndexOf("\\")));
		}
		if (!FileUtils.isFileOrFolder(pageTagFileAddr)) {
			FileUtils.fileStreamWrite(pageTagFileAddr, this.getClass()
					.getResourceAsStream("/" + PageTag.PAGE_TAG_FILE_PATH));
		}
	}

	private void setFileEncoding(String fileEncoding) {
		if (!StringUtils.isNull(fileEncoding)) {
			System.setProperty("file.encoding", fileEncoding);
		}
	}

	private void readMessages(String messagesFilePath) {
		String messages = null;
		if (!StringUtils.isNull(messagesFilePath)) {
			messages = messagesFilePath;
		} else if (new File(ProjectUtils.getProjectClassPath()
				+ ProjectProperties.DEFAULT_MESSAGES_FILE_NAME
				+ ProjectProperties.DEFAULT_FILE_EXTENSION_NAME).exists()) {
			messages = ProjectProperties.DEFAULT_MESSAGES_FILE_NAME;
		}
		if (!StringUtils.isNull(messages)) {
			super.initMessages(FileUtils.filePropertiesReader(messages));
		}
	}

	private void readConfig(String configFilePath) {
		String config = null;
		if (!StringUtils.isNull(configFilePath)) {
			config = configFilePath;
		} else if (new File(ProjectUtils.getProjectClassPath()
				+ ProjectProperties.DEFAULT_CONFIG_FILE_NAME
				+ ProjectProperties.DEFAULT_FILE_EXTENSION_NAME).exists()) {
			config = ProjectProperties.DEFAULT_CONFIG_FILE_NAME;
		}
		if (!StringUtils.isNull(config)) {
			super.initConfig(FileUtils.filePropertiesReader(config));
		}
	}
}
