package kmeans;

import java.util.Arrays;

public class kmeanscode {

	public static void main(String[] args) {
		
		int med[][]= new int[2][4];
		double dist[][]= new double[2][4];
		int group[][] = new int[2][4];
		int prevcent[][] = new int[2][2];
		int newcent[][] = new int[2][2];
		boolean compare = false;
		med[0][0] = 1;
		med[0][1] = 2;
		med[0][2] = 4;
		med[0][3] = 5;
		med[1][0] = 1;
		med[1][1] = 1;
		med[1][2] = 3;
		med[1][3] = 4;
		
		System.out.println("input Matrix:");
		
		for(int i=0;i<2;i++){
			System.out.print("\t{");
			for(int j=0;j<4;j++){
				System.out.print("["+med[i][j]+"]");
			}
			System.out.println("}");
		}
		
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				newcent[i][j]=med[i][j];
			}
		}
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				prevcent[i][j]=newcent[i][j];
			}
		}
		

		System.out.println("Initial centroids: ["+newcent[0][0]+","+newcent[1][0]+"]["+newcent[0][1]+","+newcent[1][1]+"]");
		
		while(compare!= true){
			
			System.out.println("Centroids: ["+newcent[0][0]+","+newcent[1][0]+"]["+newcent[0][1]+","+newcent[1][1]+"]");
			
			
		double num1;
		double num2;
		double ucldist;
			
			for(int j=0;j<4;j++){
				
				int i = 0;
				num1 = Math.pow((med[i][j]-newcent[0][0]),2);
				num2 = Math.pow((med[i+1][j]-newcent[1][0]),2);
				ucldist = Math.sqrt(num1 + num2);
				
				dist[i][j]= (int) ucldist;
				
				num1 = Math.pow((med[i][j]-newcent[0][1]),2);
				num2 = Math.pow((med[i+1][j]-newcent[1][1]),2);
				ucldist = Math.sqrt(num1 + num2);
				
				dist[i+1][j]=(int)ucldist;
			}
			
			System.out.println("\nThe Distance matrix:");
			for(int i=0;i<2;i++){
				System.out.print("\t{");
				for(int j=0;j<4;j++){
					System.out.print("["+dist[i][j]+"]");
				}
				System.out.println("}");
			}
			
			for(int j=0;j<4;j++){
				
				int i = 0;
				
				if(dist[i][j] <= dist[i+1][j]){
					group[i][j] = 1;
					group[i+1][j] = 0;
					
				}else{
					group[i][j] = 0;
					group[i+1][j] = 1;
				}	
				
			}
			
			System.out.println("\nThe Group matrix:");
			for(int i=0;i<2;i++){
				System.out.print("\t{");
				for(int j=0;j<4;j++){
					System.out.print("["+group[i][j]+"]");
				}
				System.out.println("}");
			}
			
			
			int x=0,x1=0,y1=0,y=0,counter=0,counter1=0;
			
			for(int j=0;j<4;j++){
				
				int i = 0;
				
				if(group[i][j] == 1){
					counter ++;
					
					x = x + med[i][j];
					y = y + med[i+1][j];
				}
				if(group[i+1][j] == 1){
					counter1 ++;
					
					x1 = x1 + med[i][j];
					y1 = y1 + med[i+1][j];
				}
				
			}
			
			
			newcent[0][0] = x/counter;
			newcent[1][0] = y/counter;
			newcent[0][1] = x1/counter1;
			newcent[1][1] = y1/counter1;
			
			compare = Arrays.deepEquals(prevcent, newcent);
			
			for(int i=0;i<2;i++){
				for(int j=0;j<2;j++){
					prevcent[i][j]=newcent[i][j];
				}
			}
			
			System.out.println("==================================================================================================");
			
		}
		
		for(int i=0;i<2;i++){
			System.out.print("Group "+ (i+1) +" has: {");
			
			for(int j=0;j<4;j++){
				
				if(group[i][j] == 1){
					if(i==0){
					System.out.print("["+med[i][j]+"]["+med[i+1][j]+"]");
						System.out.print(",");
					
					}else{
						int temp = 0;
						System.out.print("["+med[temp][j]+"]["+med[i][j]+"]");
					}
					
				}
			}
			System.out.println("}");
		}
		
	}

}
