<template>
  <footer class="footer">
    <div class="footer-container">
      <div class="footer-info">
        <h3>Mi Sitio</h3>
        <p>&copy; 2024 Todos los derechos reservados.</p>
      </div>

      <div class="footer-links">
        <ul>
          <li><a href="#">Sobre Nosotros</a></li>
          <li><a href="#">Política de Privacidad</a></li>
          <li><a href="#">Términos y Condiciones</a></li>
        </ul>
      </div>

      <div class="footer-contacts">
        <h4>Contactos del Equipo</h4>
        <div class="contacts-list">
          <div class="contact-item" v-for="contact in contacts" :key="contact.name">
            <h5>{{ contact.name }}</h5>
            <p><strong>Correo:</strong> <a :href="'mailto:' + contact.email">{{ contact.email }}</a></p>
            <p><strong>Teléfono:</strong> {{ contact.phone }}</p>
          </div>
        </div>
      </div>

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
  data() {
    return {
      contacts: [
        {
          name: "Daira Arce Quisbert",
          email: "dairaarcequisbert@ucb.edu.bo",
          phone: "+591 69765793",
        },
        {
          name: "Kenneth Lopez Castillo",
          email: "kennethlopezcastillo@ucb.edu.bo",
          phone: "+591 67309992",
        },
        {
          name: "Zapana Pariguana Brian",
          email: "zapanapariguanabrian@ucb.edu.bo",
          phone: "+591 75232880",
        },
        {
          name: "Condarco Poma Fabrisio",
          email: "condarcopomafabrisio@ucb.edu.bo",
          phone: "+591 70692270",
        },
        {
          name: "Flores Moya Valdir",
          email: "floresmoyavaldir@ucb.edu.bo",
          phone: "+591 71228229",
        },
      ],
    };
  },
};
</script>

<style scoped>
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

.footer-contacts {
  text-align: center;
  font-size: 1rem;
  width: 100%;
}

.footer-contacts h4 {
  margin-bottom: 15px;
}

.contacts-list {
  display: flex;
  flex-direction: column;
  gap: 15px;
  align-items: center;
  width: 100%;
}

.contact-item {
  background-color: #34495e; /* Azul oscuro */
  padding: 15px;
  border-radius: 8px;
  text-align: left;
  width: 100%;
  max-width: 400px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  color: #ecf0f1;
}

.contact-item h5 {
  margin: 0 0 10px;
  font-size: 1.1rem;
}

.contact-item a {
  color: #3498db; /* Azul claro */
  text-decoration: none;
  transition: color 0.3s ease;
}

.contact-item a:hover {
  color: #2980b9; /* Azul más oscuro */
}

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

  .contacts-list {
    flex-direction: row;
    flex-wrap: wrap;
    justify-content: center;
  }

  .contact-item {
    margin: 0 10px;
  }
}
</style>
