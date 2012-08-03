package org.qq120011676.snow.tag;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.qq120011676.snow.entity.PageEntity;
import org.qq120011676.snow.util.FreeMarkerUtils;

import freemarker.template.TemplateException;

public class PageTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	public final static String PAGE_TAG_FILE_PATH = "pageTag.ftl";

	private PageEntity pageEntity;

	private String formId;

	public void setPageEntity(PageEntity pageEntity) {
		this.pageEntity = pageEntity;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	@Override
	public int doStartTag() throws JspException {
		Map<String, Object> map = new HashMap<String, Object>();
		Random random = new Random();
		map.put("selectId", "_S" + random.nextInt());
		map.put("page", this.pageEntity);
		map.put("formId", this.formId);
		try {
			FreeMarkerUtils.getconfiguration().getTemplate(PAGE_TAG_FILE_PATH)
					.process(map, super.pageContext.getOut());
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return super.doStartTag();
	}
}
