//package cn.even.kingsum.origin.util;
//import java.awt.Graphics2D;
//import java.awt.RenderingHints;
//import java.awt.geom.AffineTransform;
//import java.awt.image.BufferedImage;
//import java.awt.image.ColorModel;
//import java.awt.image.WritableRaster;
//import java.io.BufferedOutputStream;
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.Base64;
//
//import javax.imageio.ImageIO;
//import javax.imageio.stream.ImageOutputStream;
//
//import org.apache.commons.io.FilenameUtils;
//import org.apache.commons.io.IOUtils;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.kingsum.platform.common.bean.PlatformUser;
//import com.kingsum.platform.common.core.Constants;
//import com.kingsum.platform.common.exception.BusinessException;
//import com.thoughtworks.xstream.core.util.Base64Encoder;
//
//
//public class ImageUtil {
//
//	public static InputStream resizeImage(InputStream inputStream, int targetW,int targetH) throws IOException {
//		try{
//			BufferedImage  source = ImageIO.read(inputStream);
//			int type = source.getType();
//
//			BufferedImage target = null;
//
//			double sx = (double) targetW / source.getWidth();
//
//			double sy = (double) targetH / source.getHeight();
//
//			if (sx < sy) {
//				sx = sy;
//				targetW = (int) (sx * source.getWidth());
//			} else {
//				sy = sx;
//				targetH = (int) (sy * source.getHeight());
//			}
//			if (type == BufferedImage.TYPE_CUSTOM) {
//				ColorModel cm = source.getColorModel();
//				WritableRaster raster = cm.createCompatibleWritableRaster(targetW,
//						targetH);
//				boolean alphaPremultiplied = cm.isAlphaPremultiplied();
//				target = new BufferedImage(cm, raster, alphaPremultiplied, null);
//			} else
//				target = new BufferedImage(targetW, targetH, type);
//			Graphics2D g = target.createGraphics();
//			g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
//					RenderingHints.VALUE_INTERPOLATION_BICUBIC);
//			g.drawRenderedImage(source, AffineTransform.getScaleInstance(sx, sy));
//			g.dispose();
//
//			ByteArrayOutputStream bs = new ByteArrayOutputStream();
//
//			ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
//
//			ImageIO.write(target, "jpg", imOut);
//
//			InputStream is = new ByteArrayInputStream(bs.toByteArray());
//
//			return is;
//		}finally{
//			IOUtils.closeQuietly(inputStream);
//		}
//
//	}
//
//	public static String save(InputStream inputStream,PlatformUser user){
//
//
//
//		return null;
//
//	}
//
//	public static void save2FileSystem(MultipartFile multipartFile,String file) throws Exception{
//		if(multipartFile.isEmpty()){
//			throw new BusinessException("文件为空");
//		}
//
//		String fileType = FilenameUtils.getExtension(multipartFile.getOriginalFilename().trim());
//		if(!Constants.fileTypes.contains(fileType.toLowerCase())){
//			throw new BusinessException("不允许上传此文件类型" + fileType);
//		}
//		//后缀名全部小写
//		file = file.substring(0,FilenameUtils.indexOfExtension(file)+1) + fileType.toLowerCase();
//		String path = FilenameUtils.getFullPath(file);
//		File f = new File(path);
//		if(!f.exists()){
//			f.mkdirs();
//		}
//
//		BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(file));
//		InputStream inputStream = multipartFile.getInputStream();
//		try {
//			IOUtils.copy(inputStream, os);
//		}finally{
//			IOUtils.closeQuietly(inputStream);
//			IOUtils.closeQuietly(os);
//		}
//
//	}
//
//	/*
//	 * 64位字符传递
//	 */
//	public static void save2FileSystem(String base64,String file,String fileType) throws Exception{
//		if(base64.isEmpty()){
//			throw new BusinessException("文件为空");
//		}
//
//		if(!Constants.fileTypes.contains(fileType.toLowerCase())){
//			throw new BusinessException("不允许上传此文件类型" + fileType);
//		}
//		//后缀名全部小写
//		file = file.substring(0,FilenameUtils.indexOfExtension(file)+1) + fileType.toLowerCase();
//		String path = FilenameUtils.getFullPath(file);
//		File f = new File(path);
//		if(!f.exists()){
//			f.mkdirs();
//		}
//		 byte[] buffer = new Base64Encoder().decode(base64);
//
//		 FileOutputStream out = new FileOutputStream(file);
//
//		try {
//			out.write(buffer);
//		}finally{
//			out.close();
//		}
//
//	}
//
//
//	public static void save2AliYunOss(InputStream inputStream,String file) {
//		if(inputStream == null){
//			return ;
//		}
//
//		try{
//			//ByteArrayInputStream input_b = (ByteArrayInputStream)ImageUtil.resizeImage(inputStream,CommonConstant.FACE_B,CommonConstant.FACE_B);
//			/*ObjectMetadata metadata = new ObjectMetadata();
//			metadata.setContentLength(input_b.available());
//			String key = String.format("%s/%s/%s",new Object[]{path,userId,CommonConstant.PATIENT_IMAGE_FACE_B});
//			client.putObject(getBucketName(CommonConstant.BUCKET_IMAGE), key_b, inputStream, metadata);	*/
//
//		}finally{
//			IOUtils.closeQuietly(inputStream);
//		}
//	}
//
//	public static void main(String[] args) {
//		System.out.println(FilenameUtils.getExtension("/ddd/dd/aaa.JPG").toLowerCase());
//		System.out.println(FilenameUtils.indexOfExtension("/ddd/dd/aaa.JPG"));
//		System.out.println("/ddd/dd/aaa.JPG".substring(0,FilenameUtils.indexOfExtension("/ddd/dd/aaa.JPG")+1) + FilenameUtils.getExtension("/ddd/dd/aaa.JPG").toLowerCase());
//		System.out.println("/ddd/dd/aaa.JPG");
//	}
//
//}
