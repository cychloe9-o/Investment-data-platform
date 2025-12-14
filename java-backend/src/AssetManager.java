import java.util.ArrayList;
import java.util.List;;

public class AssetManager {
    private ArrayList<Asset> assets;

    public AssetManager(){
        assets = new ArrayList<>();
    }

    public void addAsset(Asset a){
        assets.add(a);
    }

    public void printAllReports() {
        for (Asset a : assets) {
            if (a instanceof Reportable) {
                //if asset don't have the interface, but it points to stock who has the interface
                //to change it into reportable interface usable - downcasting
                Reportable r = (Reportable) a; 
                System.out.println(r.generateReport());
            }
        }
    }

    public List<Asset> sortByReturn(){
        return assets.stream().sorted((a, b)->{
            double r1 = ((ReturnCalculable)a).getReturn();
            double r2 = ((ReturnCalculable)b).getReturn();
            return Double.compare(r2, r1);
        }).toList();
    }


    public ArrayList<Asset> filterHighReturn(double threshold) {
        ArrayList<Asset> result = new ArrayList<>();

        for (Asset a : assets) {
            //downcasting as above
            if (a instanceof ReturnCalculable rc) {
                if (rc.getReturn() >= threshold) {
                    result.add(a);
                }
            }
        }
        return result;
    }

}
