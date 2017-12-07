module Utilities

    open System
    open System.IO
    open System.Reflection

    module Primes =
        
        let private cachePath = 
            Path.GetDirectoryName(Assembly.GetExecutingAssembly().Location) 
            + "\PrimeCache.txt"
                    
        let private readCache : int list =
            let text = File.ReadAllText(cachePath).Trim()            
            text.Split([|','|]) 
            |> Seq.filter(fun w -> w |> String.length > 0)
            |> Seq.map(fun w -> Int32.Parse(w)) 
            |> Seq.toList

        let private writeCache cache =
            let text = String.Join(",", cache |> Seq.map(fun n -> n.ToString()))
            File.WriteAllText(cachePath, text)

        let mutable private cache = []
        cache <- readCache

        let private appendElement element list = 
            element::(list |> List.rev) |> List.rev

        let private isPrimeInner (n : int) =
            if n < 2 then false
            else 
                let len = cache.Length
                let factorLimit = Convert.ToInt32(Math.Floor(Math.Sqrt(Convert.ToDouble(n))))

                let mutable i = 0
                let mutable stop = false
                let mutable isPrime = true

                while stop = false do
                    //Get the next element from cache
                    let p = cache.[i]
                    
                    i <- i+1
                    
                    //Don't go past last index of cache
                    if i >= len
                    then stop <- true 
                    else ()

                    //Don't check primes > sqrt(n)
                    if p > factorLimit
                    then stop <- true
                    else ()

                    //If its divisible by any prime, its not a prime
                    if n % p = 0
                    then 
                        stop <- true
                        isPrime <- false
                    else ()

                //Add primes to cache
                if isPrime
                then cache <- appendElement n cache
                else ()

                isPrime

        let isPrime (n : int) : bool =            
            isPrimeInner n
            
        let getPrimes : int seq =
            seq {
                for p in cache do 
                    yield p

                let next = if cache.Length > 0 
                           then cache.[cache.Length-1]+1
                           else 2

                for n = next to Int32.MaxValue do
                    if isPrimeInner n
                    then yield n
                    else ()
            }
        
        let saveCache() : unit =
            writeCache cache