use druid::{
    widget::{Button, Flex, Label},
    AppLauncher, Data, Env, Widget, WindowDesc,
};
/*
 *
 *
 */

#[derive(Clone, Data)]
struct FunnyData {
    num: i32,
}

fn ui_builder() -> impl Widget<FunnyData> {
    // Counter: _
    // + -
    let label = Label::new(|data: &FunnyData, _: &Env| format!("Counter: {}", data.num));
    let increment = Button::new("+").on_click(|_ctx, data: &mut FunnyData, _env| data.num += 1);
    let decrement = Button::new("-").on_click(|_ctx, data: &mut FunnyData, _env| data.num -= 1);

    Flex::column()
        .with_child(label)
        .with_child(Flex::row().with_child(increment).with_child(decrement))
}

fn main() {
    // window descriptor
    // launch
    let main_window = WindowDesc::new(ui_builder()).title("Funny Window");
    AppLauncher::with_window(main_window)
        .log_to_console()
        .launch(FunnyData { num: 0 })
        .unwrap();
}
