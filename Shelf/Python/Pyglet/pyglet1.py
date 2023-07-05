import pyglet
from pyglet import *
window = pyglet.window.Window()
label = pyglet.text.Label('Hello, world',
                          font_name='Times New Roman',
                          font_size=36,
                          x=window.width//2,
                          y=window.height//2,
                          anchor_x='center', anchor_y='center')
square = shapes.Rectangle(x=20,
                          y=200,
                          width=200,
                          height=200,
                          color=(55, 55, 255))

@window.event
def on_draw():
    window.clear()
    label.draw()
    square.draw()

pyglet.app.run()