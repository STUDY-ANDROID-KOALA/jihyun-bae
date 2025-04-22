from collections import Counter

def solution(str1, str2):
    str1_set = make_set(str1)
    str2_set = make_set(str2)
    
    inter = sum((str1_set & str2_set).values())
    union = sum((str1_set | str2_set).values())
    
    return 65536 if union == 0 else int((inter / union) * 65536)


def make_set(str):
    str = str.lower()
    return Counter(
        str[i:i + 2] for i in range(len(str) - 1) if str[i:i + 2].isalpha()
    )
