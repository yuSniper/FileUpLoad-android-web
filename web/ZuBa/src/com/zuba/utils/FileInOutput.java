package com.zuba.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

public class FileInOutput {

	public String filerename = "";

	public String upLoadFile(List<FileItem> items, String filedir) {

		try {

			if (items != null && !items.isEmpty()) {

				for (FileItem fileItem : items) {
					String filename = fileItem.getName();
					System.out.println(fileItem);
					// 获取系统当前时间
					String currentTime = String.valueOf(System
							.currentTimeMillis());

					// 得到上传文件的扩展名 (.xxx)
					// String fileExtName = filename.substring(filename
					// .lastIndexOf("."));
					// //
					// filerename = currentTime + fileExtName;

					String filepath = filedir + File.separator + filename;
					// 通过System.getProperty("file.separator")来得到系统相关的路径分隔符。
					// String separator = System.getProperty("file.separator");
					String savepath = filepath.replaceAll("\\\\", "/");
					System.out.println(filepath.replaceAll("\\\\", "/"));
					// http://192.168.47.114:8080/UploadFileWeb/images/3.jpg
					System.out.println("文件保存路径为:" + savepath);
					// 文件路径
					File file = new File(filepath);
					// File file1 = new File(filedir, filename);
					// File file2 = new File(filedir, filerename);
					// file1.renameTo(file1);
					System.out.println(file);
					// File file = new File(filepath);

					InputStream inputSteam = fileItem.getInputStream();
					BufferedInputStream fis = new BufferedInputStream(
							inputSteam);
					FileOutputStream fos = new FileOutputStream(file);
					int f;
					while ((f = fis.read()) != -1) {
						fos.write(f);
					}
					fos.flush();
					fos.close();
					fis.close();
					inputSteam.close();
					System.out.println("文件：" + filename + "上传成功!");
				}

			}
			System.out.println("上传文件成功!");
			return filerename;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
