import sys

n = int(sys.stdin.readline())
word = [sys.stdin.readline().rstrip() for _ in range(n)]
d = sorted(list(enumerate(word)),key = lambda x: x[1])

length = [0] * n
for i in range(n - 1):
    count = 0
    for j in range(min(len(d[i][1]), len(d[i + 1][1]))):
        if d[i][1][j] == d[i + 1][1][j]: count += 1
        else: break
    
    length[d[i][0]] = max(length[d[i][0]], count)
    length[d[i + 1][0]] = max(length[d[i + 1][0]], count)

maxLength = max(length)

pre = 0
for i in range(n):
    if length[i] == maxLength:
        if pre == 0:
            pre = word[i][:maxLength]
            print(word[i])
        elif word[i][:maxLength] == pre:
            print(word[i])
            break
