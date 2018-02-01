/* Problem 17: Number letter counts
 
   If the numbers 1 to 5 are written out in words: one, two, three, four,
   five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 
   If all the numbers from 1 to 1000 (one thousand) inclusive were written 
   out in words, how many letters would be used?

   NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and 
   forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 
   20 letters. The use of "and" when writing out numbers is in compliance 
   with British usage.
 */

pub fn get_answer() -> u32 {
    Iterator::fold(1..1001, 0u32, 
        |acc, n| -> u32 { 
            let letter_count = match to_words(n) {
                Some(x) => {
                //    println!("{}", x);
                    x.chars()
                        .filter(|letter| -> bool { *letter != ' ' })
                        .count() as u32
                },
                None => 0
            };
            acc + letter_count
        }
    )
}


pub fn to_words(n: u32) -> Option<String> {
    match primitive_strategy(n)
    {
        Some(words) => Some(words.to_string()),
        None => match n {
            x if x > 20 && x < 100 => two_digit_strategy(n),
            x if x >= 100 && x < 1000 => three_digit_strategy(n),
            x if x == 1000 => four_digit_strategy(n),
            
            //Out of range
            _ => None 
        }
    }
}

fn primitive_strategy<'a>(number:u32) -> Option<&'a str>{
    match number {
        1 => Some("one"),
        2 => Some("two"),
        3 => Some("three"),
        4 => Some("four"),
        5 => Some("five"),
        6 => Some("six"), 
        7 => Some("seven"),
        8 => Some("eight"),
        9 => Some("nine"),
        10 => Some("ten"),
        11 => Some("eleven"),
        12 => Some("twelve"),
        13 => Some("thirteen"),
        14 => Some("fourteen"),
        15 => Some("fifteen"),
        16 => Some("sixteen"),
        17 => Some("seventeen"),
        18 => Some("eighteen"),
        19 => Some("nineteen"),
        20 => Some("twenty"),
        30 => Some("thirty"),
        40 => Some("forty"),
        50 => Some("fifty"),
        60 => Some("sixty"),
        70 => Some("seventy"),
        80 => Some("eighty"),
        90 => Some("ninety"),
        _ => None
    }
}
    
pub fn two_digit_strategy(n: u32) -> Option<String> {
    let ones = n % 10;
    let tens = n - ones;
    match to_words(tens){
        Some(x) => match to_words(ones){
            Some(y) => 
            {
                let words = format!("{} {}", x, y);
                Some(words)
            }
            None => None
        },
        None => None
    }
}

pub fn three_digit_strategy(n: u32) -> Option<String> {
    let mod100 = n % 100;
    let hundred = (n - mod100)/100;

    if hundred > 9 {
        None
    }
    else {
        match to_words(hundred) {
        None => None,
        Some(x) => match mod100 {
            0 => Some(format!("{} hundred", x)),
            _ => match to_words(mod100) {
                None => None, // should always be caught above
                Some(y) => Some(format!("{} hundred and {}", x, y))
                }
            }
        }
    }
}

pub fn four_digit_strategy(n: u32) -> Option<String> {
    if n == 1000 {
        Some("one thousand".to_string()) 
    }    
    else {
        None
    }
}

/*
 * You are the 121346th person to have solved this problem.
 * (With gratuitous assistance from Jeremy Spangler.)
 */
