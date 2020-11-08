package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    List<Member> allMembers = new ArrayList<>();

    public void addMember(String name) {
        allMembers.add(new Member(name));
    }

    public void connect(String name1, String name2) {
        findByName(name1).connectMember(findByName(name2));
    }

    private Member findByName(String name) {
        for (Member member: allMembers) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> connected = new ArrayList<>();
        for (Member member: allMembers) {
            for (Member memberConnection: member.getConnections()) {
                if (memberConnection.getConnections().contains(member)) {
                    connected.add(member.getName() + " <=> " + memberConnection.getName());
                }
            }
        }
        return connected;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "allMembers=" + allMembers +
                '}';
    }
}
