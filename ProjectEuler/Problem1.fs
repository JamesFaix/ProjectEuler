(* Problem 1
    
If we list all the natural numbers below 10 that are multiples of 3 or 5, 
we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.

*)

module Problem1

let isMultipleOf divisor n = 
   n % divisor = 0

let isSummand n =
    n |> isMultipleOf 3 ||
    n |> isMultipleOf 5

let getAnswer =
    [1..999] 
    |> List.filter isSummand 
    |> List.sum

(*
    You are the 709908th person to have solved this problem.
*)