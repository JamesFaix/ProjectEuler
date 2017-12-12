(* Problem 14: Longest Collatz sequence

The following iterative sequence is defined for the set of positive integers:

n → n/2 (n is even)
n → 3n + 1 (n is odd)

Using the rule above and starting with 13, we generate the following sequence:
13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1

It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.

Which starting number, under one million, produces the longest chain?

NOTE: Once the chain starts the terms are allowed to go above one million.

*)

module Problem14

open System.Collections.Generic

let getAnswer() =
    
    //create dictionary to hold lengths

    //function to get collatz length of number
        //start collatz sequence and count elements
        //if any element is already indexed, return count + indexed count, then add to index

    let index = new Dictionary<int64, int64>()

    let nextCollatz last = 
        if last % 2L = 0L
        then last/2L
        else (3L * last) + 1L

    let collatzLen n =
        let mutable current = n
        let mutable count = 1L
        let mutable stop = false
        while stop = false do
            //If number has alrady been hit, add to indexed count
            if index.ContainsKey(current)
            then count <- count + index.[current] - 1L
                 stop <- true
            else //Get next
                let next = nextCollatz current
                current <- next
                count <- count + 1L

                //Stop if at 1
                if current = 1L
                then stop <- true 
                else ()        
        count

    for n in [1L..1_000_000L] do
        let len = collatzLen n
        if index.ContainsKey(n)
        then ()
        else index.[n] <- len

    (index |> Seq.maxBy (fun pair -> pair.Value)).Key

(*
    You are the 177295th person to have solved this problem.
*)