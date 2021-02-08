package collectionsqueue.collectionspriorityqueue;

import collectionsqueue.job.Job;
import collectionsqueue.job.NoJobException;

import java.util.PriorityQueue;
import java.util.Queue;

public class JobDispatcher {


    public Queue<Job> addJob(Job... jobs) {
        Queue<Job> result = new PriorityQueue<>();
        for (Job actual: jobs) {
            result.add(actual);
        }
        return result;
    }

    public Job dispatchNextJob(Queue<Job> jobs) throws NoJobException {
        if (jobs.isEmpty()) {
            throw new NoJobException("No job available, get a rest!");
        }
        return jobs.remove();
    }
}
