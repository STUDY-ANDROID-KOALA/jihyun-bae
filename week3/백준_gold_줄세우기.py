import sys

n = int(sys.stdin.readline())
line = [int(sys.stdin.readline()) for _ in range(n)]
dp = [1] * n

for i in range(n):
    for j in range(i):
        if line[i] > line[j]:
            dp[i] = max(dp[i], dp[j] + 1)

print(n - max(dp))
