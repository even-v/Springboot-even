package cn.even.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FileName: StringUtil
 * Author:   jiangjingwei@yysoft.org.cn
 * Date:     6/15/2020 10:43 AM
 * Description:
 */

public class StringUtil {
    public static HashMap<String, String> escapeCharMap = new HashMap();

    public StringUtil() {
    }

    public static String utf8Decoder(String str) {
        try {
            return isEmpty(str) ? str : URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
            return str;
        }
    }

    public static String utf8Encoder(String str) {
        try {
            return isEmpty(str) ? str : URLEncoder.encode(str, "UTF-8");
        } catch (Exception var2) {
            var2.printStackTrace();
            return str;
        }
    }

    public static String shieldMobile(String mobile) {
        return isEmpty(mobile) ? null : mobile.substring(0, 3) + "****" + mobile.substring(7, 11);
    }

    public static String getRodamCode(int length) {
        Random rand = new Random();
        String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTYVWXYZ";
        int size = base.length();
        StringBuffer str = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            int start = rand.nextInt(size);
            String tmpStr = base.substring(start, start + 1);
            str.append(tmpStr);
        }

        return str.toString();
    }

    public static String ArrayToString(Map<String, String[]> map) {
        String res = "";
        Iterator var2 = map.keySet().iterator();

        while(true) {
            while(var2.hasNext()) {
                String key = (String)var2.next();
                String[] values = (String[])map.get(key);
                if (values != null) {
                    res = res + key + "=[";
                    String[] var5 = values;
                    int var6 = values.length;

                    for(int var7 = 0; var7 < var6; ++var7) {
                        String value = var5[var7];
                        res = res + value + ",";
                    }

                    if (res.length() - res.lastIndexOf(",") == 1) {
                        res = res.substring(0, res.lastIndexOf(","));
                    }

                    res = res + "],";
                } else {
                    res = res + key + "=NULL,";
                }
            }

            if (res.length() - res.lastIndexOf(",") == 1) {
                res = res.substring(0, res.lastIndexOf(","));
            }

            return res;
        }
    }

    public static boolean checkVersion(String version) {
        if (version != null && !"".equals(version) && version.split("\\.").length == 3) {
            try {
                String[] numbers = version.split("\\.");

                for(int i = 0; i < numbers.length; ++i) {
                    Long num = Long.parseLong(numbers[i]);
                    if (num > 9999L || num < 0L) {
                        return false;
                    }
                }

                return true;
            } catch (Exception var4) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static String subString(String str, int end) {
        if (isEmpty(str)) {
            return str;
        } else {
            int length = str.length();
            return end >= length ? str : str.substring(0, end);
        }
    }

    public static void downloadFile(String file, HttpServletResponse response) {
        String filename = file.substring(file.lastIndexOf(File.separator) + 1);
        response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition", "attachment; filename=" + filename);

        try {
            BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buf = new byte[4096];

            while(bis.available() > 0) {
                int len = bis.read(buf);
                bos.write(buf, 0, len);
            }

            bos.flush();
            bos.close();
            bis.close();
        } catch (Exception var7) {
            var7.printStackTrace();
        }

    }

    public static String escapeCharacter(String source) {
        if (source != null && source.length() != 0) {
            if (escapeCharMap.size() == 0) {
                return source;
            } else {
                StringBuffer sb = new StringBuffer(source.length() + 100);
                StringCharacterIterator sci = new StringCharacterIterator(source);

                for(char c = sci.first(); c != '\uffff'; c = sci.next()) {
                    String character = String.valueOf(c);
                    if (escapeCharMap.containsKey(character)) {
                        character = (String)escapeCharMap.get(character);
                    }

                    sb.append(character);
                }

                return sb.toString();
            }
        } else {
            return source;
        }
    }

    public static int getByteCount(String str) {
        int len = 0;
        if (str == null) {
            return len;
        } else {
            for(int i = 0; i < str.length(); ++i) {
                int codePoint = str.codePointAt(i);
                if (codePoint > 255) {
                    len += 2;
                } else {
                    ++len;
                }
            }

            return len;
        }
    }

    public static boolean isDate(String str_input, String rDateFormat) {
        if (!isNull(str_input)) {
            SimpleDateFormat formatter = new SimpleDateFormat(rDateFormat);
            formatter.setLenient(false);

            try {
                formatter.format(formatter.parse(str_input));
                return true;
            } catch (Exception var4) {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isEmail(String email) {
        String check = "^([a-z0-9A-Z]+[-|\\._]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Matcher matcher = Pattern.compile(check).matcher(email);
        return matcher.matches();
    }

    public static String validCode(int length) {
        String validCodeStr = "";
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            validCodeStr = validCodeStr + random.nextInt(10);
        }

        return validCodeStr;
    }

    public static boolean isEmpty(String str) {
        return str == null || "".equals(str) || "null".equals(str);
    }

    public static boolean isNotEmpty(String str) {
        return str != null && !"".equals(str) && !"null".equals(str);
    }

    public static boolean isNull(Object str) {
        return str == null;
    }

    public static String null2Str(Object value) {
        return value != null && !"null".equals(value.toString()) ? value.toString() : "";
    }

    public static String null2Str(String value) {
        return value != null && !"null".equals(value) ? value.trim() : "";
    }

    public static final String[] split(String string, String delim) {
        StringTokenizer token = new StringTokenizer(string, delim);
        String[] result = new String[token.countTokens()];
        ArrayList tmp = new ArrayList();

        while(token.hasMoreTokens()) {
            tmp.add(token.nextToken());
        }

        tmp.toArray(result);
        return result;
    }

    public static Long stringToLong(String value) {
        value = null2Str(value);
        Long l;
        if ("".equals(value)) {
            l = 0L;
        } else {
            try {
                l = Long.valueOf(value);
            } catch (Exception var3) {
                l = 0L;
            }
        }

        return l;
    }

    public static String substr(String str, int byteCount) {
        if (str == null) {
            return null;
        } else {
            StringBuffer sb = new StringBuffer(str.length());
            int count = 0;

            for(int i = 0; i < str.length(); ++i) {
                int codePoint = str.codePointAt(i);
                char ch = str.charAt(i);
                if (codePoint > 255) {
                    count += 2;
                } else {
                    ++count;
                }

                if (count > byteCount) {
                    break;
                }

                sb.append(ch);
            }

            return sb.toString();
        }
    }

    public static boolean isContainsStrBySplit(String src, String split, String key) {
        if (isEmpty(src)) {
            return false;
        } else {
            String[] srcs = src.split(split);
            String[] var4 = srcs;
            int var5 = srcs.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String _src = var4[var6];
                if (_src.equals(key)) {
                    return true;
                }
            }

            return false;
        }
    }


    public static String encodeString(String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
        }

        return str;
    }

    public static String decodeString(String str) {
        try {
            str = URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException var2) {
            var2.printStackTrace();
        }

        return str;
    }

    public static String buildSqlByParam(String sql, Map<String, Object> params) {
        String name;
        String _value;
        for(Iterator it = params.keySet().iterator(); it.hasNext(); sql = sql.replaceAll(":" + name, _value)) {
            name = (String)it.next();
            Object value = params.get(name);
            _value = "";
            if (value instanceof Date) {
                _value = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(value);
            } else {
                _value = String.valueOf(value);
            }
        }

        return sql;
    }

    public static boolean isEmptyArray(String[] a) {
        return a == null || a.length == 0;
    }

    public static Date dateAfterMinut(int x) {
        new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(12, x);
        Date date = cal.getTime();
        return date;
    }

    public static void main(String[] args) {
        String s = "<p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">心理健康教育【婚姻家庭科普教育包含其中】，这其实是每一个心理学从业者最最基本的技能，在学会个案咨询之前就应该会讲课。通过讲课，一方面提升自己的口才和知识储备；另一方面也是最好的聚人气方式、获得社会大众了解、信任和接纳讲者的机会。当然，并非所有咨询师都具备讲师的条件， 除了个人的口才等因素之外，拥有自己独创并被大众喜爱的课程特别重要。而要想打造出满足社会大众需求的课程产品，就需要讲者具备系统性、科学性的专业知识。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-family: 仿宋; font-size: 14px;\">在此，我们隆重推出中国社会科学院婚姻家庭研究与教育专家陈一筠教授的培训课程，供大家选择。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 黑体; color: red;\">陈一筠“婚姻家庭讲师”高级研修班</span><span style=\"font-size: 14px; font-family: 仿宋;\">，将传授陈教授几十年的研究与教育实践成果，从东西方社会文化的差异中探讨中国婚姻家庭演变的趋势、现状、存在的问题与解决方案，着力回答社会大众在婚姻家庭生活中的问题以及澄清父母在孩子教育理念与方法上存在的误区。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">课程全部内容的分享，需要</span><span style=\"font-size: 14px; font-family: 黑体; color: red;\">五天四晚</span><span style=\"font-size: 14px; font-family: 仿宋;\">的封闭训练，不仅适合于心理学工作者、婚姻家庭咨询师群体，同时适合普通的社会大众。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">【陈一筠教授简介】</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-family: 仿宋; font-size: 14px;\">陈一筠，女，1940年4月出生于四川省筠连县，成长于重庆市。1964年毕业于北京大学俄罗斯语言文学系。中国社会科学院研究员，青春期健康与情感教育专家；中国陶行知研究会青春期教育专业委员会名誉主任；中国婚姻家庭研究会专家委员会副主任。1993年获国务院授予的“社会科学领域特殊贡献专家 ”荣誉证书并享受政府特殊津贴。曾任《国外社会学》主编。出版了《现代男女的婚恋与性》、《两性世界何处去》、《婚姻家庭的科学咨询》、《走向婚姻》、《天涯何处觅佳偶？》、《婚姻旅程探幽》、《解读性的奥秘》等专著：主编了《青苹果丛书》（包括《男孩女孩长大了》、《少男少女知多少》、《爱在青春期》、《引领孩子度青春》等），其独到的学术见解和解决实际问题的方法，被社会各界人士广为接受和传播，深受广大专业人员、中青年读者和青少年及其家长们的喜爱。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-weight: bold; font-size: 14px; font-family: 黑体;\">课程大纲</span><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">第一天</span></strong><strong><span style=\"font-size: 14px; font-family: 宋体; color: red;\">&nbsp;&nbsp;</span></strong><strong>&nbsp;</strong><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">现代婚姻向何处去？</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></strong><strong><span style=\"font-size: 14px; font-family: 楷体;\">——社会转型期的婚恋趋势、问题、原因和对策</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第一讲：家庭是我国社会保障的基点</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第二讲：美国：婚姻家庭衰退、经济危机和美国梦的幻灭</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第三讲：中国传统型婚姻的功能及其维系纽带</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第四讲：现代婚姻的功能转换和维系因素对夫妻关系的挑战</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第五讲：婚姻成败对妇女儿童及社会的影响</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第六讲：影响现代婚恋关系的社会心理因素</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">自由择偶的心理风险——机遇的制约和变化的考验</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">浪漫激情为何不是婚姻成功的保证？</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span style=\"font-size: 14px; font-family: 仿宋;\">——难以把握的非理性：本能性、主观性、虚幻性</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">市场经济时代的社会环境因素对婚恋的影响</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第七讲：中外离婚趋势比较与离婚率的统计方法</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第八讲：离婚因素解析（社会、经济、道德、健康等层面）</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第九讲：关于对策的思考与建议（法制、教育、咨询救助及其他）</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">第二天</span></strong><strong><span style=\"font-size: 14px; font-family: 宋体; color: red;\">&nbsp;&nbsp;</span></strong><strong>&nbsp;</strong><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">婚姻的生命周期与夫妻关系调适（上）</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第一讲：何谓“婚姻的生命周期”？社会学如何划分“生命周期”？</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第二讲：婚姻幼稚期的两次角色转变（结婚头5年）</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">从恋人到夫妻的角色变化与心理适应</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">从夫妻到父母的亲职压力与夫妻关系</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">姻亲矛盾的影响因素与调适智慧</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第三讲：婚姻成长期的双重角色冲突（婚后5--15年）</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">性别角色的冲突</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">A.</span><span style=\"font-size: 14px; font-family: 仿宋;\">男主外、女主内天然合理吗？</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">B.</span><span style=\"font-size: 14px; font-family: 仿宋;\">“二保一”和全职太太的困局</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">工作世界与家庭世界的矛盾</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">A.</span><span style=\"font-size: 14px; font-family: 仿宋;\">以效益代替公平的市场经济法则与价值观</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">B.</span><span style=\"font-size: 14px; font-family: 仿宋;\">职场压力、合理家务分担与夫妻平等</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">C.</span><span style=\"font-size: 14px; font-family: 仿宋;\">“女主外，男主内”如何？</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第三讲：中年夫妻的多事之秋（结婚15--35年）</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">审美疲劳与心理疲劳在夫妻关系中的反映</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">妻子更年期与丈夫的心理适应及角色扮演</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">夫妻性生活失调的原因与对策</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">4.</span><span style=\"font-size: 14px; font-family: 仿宋;\">更年期遭遇青春期——“两期战争”的平息之道</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">5.</span><span style=\"font-size: 14px; font-family: 仿宋;\">妻子更年期的特殊保健与护理</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; color: red;\">&nbsp;</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">第三天</span></strong><strong><span style=\"font-size: 14px; font-family: 宋体; color: red;\">&nbsp;</span></strong><strong>&nbsp;</strong><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">婚姻的生命周期与夫妻关系调适（下）</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第一讲：夕阳无限好</span></strong><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;</span></strong><strong>&nbsp;</strong><strong><span style=\"font-size: 14px; font-family: 黑体;\">人间重晚情</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">老年夫妻的双重角色丧失及其心理适应</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">老年的健康与疾病</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">老年夫妻的情感与性</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">4.</span><span style=\"font-size: 14px; font-family: 仿宋;\">丧偶老人的再婚与同居</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第二讲：现代社会的男女交往与“婚外情”现象解析</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">现代已婚男女的大千世界与两人世界</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">异性交往中的“磁场反应”与情感滋养</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">夫妻之间可以有隐私吗</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">4.</span><span style=\"font-size: 14px; font-family: 仿宋;\">现代夫妻可以有隐私吗？</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">5.</span><span style=\"font-size: 14px; font-family: 仿宋;\">危险的“迷恋”——婚外情的信号</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">6.</span><span style=\"font-size: 14px; font-family: 仿宋;\">设防“办公室恋情”</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">7.</span><span style=\"font-size: 14px; font-family: 仿宋;\">男女在对待“婚外情事故”上的态度差异及其原因</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">8.</span><span style=\"font-size: 14px; font-family: 仿宋;\">外遇有救吗？——关于配偶“出格”的原因、性质与对策</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第三讲：婚姻生活与性和谐</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">婚姻关系的三要素（激情、承诺、性生活）</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">性爱与婚姻</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">夫妻性生活障碍：原因与对策</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">4.</span><span style=\"font-size: 14px; font-family: 仿宋;\">关于性取向——同性恋、双性恋及其他</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">第四天</span></strong><strong><span style=\"font-size: 14px; font-family: 宋体; color: red;\">&nbsp;</span></strong><strong>&nbsp;</strong><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">青春健康与青年男女的恋爱择偶</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第一讲：解读青春密码——青春健康与“早恋”</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">青春期的释义与三大性证</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">青春期少男少女的双重困顿</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">青春期教育的狭义和广义层面</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">4.</span><span style=\"font-size: 14px; font-family: 仿宋;\">青春期教育的宗旨与价值观</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">5.</span><span style=\"font-size: 14px; font-family: 仿宋;\">爱在青春期——关于异性友情与爱情</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">6.</span><span style=\"font-size: 14px; font-family: 仿宋;\">家庭是培育爱的学校</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">7.</span><span style=\"font-size: 14px; font-family: 仿宋;\">关于少男少女的交往——“早恋”还是“早练”？</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">8.</span><span style=\"font-size: 14px; font-family: 仿宋;\">青春少男少女渴望隐私关怀——少女怀孕、堕胎与杀婴</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">9.</span><span style=\"font-size: 14px; font-family: 仿宋;\">建立三道方火墙，维护未成年人的性健康与生殖健康</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">10.</span><span style=\"font-size: 14px; font-family: 仿宋;\">生命教育视野下的青春期教育</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal;\"><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;&nbsp;&nbsp;</span></strong><strong><span style=\"font-size: 14px; font-family: 黑体;\">第二讲 天涯何处觅知音——</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></strong><strong><span style=\"font-size: 14px; font-family: 黑体;\">关于现代男女的恋爱、择偶、同居与性健康</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">婚前异性交往的性质与功能（从友情到爱情）</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">自由择偶与婚姻责任（机遇和变化的双重风险）</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">从一见钟情到承诺终生（非理性与理性的博弈）</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">4.</span><span style=\"font-size: 14px; font-family: 仿宋;\">选择人生伴侣要考虑的主要条件（文化、价值观、性格与年龄）</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">5.</span><span style=\"font-size: 14px; font-family: 仿宋;\">对婚前交往过程的评估与结婚的审慎抉择</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">6.</span><span style=\"font-size: 14px; font-family: 仿宋;\">关于婚前同居与“试婚”</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">7.</span><span style=\"font-size: 14px; font-family: 仿宋;\">选择配偶犹如选择原材料，幸福婚姻是创造的成果</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">8.</span><span style=\"font-size: 14px; font-family: 仿宋;\">婚前检查、婚房、婚礼与蜜月</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\"><br/></span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">第五天</span></strong><strong><span style=\"font-size: 14px; font-family: 宋体; color: red;\">&nbsp;</span></strong><strong>&nbsp;</strong><strong><span style=\"font-size: 14px; font-family: 黑体; color: red;\">婚姻家庭辅导与救助</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第一讲：婚姻是爱情的坟墓吗？</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第二讲：病态爱情种种</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第三讲：男女性障碍的医学与心理学解析</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第四讲：我们需要婚前契约和夫妻AA制吗？</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第五讲：男人出轨“三部曲”</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第六讲：夫妻吵架</span></strong><strong><span style=\"font-size: 14px; font-family: 宋体;\">&nbsp;</span></strong><strong>&nbsp;</strong><strong><span style=\"font-size: 14px; font-family: 黑体;\">约法三章</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第七讲：关于家庭暴力的心理与法律干预</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第八讲：关于离婚的社会救助——“试离婚”如何？</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">第九讲：关于完善我国婚姻家庭相关政策法规的探讨</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\"><br/></span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">课程附加值：</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-family: 仿宋; font-size: 14px;\">所有参加陈一筠教授课程的心理咨询师、婚姻家庭咨询师学员，赠送华众健康集团董事长、国内著名婚姻家庭问题咨询专家因缘老师《婚姻家庭方向品牌课程研发秘籍》系统培训一次，并协助学员研发自己的课程，价值8000元，帮助参训学员打造出属于自己的课程体系，建构专属的课程产品矩阵。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">招生对象：</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">有志于从事婚姻家庭教育与咨询的社会工作者、教师、医生</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">具有心理咨询师相关资格证书【心理咨询师等级证书、婚姻家庭咨询师等级证书等】，有待提高自己执业能力的专业人士</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">希望学习爱情知识的青年男女，想要获得经营和维护婚姻家庭的经验与智慧，提升自己婚姻家庭生活质量的夫妻，渴望掌握青春期孩子成长规律，正确引领孩子度青春的广大中小学生家长。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><strong><span style=\"font-size: 14px; font-family: 黑体;\">培训目的和发展机遇：</span></strong></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">1.</span><span style=\"font-size: 14px; font-family: 仿宋;\">建立、完善“中国婚姻家庭援助联盟”合作体系，培训一批能够讲授婚姻智慧或者亲子教育课程、能够推动当地婚姻家庭教育咨询事业发展的成员。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">2.</span><span style=\"font-size: 14px; font-family: 仿宋;\">解决学员自身在经营婚姻和教育孩子方面可能存在的问题。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">3.</span><span style=\"font-size: 14px; font-family: 仿宋;\">为各地的家长学校系统培训讲师。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">4.</span><span style=\"font-size: 14px; font-family: 仿宋;\">建立“爱情与人生”讲师人才库，优秀学员直接与公司签订就业合同，加入“爱情与人生婚姻家庭讲师团”。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\">5.</span><span style=\"font-size: 14px; font-family: 仿宋;\">经陈一筠教授和“爱情与人生婚姻家庭讲师团”授权，获得相关课程的讲授资格的学员，可在某地区或全国开展授权课程的收费培训。</span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"font-size: 14px; font-family: 仿宋;\"><br/></span></p><p style=\"margin-top: 4px; margin-bottom: 4px; white-space: normal; text-indent: 33px;\"><span style=\"color: rgb(255, 0, 0);\"><span style=\"font-family: 黑体, SimHei;\"><strong><span style=\"font-size: 14px;\">关</span></strong></span><span style=\"color: rgb(255, 0, 0); text-indent: 33px; font-family: 黑体, SimHei;\"><strong><span style=\"font-size: 14px;\">于报名：</span></strong><span style=\"font-size: 14px;\">1、</span></span><span style=\"color: rgb(255, 0, 0); text-indent: 33px; font-size: 14px; font-family: 仿宋;\">付费后，联系因缘老师，微信：love80241；QQ：329660457；2、填写地址时，正常填写就可以，在“备注说明”一栏，填写上QQ号或者微信号，便于客服联系</span><span style=\"font-size: 14px; font-family: 仿宋;\"></span></span></p>";
        System.out.println(Html2Text(s));
    }

    public static String getXmlValue(String text, String key) throws Exception {
        if (!text.contains(key)) {
            throw new Exception("不包含此标签");
        } else {
            int index = text.indexOf(key);
            return text.substring(index + key.length(), text.indexOf("</", index));
        }
    }

    public static String deleteCDATA(String text) throws Exception {
        return text.substring(text.indexOf("A[") + 2, text.lastIndexOf("]]"));
    }

    public static String formatDouble(double value) {
        DecimalFormat df = new DecimalFormat("######0.00");
        return df.format(value);
    }

    public static String getIpAddr(HttpServletRequest request) {
        String ip = "";
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    public static String mapToGet(Map<String, Object> req) {
        String ret = "";

        String key;
        for(Iterator it = req.keySet().iterator(); it.hasNext(); ret = ret + key + "=" + req.get(key) + "&") {
            key = (String)it.next();
        }

        return ret.substring(0, ret.length() - 1);
    }

    public static String mapToXml(Map<String, Object> req) {
        String ret = "";

        String key;
        for(Iterator it = req.keySet().iterator(); it.hasNext(); ret = ret + "<" + key + ">" + req.get(key) + "</" + key + ">") {
            key = (String)it.next();
        }

        return ret;
    }

    public static String Html2Text(String inputString) {
        String htmlStr = inputString;
        String textStr = "";

        try {
            String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
            String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
            String regEx_html = "<[^>]+>";
            Pattern p_script = Pattern.compile(regEx_script, 2);
            Matcher m_script = p_script.matcher(htmlStr);
            htmlStr = m_script.replaceAll("");
            Pattern p_style = Pattern.compile(regEx_style, 2);
            Matcher m_style = p_style.matcher(htmlStr);
            htmlStr = m_style.replaceAll("");
            Pattern p_html = Pattern.compile(regEx_html, 2);
            Matcher m_html = p_html.matcher(htmlStr);
            htmlStr = m_html.replaceAll("");
            textStr = htmlStr;
        } catch (Exception var12) {
        }

        return textStr.replaceAll("&nbsp;", "");
    }

    public static String getModel(String ua) {
        if (ua == null) {
            return "android";
        } else if (ua.toLowerCase().contains("android")) {
            return "android";
        } else {
            return ua.toLowerCase().contains("iphone") ? "iphone" : "android";
        }
    }

    public static Object changeIOSFontSize(String str) {
        try {
            Pattern p = Pattern.compile("font-size: ");

            Integer size;
            for(Matcher m = p.matcher(str); m.find(); str = str.substring(0, m.start()) + "font-size: " + size + str.substring(m.start() + 13)) {
                size = Integer.parseInt(str.substring(m.start() + 11, m.start() + 13)) * 3;
            }
        } catch (NumberFormatException var4) {
            var4.printStackTrace();
        }

        return str;
    }

    static {
        escapeCharMap.put("<", "&lt;");
        escapeCharMap.put(">", "&gt;");
        escapeCharMap.put("&", "&amp;");
        escapeCharMap.put("\"", "&quot;");
        escapeCharMap.put("'", "&apos;");
    }
}