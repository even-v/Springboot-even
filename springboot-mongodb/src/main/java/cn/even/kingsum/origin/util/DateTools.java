package cn.even.kingsum.origin.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 时间处理 Created by zht on 16/6/13.
 */
public class DateTools {
	public final static String FirstDay = "FirstDay";
	public final static String EndDay = "EndDay";
	// 常用日期输出格式
	public final static String YYYYMMDD = "yyyyMMdd";
	public final static String YYYYMM = "yyyyMM";
	public final static String YYYY_MM_DD = "yyyy-MM-dd";
	public final static String YYYY_M_D = "yyyy-M-d";
	public final static String YYYYMMDDHHMM = "yyyyMMddHHmm";
	public final static String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public final static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public final static String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
	public final static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public final static String HHMMSS = "HHmmss";
	public final static String HH_MM_SS = "HH:mm:ss";
	public final static String MM_SS = "MM月dd日";
	public final static String MM_DD = "MM-dd";
	public final static String YYYY_MM_DD_EE = "yyyy-MM-dd EE";
	public final static String YYYY_MM_DD_EEEE = "yyyy-MM-dd EEEE";
	public final static String DATE_FORMAT_STR_CHINESE = "yyyy年MM月dd日";
	public final static String DATE_FORMAT_YEAR_MONTH = "yyyy-MM";
	/** 00:00:00 */
	public final static String CURR_TIME_MORNING = " 00:00:00";
	/** 23:59:59 */
	public final static String CURR_TIME_NIGHT = " 23:59:59";
	public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss SSS");
	public static final SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
	public static final SimpleDateFormat DATE_FORMAT_HH_MM_SS = new SimpleDateFormat(HH_MM_SS);
	public static final SimpleDateFormat DATE_FORMAT_MM_SS = new SimpleDateFormat(MM_SS);
	public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_HH_MM = new SimpleDateFormat(YYYY_MM_DD_HH_MM);
	public static final SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
	public static final SimpleDateFormat DATE_FORMAT_YYYY_MM = new SimpleDateFormat(YYYYMM);
	public static final SimpleDateFormat DATE_FORMAT_MM_SS_ = new SimpleDateFormat(MM_SS, Locale.getDefault());
	public static final SimpleDateFormat DATE_FORMAT_YYYY_M_D = new SimpleDateFormat(YYYY_M_D, Locale.getDefault());
	public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_EE = new SimpleDateFormat(YYYY_MM_DD_EE,
			Locale.getDefault());
	public static final SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_EEEE = new SimpleDateFormat(YYYY_MM_DD_EEEE,
			Locale.getDefault());
	public static final SimpleDateFormat sdfH = new SimpleDateFormat("HH:00");
	public static final SimpleDateFormat DATE_FORMAT_HM = new SimpleDateFormat("HH:mm");
	public static final SimpleDateFormat mdh = new SimpleDateFormat("MM-dd HH:00");
	public static final SimpleDateFormat ymdh = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	public static final SimpleDateFormat HH = new SimpleDateFormat("HH");
	public static final SimpleDateFormat DD = new SimpleDateFormat("dd");
	public static final SimpleDateFormat DATE_FORMAT_YEAR_MONTH_EE = new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH);

	// 保留2位
	public static final java.text.DecimalFormat datef = new java.text.DecimalFormat("#.00");

	/**
	 * 获取相差时间 字符串描述 xx小时xx分
	 * 
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static String getHoursMinute2String(Calendar cal1, Calendar cal2) {
		long gap = (cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (1000 * 60);// 间隔分钟
		if (gap < 0) {
			gap = gap + 1000 * 60 * 60 * 24;
		}
		String tip = "";

		if (gap >= 60) {
			long l2 = gap / 60;
			long l3 = gap % 60;
			if (l3 > 0) {
				tip = l3 + "分钟";
			}

			tip = l2 + "小时" + tip;

		} else if (gap > 0) {
			tip = gap + "分钟";
		}

		return tip;
	}

	/**
	 * 减去天数
	 * 
	 * @param date
	 * @param sub
	 * @param minZoreorMax
	 *            0 return yyyy-mm-dd 00:00:00 1 yyyy-mm-dd 23:59:59 2
	 *            yyyy-mm-dd
	 * @return
	 * @throws ParseException
	 */
	public static Date subtraction(Date date, int sub, int minZoreorMax) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) - sub);
		calendar.set(Calendar.MILLISECOND, 000);
		SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
		if (minZoreorMax == 0) {
			return DATE_FORMAT_DEFAULT
					.parse(DATE_FORMAT_DATE_YYYY_MM_DD.format(calendar.getTime()) + CURR_TIME_MORNING);
		}
		if (minZoreorMax == 1) {
			return DATE_FORMAT_DEFAULT.parse(DATE_FORMAT_DATE_YYYY_MM_DD.format(calendar.getTime()) + CURR_TIME_NIGHT);
		}
		if (minZoreorMax == 2) {
			return DATE_FORMAT_DATE_YYYY_MM_DD.parse(DATE_FORMAT_DEFAULT.format(calendar.getTime()));
		}
		if (minZoreorMax == 3) {
			return calendar.getTime();
		}
		return calendar.getTime();
	}

	public static Date subtraction1(Date date, int sub, int minZoreorMax) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + sub);
		calendar.set(Calendar.MILLISECOND, 000);
		SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
		if (minZoreorMax == 0) {
			return DATE_FORMAT_DEFAULT
					.parse(DATE_FORMAT_DATE_YYYY_MM_DD.format(calendar.getTime()) + CURR_TIME_MORNING);
		}
		if (minZoreorMax == 1) {
			return DATE_FORMAT_DEFAULT.parse(DATE_FORMAT_DATE_YYYY_MM_DD.format(calendar.getTime()) + CURR_TIME_NIGHT);
		}
		if (minZoreorMax == 2) {
			return DATE_FORMAT_DATE_YYYY_MM_DD.parse(DATE_FORMAT_DEFAULT.format(calendar.getTime()));
		}
		return calendar.getTime();
	}
	// public static String timestamp2Date(SimpleDateFormat format, long
	// timestamp) {
	// TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
	// TimeZone.setDefault(tz);
	// format.setTimeZone(tz);
	// String date = format.format(timestamp);
	// return date;
	// }

	/**
	 * 输入一个时间，获取该时间的时间戳
	 * 
	 * @param dateString
	 * @return
	 * @throws ParseException
	 */
	public static long string2Timestamp(String dateString) throws ParseException {
		SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		Date date1 = DATE_FORMAT_DEFAULT.parse(dateString);
		long temp = date1.getTime();// JAVA的时间戳长度是13位
		return temp;
	}

	/**
	 * 毫秒转换成yyyy.MM.dd HH:mm:ss格式
	 */
	public static String timestamp2Date(long timestamp) {
		TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
		TimeZone.setDefault(tz);
		SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		DATE_FORMAT_DEFAULT.setTimeZone(tz);
		String date = DATE_FORMAT_DEFAULT.format(timestamp);
		return date;
	}

	/**
	 * 毫秒转换成yyyy.MM.dd HH:mm:ss格式
	 */
	public static String longtimes2Date(long timestamp) {
		SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		String date = DATE_FORMAT_DEFAULT.format(timestamp);
		return date;
	}

	/**
	 * 毫秒转换成HH:mm:ss格式
	 */
	public static String longtimes2HH_MM_SS(long timestamp) {
		SimpleDateFormat DATE_FORMAT_HH_MM_SS = new SimpleDateFormat(HH_MM_SS);
		String date = DATE_FORMAT_HH_MM_SS.format(timestamp);
		return date;
	}

	public static String longtimes2HH_MM_SS_SSS(long timestamp) {
		String date = DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS.format(timestamp);
		return date;
	}
	
	/**
	 * 毫秒转换成MM_SS格式年月
	 */
	public static String longtimes2MM_SS(long timestamp) {
		SimpleDateFormat DATE_FORMAT_MM_SS = new SimpleDateFormat(MM_SS);
		String date = DATE_FORMAT_MM_SS.format(timestamp);
		return date;
	}

	/**
	 * 获取yyyy.MM.dd HH:mm:ss格式的当前时间
	 */
	public static String getNowDate() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		String date = DATE_FORMAT_DEFAULT.format(c.getTime());
		return date;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 中获取 yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String formatDate(String date) {
		Date d = new Date();
		try {
			SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			d = DATE_FORMAT_DEFAULT.parse(date);
		} catch (ParseException e) {
			return date;
		}
		SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
		return DATE_FORMAT_DATE_YYYY_MM_DD.format(d);
	}

	/**
	 * 获取日期 时分秒为0
	 *
	 * @return
	 */
	public static Calendar getCalendar() {
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd",
		// Locale.CHINA);
		// format.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		Calendar c = Calendar.getInstance();
		SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
		String dateString = DATE_FORMAT_DATE_YYYY_MM_DD.format(c.getTime());
		try {
			c.setTime(DATE_FORMAT_DATE_YYYY_MM_DD.parse(dateString));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static Calendar getCalendar(Calendar calendar) {
		Calendar c = (Calendar) calendar.clone();
		SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
		String dateString = DATE_FORMAT_DATE_YYYY_MM_DD.format(c.getTime());
		try {
			c.setTime(DATE_FORMAT_DATE_YYYY_MM_DD.parse(dateString));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	public static String formatTime(String strTime) {
		try {
			SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			Date date = DATE_FORMAT_DEFAULT.parse(strTime);
			SimpleDateFormat DATE_FORMAT_HM = new SimpleDateFormat("HH:mm");
			strTime = DATE_FORMAT_HM.format(date);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		return strTime;
	}

	/**
	 * 获取相差天数
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static int getBetween(Calendar cal1, Calendar cal2) {
		long gap = (cal2.getTimeInMillis() - cal1.getTimeInMillis()) / (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
		return (int) gap;
	}

	/**
	 * 获取相差天数
	 *
	 * @param start
	 * @param end
	 * @return
	 */
	public static int getBetween(Date start, Date end) {
		long gap = (end.getTime() - start.getTime()) / (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
		return (int) gap;
	}

	/**
	 * 获取相差天数 去除后面的时分秒 获取相差天数
	 *
	 * @param cal1
	 * @param cal2
	 * @return
	 */
	public static int getBetween2(Calendar cal1, Calendar cal2) {
		long gap = (getCalendar((Calendar) cal2.clone()).getTimeInMillis() - getCalendar(cal1).getTimeInMillis())
				/ (1000 * 3600 * 24);// 从间隔毫秒变成间隔天数
		return (int) gap;
	}

	public static boolean isToday(Calendar cal) {
		boolean ret = false;
		Calendar tmp = Calendar.getInstance();
		SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
		String s1 = DATE_FORMAT_DATE_YYYY_MM_DD.format(cal.getTime());
		String s2 = DATE_FORMAT_DATE_YYYY_MM_DD.format(tmp.getTime());
		if (s1.equals(s2)) {
			ret = true;
		}
		return ret;
	}

	public static boolean isExpired(String searchStr) {
		boolean ret = false;
		Calendar cur = DateTools.getCalendar();
		Calendar search = DateTools.getCalendar();
		try {
			SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
			search.setTime(DATE_FORMAT_DATE_YYYY_MM_DD.parse(searchStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (search.before(cur)) {
			ret = true;
		}
		return ret;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss 字符串格式的两个时间的减法
	 *
	 * @param str1
	 *            减数
	 * @param str2
	 *            被减数
	 * @return 返回毫秒级别的时间单位
	 */
	public static long getTimeTwoString(String str1, String str2) {
		Date d1 = null;
		Date d2 = null;
		try {
			SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			d1 = DATE_FORMAT_DEFAULT.parse(str1);
			d2 = DATE_FORMAT_DEFAULT.parse(str2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time = d1.getTime() - d2.getTime();
		return time;
	}

	/**
	 * 把毫秒基本的时间格式转化为 hh:mm:ss 格式的时间
	 *
	 * @param diff
	 * @return
	 */
	public static String twoDate(long diff) {
		long days = diff / (1000 * 60 * 60 * 24);
		long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
		long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
		long miao = (diff - days * (100 * 60 * 60 * 24) - hours * (1000 * 60 * 60) - minutes * (1000 * 60)) / 1000;
		String str;
		if (String.valueOf(hours).length() == 1) {
			str = "0" + hours + ":";
		} else {
			str = hours + ":";
		}
		if (String.valueOf(minutes).length() == 1) {
			str = str + "0" + minutes + ":";
		} else {
			str = str + minutes + ":";
		}
		if (String.valueOf(miao).length() == 1) {
			str = str + "0" + miao;
		} else {
			str = str + miao;
		}
		return str;
	}

	public static String getYYYYMMDD(Date date) {
		SimpleDateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat(YYYYMMDD);
		return DATE_FORMAT_YYYYMMDD.format(date);
	}

	public static String getYYYY_MM_DD_HH_MM_SS(Date date) {
		SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return DATE_FORMAT_DEFAULT.format(date);
	}

	public static String getYYYY_MM_DD(Date date) {
		SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
		return DATE_FORMAT_DATE_YYYY_MM_DD.format(date);
	}

	public static String getMM_DD(Date date) {
		SimpleDateFormat DATE_FORMAT_MM_SS = new SimpleDateFormat(MM_SS);
		return DATE_FORMAT_MM_SS.format(date);
	}

	public static String getMM_RR(Date date) {
		SimpleDateFormat DATE_FORMAT_YYYYMMDD = new SimpleDateFormat(MM_DD);
		return DATE_FORMAT_YYYYMMDD.format(date);
	}

	/**
	 * 小时计算
	 * 
	 * @return
	 */
	public static Date getHour(int hour, int s, int m, int millis) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.SECOND, s);
		cal.set(Calendar.MINUTE, m);
		cal.set(Calendar.MILLISECOND, millis);
		return cal.getTime();
	}

	// 获得时间明天时间
	public static Date setTimeFmt(int day, int hour, int s, int m, int millis) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, hour);
		cal.set(Calendar.SECOND, s);
		cal.set(Calendar.MINUTE, m);
		cal.set(Calendar.MILLISECOND, millis);
		if (day != 0) {
			cal.add(Calendar.DATE, day * -1);
		}
		if (day != 0) {
			cal.set(Calendar.HOUR_OF_DAY, hour);
		}
		return cal.getTime();
	}

	// 获得时间当前时间
	public static Date getTomorFmt() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 8);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得当天0点时间
	public static Date getTimesmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获取当天的23点59分59秒999
	public static Date getTimesmorning999() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}

	// 获得昨天0点时间
	public static Date getYesterdaymorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setTimeInMillis(getTimesmorning().getTime() - 3600 * 24 * 1000);
		return cal.getTime();
	}

	// 获得明天0点时间
	public static Date getTomorrowmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		cal.setTimeInMillis(getTimesmorning().getTime() + 3600 * 24 * 1000);
		return cal.getTime();
	}

	// 获得当天近7天时间
	public static Date getWeekFromNow() {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(getTimesmorning().getTime() - 3600 * 24 * 1000 * 7);
		return cal.getTime();
	}

	/**
	 * 获取近期天数
	 * 
	 * @param day
	 *            天数
	 * @return
	 */
	public static Date getDayFromNow(Integer day) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, day * -1);
		return calendar.getTime();
	}

	// 获得当天24点时间
	public static Date getTimesnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得本周一0点时间
	public static Date getTimesWeekmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得上周一0点时间
	public static Date getLastTimesWeekmorning() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesWeekmorning());
		cal.add(Calendar.DAY_OF_WEEK, -7);
		return cal.getTime();
	}

	// 获得本周日24点时间
	public static Date getTimesWeeknight() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesWeekmorning());
		cal.add(Calendar.DAY_OF_WEEK, 7);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得本月第一天0点时间
	public static Date getTimesMonthmorning() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 获得本月最后一天24点时间
	public static Date getTimesMonthnight() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		cal.set(Calendar.HOUR_OF_DAY, 24);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getLastMonthStartMorning() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesMonthmorning());
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	}

	public static Date getCurrentQuarterStartTime() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.MILLISECOND, 0);
		int currentMonth = c.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				c.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				c.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				c.set(Calendar.MONTH, 6);
			else if (currentMonth >= 10 && currentMonth <= 12)
				c.set(Calendar.MONTH, 9);
			c.set(Calendar.DATE, 1);
			SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
			now = DATE_FORMAT_DEFAULT.parse(DATE_FORMAT_DATE_YYYY_MM_DD.format(c.getTime()) + CURR_TIME_MORNING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return now;
	}

	public static Date parseDate(String str) {
		try {
			if (!isExpired(str)) {
				SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
				return DATE_FORMAT_DATE_YYYY_MM_DD.parse(str);
			} else {
				SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
				return DATE_FORMAT_DEFAULT.parse(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date parseDate(String str,String format) {
		try {
			return DATE_FORMAT_YYYY_MM_DD_HH_MM.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 当前季度的结束时间，即2012-03-31 23:59:59
	 *
	 * @return
	 */
	public static Date getCurrentQuarterEndTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCurrentQuarterStartTime());
		cal.add(Calendar.MONTH, 3);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getCurrentYearStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.set(cal.get(Calendar.YEAR), 0, cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.YEAR));
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getCurrentYearEndTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCurrentYearStartTime());
		cal.add(Calendar.YEAR, 1);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date getLastYearStartTime() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCurrentYearStartTime());
		cal.add(Calendar.YEAR, -1);
		return cal.getTime();
	}

	public static Date getNumYearStartTime(int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getCurrentYearStartTime());
		cal.add(Calendar.YEAR, num);
		return cal.getTime();
	}

	public static Date getNumMonStartTime(int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesMonthmorning());
		cal.add(Calendar.MONTH, num);
		return cal.getTime();
	}

	public static Date getNumMonEndTime(int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesMonthnight());
		cal.add(Calendar.MONTH, num);
		return cal.getTime();
	}

	public static Date getNumWeekStartTime(int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getTimesWeekmorning());
		cal.add(Calendar.DAY_OF_WEEK, 7 * num);
		return cal.getTime();
	}

	public static Date getDaysFromNow(int num) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(getTimesmorning().getTime() + 3600 * 24 * 1000 * num);
		return cal.getTime();
	}

	public static Integer getHour(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}

	// 获取指定日期当月的第一天/最后一天
	public static Date getMonthDay(Integer year, Integer month, String model) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);
		System.out.println(calendar.getTime().toLocaleString());
		if ("FirstDay".equals(model)) {
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 000);
		} else if ("EndDay".equals(model)) {
			calendar.add(Calendar.MONTH, 1);
			calendar.set(Calendar.DAY_OF_MONTH, 0);
			calendar.set(Calendar.HOUR_OF_DAY, 23);
			calendar.set(Calendar.MINUTE, 59);
			calendar.set(Calendar.SECOND, 59);
			calendar.set(Calendar.MILLISECOND, 999);
		}
		return calendar.getTime();
	}

	public static Date getMonthDay22(Date targetDate, String model) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(targetDate);

		if ("FirstDay".equals(model)) {
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.MILLISECOND, 0);
		} else if ("EndDay".equals(model)) {
			cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			cal.set(Calendar.HOUR_OF_DAY, 24);
			cal.set(Calendar.MILLISECOND, 0);
		}
		return cal.getTime();
	}

	// 获取指定年份的第一天/最后一天
	public static Date getYearDay(Date targetDate, String model) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(targetDate);
		if ("FirstDay".equals(model)) {
			cal.set(cal.get(Calendar.YEAR), 0, cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.YEAR));
			cal.set(Calendar.MILLISECOND, 0);
		} else if ("EndDay".equals(model)) {
			cal.add(Calendar.YEAR, 1);
			cal.set(Calendar.MILLISECOND, 0);
		}
		return cal.getTime();
	}

	// 获取指定季度的第一天/最后一天
	public static Date getQuarterDay(Date targetDate, String model) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(targetDate);
		cal.set(Calendar.MILLISECOND, 0);
		int currentMonth = cal.get(Calendar.MONTH) + 1;
		Date now = null;
		try {
			if (currentMonth >= 1 && currentMonth <= 3)
				cal.set(Calendar.MONTH, 0);
			else if (currentMonth >= 4 && currentMonth <= 6)
				cal.set(Calendar.MONTH, 3);
			else if (currentMonth >= 7 && currentMonth <= 9)
				cal.set(Calendar.MONTH, 6);
			else if (currentMonth >= 10 && currentMonth <= 12)
				cal.set(Calendar.MONTH, 9);
			cal.set(Calendar.DATE, 1);
			SimpleDateFormat DATE_FORMAT_DEFAULT = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
			SimpleDateFormat DATE_FORMAT_DATE_YYYY_MM_DD = new SimpleDateFormat(YYYY_MM_DD);
			now = DATE_FORMAT_DEFAULT.parse(DATE_FORMAT_DATE_YYYY_MM_DD.format(cal.getTime()) + CURR_TIME_MORNING);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if ("EndDay".equals(model)) {
			cal.setTime(now);
			cal.add(Calendar.MONTH, 3);
			cal.set(Calendar.MILLISECOND, 0);
			return cal.getTime();
		}
		return now;
	}

	public static Date getMillisecondFd(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	// 得到当月中的周时间
	public static Date getWeekDay(Date targetDate, String model) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(targetDate);
		int day = 0;
		if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
			day = 7;
		} else {
			day = cal.get(Calendar.DAY_OF_WEEK) - 1;
		}
		if ("FirstDay".equals(model)) {

			cal.add(cal.DATE, -(day - 1));
		} else if ("EndDay".equals(model)) {
			if (day != 1) {
				cal.add(cal.DATE, (7 - day + 1));
			}
		}
		return cal.getTime();
	}

	public static void setTilteMessage() {
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(cal.DATE, 1);
		date = cal.getTime();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * System.out.println("当天24点时间：" + getTimesnight().toLocaleString());
		 * System.out.println("当前时间：" + new Date().toLocaleString());
		 * System.out.println("当天0点时间：" + getTimesmorning().toLocaleString());
		 * System.out.println("昨天0点时间：" +
		 * getYesterdaymorning().toLocaleString()); System.out.println("近7天时间："
		 * + getWeekFromNow().toLocaleString()); System.out.println("本周周一0点时间："
		 * + getTimesWeekmorning().toLocaleString());
		 * System.out.println("本周周日24点时间：" +
		 * getTimesWeeknight().toLocaleString()); System.out.println("本月初0点时间："
		 * + getTimesMonthmorning().toLocaleString());
		 * System.out.println("本月未24点时间：" +
		 * getTimesMonthnight().toLocaleString()); System.out.println("上月初0点时间："
		 * + getLastMonthStartMorning().toLocaleString());
		 * System.out.println("本季度开始点时间：" +
		 * getCurrentQuarterStartTime().toLocaleString());
		 * System.out.println("本季度结束点时间：" +
		 * getCurrentQuarterEndTime().toLocaleString());
		 * System.out.println("本年开始点时间：" +
		 * getCurrentYearStartTime().toLocaleString());
		 * System.out.println("本年结束点时间：" +
		 * getCurrentYearEndTime().toLocaleString());
		 * System.out.println("上年开始点时间：" +
		 * getLastYearStartTime().toLocaleString());
		 * System.out.println("上周一0点时间：" +
		 * getLastTimesWeekmorning().toLocaleString());
		 */
		/*
		 * System.out.println(getDaysFromNow(2).toLocaleString());
		 * System.out.println("本季度开始点时间：" + getCurrentQuarterStartTime());
		 * System.out.println("本季度结束点时间：" + getCurrentQuarterEndTime());
		 */
		/*
		 * System.out.println(getCalendar().getTime()); Calendar calendar =
		 * Calendar.getInstance(); Date date = new Date(); SimpleDateFormat
		 * format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		 * System.out.println(format.format(date)); calendar.setTime(date);
		 * calendar.set(Calendar.DAY_OF_MONTH,
		 * calendar.get(Calendar.DAY_OF_MONTH)-1);
		 */
		// BasicDBObject time = new BasicDBObject("ts", new Date());
		// System.out.println(time);

		Date date = new Date();
//			Date date1 = subtraction(date, 1, 1);
//			System.out.println(DateTools.getYYYY_MM_DD_HH_MM_SS(date1));
//			Calendar calendar = Calendar.getInstance();
//			calendar.set(Calendar.YEAR, 2017);
//			calendar.set(Calendar.MONTH, 10 - 1);
//			System.out.println("startTime===" + calendar.getTime().toLocaleString());
//			Date startTime = DateTools.getMonthDay22(calendar.getTime(), DateTools.FirstDay); // 指定月的第一天
//			Date endTime = DateTools.getMonthDay22(calendar.getTime(), DateTools.EndDay); // 指定月的最后一天
//
//			System.out.println("startTime===" + startTime.toLocaleString());
//			System.out.println("endTime=====" + endTime.toLocaleString());
//			System.out.println("start===" + getWeekDay(startTime, "FirstDay").toLocaleString());
//			System.out.println("end=====" + getWeekDay(endTime, "EndDay").toLocaleString());
//
//			String time = new Date().getTime() + "";
//			System.out.println("date=====" + time + "==" + longtimes2HH_MM_SS_SSS(Long.valueOf(time)));
//			String d = time.substring(0, time.length() - 3);
//			d = d + "000";
//			SimpleDateFormat DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//			d = DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS.format(new Date().getTime());
//			System.out.println(d);
//			d = d.substring(0, d.length() - 3);
//			d = d + "000";
//			System.out.println(DATE_FORMAT_YYYY_MM_DD_HH_MM_SS_SSS.parse(d));

			Integer year = 2018;
			Integer month = 2;
			System.out.println("startTime===" + year + "-" + month);
			Date startTime3 = DateTools.getMonthDay(year, month, DateTools.FirstDay); // 当然前月的第一天
			Date endTime3 = DateTools.getMonthDay(year, month, DateTools.EndDay); // 当然前月的最后一天
			

	}
}