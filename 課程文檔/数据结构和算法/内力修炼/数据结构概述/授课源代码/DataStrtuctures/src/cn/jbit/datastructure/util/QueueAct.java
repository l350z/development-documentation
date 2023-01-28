package cn.jbit.datastructure.util;

import java.util.Scanner;
public class QueueAct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue LQ=new LinkedQueue();
		Scanner input = new Scanner(System.in);
		System.out.println("请输入前来打饭的人员姓名，输入f表示输入结束：");
		String name=input.next();
		while(!name.equals("f")){
			LQ.push(name);
			name=input.next();
		}

		while(!LQ.isEmpty()){
			System.out.println(LQ.pop()+"打完饭离开打饭队伍。");
		}
	}
}
