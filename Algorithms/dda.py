def ROUND(a):

    return int(a + 0.5)


def drawDDA(x1, y1, x2, y2):

    x, y = x1, y1

    length = (x2-x1) if (x2-x1) > (y2-y1) else (y2-y1)

    dx = (x2-x1)/float(length)

    dy = (y2-y1)/float(length)

    print('x = %s, y = %s' % (((ROUND(x), ROUND(y)))))

    for _ in range(length):

        x += dx

        y += dy

        print('x = %s, y = %s' % (((ROUND(x), ROUND(y)))))


# x1, y1, x2, y2
drawDDA(21, 61, 81, 12)
