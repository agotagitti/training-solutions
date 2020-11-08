package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private List<Member> connections = new ArrayList<>();
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public void connectMember(Member member) {
        connections.add(member);
    }

    public List<Member> getConnections() {
        return connections;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\nMember name: " + name + " connections: " + connectedNames();
    }

    private List<String> connectedNames() {
        List<String> memberNames = new ArrayList<>();
        for (Member member: connections) {
            memberNames.add(member.getName());
        }
        return memberNames;
    }

}
