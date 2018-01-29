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
    
    use std::collections::hash_map::HashMap;

    let primitivesMap = hashmap!{
        1 => "one",
        2 => "two",
        3 => "three",
        4 => "four",
        5 => "five",
        6 => "six", 
        7 => "seven",
        8 => "eight",
        9 => "nine",
        10 => "ten",
        11 => "eleven",
        12 => "twelve",
        13 => "thirteen",
        14 => "fourteen",
        15 => "fifteen",
        16 => "sixteen",
        17 => "seventeen",
        18 => "eighteen",
        19 => "nineteen",
        20 => "twenty",
        30 => "thirty",
        40 => "forty",
        50 => "fifty",
        60 => "sixty",
        70 => "seventy",
        80 => "eighty",
        90 => "ninety"
    };

    fn to_words<'a>(n: u32, primitives : &HashMap<u32, &str>) -> Option<String> {
        match primitives.get(&n)
        {
            Some(words) => Some(words.to_string()),
            None => match n {
                x if x > 20 && x < 100 => two_digit_strategy(n, primitives),
                //3-digit strategy
                //4-digit strategy
                //Out of range
                _ => None 
            }
        }
    }
    
    fn two_digit_strategy<'a>(n: u32, primitives : &HashMap<u32, &str>) -> Option<String> {
        let ones = n % 10;
        let tens = n - ones;
        match to_words(tens, &primitives){
            Some(x) => match to_words(ones, &primitives){
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

    0u32
}

/*
 * 
 */
