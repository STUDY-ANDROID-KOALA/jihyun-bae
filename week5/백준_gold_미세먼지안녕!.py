# Python3 시간초과로 인해 PyPy3 이용

import sys

r, c, t = map(int, sys.stdin.readline().split())

now = [list(map(int, sys.stdin.readline().split())) for _ in range(r)]

air = []
for i in range(r):
    if now[i][0] == -1:
        air.append(i)

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

for _ in range(t):
    change = [[0] * c for _ in range(r)]
    for a in air:
        change[a][0] = -1

    for i in range(r):
        for j in range(c):
            if now[i][j] != 0 and now[i][j] != -1:
                amount = now[i][j] // 5

                count = 0
                for k in range(4):
                    next = [i + dx[k], j + dy[k]]

                    if 0 <= next[0] < r and 0 <= next[1] < c and now[next[0]][next[1]] != -1:
                        count += 1
                        change[next[0]][next[1]] += amount
                    
                change[i][j] += now[i][j] - (amount * count)
    
    for i in range(air[0] - 2, -1, -1): change[i + 1][0] = change[i][0]
    for i in range(1, c): change[0][i - 1] = change[0][i]
    for i in range(1, air[0] + 1): change[i - 1][c - 1] = change[i][c - 1]
    for i in range(c - 2, -1, -1): change[air[0]][i + 1] = change[air[0]][i]
    change[air[0]][1] = 0

    for i in range(air[1] + 2, r): change[i - 1][0] = change[i][0]
    for i in range(1, c): change[r - 1][i - 1] = change[r - 1][i]
    for i in range(r - 2, air[1] - 1, -1): change[i + 1][c - 1] = change[i][c - 1]
    for i in range(c - 2, -1, -1): change[air[1]][i + 1] = change[air[1]][i]
    change[air[1]][1] = 0

    now = change

print(sum(sum(row) for row in now) + 2)
