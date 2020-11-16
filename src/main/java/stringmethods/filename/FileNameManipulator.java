package stringmethods.filename;

public class FileNameManipulator {

    public char findLastCharacter(String str) {
        if (isEmpty(str)) {
            throw new IllegalArgumentException("Empty string!");
        }
        return str.trim().charAt(str.trim().length() - 1);
    }

    public String findFileExtension(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        if (!isFileNameValid(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        return fileName.substring(fileName.indexOf("."));
    }

    public boolean identifyFilesByExtension(String ext, String fileName) {
        if (isEmpty(ext) || isEmpty(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (!isFileNameValid(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        return fileName.trim().endsWith(ext);
    }

    public boolean compareFilesByName(String searchedFileName, String actualFileName) {
        if (isEmpty(searchedFileName) || isEmpty(actualFileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        if (!isFileNameValid(searchedFileName) || !isFileNameValid(actualFileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        return searchedFileName.equalsIgnoreCase(actualFileName);
    }

    public String changeExtensionToLowerCase(String fileName) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (!isFileNameValid(fileName)) {
            throw new IllegalArgumentException("Invalid argument!");
        }
        String lowerCaseExtension = "";
        String name = fileName.substring(0, (fileName.indexOf(".")));
        lowerCaseExtension = findFileExtension(fileName).toLowerCase();
        return name + lowerCaseExtension;
    }

    public String replaceStringPart(String fileName, String present, String target) {
        if (isEmpty(fileName)) {
            throw new IllegalArgumentException("Empty string!");
        }
        if (!isFileNameValid(fileName)) {
            throw new IllegalArgumentException("Invalid file name!");
        }
        String fileNameTarget = fileName;
        if (fileName.contains(present)) {
            fileNameTarget = fileName.replace(present, target);
        }
        return fileNameTarget;
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

    private boolean isFileNameValid(String fileName) {
        boolean isValid = false;
        if (fileName.contains(".")) {
            if (!isEmpty(fileName.substring(0, (fileName.indexOf("."))))) {
                if (!isEmpty((fileName.substring(fileName.indexOf(".") + 1)))) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }
}