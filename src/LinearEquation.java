public class LinearEquation {

    int x1;
    int y1;
    int x2;
    int y2;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public double distance() {
        double howLong;
        howLong = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        return roundedToHundredth(howLong);
    }

    public double slope() {
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public double yIntercept() {
        double intercept = y1 - (slope() * x1);
        return intercept;
    }

    public String equation() {
        String inSlope;
        String theY = "";

        if (y2 == y1) {
            return "y = " + yIntercept();
        }

        if (((double) (y2 - y1) / (double) (x2 - x1)) == 1){
            inSlope = "";
        }

        else if (((double) (y2 - y1) / (double) (x2 - x1)) == -1) {
            inSlope = "-";
        }

        else if ((y2 - y1) % (x2 - x1) == 0) {
            inSlope = "" + ((y2 - y1) / (x2 - x1));
        }

        else if (((y2 - y1) < 0) && ((x2 - x1) < 0)) {
            inSlope = Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        }

        else if (((y2 - y1) < 0) || 0 > (x2 - x1)){
            inSlope = "-" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        }

        else {
            inSlope = (y2 - y1) + "/" + (x2 - x1);
        }

        if ((yIntercept() == 0) &&  (slope() == 0)) {
            return "y = 0";
        }
        else if (yIntercept() == 0) {
            theY = "";
        }
        else if (yIntercept() < 0) {
            theY = "- " + Math.abs(yIntercept());
        }
        else {
            theY = "+ " + yIntercept();
        }

        return "y = " + inSlope + "x " + theY;
    }

    public String coordinateForX(double x) {

        double y = y1 + (slope() * (x - x1));

        return "(" + (double) x + ", " + y + ")";
    }

    public String lineInfo() {
        String one = "The two points are (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        String two = "The equation of the line between these points is: " + equation();
        String three = "The y-intercept of this line is: " + yIntercept();
        String four = "The slope of this line is: " + slope();
        String five = "The distance between these points is " + distance();   //idk if Im supposed to add a : after the "is", I thought it might be something thats used to catch people using ai for the assignment

        return one + "\n" + two + "\n" + three + "\n" + four + "\n" + five;
    }

    private double roundedToHundredth(double toRound) {

        return (Math.round(toRound * 100) / 100.0);
    }

}
