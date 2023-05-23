#include <iostream> // for std::cout, std::endl, and std::cin

// This section is part of an example code snippet for compiling with c++20
// source : https://www.learncpp.com/cpp-tutorial/introduction-to-iostream-cout-cin-and-endl

int main()
{
    int x{ 5 };
    std::cout << "x is equal to: " << x << std::endl; // std::endl will cause the cursor
                                                      // to move to the end of the console

    std::cout << "My name is Sam." << std::endl;
    // endl vs '\n'
    // endl 'moves the cursor to the next line of the console,
    // and it flushes the buffer. When writing text to the console, we
    // typically dont need to flush the buffer at the end of each line.'

    std::cout << "Enter two numbers separated by a space: ";
    int y{ }; // define variable y to hold user input (and zero-initialize it)
    int z{ }; // define variable z to hold user input (and zero-initialize it)
    std::cin >> x >> y; // get two numbers and store in variable x and y respectively

    std:: cout << "You entered " << x << " and " << y << '\n';

    return 0;
}
