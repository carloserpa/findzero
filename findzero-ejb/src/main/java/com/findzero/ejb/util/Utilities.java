package com.findzero.ejb.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Base64;

import javax.imageio.ImageIO;

public class Utilities {

	public static String encondeBase64(String fileImage) throws Exception{
		BufferedImage bufferedImage = ImageIO.read(new File("/opt/source/"+fileImage+".jpeg")); 
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		ImageIO.write(bufferedImage, "png", baos); 
		byte[] res = baos.toByteArray(); 
		String encondeBase64 = Base64.getEncoder().encodeToString(res); 
		return encondeBase64;		 
	}
}
