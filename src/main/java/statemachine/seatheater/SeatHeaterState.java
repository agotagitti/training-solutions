package statemachine.seatheater;

public enum SeatHeaterState {

    OFF{
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    },
    ONE {
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    },
    TWO{
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    THREE{
        @Override
        public SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    };

    public SeatHeaterState next() {
        return SeatHeaterState.OFF;
    }

}
