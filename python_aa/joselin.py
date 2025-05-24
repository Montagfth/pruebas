import turtle

# Pantalla
pantalla = turtle.Screen()
pantalla.bgcolor("lightpink")
pantalla.title("Para Joselin 💖")

# Corazón
corazon = turtle.Turtle()
corazon.pensize(3)
corazon.color("red")
corazon.speed(2)

def dibujar_corazon():
    corazon.begin_fill()
    corazon.left(140)
    corazon.forward(180)
    corazon.circle(-90, 200)
    corazon.left(120)
    corazon.circle(-90, 200)
    corazon.forward(180)
    corazon.end_fill()

# Mensaje
mensaje = turtle.Turtle()
mensaje.hideturtle()
mensaje.penup()
mensaje.color("darkblue")
mensaje.goto(0, -180)
mensaje.write("Para Joselin 💕\nEres especial, nunca lo olvides pdts te voy a pegar 😊", align="center", font=("Arial", 20, "bold"))

# Dibuja el corazón
dibujar_corazon()

# Espera
pantalla.mainloop()
