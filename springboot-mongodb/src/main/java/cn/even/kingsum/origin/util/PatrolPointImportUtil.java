//package cn.even.kingsum.origin.util;
//import com.kingsum.platform.common.collects.FirePatrolPoint;
//import com.kingsum.platform.common.enums.CommonEnum;
//import com.kingsum.platform.common.enums.DeviceEnum;
//import com.kingsum.platform.common.enums.DeviceEnum.DeviceSourceEnum;
//import com.kingsum.platform.common.enums.DeviceEnum.DeviceStatus;
//import org.apache.poi.hssf.usermodel.HSSFDataFormat;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CellStyle;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.bson.Document;
//import org.bson.types.ObjectId;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//public class PatrolPointImportUtil {
//
//	public static final String ENCODE = "GBK";
//	public static int pointCodeIndex = 0;
//	public static int pointNameIndex = 1;
//	public static int buildingNameIndex = 2;
//	public static int floorNameIndex = 3;
//	public static int realNoIndex = 4;
//	public static int partitionDescribeIndex =5;
//	public static int addressIndex = 6;
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
//					case "点位编号":
//						pointCodeIndex = i;
//						break;
//					case "点位名称":
//						pointNameIndex = i;
//						break;
//					case "区域/建筑物":
//						buildingNameIndex = i;
//						break;
//					case "楼层名":
//						floorNameIndex = i;
//						break;
//					case "真实楼层":
//						realNoIndex = i;
//						break;
//					case "分区/房间":
//						partitionDescribeIndex = i;
//						break;
//					case "详细位置":
//						addressIndex = i;
//						break;
//				}
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
//		String partitionNo = null;
//		String partitionDescribe = null;
//		if (obj instanceof Document) {
//			floor = (Document) obj;
//		} else {
//			List<Document> floorList = (List<Document>) build.get("floorList");
//			for (Document f : floorList) {
//				if (info[PatrolPointImportUtil.floorNameIndex].equals(f.getString("floorName"))) {
//					floor = f;
//					continue;
//				}
//			}
//
//		}
//
//		if (floor == null) {
//			return null;
//		}else{
//
//			List<Document> partitionList = (List<Document>) floor.get("partition");
//			if(partitionList == null)
//				return null;
//			for (Document partition : partitionList) {
//				String pNo = partition.getString("partitionNo");
//				String pDesc = partition.getString("partitionDescribe");
//				String partitionDesc = info[PatrolPointImportUtil.partitionDescribeIndex];
//				if (partitionDesc.equals(pDesc)) {
//					partitionNo = pNo;
//					partitionDescribe = partitionDesc;
//					continue;
//				}
//			}
//		}
//
//		if(StringUtil.isEmpty(partitionNo,partitionDescribe)) {
//			return null;
//		}
//
//		Document doc;
//		try {
//			Date dd = new Date();
//			doc = new Document(FirePatrolPoint.unitId, unitId) // 业主单位id
//					.append(FirePatrolPoint.buildingId, build.getObjectId("_id"))
//					.append(FirePatrolPoint.buildName, info[buildingNameIndex])
//					.append(FirePatrolPoint.pointCode, info[pointCodeIndex])
//					.append(FirePatrolPoint.pointName, info[pointNameIndex])
//					.append(FirePatrolPoint.parkId, build.getObjectId("parkId"))
//					.append(FirePatrolPoint.parkName, build.getString("parkName"))
//					.append(FirePatrolPoint.partitionNo, partitionNo)
//					.append(FirePatrolPoint.partitionDescribe, partitionDescribe)
//					.append(FirePatrolPoint.floorNo, floor.getInteger("floorNo"))
//					.append(FirePatrolPoint.floorName, floor.getString("floorName"))
//					.append(FirePatrolPoint.realNo, info[realNoIndex])
//					.append(FirePatrolPoint.address, info[addressIndex])
//					.append(FirePatrolPoint.createTime, dd)
//					.append(FirePatrolPoint.updateTime, dd)
//					.append(FirePatrolPoint.pointStatus, DeviceEnum.DeviceStatus.ACTIVE.getIndex());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			doc = null;
//		}
//		return doc;
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
//}
