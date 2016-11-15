package myarray;

/**
 * Created by zzp on 2016/11/9.
 */
public class myArray {
    char[] cNum = {'1','2','3','4','5','6','7','8','9','0'};
    char[] cStr = {'a','b','c','d','e','f','g','h',
            'i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z'};
    int[] iMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    String [] sMail = {"@","."};

    /**
     * 方法说明：校验电子邮件
     * @param sPara 被校验的电子邮件字符
     * @return boolean 符合格式返回true，否则false
     */
    public boolean isMail(String sPara){
        for(int i = 0 ;i < sMail.length;i ++){
            if (sPara.indexOf(sMail[i])== -1)
                return false;
        }
        return true;
    }

    /**
     * 方法说明：判断是否是数字
     * @param sPara
     * @return 是则返回TRUE，否则返回false
     */

    public boolean isNumber(String sPara){
        int iPLength =  sPara.length();
        for (int i=0 ;i<iPLength;i++){
            char cTemp = sPara.charAt(i);
            boolean bTemp = false;
            for(int j=0;j<cNum.length;j++){
                if (cTemp == cNum[j]){
                    bTemp = true;
                    break;
                }
            }
            if(!bTemp) return false;
        }
        return true;
    }

    /**
     * 方法说明：判断是否是英文字符
     * @param sPara
     * @return 是则返回TRUE，否则返回false
     */
    public boolean isString (String sPara){
        int iPLength = sPara.length();
        for(int i = 0;i < iPLength;i++){
            char cTmp = sPara.charAt(i);
            boolean bTmp = false;
            for(int j=0 ;j <cStr.length;j++){
                if (cTmp == cStr[j]){
                    bTmp = true;
                    break;
                }
                if(!bTmp) return false;
            }
        }
        return true;
    }

    /**
     * 判断是否是闰年
     * @param iPara 要判断的年份
     * @return Boolean，是则返回true，否则返回false
     */
    public boolean checkDay(int iPara){
        return iPara%100==0&&iPara%4==0;
    }
    /**
     * 方法说明：检查日期格式是否正确
     * @param sPara。要检查的日期字符
     * @return int .0 日期格式正确，-1，月或日不合要求，-2年月日格式不合要求
     */
    public int checkData(String sPara){
        boolean bTmp = false;
        //所输入日期长度不正确
        if (sPara.length()!= 10) return -2;
        String sYear = sPara.substring(0,4);
        //判断是否为数字
        if(!isNumber(sYear)) return -2;
        String sMonth = sPara.substring(5,7);
        if(!isNumber(sMonth)) return -2;
        String sDay =sPara.substring(8,10);
        if(!isNumber(sDay)) return -2;
        int iYear = Integer.parseInt(sYear);
        int iMon = Integer.parseInt(sMonth);
        int iDay = Integer.parseInt(sDay);
        if(iMon > 12 ) return -1;
        if(iMon == 2 && checkDay(iYear)){
            if(iDay>29) return -1;
        }else {
            if(iDay > iMonth[iMon-1]) return -1;
        }
        return 0;
    }

    /**
     * 方法说明：主方法，测试用
     * @param args
     */
    public static void main(String[] args) {
        myArray mA = new myArray();
        //校验邮件地址
        String bb = "935408317@qq.com";
        String date = "2016-11-11";
        boolean bMail = mA.isMail("935408317@qq.com");
        System.out.println("1 bMail is" +bMail);
        boolean bIsNum = mA.isNumber(bb);
        System.out.println("2 bMail is" +bIsNum);
        int bDate = mA.checkData(date);
        System.out.println("3 bDate is" + bDate);
    }
}
