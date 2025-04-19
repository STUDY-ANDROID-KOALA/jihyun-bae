import sys
import heapq

repeat = 1
while(True):
    n = int(sys.stdin.readline())

    if(n == 0): break

    cave = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    heap = []
    rupee = [[int(1e9)] * n for _ in range(n)]
    rupee[0][0] = cave[0][0]
    heapq.heappush(heap, (cave[0][0], 0, 0))

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    while heap:
        distance, y, x = heapq.heappop(heap)

        if y == n - 1 and x == n - 1:
            print(f'Problem {repeat}: {distance}')
            repeat += 1
            break

        for i in range(len(dx)):
            ny = y + dy[i]
            nx = x + dx[i]

            if 0 <= ny < n and 0 <= nx < n:
                if rupee[ny][nx] > distance + cave[ny][nx]:
                    rupee[ny][nx] = distance + cave[ny][nx]
                    heapq.heappush(heap, (rupee[ny][nx], ny, nx))
