(*
    SPOILER ALERT:

    These tests contain the answers to the Euler Project problems.
*)

namespace Tests

open NUnit.Framework

[<TestFixture>]
type CheckAnswers() =

    [<Test>]
    member this.Problem1() =
        Assert.AreEqual(Problem1.getAnswer(), 233168)
            
    [<Test>]
    member this.Problem2() =
        Assert.AreEqual(Problem2.getAnswer(), 4613732)
                
    [<Test>]
    member this.Problem3() =
        Assert.AreEqual(Problem3.getAnswer(), 6857L)
                
    [<Test>]
    member this.Problem4() =
        Assert.AreEqual(Problem4.getAnswer(), 906609)

    [<Test>]
    member this.Problem5() =
        Assert.AreEqual(Problem5.getAnswer(), 232792560L)
        
    [<Test>]
    member this.Problem6() =
        Assert.AreEqual(Problem6.getAnswer(), 25164150)
        
    [<Test>]
    member this.Problem7() =
        Assert.AreEqual(Problem7.getAnswer(), 104743L)
        
    [<Test>]
    member this.Problem8() =
        Assert.AreEqual(Problem8.getAnswer(), 23514624000L)
        
    [<Test>]
    member this.Problem9() =
        Assert.AreEqual(Problem9.getAnswer(), 31875000)
        
    [<Test>]
    member this.Problem10() =
        Assert.AreEqual(Problem10.getAnswer(), 142913828922L)
