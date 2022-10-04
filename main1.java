package arithmetic;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class main1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		//创建两文件
		File file1=new File("D:\\java作业\\Exercises.txt");
		Writer out1=new FileWriter(file1);
		File file2=new File("D:\\java作业\\Answers.txt");
		Writer out2=new FileWriter(file2);
		
		System.out.println("请输入题目个数：");
		int count=sc.nextInt();
		int count1=1;
		for(;count1<=count;)
		{
			int kind=(int)(Math.random()*2);//随机产生符号个数
			if(kind==0) {//符号个数为1
				int a=(int)(Math.random()*100);
				int b=(int)(Math.random()*100);		
				int k=(int)(Math.random()*2);
				int ans=calculation1(a,b,k);
				if(ans<0||ans>100) continue;
				if(k==0)
				{
					out1.write(count1+".  "+a+"+"+b+"="+"\n");
				}
				if(k==1) {
					out1.write(count1+".  "+a+"-"+b+"="+"\n");
				}
				out2.write(count1+".  "+ans+"\n");
				count1++;
			}
			if(kind==1) {//符号个数为2
				int a=(int)(Math.random()*100);
				int b=(int)(Math.random()*100);
				int c=(int)(Math.random()*100);
				int k1=(int)(Math.random()*2);
				int k2=(int)(Math.random()*2);
				int ans=calculation2(a,b,c,k1,k2);
				if(ans<0||ans>100) continue;
				if(k1==0&&k2==0)
				{
					out1.write(count1+".  "+a+"+"+b+"+"+c+"="+"\n");
				}
				if(k1==0&&k2==1) {
					out1.write(count1+".  "+a+"+"+b+"-"+c+"="+"\n");
				}
				if(k1==1&&k2==0)
				{
					out1.write(count1+".  "+a+"-"+b+"+"+c+"="+"\n");
				}
				if(k1==1&&k2==1)
				{
					out1.write(count1+".  "+a+"-"+b+"-"+c+"="+"\n");
				}
				out2.write(count1+".  "+ans+"\n");
				count1++;
			}
		}
		out1.close();
		out2.close();		
	}

//产生加减符号
String getOperator(int k) {
			String operator="";
			switch(k) {
			case 0:operator="+";
			break;
			case 1:operator="-";
			break;
			}
			return operator;
}

//一个符号加减运算
static int calculation1(int a,int b,int k) {
	int answer=0;
	switch(k) {
	case 0:answer=a+b;
	break;
	case 1:answer=a-b;
	break;
	}
	return answer;
}

//两个符号加减运算
static int calculation2(int a,int b,int c,int k1,int k2) {
	int answer=0;
	int d=calculation1(a,b,k1);
	answer=calculation1(d,c,k2);
	return answer;
}
}
