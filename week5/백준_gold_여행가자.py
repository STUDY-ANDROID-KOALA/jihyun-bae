import sys
from collections import deque

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())

way = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

plan = list(map(lambda x: int(x) - 1, sys.stdin.readline().split()))
visited = [-1] * n

queue = deque([plan[0]])
visited[plan[0]] = 0

while queue:
    now = queue.popleft()

    for i in range(n):
        if way[now][i] == 1 and visited[i] == -1:
            visited[i] = visited[now] + 1
            queue.append(i)

for p in plan:
    if visited[p] == -1:
        print("NO")
        sys.exit()

print("YES")
