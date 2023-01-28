package cn.jbit.datastructure.util;

public class ArraySort {
	public static LinearList Sort(LinearList ST,int placenum)
	{
		if(placenum>=ST.size()){
			return ST;
		}
		int j=Integer.parseInt(ST.get(placenum).toString());
		int element=Integer.parseInt(ST.get(placenum).toString());
		int elementplace=0;
		for(int i=placenum;i<ST.size();i++){			
			if(element>Integer.parseInt(ST.get(i).toString())){
				element=Integer.parseInt(ST.get(i).toString());
				elementplace=i;
			}
		}
		if(elementplace!=0){
			ST.set(placenum, element);
			ST.set(elementplace, j);
		}
		Sort(ST,++placenum);
		return ST;
	}

	public static void main(String[] args) {
		LinearList ST=new SequenceList(6);
		ST.add(23);
		ST.add(45);
		ST.add(16);
		ST.add(7);
		ST.add(42);
		ST.add(3);
		LinearList STSort=Sort(ST,0);
		for(int i=0;i<STSort.size();i++){
			System.out.println(STSort.get(i));
		}
	}
}
