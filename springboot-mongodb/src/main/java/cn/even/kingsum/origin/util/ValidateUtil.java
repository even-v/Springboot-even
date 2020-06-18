package cn.even.kingsum.origin.util;

import java.util.regex.Pattern;

import org.springframework.util.StringUtils;


public class ValidateUtil {
	public static final Pattern PHONE = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
	public static final Pattern EMAIL = Pattern.compile("^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w+)+)$");
	public static final Pattern FIXEDLINETEL = Pattern.compile("^0\\d{2,3}-\\d{6,8}$");
	
	public static boolean validatePhone(String phone){
		if(StringUtils.isEmpty(phone)) return false;
		return PHONE.matcher(phone).matches();
	}
	
	public static boolean validateEmail(String email){
		if(StringUtils.isEmpty(email)) return false;
		return EMAIL.matcher(email).matches();
	}
	
	public static boolean validateFixedLineTel(String fixedLineTel){
		if(StringUtils.isEmpty(fixedLineTel)) return false;
		return FIXEDLINETEL.matcher(fixedLineTel).matches();
	}
	
	public static void main(String[] args) {
		System.out.println(ValidateUtil.validatePhone("15962119546"));
		System.out.println(ValidateUtil.validateEmail("1596211_9546@aa.com.cm"));
		System.out.println(ValidateUtil.validateFixedLineTel("0510-8611111"));
	}
}
