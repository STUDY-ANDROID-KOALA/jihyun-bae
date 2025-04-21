import sys
from collections import deque

n = int(sys.stdin.readline())
line = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

size = 2
now = [0, 0]

for i in range(n):
    for j in range(n):
        if line[i][j] == 9:
            now = [i, j]
            break

line[now[0]][now[1]] = 0

def bfs(x, y, now_size):
    visited = [[-1] * n for _ in range(n)]
    queue = deque()
    eat = []

    queue.append([x, y])
    visited[x][y] = 0

    while queue:
        now = queue.popleft()

        for i in range(4):
            next = [now[0] + dx[i], now[1] + dy[i]]
            if 0 <= next[0] < n and 0 <= next[1] < n and visited[next[0]][next[1]] == -1:
                if line[next[0]][next[1]] <= now_size:
                    queue.append(next)
                    visited[next[0]][next[1]] = visited[now[0]][now[1]] + 1
                    if line[next[0]][next[1]] < now_size and line[next[0]][next[1]] != 0:
                        eat.append([next[0], next[1], visited[next[0]][next[1]]])
    
    return sorted(eat, key = lambda e: (-e[2], -e[0], -e[1]))

answer = 0
count = 0

while True:
    eat = bfs(now[0], now[1], size)

    if len(eat) == 0:
        break

    next = eat.pop()

    answer += next[2]
    count += 1
    line[next[0]][next[1]] = 0
    now = [next[0], next[1]]

    if count == size:
        size += 1
        count = 0

print(answer)
