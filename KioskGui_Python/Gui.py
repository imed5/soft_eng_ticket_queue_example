import tkinter as tk
from tkinter import ttk
import urllib.request

def issueTicket(): 
    page = urllib.request.urlopen('http://localhost:4567/issueTicket/PY1')
    queue=page.read().decode("utf-8").strip()
    label.configure(text='Ticket Number :'+queue)


windows = tk.Tk()
windows.geometry("500x200")
windows.title("Kiosk GUI")

label = tk.Label(windows, text="Ticket Number : ")
label.place(x=100,y=50)

custom_button = ttk.Button(windows, text="Issue Ticket", command=issueTicket)
custom_button.place(x=100,y=150)

windows.mainloop()