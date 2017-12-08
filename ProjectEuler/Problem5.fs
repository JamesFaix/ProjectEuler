(* Problem 5: Smallest multiple

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

*)

module Problem5

open System

let getAnswer() =         
    let divisors = [2L..20L]
    
    let product (seq : int64 seq) = seq |> Seq.reduce (fun x y -> x*y)
    
    let lowestPossible = 
        Utilities.Primes.getPrimes
        |> Seq.takeWhile(fun p -> p <= 20)
        |> Seq.map(Convert.ToInt64)
        |> product

    let highestPossible = divisors |> product

    seq{lowestPossible..highestPossible}
    |> Seq.pick (fun n -> 
        if divisors 
            |> Seq.forall(fun d -> n % d = 0L) 
        then Some n 
        else None)

(*
    You are the 375258th person to have solved this problem.
*)