import sys
from collections import deque

n, m = map(int, sys.stdin.readline().split(' '))

ladderAndSanke = []

for _ in range(n + m):
    x, y = map(int, sys.stdin.readline().split(' '))
    ladderAndSanke.append([x, y])

ladderAndSanke.sort()

map = [0] * 101
stack = deque([1])

while stack:
    now = stack.popleft()

    for i in range(1, 7):
        next = now + i
        
        if 0 < next < 101:
            for j in range(len(ladderAndSanke)):
                if ladderAndSanke[j][0] == next:
                    next = ladderAndSanke[j][1]
        
            if map[next] == 0:
                map[next] = map[now] + 1
                stack.append(next)
    
    if map[100] != 0:
        print(map[100])
        break
