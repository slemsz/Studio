#include <iostream>

// This section is part of an example code snippet
// source : https://www.learncpp.com/cpp-tutorial/uninitialized-variables-and-undefined-behavior/

void doNothing(int&)
{
    std::cout << "doNothing() called." << std::endl;
}

int main()
{
    // define an integer variable named x
    int x; // this variable is uninitialized because we haven't given it a value

    doNothing(x);
    // print the value of x to the screen
    std::cout << x << '\n'; // who knows what we'll get, because x is uninitialized

    std::cout << sizeof(int); // print how many bytes of memory an int value takes

    return 0;

}
