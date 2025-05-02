def change(x):
    exc = {'C#':'1','D#':'2', 'F#':'3', 'G#':'4', 'A#':'5', 'B#':'6'}
    for k, v in exc.items():
        x = x.replace(k, v)
    return x

def solution(m, musicinfos):
    answer = []
    
    for music in musicinfos:
        info = music.split(",")
        time = int(info[1].split(":")[0]) * 60 + int(info[1].split(":")[1]) - int(info[0].split(":")[0]) * 60 - int(info[0].split(":")[1])
        
        info[3] = change(info[3])
        
        if time >= len(info[3]):
            temp = info[3] * (time // len(info[3])) + info[3][:time % len(info[3])]
        else:
            temp = info[3][:time]
            
        if change(m) in temp:
            answer.append([time, info[2]])
    
    if len(answer) == 0:
        return '(None)'
    else:
        return sorted(answer, key = lambda x: -x[0])[0][1]
