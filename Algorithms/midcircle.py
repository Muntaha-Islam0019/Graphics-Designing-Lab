'''Midpoint circle drawing algorithm.'''


def midpoint_circle(x_centre, y_centre, radius):
    '''This function implements midpoint circle drawing algorithm.'''

    x_coordinate = radius
    y_coordinate = 0

    # Printing the initial point the
    # axes after translation
    print("(", x_coordinate + x_centre, ", ",
          y_coordinate + y_centre, ")",
          sep="", end="")

    # When radius is zero only a single
    # point be printed
    if radius > 0:

        print("(", x_coordinate + x_centre, ", ",
              -y_coordinate + y_centre, ")",
              sep="", end="")
        print("(", y_coordinate + x_centre, ", ",
              x_coordinate + y_centre, ")",
              sep="", end="")
        print("(", -y_coordinate + x_centre, ", ",
              x_coordinate + y_centre, ")", sep="")

    # Initialising the value of P
    p_val = 1 - radius

    while x_coordinate > y_coordinate:

        y_coordinate += 1

        # Mid-point inside or on the perimeter
        if p_val <= 0:
            p_val = p_val + 2 * y_coordinate + 1

        # Mid-point outside the perimeter
        else:
            x_coordinate -= 1
            p_val = p_val + 2 * y_coordinate - 2 * x_coordinate + 1

        # All the perimeter points have
        # already been printed
        if x_coordinate < y_coordinate:
            break

        # Printing the generated point its reflection
        # in the other octants after translation
        print("(", x_coordinate + x_centre, ", ", y_coordinate + y_centre,
              ")", sep="", end="")
        print("(", -x_coordinate + x_centre, ", ", y_coordinate + y_centre,
              ")", sep="", end="")
        print("(", x_coordinate + x_centre, ", ", -y_coordinate + y_centre,
              ")", sep="", end="")
        print("(", -x_coordinate + x_centre, ", ", -y_coordinate + y_centre,
              ")", sep="")

        # If the generated point on the line x = y then
        # the perimeter points have already been printed
        if x_coordinate != y_coordinate:

            print("(", y_coordinate + x_centre, ", ", x_coordinate + y_centre,
                  ")", sep="", end="")
            print("(", -y_coordinate + x_centre, ", ", x_coordinate + y_centre,
                  ")", sep="", end="")
            print("(", y_coordinate + x_centre, ", ", -x_coordinate + y_centre,
                  ")", sep="", end="")
            print("(", -y_coordinate + x_centre, ", ", -x_coordinate + y_centre,
                  ")", sep="")


# Driver Code
if __name__ == '__main__':

    # To draw a circle of radius 3
    # centred at (0, 0)
    midpoint_circle(0, 0, 41)
