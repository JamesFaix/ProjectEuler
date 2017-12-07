(* Problem 5: Smallest multiple

2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?

*)

module Problem5

let getAnswer =         
    let divisors = [2L..20L]
    let mutable primes = [2L]    
    
    let isPrime n = 
        primes 
        |> List.exists(fun p -> n % p = 0L) 
        |> not

    for n in [3L..20L] do
        if isPrime n
        then primes <- n::primes
        else ()
        
    let lowestPossible = primes |> Seq.reduce (fun x y -> x*y)
    let highestPossible = divisors |> Seq.reduce (fun x y -> x*y)

    seq{lowestPossible..highestPossible}
    |> Seq.pick (fun n -> 
        if divisors 
            |> Seq.forall(fun d -> n % d = 0L) 
        then Some n 
        else None)

(*
    You are the 375258th person to have solved this problem.
*)