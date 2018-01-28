extern crate num;

mod problem16;

#[cfg(test)]
mod tests {

    #[test]
    fn problem16_test() {
        let result = super::problem16::get_answer();
        assert_eq!(result, 1366);
    }
}
