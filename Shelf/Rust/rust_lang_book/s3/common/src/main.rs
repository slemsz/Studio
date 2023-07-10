use std::time::Instant;

fn shadowing() {
    let x = 5;
    let x = x + 1;
    let x = x * 2;
    {
        let x = x * 3;
        println!("The value of x in the inner scope is: {}", x);
    }
    println!("The value of x is: {}", x);
}

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
        "shadowing" => shadowing(),
        "fn name" => println!("fn body"),
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

    println!("\nshadowing()");
    let string2 = "shadowing";
    time_elapsed(string2);
    
}
