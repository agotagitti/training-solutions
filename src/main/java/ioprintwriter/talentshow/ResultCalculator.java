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
                Vote vote = getVoteForProduction(Integer.parseInt(line));
               if (vote == null) {
                   vote = new Vote(Integer.parseInt(line), 0);
                   votes.add(vote);
               }
               vote.incNum();
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
                Vote vote = getVoteForProduction(actualProds.getId());
                if (vote != null) {
                    voteNumber = vote.getNumber();
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

    private Vote getVoteForProduction(int prodId) {
        for (Vote actualVote : votes) {
            if (prodId == actualVote.getId()) {
                return actualVote;
            }
        }
        return null;
    }

    public List<Production> getProductions() {
        return productions;
    }

    public List<Vote> getVotes() {
        return votes;
    }

}
