import sys

for _ in range(3):
    n = int(sys.stdin.readline())
    dict = {}
    total = 0

    for _ in range(n):
        money, count = map(int, sys.stdin.readline().split())
        total += money * count
        dict[money] = count
    
    if total % 2 == 1:
        print(0)
        continue

    target = total // 2
    dp = [1] + [0] * (target)

    for key, value in dict.items():
        for a in range(target, key - 1, -1):
            if dp[a - key]:
                for j in range(value):
                    if a + key * j <= target:
                        dp[a + key * j] = 1
    
    print(dp[total // 2])
