import java.util.List;
import java.util.ArrayList;
public class zustand{
    List<Integer> b1;
    List<Integer> b2;
    List<Integer> b3;
    public zustand(){
        b1=new ArrayList<Integer>();
        b2=new ArrayList<Integer>();
        b3=new ArrayList<Integer>();
    }
    public zustand(zustand z){
        b1=new ArrayList<Integer>();
        b2=new ArrayList<Integer>();
        b3=new ArrayList<Integer>();
        for(int i=0;i<z.b1.size();i++) this.b1.add(z.b1.get(i));
        for(int i=0;i<z.b2.size();i++) this.b2.add(z.b2.get(i));
        for(int i=0;i<z.b3.size();i++) this.b3.add(z.b3.get(i));
    }
    public void zeigzustand(){
        System.out.print("\nBin 1: ");
        for(int i=0;i<this.b1.size();i++){
            if(i==this.b1.size()-1) System.out.print((this.b1.get(i)));
            else System.out.print(this.b1.get(i)+", ");
        }
        System.out.print(" \t\t| Bin 2: ");
        for(int i=0;i<this.b2.size();i++){
            if(i==this.b2.size()-1) System.out.print(this.b2.get(i));
            else System.out.print(this.b2.get(i)+", ");
        }
        System.out.print("       \t| Bin 3: ");
        for(int i=0;i<this.b3.size();i++){
            if(i==this.b3.size()-1) System.out.print((this.b3.get(i)));
            else System.out.print(this.b3.get(i)+", ");
        }
    }
}