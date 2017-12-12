(*
    SPOILER ALERT:

    These tests contain the answers to the Euler Project problems.
*)

namespace Tests

open NUnit.Framework
open Shouldly

[<TestFixture>]
type CheckAnswers() =

    [<Test>]
    member this.Problem1() = 
        Problem1.getAnswer().ShouldBe(233168)
            
    [<Test>]
    member this.Problem2() = 
        Problem2.getAnswer().ShouldBe(4613732)
                
    [<Test>]
    member this.Problem3() = 
        Problem3.getAnswer().ShouldBe(6857)
                
    [<Test>]
    member this.Problem4() = 
        Problem4.getAnswer().ShouldBe(906609)

    [<Test>]
    member this.Problem5() = 
        Problem5.getAnswer().ShouldBe(232792560L)
        
    [<Test>]
    member this.Problem6() = 
        Problem6.getAnswer().ShouldBe(25164150)
        
    [<Test>]
    member this.Problem7() = 
        Problem7.getAnswer().ShouldBe(104743L)
        
    [<Test>]
    member this.Problem8() = 
        Problem8.getAnswer().ShouldBe(23514624000L)
        
    [<Test>]
    member this.Problem9() = 
        Problem9.getAnswer().ShouldBe(31875000)
        
    [<Test>]
    member this.Problem10() = 
        Problem10.getAnswer().ShouldBe(142913828922L)
        
    [<Test>]
    member this.Problem11() = 
        Problem11.getAnswer().ShouldBe(70600674)
                
    [<Test>]
    member this.Problem12() = 
        Problem12.getAnswer().ShouldBe(76576500L)
                
    [<Test>]
    member this.Problem13() = 
        Problem13.getAnswer().ShouldBe("5537376230")
                
    [<Test>]
    member this.Problem14() = 
        Problem14.getAnswer().ShouldBe(837799L)
