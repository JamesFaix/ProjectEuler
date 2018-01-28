(* Problem 9: Special Pythagorean triplet

A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

a^2 + b^2 = c^2

For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

There exists exactly one Pythagorean triplet for which a + b + c = 1000.
Find the product abc.

*)

module Problem9

let getAnswer() =
    let rec findSummands sum count : int list seq =
        match count with
        | c when c < 2 -> failwith "You need to sum more than 1 number"
        | 2 ->  
            seq {
                for n = 1 to sum / 2 do
                yield [n; sum - n]
            }
        | _ -> 
            seq {
                for n = 1 to sum / count do
                    for summands in findSummands (sum-n) (count-1) do
                        yield n::summands
            }

    let square n = n * n

    let isPythagoreanTriple (triple : int list) =
        match triple.Length with
        | 3 -> let sorted = triple |> List.sort
               (square sorted.[0]) + (square sorted.[1]) = (square sorted.[2])
        | _ -> false
        
    let product seq = seq |> Seq.reduce (fun x y -> x * y)
    
    findSummands 1000 3
    |> Seq.filter isPythagoreanTriple
    |> Seq.head
    |> product
    
(*
    You are the 276190th person to have solved this problem.
*)