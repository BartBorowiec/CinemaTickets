package uph.ii.borowiec.cinematickets.entity;

public class Seat {
    int rowNumber;
    int seatNumber;
    boolean isTaken;

    public Seat() {
    }

    public Seat(int rowNumber, int seatNumber) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.isTaken = false;
    }

    public Seat(int rowNumber, int seatNumber, boolean isTaken) {
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
        this.isTaken = isTaken;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean getIsTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean isTaken) {
        this.isTaken = isTaken;
    }

    public void setIsTakenForScreening(Screening screening) {
        for (Reservation reservation : screening.getReservations())
            for (Ticket ticket : reservation.getTickets())
                if (seatNumber == ticket.getSeatNumber() && rowNumber == ticket.getSeatRow())
                    setIsTaken(true);
    }

    @Override
    public String toString() {
        return "Rząd: " + rowNumber + ", miejsce: " + seatNumber + ", zajęte: " + (isTaken ? "tak" : "nie") + "\n";
    }
}
