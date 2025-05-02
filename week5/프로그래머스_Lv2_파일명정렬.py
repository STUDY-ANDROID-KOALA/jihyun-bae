def solution(files):
    split = []
    
    for file in files:
        head, number, tail = '', '', ''
        for i in range(len(file)):
            if file[i].isdigit():
                head = file[:i]
                number = file[i:]
                
                for j in range(len(number)):
                    if not number[j].isdigit():
                        tail = number[j:]
                        number = number[:j]
                        break
                
                split.append([head, number, tail])
                break
    
    split = sorted(split, key = lambda x:(x[0].lower(), int(x[1])))            
    
    return [''.join(i) for i in split]
        
        
