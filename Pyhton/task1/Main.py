import math
import random


def bernoulli(p, n):
    l = []
    print ("Bernoulli: n=%1d p=%3.1f" % (n, p))
    for k in range(0, n + 1):
        l.append(round(binomial(n, k) * (p ** k) * ((1 - p) ** (n - k)), 3))
    print l


def binomial(n, i):
    return math.factorial(n) / (math.factorial(i) * math.factorial(n - i))


def experiment(p, n):
    max_exp = 500000
    l = []
    for i in range(0, n + 1):
        l.append(0)
    for j in range(0, max_exp):
        exp = 0
        for i in range(0, n):
            rand = 0 if (random.random() < p) else 1
            exp += rand
        l[exp] += 1

    for i in range(0, len(l)):
        l[i] = round(float(l[i]) / max_exp, 3)

    print l


# Main
bernoulli(0.500, 3)
experiment(0.500, 3)
