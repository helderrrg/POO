package MakeItFit.activities.implementation;

import MakeItFit.activities.types.DistanceWithAltimetry;

public class Trail extends DistanceWithAltimetry {

    public static final int TRAIL_TYPE_EASY = 0;
    public static final int TRAIL_TYPE_MEDIUM = 1;
    public static final int TRAIL_TYPE_HARD = 2;

    private int trailType;

    public Trail(int expectedDuration, String designation, double distance, double elevationGain, double elevationLoss, int trailType) {
        super(expectedDuration, designation, distance, elevationGain, elevationLoss);
        this.trailType = trailType;
    }

    public Trail(){
        super();
        this.trailType = TRAIL_TYPE_EASY;
    }

    public Trail(Trail t){
        super(t);
        this.trailType = t.getTrailType();
    }

    public int getTrailType() {
        return trailType;
    }

    public void setTrailType(int trailType) {
        if(trailType < TRAIL_TYPE_EASY) this.trailType = TRAIL_TYPE_EASY;
        else if (trailType > TRAIL_TYPE_HARD) this.trailType = TRAIL_TYPE_HARD;
        else this.trailType = trailType;
    }

    public int calculateCaloricWaste(){
        return (int) (
                getDistance() * getElevationGain() * getElevationLoss());
    }

    public String toString(){
        return super.toString() + "Trail Type: " + trailType + "\n";
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (!(o instanceof Trail)) return false;
        Trail t = (Trail) o;
        return super.equals(t) && this.trailType == t.getTrailType();
    }
}
