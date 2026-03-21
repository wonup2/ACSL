def solve_acsl_rings():
    points = {
        'A': 1, 'R': 1,
        'O': 3, 'G': 3,
        'B': 6
    }

    s1 = input().strip().upper()
    s2 = input().strip().upper()

    score1 = 0
    for letter in s1:
        score1 = score1 + points[letter]

    score2 = 0
    for letter in s2:
        score2 = score2 + points[letter]

    if score1 >= score2:
        print(score1, score2)
    else:
        print(score2, score1)

solve_acsl_rings()