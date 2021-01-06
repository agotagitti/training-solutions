package exam02.cv;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;

    private List<Skill> skills = new ArrayList<>();

    public Cv(String name) {
        this.name = name;
    }

    public void addSkills(String... skills) {
        for (String actual: skills) {
            this.skills.add(createSkill(actual));
        }
    }

    private Skill createSkill(String string) {
        String name = string.substring(0, string.indexOf("(")).trim();
        int level = Integer.parseInt(string.substring(string.indexOf("(") + 1, string.indexOf(")")));
        return new Skill(name, level);
    }

    public int findSkillLevelByName(String skillName) {
        for (Skill actual: skills) {
            if (actual.getName().equals(skillName)) {
                return actual.getLevel();
            }
        }
        throw new IllegalArgumentException("Skill not found!");
    }


    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }
}
