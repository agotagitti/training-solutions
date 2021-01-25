package ioprintwriter.talentshow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    private List<Production> productions = new ArrayList<>();
    private List<Vote> votes = new ArrayList<>();

    public void readTalents(Path talentsFile) {
        try (BufferedReader br = Files.newBufferedReader(talentsFile)) {
            String line;
            while((line = br.readLine()) != null) {
                String[] talents = line.split(" ");
                productions.add(new Production(Integer.parseInt(talents[0]), talents[1]));
            }

        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public void calculateVotes(Path votesFile) {
        try (BufferedReader br = Files.newBufferedReader(votesFile)) {
            String line;
            while((line = br.readLine()) != null) {
                boolean foundVote = false;
                for(Vote actual: votes) {
                    if (actual.getId() == Integer.parseInt(line)) {
                        actual.incNum();
                        foundVote = true;
                    }
                }
                if (!foundVote) {
                    votes.add(new Vote(Integer.parseInt(line), 1));
                }

            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot read file", e);
        }
    }

    public void writeResultToFile(Path resultFile) {
        try (PrintWriter printWriter = new PrintWriter(Files.newBufferedWriter(resultFile))) {
            int mostVoteNumber = 0;
            String winnerProductName = "";
            for (Production actualProds : productions) {
                int voteNumber = 0;
                for (Vote actualVotes : votes) {
                    if (actualProds.getId() == actualVotes.getId()) {
                        voteNumber = actualVotes.getNumber();
                    }
                }
                if (voteNumber > mostVoteNumber) {
                    mostVoteNumber = voteNumber;
                    winnerProductName = actualProds.getName();
                }
                printWriter.println(actualProds.getId() + " " + actualProds.getName() + " " + voteNumber);
            }
            printWriter.println("Winner: " + winnerProductName);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Cannot write file", ioe);
        }
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }

}
