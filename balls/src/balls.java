import java.util.List;
import java.util.ArrayList;
public class balls {
    public zustand ourclass=new zustand();
    public static boolean iststartende(zustand z1,zustand z2){
        if(!z1.b1.equals(z2.b1)) return false;
        if(!z1.b2.equals(z2.b2)) return false;
        if(!z1.b3.equals(z2.b3)) return false;
        return true;
    }
    public static List<uebergang> getto(List<uebergang> s, zustand z1, zustand ze, int t){
        if(iststartende(z1,ze)) return s;
        if(s.size()>=t) return null;
        List<uebergaenge> r=new ArrayList<uebergaenge>();
        //Übergänger zu b1 
        if(z1.b1.size()<3){
            if(z1.b2.size()>0){
                //Übergang b2 zu b1
                zustand zneu=new zustand(z1); 
                zneu.b1.add(z1.b2.get(z1.b2.size()-1));
                zneu.b2.remove(z1.b2.size()-1);
                s.add(new uebergang(z1,zneu));
                List<uebergang> sneu=getto(s,zneu,ze,t);
                if(sneu!=null) r.add(new uebergaenge(sneu));
                s.remove(s.size()-1);
            }
            if(z1.b3.size()>0){
                //Übergang b3 zu b1
                zustand zneu=new zustand(z1); 
                zneu.b1.add(z1.b3.get(z1.b3.size()-1));
                zneu.b3.remove(z1.b3.size()-1);
                s.add(new uebergang(z1,zneu));
                List<uebergang> sneu=getto(s,zneu,ze,t);
                if(sneu!=null) r.add(new uebergaenge(sneu));
                s.remove(s.size()-1);
            }
        }
        //Übergänger zu b2
        if(z1.b2.size()<3){
            if(z1.b1.size()>0){
                //Übergang b1 zu b2
                zustand zneu=new zustand(z1); 
                zneu.b2.add(z1.b1.get(z1.b1.size()-1));
                zneu.b1.remove(z1.b1.size()-1);
                s.add(new uebergang(z1,zneu));
                List<uebergang> sneu=getto(s,zneu,ze,t);
                if(sneu!=null) r.add(new uebergaenge(sneu));
                s.remove(s.size()-1);
            }
            if(z1.b3.size()>0){
                //Übergang b3 zu b2
                zustand zneu=new zustand(z1); 
                zneu.b2.add(z1.b3.get(z1.b3.size()-1));
                zneu.b3.remove(z1.b3.size()-1);
                s.add(new uebergang(z1,zneu));
                List<uebergang> sneu=getto(s,zneu,ze,t);
                if(sneu!=null) r.add(new uebergaenge(sneu));
                s.remove(s.size()-1);
            }
        }
        //Übergänger zu b3
        if(z1.b3.size()<2){
            if(z1.b1.size()>0){
                //Übergang b1 zu b3
                zustand zneu=new zustand(z1); 
                zneu.b3.add(z1.b1.get(z1.b1.size()-1));
                zneu.b1.remove(z1.b1.size()-1);
                s.add(new uebergang(z1,zneu));
                List<uebergang> sneu=getto(s,zneu,ze,t);
                if(sneu!=null) r.add(new uebergaenge(sneu));
                s.remove(s.size()-1);
            }
            if(z1.b2.size()>0){
                //Übergang b2 zu b3
                zustand zneu=new zustand(z1); 
                zneu.b3.add(z1.b2.get(z1.b2.size()-1));
                zneu.b2.remove(z1.b2.size()-1);
                s.add(new uebergang(z1,zneu));
                List<uebergang> sneu=getto(s,zneu,ze,t);
                if(sneu!=null) r.add(new uebergaenge(sneu));
                s.remove(s.size()-1);
            }
        }
        if(r.isEmpty()) return null;
        int imax=0;
        for(int i=1;i<r.size();i++) if(r.get(i).u.size()<r.get(imax).u.size()){
            imax=i;
        }
        for(int i=s.size();i<r.get(imax).u.size();i++) s.add(r.get(imax).u.get(i));
        return s;
    }
    public static void main(String[] args) {
        zustand start = new zustand(); //Buchstabe=Zahl, 1. Element=Index 0
        zustand ende = new zustand();
        //Startzustand definieren
        start.b2.add(1);
        start.b2.add(2);
        start.b2.add(3);
        start.b3.add(4);
        start.b3.add(5);
        //Endzustand definieren
        ende.b1.add(2);
        ende.b1.add(3);
        ende.b2.add(4);
        ende.b2.add(1);
        ende.b3.add(5);
        int t=1;
        while(true){
            List <uebergang> min = getto(new ArrayList<uebergang>(), start,ende,t);
            if(min!=null) {
                System.out.print("Ball-Verschiebungen: "+(min.size()));
                start.zeigzustand();
                for(int i=0;i<min.size();i++) min.get(i).z2.zeigzustand();
                System.exit(101);
            }
            t+=1;
        }
    }
}
