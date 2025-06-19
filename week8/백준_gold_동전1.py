import sys

n, k = map(int, sys.stdin.readline().split(' '))
dp = [0] * 10001
dp[0] = 1

for _ in range(n):
    index = int(sys.stdin.readline())
    
    for i in range(index, k + 1):
        dp[i] += dp[i - index]

print(dp[k])
