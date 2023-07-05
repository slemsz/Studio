from vpython import *

track = box(
    pos=vector(0,-0.5,0),
    size=vector(1.0,0.05,0.10)
)

cart = box(
    pos = vector(-0.5, 0, 0),
    size = vector(0.1,0.04,0.06),
    color = color.green
)

cart.m = 0.80
cart.p = cart.m*vector(0.5, 0, 0)
deltat = 0.01
t = 0
while(t<3.0):
    t = t + deltat
    rate(100)
    Fnet = vector(-0.4, 0, 0)
    cart.p = cart.p + Fnet*deltat
    cart.pos = cart.pos + (cart.p/cart.m)*deltat

