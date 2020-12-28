package statemachine.elevator;

public enum ElevatorStatus {

    GROUND_OPEN("Ground Floor Open") {
        @Override
        ElevatorStatus up() {
            return ElevatorStatus.GROUND_CLOSED;
        }

        @Override
        ElevatorStatus down() {
            return ElevatorStatus.GROUND_OPEN;
        }
    },
    GROUND_CLOSED("Ground Floor Closed") {
        @Override
        ElevatorStatus up() {
            return ElevatorStatus.FIRST_CLOSED;
        }

        @Override
        ElevatorStatus down() {
            return ElevatorStatus.GROUND_OPEN;
        }
    },
    FIRST_CLOSED("First Floor Closed") {
        @Override
        ElevatorStatus up() {
            return ElevatorStatus.FIRST_OPEN;
        }

        @Override
        ElevatorStatus down() {
            return ElevatorStatus.GROUND_CLOSED;
        }
    },
    FIRST_OPEN("First Floor Open") {
        @Override
        ElevatorStatus up() {
            return ElevatorStatus.FIRST_OPEN;
        }

        @Override
        ElevatorStatus down() {
            return ElevatorStatus.FIRST_CLOSED;
        }
    };

    private String status;

    ElevatorStatus(String status) {
        this.status = status;
    }

    abstract ElevatorStatus up();

    abstract ElevatorStatus down();

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return getStatus();
    }
}
