import sys

h, w = map(int, sys.stdin.readline().split(' '))
blocks = list(map(int, sys.stdin.readline().split(' ')))

answer = 0

for i in range(1, len(blocks) - 1):
    left = max(blocks[:i])
    right = max(blocks[i + 1:])

    m = min(left, right)

    if m > blocks[i]:
        answer += m - blocks[i]

print(answer)
