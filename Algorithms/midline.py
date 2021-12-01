'''Midpoint line drawing algorithm.'''


def midpoint_line(x_1, y_1, x_2, y_2):
    '''This function implements midpoint line drawing algorithm.'''

    counter = 2

    # calculate dx & dy
    d_x = x_2 - x_1
    d_y = y_2 - y_1

    # initial value of decision parameter d
    decision_param = d_y - (d_x/2)
    x_coordinate = x_1
    y_coordinate = y_1

    # Plot initial given point
    # putpixel(x,y) can be used to print pixel
    # of line in graphics
    print(1, x_coordinate, ",", y_coordinate, "\n")
    # iterate through value of X
    while x_coordinate < x_2:
        x_coordinate = x_coordinate+1

        direction = True

        # E or East is chosen
        if decision_param < 0:
            decision_param = decision_param + d_y
            direction = True

        # NE or North East is chosen
        else:
            decision_param = decision_param + (d_y - d_x)
            y_coordinate = y_coordinate+1
            direction = False

        # Plot intermediate points
        # putpixel(x,y) is used to print pixel
        # of line in graphics
        print(counter, direction, x_coordinate, ",", y_coordinate, "\n")
        counter += 1


# Driver program
if __name__ == '__main__':
    X1 = 6
    Y1 = 93
    X2 = 88
    Y2 = 134
    midpoint_line(X1, Y1, X2, Y2)
