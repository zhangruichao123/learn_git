package primary;
//位运算
public class Ex1 {
	public static void print(int num) {
		for(int i =31; i>=0;i--) {
			System.out.print((num&(1<<i))==0?"0":"1");
		}
		System.out.println();
	}

	public static void main(String[] args) {
/*		int a=-1;
		print(a);
		System.out.println("sss");*/

		//对数器测试，大样本随机测试
		//根据分f()1~5等概率随机数函数基础上，改成1~7等概率随机数函数
		int counts[]=new int[8];
		int testTime=100000;
		for (int i = 0; i < testTime; i++) {
			int num=g();
			counts[num]++;
		}
		for (int i = 0; i < 8; i++) {
			System.out.println(i+"这个数出现了："+counts[i]+"次");
		}
	}

	//根据分f()1~5等概率随机数函数基础上，改成1~7等概率随机数函数
	//f()1~5等概率随机数函数
	public static int f() {
		return (int)(Math.random() * 5)+1;
	}

	//根据f()函数，制作f2()等概率返回0和1
	public static int f2() {
		int ans=0;
		do {
			ans = f();
		}while (ans == 3);
		return ans<3?0:1;
	}
//	1~7随机，2¹+2²+2³=1+2+4=7>=7,既三位2进制数000~111等概率返回，得出0~7等概率随机
	public static int f3() {
		return (f2()<<2)+(f2()<<1)+f2();
	}
	//题目要求1~7随机，既0~6随机+1，随机到7就重新随机
	public static int f4() {
		int ans=0;
		do {
			ans = f3();
		}while (ans == 7);
		return ans;
	}
//	1~7随机
	public static int g() {
		return f4()+1;
	}

}
