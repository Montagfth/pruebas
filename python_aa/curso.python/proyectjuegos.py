#import pygame 
import math
import random
from collections import deque
from dataclasses import dataclass
from typing import List, Tuple, Optional
from enum import Enum

# Inicializar Pygame
pygame.init()

# Constantes
WINDOW_WIDTH = 1000
WINDOW_HEIGHT = 700
FPS = 60
TRACK_WIDTH = 800
TRACK_HEIGHT = 500

# Colores
WHITE = (255, 255, 255)
BLACK = (0, 0, 0)
RED = (255, 0, 0)
BLUE = (0, 0, 255)
GREEN = (0, 255, 0)
YELLOW = (255, 255, 0)
PURPLE = (255, 0, 255)
ORANGE = (255, 165, 0)
GRAY = (128, 128, 128)
DARK_GRAY = (64, 64, 64)

class PowerUpType(Enum):
    MISSILE = "missile"
    BOOST = "boost"
    SHIELD = "shield"
    MINE = "mine"

@dataclass
class Vector2D:
    x: float
    y: float
    
    def __add__(self, other):
        return Vector2D(self.x + other.x, self.y + other.y)
    
    def __mul__(self, scalar):
        return Vector2D(self.x * scalar, self.y * scalar)
    
    def magnitude(self):
        return math.sqrt(self.x**2 + self.y**2)
    
    def normalize(self):
        mag = self.magnitude()
        if mag > 0:
            return Vector2D(self.x / mag, self.y / mag)
        return Vector2D(0, 0)

class Kart:
    def __init__(self, x: float, y: float, color: Tuple[int, int, int], player_id: int):
        self.position = Vector2D(x, y)
        self.velocity = Vector2D(0, 0)
        self.angle = 0.0
        self.color = color
        self.player_id = player_id
        self.speed = 0.0
        self.max_speed = 4.0
        self.acceleration = 0.3
        self.friction = 0.85
        self.turn_speed = 3.0
        self.size = 20
        self.hp = 100
        self.max_hp = 100
        self.shield_time = 0
        self.boost_time = 0
        self.power_ups = deque(maxlen=3)  # Cola para power-ups
        self.last_shot = 0
        self.shoot_cooldown = 30
        
    def update(self):
        # Aplicar fricción
        self.velocity = self.velocity * self.friction
        
        # Actualizar posición
        self.position = self.position + self.velocity
        
        # Mantener dentro de los límites
        self.position.x = max(self.size, min(TRACK_WIDTH - self.size, self.position.x))
        self.position.y = max(self.size, min(TRACK_HEIGHT - self.size, self.position.y))
        
        # Actualizar efectos temporales
        if self.shield_time > 0:
            self.shield_time -= 1
        if self.boost_time > 0:
            self.boost_time -= 1
            
        if self.last_shot > 0:
            self.last_shot -= 1
    
    def accelerate(self):
        speed_multiplier = 1.5 if self.boost_time > 0 else 1.0
        forward = Vector2D(math.cos(math.radians(self.angle)), 
                          math.sin(math.radians(self.angle)))
        self.velocity = self.velocity + forward * (self.acceleration * speed_multiplier)
        
        # Limitar velocidad máxima
        if self.velocity.magnitude() > self.max_speed * speed_multiplier:
            self.velocity = self.velocity.normalize() * (self.max_speed * speed_multiplier)
    
    def brake(self):
        self.velocity = self.velocity * 0.7
    
    def turn_left(self):
        self.angle -= self.turn_speed
    
    def turn_right(self):
        self.angle += self.turn_speed
    
    def add_power_up(self, power_up_type: PowerUpType):
        self.power_ups.append(power_up_type)
    
    def use_power_up(self):
        if self.power_ups and self.last_shot == 0:
            power_up = self.power_ups.popleft()
            self.last_shot = self.shoot_cooldown
            return power_up
        return None
    
    def take_damage(self, damage: int):
        if self.shield_time == 0:
            self.hp -= damage
            self.hp = max(0, self.hp)
    
    def heal(self, amount: int):
        self.hp = min(self.max_hp, self.hp + amount)
    
    def draw(self, screen):
        # Dibujar kart
        kart_points = []
        for dx, dy in [(-self.size//2, -self.size//3), (self.size//2, 0), 
                       (-self.size//2, self.size//3)]:
            # Rotar puntos
            cos_a = math.cos(math.radians(self.angle))
            sin_a = math.sin(math.radians(self.angle))
            rx = dx * cos_a - dy * sin_a
            ry = dx * sin_a + dy * cos_a
            kart_points.append((self.position.x + rx, self.position.y + ry))
        
        # Color del kart (cambiar si tiene escudo)
        color = (255, 255, 255) if self.shield_time > 0 else self.color
        pygame.draw.polygon(screen, color, kart_points)
        
        # Dibujar barra de vida
        bar_width = 40
        bar_height = 6
        bar_x = self.position.x - bar_width // 2
        bar_y = self.position.y - self.size - 10
        
        # Fondo de la barra
        pygame.draw.rect(screen, RED, (bar_x, bar_y, bar_width, bar_height))
        
        # Vida actual
        health_width = int((self.hp / self.max_hp) * bar_width)
        pygame.draw.rect(screen, GREEN, (bar_x, bar_y, health_width, bar_height))
        
        # Indicador de power-ups
        for i, power_up in enumerate(list(self.power_ups)):
            icon_x = self.position.x - 15 + i * 10
            icon_y = self.position.y + self.size + 5
            
            if power_up == PowerUpType.MISSILE:
                pygame.draw.circle(screen, RED, (int(icon_x), int(icon_y)), 3)
            elif power_up == PowerUpType.BOOST:
                pygame.draw.circle(screen, YELLOW, (int(icon_x), int(icon_y)), 3)
            elif power_up == PowerUpType.SHIELD:
                pygame.draw.circle(screen, BLUE, (int(icon_x), int(icon_y)), 3)
            elif power_up == PowerUpType.MINE:
                pygame.draw.circle(screen, DARK_GRAY, (int(icon_x), int(icon_y)), 3)

class Projectile:
    def __init__(self, x: float, y: float, angle: float, speed: float, 
                 projectile_type: PowerUpType, owner_id: int):
        self.position = Vector2D(x, y)
        self.angle = angle
        self.speed = speed
        self.type = projectile_type
        self.owner_id = owner_id
        self.lifetime = 180  # 3 segundos a 60 FPS
        self.size = 8 if projectile_type == PowerUpType.MISSILE else 5
        
        # Calcular velocidad
        self.velocity = Vector2D(
            math.cos(math.radians(angle)) * speed,
            math.sin(math.radians(angle)) * speed
        )
    
    def update(self):
        self.position = self.position + self.velocity
        self.lifetime -= 1
        return self.lifetime > 0
    
    def draw(self, screen):
        color = RED if self.type == PowerUpType.MISSILE else DARK_GRAY
        pygame.draw.circle(screen, color, 
                         (int(self.position.x), int(self.position.y)), self.size)

class PowerUp:
    def __init__(self, x: float, y: float, power_type: PowerUpType):
        self.position = Vector2D(x, y)
        self.type = power_type
        self.size = 15
        self.collected = False
        self.spawn_time = pygame.time.get_ticks()
    
    def draw(self, screen):
        if not self.collected:
            color_map = {
                PowerUpType.MISSILE: RED,
                PowerUpType.BOOST: YELLOW,
                PowerUpType.SHIELD: BLUE,
                PowerUpType.MINE: DARK_GRAY
            }
            
            color = color_map.get(self.type, WHITE)
            pygame.draw.circle(screen, color, 
                             (int(self.position.x), int(self.position.y)), self.size)
            pygame.draw.circle(screen, BLACK, 
                             (int(self.position.x), int(self.position.y)), self.size, 2)

class GameArena:
    def __init__(self):
        self.karts: List[Kart] = []
        self.projectiles: List[Projectile] = []
        self.power_ups: List[PowerUp] = []
        self.mines: List[Projectile] = []
        self.last_powerup_spawn = 0
        self.powerup_spawn_rate = 120  # 2 segundos
        
        # Crear karts de jugadores
        self.create_karts()
        
        # Spawn inicial de power-ups
        self.spawn_power_ups(5)
    
    def create_karts(self):
        # Posiciones iniciales para 4 jugadores
        start_positions = [
            (100, 100, RED),
            (TRACK_WIDTH - 100, 100, BLUE),
            (100, TRACK_HEIGHT - 100, GREEN),
            (TRACK_WIDTH - 100, TRACK_HEIGHT - 100, YELLOW)
        ]
        
        for i, (x, y, color) in enumerate(start_positions):
            self.karts.append(Kart(x, y, color, i))
    
    def spawn_power_ups(self, count: int):
        for _ in range(count):
            x = random.randint(50, TRACK_WIDTH - 50)
            y = random.randint(50, TRACK_HEIGHT - 50)
            power_type = random.choice(list(PowerUpType))
            self.power_ups.append(PowerUp(x, y, power_type))
    
    def update(self):
        # Actualizar karts
        for kart in self.karts:
            kart.update()
        
        # Actualizar proyectiles
        self.projectiles = [p for p in self.projectiles if p.update()]
        self.mines = [m for m in self.mines if m.update()]
        
        # Spawn de power-ups
        self.last_powerup_spawn += 1
        if self.last_powerup_spawn >= self.powerup_spawn_rate:
            if len(self.power_ups) < 8:
                self.spawn_power_ups(1)
            self.last_powerup_spawn = 0
        
        # Detectar colisiones
        self.check_collisions()
    
    def check_collisions(self):
        # Colisiones kart-power_up
        for kart in self.karts:
            for power_up in self.power_ups:
                if not power_up.collected:
                    dist = math.sqrt((kart.position.x - power_up.position.x)**2 + 
                                   (kart.position.y - power_up.position.y)**2)
                    if dist < kart.size + power_up.size:
                        kart.add_power_up(power_up.type)
                        if power_up.type == PowerUpType.SHIELD:
                            kart.shield_time = 180
                        elif power_up.type == PowerUpType.BOOST:
                            kart.boost_time = 120
                        power_up.collected = True
        
        # Remover power-ups recolectados
        self.power_ups = [p for p in self.power_ups if not p.collected]
        
        # Colisiones proyectil-kart
        for projectile in self.projectiles[:]:
            for kart in self.karts:
                if kart.player_id != projectile.owner_id:
                    dist = math.sqrt((kart.position.x - projectile.position.x)**2 + 
                                   (kart.position.y - projectile.position.y)**2)
                    if dist < kart.size + projectile.size:
                        if projectile.type == PowerUpType.MISSILE:
                            kart.take_damage(25)
                        self.projectiles.remove(projectile)
                        break
        
        # Colisiones mina-kart
        for mine in self.mines[:]:
            for kart in self.karts:
                if kart.player_id != mine.owner_id:
                    dist = math.sqrt((kart.position.x - mine.position.x)**2 + 
                                   (kart.position.y - mine.position.y)**2)
                    if dist < kart.size + mine.size:
                        kart.take_damage(35)
                        self.mines.remove(mine)
                        break
    
    def shoot_projectile(self, kart: Kart, power_up_type: PowerUpType):
        if power_up_type == PowerUpType.MISSILE:
            projectile = Projectile(kart.position.x, kart.position.y, 
                                  kart.angle, 8, power_up_type, kart.player_id)
            self.projectiles.append(projectile)
        elif power_up_type == PowerUpType.MINE:
            # Las minas se dejan en la posición actual
            mine = Projectile(kart.position.x, kart.position.y, 
                            0, 0, power_up_type, kart.player_id)
            mine.lifetime = 600  # 10 segundos
            self.mines.append(mine)
    
    def draw(self, screen):
        # Dibujar fondo de la pista
        pygame.draw.rect(screen, GRAY, (0, 0, TRACK_WIDTH, TRACK_HEIGHT))
        pygame.draw.rect(screen, WHITE, (0, 0, TRACK_WIDTH, TRACK_HEIGHT), 3)
        
        # Dibujar power-ups
        for power_up in self.power_ups:
            power_up.draw(screen)
        
        # Dibujar minas
        for mine in self.mines:
            mine.draw(screen)
        
        # Dibujar proyectiles
        for projectile in self.projectiles:
            projectile.draw(screen)
        
        # Dibujar karts
        for kart in self.karts:
            kart.draw(screen)

def main():
    screen = pygame.display.set_mode((WINDOW_WIDTH, WINDOW_HEIGHT))
    pygame.display.set_caption("Smash Karts - Python")
    clock = pygame.time.Clock()
    
    # Crear arena de juego
    arena = GameArena()
    
    # Fuente para texto
    font = pygame.font.Font(None, 36)
    small_font = pygame.font.Font(None, 24)
    
    running = True
    while running:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                running = False
            elif event.type == pygame.KEYDOWN:
                # Disparar power-ups
                if event.key == pygame.K_SPACE:  # Jugador 1
                    power_up = arena.karts[0].use_power_up()
                    if power_up:
                        arena.shoot_projectile(arena.karts[0], power_up)
                elif event.key == pygame.K_RETURN:  # Jugador 2
                    power_up = arena.karts[1].use_power_up()
                    if power_up:
                        arena.shoot_projectile(arena.karts[1], power_up)
        
        # Controles de los karts
        keys = pygame.key.get_pressed()
        
        # Jugador 1 (WASD)
        if keys[pygame.K_w]:
            arena.karts[0].accelerate()
        if keys[pygame.K_s]:
            arena.karts[0].brake()
        if keys[pygame.K_a]:
            arena.karts[0].turn_left()
        if keys[pygame.K_d]:
            arena.karts[0].turn_right()
        
        # Jugador 2 (Flechas)
        if keys[pygame.K_UP]:
            arena.karts[1].accelerate()
        if keys[pygame.K_DOWN]:
            arena.karts[1].brake()
        if keys[pygame.K_LEFT]:
            arena.karts[1].turn_left()
        if keys[pygame.K_RIGHT]:
            arena.karts[1].turn_right()
        
        # Actualizar juego
        arena.update()
        
        # Dibujar todo
        screen.fill(BLACK)
        arena.draw(screen)
        
        # Dibujar interfaz
        y_offset = TRACK_HEIGHT + 20
        
        # Información de jugadores
        for i, kart in enumerate(arena.karts[:2]):  # Solo mostrar 2 jugadores activos
            player_text = f"Jugador {i+1}: HP {kart.hp}/100"
            powerups_text = f"Power-ups: {len(kart.power_ups)}"
            
            text_surface = small_font.render(player_text, True, kart.color)
            powerup_surface = small_font.render(powerups_text, True, kart.color)
            
            screen.blit(text_surface, (10 + i * 200, y_offset))
            screen.blit(powerup_surface, (10 + i * 200, y_offset + 25))
        
        # Controles
        controls_text = [
            "Jugador 1: WASD para mover, ESPACIO para disparar",
            "Jugador 2: Flechas para mover, ENTER para disparar",
            "Power-ups: Rojo=Misil, Amarillo=Turbo, Azul=Escudo, Gris=Mina"
        ]
        
        for i, text in enumerate(controls_text):
            text_surface = small_font.render(text, True, WHITE)
            screen.blit(text_surface, (10, y_offset + 60 + i * 20))
        
        pygame.display.flip()
        clock.tick(FPS)
    
    pygame.quit()

if __name__ == "__main__":
    main()