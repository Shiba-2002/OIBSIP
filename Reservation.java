
public class Reservation {
    private static int counter = 1000;
    private int pnr;
    private String passengerName;
    private int trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String from;
    private String to;

    public Reservation(String passengerName, int trainNumber, String trainName, String classType, String dateOfJourney, String from, String to) {
        this.pnr = counter++;
        this.passengerName = passengerName;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.from = from;
        this.to = to;
    }

    public int getPnr() {
        return pnr;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr + ", Passenger: " + passengerName + ", Train: " + trainNumber + " - " + trainName +
                ", Class: " + classType + ", Date: " + dateOfJourney + ", From: " + from + ", To: " + to;
    }
}
