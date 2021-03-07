package com.rodasnet.optimalstop.secretary;

import java.util.Arrays;
import java.util.List;

public class Interview {

    private List<Candidate> candidates;

    
    public Interview() {
        this.candidates = Arrays.asList(
            new Candidate("Bob",7,6,6), 
            new Candidate("Alice",7,4,3), 
            new Candidate("Lisa",5,8,7),
            new Candidate("John",4,6,6),
            new Candidate("Ema",6,4,15),
            new Candidate("Chris",1,6,4),
            new Candidate("Nancy",3,4,5),
            new Candidate("James",1,3,4),
            new Candidate("Saly",8,1,5),
            new Candidate("Eric",9,4,6)
        );

        start();
    }

    public void start()
    {
        // for (int i = 0; i < this.candidates.size(); i++) {
        //     String message = "Hello candidate, let us begin " + this.candidates.get(i).getName() + "!";
        //     System.out.println(message);
        // }     

        /**
         * Get index of start and end of candidate sample pool
         */
        int s_sample_pool = 0;
        int e_sample_pool =  this.candidates.size()/3; 

        /** 
         * Get best candidate in sample pool
         */

        Candidate best = candidates.get(0);

        for (int i = 0; i < e_sample_pool; i++) {
            
            Candidate current = candidates.get(i);
            
            System.out.println("Current candidate is " + current.getName());

            best = compareCandidate(best, current);

            String message= "The best candidate is " + best.getName() + ".";

            System.out.println(message);
        }     

        System.out.println("Now interviewing remaining candidates ...");

        /**
         * Get index of start and end of eligeble remaining candidates
         */
        int s_remain_pool =  (this.candidates.size()/3)+1;
        int e_remain_pool =  this.candidates.size()-1;

        Candidate candidate_to_hire;

        for (int i = s_remain_pool-1; i < e_remain_pool+1; i++) {
            
            Candidate current = candidates.get(i);
            
            System.out.println("Current candidate is " + current.getName());

            best = compareCandidate(best, current);

            String message= "The best candidate is " + best.getName() + ".";

            System.out.println(message);
        }
    }

    private Candidate compareCandidate(Candidate c1, Candidate c2)
    {
        /**
         * Compare current candidate with best candidate
         */

        Candidate best = c1;        

        if (c1.getSpeed() < c2.getSpeed()) {
            best=c2;
        } else if (c1.getSpeed() == c2.getSpeed()) {
            if (c1.getExperience() < c2.getExperience()) {
                best=c2;
            } 
            if (c1.getExperience() == c2.getExperience() && c1.getPersonality() < c2.getPersonality())
            {
                best=c2;
            }
        } 

        return best;
    }
}
