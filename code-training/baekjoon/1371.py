import sys
from collections import defaultdict

char_count = defaultdict(int)
try:
    lines = sys.stdin.readlines()

    for line in lines:
        for char in line:
            if char.isalpha():
                char_count[char.lower()] += 1

    if char_count:
        max_count = max(char_count.values())
        max_chars = [char for char, count in char_count.items() if count == max_count]
        max_chars.sort()
        print(''.join(max_chars))
    else:
        print()

except ValueError:
    print()
