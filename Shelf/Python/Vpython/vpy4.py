from vpython import *
scene.y = 400

track = box(
    pos = vector(0, -.05, 0),
    size = vector(1.0,0.05,0.10)
)

cart = box(
    pos = vector(-0.5, 0, 0),
    size = vector(0.1,0.04,0.06),
    color = color.green
)

cart.m = 0.80
cart.p = cart.m * vector(0.7, 0.1, 0)
cart.trail = curve (
    color = color.red
)
deltat = 0.01

t = 0

mgraph = gcurve(
    color = color.cyan
)

while t < 3.0 :
    t = t + deltat
    rate(100)
    Fnet = vector(0.0, -.8, 0)
    cart.p = cart.p + Fnet*deltat
    print("t= ", t, "cart.p", cart.p)
    cart.pos = cart.pos + (cart.p/cart.m) * deltat
    mgraph.plot(pos = (t, cart.p.x))
    cart.trail.append(pos = cart.pos)

