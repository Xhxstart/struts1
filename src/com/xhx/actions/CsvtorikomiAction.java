package com.xhx.actions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.xhx.froms.CsvfileTorikomiForm;

public class CsvtorikomiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		CsvfileTorikomiForm fileForm = (CsvfileTorikomiForm) form;
		String inString = "";
		String fileName = fileForm.getFilePath().getFileName();
		byte[] fileBytes = fileForm.getFilePath().getFileData();

		String path = this.getServlet().getInitParameter("uploadpath")
				+ fileName;
		;
		File file = new File(path);
		System.out.println(file.getParentFile());
		if (!file.getParentFile().exists()) {
			boolean result = file.getParentFile().mkdirs();
			if (!result) {
				System.out.println("创建失败");
				return mapping.findForward("error");
			}
		}
		try {
			FileOutputStream fileout = new FileOutputStream(path);
			fileout.write(fileBytes);
			fileout.flush();
			fileout.close();
			try {
				BufferedReader reader = new BufferedReader(new FileReader(path));
				BufferedWriter writer = new BufferedWriter(new FileWriter(
						"E:/writers.csv"));
				int lineNum = -1;
				while ((inString = reader.readLine()) != null) {
					lineNum++;
					if (lineNum > 0) {
						String item[] = inString.split(",", -1);
						/*
						 * if(item.length!=14){ System.out.println("文件列数出错！");
						 * return mapping.findForward("error"); }
						 */
						String error_msg = CheckMeishiData(item);
						inString = Integer.toString(lineNum) + "," + error_msg;
						// 『カンマ』

						for (int i = 0; i < item.length; i++) {
							inString = inString + "," + item[i];
						}
						writer.write(inString);
						writer.newLine();
					}
				}
				reader.close();
				writer.close();
			} catch (FileNotFoundException ex) {
				System.out.println("没找到文件！");
			} catch (IOException ex) {
				System.out.println("读写文件出错！");
			}
			request.setAttribute("fileForm", fileForm);
			return mapping.findForward("ok");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return mapping.findForward("error");
		}
	}

	private String CheckMeishiData(String[] row) {

		String error_msg = "";
		if (row[3].isEmpty() || row[3] == null) {
			error_msg = "必須項目未設定(顧客管理No)";
			return error_msg;
		}
		return error_msg;
	}

}
