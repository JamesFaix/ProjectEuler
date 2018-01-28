(* Problem 7: 10001st prime

By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?

*)

module Problem7

open System

let getAnswer() =
    let mutable primes = [2L]
    
    let isPrime (n : Int64) = 
        primes 
        |> List.exists(fun p -> n % p = 0L) 
        |> not
        
    let mutable n = 3L

    while (primes |> List.length) < 10001 do
        if isPrime n
        then do primes <- n::primes
        else ()
        n <- n+1L

    primes.Head

(*
    You are the 323122nd person to have solved this problem.
*)