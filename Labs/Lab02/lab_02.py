"""
This code will draw my ID number's last 2 digits which is: 79
"""

# Using John Zelles graphics library
from graphics import GraphWin
from graphics import Point

# making window size 400 X 400
win = GraphWin("Seven Nine", 400, 400)
# making background black
win.setBackground("black")


def draw_line_low_mid(x0, y0, x1, y1):
    """Method to draw line if slope is negative."""

    dx = x1 - x0
    dy = y1 - y0

    if dy < 0:
        yi = -1
        dy = -dy

    y = y0
    x = x0
    d = dy - dx / 2

    while x <= x1:

        pt = Point(x, y)
        pt.setFill("cyan")
        pt.draw(win)

        if d < 0:
            d = d + dy
        else:
            d = d + dy - dx
            y = y + yi

        x = x + 1


def draw_line_high_mid(x0, y0, x1, y1):
    """Method to draw line if slope is positive."""

    dx = x1 - x0
    dy = y1 - y0

    if dx < 0:
        xi = -1
        dx = -dx

    y = y0
    x = x0
    d = dx - dy / 2

    while y <= y1:

        pt = Point(x, y)
        pt.setFill("yellow")
        pt.draw(win)

        if d < 0:
            d = d + dx
        else:
            d = d + dx - dy
            x = x + xi

        y = y + 1


def draw_line(x0, y0, x1, y1):
    """Desired method for midpoint line drawing."""

    if abs(x1 - x0) > abs(y1 - y0):
        if x0 > x1:
            draw_line_low_mid(x1, y1, x0, y0)
        else:
            draw_line_low_mid(x0, y0, x1, y1)
    else:
        if y0 > y1:
            draw_line_high_mid(x1, y1, x0, y0)
        else:
            draw_line_high_mid(x0, y0, x1, y1)


def draw_seven():
    """This method draws a 7."""

    draw_line(150, 80, 150, 200)
    draw_line(150, 80, 80, 80)


def draw_nine():
    """This method draws a 9."""

    draw_line(250, 80, 250, 200)
    draw_line(250, 80, 180, 80)
    draw_line(250, 150, 180, 150)
    draw_line(180, 80, 180, 150)
    draw_line(250, 200, 180, 200)


# main segment
draw_seven()
draw_nine()
win.getMouse()
win.close()
