package immutable.satellite;

public class Satellite {

    private CelestialCoordinates destinationCoordinates;
    private String registerIdent;

    public Satellite(CelestialCoordinates destinationCoordinates, String registerIdent) {
        if (isEmpty(registerIdent)) {
            throw new IllegalArgumentException("Register ident must not be empty!");
        }
        this.destinationCoordinates = destinationCoordinates;
        this.registerIdent = registerIdent;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        destinationCoordinates = new CelestialCoordinates(destinationCoordinates.getX() + diff.getX(),
                destinationCoordinates.getY() + diff.getY(), destinationCoordinates.getZ() + diff.getZ());
    }

    public String toString() {
        //"ASD567: CelestialCoordinates: x=14, y=25, z=47"
        return registerIdent + ": " + destinationCoordinates;
    }

    private boolean isEmpty(String string) {
        return string == null || "".equals(string.trim());
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }
}
