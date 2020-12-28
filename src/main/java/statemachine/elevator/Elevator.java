package statemachine.elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator {

    private List<ElevatorStatus> history = new ArrayList<>();
    private ElevatorStatus elevatorStatus;
    private ElevatorStatus target;

    public Elevator() {
        this.elevatorStatus = ElevatorStatus.GROUND_OPEN;
        history.add(elevatorStatus);
    }

    public void pushButtonToGoToFirstFloor() {
        target = ElevatorStatus.FIRST_OPEN;
    }

    public  void pushButtonToGoToGroundFloor() {
        target = ElevatorStatus.GROUND_OPEN;
    }

    public void pushCallButtonOnGroundFloor() {
        pushButtonToGoToGroundFloor();
    }

    public void work() {
        while (elevatorStatus != target) {
            if (target == ElevatorStatus.GROUND_OPEN) {
                elevatorStatus = elevatorStatus.down();
            } else {
                elevatorStatus = elevatorStatus.up();
            }
            history.add(elevatorStatus);
        }
    }

    public String getHistory() {
        return history.toString();
    }

}
