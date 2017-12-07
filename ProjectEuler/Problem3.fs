(* Problem 3: Largest Prime Factor

The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?

*)

module Problem3

open System

let getAnswer =
    let product = 600851475143L
    
    let factorLimit = Convert.ToInt64(Math.Floor(Math.Sqrt(Convert.ToDouble(product))))
    
    let mutable primes = [2L]
    
    let isPrime (n : Int64) = 
        primes 
        |> List.exists(fun p -> n % p = 0L) 
        |> not

    let isFactor p =
        if product % p = 0L 
        then Some p 
        else None

    for n in [3L..factorLimit] do
        if isPrime n 
        then do primes <- n::primes
        else ()

    primes 
    |> Seq.pick isFactor

(*
    You are the 410449th person to have solved this problem.
*)