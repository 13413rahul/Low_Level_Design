package elevator;

import java.util.PriorityQueue;

public class Elevator {
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upQueue;
    PriorityQueue<Request> downQueue;

    public Elevator(int currentFloor) {
        this.currentFloor = currentFloor;

        this.direction = Direction.IDLE;

        // use default, which is a min heap
        upQueue = new PriorityQueue<>((a, b) -> a.desiredFloor - b.desiredFloor);

        // use a max heap
        downQueue =  new PriorityQueue<>((a, b) -> b.desiredFloor - a.desiredFloor);
    }

    public void sendUpRequest(Request upRequest) {
        // If the request is sent from out side of the elevator,
        // we need to stop at the current floor of the requester
        // to pick him up, and then go the the desired floor.
        if (upRequest.location == Location.OUTSIDE_ELEVATOR) {
            // Go pick up the requester who is outside of the elevator
            upQueue.offer(new Request(upRequest.currentFloor,
                    upRequest.currentFloor,
                    Direction.UP,
                    Location.OUTSIDE_ELEVATOR));

            System.out.println("Append up request going to floor " + upRequest.currentFloor + ".");
        }

        // Go to the desired floor
        upQueue.offer(upRequest);

        System.out.println("Append up request going to floor " + upRequest.desiredFloor + ".");
    }

    public void sendDownRequest(Request downRequest) {
        // Similar to the sendUpRequest logic
        if (downRequest.location == Location.OUTSIDE_ELEVATOR) {
            downQueue.offer(new Request(downRequest.currentFloor,
                    downRequest.currentFloor,
                    Direction.DOWN,
                    Location.OUTSIDE_ELEVATOR));

            System.out.println("Append down request going to floor " + downRequest.currentFloor + ".");
        }

        // Go to the desired floor
        downQueue.offer(downRequest);

        System.out.println("Append down request going to floor " + downRequest.desiredFloor + ".");
    }

    public void run() {
        while (!upQueue.isEmpty() || !downQueue.isEmpty()) {
            processRequests();
        }

        System.out.println("Finished all requests.");
        this.direction = Direction.IDLE;
    }

    private void processRequests() {
        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    private void processUpRequest() {
        while (!upQueue.isEmpty()) {
            Request upRequest = upQueue.poll();
            // Communicate with hardware
            this.currentFloor = upRequest.desiredFloor;
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if (!downQueue.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    private void processDownRequest() {
        while (!downQueue.isEmpty()) {
            Request downRequest = downQueue.poll();
            // Communicate with hardware
            this.currentFloor = downRequest.desiredFloor;
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if (!upQueue.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }

}
