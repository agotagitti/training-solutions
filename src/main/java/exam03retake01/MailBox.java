package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> findByCriteria(String criteria) {
        List<Mail> foundMails;
        if (criteria.startsWith("from")) {
            foundMails = findByFrom(criteria);
        } else if (criteria.startsWith("to")) {
            foundMails = findByTo(criteria);
        } else {
            foundMails = findByText(criteria);
        }
        return foundMails;
    }

    private List<Mail> findByFrom(String criteria) {
        List<Mail> foundMailByFrom = new ArrayList<>();
        String exactCriteria = criteria.substring(criteria.indexOf(":") + 1);
        for (Mail actualMail : mails) {
            if (actualMail.getFrom().getEmail().equals(exactCriteria) || actualMail.getFrom().getName().equals(exactCriteria)) {
                foundMailByFrom.add(actualMail);
            }
        }
        return foundMailByFrom;
    }

    private List<Mail> findByTo(String criteria) {
        List<Mail> foundMailByTo = new ArrayList<>();
        String exactCriteria = criteria.substring(criteria.indexOf(":") + 1);
        for (Mail actualMail : mails) {
            for(Contact actualContact : actualMail.getTo()) {
                if (actualContact.getName().equals(exactCriteria) || actualContact.getEmail().equals(exactCriteria)) {
                    foundMailByTo.add(actualMail);
                }
            }
        }
        return foundMailByTo;
    }

    private List<Mail> findByText(String criteria) {
        List<Mail> foundMailByText = new ArrayList<>();
        for (Mail actualMail : mails) {
            if (actualMail.getSubject().contains(criteria) || actualMail.getMessage().contains(criteria)) {
                foundMailByText.add(actualMail);
            }
        }
        return foundMailByText;
    }


    public List<Mail> getMails() {
        return mails;
    }

}
