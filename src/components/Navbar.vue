<template>
    <nav class="navbar">
      <div class="container">
        <div class="logo">Mi Sitio</div>
        <ul class="nav-links">
          <li><a href="#">Inicio</a></li>
          <li><a href="#">Servicios</a></li>
          <li><a href="#">Contacto</a></li>
        </ul>
        <div class="login-button">
          <router-link to="/auth/login">Iniciar Sesión</router-link>
        </div>
      </div>
    </nav>
  </template>
  
  <script>
  export default {
    name: "Navbar",
  };
  </script>
  
  <style scoped>
  /* Estilos generales del navbar */
  .navbar {
    background-color: #2c3e50; /* Azul oscuro */
    color: white;
    padding: 10px 20px;
    display: flex;
    justify-content: center;
    align-items: center;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  }
  
  .container {
    width: 100%;
    max-width: 1200px;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  /* Logo */
  .logo {
    font-size: 1.5rem;
    font-weight: bold;
    color: #ecf0f1;
  }
  
  /* Enlaces de navegación */
  .nav-links {
    list-style: none;
    display: flex;
    gap: 20px;
    margin: 0;
    padding: 0;
  }
  
  .nav-links li {
    font-size: 1rem;
  }
  
  .nav-links a {
    text-decoration: none;
    color: #ecf0f1;
    transition: color 0.3s ease;
  }
  
  .nav-links a:hover {
    color: #3498db; /* Azul claro */
  }
  
  /* Botón de login */
  .login-button a {
    text-decoration: none;
    padding: 8px 16px;
    color: white;
    background-color: #3498db; /* Azul claro */
    border-radius: 5px;
    font-weight: bold;
    transition: background-color 0.3s ease;
  }
  
  .login-button a:hover {
    background-color: #2980b9; /* Azul más oscuro */
  }
  </style>
  