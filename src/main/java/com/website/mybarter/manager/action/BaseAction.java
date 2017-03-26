package com.website.mybarter.manager.action;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;

import com.website.mybarter.manager.util.JsonUtils;

@ParentPackage("basePackage")
@Namespace("/")
public class BaseAction {

	public void writeJson(Object obj) {

		try {
			String json = JsonUtils.toJSon(obj);
			ServletActionContext.getResponse().setContentType(
					"text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
