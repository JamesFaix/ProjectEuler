(* Problem 4: Largest palindrome product

A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.

*)

module Problem4

let getAnswer() =
    let isPalindrome str =
        let len = String.length str
        [0..len/2]
        |> List.forall (fun i -> str.[i] = str.[len-1-i])

    let mutable palindromes = []

    for a in [100..999] do
        for b in [100..999] do
            let prod = a*b
            if isPalindrome (prod.ToString())
            then do palindromes <- prod::palindromes
            else ()

    palindromes
    |> List.max

(*
    You are the 366077th person to have solved this problem.    
*)