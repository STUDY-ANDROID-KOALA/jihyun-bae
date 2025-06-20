import sys
from collections import deque

n, k = map(int, sys.stdin.readline().split(' '))
belt = deque(list(map(int, sys.stdin.readline().split(' '))))
robot = deque([0] * n)

answer = 0

while belt.count(0) < k:
    answer += 1

    belt.rotate(1)
    robot.rotate(1)
    robot[n - 1] = 0

    for i in range(n - 2, -1, -1):
        if robot[i] == 1 and robot[i + 1] == 0 and belt[i + 1] >= 1:
            robot[i] = 0
            robot[i + 1] = 1
            belt[i + 1] -= 1

    robot[n - 1] = 0

    if belt[0] >= 1:
        robot[0] = 1
        belt[0] -= 1

print(answer)
