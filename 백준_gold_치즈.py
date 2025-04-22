import sys
from collections import deque

m, n = map(int, sys.stdin.readline().split())
cheese = [list(map(int, sys.stdin.readline().split())) for _ in range(m)]
time = 0

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    queue = deque([[0, 0]])
    melt = 0

    while queue:
        now = queue.popleft()
        for i in range(4):
            next = [now[0] + dx[i], now[1] + dy[i]]
            if 0 <= next[0] < m and 0 <= next[1] < n and not visited[next[0]][next[1]]:
                visited[next[0]][next[1]] = 1
                if cheese[next[0]][next[1]] == 0:
                    queue.append(next)
                else:
                    melt += 1
                    cheese[next[0]][next[1]] = 0
    
    return melt

while True:
    visited = [[0] * n for _ in range(m)]
    melt = bfs()
    time += 1

    if not any(1 in row for row in cheese):
        print(time)
        print(melt)
        break
