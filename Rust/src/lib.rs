extern crate num;

mod problem16;
mod problem17;

#[cfg(test)]
mod tests {

    #[test]
    fn problem16_test() {
        let result = super::problem16::get_answer();
        assert_eq!(result, 1366);
    }

    // Problem 17

    #[test]
    fn problem17_final_answer() {
        let result = super::problem17::get_answer();
        assert_eq!(result, 0);
    }

    #[test]
    fn problem17_2digit_strategy() {
        let result = super::problem17::two_digit_strategy(99u32);
        assert_eq!(result, Some("ninety nine".to_string()));
        
        let invalid_input_result = super::problem17::two_digit_strategy(1u32);
        assert_eq!(invalid_input_result, None);
    }
    
    //
}
