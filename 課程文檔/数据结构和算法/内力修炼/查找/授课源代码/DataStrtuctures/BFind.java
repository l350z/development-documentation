
public class BFind {
	public static void main(String[] args) {
		int[] data={7,16,23,42,45};
		int findData=45;
		int len=data.length;	
		int low=0;
		int high=len-1;
		while(low<=high){
			int middle=(low+high)/2;
			if(findData==data[middle])
			{
				System.out.println("查找成功，位于data["+middle+"]");
				return;
			}
			else if( findData <data[middle] )
				high=middle-1;
			else
				low=middle+1;
		}
	     System.out.println("查找失败");
	} 

}
