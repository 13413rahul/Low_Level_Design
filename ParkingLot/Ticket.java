package ParkingLot;

public class Ticket {
    private String ticketNumber;
    private long startTime;
    private long endTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

//    public Ticket(String ticketNumber, long startTime, long endTime, Vehicle vehicle, ParkingSlot parkingSlot) {
//        this.ticketNumber = ticketNumber;
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.vehicle = vehicle;
//        this.parkingSlot = parkingSlot;
//    }

    public static Ticket createTicket(Vehicle vehicle,ParkingSlot parkingSlot){
        Ticket ticket = new Ticket();
        ticket.setParkingSlot(parkingSlot);
        ticket.setStartTime(System.currentTimeMillis());
        ticket.setVehicle(vehicle);
        ticket.setTicketNumber(vehicle.getVehicleNumber() + System.currentTimeMillis());

        return ticket;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
