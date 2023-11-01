public class uebergang{
    zustand z1;
    zustand z2;
    public uebergang(zustand z1n, zustand z2n){
        z1=new zustand(z1n);
        z2= new zustand(z2n);
    }
    public uebergang(zustand z1n){
        z1=new zustand(z1n);
    }
}