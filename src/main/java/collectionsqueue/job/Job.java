package collectionsqueue.job;

public class Job implements Comparable<Job> {

    private final int priority;
    private final String jobDescription;
    private final boolean urgent;

    public Job(int priority, String jobDescription) {
        if (priority < 1 || priority > 10) {
            throw new IllegalArgumentException("Wrong priority");
        }
        this.priority = priority;
        this.jobDescription = jobDescription;
        if (priority < 5) {
            this.urgent = true;
        } else {
            this.urgent = false;
        }
    }

    @Override
    public int compareTo(Job o) {
        return this.priority - o.priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public boolean isUrgent() {
        return urgent;
    }
}
