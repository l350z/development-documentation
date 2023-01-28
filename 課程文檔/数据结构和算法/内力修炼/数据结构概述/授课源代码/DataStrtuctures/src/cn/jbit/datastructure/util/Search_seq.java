package cn.jbit.datastructure.util;

public class Search_seq {
	public static int Search_seq(LinearList ST,String key)
	{
		int i=0;
		while(!ST.get(i).equals(key))
				i++;
		return i;
	}

	public static void main(String[] args) {
		LinearList ST=new SequenceList();
		String key="S";
		ST.add("A");
		ST.add("D");
		ST.add("F");
		ST.add("G");
		ST.add("H");
		ST.add("J");
		ST.add("K");
		ST.add("L");
		ST.add("S");
		ST.add("Q");
		int i=Search_seq(ST,key);
		System.out.println("在"+i+"位置查找到了S关键字。");
	}
}
