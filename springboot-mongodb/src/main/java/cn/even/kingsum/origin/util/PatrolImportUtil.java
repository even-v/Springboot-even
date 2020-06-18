//package cn.even.kingsum.origin.util;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.bson.Document;
//import org.bson.types.ObjectId;
//
//import com.kingsum.platform.common.collects.FirePatrolDevice;
//import com.kingsum.platform.common.collects.FirePatrolPoint;
//import com.kingsum.platform.common.enums.CommonEnum;
//import com.kingsum.platform.common.enums.DeviceEnum.DeviceSourceEnum;
//import com.kingsum.platform.common.enums.DeviceEnum.DeviceStatus;
//
//public class PatrolImportUtil {
//
//	public static final String ENCODE = "GBK";
//	public static int pointCodeIndex = 0;
//	public static int buildingNameIndex = 1;
//	public static int floorNameIndex = 2;
//	public static int partitionDescribeIndex = 3;
//	public static int pointNameIndex = 4;
//	public static int pointAddrIndex = 5;
//	public static int deviceNameIndex = 6;
//	public static int devicBrandIndex = 7;
//	public static int deviceModelIndex = 8;
//	public static int fireSysTypeIndex = 9;
//	public static int fireDeviceTypeIndex = 10;
//	public static int deviceAddrIndex = 11;
//	public static int deviceValidDateIndex = 12;
//	public static int remarksIndex = 13;
//
//	public static boolean checkFileCode(String filePath) throws IOException {
//		File deFile = null;
//		// 判断文件编码格式
//		deFile = new File(filePath);
//		InputStream in = new FileInputStream(deFile);
//		int p = (in.read() << 8) + in.read();
//		in.close();
//		String code = null;
//		switch (p) {
//		case 0xefbb:
//			code = "UTF-8";
//			break;
//		case 0xfffe:
//			code = "Unicode";
//			break;
//		case 0xfeff:
//			code = "UTF-16BE";
//			break;
//		default:
//			code = "GBK";
//		}
//
//		return ENCODE.equals(code);
//	}
//
//	public static void handleHeaderIndex(String[] headers) {
//		if (headers != null && headers.length > 0) {
//			int i = 0;
//			for (String header : headers) {
//				System.out.println(header + i);
//				switch (header.trim()) {
//				case "点位编号":
//					pointCodeIndex = i;
//					break;
//				case "区域/建筑物":
//					buildingNameIndex = i;
//					break;
//				case "楼层名":
//					floorNameIndex = i;
//					break;
//				case "分区房间":
//					partitionDescribeIndex = i;
//					break;
//				case "点位名称":
//					pointNameIndex = i;
//					break;
//				case "点位详细位置":
//					pointAddrIndex = i;
//					break;
//				case "设备名称":
//					deviceNameIndex = i;
//					break;
//				case "设备品牌":
//					devicBrandIndex = i;
//					break;
//				case "设备型号":
//					deviceModelIndex = i;
//					break;
//				case "设备详细位置":
//					deviceAddrIndex = i;
//					break;
//				case "消防系统类型":
//					fireSysTypeIndex = i;
//					break;
//				case "消防设备类型":
//					fireDeviceTypeIndex = i;
//					break;
//				case "设备有效期":
//					deviceValidDateIndex = i;
//					break;
//				case "扩展信息":
//					remarksIndex = i;
//					break;
//				}
//
//				i++;
//			}
//		}
//	}
//
//	public static int checkData(String[] info, Document build) {
//		int flag = 1;
//		if (build == null) {
//			flag = 2;// 没有该建筑物
//		} else {
//			if (build.getInteger("status").intValue() == CommonEnum.data_status_del.getIndex()) {
//				flag = 2;
//			} else {
//				if (!StringUtil.isEmpty(info[floorNameIndex])) {
//					boolean f = false;
//					@SuppressWarnings("unchecked")
//					List<Document> floorList = (List<Document>) build.get("floorList");
//					for (Document floor : floorList) {
//						if (floor.getString("floorName").equals(info[floorNameIndex])) {
//							f = true;
//						}
//					}
//					if (!f) {
//						flag = 4;// 没有该楼层
//					}
//				} else {
//					flag = 3;// 所属楼层号不能为空
//				}
//			}
//
//		}
//
//		return flag;
//	}
//
//	/**
//	 * 处理导入部件数据
//	 *
//	 * @param info
//	 *            数组
//	 * @param unitId
//	 *            业主单位id
//	 * @return
//	 */
//	public static Document handle5ImportData(String[] info, ObjectId unitId, Document build, Document point) {
//
//		Document floor = null;
//		Object obj = build.get("floorList");
//		if (obj instanceof Document) {
//			floor = (Document) obj;
//		} else {
//			List<Document> floorList = (List<Document>) build.get("floorList");
//			for (Document f : floorList) {
//				if (info[PatrolImportUtil.floorNameIndex].equals(f.getInteger("floorName") + "")) {
//					floor = f;
//				}
//			}
//		}
//		if (floor == null) {
//			return null;
//		}
//
//		Document device;
//		try {
//			String validDate = info[deviceValidDateIndex];
//			Date date = DateTools.DATE_FORMAT_DATE_YYYY_MM_DD.parse(validDate);
//			Date dd = new Date();
//			device = new Document(FirePatrolDevice.unitId, unitId);
//			device.append(FirePatrolDevice.pointId, point.getObjectId(FirePatrolPoint._id))
//					.append(FirePatrolDevice.pointCode, point.getString(FirePatrolPoint.pointCode))
//					.append(FirePatrolDevice.pointName, point.getString(FirePatrolPoint.pointName))
//					.append(FirePatrolDevice.pointAddr, point.getString(FirePatrolPoint.address))
//					.append(FirePatrolDevice.buildingId, point.getObjectId(FirePatrolPoint.buildingId))
//					.append(FirePatrolDevice.buildName, point.getString(FirePatrolPoint.buildName))
//					.append(FirePatrolDevice.floorNo, point.getInteger(FirePatrolPoint.floorNo))
//					.append(FirePatrolDevice.floorName, point.getString(FirePatrolPoint.floorName))
//					.append(FirePatrolDevice.partitionNo, point.getString(FirePatrolPoint.partitionNo))
//					.append(FirePatrolDevice.partitionDescribe, point.getString(FirePatrolPoint.partitionDescribe))
//					.append(FirePatrolDevice.deviceAddr, info[PatrolImportUtil.deviceAddrIndex])
//					.append(FirePatrolDevice.source, DeviceSourceEnum.WEB.getIndex())
//					.append(FirePatrolDevice.deviceName, info[PatrolImportUtil.deviceNameIndex])
//					.append(FirePatrolDevice.createTime, dd).append("updateTime", dd)
//					.append(FirePatrolDevice.deviceValidDate, date)
//					.append(FirePatrolDevice.deviceModel, info[deviceModelIndex])
//					.append(FirePatrolDevice.brandName, info[devicBrandIndex])
//					.append(FirePatrolDevice.remarks, info[remarksIndex])
//					.append(FirePatrolDevice.parkId, point.getObjectId(FirePatrolPoint.parkId))
//					.append(FirePatrolDevice.parkName, point.getString(FirePatrolPoint.parkName))
//					.append(FirePatrolDevice.deviceStatus, DeviceStatus.ACTIVE.getIndex());
//		} catch (Exception e) {
//			e.printStackTrace();
//			device = null;
//		}
//		return device;
//	}
//
//	public static Document handData(String[] info, ObjectId unitId, Document point) {
//		Document device;
//		try {
//
//			String validDate = info[deviceValidDateIndex];
//			Date date = DateTools.DATE_FORMAT_DATE_YYYY_MM_DD.parse(validDate);
//			Date dd = new Date();
//			device = new Document(FirePatrolDevice.unitId, unitId);
//			device.append(FirePatrolDevice.pointId, point.getObjectId(FirePatrolPoint._id))
//					.append(FirePatrolDevice.pointCode, point.getString(FirePatrolPoint.pointCode))
//					.append(FirePatrolDevice.pointName, point.getString(FirePatrolPoint.pointName))
//					.append(FirePatrolDevice.pointAddr, point.getString(FirePatrolPoint.address))
//					.append(FirePatrolDevice.buildingId, point.getObjectId(FirePatrolPoint.buildingId))
//					.append(FirePatrolDevice.buildName, point.getString(FirePatrolPoint.buildName))
//					.append(FirePatrolDevice.floorNo, point.getInteger(FirePatrolPoint.floorNo))
//					.append(FirePatrolDevice.floorName, point.getString(FirePatrolPoint.floorName))
//					.append(FirePatrolDevice.partitionNo, point.getString(FirePatrolPoint.partitionNo))
//					.append(FirePatrolDevice.partitionDescribe, point.getString(FirePatrolPoint.partitionDescribe))
//					.append(FirePatrolDevice.deviceAddr, info[PatrolImportUtil.deviceAddrIndex])
//					.append(FirePatrolDevice.source, DeviceSourceEnum.WEB.getIndex())
//					.append(FirePatrolDevice.deviceName, info[PatrolImportUtil.deviceNameIndex])
//					.append(FirePatrolDevice.createTime, dd).append("updateTime", dd)
//					.append(FirePatrolDevice.deviceValidDate, date)
//					.append(FirePatrolDevice.deviceModel, info[deviceModelIndex])
//					.append(FirePatrolDevice.brandName, info[devicBrandIndex])
//					.append(FirePatrolDevice.remarks, info[remarksIndex])
//					.append(FirePatrolDevice.parkId, point.getObjectId(FirePatrolPoint.parkId))
//					.append(FirePatrolDevice.parkName, point.getString(FirePatrolPoint.parkName))
//					.append(FirePatrolDevice.deviceStatus, DeviceStatus.ACTIVE.getIndex());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			device = null;
//		}
//		return device;
//	}
//
//	/**
//	 * 格式化Excel数据
//	 *
//	 * @param cell
//	 * @return
//	 */
//	public static String parseExcel(Cell cell) {
//		if (cell == null) {
//			return "";
//		}
//		String result = new String();
//		switch (cell.getCellType()) {
//		case Cell.CELL_TYPE_NUMERIC:
//			if (DateUtil.isCellDateFormatted(cell)) {
//				SimpleDateFormat sdf = null;
//				if (cell.getCellStyle().getDataFormat() == HSSFDataFormat.getBuiltinFormat("h:mm")) {
//					sdf = new SimpleDateFormat("HH:mm");
//				} else {// 日期
//					sdf = new SimpleDateFormat("yyyy-MM-dd");
//				}
//				Date date = cell.getDateCellValue();
//				result = sdf.format(date);
//			} else if (cell.getCellStyle().getDataFormat() == 58) {
//				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//				double value = cell.getNumericCellValue();
//				Date date = DateUtil.getJavaDate(value);
//				result = sdf.format(date);
//			} else {
//				double value = cell.getNumericCellValue();
//				CellStyle style = cell.getCellStyle();
//				DecimalFormat format = new DecimalFormat();
//				String temp = style.getDataFormatString();
//				if (temp.equals("General")) {
//					format.applyPattern("####.################");
//				}
//				result = format.format(value);
//			}
//			break;
//		case Cell.CELL_TYPE_STRING:// String类型
//			result = cell.getRichStringCellValue().toString();
//			break;
//		case Cell.CELL_TYPE_FORMULA:
//			result = cell.getRichStringCellValue().toString();
//			break;
//		case Cell.CELL_TYPE_BLANK:
//			result = "";
//		default:
//			result = "";
//			break;
//		}
//		return result;
//	}
//
//	// 验证设备名称是否有效
//	public static int deviceName(String deviceName) {
//		if (StringUtil.isEmpty(deviceName)) {
//			return 1;
//		} else {
//			if (deviceName.length() > 30) {
//				return 2;
//			} else if (isSpecialChar(deviceName)) { // true为包含，false为不包含
//				return 3;
//			}
//		}
//		return 0;
//	}
//
//	/**
//	 * 判断是否含有特殊字符
//	 *
//	 * @param str
//	 * @return true为包含，false为不包含
//	 */
//	public static boolean isSpecialChar(String str) {
//		String regEx = "[ _`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]|\n|\r|\t";
//		Pattern p = Pattern.compile(regEx);
//		Matcher m = p.matcher(str);
//		return m.find();
//	}
//
//}
