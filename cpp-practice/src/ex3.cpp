#include <iostream>

// This section is part of an example code snippet for
// compiling with c++20
// source : https://www.learncpp.com/cpp-tutorial/variable-assignment-and-initialization/

int main()
{
    //int width;
    //width = 5; // copy assignment of value 5 into variable
    // variable width now has value 5
    //width = 7; // change value stored in variable width to 7
    // variable width now has value 7

    int a; // no initializer (default initialization)
    int b = 5; // initializer after equals sign (copy initialization)
    int c( 6 ); // initializer in parenthesis (direct initialization)

    // List initialization methods (C++11) (preferred)
    int d { 7 }; // initializer in braces (direct list initialization)
    int e = { 8 }; // initializer in braces after equals sign (copy list initialization)
    int f {};

    // Direct Initialization
    //int width( 5 ); // direct initialization of value 5 info variable width
    // also used when 'values are explicitly cast to another type'
    //int x(); // forward declaration of function x
    //int x(0); // definition of variable x with initializer 0

    // List Initialization
    int width { 5 }; // direct list initialization of value 5 into variable width
    int height = { 6 }; // copy list initialization of value 6 into variable height
    int depth {}; // value initialization.

    // When should I initialize with { 0 } vs {}?
    // Use an explicit initialization valye if youre actually using that value.
    //int x { 0 }; // explicit initialization to value 0
    //std::cout << x; // we're using that zero value
    // Use value initialization if the value is temporary and will be replaced;
    //int x {}; // value initialization
    //std::cin >> x; // we're immediately replacing that value

    // [[maybe_unused]]
    [[maybe_unused]] int x { 5 };
    // since x is [[maybe_unused]], no warning generated
    return 0;
}
