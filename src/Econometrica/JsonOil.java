package Econometrica;

/**
 *
 * @author Μπορότης Βασίλειος
 * @author Ντουλάκης Ευστράτιος
 * @author Ντάφος Χρήστος
 */

public class JsonOil {
    private DataSet dataset;

    public JsonOil(DataSet dataset) {
        this.dataset = dataset;
    }

    public DataSet getDataset() {
        return dataset;
    }

    @Override
    public String toString() {
        return "JsonOil{" + "dataset=" + dataset + '}';
    }
}