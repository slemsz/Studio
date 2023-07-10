use chrono::{DateTime, Utc, Local};
use std::time::Instant;

fn convert_timezone() {
    let utc_time: DateTime<Utc> = Utc::now();
    let local_time: DateTime<Local> = utc_time.with_timezone(&Local);

    println!("UTC time: {}", utc_time);
    println!("Local time: {}", local_time);
}

fn main() {
    let start = Instant::now();
    convert_timezone();
    let end = Instant::now();
    let duration = end.duration_since(start);
    println!("Time elapsed in convert_timezone() is: {:?}", duration);

}

