<template>
  <footer class="footer">
    <div class="footer-container">
      <!-- Sección de enlaces y contacto en columnas -->
      <div class="footer-content">
        <!-- Sección de enlaces -->
        <div class="footer-links">
          <h4>Enlaces</h4>
          <ul>
            <li><a href="#">Sobre Nosotros</a></li>
            <li><a href="#">Política de Privacidad</a></li>
            <li><a href="#">Términos y Condiciones</a></li>
          </ul>
        </div>

        <!-- Sección de contacto -->
        <div class="footer-contact">
          <h4>Contacto</h4>
          <ul>
            <li><strong>Kenneth Lopez</strong> - juan@airpollution.com</li>
            <li><strong>Daira Arce</strong> - ana@airpollution.com</li>
            <li><strong>Valdir Flores</strong> - carlos@airpollution.com</li>
            <li><strong>Brian Zapana</strong> - laura@airpollution.com</li>
            <li><strong>Fabricio Condarco</strong> - pedro@airpollution.com</li>
          </ul>
        </div>
      </div>

      <!-- Sección de derechos reservados -->
      <div class="footer-info">
        <h3>Air Pollution</h3>
        <p>&copy; 2024 Todos los derechos reservados.</p>
      </div>

      <!-- Sección de redes sociales -->
      <div class="footer-socials">
        <a href="#" aria-label="Facebook" class="social-icon">
          <i class="fab fa-facebook"></i>
        </a>
        <a href="#" aria-label="Twitter" class="social-icon">
          <i class="fab fa-twitter"></i>
        </a>
        <a href="#" aria-label="Instagram" class="social-icon">
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
  background: linear-gradient(135deg, #2c3e50, #34495e); /* Fondo con degradado */
  color: #ecf0f1;
  padding: 40px 20px;
  text-align: center;
  font-family: 'Arial', sans-serif;
  position: relative;
  overflow: hidden;
}

/* Animaciones de ondas */
.footer::before,
.footer::after {
  content: "";
  position: absolute;
  width: 200%;
  height: 100px;
  background: rgba(255, 255, 255, 0.1);
  animation: wave 6s infinite linear;
  transform: rotate(0deg);
}

.footer::before {
  top: -40px;
  left: -100%;
}

.footer::after {
  top: -20px;
  left: -50%;
  animation-delay: 3s;
}

@keyframes wave {
  from {
    transform: translateX(0%);
  }
  to {
    transform: translateX(-50%);
  }
}

.footer-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  gap: 40px;
}

.footer-content {
  display: flex;
  flex-direction: column;
  gap: 20px;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  width: 100%;
}

.footer-links,
.footer-contact {
  max-width: 350px;
}

.footer-links h4,
.footer-contact h4 {
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 15px;
  color: #ffffff;
  text-transform: uppercase;
}

.footer-links ul,
.footer-contact ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.footer-links li,
.footer-contact li {
  margin: 8px 0;
  font-size: 1rem;
  transition: transform 0.3s ease;
}

.footer-links li:hover,
.footer-contact li:hover {
  transform: scale(1.1);
}

.footer-links a {
  text-decoration: none;
  color: #ecf0f1;
  transition: color 0.3s ease;
}

.footer-links a:hover {
  color: #1abc9c; /* Verde brillante */
}

.footer-info h3 {
  margin: 0;
  font-size: 2rem;
  color: #ecf0f1;
  animation: fadeIn 2s ease;
}

.footer-info p {
  margin: -100px 0 0;
  font-size: 1rem;
  color: #bdc3c7;
  animation: fadeIn 3s ease;
}

/* Animación de redes sociales */
.footer-socials a {
  color: #ecf0f1;
  font-size: 2rem;
  margin: 0 15px;
  transition: transform 0.3s ease, color 0.3s ease;
}

.footer-socials a:hover {
  transform: scale(1.2);
  color: #e74c3c; /* Rojo vibrante */
}

/* Efectos al entrar */
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(20px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

@media (min-width: 768px) {
  .footer-content {
    flex-direction: row;
    justify-content: space-between;
  }

  .footer-links,
  .footer-contact {
    width: 45%;
  }

  .footer-socials {
    margin-top: 10px;
  }
}
</style>
