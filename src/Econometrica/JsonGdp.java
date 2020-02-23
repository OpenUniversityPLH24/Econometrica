package Econometrica;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

public class JsonGdp {
    private DataSet dataset;
    
    public JsonGdp(DataSet dataset) {
        this.dataset = dataset;
    }

    public DataSet getDataset() {
        return dataset;
    }  

    @Override
    public String toString() {
        return "JsonGdp{" + "dataset=" + dataset + '}';
    }
}