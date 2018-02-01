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
        assert_eq!(result, 21124);
    }

    #[test]
    fn problem17_2digit_strategy() {
        let result = super::problem17::two_digit_strategy(99u32);
        assert_eq!(result, Some("ninety nine".to_string()));
        
        let invalid_input_result = super::problem17::two_digit_strategy(1u32);
        assert_eq!(invalid_input_result, None);
    }
    
    #[test]
    fn problem17_3digit_strategy() {
        //100
        let result_100 = super::problem17::three_digit_strategy(100);
        assert_eq!(result_100, Some("one hundred".to_string()));

        //101
        let result_101 = super::problem17::three_digit_strategy(101);
        assert_eq!(result_101, Some("one hundred and one".to_string()));

        //111
        let result_111 = super::problem17::three_digit_strategy(111);
        assert_eq!(result_111, Some("one hundred and eleven".to_string()));

        //146
        let result_146 = super::problem17::three_digit_strategy(146);
        assert_eq!(result_146, Some("one hundred and forty six".to_string()));

        //753
        let result_753 = super::problem17::three_digit_strategy(753);
        assert_eq!(result_753, Some("seven hundred and fifty three".to_string()));

        //99
        let result_99 = super::problem17::three_digit_strategy(99);
        assert_eq!(result_99, None);

        //6000
        let result_6000 = super::problem17::three_digit_strategy(6000);
        assert_eq!(result_6000, None);
    }

    #[test]
    fn problem17_4digit_strategy() {
        let result_1000 = super::problem17::four_digit_strategy(1000);
        assert_eq!(result_1000, Some("one thousand".to_string()));

        let result_1 = super::problem17::four_digit_strategy(1);
        assert_eq!(result_1, None);

        let result_1001 = super::problem17::four_digit_strategy(1001);
        assert_eq!(result_1001, None);
    }

    //
}
