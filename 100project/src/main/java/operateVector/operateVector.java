package operateVector;

import java.util.Vector;

/**
 * Created by zzp on 2016/11/11.
 */
public class operateVector {
    /**
     * 生产一个4*e的二维Vector，供使用
     * @return
     */
    public Vector buildVector(){
        Vector vTemps =  new Vector();
        for(int i=0; i<4;i++ ){
            Vector vTmp = new Vector();
            for(int j=0;j<4;j++){
                vTmp.addElement("Vector("+ i +")("+ j +")");
            }
            vTemps.addElement(vTmp);
        }
        return vTemps;
    }

    /**
     * 插入数据
     * @param vTemp 待插数据对象
     * @param iTemp 插入数据位置
     * @param oTemp 插入数据值
     * @return Vector 结果
     */
    public Vector insert(Vector vTemp,int iTemp,Object oTemp){
        if(iTemp > vTemp.size()){
            print("数据越界");
            return null;
        }else{
            vTemp.insertElementAt(oTemp,iTemp);
        }
        return vTemp;
    }
    public Vector delete(Vector vTemp,int iTemp){
        if(iTemp > vTemp.size()){
            print("数据越界");
            return null;
        }else{
            vTemp.removeElementAt(iTemp);
        }
        return vTemp;
    }

    public Vector update(Vector vTemp,int iTemp,Object oTemp){
        if(iTemp > vTemp.size()){
            print("数据越界");
            return null;
        }else{
            vTemp.setElementAt(oTemp,iTemp);
        }
        return vTemp;
    }

    /**
     * 输出信息
     * @param sTemp 输出信息名称
     * @param oTemp 输出信息值
     */
    public void print(String sTemp,Vector oTemp){
        print(sTemp+"数据：");
        this.print(oTemp);
    }

    /**
     * 打印输出
     * @param oPara 输出的对象
     */
    public void print(Object oPara){
        System.out.println(oPara);
    }

    /**
     * 打印输出（过载）
     * @param vPara 显示输出矢量对象
     */
    public void print(Vector vPara){
        for(int i = 0;i<vPara.size();i++){
            System.out.println(vPara.elementAt(i));
        }
    }

    /**
     * 程序入口
     * @param args
     */
    public static void main(String[] args) {
        operateVector ov = new operateVector();
        Vector vTemp = ov.buildVector();
        ov.print("vTemp0:",vTemp);
        Vector vResult = ov.insert(vTemp,2,"傻逼");
        ov.print("vResult:",vResult);
        Vector vResultup = ov.update(vResult,2,"修改的数据");
        ov.print("vResultmp",vResultup);
        Vector vResultnow = ov.delete(vResultup,2);
        ov.print("vResultnow",vResultnow);
    }
}
