extern crate num;
#[macro_use] extern crate maplit;

mod problem16;
mod problem17;

#[cfg(test)]
mod tests {

    #[test]
    fn problem16_test() {
        let result = super::problem16::get_answer();
        assert_eq!(result, 1366);
    }

    #[test]
    fn problem17_test() {
        let result = super::problem17::get_answer();
        assert_eq!(result, 0);
    }
    
}
