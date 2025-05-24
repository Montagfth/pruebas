import tkinter as tk
from tkinter import messagebox

class calculadora:
    def __init__(self,root):
        self.root = root
        self.root.title("calculadora")
        self.root.configure(bg="#2b2b2b")
        self.root.geometry("375x550")
        self.root.resizable(False,False)
        
        self.entrada = tk.Entry(root,width=17,font=('Arial',28),borderwidth=0,
                                relief='solid',bg="#2b2b2b", fg="white",justify='right')
        self.entrada.grid(row=0,column=0,columnspan=4, ipadx=8,ipady=10,pady=(10,5))
        self.crear_botones()
        
    def crear_botones(self):
        botones = [
        
            ('c',2),('←',1),('/,1'),
            ('7',1),('8',1),('9',1),('*',1),
            ('4',1),('5',1),('6',1),('-',1),
            ('4',1),('5',1),('3',1),('+',1),
            ('0',2),('.',1),('=',1),
            ]
        
        colores_botones = {
            'numero': '#4d4d4d',
            'operador': '#fe9505',
                'igual': '#fffff',
                'reset': '#d32f2f',
            'borrar':'#fe9505'
            }
        frame_botones = tk.Frame(self.root, bg = '#2b2b2b')
        frame_botones.grid(row=1,column=0,columnspan=4,pady=(0,10))
        
        fila = 0
        columna = 0
        for boton, span in botones:
            
            color_fondo = colores_botones['operador']if boton in ['/','*','-','+','=','←']else colores_botones['numero']
            if boton == 'c':
                color_fondo =colores_botones['reset']
            elif boton== '←':
                color_fondo = colores_botones['borrar']
            elif boton == '=':
                color_fondo = colores_botones['igual']
                
                tk.Button(frame_botones,text=boton,width=5*span,height=2,font=('arial',20),
                            bg=color_fondo,fg=colores_botones['texto'], borderwidth=0,
                            command=lambda b= boton:self.click_boton(b)).grid(row=fila,column=columna,columnspan=span,padx=1,pady=1, sticky='nsew')
            column += span
            if columna >=4:
                columna = 0
                fila +=1
                
                for i in range(4):
                    frame_botones.grid_columnconfigure(i,weight=1)
                    for i in range (fila + 1):
                        frame_botones.grid_rowconfigure(i, weight=1)
                            
    def click_botones(self, valor):
        if valor== '=':
            try:
                resultado = str(eval(self.entrada.get()))
                self.entrada.delete(0,tk.END)
            except Exception as e:
                messagebox.showerror("error","entrada no valida")
                self.entrada.delete(0,tk.END)
        elif valor == "c":
            self .entra0da.delete(0, tk.end)
        elif valor == "←":
            self.entrada.delete(len(self.entrada.get())-1, tk.end)
        else:
            self.entrada.insert(tk.END,valor)
            
if __name__ == " __main__":
    root = tk.tk()
    calculadora = calculadora(root)
    root.mainloop()
                            
                                    
                                        
                                    
                        
                                    
                                              
                                  