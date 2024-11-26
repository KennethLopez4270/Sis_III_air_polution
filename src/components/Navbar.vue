<template>
  <nav class="navbar">
    <div class="container">
      <!-- Logo -->
      <div class="logo">
        <span>🌐</span> AirPollution
      </div>

      <!-- Links de navegación -->
      <ul class="nav-links">
        <li><router-link to="/">Inicio</router-link></li>

        <!-- Ciencia de Datos: visible solo si está autenticado -->
        <li v-if="isAuthenticated">
          <router-link to="/ciencia-datos">Ciencia de Datos</router-link>
        </li>

        <!-- Links dinámicos según autenticación -->
        <li v-if="isAuthenticated" class="dropdown">
          <span>Bienvenido, {{ userName }}</span>
          <ul class="submenu">
            <li v-if="userRole === 'Admin'"><router-link to="/admin">Administrar</router-link></li>
            <li><router-link to="/" @click.native="logout">Cerrar sesión</router-link></li>
          </ul>
        </li>

        <!-- Si no está autenticado -->
        <li v-else>
          <router-link to="/auth/login">Iniciar Sesión</router-link>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  data() {
    return {
      userRole: localStorage.getItem("userRole") || null,
      userName: localStorage.getItem("userName") || "Usuario",
    };
  },
  computed: {
    isAuthenticated() {
      return !!localStorage.getItem("authToken");
    },
  },
  methods: {
    logout() {
      // Limpiamos los datos de sesión
      localStorage.removeItem("authToken");
      localStorage.removeItem("userRole");
      localStorage.removeItem("userName");
      localStorage.removeItem("user");

      // Redirigimos al inicio
      this.$router.push("/admin"); // Nos aseguramos de que la redirección es correcta
      window.location.reload(); // Recargamos la página para evitar problemas con el estado de la aplicación
    },
  },
};
</script>

<style scoped>
/* Estilos generales del navbar */
.navbar {
  background-color: #34495e;
  color: white;
  padding: 15px 20px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  position: sticky;
  top: 0;
  z-index: 1000;
}

.container {
  display: flex;
  justify-content: space-between;
  align-items: center;
  max-width: 1200px;
  margin: 0 auto;
}

/* Logo */
.logo {
  font-size: 1.8rem;
  font-weight: bold;
  color: #ecf0f1;
  display: flex;
  align-items: center;
  gap: 10px;
}

.logo span {
  font-size: 2rem;
}

/* Enlaces de navegación */
.nav-links {
  list-style: none;
  display: flex;
  gap: 30px;
  margin: 0;
  padding: 0;
}

.nav-links li {
  position: relative;
}

.nav-links a {
  text-decoration: none;
  color: #ecf0f1;
  padding: 8px 15px;
  border-radius: 5px;
  transition: all 0.3s ease;
}

.nav-links a:hover {
  background-color: #1abc9c;
  color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

/* Dropdown (Menú desplegable) */
.dropdown {
  position: relative;
}

.dropdown span {
  cursor: pointer;
  padding: 8px 15px;
  border-radius: 5px;
  transition: background-color 0.3s ease;
}

.dropdown:hover span {
  background-color: #1abc9c;
}

.submenu {
  display: none;
  position: absolute;
  top: 100%; /* Mejor alineación con el texto */
  left: 0;
  background-color: white;
  color: #2c3e50;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
  border-radius: 5px;
  list-style: none;
  padding: 10px 0;
  z-index: 1000;
  min-width: 200px;
}

.dropdown:hover .submenu {
  display: block;
}

.submenu:hover {
  display: block; /* Evita que desaparezca al mover el ratón */
}

.submenu li {
  padding: 10px 20px;
  transition: background-color 0.3s ease;
}

.submenu li:hover {
  background-color: #ecf0f1;
}

.submenu a {
  text-decoration: none;
  color: #34495e;
  font-weight: bold;
  transition: color 0.3s ease;
}

.submenu a:hover {
  color: #000000;
}

/* Responsividad */
@media (max-width: 768px) {
  .nav-links {
    flex-direction: column;
    gap: 15px;
  }
}
</style>
