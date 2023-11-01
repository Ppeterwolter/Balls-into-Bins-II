import java.util.List;
import java.util.ArrayList;
public class uebergaenge{
    List<uebergang> u;
    public uebergaenge(List<uebergang> s){
        u=new ArrayList<uebergang>();
        if(s==null) u=null;
        for(int i=0;i<s.size();i++) u.add(s.get(i));
    }
}