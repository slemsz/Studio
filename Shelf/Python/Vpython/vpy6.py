from vpython import *
scene.width = 800
scene.height = 800

x, y, z = 0, -2, 5
obj = cylinder(
    pos = vector(x, y, z),
    size = vector(1, 1, 1),
    color = vector(0.72, 0.42, 0)
)

obj.rotate(
    angle = pi/2,
    axis = vec(0,0,1)
)

floor_box = box(
    size = vector(2, 0.1, 2),
    pos = vector(0, -2-.1, 5)
)

floor_box.rotate(
    angle = pi/2,
    axis = vec(0,1,0)
)