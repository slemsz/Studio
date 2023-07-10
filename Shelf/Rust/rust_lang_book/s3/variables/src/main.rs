use std::time::Instant;

fn constants() {
    const THREE_HOURS_IN_SECONDS: u32 = 60 * 60 * 3;
    println!("Three hours in seconds: {}", THREE_HOURS_IN_SECONDS);
}

fn mutability() {
    let mut x = 5;
    println!("The value of x is: {}", x);
    x = 6;
    println!("The value of x is: {}", x);
}

fn time_elapsed(s: &str) {
    let start = Instant::now();
    match s {
        "mutability" => mutability(),
        "constants" => constants(),
        "three" => println!("three"),
        _ => println!("not sure what you meant by that, mate."),
    }
    let end = Instant::now();
    let duration = end.duration_since(start);
    println!("[ Time elapsed in {} is: {:?} ]", s, duration);
}

fn main() {
    println!("\nmutability()");
    let string = "mutability";
    time_elapsed(string);

    println!("\nconstants()");
    let string = "constants";
    time_elapsed(string);
    
}
