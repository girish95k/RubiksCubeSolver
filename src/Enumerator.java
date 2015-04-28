import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Girish
 */
public class Enumerator {
    private int maxDepth;
    private int currentDepth;
    private int currentPerm;
    private String alphabet;
    
    static int b[], c[];

    public Enumerator(String alphabet, int d) {
        this.maxDepth = d;
        this.currentDepth = 1;
        this.currentPerm = 0;
        this.alphabet = alphabet;
    }

    public boolean next() {
        int numPermutations = (int) Math.pow(alphabet.length(), this.currentDepth);
        boolean res=false;

        // finished if
        if ((this.currentDepth == this.maxDepth) && 
            (this.currentPerm == numPermutations - 1)) {
            res = false;
        }
        // next perm at this depth
        else if (this.currentPerm < numPermutations - 1) {
            this.currentPerm++;
            res = true;
        }
        // next depth
        else if (this.currentDepth <= this.maxDepth) {
            this.currentDepth++;
            this.currentPerm = 0;
            res = true;
        }
        return res;
    }

    public String getPermutation() {
        int tmpPerm = this.currentPerm;
        String res = "";
        for (int i=0; i<this.currentDepth; i++) {
          int ind = tmpPerm % this.alphabet.length();
          res = this.alphabet.charAt(ind) + res;
          tmpPerm /= this.alphabet.length();
        }
        return res;
    }

    public static void main(String args[]) {
        
        
        
        System.out.println("Enter the scramble: ");
        Scanner s = new Scanner(System.in);
        String scramble = s.nextLine();
        
        String[] move = scramble.split("");
        
        int state[] = {1,2,3,4,5,6,7,8};


        int state1[] = new int[4];
        int state2[] = new int[4];
        
        
        for(int i=0; i<state.length/2; i++)
        {
            state1[i]=state[i];
        }
        for(int i=state.length/2; i<state.length; i++)
        {
            state2[i-4]=state[i];
        }
        
        
        for(int i=0; i<move.length; i++)
        {
        	System.out.print(move[i]);
        	if(move[i].equals("U"))
        	{
        		int temp1 = state1[0];
                for(int j=0; j<state1.length-1; j++)
                {
                   state1[j]=state1[j+1]; 
                }
                state1[3]=temp1;
        	}
        	else if(move[i].equals("F"))
        	{
        		int temp1=state1[1];
                int temp2=state1[2];
                int temp3=state2[2];
                int temp4=state2[1];
                
                state1[2]=temp1;
                state2[2]=temp2;
                state2[1]=temp3;
                state1[1]=temp4;
        	}
        	else if(move[i].equals("D"))
        	{
        		int temp1 = state2[state2.length-1];
                for(int j=state2.length-1; j>0; j--)
                {
                   state2[j]=state2[j-1]; 
                }
                state2[0]=temp1;
        	}
        	else if(move[i].equals("R"))
        	{
        		int temp1=state1[2];
                int temp2=state1[3];
                int temp3=state2[3];
                int temp4=state2[2];
                
                state1[3]=temp1;
                state2[3]=temp2;
                state2[2]=temp3;
                state1[2]=temp4;
        	}
        	else if(move[i].equals("L"))
        	{
        		int temp1=state1[0];
                int temp2=state1[1];
                int temp3=state2[1];
                int temp4=state2[0];
                
                state1[1]=temp1;
                state2[1]=temp2;
                state2[0]=temp3;
                state1[0]=temp4;
        	}
        	else if(move[i].equals("B"))
        	{
        		int temp1=state1[3];
                int temp2=state1[0];
                int temp3=state2[0];
                int temp4=state2[3];
                
                state1[0]=temp1;
                state2[0]=temp2;
                state2[3]=temp3;
                state1[3]=temp4;
        	}
        }
        for(int i=0; i<state1.length; i++)
        {
        	System.out.print(state1[i]);
        }
        System.out.println();
        for(int i=0; i<state2.length; i++)
        {
        	System.out.print(state2[i]);
        }
        System.out.println();
        
        //int a[] = {2,6,8,4,5,7,3,1};
        //int a[] = {6,3,7,5,2,4,8,1};
        //int a[] = {1,3,7,4,5,2,6,8};
        //int a[] = {7,8,4,5,6,3,2,1};
        //int a[] = {5,6,7,8,1,2,3,4};
        int a[] = new int[8];

        for(int i=0; i<state1.length; i++)
        {
            a[i]=state1[i];
        }
        int j =4;
        for(int i=0; i<state2.length; i++)
        {
            a[j]=state2[i];
            j++;
        }
        
        b = new int[4];
        c = new int[4];
        for(int i=0; i<a.length/2; i++)
        {
            b[i]=a[i];
        }
        for(int i=a.length/2; i<a.length; i++)
        {
            c[i-4]=a[i];
        }
        
        int depth = 10;
        String alphabet = "0123";
        Enumerator e = new Enumerator(alphabet, depth); 
        do {
            String perm = e.getPermutation();
            System.out.println(perm);
            
            boolean result = check(perm);
            if(result==true)
            {
                System.out.println("Solution: " + perm);
                break;
            }
            
        } while (e.next());
        
        for(int i=0; i<state1.length; i++)
        {
        	System.out.print(state1[i]);
        }
        System.out.println();
        for(int i=0; i<state2.length; i++)
        {
        	System.out.print(state2[i]);
        }
        
    }
    
    public static boolean check(String perm)
    {
        String moves[] = perm.split("");
        for(int i=0; i<moves.length;i++)
        {
            //System.out.println(moves[i]);
        }
        int flag=1;
        //int b1[]=b, c1[]=c;
        
        int b1[], c1[];
        b1=new int[b.length];
        c1=new int[c.length];
        for(int i=0; i<b.length; i++)
        {
            b1[i]=b[i];
            c1[i]=c[i];
        }
        for(int i=0; i<moves.length; i++)
        {
            if(moves[i].equals("0"))        //exchange rows
            {
                int temp[] = b1;
                b1=c1;
                c1=temp;
                
                int t;
                t = b1[0];
                b1[0]=b1[1];
                b1[1] = t;
                
                t = c1[0];
                c1[0]=c1[1];
                c1[1] = t;
                
                t = b1[2];
                b1[2]=b1[3];
                b1[3] = t;
                
                t = c1[2];
                c1[2]=c1[3];
                c1[3] = t;
                
            }
             else if(moves[i].equals("2"))  //turn face clockwise
            {
                int temp1=b1[1];
                int temp2=b1[2];
                int temp3=c1[2];
                int temp4=c1[1];
                
                //System.out.println("2" + temp1 + temp2 +temp3 + temp4 + b1[0]);
                b1[2]=temp1;
                c1[2]=temp2;
                c1[1]=temp3;
                b1[1]=temp4;
            }
            else if(moves[i].equals("1"))   //right rotate cube
            {
                int temp1 = b1[b1.length-1];
                int temp2 = c1[c1.length-1];
                for(int j=b1.length-1; j>0; j--)
                {
                   b1[j]=b1[j-1];
                   c1[j]=c1[j-1]; 
                }
                b1[0]=temp1;
                c1[0]=temp2;
            }
            else if(moves[i].equals("3"))
            {
                int temp1 = b1[b1.length-1];
                for(int j=b1.length-1; j>0; j--)
                {
                   b1[j]=b1[j-1]; 
                }
                b1[0]=temp1;
            }
           
        }
        for(int i=0; i<b1.length; i++)
        {
            //System.out.println("flag");
            if(!((b1[i]==(i+1))&&(c1[i]==(i+4+1))))
                    {
                        flag=0; //System.out.println("flag");
                        //System.out.println("falg=0" + b1[i] + (i+1) + c1[i] + (i+4+1));
                    }
        }
        for(int i=0; i<b1.length; i++)
        {
            System.out.print(b1[i]);
        }
        for(int i=0; i<c1.length; i++)
        {
            System.out.print(c1[i]);
        }
        System.out.println();
        if(flag==1)
            return true;
        else
            return false;
    }
}

/*
1 rgw
2 gow
3 obw
4 brw
5 ryg
6 gyo
7 oyb
8 byr

5738
1624
*/