package collectionsqueue.collectionsdeque;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.ArrayDeque;
import java.util.Deque;

public class JobQueue {

    public Deque<Job> addJobByUrgency(Job... jobs) {
        Deque<Job> result = new ArrayDeque<>();
        for (Job actual: jobs) {
            if (actual.isUrgent()) {
                result.addFirst(actual);
            } else {
                result.addLast(actual);
            }
        }
        return result;
    }

    public Job dispatchUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty() || !jobs.peekFirst().isUrgent()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.removeFirst();
    }

    public Job dispatchNotUrgentJob(Deque<Job> jobs) throws NoJobException {
        if (jobs.isEmpty() || jobs.peekLast().isUrgent()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.removeLast();
    }


}
