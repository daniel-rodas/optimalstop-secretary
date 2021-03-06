package com.rodasnet.optimalstop.secretary;

import java.util.Arrays;
import java.util.List;

public class Interview {

    private List<Candidate> candidates;

    
    public Interview() {
        this.candidates = Arrays.asList(
            new Candidate("Bob",4,6,6), 
            new Candidate("Alice",4,6,3), 
            new Candidate("Lisa",5,8,7),
            new Candidate("John",5,8,7),
            new Candidate("Ema",6,4,15),
            new Candidate("Chris",1,6,4),
            new Candidate("Nancy",3,4,5),
            new Candidate("James",1,3,4),
            new Candidate("Saly",4,1,5),
            new Candidate("Eric",9,4,6)
        );

        start();
    }

    public void start()
    {
        /**
         * Get index of start and end of candidate sample pool
         */
        int s_sample_pool = 0;
        int e_sample_pool =  this.candidates.size()/3; 

        /** 
         * Get best candidate in sample pool
         */

        Candidate best = candidates.get(0);

        for (int i = s_sample_pool; i < e_sample_pool; i++) {
            
            Candidate current = candidates.get(i);
            
            System.out.println("Current candidate is " + current.getName());

            if (compareCandidate(best, current) == 1) {
                best=current;
            }

            String message= "The best candidate is " + best.getName() + ".";

            System.out.println(message);
        }     

        System.out.println("Now interviewing remaining candidates ...");

        /**
         * Get index of start and end of eligeble remaining candidates
         */
        int s_remain_pool =  (this.candidates.size()/3)+1;
        int e_remain_pool =  this.candidates.size()-1;

        for (int i = s_remain_pool-1; i < e_remain_pool+1; i++) {
            
            Candidate current = candidates.get(i);
            
            System.out.println("Current candidate is " + current.getName());

            if (compareCandidate(best, current) == 1) {
                best=current;

                String message= "The best candidate is " + best.getName() + ".";
                System.out.println(message);

                break;
            }            
        }
    }

    private int compareCandidate(Candidate c0, Candidate c1)
    {
        /**
         * Compare current candidate with best candidate
         */        
            // current      next
        if (c0.getSpeed() < c1.getSpeed()) {
            return 1;
        } else if (c0.getSpeed() == c1.getSpeed()) {
            if (c0.getExperience() < c1.getExperience()) {
                return 1;
            } 
            if (c0.getExperience() == c1.getExperience() && c0.getPersonality() <= c1.getPersonality())
            {
                return 1;
            }
        } 
        return 0;
    }
}
