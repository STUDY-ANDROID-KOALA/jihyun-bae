import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split())
way = [-1] * 100001

way[n] = 0
queue = deque([n])

while queue:
    now = queue.popleft()

    if 0 <= now * 2 < 100001 and way[now * 2] == -1:
        way[now * 2] = way[now]
        queue.appendleft(now * 2)

    if 0 <= now - 1 < 100001 and way[now - 1] == -1:
        way[now - 1] = way[now] + 1
        queue.append(now - 1)

    if 0 <= now + 1 < 100001 and way[now + 1] == -1:
        way[now + 1] = way[now] + 1
        queue.append(now + 1)

print(way[k])
