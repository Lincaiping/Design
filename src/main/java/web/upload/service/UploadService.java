package web.upload.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;

@Service
public class UploadService {
	public boolean SaveManager(String image, String imgFilePath) {
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(image.substring(22));
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	int length = 2097152;

	public boolean androidSaveManager(File image, String imgFilePath) {
		try {
			OutputStream out = new FileOutputStream(imgFilePath);
			InputStream in = new FileInputStream(image);
			byte[] buffer = new byte[length];
			while (true) {
				int ins = in.read(buffer);
				if (ins == -1) {
					in.close();
					out.flush();
					out.close();
					return true;
				} else
					out.write(buffer, 0, ins);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

}
