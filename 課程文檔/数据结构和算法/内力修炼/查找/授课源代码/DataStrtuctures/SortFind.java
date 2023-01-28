//顺序查找
public class SortFind {
	public static void main(String[] args) {
		int[] data={16,42,23,7,45};
		int len=data.length;	
		int findData=7;
		for(int i=0;i<len;i++){
			if(data[i]==findData){
				System.out.print("查找成功！");
				break;
			}
			
			if(i==len-1)
				System.out.print("查找失败！");
			
			
		}

		
	}

}
