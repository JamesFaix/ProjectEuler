﻿(* Problem 12: Highly divisible triangular number

The sequence of triangle numbers is generated by adding the natural numbers. 
So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28. 
The first ten terms would be:

1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...

Let us list the factors of the first seven triangle numbers:

     1: 1
     3: 1,3
     6: 1,2,3,6
    10: 1,2,5,10
    15: 1,3,5,15
    21: 1,3,7,21
    28: 1,2,4,7,14,28

We can see that 28 is the first triangle number to have over five divisors.

What is the value of the first triangle number to have over five hundred divisors?


*)

module Problem12

open System

let getAnswer() =
    
    let triangulars = Seq.initInfinite(fun n -> Seq.sum [1L..Convert.ToInt64(n+1)])

    let inline longFor low high f = 
        let rec loop n =
            if n < high then f n; loop (n + 1L)
        loop low

    let factorCount (n : int64) =
        //All N are divisible by 1 and N
        let mutable factors = 2

        //Add 1 factor for perfect squares
        let sqrt = Math.Sqrt(Convert.ToDouble(n))
        if (sqrt % 1.0) = 0.0 then factors <- factors + 1 else ()

        //Each other factor pair must have one number 
        //below sqrt and one above, so don't check past sqrt
        let maxFactor = Convert.ToInt64(Math.Floor(sqrt))

        longFor 2L maxFactor (fun i -> 
            if n % i = 0L 
            then factors <- factors + 2 
            else ())

        factors
        
    triangulars
    |> Seq.pick (fun n -> 
        if factorCount n > 500 
        then Some n 
        else None)

(*
    You are the 172018th person to have solved this problem.
*)