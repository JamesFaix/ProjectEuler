(* Problem 3: Largest Prime Factor

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

*)

module Problem3

open System

let getAnswer() =
    let product = 600851475143L
    
    let factorLimit = Convert.ToInt32(Math.Floor(Math.Sqrt(Convert.ToDouble(product))))
    
    let primes = 
        Utilities.Primes.getPrimes
        |> Seq.takeWhile (fun p -> p <= factorLimit)
        |> Seq.toList
        |> List.rev
        
    Utilities.Primes.saveCache()
    
    let isFactor (p : int) =
        if product % Convert.ToInt64(p) = 0L
        then Some p 
        else None

    primes |> Seq.pick isFactor
    
(*
    You are the 410449th person to have solved this problem.
*)