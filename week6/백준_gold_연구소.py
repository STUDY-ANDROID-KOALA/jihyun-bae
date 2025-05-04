import sys, copy
from itertools import combinations
from collections import deque

n, m = map(int, sys.stdin.readline().split())

maps = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
queue = deque()

virus = []
empty = []

for i in range(n):
    for j in range(m):
        if maps[i][j] == 2:
            virus.append([i, j])
        if maps[i][j] == 0:
            empty.append([i, j])

safe = 0

for t in list(combinations(empty, 3)):
    temp = copy.deepcopy(maps)
    
    for i in t:
        temp[i[0]][i[1]] = 1

    for v in virus:
        queue.append(v)

        while queue:
            now = queue.popleft()

            for i in range(4):
                next = [now[0] + dx[i], now[1] + dy[i]]

                if 0 <= next[0] < n and 0 <= next[1] < m and temp[next[0]][next[1]] == 0:
                    queue.append(next)
                    temp[next[0]][next[1]] = 1
        
    safe = max(safe, sum(row.count(0) for row in temp))

print(safe)
