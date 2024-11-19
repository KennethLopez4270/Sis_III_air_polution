<template>
    <footer class="footer">
      <div class="footer-container">
        <!-- Sección de información -->
        <div class="footer-info">
          <h3>Mi Sitio</h3>
          <p>&copy; 2024 Todos los derechos reservados.</p>
        </div>
  
        <!-- Sección de enlaces -->
        <div class="footer-links">
          <ul>
            <li><a href="#">Sobre Nosotros</a></li>
            <li><a href="#">Política de Privacidad</a></li>
            <li><a href="#">Términos y Condiciones</a></li>
          </ul>
        </div>
  
        <!-- Sección de redes sociales -->
        <div class="footer-socials">
          <a href="#" aria-label="Facebook">
            <i class="fab fa-facebook"></i>
          </a>
          <a href="#" aria-label="Twitter">
            <i class="fab fa-twitter"></i>
          </a>
          <a href="#" aria-label="Instagram">
            <i class="fab fa-instagram"></i>
          </a>
        </div>
      </div>
    </footer>
  </template>
  
  <script>
  export default {
    name: "Footer",
  };
  </script>
  
  <style scoped>
  /* Estilos del footer */
  .footer {
    background-color: #2c3e50; /* Azul oscuro */
    color: #ecf0f1; /* Gris claro */
    padding: 20px 0;
    text-align: center;
  }
  
  .footer-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
  }
  
  .footer-info h3 {
    margin: 0;
    font-size: 1.5rem;
  }
  
  .footer-info p {
    margin: 5px 0 0;
    font-size: 0.9rem;
    color: #bdc3c7; /* Gris más claro */
  }
  
  .footer-links ul {
    list-style: none;
    padding: 0;
    margin: 0;
    display: flex;
    gap: 15px;
  }
  
  .footer-links li {
    font-size: 0.9rem;
  }
  
  .footer-links a {
    text-decoration: none;
    color: #ecf0f1;
    transition: color 0.3s ease;
  }
  
  .footer-links a:hover {
    color: #3498db; /* Azul claro */
  }
  
  /* Estilos de redes sociales */
  .footer-socials a {
    color: #ecf0f1;
    font-size: 1.2rem;
    margin: 0 10px;
    transition: color 0.3s ease;
  }
  
  .footer-socials a:hover {
    color: #3498db; /* Azul claro */
  }
  
  /* Diseño adaptable */
  @media (min-width: 768px) {
    .footer-container {
      flex-direction: row;
      justify-content: space-between;
      max-width: 1200px;
      margin: 0 auto;
    }
  }
  </style>
  