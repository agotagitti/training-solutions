package stringbuilder;

public class NameBuilder {

    private String familyName;
    private String middleName;
    private String givenName;
    private Title title;

    public String concatNameWesternStyle(String familyName, String middleName, String givenName, Title title) {
        //Mr. John G Smith
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder fullName = new StringBuilder("");
            if (title != null) {
                fullName.append(title.getTitleDesc());
                fullName.append(" ");
                fullName.append(givenName);
            } else {
                fullName.append(givenName);
            }
            fullName.append(" ");
            if (!isEmpty(middleName)) {
                    fullName.append(middleName);
                    fullName.append(" ");
            }
            fullName.append(familyName);
            return fullName.toString();
    }

    public String concatNameHungarianStyle(String familyName, String middleName, String givenName, Title title) {
        //Mr. Smith G John
        if (isEmpty(familyName) || isEmpty(givenName)) {
            throw new IllegalArgumentException("Family name and given name must not be empty!");
        }
        StringBuilder fullName = new StringBuilder("");
        if (title != null) {
            fullName.append(title.getTitleDesc());
            fullName.append(" ");
            fullName.append(familyName);
        } else {
            fullName.append(familyName);
        }
        fullName.append(" ");
        if (!isEmpty(middleName)) {
            fullName.append(middleName);
            fullName.append(" ");
        }
        fullName.append(givenName);
        return fullName.toString();

    }

    public String insertTitle(String name, Title title, String where) {
        StringBuilder nameWithTitle = new StringBuilder(name);
        int ins = nameWithTitle.indexOf(where);
        nameWithTitle.insert(ins + 1, title.getTitleDesc() + " ");
        return nameWithTitle.toString();
    }

    public String deleteNamePart(String name, String delete) {
        //name: Dr. Prof. John G Smith
        //delete: "Prof. "
        StringBuilder nameWithoutTitle = new StringBuilder(name);
        int del = name.indexOf(delete);
        nameWithoutTitle.delete(del, delete.length() + del);
        return nameWithoutTitle.toString();
    }

    private boolean isEmpty(String str) {
        boolean isEmpty = false;
        if (str != null) {
            if(str.trim().equals("")) {
                isEmpty = true;
            }
        } else {
            isEmpty = true;
        }
        return isEmpty;
    }

}
