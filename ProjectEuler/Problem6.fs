(* Problem 6: Sum square difference

The sum of the squares of the first ten natural numbers is,

1^2 + 2^2 + ... + 10^2 = 385

The square of the sum of the first ten natural numbers is,

(1 + 2 + ... + 10)^2 = 55^2 = 3025

Hence the difference between the sum of the squares of the first 
ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first 
one hundred natural numbers and the square of the sum.

*)

module Problem6

let getAnswer =
    let square n = n * n

    let sumOfSquares n =
        Seq.initInfinite(fun i -> square (i + 1))
        |> Seq.take n
        |> Seq.sum

    let squareOfSum n =        
        Seq.initInfinite(fun i -> i + 1)
        |> Seq.take n
        |> Seq.sum
        |> square

    let n = 100
    (squareOfSum n) - (sumOfSquares n)

(*
    You are the 377290th person to have solved this problem.
*)