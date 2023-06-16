package com.example.elesigna;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class DateUtil {
    private static final DateFormat FORMATTER = SimpleDateFormat.getDateInstance();

    public static String getWeekOfDate(Date date) {
        String[] weekOfDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekOfDays[w];
    }

    //chengjiahang  年月日
    public static String getDateResultYMD(Date date) {
        StringBuffer sbf = new StringBuffer(getStringDate(date));
        return sbf.toString();
    }


    public static Date getPreviousDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    //  获得当天时间
    public static Date getNextDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        // calendar.add(Calendar.DATE,0);
        return calendar.getTime();
    }

    public static String getHMTime(long s) {
        DateFormat formatter = new SimpleDateFormat("HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getMonthAndDay(long s) {
        DateFormat formatter = new SimpleDateFormat("MM月dd日");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getMonthAndDay2(long s) {
        DateFormat formatter = new SimpleDateFormat("MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getMonthAndDay3(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());

    }

    public static String getMonthAndDay5(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getStringDate3(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getStringDateM(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getMonthAndDay4(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy年M月d日");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getYearMonthDay4(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy年M月d日");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getMonthAndMD(long s) {
        DateFormat formatter = new SimpleDateFormat("M月d日");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getStringDate_YMd(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }

    public static String getStringDate_YMd2(long s) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-ddHH:mm");
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(s);
        return formatter.format(calendar.getTime());
    }


    public static String getDurationTime(long mss) {
        long hours = mss / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        if (minutes == 0) {
            return hours + "时";
        }
        return hours + "时" + minutes + "分";
    }

    public static String getStringDate(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(data);
        return dateString;
    }

    public static String getStringDate2(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dateString = formatter.format(data);
        return dateString;
    }

    public static String getStringDate3(Date data) {
        if (data == null) {
            return "";
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String dateString = formatter.format(data);
        return dateString;
    }

    public static String getStringDate4(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd HH:mm");
        String dateString = formatter.format(data);
        return dateString;
    }

    public static String getStringYear(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        String dateString = formatter.format(data);
        return dateString;
    }

    public static String getStringMonth(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("M");
        String dateString = formatter.format(data);
        return dateString;
    }

    public static String getStringDay(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("d");
        String dateString = formatter.format(data);
        return dateString;
    }

    public static boolean isSameDay(Date day1, Date day2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ds1 = sdf.format(day1);
        String ds2 = sdf.format(day2);
        if (ds1.equals(ds2)) {
            return true;
        } else {
            return false;
        }
    }

    public static Date StringToDate(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date StringToDateS(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    // cjh
    public static Date StringToTime(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date StringToDate2(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String DateDelSecond(String dateStr) {
        String time = "";
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
            time = sdf1.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    public static Date StringToDate3(String dateStr) {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 比较两个日期之间的大小
     *
     * @param d1
     * @param d2
     * @return 前者大于后者返回true 反之false
     */
    public static boolean compareDate(Date d1, Date d2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        int result = c1.compareTo(c2);
        if (result >= 0)
            return true;
        else
            return false;
    }

    public static boolean compareDateofString(String date1, String date2) {
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = stringToDate(date1, "yyyy-MM-dd");
            d2 = stringToDate(date2, "yyyy-MM-dd");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(d1);
        c2.setTime(d2);

        int result = c1.compareTo(c2);
        if (result > 0)
            return true;
        else
            return false;
    }


    public static String getCrossDays(int days) {
        String s = "";
        switch (days) {
            case 0:
                break;
            case 1:
                s = "(次日)";
                break;
            default:
                days = days + 1;
                s = "(第" + days + "日)";
                break;
        }
        return s;
    }

    //  站站查询的详情 ListView  下方时间  去掉：  加小时、分
    public static String SetDateTime(String settime) {

        String s = settime;
        String str = s.replace(":", "");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.insert(2, "小时");

        String setDateTime = sb.toString() + "分";
        return setDateTime;
    }

    public static String SetDateTime3(String settime) {
        StringBuilder sb = new StringBuilder();
        sb.append(settime).append(" ");
        sb.insert(4, "-");
        sb.insert(7, "-");
        String setDateTime = sb.toString();
        return setDateTime;
    }

    // 去年月日  加-号
    public static String SetDateTime4(String settime) {
        String s = settime;
        String str = s.replace("年", "").replace("月", "").replace("日", "");

        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.insert(4, "-");
        sb.insert(7, "-");
        String setDateTime = sb.toString();

        return setDateTime;
    }

    // 去-号  加年月日
    public static String SetDateTime6(String settime) {
        String[] str = settime.split("-");
        if (str.length == 3) {
            settime = str[0] + "年" + str[1] + "月" + str[2] + "日";
        }
        return settime;
    }

    // 去年月日  加-号
    public static String SetDateTimeCamera(String settime) {

        String[] names1 = settime.split("年");
        if (names1.length < 2) {
            return settime;
        }
        String namesa = names1[0] + "-" + names1[1];
        String[] names2 = namesa.split("月");
        String namesb = names2[0] + "-" + names2[1];

        String namesc = namesb.replace("日", "");


        String[] aaaa = namesc.split("-");
        String yue = "";
        String ri = "";
        if (aaaa[1].length() == 1) {
            yue = "0" + aaaa[1];
        } else {
            yue = aaaa[1];
        }
        if (aaaa[2].length() == 1) {
            ri = "0" + aaaa[2];
        } else {
            ri = aaaa[2];
        }

        String newString = aaaa[0] + "-" + yue + "-" + ri;


//        StringBuilder sb = new StringBuilder();
//        sb.append(str);
//        sb.insert(4, "-");
//        sb.insert(7, "-");

//        String setDateTime = sb.toString();

        return newString;
    }

    // RectCameraAddTripActivity 的跳转AddTripCC_PopupWindow 绑定确认框 传的参数
    // 2017年4月22日  去掉年月日， 加-号 2017-4-20
    public static String SetDateTime5(String settime) {
        String s = settime;
        String str = s.replace("年", "").replace("月", "").replace("日", "");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.insert(4, "-");
        sb.insert(6, "-");
        String setDateTime = sb.toString();
        return setDateTime;
    }


    public static String SetDateTime2(String setdate) {
        StringBuilder sb = new StringBuilder();
        sb.append(setdate);
        sb.insert(4, "_");
        sb.insert(7, "_");
        String setDateTime = sb.toString();
        return setDateTime;
    }

    public static String getToday() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateNowStr = sdf.format(d);
        Log.e("Today获得今天时间>>>>>>>", dateNowStr + "");
        return dateNowStr;
    }

    public static String Today2() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
        String dateNowStr = sdf.format(d);
        Log.e("Today获得今天时间>>>>>>>", dateNowStr + "");
        return dateNowStr;
    }

    public static String TodayM() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String dateNowStr = sdf.format(d);
        Log.e("TodayM获得今天时间>>>>>>>", dateNowStr + "");
        return dateNowStr;
    }

    public static String TodayS() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("M月d日");
        String dateNowStr = sdf.format(d);
        Log.e("TodayM获得今天时间>>>>>>>", dateNowStr + "");
        return dateNowStr;
    }

    public static String TodayHZ() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
        String dateNowStr = sdf.format(d);
        Log.e("TodayHZ获得今天时间>>>>>>>", dateNowStr + "");
        return dateNowStr;
    }

    public static String TodayNYR() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        String dateNowStr = sdf.format(d);
        Log.e("TodayHZ获得今天时间>>>>>>>", dateNowStr + "");
        return dateNowStr;
    }

    public static String TodayYM() {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String dateNowStr = sdf.format(d);
        Log.e("TodayHZ获得今天时间>>>>>>>", dateNowStr + "");
        return dateNowStr;
    }

    public static boolean isValidDate(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    // 将 2016-04-19 格式转换为   年4月19日
    public static String SetNYR(String str) {
        String Str = str.substring(6);
        Str.replace("-", "");
        String date = Str + "日";
        StringBuffer strb = new StringBuffer(date);
        strb.deleteCharAt(1).toString();
        strb.insert(1, "月");
        String newDate = strb.toString();
        return newDate;
    }

    public static int in = 0;

    // 2017-04-16字符串 进来转换Date 传个int-day进来 传几就加几天  return 2017-04-16日期格式的字符串出去   （字符串转Date加天数）
    public static String AddNumberDate(String DateString, String format, int day) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date cd = sdf.parse(DateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cd);
        calendar.add(calendar.DATE, day);
        cd = calendar.getTime();
        //   Log.e("AddNumberDate转时间格式", getStringDate(cd) + "");
        return getStringDate(cd);
    }

    // 2017-04-16字符串 进来转换Date 加1天 return   （字符串转Date加天数）
    public static String AddDatejia(String DateString, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date cd = sdf.parse(DateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cd);
        calendar.add(calendar.DATE, 1);
        cd = calendar.getTime();
        //  Log.e("AddDatejia转时间格式", getStringDate(cd) + "");
        return getStringDate(cd);
    }

    public static String AddDatejian(String DateString, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date cd = sdf.parse(DateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cd);
        calendar.add(calendar.DATE, -1);
        cd = calendar.getTime();
        //  Log.e("AddDatejian转时间格式", getStringDate(cd) + "");
        return getStringDate(cd);
    }

    public static String DeleteOneDate(String DateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date cd = sdf.parse(DateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cd);
        calendar.add(calendar.DATE, -1);
        cd = calendar.getTime();
        // Log.e("DeleteOneDate转时间格式", getStringDate(cd) + "");
        return getStringDate2(cd);
    }

    public static String AddDatejian2(String DateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date cd = sdf.parse(DateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cd);
        calendar.add(calendar.DATE, -10);
        cd = calendar.getTime();
        // Log.e("AddDatejian2转时间格式", getStringDate2(cd) + "");
        return getStringDate2(cd);
    }

    // 2017-04-16字符串 进来转换Date 加update天 return   （字符串转Date加天数）
    public static String AddDate(String DateString, String format, int update) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date cd = sdf.parse(DateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cd);
        calendar.add(calendar.DATE, -update);
        cd = calendar.getTime();
        //   Log.e("动态return减少的天数", getStringDate2(cd) + "");
        return getStringDate2(cd);
    }

    // 2017-04-16字符串 进来转换Date 加N天 return   （字符串转Date加天数）
    public static String DeleteDate(String DateString, int update) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date cd = sdf.parse(DateString);
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(cd);
        calendar.add(calendar.DATE, -update);
        cd = calendar.getTime();
        //   Log.e("动态return减少的天数", getStringDate2(cd) + "");
        return getStringDate2(cd);
    }

    // 判断String是不是日期格式
    public static boolean isValidDate2(String str) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    //    // 2017-04-16字符串 进来转换Date 加1天 return   （字符串转Date加天数）
//    public static String StartOrEnd(String DateString,String format, int update) throws ParseException{
//
//
//
//        SimpleDateFormat sdf = new SimpleDateFormat(format);
//        Date cd = sdf.parse(DateString);
//
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(cd);
//        calendar.add(calendar.DATE,update);//把日期往后增加一天.整数往后推,负数往前移动
//        cd = calendar.getTime();   //这个时间就是日期往后推一天的结果
//
//        Log.e("转时间格式",getStringDate(cd)+"");
//        return getStringDate(cd);
//
//    }
    /*
     * 将时间转换为时间戳
     */
    public static long dateToStampM(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStamp(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            Log.e("ccccc--", e.getMessage());
            e.printStackTrace();
        }
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStampS(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    public static long dateToStampS2(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-ddHH:mm");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long GetDateLong(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStampSJC(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年M月d日");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStampSJC3(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long DateToStampSJC3(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     * 将时间转换为时间戳
     */
    public static long dateToStampSJC2(String s) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse(s);
        long ts = date.getTime();
        return ts;
    }

    /*
     *
     */
    public static String stampToDateS(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToyyyy(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String StampToDateS(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToMM(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampTodd(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    //    获得当前时间戳
    public static long GetDateTimeSJC() throws ParseException {
        long sjc = Calendar.getInstance().getTimeInMillis();
        String aa = getMonthAndDay4(sjc);
        long nyr_sjc = dateToStampSJC(aa);
        return nyr_sjc;
    }

    /**
     * 1为时分秒
     * 2为时分
     *
     * @param type
     * @return
     */
    public static String getNowTime(int type) {
        String time = "";
        try {
            SimpleDateFormat df = null;
            if (type == 1) {
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            } else if (type == 2) {
                df = new SimpleDateFormat("yyyy-MM-dd HH:mm");//设置日期格式
            }
            time = df.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }


    public interface DateClick {
        void dateClick(DatePicker view, String time);
    }


    private static String datePattern = "yyyy-MM-dd";
    private static String datePatternHHmm = "yyyy-MM-dd HH:mm:ss";
    private final static SimpleDateFormat shortSdf = new SimpleDateFormat("yyyy-MM-dd");
    private final static SimpleDateFormat longSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final long MILLIS_HALF_HOUR = 1800000L; //半个小时毫秒数

    /**
     * 返回当前日期 Date
     */
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    /**
     * 返回当前日期 Timestamp
     */
    public static Timestamp getCurrenTimestamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return timestamp;
    }


    /**
     * 使用预设Format格式化Date成字符串
     */
    public static String format(Date date) {
        return format(date, getDatePattern());
    }

    /**
     * 使用参数Format格式化Date成字符串
     */
    public static String format(Date date, String pattern) {
        String returnValue = "";
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return returnValue;
    }

    /**
     * 使用参数Format格式化Timestamp成字符串
     */
    public static String convertTimeStamp(Timestamp date, String pattern) {
        String str = null;
        try {
            SimpleDateFormat df = new SimpleDateFormat(pattern);// 定义格式，不显示毫秒
            str = df.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 使用预设格式将字符串转为Date
     */
    public static Date parse(String strDate) {
        return parse(strDate, getDatePattern());
    }

    /**
     * 使用参数Format将字符串转为Date
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 在日期上增加N个整月
     */
    public static Date addMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n);
        return cal.getTime();
    }

    /**
     * 获取日期的增加N个整月的第一天
     */
    public static Date getDayFirstMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        GregorianCalendar gcLast = (GregorianCalendar) Calendar.getInstance();
        cal.setTime(date);

        cal.add(Calendar.MONTH, n);
        Date theDate = cal.getTime();
        gcLast.setTime(theDate);
        gcLast.set(Calendar.DAY_OF_MONTH, 1);
        String dayFirstMonth = format(gcLast.getTime());
        StringBuffer str = new StringBuffer().append(dayFirstMonth).append(
                " 00:00:00");
        return parse(str.toString(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 获取日期的增加N个整月的最后一天
     */
    public static Date getDayEndMonth(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, n + 1);
        cal.set(Calendar.DATE, 1);
        cal.add(Calendar.DATE, -1);
        String dayEndMonth = format(cal.getTime());
        StringBuffer str = new StringBuffer().append(dayEndMonth).append(
                " 23:59:59");
        return parse(str.toString(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 根据日期获取年的第一天
     */
    public static Date getCurrentYearFirst(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_YEAR, 1);
        return parse(format(cal.getTime()));
    }

    /**
     * 在日期上增加N天
     */
    public static Date addDay(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, n);
        return cal.getTime();
    }

    /**
     * 获得当前日期的前N天
     */
    public static String getDayBeforeSomeDay(int n) {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - n);
        String dayBefore = format(c.getTime());
        return dayBefore;
    }

    /**
     * 获得指定日期的前N天
     */
    public static String getDayBeforeSomeDay(String theDate, int n) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(theDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - n);
        String dayBefore = format(c.getTime(), "yyyy-MM-dd HH:mm:ss");
        return dayBefore;
    }

    /**
     * 获得当前日期的后N天
     */
    public static String getDayAfterSomeDay(int n) {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + n);
        String dayBefore = format(c.getTime(), datePattern);
        return dayBefore;
    }

    /**
     * 获得指定日期的后N天
     */
    public static String getDayAfterSomeDay(String theDate, int n) {
        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yy-MM-dd").parse(theDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day + n);
        String dayBefore = format(c.getTime());
        return dayBefore;
    }

    /**
     * 返回两个时间相差天数
     * 向上进位（如：2014-08-01 16:35:38 2014-08-02 17:35:38 相差2天）
     */
    public static long getDistDays(Date startDate, Date endDate) {
        long timeStart = startDate.getTime();
        long timeEnd = endDate.getTime();
        long diff;
        if (timeStart < timeEnd) {
            diff = timeEnd - timeStart;
        } else {
            diff = timeStart - timeEnd;
        }
        BigDecimal bigDiff = new BigDecimal(diff);
        BigDecimal bigDay = new BigDecimal(1000 * 60 * 60 * 24);
        BigDecimal time = bigDiff.divide(bigDay, 0, BigDecimal.ROUND_UP);

        return time.longValue();
    }

    /**
     * 返回两个时间相差 “XX天XX小时”
     * 向上进位
     */
    public static String getDistanceDayAndHour(Date startDate, Date endDate) {
        long timeStart = startDate.getTime();
        long timeEnd = endDate.getTime();
        long diff;
        if (timeStart < timeEnd) {
            diff = timeEnd - timeStart;
        } else {
            diff = timeStart - timeEnd;
        }
        BigDecimal dayMilli = new BigDecimal(24 * 60 * 60 * 1000);    //天的毫秒数
        BigDecimal hourMilli = new BigDecimal(60 * 60 * 1000);    //小时的毫秒数
        BigDecimal hour = new BigDecimal(24);    //小时


        BigDecimal bigDiff = new BigDecimal(diff);
        BigDecimal bigDay = bigDiff.divide(dayMilli, 0, BigDecimal.ROUND_DOWN);
        BigDecimal bigHour = bigDiff.divide(hourMilli, 0, BigDecimal.ROUND_UP).subtract(bigDay.multiply(hour));

        return bigDay.intValue() + "天" + bigHour.intValue() + "小时";
    }

    /**
     * 得到N(N可以为负数)小时后的日期
     */
    public static Date afterNHoursDate(Date theDate, int hous) {
        try {
            if (theDate == null) {
                return getCurrentDate();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(theDate);
            cal.add(Calendar.HOUR_OF_DAY, hous);
            return cal.getTime();
        } catch (Exception e) {
            return getCurrentDate(); // 如果无法转化，则返回默认格式的时间。
        }
    }

    /**
     * 得到N(N可以为负数)分钟后的日期
     */
    public static Date afterNMinutesDate(Date theDate, int minute) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(theDate);
            cal.add(Calendar.MINUTE, minute);
            return cal.getTime();
        } catch (Exception e) {
            return getCurrentDate(); // 如果无法转化，则返回默认格式的时间。
        }
    }

    /**
     * 得到N(N可以为负数)天后的日期
     */
    public static Date afterNDayDate(Date theDate, int day) {
        try {
            if (theDate == null) {
                return getCurrentDate();
            }
            Calendar cal = Calendar.getInstance();
            cal.setTime(theDate);
            cal.add(Calendar.DAY_OF_MONTH, day);
            return cal.getTime();
        } catch (Exception e) {
            return getCurrentDate(); // 如果无法转化，则返回默认格式的时间。
        }
    }

    /**
     * 返回两个日期相差的分钟数
     */
    public static long getDistMins(Date startDate, Date endDate) {
        long totalDate = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        long timestart = calendar.getTimeInMillis();
        calendar.setTime(endDate);
        long timeend = calendar.getTimeInMillis();
        totalDate = Math.abs((timeend - timestart)) / (1000 * 60);
        return totalDate;
    }

    /**
     * 返回指定日期所在的月份
     */
    public static String getCurrMonth(String dateStr) {
        String[] list = dateStr.split("-");
        if (list != null && list.length != 0) {
            return list[1];
        } else {
            list = dateStr.split("/");
            return list[1];
        }

    }

    /**
     * 根据日期获取星期几
     */
    public static String getWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        SimpleDateFormat sd = new SimpleDateFormat("EEE");
        return sd.format(date);
    }

    /**
     * 获取当天的日历对象
     */
    public static Calendar getTodayCalendar() throws ParseException {
        String strDate = getToday();
        Calendar cal = new GregorianCalendar();
        cal.setTime(parse(strDate, datePattern));
        return cal;
    }

    public static String getDatePattern() {
        return datePatternHHmm;
    }

    /**
     * 根据身份证号获取年龄
     *
     * @param idCard
     * @return : int
     * @Method_Name : getAgeByIdCard
     * @Creation Date  : 2014年12月20日 下午5:33:12
     * @version : v1.00
     * @Author : chensheng
     * @Update Date    :
     * @Update Author  :
     */
    public static int getAgeByIdCard(String idCard) {

        int age = 0;
        String birth = idCard.substring(6, 10);
        int birthday = Integer.parseInt(birth);
        int year = 0;
        year = Integer.parseInt(format(new Date(), "yyyy"));
        age = year - birthday;
        return age;
    }

    /**
     * 判断一个时间是否在某个时间段
     * true date在strDateBegin-strDateEnd内
     * false date不在strDateBegin-strDateEnd内
     *
     * @param date
     * @param strDateBegin
     * @param strDateEnd
     * @return : boolean
     * @Method_Name : isInDate
     * @Creation Date  : 2015年9月28日 下午1:50:02
     * @Version : v1.00
     * @Author : chensheng
     */
    public static boolean isInDate(Date date, String strDateBegin,
                                   String strDateEnd) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);
        // 截取当前时间时分秒
        int strDateH = Integer.parseInt(strDate.substring(11, 13));
        int strDateM = Integer.parseInt(strDate.substring(14, 16));
        int strDateS = Integer.parseInt(strDate.substring(17, 19));
        // 截取开始时间时分秒
        int strDateBeginH = Integer.parseInt(strDateBegin.substring(0, 2));
        int strDateBeginM = Integer.parseInt(strDateBegin.substring(3, 5));
        int strDateBeginS = Integer.parseInt(strDateBegin.substring(6, 8));
        // 截取结束时间时分秒
        int strDateEndH = Integer.parseInt(strDateEnd.substring(0, 2));
        int strDateEndM = Integer.parseInt(strDateEnd.substring(3, 5));
        int strDateEndS = Integer.parseInt(strDateEnd.substring(6, 8));
        if ((strDateH >= strDateBeginH && strDateH <= strDateEndH)) {
            // 当前时间小时数在开始时间和结束时间小时数之间
            if (strDateH > strDateBeginH && strDateH < strDateEndH) {
                return true;
                // 当前时间小时数等于开始时间小时数，分钟数在开始和结束之间
            } else if (strDateH == strDateBeginH && strDateM >= strDateBeginM
                    && strDateM <= strDateEndM) {
                return true;
                // 当前时间小时数等于开始时间小时数，分钟数等于开始时间分钟数，秒数在开始和结束之间
            } else if (strDateH == strDateBeginH && strDateM == strDateBeginM
                    && strDateS >= strDateBeginS && strDateS <= strDateEndS) {
                return true;
            }
            // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数小等于结束时间分钟数
            else if (strDateH >= strDateBeginH && strDateH == strDateEndH
                    && strDateM <= strDateEndM) {
                return true;
                // 当前时间小时数大等于开始时间小时数，等于结束时间小时数，分钟数等于结束时间分钟数，秒数小等于结束时间秒数
            } else if (strDateH >= strDateBeginH && strDateH == strDateEndH
                    && strDateM == strDateEndM && strDateS <= strDateEndS) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 判断一个时间是否在某个时间段
     * true date在strDateBegin-strDateEnd内
     * false date不在strDateBegin-strDateEnd内
     *
     * @param date
     * @return : boolean
     * @Method_Name : isInDate
     * @Creation Date  : 2015年9月28日 下午1:50:02
     * @Version : v1.00
     * @Author : chensheng
     */
    public static boolean isInDate(Date date, Date dateBegin,
                                   Date dateEnd) {

        if (date.after(dateBegin) && date.before(dateEnd)) {
            return true;
        }

        return false;
    }

    /**
     * 返回两个日期相差的年数,4舍5入
     *
     * @param start
     * @param end
     * @return : int
     * @Method_Name : getYearFromDate
     * @Creation Date  : 2015年10月22日 下午1:43:20
     * @Version : v1.00
     * @Author : chensheng
     */
    public static int getYearFromDate(Date start, Date end) {
        long disDays = getDistDays(start, end);
        double year = Double.valueOf(disDays) / 365;
        String yearStr = String.format("%.0f", year);
        return Integer.valueOf(yearStr);
    }

    /**
     * 获取未来七天的周几日期
     *
     * @param weekday
     * @return : String[]
     * 下标为0的是"-"连接
     * 下标为1的是"月，日"连接
     * @Method_Name : getDateFromNowOnByWeekday
     * @Creation Date  : 2015年10月26日 上午11:55:52
     * @Version : v1.00
     * @Author : chensheng
     */
    public static String[] getDateFromNowOnByWeekday(int weekday) {
        String dateFormat = "MM月dd日";
        String[] result = new String[2];
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("星期一", 0);
        map.put("星期二", 1);
        map.put("星期三", 2);
        map.put("星期四", 3);
        map.put("星期五", 4);
        map.put("星期六", 5);
        map.put("星期日", 6);

        Date now = new Date();
        String weekStr = getWeek(now);
        Integer weekCode = map.get(weekStr);
        String normalFormat = "";
        String specailFormat = "";
        if (weekday > weekCode) {
            normalFormat = format(addDay(now, weekday - weekCode));
            specailFormat = format(addDay(now, weekday - weekCode), dateFormat);
        } else {
            normalFormat = format(addDay(now, weekday - weekCode + 7));
            specailFormat = format(addDay(now, weekday - weekCode + 7), dateFormat);
        }
        result[0] = normalFormat;
        result[1] = specailFormat;
        return result;
    }

    /**
     * 把一段时间切片，target为切片的分钟数
     * 参数日期格式为yyyy-MM-dd HH:mm
     *
     * @param begin
     * @param end
     * @param target
     * @return : List<String>
     * @Method_Name : spiltTime
     * @Creation Date  : 2016年3月4日 下午4:21:13
     * @Version : v1.00
     * @Author : chensheng
     */
    public static List<String> spiltTime(Date begin, Date end, int target) {
        String beginStr = format(begin, "HH:mm");
        String endStr = format(end, "HH:mm");
        int beginHour = Integer.valueOf(beginStr.substring(0, 2));
        int beginMinute = Integer.valueOf(beginStr.substring(3));
        int endHour = Integer.valueOf(endStr.substring(0, 2));
        if (beginMinute > 0) beginHour++;
        String result = "";
        String am_pm = "上午  ";
        List<String> resultList = new ArrayList<String>();
        for (int i = beginHour; i < endHour; i++) {
            if (i >= 12) am_pm = "下午  ";
            result = am_pm + i + ":00" + "-" + (i + 1) + ":00";
            resultList.add(result);
        }

        return resultList;
    }

    /**
     * 判断两个时间段是否存在交集
     * 时间的大小顺序满足d1 < d2
     * true存在交集
     * false不存在交集
     *
     * @param d1
     * @param d2
     * @param begin
     * @return : boolean
     * @Method_Name : lapOver
     * @Creation Date  : 2016年3月8日 下午2:07:35
     * @Version : v1.00
     * @Author : chensheng
     */
    public static boolean lapOver(Date d1, Date d2, Date begin) {
        if (d1.getTime() < begin.getTime() &&
                begin.getTime() < d2.getTime())
            return true;
        return false;
    }

    /**
     * 判断一个日期是否大于当前日期
     *
     * @param date
     * @return : boolean
     * @Method_Name : greaterThanNow
     * @Creation Date  : 2016年9月2日 下午6:10:43
     * @version : v1.00
     * @Author : shensheng
     * @Update Date    :
     * @Update Author  :
     */
    public static boolean greaterThanNow(Date date) {
        Long dateMillions = date.getTime();
        Long nowMillions = new Date().getTime();
        return dateMillions > nowMillions;
    }

    /**
     * 获取当天的开始时间
     *
     * @return : Date
     * @Method_Name : startOfTodDay
     * @Creation Date  : 2017年1月6日 下午4:32:32
     * @version : v1.00
     * @Author : shensheng
     * @Update Date    :
     * @Update Author  :
     */
    public static Date startOfTodDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * 获取当天的结束时间
     *
     * @return : long
     * @Method_Name : endOfTodDay
     * @Creation Date  : 2017年1月6日 下午4:32:37
     * @version : v1.00
     * @Author : shensheng
     * @Update Date    :
     * @Update Author  :
     */
    public static Date endOfTodDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        Date date = calendar.getTime();
        return date;
    }

    /**
     * @Author liqi
     * @Date 2017-09-02 13:02
     * @Description:获取指定时间一天开始的时间
     */

    public static Date startOfDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * @Author liqi
     * @Date 2017-09-02 13:03
     * @Description:获取指定时间一天结束的时间
     */

    public static Date endOfDate(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * 判断时间是不是今天
     *
     * @param date
     * @return 是返回true，不是返回false
     */
    public static boolean isToday(Date date) {
        //当前时间
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        //获取今天的日期
        String nowDay = sf.format(now);
        //对比的时间
        String day = sf.format(date);
        return day.equals(nowDay);
    }


    /**
     * @Author liqi
     * @Date 2017-09-05 20:54
     * @Description:毫秒转化时分秒毫秒
     */

    public static String formatTime(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
        Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
        Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分钟");
        }
//       if(second > 0) {
//           sb.append(second+"秒");
//       }
//       if(milliSecond > 0) {
//           sb.append(milliSecond+"毫秒");
//       }
        return sb.toString();
    }

    /**
     * @Author liqi
     * @Date 2017-09-06 19:45
     * @Description:格式化日期 HH:mm
     */

    public static String getFormatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.format(date);
    }


    /**
     * @Author liqi
     * @Date 2017-09-06 19:50
     * @Description:时间戳转换为date
     */

    public static Date longToDate(long date) {
        return new Date(date);
    }

    /**
     * author:xieyushi
     *
     * @date 2017/9/8 10:36
     * desc:格式化字符串，带年月日周,形如：2017年8月12号（周二）
     */
    public static String getStringWithWeek(Date date) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        String week = weekDays[w];
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return year + "年" + month + "月" + day + "号（" + week + "）";
    }


    /**
     * @Author liqi
     * @Date 2017-11-01 10:37
     * @Description:格式化日期，带月日周,形如：8月12日 周二
     */

    public static String getWeekByDate(Date date) {
        String[] weekDays = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        String week = weekDays[w];

        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return month + "月" + day + "日 " + week;
    }


    /**
     * author:Wuhao
     *
     * @date 2017/10/16 10:36
     * desc:获取本周日期
     */
    public static Map<String, String> getthisWeek() {
        Map<String, String> map = new LinkedHashMap<>();
        Calendar cal = Calendar.getInstance();
        int date = cal.get(Calendar.DAY_OF_MONTH);
        int n = cal.get(Calendar.DAY_OF_WEEK);
        if (n == 1) {
            n = 7;
        } else {
            n = n - 1;
        }
        // 日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 1; i <= 7; i++) {
            cal.set(Calendar.DAY_OF_MONTH, date + i - n);
            map.put("周" + i, sdf.format(cal.getTime()));
        }
        return map;
    }


    /**
     * @Author liqi
     * @Date 2017-12-01 16:50
     * @Description:获得本月的开始时间
     */

    public static Date getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * @Author liqi
     * @Date 2017-12-01 16:50
     * @Description:本月的结束时间
     */

    public static Date getCurrentMonthEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * @Author liqi
     * @Date 2017-12-05 14:30
     * @Description:计算int类型的时间计算总分钟数（用于车站大屏）
     */

    public static int getminute(int hhmm) {
        int hhmmone = 0;
        if (String.valueOf(hhmm).length() == 4) {
            //取前两位
            hhmmone = Integer.valueOf(String.valueOf(hhmm).substring(0, 2)) * 60 + Integer.valueOf(String.valueOf(hhmm).substring(2));
        } else if (String.valueOf(hhmm).length() == 3) {
            //取前一位
            hhmmone = Integer.valueOf(String.valueOf(hhmm).substring(0, 1)) * 60 + Integer.valueOf(String.valueOf(hhmm).substring(1));
        } else if (String.valueOf(hhmm).length() == 2) {
            hhmmone = hhmm;
        } else if (String.valueOf(hhmm).length() == 1) {
            hhmmone = hhmm;
        }

        return hhmmone;
    }

    /**
     * @Author liqi
     * @Date 2017-12-27 15:53
     * @Description:获取当天日期格式为20171227
     */

    public static String getFormatNewdate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(new Date());
    }

    /**
     * @Author liqi
     * @Date 2017-12-27 18:39
     * @Description:根据毫秒拿到天、时、分（为行程状态）
     */

    public static String twoDateSubtract(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;

        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        Long minute = (ms - day * dd - hour * hh) / mi;
//		Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
//		Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;
        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        if (minute > 0) {
            sb.append(minute + "分钟");
        }
        if (sb.indexOf("天") > -1 && sb.indexOf("小时") > -1) {
            return (day + 1) + "天";
        } else if (sb.indexOf("小时") > -1 && sb.indexOf("分钟") > -1) {
            return (hour + 1) + "小时";
        } else if (sb.indexOf("天") > -1) {
            return day + "天";
        } else if (sb.indexOf("小时") > -1) {
            return hour + "小时";
        } else if (sb.indexOf("分钟") > -1) {
            return minute + "分钟";
        }

        return sb.toString();
    }

    /**
     * @Author liqi
     * @Date 2018-01-23 15:33
     * @Description:毫秒转化为天，小时不要
     */

    public static String formatTimeForDay(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;
        Long day = ms / dd;
        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day + "天");
        }
        return sb.toString();
    }

    /**
     * @Author liqi
     * @Date 2018-01-23 16:09
     * @Description:毫秒转化为小时，分钟不要
     */

    public static String formatTimeForHour(Long ms) {
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;
        Long day = ms / dd;
        Long hour = (ms - day * dd) / hh;
        StringBuffer sb = new StringBuffer();
        if (hour > 0) {
            sb.append(hour + "小时");
        }
        return sb.toString();
    }

    /**
     * @Author liqi
     * @Date 2018-01-24 11:14
     * @Description:两个时间相减跨几天
     */

    public static String getLiveForTime(Date startdate, Date endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String d1 = simpleDateFormat.format(startdate);
        String d2 = simpleDateFormat.format(endDate);
        Long ms = null;
        try {
            ms = simpleDateFormat.parse(d2).getTime() - simpleDateFormat.parse(d1).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer ss = 1000;
        Integer mi = ss * 60;
        Integer hh = mi * 60;
        Integer dd = hh * 24;
        Long day = ms / dd;
        StringBuffer sb = new StringBuffer();
        if (day > 0) {
            sb.append(day);
        }
        return sb.toString();

    }

    public static void chooseDateAndSetText(Context context, final TextView txt_date) {
        try {
            Calendar ca = Calendar.getInstance();
            new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            try {
                                String days;
                                if (month + 1 < 10) {
                                    if (dayOfMonth < 10) {
                                        days = new StringBuffer().append(year).append("-").append("0").append(month + 1).append("-").append("0").append(dayOfMonth).toString();
                                    } else {
                                        days = new StringBuffer().append(year).append("-").append("0").append(month + 1).append("-").append(dayOfMonth).toString();
                                    }
                                } else {
                                    if (dayOfMonth < 10) {
                                        days = new StringBuffer().append(year).append("-").append(month + 1).append("-").append("0").append(dayOfMonth).toString();
                                    } else {
                                        days = new StringBuffer().append(year).append("-").append(month + 1).append("-").append(dayOfMonth).toString();
                                    }
                                }
                                txt_date.setText(days);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    }, ca.get((Calendar.YEAR)), ca.get(Calendar.MONTH), ca.get(Calendar.DAY_OF_MONTH)).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void chooseTimeAndSetText(Context context, final TextView txt_time) {
        try {
            Calendar ca = Calendar.getInstance();
            new TimePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                    try {
                        String time;
                        if (hour + 1 < 10) {
                            if (minute < 10) {
                                time = new StringBuffer().append("0").append(hour).append(":").append("0").append(minute).toString();
                            } else {
                                time = new StringBuffer().append("0").append(hour).append(":").append(minute).toString();
                            }
                        } else {
                            if (minute < 10) {
                                time = new StringBuffer().append(hour).append(":").append("0").append(minute).toString();
                            } else {
                                time = new StringBuffer().append(hour).append(":").append(minute).toString();
                            }
                        }
                        txt_time.setText(time);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }, ca.get(Calendar.HOUR_OF_DAY), ca.get(Calendar.MINUTE), true).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static String stringToString(String oldTime, String formatOld, String formatResult) {
        Date date = stringToDate(oldTime, formatOld);
        return dateToString(date, formatResult);
    }

    public static String dateToString(Date data, String format) {
        if (data == null || TextUtils.isEmpty(format)) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
        return sdf.format(data);
    }

    public static Date stringToDate(String strTime, String format) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault());
            date = sdf.parse(strTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String longToString(long currentTime, String format) {
        Date date = longToDate(currentTime); // long类型转成Date类型
        return dateToString(date, format);
    }


    public static long stringToLong(String strTime, String format) {
        Date date = stringToDate(strTime, format); // String类型转成date类型
        if (date == null) {
            return 0;
        } else {
            return dateToLong(date);
        }
    }

    public static long dateToLong(Date date) {
        return date.getTime();
    }


    public static void main(String[] args) {

        System.out.println(getDayAfterSomeDay(1 - 1));
        System.out.println(getToday());
    }

    /*
     * 选择日期
     * type:1:20170101,2:2017/01/01 3:2017-01-01
     * */
    public static void getDateBtn(final TextView view, Context context) {
        try {
            Dialog dialog = null;
            Calendar c = Calendar.getInstance();
            dialog = new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker dp, int year, int month, int dayOfMonth) {
                            try {
                                int m = month + 1;
                                String mm = "" + m;
                                String dd = "" + dayOfMonth;
                                if (m < 10) {
                                    mm = "0" + m;
                                }
                                if (dayOfMonth < 10) {
                                    dd = "0" + dayOfMonth;
                                }
                                String str = year + "-" + mm + "-" + dd;
                                view.setText(str);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, c.get(Calendar.YEAR), // 传入年份
                    c.get(Calendar.MONTH), // 传入月份
                    c.get(Calendar.DAY_OF_MONTH) // 传入天数
            );
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 选择时间
     *
     * */
    public static void getTimeBtn(final TextView view, Context context) {
        try {
            Dialog dialog = null;
            Calendar c = Calendar.getInstance();
            dialog = new TimePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker picker,
                                              int hourOfDay, int minute) {
                            try {
                                String hourOfDayStr = hourOfDay + "";
                                if (hourOfDay < 10) {
                                    hourOfDayStr = "0" + hourOfDay;
                                }
                                String minuteStr = minute + "";
                                if (minute < 10) {
                                    minuteStr = "0" + minute;
                                }
                                String str = hourOfDayStr + ":" + minuteStr;
                                view.setText(str);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }, c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE),
                    false);
            dialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
