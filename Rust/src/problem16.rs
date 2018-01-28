/* Problem 16: Power digit sum
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */

pub fn get_answer() -> u32 {
    use num::BigUint;
    
    //In binary 2^1000 is 1 followed by 1000 0's
    //In a byte array, this is 1 byte of 1 followed by 125 bytes of 0
    let mut bytes = [0u8; 126];
    bytes[0] = 1u8;

    //Create BigUint from this byte array
    let number = BigUint::from_bytes_be(&bytes);
    
    //Convert to string
    let text = number.to_string();
    
    const RADIX = 10;

    //Sum each char parsed as an i32
    Iterator::fold(text.chars(), 0u32, 
        |acc, ch| -> u32 { acc + ch.to_digit(RADIX).unwrap() })
}

/*
 * You are the 182063rd person to have solved this problem.
 */
