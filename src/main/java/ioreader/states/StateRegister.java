package ioreader.states;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StateRegister {

    private List<State> states = new ArrayList<>();

    public void readStatesFromFile(String fileName) {
        Path path = Path.of("src/main/resources/" + fileName);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                String[] stateAndCapital = line.split("-");
                states.add(new State(stateAndCapital[0], stateAndCapital[1]));
            }
        }
        catch(IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public String findCapitalByStateName(String stateName) {
        for (State actual: states) {
            if (stateName.equals(actual.getStateName())) {
                return actual.getCapital();
            }
        }
        throw new IllegalArgumentException("No state with this name!");
    }

    public List<State> getStates() {
        return new ArrayList<>(states);
    }

}
