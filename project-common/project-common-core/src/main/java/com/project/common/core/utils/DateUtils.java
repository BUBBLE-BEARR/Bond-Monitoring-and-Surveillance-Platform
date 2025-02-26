package com.project.common.core.utils;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 时间工具类
 * 
 * @author project
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils
{
    public static String YYYY = "yyyy";

    public static String YYYYMM = "yyyyMM";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    
    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     * 
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return parseDate(str.toString(), parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate()
    {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }


    /**
     * 获取12个月份集合,不包含本月
     * @return
     */
    public static  List<String> getTwelveMonth (){
        List<String> localMonths = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for(long i = 1L;i <= 12L; i++){
            LocalDate localDate = today.minusMonths(i);
            String localMonth = localDate.toString().substring(0, 7);
            localMonths.add(localMonth);
        }
        return localMonths;
    }
    /**
     *  //按照指定的时间格式转换
     * @param format
     * @param date
     * @return
     */
    public static String getObjectDate(String format,Object date){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            //判断传入的时间类型是什么类型
            if(date instanceof Date){
                return formatter.format(date);
            }
            if (date instanceof String){
                return formatter.format(date);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //获取本年去年的数据
    public static List<String> getOldYears(){
        List<String> oldYears = new ArrayList<>();
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.YEAR,-1);
            // 获取当前的年份
            int year = c.get(Calendar.YEAR);
            // 定义时间格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            // 开始日期为当前年拼接1月份
            Date startDate = sdf.parse(year + "-01");
            // 结束日期为当前年拼接12月份
            Date endDate = getFirstDay();
            // 设置calendar的开始日期
            c.setTime(startDate);
            // 当前时间小于等于设定的结束时间
            while(c.getTime().compareTo(endDate) <= 0){
                String time = sdf.format(c.getTime());
                // 打印日期
                oldYears.add(time);
                // 当前月份加1
                c.add(Calendar.MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return oldYears;
    }


    public static Date getFirstDay(){
        Date date=null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("MM");
            //获取前月的第一天
            Calendar   cal_1=Calendar.getInstance();//获取当前日期

            cal_1.add(Calendar.MONTH, -1);

            cal_1.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天

            String firstDay = format.format(cal_1.getTime());

            int year = cal_1.get(Calendar.YEAR);
            date= new SimpleDateFormat("yyyy-MM").parse(year +"-"+ firstDay);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 获取5年的集合,包含本年
     * @return
     */
    public static  List<String> getFiveYear(){
        List<String> localYears = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for(long i = 0L;i <5L; i++){
            LocalDate localDate = today.minusYears(i);
            String localYear = localDate.toString().substring(0, 4);
            localYears.add(localYear);
        }
        return localYears;
    }


    public static  List<String> getFiveYearAndMonth(){
        List<String> localYears = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for(long i = 0L;i <5L; i++){
            LocalDate localDate = today.minusYears(i);
            String localYear = localDate.toString().substring(0, 4);
            localYears.add(localYear+"-01-01");
        }
        return localYears;
    }

    /**
     * 不包含本年的
     * @return
     */
    public static  List<String> getNoFiveYear(){
        List<String> localYears = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for(long i = 1;i <6; i++){
            LocalDate localDate = today.minusYears(i);
            String localYear = localDate.toString().substring(0, 4);
            localYears.add(localYear);
        }
        return localYears;
    }


    /**
     * 获取3年的集合,包含本年
     * @return
     */
    public static  List<String> getThreeYear(){
        List<String> localYears = new ArrayList<>();
        LocalDate today = LocalDate.now();
        for(long i = 0L;i <3L; i++){
            LocalDate localDate = today.minusYears(i);
            String localYear = localDate.toString().substring(0, 4);
            localYears.add(localYear);
        }
        return localYears;
    }

    /**
     * 获取去年
     * @param date
     * @return java.lang.String
     */
    public static String getLastYear(String date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime(YYYY, date));
        calendar.add(Calendar.YEAR, -1);
        return parseDateToStr(YYYY, calendar.getTime());
    }

    /**
     * 获取去年 年月
     * @param date
     * @return java.lang.String
     */
    public static String getLastYearMonth(String date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime(YYYYMM, date));
        calendar.add(Calendar.MONTH, -12);
        return parseDateToStr(YYYYMM, calendar.getTime());
    }

    /**
     * 获取去年 年月日
     * @param date
     * @return java.lang.String
     */
    public static String getLastYearMonthDay(String date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateTime(YYYY_MM_DD, date));
        calendar.add(Calendar.YEAR, -1);
        return parseDateToStr(YYYY_MM_DD, calendar.getTime());
    }

    /**
     * 获取当前年份
     * @return
     */
    public static String getCurrentYear(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY);
        return sdf.format(date);
    }

    /**
     * 获取当前季度
     * @return
     */
    public static String getCurrentQuarter(){
        LocalDate localDate = LocalDate.now();
        int month = localDate.getMonthValue();
        int quarter = (month - 1) / 3 + 1;
        return String.valueOf(quarter);
    }
}
