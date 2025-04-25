import sys
from collections import deque, Counter

n, m = map(int, sys.stdin.readline().split())
cheese = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

def bfs():
    queue = deque([[0, 0]])
    melt = []

    while queue:
        now = queue.popleft()
        for i in range(4):
            next = [now[0] + dx[i], now[1] + dy[i]]
            if 0 <= next[0] < n and 0 <= next[1] < m and not visited[next[0]][next[1]]:
                if cheese[next[0]][next[1]] == 0:
                    visited[next[0]][next[1]] = 1
                    queue.append(next)
                else:
                    melt.append(next)
    
    count = Counter(tuple(x) for x in melt)
    real_melt = [melt for melt, v in count.items() if v >= 2]

    for r in real_melt:
        cheese[r[0]][r[1]] = 0
    
    return real_melt

answer = 0
while True:
    visited = [[0] * m for _ in range(n)]
    melt = bfs()

    if not melt: break
    else: answer += 1

print(answer)
