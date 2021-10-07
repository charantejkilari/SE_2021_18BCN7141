package hitWicketq;
import java.io.*;
import java.util.*;
public class Level1 {
	Scanner sc=new Scanner(System.in);
	String[] ar11=new String[5];
	String[] ar22=new String[5];
	char[] pos11=new char[5];
	char[] pos22=new char[5];
	String[][] gridd=new String[5][5];
	
	//intializing
	 public void initialize(String[] ar1,String ar2[],String[][] grid) {
		ar11=ar1;
		ar22=ar2;
		gridd=grid;
	}
	 
	 //game
	 int k=0;
	 public void startGame() {
		 while(true) {
			 if(k%2==0) {
				 System.out.println("Player A's move");
				 String move=sc.nextLine();
				 if(checkInput(move,k)) {
					 updateGrid(move,k);
					 printGrid();
					 k++;
				 }
				 else {
					 System.out.println("Invalid Input");
				 }
			 }
			 else {
				 System.out.println("Player B's move");
				 String move=sc.nextLine();
				 if(checkInput(move,k)) {
					 updateGrid(move,k);
					 printGrid();
					 k++;
				 }
				 else {
					 System.out.println("Invalid Input");
				 } 
			 }
		 }
	 }
	 public boolean checkInput(String s,int k) {
		 String player="";
		 char a,b;
		 a=s.charAt(0);
		 b=s.charAt(1);
		 player=player+a+b;
		 if(k%2==0) {
			 if(Arrays.toString(ar11).contains(player)) {
				 return true;
			 }
		 }
		 else {
			 if(Arrays.toString(ar22).contains(player)) {
				 return true;
			 } 
		 }
		 return false;
	 }
	 public void updateGrid(String m,int p) {
		 String player="";//player's charcter
		 char mm=m.charAt(3);//move
		 char a,b;
		 a=m.charAt(0);
		 b=m.charAt(1);
		 player=player+a+b;
		 playerMove(k,mm,player);
			
		 
	 }
	 
	 public void playerMove(int k,char mm, String player) {
		 if(k%2==0) {
			 int[] index=new int[2];
			index=getIndex(player,k);
			 if(mm=='F') {
				 String temp=player;
				 gridd[index[0]][index[1]]="-";
				 gridd[index[0]-1][index[1]]=temp;
			 }
		 }
		 else {
			 int[] index=new int[2];
				index=getIndex(player,k);
			 if(mm=='F') {
				 String temp=player;
				 gridd[index[0]][index[1]]="-";
				 gridd[index[0]+1][index[1]]=temp; 
			 } 
		 }
	 }
	 void printGrid() {
		 for(int i=0;i<5;i++) {
			 for(int j=0;j<5;j++) {
				 if(gridd[i][j]!=null) {
				 System.out.print(gridd[i][j]+" ");
				 }
				 else {
					 System.out.print("-"+" ");
				 }
			 }
			 System.out.println();
		 }
	 }
	 
	 public int[] getIndex(String player,int k) {
		 int index[]=new int[2];
		 if(k%2==0) {
			 for(int i=0;i<5;i++) {
				 for(int j=0;j<5;j++) {
					 if(player==gridd[i][j]) {
						 index[0]=i;
						 index[1]=j;
						 break;
					 }
				 }
			 }
		 }
		 return index;
	 }
		 
	 
	public static void main(String[] args) {
		Level1 l=new Level1();
		Scanner sc=new Scanner(System.in);
		String[] ar1=new String[5];
		String[] ar2=new String[5];
		char[] pos1=new char[5];
		char[] pos2=new char[5];
		String[][] grid=new String[5][5];
		//player 1 selects their character
		for(int i=0;i<5;i++) {
			ar1[i]=sc.nextLine();
			grid[4][i]=ar1[i];
		}
		//---------------
		//print grid
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(grid[i][j]!=null) {
					System.out.print(grid[i][j]+" ");
				}
				else {
					System.out.print("-"+" ");
				}
			}
			System.out.println();
		}
		//--------------
		
		
		//player 2 select their character
		for(int i=0;i<5;i++) {
			ar2[i]=sc.nextLine();
			grid[0][i]=ar2[i];
		}
		//---------------
		//print grid
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(grid[i][j]!=null) {
					System.out.print(grid[i][j]+" ");
				}
				else {
					System.out.print("-"+" ");
				}
			}
			System.out.println();
		}
		//-------------------
		l.initialize(ar1, ar2, grid);
		l.startGame();
		l.printGrid();
		
	}
}
