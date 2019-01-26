package com.team.manage.common.util;

import com.team.manage.common.util.secert.SecretException;
import com.team.manage.common.util.secert.SecretFactory;
import com.team.manage.enums.SecretType;
import org.apache.commons.lang3.StringUtils;


import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String的常用共用方法
 *
 * @author bjyuan
 */
public class StringUtil {

    /**
     * 隐藏手机号码
     *
     * @param str
     * @return
     */
    public static String hidePhone(String str) {
        try {
            if (str.length() != 11) {
                return str;
            }
            return str.substring(0, str.length() - (str.substring(3)).length())
                    + "****" + str.substring(7);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /**
     * 隐藏银行卡号
     *
     * @param bankCard
     * @return
     */
    public static String hideBankCard(String bankCard) {
        String hideBankCard = "********" + bankCard.substring(bankCard.length() - 4);
        if (bankCard.length() > 10) {
            hideBankCard = bankCard.substring(0, 4) + hideBankCard;
        }
        return hideBankCard;
    }


    /**
     * 中文、数字、字母 判断
     *
     * @param str
     * @return
     */
    public static boolean isLetterDigitOrChinese(String str) {
        try {
            String regex = "^[a-z0-9A-Z\u4e00-\u9fa5]+$";
            return str.matches(regex);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 验证手机号码
     *
     * @param mobileNumber
     * @return
     */
    public static boolean checkMobileNumber(String mobileNumber) {
        try {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(mobileNumber);
            if (mobileNumber.length() == 11 && isNum.matches()) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 去空并且去null
     *
     * @param str
     * @return
     */
    public static String dealElementText(String str) {
        return str == null ? "" : str.trim();
    }

    /**
     * 判断字符串是否为空，或者为null
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    /**
     * 判断多个字符串是否含有空
     *
     * @author: xuk
     * @date: 2018/2/7
     */
    public static boolean anyEmpty(String... strings) {
        for (String s : strings) {
            if (isEmpty(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断字符串是否为空，或者为null
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String str;
    public static final String EMPTY_STRING = "";

    private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    /**
     * 转换字节数组为16进制字串
     *
     * @param b 字节数组
     * @return 16进制字串
     */
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String MD5Encode(String origin) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteArrayToHexString(md.digest(resultString
                    .getBytes()));
        } catch (Exception ex) {
        }
        return resultString;
    }

    /**
     * @param content
     * @return
     * @description 获取一段字符串的字符个数（包含中英文，一个中文算2个字符）
     */

    public static int getCharacterNum(final String content) {

        if (null == content || "".equals(content)) {

            return 0;

        } else {

            return (content.length() + getChineseNum(content));

        }

    }

    /**
     * @param s
     * @return
     * @description 返回字符串里中文字或者全角字符的个数
     */

    public static int getChineseNum(String s) {

        int num = 0;

        char[] myChar = s.toCharArray();

        for (int i = 0; i < myChar.length; i++) {

            if ((char) (byte) myChar[i] != myChar[i]) {

                num++;

            }

        }

        return num;

    }



    /**
     * 两个数字生成百分比
     */
    public static String getPercent(int x, int total) {
        if (total == 0) {
            return "0.00%";
        }
        String result = "";//接受百分比的值

        double x_double = x * 1.0;
        double tempresult = x_double / total;
        //NumberFormat nf   =   NumberFormat.getPercentInstance();     注释掉的也是一种方法
        //nf.setMinimumFractionDigits( 2 );        保留到小数点后几位
        DecimalFormat df1 = new DecimalFormat("0.00%");    //##.00%   百分比格式，后面不足2位的用0补齐
        //result=nf.format(tempresult);
        result = df1.format(tempresult);
        return result;
    }

    /**
     * 两个double数字生成百分比
     * @param format  百分比格式,如0.00%
     */
    public static String getPercent(double x, double total, String format) {
        if (total == 0) {
            return "0.00%";
        }
        String result = "";//接受百分比的值

        double x_double = x * 1.0;
        double tempresult = x_double / total;
        //NumberFormat nf   =   NumberFormat.getPercentInstance();     注释掉的也是一种方法
        //nf.setMinimumFractionDigits( 2 );        保留到小数点后几位
        DecimalFormat df1 = new DecimalFormat(format);    //##.00%   百分比格式，后面不足2位的用0补齐
        //result=nf.format(tempresult);
        result = df1.format(tempresult);
        return result;
    }

    /**
     * 隐藏身份证
     *
     * @param str
     * @return
     */
    public static String hideCard(String str) {
        try {
            if (StringUtils.isBlank(str)) {
                return str;
            }
            if (str.length() == 18) {
                return str.substring(0,
                        str.length() - (str.substring(1)).length())
                        + "****************" + str.substring(17);
            } else {
                return str.substring(0,
                        str.length() - (str.substring(1)).length())
                        + "*************" + str.substring(14);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    /**
     * 判断是否是数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    /**
     * MD5加密
     *
     * @param str
     * @return
     */
    public static String getMd5(String str) {
        String secretStr = "";
        try {
            secretStr = SecretFactory.getInstance().getSecret(SecretType.MD5).encode(str);
        } catch (SecretException e) {
            e.printStackTrace();
        }
        return secretStr;
    }

    /**
     * MD5加密以某个编码
     *
     * @param str
     * @param
     * @return
     * @author xuk
     */
    public static String getMd5(String str, String coded) {
        String secretStr = "";
        try {
            secretStr = SecretFactory.getInstance().getSecret(SecretType.MD5).encode(str, coded);
        } catch (SecretException e) {
            e.printStackTrace();
        }
        return secretStr;
    }

    /**
     * 获取随访账号前缀
     *
     * @param account
     * @return
     */
    public static String getPrefix(String account) {
        return account.substring(0, account.indexOf("_"));
    }

    /**
     * 获取蓝牛号数字
     *
     * @param hugId
     * @return
     */
    public static Integer getHugNo(String hugId) {
        return Integer.parseInt(hugId.substring(2));
    }

    /**
     * 比较蓝牛号数字 hugId1>=hugId2 true
     *
     * @param hugId1
     * @param hugId2
     * @return
     */
    public static boolean compareHugIdNo(String hugId1, String hugId2) {
        if (getHugNo(hugId1) >= getHugNo(hugId2)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @Author:yudongdong
     * @Description: 将字符串以，号分开 组成list返回
     * @param:
     * @Date: 19:47 2017-2-13
     */
    public static List<String> splitListByString(String str) {
        List<String> lists = new ArrayList<String>();
        if (str != null && !"".equals(str)) {
            String[] strs = str.split(",|，");
            String strParam = "";
            if (strs.length > 0) {
                for (int i = 0; i < strs.length; i++) {
                    strParam = strs[i];
                    if (strParam != null && !"".equals(strParam)) {
                        lists.add(strParam);
                    }
                }
            }
        }
        return lists;
    }

    /**
     * 将字符串以特定的字符分隔组装成list
     * @param str
     * @param separator
     * @return
     */
    public static List<String> splitListByString(String str, String separator) {
        List<String> strList = new ArrayList();
        if (StringUtils.isNotBlank(str)) {
            String[] strs = str.split(separator);
            String strParam;
            if (strs.length > 0) {
                for (int i = 0; i < strs.length; i++) {
                    strParam = strs[i];
                    if (StringUtils.isNotBlank(strParam)) {
                        strList.add(strParam);
                    }
                }
            }
        }
        return strList;
    }

    /**
     * 字符串转Double
     *
     * @param str
     * @return
     */
    public static Double StringToDouble(String str) {
        if (str == null) {
            return 0.0;
        } else {
            return Double.parseDouble(str);
        }
    }

    /**
     * map取值  转换为字符串
     *
     * @param obj
     * @return
     * @throws Exception
     */
    public static String objTostr(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    /**
     * 字符串数值相加
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String StringAdd(String num1, String num2) {
        if (num1 == null || "".equals(num1.trim()))
            num1 = "0.0";
        if (num2 == null || "".equals(num2.trim()))
            num2 = "0.0";
        BigDecimal bd1 = new BigDecimal(num1.trim());
        BigDecimal bd2 = new BigDecimal(num2.trim());
        NumberFormat nf = NumberFormat.getInstance();
        nf.setGroupingUsed(false);
        Double d = bd1.add(bd2).doubleValue();
        return d == 0 ? null : String.valueOf(nf.format(d));
    }

    /**
     * @Author:yudongdong
     * @Description: 中文编码
     * @param:
     * @Date: 19:44 2017-3-2
     */
    public static String getEncoder(String str) {
        String str1 = "";
        try {
            str1 = URLEncoder.encode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str1;
    }

    /**
     * @Author:yudongdong
     * @Description: 中文解码
     * @param:
     * @Date: 19:44 2017-3-2
     */
    public static String getDecode(String str) {
        String str1 = "";
        try {
            str1 = URLDecoder.decode(str, "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str1;
    }



    /**
     * @Description: 去除 字符串里面 所有非汉字内容
     * @param:
     * @return:
     */
    public static String clearNotChinese(String buff) {
        String tmpString = buff.replaceAll("(?i)[^a-zA-Z0-9\u4E00-\u9FA5]", "");//去掉所有中英文符号
        char[] carr = tmpString.toCharArray();
        for (int i = 0; i < tmpString.length(); i++) {
            if (carr[i] < 0xFF) {
                carr[i] = ' ';//过滤掉非汉字内容
            }
        }
        return String.copyValueOf(carr).trim().replace(" ", "");
    }

    /**
     * 根据时间判断上下午 1-上午 2-下午
     *
     * @param time
     * @return
     */
    public static String isAmOrPm(String time) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time.substring(0, 2)));
        calendar.set(Calendar.MINUTE, Integer.parseInt(time.substring(3, 5)));
        return (calendar.get(Calendar.AM_PM) == 0 ? "1" : "2");
    }


    /**
     * 根据身份证获取性别
     *
     * @param idCard
     * @return 1男2女9其他
     */
    public static int getSexBYIdCard(String idCard) {
        try {
            if (idCard != null) {
                String lastValue = "";
                if (idCard.length() == 15) {
                    lastValue = idCard.substring(idCard.length() - 1, idCard.length());
                } else if (idCard.length() == 18) {
                    lastValue = idCard.substring(idCard.length() - 2, idCard.length() - 1);
                } else {
                    return 9;
                }
                int sex;
                if (lastValue.trim().toLowerCase().equals("x") || lastValue.trim().toLowerCase().equals("e")) {
                    return 1;
                } else {
                    sex = Integer.parseInt(lastValue) % 2;
                    return sex == 0 ? 2 : 1;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 9;
    }

    /**
     * 获取请求路径后的参数组装成map返回
     *
     * @param param
     * @return
     */
    public static Map<String, Object> getUrlParams(String param) {
        Map<String, Object> map = new HashMap<>(0);
        if (StringUtils.isBlank(param)) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

    // MD5转换
    public static String encryptToMD5(String password) {
        byte[] digesta = null;
        String result = null;
        try {

            // 得到一个MD5的消息摘要
            MessageDigest mdi = MessageDigest.getInstance("MD5");
            // 添加要进行计算摘要的信息
            mdi.update(password.getBytes("utf-8"));
            // 得到该摘要
            digesta = mdi.digest();
            result = byteToHex(digesta);
        } catch (NoSuchAlgorithmException e) {

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
        return result;
    }
    /**
     * 将二进制转化为16进制字符串
     */
    public static String byteToHex(byte[] pwd) {
        StringBuilder hs = new StringBuilder("");
        String temp = "";
        for (int i = 0; i < pwd.length; i++) {
            temp = Integer.toHexString(pwd[i] & 0XFF);
            if (temp.length() == 1) {
                hs.append("0").append(temp);
            } else {
                hs.append(temp);
            }
        }
        return hs.toString().toUpperCase();
    }

    public static void main(String[] args) {
        //System.out.println(hideBankCard("83836267383838383"));
        System.out.println(splitListByString("123x，1546d，123，是的"));
    }
}
