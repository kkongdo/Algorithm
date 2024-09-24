import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, currentTime = 0, completedJobs = 0;
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Job> queue = new PriorityQueue<>(new Comparator<Job>(){
            @Override
            public int compare(Job o1, Job o2){
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        
        while(!queue.isEmpty() || completedJobs < jobs.length){
            for(int i = completedJobs; i < jobs.length; i++){
                if(jobs[i][0] <= currentTime){
                    queue.offer(new Job(jobs[i][0], jobs[i][1]));
                    completedJobs++;
                }
                else{
                    break;
                }
            }
            if(queue.isEmpty()){
                currentTime = jobs[completedJobs][0];
            }
            else{
                Job job = queue.poll();    
                currentTime += job.weight;
                answer += currentTime - job.requestTime;
            }
        }
        
        return answer / jobs.length;
    }
}

class Job{
    int requestTime;
    int weight;
    
    public Job(int requestTime, int weight){
        this.requestTime = requestTime;
        this.weight = weight;
    }
}