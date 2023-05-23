#include <array>
#include <iostream>
#include <string_view>
#include <tuple>
#include <type_traits>

// This section is part of an example code snippet for
// compiling with c++17
// https://www.learncpp.com/cpp-tutorial/configuring-your-compiler-choosing-a-language-standard/

namespace a::b::c
{
    inline constexpr std::string_view str{ "hello" };
}

template <class... T>
std::tuple<std::size_t, std::common_type_t<T...>> sum(T... args)
{
    return { sizeof...(T), (args + ...) };
}

int main()
{
    auto [iNumbers, iSum]{ sum(1,2,3) };
    std::cout << a::b::c::str << ' ' << iNumbers << ' ' << iSum << '\n';
    std::array arr{ 1, 2, 3 };
    std::cout << std::size(arr) << '\n';
    return 0;
}
