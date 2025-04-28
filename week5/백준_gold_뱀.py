import sys

n = int(sys.stdin.readline())
board = [[''] * n for _ in range(n)]

k = int(sys.stdin.readline())
for _ in range(k):
    i, j = map(int, sys.stdin.readline().split())
    board[i - 1][j - 1] = 'A'

L = int(sys.stdin.readline())
change = [[int(x[0]), x[1]] for x in (sys.stdin.readline().split() for _ in range(L))]

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

now = [0, 0]
snake = [[0, 0]]
way = 0
answer = 0

while True:
    if len(change) != 0 and change[0][0] == answer:
        if change[0][1] == 'L':
            way = (way - 1) % 4
        else:
            way = (way + 1) % 4
        
        del change[0]

    now = [now[0] + dx[way], now[1] + dy[way]]
    answer += 1

    if now in snake or 0 > now[0] or now[0] >= n or 0 > now[1] or now[1] >= n:
        break

    snake.append(now)
    if board[now[0]][now[1]] == 'A':
        board[now[0]][now[1]] = ''
    else:
        del snake[0]

print(answer)
