[<EntryPoint>]
let main argv = 
    printfn "The answer to Problem 1 is %A" Problem1.getAnswer
    System.Console.ReadLine() |> ignore
    0
