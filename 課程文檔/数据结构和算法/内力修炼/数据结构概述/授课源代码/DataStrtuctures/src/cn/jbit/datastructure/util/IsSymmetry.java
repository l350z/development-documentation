package cn.jbit.datastructure.util;

public class IsSymmetry {

	public static boolean IsSymmetry(String args)
	{
		Stack SS=new SequenceStack();
		int size=args.length();
		for(int i=0;i<size;i++){
			char charj=args.charAt(i);
			switch(charj){
			case 123: //对应"{"
				SS.push("{");
				break;
			case 91:  //对应"["
				SS.push("[");
				break;
			case 40:  //对应"("
				SS.push("(");
				break;
			case 41:  //对应")"
				System.out.println(SS.pop().equals("("));
				break;
			case 93:  //对应"]"
				System.out.println(SS.pop().equals("["));
				break;
			case 125: //对应"}"
				System.out.println(SS.pop().equals("{"));
				break;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String symbolString="{ss[aa(bb)]}";
		IsSymmetry(symbolString);
	}
}
