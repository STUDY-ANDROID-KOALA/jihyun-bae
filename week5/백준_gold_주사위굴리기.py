import sys

n, m, x, y, k = map(int, sys.stdin.readline().split())

maps = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

dice = [0] * 6

dy = [1, -1, 0, 0]
dx = [0, 0, -1, 1]

move = list(map(int, sys.stdin.readline().split()))

now = [x, y]
for mo in move:
    next = [now[0] + dx[mo - 1], now[1] + dy[mo - 1]]

    if 0 <= next[0] < n and 0 <= next[1] < m:
        now = next
        if mo == 1:
            dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[3], dice[1], dice[0], dice[5], dice[4], dice[2]
        elif mo == 2:
            dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[2], dice[1], dice[5], dice[0], dice[4], dice[3]
        elif mo == 3:
            dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[4], dice[0], dice[2], dice[3], dice[5], dice[1]
        else:
            dice[0], dice[1], dice[2], dice[3], dice[4], dice[5] = dice[1], dice[5], dice[2], dice[3], dice[0], dice[4]
        
        if maps[next[0]][next[1]] == 0:
            maps[next[0]][next[1]] = dice[5]
        else:
            dice[5] = maps[next[0]][next[1]]
            maps[next[0]][next[1]] = 0
        
        print(dice[0])
