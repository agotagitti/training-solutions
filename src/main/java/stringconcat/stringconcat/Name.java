package stringconcat.stringconcat;

public class Name {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public Name(String familyName, String middleName, String givenName, Title title) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        this.title =title;
        if (!isNameValid()) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
    }

    public Name(String familyName, String middleName, String givenName) {
        this.familyName = familyName;
        this.middleName = middleName;
        this.givenName = givenName;
        if (!isNameValid()) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
    }

    public String concatNameWesternStyle() {
        //Mr. John G Smith
        String fullName = "";
        if (title != null) {
            fullName += title.getTitleDesc() + " ";
        }
        fullName += givenName + " ";
        if (!isEmpty(middleName)) {
            fullName += middleName + " ";
        }
        fullName += familyName;
        return fullName;
    }

    public String concatNameHungarianStyle() {
        //Mr. Smith G John
        String fullName = "";
        if (title != null) {
            fullName = fullName.concat(title.getTitleDesc());
            fullName = fullName.concat(" ");
        }
        fullName = fullName.concat(familyName);
        fullName = fullName.concat(" ");
        if (!isEmpty(middleName)) {
            fullName = fullName.concat(middleName);
            fullName = fullName.concat(" ");
        }
        fullName = fullName.concat(givenName);
        return fullName;
    }

    private boolean isEmpty(String value) {
        boolean isEmpty = false;
        if (value == null || value.equals("")) {
            isEmpty = true;
        }
        return isEmpty;
    }

    private boolean isNameValid() {
        boolean isValid = false;
        if (!isEmpty(familyName) && !isEmpty(givenName)) {
            isValid = true;
        }
        return isValid;
    }
}
