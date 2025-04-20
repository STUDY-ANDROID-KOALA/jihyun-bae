import sys

N, X = map(int, sys.stdin.readline().rstrip().split())
person = list(map(int, sys.stdin.readline().rstrip().split()))

start = 0
end = X - 1

max_person = sum(person[start:X])
temp = max_person
max_count = 1

while (end < N - 1) :
    start = start + 1
    end = end + 1

    temp += - person[start - 1] + person[end]
    if (max_person == temp):
        max_count += 1
    elif (max_person < temp):
        max_person = temp
        max_count = 1

if (max_person == 0):
    print("SAD")
else:
    print(max_person, end="\n")
    print(max_count)
