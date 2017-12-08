(* Problem 10: Summation of primes

The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

Find the sum of all the primes below two million.

*)

module Problem10

open System

let getAnswer() =
    
    let limit = 1000

    let primes = Utilities.Primes.getPrimes
                 |> Seq.takeWhile(fun p -> p < limit)
    
    let result = 
        primes 
        |> Seq.map(fun n -> Convert.ToInt64(n))
        |> Seq.sum
        
    Utilities.Primes.saveCache()

    result
(*
    You are the 253583rd person to have solved this problem.
*)