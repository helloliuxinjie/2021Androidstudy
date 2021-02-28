import java.util.Scanner;
/**
 * @author Liuxinjie
 * @version 1.0
 * @date 2021/1/27 027 19:55
 * @software IDEA
 */
public class csawork1 {
    public static void main(String[] args) {
        System.out.println("请输入一串数字：");
        String str;//该字符串str用于存放任意长度的数字字符串
        Scanner in=new Scanner(System.in);
        str=in.nextLine();
        System.out.println(str);
        String str1[]=str.split(",");//将在数字字符串str1以逗号分割为多个字符串数字
        int[] array=strToInt(str1);
//        java.util.Arrays.parallelSort(array);
        selectionSort(array);//使用选择排序对数组array进行排序
        System.out.println("排序后的结果：");
        print(array);
        System.out.println("请输入另一串数字：");
        String str2=in.nextLine();//第二个输入
        System.out.println(str2);
        String str3[]=str2.split(",");//将在数字字符串str2以逗号分割为多个字符串数字
        int[] array2=strToInt(str3);
        //下面将array与array2合并为一个数组
//        System.arraycopy();
        int[] all=merge(array2,0,array,array.length,array2.length);
        //然后下面将合并数组进行排序
        selectionSort(all);
        System.out.println("合并后的结果：");
        print(all);

    }
    static int[] merge(int[]a,int a_start,int[] b,int b_start,int acopy_len){
        // 将源数组a的内容复制到目标数组b的后面
        int[] all=new int[a.length+b.length];
        for(int j=0;j<b_start;j++){
            all[j]=b[j];
        }
        for(int i=0;i<acopy_len;i++){
            all[b_start+i]=a[a_start+i];
        }
        return all;
    }
    static void selectionSort(int[] array){
        //选择排序

        int len=array.length;
        for(int i=0;i<len-1;i++){
            int minpos=i;//最小位置指向
            for(int j=i+1;j<len;j++) {
                minpos = array[minpos] > array[j] ? j : minpos;
            }
            swap(array,minpos,i);

        }


    }
    static  void swap(int[] array,int minpos,int j){
        int temp;//暂存变量
        temp=array[minpos];
        array[minpos]=array[j];
        array[j]=temp;
    }
    static int [] strToInt(String str1[]){
        //数字字符串数组转化为数字数组
        int[]array=new int[str1.length];//用于存放数字
        for(int i=0;i<str1.length;i++){//将分割后的字符串数组中的每个字符串数字转化为相应的数字放入整数数组中
            array[i]=Integer.valueOf(str1[i]);
        }
        return array;
    }
    static void print(int[] array){
        //打印数组
        for(int i=0;i<array.length;i++){
            if(i==array.length-1)
                System.out.println(array[i]);
            else
                System.out.print(array[i]+",");
        }
    }
}