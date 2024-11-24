<template>
    <nav class="navbar">
      <div class="container">
        <div class="logo">Mi Sitio</div>
        <ul class="nav-links">
          <li><router-link to="/">Inicio</router-link></li>
          <li><router-link to="/ciencia-datos">Ciencia de Datos</router-link></li>
        </ul>
      </div>
    </nav>
  </template>
  
  <script>
  export default {
    name: "NavbarDespInicio",
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
  </style>
  