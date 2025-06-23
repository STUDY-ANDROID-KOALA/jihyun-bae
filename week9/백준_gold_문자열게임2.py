import sys
from collections import defaultdict

t = int(sys.stdin.readline())

for _ in range(t):
    w = sys.stdin.readline().strip()
    k = int(sys.stdin.readline())

    minval, maxval = len(w) + 1, -1
    alphabet = defaultdict(list)

    for i in range(len(w)):
        alphabet[w[i]].append(i)
    
    for i in alphabet.values():
        if len(i) >= k:
            for j in range(len(i) - k + 1):
                minval = min(minval, i[j + k - 1] - i[j] + 1)
                maxval = max(maxval, i[j + k - 1] - i[j] + 1)
    
    if maxval == -1:
        print(maxval)
    else:
        print(f'{minval} {maxval}')
