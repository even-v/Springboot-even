package cn.even.kingsum.origin.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
	public static boolean isEmpty(String str) {
		if (str == null || str.trim().length() == 0 || "null".equalsIgnoreCase(str.trim())) {
			return true;
		}
		return false;
	}

	public static boolean isEmpty(String... str) {
		for (String s : str) {
			if (isEmpty(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 将byte数组转换为表示16进制值的字符串，如：byte[]{8,18}转换为：0813， 和public static byte[]
	 * hexStrToByteArr(String strIn) 互为可逆的转换过程
	 * 
	 * @param arrB
	 *            需要转换的byte数组
	 * @return 转换后的字符串
	 */
	public static String byteArrToHexStr(byte[] arrB) {
		int iLen = arrB.length;
		// 每个byte(8位)用两个(16进制)字符才能表示，所以字符串的长度是数组长度的两倍
		StringBuffer sb = new StringBuffer(iLen * 2);
		for (int i = 0; i < iLen; i++) {
			int intTmp = arrB[i];
			while (intTmp < 0) {// 把负数转换为正数
				intTmp = intTmp + 256;
			}
			if (intTmp < 16) {// 小于0F的数需要在前面补0
				sb.append("0");
			}
			sb.append(Integer.toString(intTmp, 16) + " ");
		}
		return sb.toString().trim();
	}

	/**
	 * 将表示16进制值的字符串转换为byte数组，和public static String byteArrToHexStr(byte[] arrB)
	 * 互为可逆的转换过程
	 * 
	 * @param strIn
	 *            需要转换的字符串
	 * @return 转换后的byte数组
	 */
	public static byte[] hexStrToByteArr(String strIn) {
		if(strIn.startsWith("0x")){
			strIn = strIn.substring(2, strIn.length());
		}
		byte[] arrB = strIn.getBytes();
		int iLen = arrB.length;
		if((iLen % 2) == 1){
			strIn = "0" + strIn;
			iLen = iLen + 1;
			arrB = strIn.getBytes();
		}
		// 两个(16进制)字符表示一个字节(8位)，所以字节数组长度是字符串长度除以2
		byte[] arrOut = new byte[iLen / 2];
		for (int i = 0; i < iLen; i = i + 2) {
			String strTmp = new String(arrB, i, 2);
			arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
		}
		return arrOut;
	}

	public static long pageCount(long totalRecord, long pageSize) {
		return (totalRecord + pageSize - 1) / pageSize;
	}

	/**
	 * 生成随机字符串
	 * 
	 * @author wanggq
	 * @param len
	 *            字符串长度
	 * @param isNums
	 *            是否是纯数字
	 * @return 字符串
	 */
	public static String randomStr(int len, boolean isNums) {
		String nums = "0123456789";
		String letterNums = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		if (isNums) {
			for (int i = 0; i < len; i++) {
				int num = random.nextInt(nums.length());
				sb.append(nums.charAt(num));
			}
		} else {
			for (int i = 0; i < len; i++) {
				int num = random.nextInt(letterNums.length());
				sb.append(letterNums.charAt(num));
			}
		}
		return sb.toString();
	}

	public static String getEquipNo(String areaNo, String placeNo) {
		if (areaNo == null) {
			areaNo = "0";
		}
		if (placeNo == null) {
			placeNo = "0";
		}
		String a = String.format("%03d", Integer.parseInt(areaNo));
		String b = String.format("%03d", Integer.parseInt(placeNo));
		return a + b;
	}

	public static boolean checkInput(String str) {
		Pattern p = Pattern.compile("[a-zA-Z0-9\u4E00-\u9FA5\\s]*");
		Matcher m = p.matcher(str);
		if (!m.find()) {
			return false;
		} else {
			if (m.group(0).length() != str.length()) {
				return false;
			}
		}
		return true;
	}


    public static String formatGb26875HexStr(String str){
    	String[] arr = str.split("\\s");
    	int total = arr.length;
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i =0;i<total;i++){
    		if(i == 1||i==26||i==(total-4)||i==(total-3)){
    			sb.append(arr[i]+"|");
    		}else{
    			sb.append(arr[i]+" ");
    		}
    	}
    	return sb.toString().trim();
    }
    
    /**
     * 例如：
     * byte0->192
     * byte1->168
     * byte2->xxx
     * byte3->xxx
     * @param arr
     * @return
     */
    public static String byteArrToIpStr(byte[] arr){
    	if(null==arr || arr.length<4){
    		return "";
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append((short)arr[0] & 0xff).append(".");
    	sb.append((short)arr[1] & 0xff).append(".");
    	sb.append((short)arr[2] & 0xff).append(".");
    	sb.append((short)arr[3] & 0xff);
    	return sb.toString();
    }
    
    public static String formatGb26875HexStr(byte[] arr){
    	return formatGb26875HexStr(byteArrToHexStr(arr));
    }
    
    public static String byteToHexStr(byte arrB) {  
    	int intTmp = arrB;  
        while (intTmp < 0) {// 把负数转换为正数  
            intTmp = intTmp + 256;  
        }  
        if (intTmp < 16) {// 小于0F的数需要在前面补0  
            return "0"+ Integer.toString(intTmp, 16);  
        }  
        return Integer.toString(intTmp, 16);  
    }
    public static Integer byteToHexStr10(byte arrB){
    	int intTmp = arrB;  
    	 while (intTmp < 0) {// 把负数转换为正数  
             intTmp = intTmp + 256;  
         }
    	 
    	return Integer.valueOf(intTmp);
    }
    
    public static String byteArrToHexStrNoEmp(byte[] arrB) {  
        int iLen = arrB.length;  
        // 每个byte(8位)用两个(16进制)字符才能表示，所以字符串的长度是数组长度的两倍  
        StringBuffer sb = new StringBuffer(iLen * 2);  
        for (int i = 0; i < iLen; i++) {  
            int intTmp = arrB[i];  
            while (intTmp < 0) {// 把负数转换为正数  
                intTmp = intTmp + 256;  
            }  
            if (intTmp < 16) {// 小于0F的数需要在前面补0  
                sb.append("0");  
            }  
            sb.append(Integer.toString(intTmp, 16)+"");  
        }  
        return sb.toString().toUpperCase().trim();  
    }
    
	public static void main(String[] args) {
//		boolean s = checkInput("点位名称2");
//		System.err.println(hexStrToByteArr("0x1223"));
		
	}
}
