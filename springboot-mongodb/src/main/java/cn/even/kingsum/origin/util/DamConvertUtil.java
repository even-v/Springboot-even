//package cn.even.kingsum.origin.util;
//import com.kingsum.platform.common.enums.PowerMonitorEnum;
//
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//
///**
// * dam 采集上传的监测值转换
// *
// * @author Administrator
// *
// */
//public class DamConvertUtil {
//
//	/**
//	 * 上传的采集值转换成设备的真实值
//	 *
//	 * @return
//	 */
//	public static Integer getDamConverVal(Integer collect_oriValue, Integer sensorType, Double rangeMax, Double rangeMin, Integer collect_scale) {
//		Integer collect_value = null;
//
//		switch (sensorType) {
//		case 0:
//			collect_value = collect_oriValue;
//			break;
//		case 1: // 4~20mA
//			if (null == rangeMax || null == rangeMin) {
//				collect_value = collect_oriValue;
//				break;
//			}
//			Integer sensorRH = 20;
//			Integer sensorRL = 4;
//			double electric = (collect_oriValue < 819 ? collect_oriValue : collect_oriValue - 819) / (4095f - 819)
//					* (sensorRH - sensorRL) + sensorRL;
//			double analog = (rangeMax - rangeMin) * (electric - sensorRL) / (sensorRH - sensorRL) + rangeMin;
//			collect_value = new BigDecimal(analog).setScale(2, RoundingMode.HALF_UP)
//					.multiply(new BigDecimal(collect_scale)).intValue();
//			break;
//		case 2: // 0~5V
//			if (null == rangeMax || null == rangeMin) {
//				collect_value = collect_oriValue;
//				break;
//			}
//			sensorRH = 5;
//			sensorRL = 0;
//			electric = collect_oriValue / (4095f) * 2 * (sensorRH - sensorRL) + sensorRL;
//			analog = (rangeMax - rangeMin) * (electric - sensorRL) / (sensorRH - sensorRL) + rangeMin;
//			collect_value = new BigDecimal(analog).setScale(2, RoundingMode.HALF_UP)
//					.multiply(new BigDecimal(collect_scale)).intValue();
//			break;
//		case 3:
//			collect_value = collect_oriValue;
//			break;
//		case 4: // 0~20mA
//			if (null == rangeMax || null == rangeMin) {
//				collect_value = collect_oriValue;
//				break;
//			}
//			sensorRH = 20;
//			sensorRL = 0;
//			electric = (collect_oriValue) / (4095f - 819) * (sensorRH - sensorRL) + sensorRL;
//			analog = (rangeMax - rangeMin) * (electric - sensorRL) / (sensorRH - sensorRL) + rangeMin;
//			collect_value = new BigDecimal(analog).setScale(2, RoundingMode.HALF_UP)
//					.multiply(new BigDecimal(collect_scale)).intValue();
//			break;
//		default:
//			break;
//		}
//		return collect_value;
//	}
//
//	/**
//	 *  从模拟量转温度、湿度
//	 * @param analogType  模拟量类型
//	 * @param orgVal	   原始值
//	 * @return
//	 */
//	public static Double convertAnalog(Integer analogType, Integer orgVal) {
//		Double realVal = Double.NaN;
//
//		Integer temperature = PowerMonitorEnum.power_monitor_temperature.getIndex();  //温度
//		Integer humidity = PowerMonitorEnum.power_monitor_humidity.getIndex();    //湿度
//		Integer current = PowerMonitorEnum.power_monitor_current.getIndex();    //电流
//		Integer voltage = PowerMonitorEnum.power_monitor_voltage.getIndex();    //电压
//
//		if (temperature.equals(analogType)) {    //温度
//			realVal = (orgVal / 204.75 - 7.55) / 0.177;
//		} else if (voltage.equals(analogType)) { //电压
//			realVal = Double.parseDouble(orgVal + "");
//		} else if (current.equals(analogType)) {//电流
//			realVal = (orgVal / 204.75 - 4) / 0.32;
//		} else if (humidity.equals(analogType)) { //湿度
//			realVal = (orgVal / 204.75 - 3.11) / 17.77;
//		}
//		return realVal;
//	}
//
//	public static void main(String[] args) {
//		Double 	realVal = (3549 / 204.75 - 3.11) / 17.77;
//	}
//}
