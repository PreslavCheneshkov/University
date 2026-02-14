width, height, maxval = 360, 360, 255

with open("gradient_360x360.pgm", "w") as f:
    f.write(f"P2\n{width} {height}\n{maxval}\n")
    for y in range(height):
        row = [str((x * maxval) // (width - 1)) for x in range(width)]
        f.write(" ".join(row) + "\n")