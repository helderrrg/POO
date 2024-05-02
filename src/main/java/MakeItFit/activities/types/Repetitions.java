package MakeItFit.activities.types;

import MakeItFit.activities.Activity;
import MakeItFit.utils.MakeItFitDate;

import java.util.UUID;

public abstract class Repetitions extends Activity {
    private int repetitions;
    private int series;

    public Repetitions(UUID userCode, MakeItFitDate realizationDate, int expectedDuration, String designation, int repetitions, int series) {
        super(userCode, realizationDate, expectedDuration, designation);
        this.repetitions = repetitions;
        this.series = series;
    }

    public Repetitions(Repetitions r){
        super(r);
        this.repetitions = r.getRepetitions();
        this.series = r.getSeries();
    }

    public int getRepetitions() {
        return repetitions;
    }

    public int getSeries() {
        return series;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public abstract int calculateCaloricWaste();

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Repetitions)) return false;
        Repetitions r = (Repetitions) o;
        return (super.equals(r) && this.repetitions == r.repetitions && this.series == r.series);
    }

    public abstract Repetitions clone();

    @Override
    public String toString(){
        return super.toString() + "Repetitions: " + this.repetitions + ", " + "Series: " + this.series + "\n";
    }
}
