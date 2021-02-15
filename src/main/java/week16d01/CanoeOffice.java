package week16d01;

import java.time.LocalDateTime;
import java.util.*;

public class CanoeOffice {

    private List<CanoeRental> canoeRentals = new ArrayList<>();

    public void addRental(CanoeRental canoeRental) {
        canoeRentals.add(canoeRental);
    }

    public CanoeRental findRentalByName(String name) {
        CanoeRental result = null;
        for (CanoeRental actual : canoeRentals) {
            if (actual.getName().equals(name) && actual.getEndTime() == null) {
                result = actual;
                break;
            }
        }
        if (result == null) {
            throw new IllegalArgumentException("No rental by this name " + name);
        }
        return result;
    }

    public CanoeRental closeRentalByName(String name, LocalDateTime endTime) {
        CanoeRental foundRental = findRentalByName(name);
        foundRental.setEndTime(endTime);
        return foundRental;
    }

    public double getRentalPriceByName(String name, LocalDateTime endTime) {
        CanoeRental foundRental = findRentalByName(name);
        closeRentalByName(name, endTime);
        double duration = foundRental.calculateRentalSum();
        return 5000 * duration * foundRental.getCanoeType().getBonus();
    }

    public List<CanoeRental> listClosedRentals() {
        List<CanoeRental> closedRentals = new ArrayList<>();
        for (CanoeRental actual : canoeRentals) {
            if (actual.getEndTime() != null) {
                closedRentals.add(actual);
            }
        }
        Collections.sort(closedRentals, new Comparator<CanoeRental>() {
            @Override
            public int compare(CanoeRental o1, CanoeRental o2) {
                return o1.getStartTime().compareTo(o2.getStartTime());
            }
        });
        return closedRentals;
    }

    public Map<CanoeType, Integer> countRentals() {
        Map<CanoeType, Integer> canoeStatistics = new HashMap<>();
        for (CanoeRental actual : canoeRentals) {
            if (!canoeStatistics.containsKey(actual.getCanoeType())) {
                canoeStatistics.put(actual.getCanoeType(), 0);
            }
            canoeStatistics.put(actual.getCanoeType(), canoeStatistics.get(actual.getCanoeType()) + 1);
        }
        return canoeStatistics;
    }


    public static void main(String[] args) {
        CanoeRental canoeRental = new CanoeRental("One", CanoeType.RED, LocalDateTime.now());
        CanoeRental canoeRental2 = new CanoeRental("Two", CanoeType.BLUE, LocalDateTime.of(2021, 01, 01, 10, 05));
        CanoeRental canoeRental3 = new CanoeRental("Three", CanoeType.GREEN, LocalDateTime.of(2021, 02, 14, 12, 05));

        CanoeOffice canoeOffice = new CanoeOffice();
        canoeOffice.addRental(canoeRental);
        canoeOffice.addRental(canoeRental2);
        canoeOffice.addRental(canoeRental3);
        System.out.println(canoeOffice.canoeRentals.size());

        System.out.println(canoeOffice.findRentalByName("Two"));
        System.out.println(canoeOffice.getRentalPriceByName("Three", LocalDateTime.now()));
        canoeOffice.closeRentalByName("One", LocalDateTime.now());
        System.out.println(canoeOffice.listClosedRentals());


    }

}
