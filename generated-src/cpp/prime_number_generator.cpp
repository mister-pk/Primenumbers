//
// Created by pkolpakov on 10.02.2017.
//
#include <cstdint>
#include <math.h>
#include "prime_number_generator.hpp"

namespace primenumbers {

int32_t PrimeNumberGenerator::generate_prime(int32_t previousPrime) {
    int32_t temp = previousPrime + 1;
    int32_t next = 0;
    int32_t exit = 0;
    int32_t i = 2;

    while (exit == 0) {
        if (temp % i == 0 && i != temp) {
            temp++;
            i = 2;
            continue;
        }

        if ((i == temp) || (i > sqrt(temp))) {
            next = temp;
            exit = 1;
        }

        i++;
    }

    return next;
}
}