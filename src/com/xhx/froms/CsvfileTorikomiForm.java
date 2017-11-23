package com.xhx.froms;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class CsvfileTorikomiForm extends ActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private FormFile filePath;

	public FormFile getFilePath() {
		return filePath;
	}

	public void setFilePath(FormFile filePath) {
		this.filePath = filePath;
	}
	

}
