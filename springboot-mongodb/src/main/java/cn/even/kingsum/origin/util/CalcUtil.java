package cn.even.kingsum.origin.util;

import java.math.BigDecimal;

public class CalcUtil {
	
	/**
	 * 获取指定精确位的小数
	 * @param value	分子
	 * @param divisor 分母
	 * @param scale	精确位
	 * @return	保留到精确位的值
	 */
	public static BigDecimal toBigDecimal(Integer value, Integer divisor, int scale){
		if(value == null || divisor == null || divisor == 0){
			return new BigDecimal(0);
		}
		return new BigDecimal(value).divide(new BigDecimal(divisor), scale, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * 获取指定精确位的小数
	 * @param value	分子
	 * @param divisor 分母
	 * @param scale	精确位
	 * @return	保留到精确位的值
	 */
	public static BigDecimal toBigDecimal(Double value, Integer divisor, int scale){
		if(value == null || divisor == null || divisor == 0){
			return new BigDecimal(0);
		}
		return new BigDecimal(value).divide(new BigDecimal(divisor), scale, BigDecimal.ROUND_HALF_UP);
	}
	
}
