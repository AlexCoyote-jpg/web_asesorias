<%-- 
    Document   : login
    Created on : 18 may 2025, 6:48:12 p.m.
    Author     : aleja
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mentorízate - Profesor-Alumno</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
            body {
                margin: 0;
                padding: 0;
                background: #4ec3c5;
                font-family: 'Comic Sans MS', 'Comic Sans', cursive, sans-serif;
            }
            .container {
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
            }
            .bienvenido {
                color: #fff;
                font-size: 2.3em;
                font-weight: bold;
                margin-bottom: 18px;
                letter-spacing: 1px;
                text-align: center;
            }
            img.logo {
                margin-bottom: 0.2em;
                display: block;
                margin-left: auto;
                margin-right: auto;
                width: 340px;
                height: auto;
                max-width: 90vw;
            }
            .eres {
                color: #fff;
                font-size: 1.3em;
                margin-bottom: 1.2em;
                font-weight: bold;
                text-align: center;
            }
            .botones {
                display: flex;
                gap: 3em;
                margin-top: 10px;
            }
            .boton {
                background: #fff;
                color: #222;
                border: 3px solid #222;
                border-radius: 12px;
                padding: 0.7em 2.8em;
                font-size: 1.25em;
                font-weight: bold;
                cursor: pointer;
                box-shadow: 4px 4px 0 #000;
                transition: background 0.2s, color 0.2s, box-shadow 0.2s, transform 0.1s;
                letter-spacing: 1px;
                font-family: inherit;
            }
            .boton:hover {
                background: #ffe066;
                color: #222;
                box-shadow: 2px 2px 0 #000;
                transform: scale(1.07) rotate(-2deg);
            }
            .boton:active {
                background: #fff176;
                transform: scale(0.98);
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="bienvenido">BIENVENIDO A:</div>
            <img class='logo' src="../imagenes/logo.png" alt='Logo'>
            <div class="eres">¿Quién eres?</div>
            <div class="botones">
                <button class="boton" onclick="window.location.href='loginAlumno.jsp'">Soy Alumno</button>
                <button class="boton" onclick="window.location.href='loginProfesor.jsp'">Soy Profesor</button>
            </div>
        </div>
    </body>
</html>
