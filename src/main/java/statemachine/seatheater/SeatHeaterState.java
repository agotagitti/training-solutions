package statemachine.seatheater;

public enum SeatHeaterState {

    OFF{
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.THREE;
        }
    },
    ONE {
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.OFF;
        }
    },
    TWO{
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.ONE;
        }
    },
    THREE{
        @Override
        SeatHeaterState next() {
            return SeatHeaterState.TWO;
        }
    };

    abstract SeatHeaterState next();

}
